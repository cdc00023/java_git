use classicmodels;
show databases;
use classicmodels;
SELECT * FROM  classicmodels;
SELECT lastName
FROM employees;
SELECT lastname, firstname, jobtitle
FROM employees;
SELECT * 
FROM employees;
/* order by : 데이터 정렬*/
/*A)ORDER BY clause to sort values in one column example 디폴트는 오름차순*/
SELECT
	contactLastname,
	contactFirstname
FROM
	customers
ORDER BY
	contactLastname;

/*If you want to sort customers by the last name in the descending order*/    
SELECT
	contactLastname,
	contactFirstname
FROM
	customers
ORDER BY
	contactLastname DESC;

/*B)ORDER BY clause to sort values in multiple columns example*/    
SELECT
	contactLastname,
	contactFirstname
FROM
	customers
ORDER BY
	contactLastname DESC,
	contactFirstname ASC;   
    
/*C)ORDER BY to sort a result set by an expression example*/
SELECT 
    orderNumber, 
    orderlinenumber, 
    quantityOrdered * priceEach 
FROM
    orderdetails
ORDER BY 
   quantityOrdered * priceEach DESC;    

/*ORDER BY to sort data using a custom list 사용자가 리스트 순서를 정할때*/
SELECT 
    orderNumber, 
    status
FROM
    orders
ORDER BY 
    FIELD(status,
        'In Process',
        'On Hold',
        'Cancelled',
        'Resolved',
        'Disputed',
        'Shipped');    
        
        
/*WHERE절*/
/* to filter rows from the result set 필터링시 사용*/
/*1)WHERE clause with equal operator example*/
SELECT 
    lastname, 
    firstname, 
    jobtitle
FROM
    employees
WHERE
    jobtitle = 'Sales Rep';
    
/*2)WHERE clause with AND operator*/    
SELECT 
    lastname, 
    firstname, 
    jobtitle,
    officeCode
FROM
    employees
WHERE
    jobtitle = 'Sales Rep' AND 
    officeCode = 1;

/*3) Using MySQL WHERE clause with OR operator*/
SELECT 
    lastName, 
    firstName, 
    jobTitle, 
    officeCode
FROM
    employees
WHERE
    jobtitle = 'Sales Rep' OR 
    officeCode = 1
ORDER BY 
    officeCode , 
    jobTitle;        
        
/*4) Using MySQL WHERE with BETWEEN operator example*/        
SELECT 
    firstName, 
    lastName, 
    officeCode
FROM
    employees
WHERE
    officeCode BETWEEN 1 AND 3
ORDER BY officeCode;       
        
/*5)WHERE with the LIKE operator example 유사검색(%:개수제한없음 ot _:한글자대체)*/       
SELECT 
    firstName, 
    lastName
FROM
    employees
WHERE
    lastName LIKE '%son'
ORDER BY firstName;        
        
/*6)WHERE clause with the IN operator example*/
SELECT 
    firstName, 
    lastName, 
    officeCode
FROM
    employees
WHERE
    officeCode IN (1 , 2, 3) /*(=BETWEEN 1 AND 3)*/
ORDER BY 
    officeCode;     
    
/*7)WHERE  clause with the IS NULL operator*/

/*8)WHERE clause with comparison operators 비교연산자*/ 
        

/*DISTINCT*/
SELECT 
    COUNT(DISTINCT state)
FROM
    customers
WHERE
    country = 'USA';

/*JOIN*/
CREATE TABLE members (
    member_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (member_id)
);

CREATE TABLE committees (
    committee_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    PRIMARY KEY (committee_id)
);

INSERT INTO members(name)
VALUES('John'),('Jane'),('Mary'),('David'),('Amelia');

INSERT INTO committees(name)
VALUES('John'),('Mary'),('Amelia'),('Joe');

select * from members;
select * from committees;


/*INNER JOIN*/
SELECT 
     select_list
FROM 
     t1
INNER JOIN t2 ON join_condition;


SELECT 
    productCode, 
    productName, 
    textDescription
FROM
    products t1
INNER JOIN productlines t2 
    ON t1.productline = t2.productline;

SELECT 
    t1.orderNumber,
    t1.status,
    SUM(quantityOrdered * priceEach) total
FROM
    orders t1
INNER JOIN orderdetails t2 
    ON t1.orderNumber = t2.orderNumber
GROUP BY orderNumber;

SELECT 
    orderNumber,
    orderDate,
    orderLineNumber,
    productName,
    quantityOrdered,
    priceEach
FROM
    orders
INNER JOIN
    orderdetails USING (orderNumber)
INNER JOIN
    products USING (productCode)
ORDER BY 
    orderNumber, 
    orderLineNumber;
    
    SELECT 
    orderNumber,
    orderDate,
    customerName,
    orderLineNumber,
    productName,
    quantityOrdered,
    priceEach
FROM
    orders
INNER JOIN orderdetails 
    USING (orderNumber)
INNER JOIN products 
    USING (productCode)
INNER JOIN customers 
    USING (customerNumber)
ORDER BY 
    orderNumber, 
    orderLineNumber;
    
    SELECT 
    orderNumber, 
    productName, 
    msrp, 
    priceEach
FROM
    products p
INNER JOIN orderdetails o 
   ON p.productcode = o.productcode
      AND p.msrp > o.priceEach
WHERE
    p.productcode = 'S10_1678';
    
show tables;
    
/* CROSS JOIN*/
CREATE DATABASE IF NOT EXISTS salesdb;
USE salesdb;
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100),
    price DECIMAL(13,2 )
);

CREATE TABLE stores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    store_name VARCHAR(100)
);

CREATE TABLE sales (
    product_id INT,
    store_id INT,
    quantity DECIMAL(13 , 2 ) NOT NULL,
    sales_date DATE NOT NULL,
    PRIMARY KEY (product_id , store_id),
    FOREIGN KEY (product_id)
        REFERENCES products (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (store_id)
        REFERENCES stores (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO products(product_name, price)
VALUES('iPhone', 699),
      ('iPad',599),
      ('Macbook Pro',1299);

INSERT INTO stores(store_name)
VALUES('North'),
      ('South');

INSERT INTO sales(store_id,product_id,quantity,sales_date)
VALUES(1,1,20,'2017-01-02'),
      (1,2,15,'2017-01-05'),
      (1,3,25,'2017-01-05'),
      (2,1,30,'2017-01-02'),
      (2,2,35,'2017-01-05');

SELECT 
    store_name,
    product_name,
    SUM(quantity * price) AS revenue
FROM
    sales
        INNER JOIN
    products ON products.id = sales.product_id
        INNER JOIN
    stores ON stores.id = sales.store_id
GROUP BY store_name , product_name; 

SELECT 
    store_name, product_name
FROM
    stores AS a
        CROSS JOIN
    products AS b;
    
SELECT 
    b.store_name,
    a.product_name,
    IFNULL(c.revenue, 0) AS revenue
FROM
    products AS a
        CROSS JOIN
    stores AS b
        LEFT JOIN
    (SELECT 
        stores.id AS store_id,
        products.id AS product_id,
        store_name,
            product_name,
            ROUND(SUM(quantity * price), 0) AS revenue
    FROM
        sales
    INNER JOIN products ON products.id = sales.product_id
    INNER JOIN stores ON stores.id = sales.store_id
    GROUP BY stores.id, products.id, store_name , product_name) AS c ON c.store_id = b.id
        AND c.product_id= a.id
ORDER BY b.store_name;  

show tables;  


/*GROUP BY*/
SELECT 
    status
FROM
    orders
GROUP BY status;

SELECT 
    status, COUNT(*)
FROM
    orders
GROUP BY status;

SELECT 
    status, 
    SUM(quantityOrdered * priceEach) AS amount
FROM
    orders
INNER JOIN orderdetails 
    USING (orderNumber)
GROUP BY 
    status;
    
SELECT 
    orderNumber,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orderdetails
GROUP BY 
    orderNumber;
    
SELECT 
    YEAR(orderDate) AS year,
    SUM(quantityOrdered * priceEach) AS total
FROM
    orders
INNER JOIN orderdetails 
    USING (orderNumber)
WHERE
    status = 'Shipped'
GROUP BY 
    YEAR(orderDate);   
    
/*derived table*/
SELECT 
    productCode, 
    ROUND(SUM(quantityOrdered * priceEach)) sales
FROM
    orderdetails
        INNER JOIN
    orders USING (orderNumber)
WHERE
    YEAR(shippedDate) = 2003
GROUP BY productCode
ORDER BY sales DESC
LIMIT 5; 

SELECT 
    productName, sales
FROM
    (SELECT 
        productCode, 
        ROUND(SUM(quantityOrdered * priceEach)) sales
    FROM
        orderdetails
    INNER JOIN orders USING (orderNumber)
    WHERE
        YEAR(shippedDate) = 2003
    GROUP BY productCode
    ORDER BY sales DESC
    LIMIT 5) top5products2003
INNER JOIN
    products USING (productCode);   

SELECT 
    customerNumber,
    ROUND(SUM(quantityOrdered * priceEach)) sales,
    (CASE
        WHEN SUM(quantityOrdered * priceEach) < 10000 THEN 'Silver'
        WHEN SUM(quantityOrdered * priceEach) BETWEEN 10000 AND 100000 THEN 'Gold'
        WHEN SUM(quantityOrdered * priceEach) > 100000 THEN 'Platinum'
    END) customerGroup
FROM
    orderdetails
        INNER JOIN
    orders USING (orderNumber)
WHERE
    YEAR(shippedDate) = 2003
GROUP BY customerNumber; 

/*insert*/
CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    start_date DATE,
    due_date DATE,
    priority TINYINT NOT NULL DEFAULT 3,
    description TEXT,
    PRIMARY KEY (task_id)
);
INSERT INTO tasks(title,priority)
VALUES('Learn MySQL INSERT Statement',1);
SELECT * FROM tasks;

SHOW VARIABLES LIKE 'max_allowed_packet';

/*INSERT INTO SELECT*/
CREATE TABLE suppliers (
    supplierNumber INT AUTO_INCREMENT,
    supplierName VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    addressLine1 VARCHAR(50),
    addressLine2 VARCHAR(50),
    city VARCHAR(50),
    state VARCHAR(50),
    postalCode VARCHAR(50),
    country VARCHAR(50),
    customerNumber INT,
    PRIMARY KEY (supplierNumber)
);
SELECT 
    customerNumber,
    customerName,
    phone,
    addressLine1,
    addressLine2,
    city,
    state,
    postalCode,
    country
FROM
    customers
WHERE
    country = 'USA' AND 
    state = 'CA';
    
    
/*PRACTISE*/
create database helloSQL;
show databases;
use helloSQL;
show tables;
create table foods
(
id int not null auto_increment,
product varchar(100) not null,
primary key(id)
);
desc foods;

create table menu
(
id int not null auto_increment,
menu varchar(100) not null,
product_id int,
primary key (id),
foreign key (product_id) references foods (id)
);
desc foods;    

show databases;
select database();
use classicmodels;

use testdb;
select database();
drop database if exists testdb; 

use classicmodels;
DESCRIBE tasks;

CREATE TABLE IF NOT EXISTS checklists (
    todo_id INT AUTO_INCREMENT,
    task_id INT,
    todo VARCHAR(255) NOT NULL,
    is_completed BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (todo_id , task_id),
    FOREIGN KEY (task_id)
        REFERENCES tasks (task_id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);


SET autocommit = 0;
SET autocommit = 1;

set autocommit = 0;
start transaction;

SELECT 
    @orderNumber:=MAX(orderNUmber)+1
FROM
    orders;

INSERT INTO orders(orderNumber,
                   orderDate,
                   requiredDate,
                   shippedDate,
                   status,
                   customerNumber)
VALUES(@orderNumber,
       '2005-05-31',
       '2005-06-10',
       '2005-06-11',
       'In Process',
        145);

INSERT INTO orderdetails(orderNumber,
                         productCode,
                         quantityOrdered,
                         priceEach,
                         orderLineNumber)
VALUES(@orderNumber,'S18_1749', 30, '136', 1),
      (@orderNumber,'S18_2248', 50, '55.09', 2); 

COMMIT; /*롤백을 해도 못돌림*/

/*취소하기 위해선 delete써야함*/

set autocommit = 1;

SELECT 
    a.orderNumber,
    orderDate,
    requiredDate,
    shippedDate,
    status,
    comments,
    customerNumber,
    orderLineNumber,
    productCode,
    quantityOrdered,
    priceEach
FROM
    orders a
        INNER JOIN
    orderdetails b USING (orderNumber)
WHERE
    a.ordernumber = 10426;


CREATE TABLE messages ( 
    id INT NOT NULL AUTO_INCREMENT, 
    message VARCHAR(100) NOT NULL, 
    PRIMARY KEY (id) 
);


SELECT CONNECTION_ID();

INSERT INTO messages(message) 
VALUES('Hello');

SELECT * FROM messages;

LOCK TABLE messages READ;

INSERT INTO messages(message) 
VALUES('Hi');

SELECT * FROM messages;

SELECT CONNECTION_ID();

UNLOCK TABLES;

SELECT * FROM messages;

LOCK TABLE messages WRITE;
INSERT INTO messages(message) 
VALUES('hey');

SELECT * FROM messages;

UNLOCK TABLES;

SELECT * FROM messages;

SELECT 
    employeeNumber, 
    lastName, 
    firstName
FROM
    employees
WHERE
    jobTitle = 'Sales Rep';