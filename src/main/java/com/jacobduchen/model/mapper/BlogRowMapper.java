package com.jacobduchen.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jacobduchen.model.Blog;

public class BlogRowMapper implements RowMapper<Blog> {

	public Blog mapRow(ResultSet rs, int row) throws SQLException {
		Blog tempBlog = new Blog();
		tempBlog.setId(rs.getInt("id"));
		tempBlog.setAuthorId(rs.getInt("author_id"));
		tempBlog.setTitle(rs.getString("blog_title"));
		tempBlog.setBody(rs.getString("blog_content"));
		return tempBlog;
	}

}