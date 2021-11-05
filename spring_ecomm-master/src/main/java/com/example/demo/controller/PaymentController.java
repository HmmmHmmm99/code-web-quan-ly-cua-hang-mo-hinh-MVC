package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.example.demo.configurations.PaypalPaymentIntent;
import com.example.demo.configurations.PaypalPaymentMethod;
import com.example.demo.entity.CartItem;
import com.example.demo.service.paypal.PaypalService;
import com.example.demo.utils.Utils;


@Controller
public class PaymentController {
	public static final String URL_PAYPAL_SUCCESS = "pay/success";
	public static final String URL_PAYPAL_CANCEL = "pay/cancel";
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaypalService paypalService;
	
	@PostMapping("/pay")
	public String pay(HttpServletRequest request,@RequestParam("price") double price ){
		String cancelUrl = Utils.getBaseURL(request) +"/"+ URL_PAYPAL_CANCEL;
		String successUrl = Utils.getBaseURL(request) +"/"+ URL_PAYPAL_SUCCESS;
		try {
			Payment payment = paypalService.createPayment(
					price, 
					"USD", 
					PaypalPaymentMethod.paypal, 
					PaypalPaymentIntent.sale,
					"payment description", 
					cancelUrl, 
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/order";
	}
	
	@GetMapping(URL_PAYPAL_CANCEL)
	public String cancelPay(){
		return "home.order";
	}
	
	@GetMapping(URL_PAYPAL_SUCCESS)
	public String successPay(HttpSession httpSession, ModelMap model, @RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		int paypal = 1;
		
		float total =0;
		int qty = 0;
		List<CartItem> ls = (List<CartItem>) httpSession.getAttribute("cart");
		model.addAttribute("cartProduct",ls);
		for(CartItem i:ls) {
			total += i.getQuantity()*i.getItem().getPrice();
			qty +=i.getQuantity();
		}
		model.addAttribute("qty", qty);
		model.addAttribute("total", total);
		model.addAttribute("paypal", paypal);
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "home.order";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/order";
	}
}
