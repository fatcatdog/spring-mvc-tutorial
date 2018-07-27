package com.jacobduchen.model;

public class Blog {
	
	private int id;
	private int authorId;
	private String title;
	private String body;
	
	public Blog() {
		
	}

	public Blog(int id, int authorId, String title, String body) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.title = title;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}