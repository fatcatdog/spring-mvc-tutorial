package com.jacobduchen.spring.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import com.jacobduchen.model.Blog;
import com.jacobduchen.model.mapper.BlogRowMapper;
import com.jacobduchen.spring.dao.BlogDao;

public class BlogDaoImpl implements BlogDao  {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public Blog getBlog(int id) {
		Blog blog = (Blog) jdbcTemplate.queryForObject("select * from blogs where id = ?",
		new Object[] { id }, new BlogRowMapper());
		return blog;
	}

	@Transactional
	public List<Blog> getAllBlogs() {
		List<Blog> listOfBlogs = (List<Blog>) jdbcTemplate.query("select * from blogs",
				new BlogRowMapper());
		return listOfBlogs;
	}

	@Transactional
	public int addBlog(Blog blog) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("blogs").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("blog_title", blog.getTitle());
		parameters.put("blog_content", blog.getBody());
		parameters.put("author_id", blog.getAuthorId());
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.intValue();
	}

	@Transactional
	public int updateBlog(Blog blog) {
		String sql = "update blogs set blog_title = ?, blog_content = ?, where id = ? AND author_id = ?";
		int resp = jdbcTemplate.update(sql, new Object[] { blog.getTitle(), blog.getBody(),
				blog.getAuthorId(), blog.getId() });
		return resp;
	}

	@Transactional
	public int deleteBlog(int id) {
		// TODO Auto-generated method stub
		int resp = jdbcTemplate.update("delete from blogs where id = ?", id);
		return resp;
	}

}
