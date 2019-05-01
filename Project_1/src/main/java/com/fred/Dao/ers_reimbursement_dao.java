package com.fred.Dao;

import java.util.List;

import com.fred.Beans.ers_reimbursement;


public interface ers_reimbursement_dao {
	
	public List<ers_reimbursement> view_all_reimbursement_request(Integer reimb_id);
	public List<ers_reimbursement> view_unsettled_reimbursements_request(Integer reimb_id);
	public List<ers_reimbursement> view_resolved_reimbursements_request(Integer reimb_id);
	public Boolean add_a_request(ers_reimbursement addreq);
	public Boolean approve_request(ers_reimbursement addreq);
	public Boolean deny_request(ers_reimbursement denyreq);
	
		
}
