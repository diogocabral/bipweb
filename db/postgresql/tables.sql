CREATE TABLE bipweb.user (
	id SERIAL,
	root_category_id INT6,
	username VARCHAR(20),
	password VARCHAR
);

CREATE TABLE bipweb.category (
	id SERIAL,
	parent_id INT6,
	name VARCHAR,
	description VARCHAR,
	criteria VARCHAR,
	terms VARCHAR
);

CREATE TABLE bipweb.document (
	id SERIAL,
	title VARCHAR,
	url VARCHAR
);

CREATE TABLE bipweb.stopword (
	id SERIAL,
	description VARCHAR
);