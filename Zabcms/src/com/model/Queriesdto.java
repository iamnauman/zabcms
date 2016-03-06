package com.model;
import java.util.Date;
public class Queriesdto {
	

	
	private int queriesid;
	private String text;
	private Date date;
	
	public int getQueriesid() {
	    return queriesid;
	}
	public void setQueriesid(int id) {
	    this.queriesid = id;
	}
	public String getText() {
	    return text;
	}
	public void setText(String text) {
	    this.text = text;
	}

	
	public Date getDate() {
	    return date;
	}
	public void setDate(Date date) {
	    this.date = date;
	}
	
}
