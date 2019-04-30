package com.fred.Dao;
import java.util.List;

import com.fred.Beans.ers_user;

public interface ers_user_dao {
	
	public Boolean inserters_user(ers_user u);
	public ers_user selecters_userById(Integer id);
	public List<ers_user> selectAllers_users();
	public Boolean updateers_usersById(Integer id);
	public Boolean deleteers_usersById(Integer id);

}
