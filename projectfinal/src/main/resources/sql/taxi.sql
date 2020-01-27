
CREATE TABLE Car
(
	car_number           VARCHAR(20) NOT NULL,
	year_of_issue        YEAR NULL,
	model                VARCHAR(20) NULL,
	color                VARCHAR(20) NULL
);



ALTER TABLE Car
ADD PRIMARY KEY (car_number);



CREATE TABLE Driver
(
	car_number           VARCHAR(20) NULL,
	id_driver            VARCHAR(20) NOT NULL,
	driver_name          VARCHAR(20) NULL,
	driver_surname       VARCHAR(20) NULL,
	driver_phone         VARCHAR(20) NULL,
	availability         boolean NULL
);



ALTER TABLE Driver
ADD PRIMARY KEY (id_driver);



CREATE TABLE Order
(
	id_user              VARCHAR(20) NULL,
	id_order             VARCHAR(20) NOT NULL,
	id_driver            VARCHAR(20) NULL,
	id_tariff            VARCHAR(20) NULL,
	id_special           VARCHAR(20) NULL,
	condition            boolean NULL,
	departure_adress     VARCHAR(20) NULL,
	arriving_adress      VARCHAR(20) NULL,
	order_date           DATE NULL
);



ALTER TABLE Order
ADD PRIMARY KEY (id_order);



CREATE TABLE Passenger_accaunt
(
	id_user              VARCHAR(20) NOT NULL,
	id_sale              VARCHAR(20) NULL,
	passenger_name       VARCHAR(20) NULL,
	passenger_surname    VARCHAR(20) NULL,
	passenger_phone      VARCHAR(20) NULL
);



ALTER TABLE Passenger_accaunt
ADD PRIMARY KEY (id_user);



CREATE TABLE Sale
(
	id_sale              VARCHAR(20) NOT NULL,
	order_amount         DOUBLE NULL,
	sale_percent         DOUBLE NULL
);



ALTER TABLE Sale
ADD PRIMARY KEY (id_sale);



CREATE TABLE Special
(
	id_special           VARCHAR(20) NOT NULL,
	sale_amount          DOUBLE NULL,
	sale_name            VARCHAR(20) NULL
);



ALTER TABLE Special
ADD PRIMARY KEY (id_special);



CREATE TABLE Tariff
(
	id_tariff            VARCHAR(20) NOT NULL,
	distance             DOUBLE NULL,
	price                DOUBLE NULL
);



ALTER TABLE Tariff
ADD PRIMARY KEY (id_tariff);



CREATE TABLE User
(
	id_user              VARCHAR(20) NOT NULL,
	email                VARCHAR(20) NULL,
	password             VARCHAR(20) NULL
);



ALTER TABLE User
ADD PRIMARY KEY (id_user);



ALTER TABLE Driver
ADD FOREIGN KEY R_4 (car_number) REFERENCES Car (car_number);



ALTER TABLE Order
ADD FOREIGN KEY R_3 (id_user) REFERENCES Passenger_accaunt (id_user);



ALTER TABLE Order
ADD FOREIGN KEY R_5 (id_driver) REFERENCES Driver (id_driver);



ALTER TABLE Order
ADD FOREIGN KEY R_6 (id_tariff) REFERENCES Tariff (id_tariff);



ALTER TABLE Order
ADD FOREIGN KEY R_7 (id_special) REFERENCES Special (id_special);



ALTER TABLE Passenger_accaunt
ADD FOREIGN KEY R_1 (id_user) REFERENCES User (id_user);



ALTER TABLE Passenger_accaunt
ADD FOREIGN KEY R_2 (id_sale) REFERENCES Sale (id_sale);


