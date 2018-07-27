package com.jacobduchen.spring.dao;

import java.util.List;

import com.jacobduchen.model.Blog;

public interface BlogDao {
	
	public Blog getBlog(int id);

	public List<Blog> getAllBlogs();

	public int addBlog(Blog blog);

	public int updateBlog(Blog blog);

	public int deleteBlog(int id);

}
