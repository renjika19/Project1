package com.fred.Services;

import java.util.List;

import com.fred.Beans.ers_user;
import com.fred.Dao.ers_user_dao;
import com.fred.Dao.ers_user_dao_impl;




public class ers_user_service {
	
	private ers_user_dao ud = null;

	public boolean confirmLogin(String ers_username, String ers_password) {
		ers_user_dao_impl ud = new ers_user_dao_impl();
		ers_user usr = null;
		System.out.println(ers_username);
		System.out.println(ers_password);
		if((usr=ud.selecters_userByUsername(ers_username.toLowerCase()))!=null){
			System.out.println(ers_username);
			if(usr.getErs_password().equals(ers_password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean ers_usernameExists(String ers_username) {
		if(new ers_user_dao_impl().selecters_userByUsername(ers_username)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean registerers_user(String ers_username, String ers_password, String user_fname, String user_lname,
			String user_email, Integer user_role_id) {
		if(new ers_user_dao_impl().inserters_user(new ers_user(ers_username, ers_password,user_fname,user_lname,user_email,user_role_id))) {
			return true;
		}
		return false;
	}
	
	public List<ers_user> getAllers_users(){
		ud = new ers_user_dao_impl();
		return ud.selectAllers_users();
	}
	
	
	

}



