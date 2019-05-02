package com.fred.Dao;
import java.util.List;

import com.fred.Beans.ers_user;
//import com.fred.Beans.ers_reimbursement;

public interface ers_user_dao {
	
	public Boolean inserters_user(ers_user u);
	public ers_user selecters_userById(Integer id);
	public List<ers_user> selectAllers_users();
	public Boolean updateers_usersById(Integer id);
	public ers_user selecters_userByUsername(String username);
	public boolean registerers_user(String ers_username, String ers_password, String user_fname, String user_lname,
			String user_email, Integer user_role_id);

}
