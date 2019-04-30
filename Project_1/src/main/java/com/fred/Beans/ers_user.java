package com.fred.Beans;

public class ers_user {
		private Integer ers_users_id;
		private String ers_username;
		private String ers_password;
		private String user_fname;
		private String user_lname;
		private String user_email;
		private Integer user_role_id;
		
		
		
		public ers_user() {
			super();
		}



		public ers_user(Integer ers_users_id, String ers_username, String ers_password, String user_fname,
				String user_lname, String user_email, Integer user_role_id) {
			super();
			this.ers_users_id = ers_users_id;
			this.ers_username = ers_username;
			this.ers_password = ers_password;
			this.user_fname = user_fname;
			this.user_lname = user_lname;
			this.user_email = user_email;
			this.user_role_id = user_role_id;
		}



		public ers_user(String ers_username, String ers_password, String user_fname, String user_lname,
				String user_email, Integer user_role_id) {
			super();
			this.ers_username = ers_username;
			this.ers_password = ers_password;
			this.user_fname = user_fname;
			this.user_lname = user_lname;
			this.user_email = user_email;
			this.user_role_id = user_role_id;
		}



		public Integer getErs_users_id() {
			return ers_users_id;
		}



		public void setErs_users_id(Integer ers_users_id) {
			this.ers_users_id = ers_users_id;
		}



		public String getErs_username() {
			return ers_username;
		}



		public void setErs_username(String ers_username) {
			this.ers_username = ers_username;
		}



		public String getErs_password() {
			return ers_password;
		}



		public void setErs_password(String ers_password) {
			this.ers_password = ers_password;
		}



		public String getUser_fname() {
			return user_fname;
		}



		public void setUser_fname(String user_fname) {
			this.user_fname = user_fname;
		}



		public String getUser_lname() {
			return user_lname;
		}



		public void setUser_lname(String user_lname) {
			this.user_lname = user_lname;
		}



		public String getUser_email() {
			return user_email;
		}



		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}



		public Integer getUser_role_id() {
			return user_role_id;
		}



		public void setUser_role_id(Integer user_role_id) {
			this.user_role_id = user_role_id;
		}



		@Override
		public String toString() {
			return "ers_user [ers_users_id=" + ers_users_id + ", ers_username=" + ers_username + ", ers_password="
					+ ers_password + ", user_fname=" + user_fname + ", user_lname=" + user_lname + ", user_email="
					+ user_email + ", user_role_id=" + user_role_id + "]";
		}



}
