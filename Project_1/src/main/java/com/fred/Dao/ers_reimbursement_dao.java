package com.fred.Dao;


import java.sql.Timestamp;

import java.util.List;

import com.fred.Beans.ers_reimbursement;


public interface ers_reimbursement_dao {
	
	public List<ers_reimbursement> view_all_reimbursement_request(Integer reimb_id);
	
	public List<ers_reimbursement> view_unsettled_reimbursements_request(Integer reimb_id, Double reimb_amount, Timestamp reimb_submitted, 
			String reimb_description, String reimb_author, Integer reimb_status_id, Integer reimb_type_id);
	
	public List<ers_reimbursement> view_resolved_reimbursements_request(Integer reimb_id, Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_desription, String reimb_resolver, Integer reimb_status_id, Integer reimb_type_id);
	
	
	
	public Boolean add_a_request(ers_reimbursement addreq);
	
	
	public Boolean update_request(Integer reimb_id, Timestamp reimb_resolved, String reimb_resolver, Integer reimb_status_id);

	
		
}
