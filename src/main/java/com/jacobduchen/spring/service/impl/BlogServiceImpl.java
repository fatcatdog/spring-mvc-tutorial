package com.jacobduchen.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jacobduchen.model.Blog;
import com.jacobduchen.spring.dao.BlogDao;
import com.jacobduchen.spring.service.BlogService;

public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	

	public Blog getBlog(int id) {
		return blogDao.getBlog(id);
	}

	 
	public List<Blog> getAllBlogs() {
		return blogDao.getAllBlogs(); 
	}

	@Override
	public int addBlog(Blog blog) {
		return blogDao.addBlog(blog);
	}

	@Override
	public int updateBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

	@Override
	public int deleteBlog(int id) {
		return blogDao.deleteBlog(id);
	}
	
	public BlogDao getBlogDao() {
		return blogDao;
	}

}
