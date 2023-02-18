CREATE TABLE color(ID INT PRIMARY KEY,
    NAME VARCHAR(255) DEFAULT '' NOT NULL);

insert into color( id, name ) values (1, 'blue');
insert into color( id, name ) values (2, 'green');
insert into color( id, name ) values (3, 'yellow');
insert into color( id, name ) values (4, 'black');
insert into color( id, name ) values (5, 'white');
insert into color( id, name ) values (6, 'red');

CREATE TABLE gender(ID INT PRIMARY KEY,
    NAME VARCHAR(20) DEFAULT '' NOT NULL);
insert into gender( id, name ) values (1, 'UNDEFINED');
insert into gender( id, name ) values (2, 'WOMEN');
insert into gender( id, name ) values (3, 'MEN');
insert into gender( id, name ) values (4, 'TRANSGENDER');

CREATE TABLE hero(ID CHAR(36) PRIMARY KEY,
    NAME VARCHAR(255) DEFAULT '' NOT NULL);