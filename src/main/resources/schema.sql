-- DROP TABLE If EXISTS CAR_COST_EVALUATION;
-- DROP TABLE If EXISTS AIRPLANE_COST_EVALUATION;
-- DROP TABLE IF EXISTS CAR;
-- DROP TABLE If EXISTS AIRPLANE;

create table IF NOT EXISTS CAR (
        "id" BIGINT NOT NULL,
        brand VARCHAR(150),
        model VARCHAR(200),
        power FLOAT,
        year_of_issue INT,
--         assessed_value DEC(20),
	PRIMARY KEY ("id")
        );

        create table IF NOT EXISTS AIRPLANE (
        "id" BIGINT NOT NULL,
        brand VARCHAR(150),
        model VARCHAR(200),
        manufacturer VARCHAR(500),
        year_of_issue INT,
        fuelCapacity INT,
        seats INT,
		PRIMARY KEY ("id")

        );

		CREATE TABLE IF NOT EXISTS CAR_COST_EVALUATION (
		    id BIGINT,
			car_id BIGINT,
			value BIGINT,
			date DATE,
			FOREIGN KEY ("car_id") REFERENCES CAR (id),
			PRIMARY KEY ("id")

		);

			CREATE TABLE IF NOT EXISTS AIRPLANE_COST_EVALUATION (
			id BIGINT,
			airplane_id BIGINT,
			value BIGINT,
			date DATE,
			FOREIGN KEY ("airplane_id") REFERENCES AIRPLANE (id),
            PRIMARY KEY ("id")

		);