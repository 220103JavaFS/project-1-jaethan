DROP TABLE IF EXISTS	ers_reimbursement;
DROP TABLE IF EXISTS	ers_reimbursement_status;
DROP TABLE IF EXISTS	ers_reimbursement_type;
DROP TABLE IF EXISTS	ers_users;
DROP TABLE IF EXISTS	ers_user_roles;

CREATE TABLE ers_reimbursement_status(
	reimb_status_id	SERIAL	PRIMARY KEY,
	reimb_status	VARCHAR(10)
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id	SERIAL	PRIMARY	KEY,
	reimb_type	VARCHAR(10)
);

CREATE TABLE ers_reimbursement(
	reimb_id SERIAL 	PRIMARY KEY,
	reimb_amount		INT,
	reimb_submitted		TIMESTAMP,
	reimb_resolved		TIMESTAMP,
	reimb_description	VARCHAR(250),
	reimb_receipt		BYTEA,
	reimb_author		INT REFERENCES ers_user_users(user_role_id),
	reimb_resolver		INT	REFERENCES ers_user_users(user_role_id),
	reimb_status_id		INT REFERENCES ers_reimbursement_status(reimb_status_id),
	reimb_type_id		INT REFERENCES ers_reimbursement_type(reimb_type_id)
);

CREATE TABLE ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR (50)
);

CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY,
	ers_username		UNIQUE	VARCHAR(50),
	ers_password		VARCHAR(50),
	user_first_name		VARCHAR(100),
	user_last_name		VARCHAR(100),
	user_email			UNIQUE	VARCHAR(150),
	user_role_id		INT	REFERENCES ers_user_roles(ers_user_role_id)
);