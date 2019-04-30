package com.fred.Services;

import java.util.List;

import com.fred.Beans.ers_user;
import com.fred.Dao.ers_user_dao_impl;


public class ers_userService {
	private ers_user_dao_impl ud = null;
	
	public Boolean addNewers_user(ers_user u) {
		ud = new ers_user_dao_impl();
		return ud.inserters_user(u);
	}

	public List<ers_user> getAllers_users(){
		ud = new ers_user_dao_impl();
		return ud.selectAllers_users();
	}
	
	public ers_user geters_usersById(Integer id){
		ud = new ers_user_dao_impl();
		return ud.selecters_userById(id);
	}
	
	public Boolean deleteCustomerById(Integer id){
		ud = new ers_user_dao_impl();
		return ud.deleteers_userById(id);
	}
}
