package com.example.demo.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Account;
import com.example.demo.service.account.AccountService;


@Controller
public class RegisterController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/register")
	public String index(ModelMap model, HttpSession session) {
		if(session.getAttribute("username")!=null) {
			return "redirect:/";
		}
		Account account = new Account();
		model.addAttribute("account", account);
		return "home.register"; 
	}
 
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("account")Account acc, HttpSession session ) {
		if(session.getAttribute("cart")==null ) {
			System.out.println("saved "+acc.getUsername());
			accountService.save(acc);
			return "redirect:/cart";
		}
		
		return "redirect:/register";
		
	}
}
