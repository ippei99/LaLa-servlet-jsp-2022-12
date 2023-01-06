-- 
-- dbsamplef[^x[X
-- 

-- 
-- gender\
-- 
DROP TABLE IF EXISTS gender;

CREATE TABLE gender (
  id CHAR(1) PRIMARY KEY,
  name VARCHAR(10)
);

INSERT INTO gender
  (id, name)
VALUES
  ('0', 'sΎ'),
  ('1', 'j«'),
  ('2', '«'),
  ('3', '»ΜΌ');


--
-- dept\
-- 
DROP TABLE IF EXISTS dept;

CREATE TABLE dept (
  id CHAR(3) PRIMARY KEY,
  name VARCHAR(100)
);

INSERT INTO dept
  (id, name)
VALUES
  ('d01', '±'),
  ('d02', 'o'),
  ('d03', 'ζκcΖ'),
  ('d04', 'J­'),
  ('d05', 'ζρcΖ');


--
-- employee\
-- 
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(100),
  gender_id CHAR(1),
  birthday DATE,
  dept_id CHAR(3)
);

INSERT INTO employee
  (id, name, gender_id, birthday, dept_id)
VALUES
  ('EMP001', 'ρK° Σέ', '2', '1994-09-21', 'd05'),
  ('EMP002', 'υJ γΔΎ',   '1', '1992-09-03', 'd04'),
  ('EMP003', 'g R’q', '2', '1988-07-22', 'd02'),
  ('EMP004', 'EΛ mξ',   '1', '1979-05-07', 'd04');


