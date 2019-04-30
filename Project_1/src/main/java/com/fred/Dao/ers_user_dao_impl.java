package com.fred.Dao;

import static com.fred.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fred.Beans.ers_user;
import com.fred.util.ConnectionUtil;

public class ers_user_dao_impl {

	@Override
	public Boolean inserters_user(ers_user u) {
		PreparedStatement stmt = null;
		/*
		 * Try-With-Resources
		 * -Any object made with a try with resources block will be
		 * closed automatically for you in the event of a crash, or
		 * successful execution. So you are not required to 
		 * worry about invoking the " .close()" on any objects
		 * created with the try block
		 * -NOTE: requires the object to implement "AutoCloseable"
		 */
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO ers_users VALUES(?,?,?,?,?,?)"); 
			//				QUESTION MARL INDEX:					   1 2 3 4 5 6
			// this is where
			// you would write a line of SQL, but in Java
			stmt.setInt(1, u.getErs_users_id());
			stmt.setString(2, u.getErs_username());
			stmt.setString(3, u.getErs_password());
			stmt.setString(4, u.getUser_fname());
			stmt.setString(5, u.getUser_lname());
			stmt.setString(6, u.getUser_email());
			stmt.setInt(7, u.getUser_role_id());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;
	}

	@Override
	public ers_user selecters_userById(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;
		ers_user ers_userss = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); 
			rs= stmt.executeQuery("SELECT * FROM ers_users WHERE ers_user_id ="+id);
			if(rs.next()) {
				ers_userss = new ers_user(
						rs.getInt("ers_users_id"), 
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_fname"),
						rs.getString("user_lname"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return custa;
	}

	@Override
	public List<ers_user> selectAllers_users() {
		Statement stmt = null;
		ResultSet rs = null;
		List<ers_user> ers_userss = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); // create a statement
			//object from the connection
			//statement objects can exectue sql queries connected
			//to DB
			
			rs = stmt.executeQuery("SELECT * FROM ers_users");
			/*
			 * ResultSet stores all the records from the successful
			 * query
			 */
			while(rs.next()) {
				ers_userss.add(new ers_user(
						rs.getInt("ers_user_id"), // grab data by name
						rs.getString("ers_user_username"), // or we can grab by index
						rs.getString("ers_user_password"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getString("email"),
						rs.getInt("user_role_id")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return custas;
	}

	@Override
	public Boolean updateers_userById(Integer id) {
		return null;
	}

	@Override
	public Boolean deleteers_userById(Integer id) {
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("DELETE FROM ers_users WHERE ers_users_id = ?"); 
			stmt.setInt(1, id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;
	}
	
	
}
