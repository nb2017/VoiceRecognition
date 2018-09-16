CREATE DATABASE GMC;

use gmc;

CREATE TABLE usr(
  id int(11) NOT NULL auto_increment,
  accounttype int(1),
  password VARCHAR(20),
  nickname VARCHAR(10000),
  PRIMARY KEY(id)
);
INSERT INTO usr(accounttype, password, nickname) VALUES('0','g1201','一般人');
SELECT * FROM usr;

create table VTB(
  id int(11) NOT NULL auto_increment,
  voice VARCHAR(10000),
  date TIMESTAMP,
  userid int(11),
  PRIMARY KEY(id)
);

