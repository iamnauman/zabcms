package com.model;

import com.mysql.jdbc.Blob;;
public class Documentsdto {
private int documentsid;
private String documentname;
private String coursenumber;
private Blob documentsmaterial;

public Blob getDocumentsmaterial() {
	return documentsmaterial;
}
public void setDocumentsmaterial(Blob documentsmaterial) {
	this.documentsmaterial = documentsmaterial;
}
public String getCoursenumber() {
	return coursenumber;
}
public void setCoursenumber(String coursenumber) {
	this.coursenumber = coursenumber;
}
public int getDocumentsid() {
	return documentsid;
}
public void setDocumentsid(int documentsid) {
	this.documentsid = documentsid;
}
public String getDocumentname() {
	return documentname;
}
public void setDocumentname(String documentname) {
	this.documentname = documentname;
}
public void setDocumentsmaterial(java.sql.Blob blob) {
	// TODO Auto-generated method stub
	
}
}
