package com.model;

public class Userdto {
	
			private String username;
			private String fullname;
	        private int id;
	        private String password;
	        private String email;
	        private String createDate;
			public Userdto() {
			
			}
			public Userdto(String username, String password){
				this.username=username;
				
				this.password=password;
				
			}
			public String getFull_name() {
				return fullname;
			}
			public void setFull_name(String full_name) {
				this.fullname = full_name;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getCreateDate() {
				return createDate;
			}
			public void setCreateDate(String createDate) {
				this.createDate = createDate;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
				
			
	}


