USE classicmodels;

show tables;

SELECT CONNECTION_ID();

SELECT * FROM messages;

INSERT INTO messages(message) 
VALUES('Bye');

SELECT CONNECTION_ID();

SELECT * FROM messages;
INSERT INTO messages(message) 
VALUES('Bye');

INSERT INTO messages(message) 
VALUES('Bye');

INSERT INTO messages(message) 
VALUES('Bye Bye');

SELECT * FROM messages;

INSERT INTO messages(message) 
VALUES('Bye Bye');

SELECT * FROM messages;

SHOW PROCESSLIST;