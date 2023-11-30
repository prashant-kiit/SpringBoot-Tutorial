CREATE SCHEMA IF NOT EXISTS db_ex;

use db_ex;

SET foreign_key_checks = 0;

DROP TABLE IF EXISTS capital;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS river;
DROP TABLE IF EXISTS city_river;

create table capital (
    capital_id INT AUTO_INCREMENT,
    capital_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(capital_id)
) ENGINE=InnoDB, AUTO_INCREMENT=0;

create table country (
    country_id INT AUTO_INCREMENT,
    country_name VARCHAR(255) NOT NULL,
    capital_id INT NOT NULL,
    PRIMARY KEY(country_id),
	FOREIGN KEY(capital_id) 
		REFERENCES capital(capital_id) 
) ENGINE=InnoDB, AUTO_INCREMENT=0;

CREATE TABLE city(
    city_id INT AUTO_INCREMENT,
    city_name VARCHAR(255) NOT NULL,
    country_id INT NOT NULL,
    PRIMARY KEY(city_id),
    FOREIGN KEY(country_id) 
		REFERENCES country(country_id)
)ENGINE=InnoDB, AUTO_INCREMENT=0;

CREATE TABLE river(
    river_id INT AUTO_INCREMENT,
    river_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(river_id)
)ENGINE=InnoDB, AUTO_INCREMENT=0;

CREATE TABLE city_river(
	city_id INT NOT NULL,
    river_id INT NOT NULL,
    PRIMARY KEY(city_id, river_id),
    FOREIGN KEY(city_id) 
		REFERENCES city(city_id),
	FOREIGN KEY(river_id) 
		REFERENCES river(river_id)
)ENGINE=InnoDB;

INSERT INTO capital(capital_name)
VALUES('Washington');
INSERT INTO capital(capital_name)
VALUES('New Delhi');
INSERT INTO capital(capital_name)
VALUES('Moscow');

INSERT INTO country(country_name, capital_id)
VALUES('USA', 1);
INSERT INTO country(country_name, capital_id)
VALUES('India', 2);
INSERT INTO country(country_name, capital_id)
VALUES('Russia', 3);

INSERT INTO city(city_name, country_id)
VALUES('Boston',1);
INSERT INTO city(city_name, country_id)
VALUES('San Fransico',1);
INSERT INTO city(city_name, country_id)
VALUES('Bangalore',2);
INSERT INTO city(city_name, country_id)
VALUES('Hyderabad',2);
INSERT INTO city(city_name, country_id)
VALUES('St. Petersburg',3);
INSERT INTO city(city_name, country_id)
VALUES('Kazan',3);

INSERT INTO river(river_name)
VALUES('A');
INSERT INTO river(river_name)
VALUES('B');
INSERT INTO river(river_name)
VALUES('C');

INSERT INTO city_river(city_id, river_id)
VALUES('1','1');
INSERT INTO city_river(city_id, river_id)
VALUES('1','2');
INSERT INTO city_river(city_id, river_id)
VALUES('2','2');

SET foreign_key_checks = 1;

