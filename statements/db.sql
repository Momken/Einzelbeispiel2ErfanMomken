DROP TABLE schiff;
DROP TABLE hafen;
DROP TABLE fahrt;


CREATE  TABLE hafen (
ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1)PRIMARY KEY,
land VARCHAR(30),
name varchar(30),
kapazitaet INTEGER,
maxGroesse DOUBLE,
oelhafen BOOLEAN,
wartungsdatum Date
);


CREATE  TABLE schiff(
ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1)PRIMARY KEY,
reeder VARCHAR(30),
baujahr DATE,
maxGeschwindigkeit DOUBLE,
kapzitaet INTEGER,
kapitaen VARCHAR(60),
name VARCHAR(30),
tanker BOOLEAN,
laenge INTEGER
);


CREATE  TABLE fahrt(
ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1)PRIMARY KEY,
schiffId INTEGER,
hafenVonId INTEGER,
hafenBisId INTEGER,
ladung VARCHAR(60),
abfahrt DATE,
ankunft DATE
);

INSERT INTO hafen VALUES(NULL, 'Iran', 'Bandarabbas',  100, 203.3, TRUE, '2015-12-13' );
INSERT INTO hafen VALUES(NULL, 'Iran', 'Kish',  30, 93.8, FALSE, '2015-12-23' );
INSERT INTO hafen VALUES(NULL, 'Iran', 'Bushehr',  150, 133.3, TRUE, '2015-12-03' );
INSERT INTO hafen VALUES(NULL, 'Deutschland', 'Hamburg',  200, 450.5, TRUE, '2015-12-01' );
INSERT INTO hafen VALUES(NULL, 'Italien', 'Bari',  20, 103.3, FALSE, '2015-02-13' );
INSERT INTO hafen VALUES(NULL, 'Japan', 'Kioto',  201, 500.5, true, '2015-01-13' );

INSERT INTO  schiff VALUES(NULL, 'US-Foderation', '2015-02-13', 40.5, 100, 'Picasso', 'Mari', TRUE, 201 );
INSERT INTO  schiff VALUES(NULL, 'GHF', '2015-02-13', 70.5, 100, 'Rudolf', 'Kuri', TRUE, 201 );
INSERT INTO  schiff VALUES(NULL, 'US-Foderation', '2015-02-13', 70.5, 100, 'Jr Mila', 'Rosi', TRUE, 201 );
INSERT INTO  schiff VALUES(NULL, 'KI', '2015-02-13', 60.5, 100, 'Ahmad Zanjani', 'Sorat', TRUE, 201 );
INSERT INTO  schiff VALUES(NULL, 'Pirates', '1879-2-21', 90.5, 100, 'Jack Sparrow', 'Black Pearl', TRUE, 201 );


INSERT INTO  fahrt VALUES(NULL, 1, 4, 3, 'APFEL', '2015-02-03', '2015-02-13');
INSERT INTO  fahrt VALUES(NULL, 5, 4, 3, 'Kanonen', '2015-02-13', '2015-02-23');