show user;


CREATE TABLE ers_users (
	ers_users_id NUMBER(6) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	ers_username VARCHAR2(200) UNIQUE,
	ers_password VARCHAR2(200),
	user_fname VARCHAR2(200),
	user_lname VARCHAR2(200),
	user_email VARCHAR2(200) UNIQUE,
	user_role_id NUMBER(6) DEFAULT 1,  
	CONSTRAINT user_role_fk FOREIGN KEY (user_role_id)
	REFERENCES ers_user_roles(ers_user_role_id)ON DELETE CASCADE
);



CREATE TABLE polkamans (
  p_id NUMBER(6) PRIMARY KEY,
  p_name VARCHAR2(200),
  p_hp NUMBER(6),
  p_str NUMBER(6),
  p_owner_id NUMBER(6),
  --CONSTRAINT polkamans_pk PRIMARY KEY (p_id)
  --CONSTRAINT constraintName CONSTRAINT TYPE (column name)
  CONSTRAINT p_owner_id FOREIGN KEY (p_owner_id)
        REFERENCES owners(o_id)
);

drop table ers_users;


create table Library.ERS_USERS(
ers_USERS_ID GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
ers_USERNAME VARCHAR2(50) UNIQUE,
ers_PASSWORD VARCHAR(50),
user_FIRST_NAME VARCHAR(100),
user_LAST_NAME VARCHAR(100),
user_EMAIL VARCHAR2(150) UNIQUE,
user_ROLE_ID NUMBER UNIQUE,
CONSTRAINT user_role_id_fk FOREIGN KEY (user_role_id)
REFERENCES Library.ers_user_roles(ers_user_role_id)
);

drop table ers_reimbursement_status ;

Create table ers_user_roles (
    ers_user_role_id number(6) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_role varchar2(10)
);

Create table ers_reimbursement_type (
    reimb_type_id number(6) GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    reimb_type varchar2(10)
);

Create table ers_reimbursement_status (
    reimb_status_id number(6) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    reimb_status varchar2(10)
);



CREATE TABLE ers_reimbursement (
	reimb_id NUMBER(6)GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	reimb_amount NUMBER(8,2),
	reimb_submitted TIMESTAMP,
	reimb_resolved TIMESTAMP,
	reimb_description VARCHAR2(3000),
	reimb_receipt BLOB,
	reimb_author NUMBER(6),
	reimb_resolver NUMBER(6),
	reimb_status_id NUMBER(6),
	reimb_type_id NUMBER(6),
	CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author)
	REFERENCES ers_users(ers_users_id) ON DELETE CASCADE,
	CONSTRAINT ers_user_fk_reslvr FOREIGN KEY (reimb_resolver)
	REFERENCES ers_users(ers_users_id) ON DELETE CASCADE,
	CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id)
	REFERENCES ers_reimbursement_status(reimb_status_id) ON DELETE CASCADE,
	CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id)
	REFERENCES ers_reimbursement_type(reimb_type_id)ON DELETE CASCADE
);






