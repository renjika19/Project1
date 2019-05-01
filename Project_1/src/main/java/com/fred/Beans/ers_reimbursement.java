package com.fred.Beans;

import java.sql.Blob;

import com.sun.jmx.snmp.Timestamp;

public class ers_reimbursement {
	private Integer reimb_id;
	private Double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private Blob reimb_receipt;
	private String reimb_author;
	private String reimb_resolver;
	private Integer reimb_status_id;
	private Integer reimb_type_id;

	
	
	public ers_reimbursement() {
		super();
	}



	public ers_reimbursement(Integer reimb_id, Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, Blob reimb_receipt, String reimb_author, String reimb_resolver,
			Integer reimb_status_id, Integer reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}



	public ers_reimbursement(Double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, Blob reimb_receipt, String reimb_author, String reimb_resolver,
			Integer reimb_status_id, Integer reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}



	public Integer getReimb_id() {
		return reimb_id;
	}



	public void setReimb_id(Integer reimb_id) {
		this.reimb_id = reimb_id;
	}



	public Double getReimb_amount() {
		return reimb_amount;
	}



	public void setReimb_amount(Double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}



	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}



	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}



	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}



	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}



	public String getReimb_description() {
		return reimb_description;
	}



	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}



	public Blob getReimb_receipt() {
		return reimb_receipt;
	}



	public void setReimb_receipt(Blob reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}



	public String getReimb_author() {
		return reimb_author;
	}



	public void setReimb_author(String reimb_author) {
		this.reimb_author = reimb_author;
	}



	public String getReimb_resolver() {
		return reimb_resolver;
	}



	public void setReimb_resolver(String reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}



	public Integer getReimb_status_id() {
		return reimb_status_id;
	}



	public void setReimb_status_id(Integer reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}



	public Integer getReimb_type_id() {
		return reimb_type_id;
	}



	public void setReimb_type_id(Integer reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}



	@Override
	public String toString() {
		return "ers_reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id=" + reimb_type_id + "]";
	}




	
}
