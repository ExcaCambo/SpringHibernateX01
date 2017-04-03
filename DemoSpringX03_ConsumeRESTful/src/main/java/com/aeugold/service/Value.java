package com.aeugold.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Value {
	private int id;
	private String quote;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQoate() {
		return quote;
	}
	public void setQoate(String qoate) {
		this.quote = qoate;
	}
	public String ToString(){
		return "Value{"
				+ "id=" + id
				+ "Quote=" + quote 
				+ "};";
	}
	
}
