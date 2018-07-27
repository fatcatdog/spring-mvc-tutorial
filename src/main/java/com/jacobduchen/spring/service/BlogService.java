package com.jacobduchen.spring.service;

import java.util.List;

import com.jacobduchen.model.Blog;

public interface BlogService {

	public Blog getBlog(int id);

	public List<Blog> getAllBlogs();

	public int addBlog(Blog blog);

	public int updateBlog(Blog blog);

	public int deleteBlog(int id);
	
}
