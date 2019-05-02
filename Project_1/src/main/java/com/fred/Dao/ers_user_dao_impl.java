package com.fred.Dao;

import static com.fred.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fred.Beans.ers_user;
import com.fred.util.ConnectionUtil;

public class ers_user_dao_impl implements ers_user_dao {
	
	private final static Logger logger = Logger.getLogger(ers_user_dao_impl.class);

	@Override
	public Boolean inserters_user(ers_user u) {
		PreparedStatement stmt = null;

		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO ers_users VALUES(?,?,?,?,?,?)"); 
//																	   1 2 3 4 5 6 7


			stmt.setString(1, u.getErs_username());
			stmt.setString(2, u.getErs_password());
			stmt.setString(3, u.getUser_fname());
			stmt.setString(4, u.getUser_lname());
			stmt.setString(5, u.getUser_email());
			stmt.setInt(6, u.getUser_role_id());
			stmt.execute();
			
			logger.info("New owner insert SUCCESS on user: " + u.getErs_username());
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			logger.error("New owner insert FAILED on user: " + u.getErs_username());
			
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
		return ers_userss;
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
						rs.getString("user_fname"),
						rs.getString("user_lname"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return ers_userss;
	}



	@Override
	public Boolean updateers_usersById(Integer id) {
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
	
	@Override
	public  ers_user selecters_userByUsername(String ers_username) {
		ers_user usr = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM ers_users WHERE LOWER (ers_username) = ?");
			ps.setString(1, ers_username);
			rs = ps.executeQuery();
			
			while(rs.next()){
				usr = new ers_user(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7)
						);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return usr;
	}

	@Override
	public boolean registerers_user(String ers_username, String ers_password, String user_fname, String user_lname,
			String user_email, Integer user_role_id) {
		// TODO Auto-generated method stub
		return false;
	}






	
	
}
