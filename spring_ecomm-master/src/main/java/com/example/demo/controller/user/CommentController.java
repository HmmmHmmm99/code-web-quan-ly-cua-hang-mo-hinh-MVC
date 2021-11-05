package com.example.demo.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.Comment;
import com.example.demo.service.comment.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/add-comment", method = RequestMethod.POST)
	public String addComment(@ModelAttribute("comment")Comment com, HttpSession session		) {
		
		if(session.getAttribute("username")==null || session.getAttribute("username")=="" ) { 
			return "redirect:/cart"; 
		}
		
		System.out.println(com.toString());
		commentService.save(com);
		System.out.println("add comment success");
		System.out.println(com.getItem().getId());
		return "redirect:/detail/"+com.getItem().getId();
	}
}
