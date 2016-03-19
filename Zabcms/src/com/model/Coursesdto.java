package com.model;

public class Coursesdto {

	private String coursenumber;
	private String coursename;
	private String documentsid;
	private String departmentid;;

	public Coursesdto() {

	}

	public Coursesdto(final String coursenumber, final String coursename,
			final String documentsid, final String departmentid) {
		this.coursenumber = coursenumber;
		this.coursename = coursename;
		this.documentsid = documentsid;
		this.departmentid = departmentid;

	}

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(final String departmentid) {
		this.departmentid = departmentid;
	}

	public String getCoursenumber() {
		return coursenumber;
	}

	public void setCoursenumber(final String coursenumber) {
		this.coursenumber = coursenumber;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(final String coursename) {
		this.coursename = coursename;
	}

	public String getDocumentsid() {
		return documentsid;
	}

	public void setDocumentsid(final String documentsid) {
		this.documentsid = documentsid;
	}
}
