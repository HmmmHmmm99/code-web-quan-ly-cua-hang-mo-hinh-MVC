package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Category;
import com.example.demo.entity.ItemSale;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.productsale.ItemSaleService;

@Controller
public class OrferController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemSaleService itemSaleService;
	
	@RequestMapping(value={"/hot-item"})
	public String getAllSale(ModelMap model) {  
		//getcategory
		List<Category> list =  categoryService.findAll();
		model.addAttribute("Categories",list);
		List<ItemSale> itemSales = itemSaleService.findAll();
		model.addAttribute("itemSales", itemSales);
		 return "home.hotitem"; 
	 }
}
