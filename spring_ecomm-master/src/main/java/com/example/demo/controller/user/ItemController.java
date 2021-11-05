package com.example.demo.controller.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Category;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Item;
import com.example.demo.service.account.AccountService;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.comment.CommentService;
import com.example.demo.service.product.ItemService;


@Controller
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	CommentService commentService;

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value={"details"} ,method = RequestMethod.GET)
	 public String index() { 
		 return "home.detail"; 
	 }
	
	 @RequestMapping(value={"detail/{id}"} ,method = RequestMethod.GET)
	 public String detail(@PathVariable("id") int id, ModelMap model, HttpSession session) { 
		 Item item = itemService.findById(id).get();
		 model.addAttribute("item", item);
		 Comment c = new Comment();
		 List<Comment> listComment = item.getComment();
		 model.addAttribute("listComment", listComment);
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 c.setUsername(""+session.getAttribute("username"));
		 c.setDate( df.format(new java.util.Date()) );
		 c.setItem(item);
		 
		 //category
		 List<Item> citem = new ArrayList<>();
		 List<Item> a = categoryService.findById(item.getCategory().getId()).get().getItems();
		 for(Item i:a) {
			 citem.add(i);
			 System.out.println(i.getTitle());
		 }	 
		 model.addAttribute("RItem", citem);
		 model.addAttribute("comment", c);
		//getcategory
		 List<Category> list =  categoryService.findAll();
		 model.addAttribute("Categories",list);
		 
		 return "home.detail"; 
	 }
	 
	 @RequestMapping(value={"category-products/{id}"} ,method = RequestMethod.GET)
	 public String ProductByCategory(@PathVariable("id") int id, ModelMap model) { 
		 List<Item> citem = new ArrayList<>();
		 List<Item> a = categoryService.findById(id).get().getItems();
		 for(Item i:a) {
			 citem.add(i);
			 System.out.println(i.getTitle());
		 }

		 model.addAttribute("CItem", citem);
		 
		 //getcategory
		 List<Category> list =  categoryService.findAll();
		 model.addAttribute("Categories",list);
		 
		 return "home.categoryproduct"; 
	 }
	 
}
