DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL
);

INSERT INTO users (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES
  (1, 'first', 'last 1', 'abc1@gmail.com'),
  (2, 'first', 'last 2', 'abc2@gmail.com'),
  (3, 'first', 'last 3', 'abc3@gmail.com');
  
 
DROP TABLE IF EXISTS student;

create table student
(
   id integer not null AUTO_INCREMENT,
   username varchar(255) not null,
   password varchar(255) not null,
   name varchar(255) not null,
   passportnumber varchar(255) not null UNIQUE,
   primary key(id)
);

DROP TABLE IF EXISTS student_election;

create table student_election
(
    id integer not null AUTO_INCREMENT,
    voter_id integer not null,
    candidate_id integer not null,
    role_id integer not null
    
);


DROP TABLE IF EXISTS candidate;

create table candidate
(
    id integer not null AUTO_INCREMENT,
    student_id integer not null UNIQUE,
    description varchar(255) not null,
    status int not null
    
)

 /*INSERT INTO STUDENT (ID, USERNAME, PASSWORD, NAME, PASSPORTNUMBER) VALUES
  (NULL, 'Shashank', 'password', 'shasha', 'ABC123'),
  (NULL, 'Priya', 'password', 'Priya', 'XYZ789'),
  (NULL, 'Arjun', 'pass', 'Arjun', 'ABC1234'),
  (NULL, 'Ram', 'charit', 'Ram', 'XYZ123'),
  (NULL, 'Anusha', 'password', 'Anusha', 'XYZ7896'); */
  
/*INSERT INTO CANDIDATE (ID, STUDENT_ID, DESCRIPTION, STATUS) VALUES
  (NULL, 1, 'Vote for me!', 0); */

  
  
  
  