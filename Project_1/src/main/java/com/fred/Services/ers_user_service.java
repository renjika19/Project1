package com.fred.Services;

import java.util.List;

import com.fred.Beans.ers_user;
import com.fred.Dao.ers_user_dao;
import com.fred.Dao.ers_user_dao_impl;




public class ers_user_service {
	
	private ers_user_dao ud = null;

	public boolean confirmLogin(String username, String password) {
		ers_user_dao_impl ud = new ers_user_dao_impl();
		ers_user usr = null;
		
		if((usr=ud.selecters_userByUsername(username.toLowerCase()))!=null){
			if(usr.getErs_password().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean ers_usernameExists(String username) {
		if(new ers_user_dao_impl().selecters_userByUsername(username)!=null) {
			return true;
		}
		return false;
	}
	
	public boolean registerers_user(String username, String password, 
			String name) {
		if(new ers_user_dao_impl().inserters_user(new ers_user(null, name,null,username,password,null))) {
			return true;
		}
		return false;
	}
	
	public List<ers_user> getAllers_users(){
		ud = new ers_user_dao_impl();
		return ud.selectAllers_users();
	}
	
	
	

}



