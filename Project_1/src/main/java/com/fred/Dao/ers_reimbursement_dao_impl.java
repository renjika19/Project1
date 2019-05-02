package com.fred.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import static com.fred.util.CloseStreams.close;
import com.fred.Beans.ers_reimbursement;
import com.fred.util.ConnectionUtil;

public class ers_reimbursement_dao_impl implements ers_reimbursement_dao {

	@Override
	public Boolean add_a_request(ers_reimbursement addreq) {
		
		PreparedStatement stmt = null;
		

		
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO ers_reimbursement(reimb_id, reimb_amount, reimb_submitted, reimb_resolved, "
					+ "reimb_description, reimb_author, "
					+ "reimb_resolver, reimb_status_id, reimb_type_id) VALUES(?,?,?,?,?,?,?,?,?,?)");
//																						10
			
			stmt.setInt(1, addreq.getReimb_id());
			stmt.setDouble(2, addreq.getReimb_amount());
			stmt.setTimestamp(3, addreq.getReimb_submitted());
			stmt.setTimestamp(4, addreq.getReimb_resolved());
			stmt.setString(5, addreq.getReimb_description());
			stmt.setString(7, addreq.getReimb_author());
			stmt.setString(8, addreq.getReimb_resolver());
			stmt.setInt(9, addreq.getReimb_status_id());
			stmt.setInt(10, addreq.getReimb_type_id());
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;
		
	}

	@Override
	public List<ers_reimbursement> view_all_reimbursement_request(Integer reimb_id) {
			Statement stmt = null;
			ResultSet rs = null;
			List<ers_reimbursement> viewall = new ArrayList<>();
			try(Connection conn = ConnectionUtil.getConnection()){
				stmt = conn.createStatement(); // create a statement
				//object from the connection
				//statement objects can exectue sql queries connected
				//to DB
				
				rs = stmt.executeQuery("SELECT * FROM ers_reimbursement");
				/*
				 * ResultSet stores all the records from the successful
				 * query
				 */
				while(rs.next()) {
					viewall.add(new ers_reimbursement(
							rs.getInt("reimb_id"), // grab data by name
							rs.getDouble("reimb_amount"), // or we can grab by index
							rs.getTimestamp("reimb_submitted"),
							rs.getTimestamp("reimb_resolved"),
							rs.getString("reimb_description"),
							rs.getBlob("reimb_receipt"),
							rs.getString("reimb_author"),
							rs.getString("reimb_resolver"),
							rs.getInt("reimb_status_id"),
							rs.getInt("reimb_type_id")
							));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(stmt);
			}
			return viewall;
			}
	
	{
		

}
	@Override
	public List<ers_reimbursement> view_unsettled_reimbursements_request(Integer reimb_id, Double reimb_amount, Timestamp reimb_submitted, 
			String reimb_description, String reimb_author, Integer reimb_status_id, Integer reimb_type_id) {
			Statement stmt = null;
			ResultSet rs = null;
			List<ers_reimbursement> unset = new ArrayList<>();
			try(Connection conn = ConnectionUtil.getConnection()){
				stmt = conn.createStatement(); // create a statement
				//object from the connection
				//statement objects can exectue sql queries connected
				//to DB
				
				rs = stmt.executeQuery("SELECT FROM ers_reimbursement where reimb_status_id=0");
				/*
				 * ResultSet stores all the records from the successful
				 * query
				 */
				while(rs.next()) {
					unset.add(new ers_reimbursement(
							rs.getInt("reimb_id"),
							rs.getDouble("reimb_amount"),
							rs.getTimestamp("reimb_submitted"),
							rs.getString("reimb_description"),
							rs.getString("reimb_author"),
							rs.getInt("reimb_status_id"),
							rs.getInt("reimb_type_id")));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(stmt);
			}
			return unset;
			}

	{
	

}


	@Override
	public List<ers_reimbursement> view_resolved_reimbursements_request(Integer reimb_id, Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_desription, String reimb_resolver, Integer reimb_status_id, Integer reimb_type_id) {
			Statement stmt = null;
			ResultSet rs = null;
			List<ers_reimbursement> settled = new ArrayList<>();
			try(Connection conn = ConnectionUtil.getConnection()){
				stmt = conn.createStatement(); // create a statement
				//object from the connection
				//statement objects can exectue sql queries connected
				//to DB
				
				rs = stmt.executeQuery("SELECT  FROM ers_reimbursement where reimb_status_id=1");
				/*
				 * ResultSet stores all the records from the successful
				 * query
				 */
				while(rs.next()) {
					settled.add(new ers_reimbursement(
							rs.getInt("reimb_id"), 
							rs.getDouble("reimb_amount"),
							rs.getTimestamp("reimb_submitted"),
							rs.getTimestamp("reimb_resolved"),
							rs.getString("reimb_description"),
							rs.getString("reimb_resolver"),
							rs.getInt("reimb_status_id"),
							rs.getInt("reimb_type_id")
							));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(stmt);
			}
			return settled;
			}
	
		{
	
			
		
}
		
		
		@Override
		public Boolean update_request(Integer reimb_id, Timestamp reimb_resolved, String reimb_resolver, Integer reimb_status_id) {
			PreparedStatement stmt = null;
			

			
			
			try(Connection conn = ConnectionUtil.getConnection()) {
				stmt = conn.prepareStatement("UPDATE Messages SET reimb_amount, reimb_resolver, reimb_status_id");
				
				
				stmt.setInt(1, reimb_id);
				stmt.setTimestamp(2, reimb_resolved);
				stmt.setString(3, reimb_resolver);
				stmt.setInt(4,  reimb_status_id);
				
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}finally {
				close(stmt);
			}
			return true;


//		@Override
//		public List<ers_reimbursement> view_resolved_reimbursements_request(Integer reimb_id, Double reimb_amount,
//				Timestamp reimb_submitted, Timestamp reimb_resolved, String reimb_desription, Blob reimb_receipt,
//				String reimb_resolver, Integer reimb_status_id, Integer reimb_type_id) {
//			// TODO Auto-generated method stub
//			return null;
//		}
		
			

			}
 	
}
	



