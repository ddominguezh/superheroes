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
	GENDER_ID INT DEFAULT 0 NOT NULL,
    EYE_COLOR_ID INT DEFAULT 0 NOT NULL,
    HAIR_COLOR_ID INT DEFAULT 0 NOT NULL,
    NAME VARCHAR(255) DEFAULT '' NOT NULL,
    HEIGHT INT DEFAULT 0 NOT NULL,
    WEIGHT INT DEFAULT 0 NOT NULL);
    
ALTER TABLE hero
    ADD FOREIGN KEY (GENDER_ID) 
    REFERENCES gender(ID);
ALTER TABLE hero
    ADD FOREIGN KEY (EYE_COLOR_ID) 
    REFERENCES color(ID);
ALTER TABLE hero
    ADD FOREIGN KEY (HAIR_COLOR_ID) 
    REFERENCES color(ID);