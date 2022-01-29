DROP TABLE IF EXISTS	ers_reimbursement;
DROP TABLE IF EXISTS	ers_users;
DROP TABLE IF EXISTS	ers_reimbursement_status;
DROP TABLE IF EXISTS	ers_reimbursement_type;
DROP TABLE IF EXISTS	ers_user_roles;

CREATE TABLE ers_reimbursement_status(
	reimb_status_id	SERIAL	PRIMARY KEY,
	reimb_status	VARCHAR(10)
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id	SERIAL	PRIMARY	KEY,
	reimb_type	VARCHAR(10)
);

CREATE TABLE ers_user_roles (
	ers_user_role_id SERIAL PRIMARY KEY,
	user_role VARCHAR (50)
);

CREATE TABLE ers_users(
	ers_users_id SERIAL PRIMARY KEY,
	ers_username		VARCHAR(50)		UNIQUE,
	ers_password		VARCHAR(200),
	user_first_name		VARCHAR(100),
	user_last_name		VARCHAR(100),
	user_email			VARCHAR(150) 	UNIQUE,
	user_role_id		INT	REFERENCES ers_user_roles(ers_user_role_id)
);

CREATE TABLE ers_reimbursement(
	reimb_id SERIAL 	PRIMARY KEY,
	reimb_amount		INT,
	reimb_submitted		TIMESTAMP,
	reimb_resolved		TIMESTAMP,
	reimb_description	VARCHAR(250),
	reimb_receipt		BYTEA,
	reimb_author		INT REFERENCES ers_users(ers_users_id),
	reimb_resolver		INT	REFERENCES ers_users(ers_users_id),
	reimb_status_id		INT REFERENCES ers_reimbursement_status(reimb_status_id),
	reimb_type_id		INT REFERENCES ers_reimbursement_type(reimb_type_id)
);

INSERT INTO ers_reimbursement_status (reimb_status) VALUES
('Pending'), ('Approved'), ('Denied');

INSERT INTO ers_reimbursement_type (reimb_type) VALUES
('Food'),('etc');

INSERT INTO ers_user_roles (user_role) VALUES
('Employee'), ('Manager');


INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES
('manager', '2e2b24f8ee40bb847fe85bb23336a39ef5948e6b49d897419ced68766b16967a', 'admin', 'god', 'admin@admin.com', 2),
('employee', '82a69e924ed8b80a888026f1e825c4516f7b38b6628a1b6d8ee4568aa82b9345', 'employee', 'poor', 'employee@employee.com', 1);

INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) VALUES 
('2', (SELECT CURRENT_TIMESTAMP), 'wf', 2, 1, 2);