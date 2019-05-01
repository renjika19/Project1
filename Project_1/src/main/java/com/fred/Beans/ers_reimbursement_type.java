package com.fred.Beans;

public class ers_reimbursement_type {
	private Integer reimb_type_id;
	private String reimb_type;
	
	
	public ers_reimbursement_type() {
		super();
	}
	
	public ers_reimbursement_type(Integer reimb_type_id, String reimb_type) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}

	public ers_reimbursement_type(String reimb_type) {
		super();
		this.reimb_type = reimb_type;
	}

	public Integer getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(Integer reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	@Override
	public String toString() {
		return "ers_reimbursement_type [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
	}
	

	
}
