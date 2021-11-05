package com.example.demo.controller.admin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemSale;
import com.example.demo.service.amazonService.AmazonService;
import com.example.demo.service.category.CategoryService;
//
import com.example.demo.service.product.ItemService;
import com.example.demo.service.productsale.ItemSaleService;
@Controller
public class SaleController {
	
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemSaleService itemSaleService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	private AmazonService amazonService;
	
	@PostMapping("/admin/upload")
	public String fileUpload(@RequestPart(value="file") MultipartFile multipartFile, @ModelAttribute("itemSale")ItemSale itemSale) {
		amazonService.uploadFile(multipartFile, itemSale);
		return "redirect:/admin/sale-products";
	}
	
	@RequestMapping("/admin/sale-products")
	public String listSales(ModelMap model, HttpSession session) {
		if(session.getAttribute("admin")==null || session.getAttribute("admin")=="") {
			return "redirect:/admin/login";
		}
		List<Item> items = itemService.findAll();
		model.addAttribute("Items",items);	
		
		List<ItemSale> itemSales = itemSaleService.findAll();
		model.addAttribute("itemSales", itemSales);
		
		/*
		 * Item i = new Item(); model.addAttribute("item", i);
		 * model.addAttribute("categories",categoryService.findAll())
		 */;
		
		ItemSale isale = new ItemSale();
		model.addAttribute("itemSale", isale);
		return "admin.dashboard.sale";
	}
//	@RequestMapping(value="/add-sale", method = RequestMethod.POST)
//	public String addProductSale(
//			@ModelAttribute("item")Item item, 
//			HttpSession session,
//			@RequestParam(value="file") MultipartFile file
//		) {
//		if(session.getAttribute("admin")==null || session.getAttribute("admin")=="" ) {
//			return "redirect:/admin/login";
//		}
//		
//		item.setPath(uploadFile(file));
//		System.out.println(item.toString()+"\n---");
//		itemService.save(item);
//		System.out.println("saved item success");
//		return "redirect:/admin/products";
//	}
}
