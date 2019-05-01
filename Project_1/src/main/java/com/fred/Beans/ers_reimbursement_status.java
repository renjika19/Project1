package com.fred.Beans;

public class ers_reimbursement_status {
	private Integer reimb_status_id;
	private String reimb_status;
	
	public ers_reimbursement_status() {
		super();
	}
	
	public ers_reimbursement_status(Integer reimb_status_id, String reimb_status) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}

	public ers_reimbursement_status(String reimb_status) {
		super();
		this.reimb_status = reimb_status;
	}
	
	public Integer getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(Integer reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public String toString() {
		return "ers_reimbursement_status [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}



	
}
