CREATE TABLE category(
	id INT AUTO_INCREMENT,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

CREATE TABLE user_detail(
	u_id INT AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enable BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY (u_id)
);

INSERT INTO user_detail(first_name,last_name,role,enable,password,email,contact_number)VALUES('Prashant','Patil','ADMIN',true,'admin','pash@gmail.com','7676370393');
INSERT INTO user_detail(first_name,last_name,role,enable,password,email,contact_number)VALUES('Pash','Patil','SUPPLIER',true,'12345','a@gmail.com','7676370395');
INSERT INTO user_detail(first_name,last_name,role,enable,password,email,contact_number)VALUES('Prash','Patil','SUPPLIER',true,'123456','sh@gmail.com','7676370396');

CREATE TABLE product (
p_id INT AUTO_INCREMENT,
code VARCHAR(20),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(255),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,

CONSTRAINT pk_product_id PRIMARY KEY (p_id)
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(u_id) 

);

INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRAACJH123456','iPhone 8s','apple','This is new apple phone in market',85000,5,true,3,2);
INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRAACJH123656','Moto C Plus','Motorola','This is new Moto phone in market',7000,5,true,1,2);
INSERT INTO product(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRAACJH123686','NOKIA 6.1 Plus','NOKIA','This is new NOKIA phone in market',17000,5,true,1,3);


