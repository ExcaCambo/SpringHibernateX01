package com.aeugold.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Quote {
	private String type;
	private Value value;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Value getVaue() {
		return value;
	}
	public void setVaue(Value vaue) {
		this.value = vaue;
	}
	
	public String ToString() {
		return "Quote{"
				+ "Type=" + type
				+ "Value=" + value
				+ "};";
	}
	
}
