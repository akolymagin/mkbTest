DROP TABLE If EXISTS CAR_COST_EVALUATION;
DROP TABLE If EXISTS AIRPLANE_COST_EVALUATION;
DROP TABLE IF EXISTS CAR;
DROP TABLE If EXISTS AIRPLANE;
-- --
-- DROP SEQUENCE IF EXISTS car_seq;
-- DROP SEQUENCE IF EXISTS airplane_seq;
-- DROP SEQUENCE IF EXISTS car_cost_evaluation_seq;
-- DROP SEQUENCE IF EXISTS airplane_cost_evaluation_seq;

-- CREATE SEQUENCE IF NOT EXISTS car_seq
--     INCREMENT 1
--     START 1
--     MINVALUE 1;

-- CREATE SEQUENCE IF NOT EXISTS airplane_seq
--     INCREMENT 1
--     START 1
--     MINVALUE 1;

CREATE SEQUENCE IF NOT EXISTS car_cost_evaluation_seq
    INCREMENT 1
    START 1
    MINVALUE 1;
--
 CREATE SEQUENCE IF NOT EXISTS airplane_cost_evaluation_seq
    INCREMENT 1
    START 1
    MINVALUE 1;

create table IF NOT EXISTS CAR (
        "id" BIGINT NOT NULL
--         DEFAULT nextval(cast('car_seq' as regclass))
        ,
        brand VARCHAR(150),
        model VARCHAR(200),
        power FLOAT,
        year_of_issue INT,
--         assessed_value DEC(20),
	PRIMARY KEY ("id")
        );



        create table IF NOT EXISTS AIRPLANE (
        "id" BIGINT NOT NULL
--         DEFAULT nextval(cast('airplane_seq' as regclass))
        ,
        brand VARCHAR(150),
        model VARCHAR(200),
        manufacturer VARCHAR(500),
        year_of_issue BIGINT,
        capacity FLOAT,
        seats BIGINT,
		PRIMARY KEY ("id")

        );



		CREATE TABLE IF NOT EXISTS CAR_COST_EVALUATION (
		    id BIGINT NOT NULL
		    DEFAULT nextval(cast('car_cost_evaluation_seq' as regclass))
		    ,
			car_id BIGINT,
			value BIGINT,
			date DATE,
			FOREIGN KEY ("car_id") REFERENCES CAR (id),
			PRIMARY KEY ("id")

		);



			CREATE TABLE IF NOT EXISTS AIRPLANE_COST_EVALUATION (
			id BIGINT NOT NULL
			DEFAULT nextval(cast('airplane_cost_evaluation_seq' as regclass))
			,
			airplane_id BIGINT,
			value BIGINT,
			date DATE,
			FOREIGN KEY ("airplane_id") REFERENCES AIRPLANE (id),
            PRIMARY KEY ("id")

		);