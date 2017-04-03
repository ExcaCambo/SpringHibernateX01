package com.aeugold.model;

import java.util.ArrayList;

public class News {
	private int news_id;
	private String news_date;
	private String news_title;
	private String news_content;
	private Source news_source;
	private Image news_image;
	private ArrayList<Image> news_images;
	
	public int getNews_id() {
		return news_id;
	}
	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	public String getNews_date() {
		return news_date;
	}
	public void setNews_date(String news_date) {
		this.news_date = news_date;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public Source getNews_source() {
		return news_source;
	}
	public void setNews_source(Source news_source) {
		this.news_source = news_source;
	}
	public Image getNews_image() {
		return news_image;
	}
	public void setNews_image(Image news_image) {
		this.news_image = news_image;
	}
	public ArrayList<Image> getNews_images() {
		return news_images;
	}
	public void setNews_images(ArrayList<Image> news_images) {
		this.news_images = news_images;
	}
	
	
}
