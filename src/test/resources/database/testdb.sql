DROP TABLE IF EXISTS color;
CREATE TABLE color(ID INT PRIMARY KEY,
    NAME VARCHAR(255) DEFAULT '' NOT NULL);
insert into color( id, name ) values (1, 'blue');
insert into color( id, name ) values (2, 'green');
insert into color( id, name ) values (3, 'yellow');
insert into color( id, name ) values (4, 'black');
insert into color( id, name ) values (5, 'white');
insert into color( id, name ) values (6, 'red');

DROP TABLE IF EXISTS gender;
CREATE TABLE gender(ID INT PRIMARY KEY,
    NAME VARCHAR(20) DEFAULT '' NOT NULL);
insert into gender( id, name ) values (1, 'UNDEFINED');
insert into gender( id, name ) values (2, 'WOMEN');
insert into gender( id, name ) values (3, 'MEN');
insert into gender( id, name ) values (4, 'TRANSGENDER');

DROP TABLE IF EXISTS hero;
CREATE TABLE hero(ID CHAR(36) PRIMARY KEY);
insert into hero( id ) values ('7f675eca-afbf-11ed-afa1-0242ac120002');
