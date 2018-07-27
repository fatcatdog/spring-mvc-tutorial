package com.jacobduchen.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacobduchen.model.Blog;
import com.jacobduchen.spring.service.BlogService;

@Controller
@RequestMapping("/")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "blogs/{id}", method = RequestMethod.GET)
	public String getBlog(@PathVariable int id, ModelMap blogModel) {
		blogModel.addAttribute("blog", blogService.getBlog(id));
		return "blog";
	}
	
	@RequestMapping(value = "blogs", method = RequestMethod.GET)
	public String getBlogs(ModelMap blogModel) {
		blogModel.addAttribute("blog", blogService.getAllBlogs());
		return "blogs";
	}
	
	@RequestMapping(value = "addBlog")
	public String addPage() {
		return "add";
	}
	
	@RequestMapping(value = "add/blog", method = RequestMethod.POST)
	public String addBlog(@RequestParam(value = "authorId", required = true) int authorId,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "body", required = true) String body, ModelMap blogModel) {
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setAuthorId(authorId);
		blog.setBody(body);

		int resp = blogService.addBlog(blog);
		if (resp > 0) {
			blogModel.addAttribute("msg", "User with id : " + resp + " added successfully.");
			blogModel.addAttribute("userDetails", blogService.getAllBlogs());
			return "blogs";
		} else {
			blogModel.addAttribute("msg", "Blog addition failed.");
			return "add";
		}
	}
	
	@RequestMapping(value = "delete/blog/{id}", method = RequestMethod.GET)
	public String deleteBlog(@PathVariable("id") int id, ModelMap blogModel) {
		int resp = blogService.deleteBlog(id);
		blogModel.addAttribute("userDetails", blogService.getAllBlogs());
		if (resp > 0) {
			blogModel.addAttribute("msg", "Blog with id : " + id + " deleted successfully.");
		} else {
			blogModel.addAttribute("msg", "Blog with id : " + id + " deletion failed.");
		}
		return "blogs";
	}
	
	@RequestMapping(value = "update/blog/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap blogModel) {
		blogModel.addAttribute("id", id);
		blogModel.addAttribute("userDetails", blogService.getBlog(id));
		return "update";
	}
	
	@RequestMapping(value = "update/blog", method = RequestMethod.POST)
	public String updateBlog(@RequestParam int id, @RequestParam(value = "authorId", required = true) int authorId,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "body", required = true) String body, ModelMap blogModel) {
		Blog blog = new Blog();
		blog.setId(id);
		blog.setTitle(title);
		blog.setBody(body);
		blog.setAuthorId(authorId);
		int resp = blogService.updateBlog(blog);
		blogModel.addAttribute("id", id);
		if (resp > 0) {
			blogModel.addAttribute("msg", "Blog with id : " + id + " updated successfully.");
			blogModel.addAttribute("userDetails", blogService.getAllBlogs());
			return "users";
		} else {
			blogModel.addAttribute("msg", "Blog with id : " + id + " updation failed.");
			blogModel.addAttribute("blog", blogService.getBlog(id));
			return "update";
		}
	}
	
}
