DELETE FROM car;
DELETE FROM airplane;
DELETE FROM CAR_COST_EVALUATION;
DELETE FROM AIRPLANE_COST_EVALUATION;


INSERT INTO car(id,brand, model, power, year_of_issue)
VALUES (3,'Mazda', 'Biante', 149, 2020)
ON CONFLICT DO NOTHING;
INSERT INTO car(id,brand, model, power, year_of_issue)
VALUES (4,'Mazda', 'CX-30', 162, 2019)
ON CONFLICT DO NOTHING;
INSERT INTO car(id,brand, model, power, year_of_issue)
VALUES (2,'Hyundai', 'Elantra', 152, 2017)
ON CONFLICT DO NOTHING;
INSERT INTO car(id,brand, model, power, year_of_issue)
VALUES (1,'Toyota', 'Corolla Altis', 145, 2018)
ON CONFLICT DO NOTHING;
INSERT INTO car(id,brand, model, power, year_of_issue)
VALUES (11,'Toyota', 'Alphard', 300, 2022)
ON CONFLICT DO NOTHING;

INSERT INTO airplane(id,brand,model,manufacturer,year_of_issue,capacity,seats)
VALUES (2,'Airbus','A380','France',2010,323,525)
ON CONFLICT DO NOTHING;
INSERT INTO airplane(id,brand,model,manufacturer,year_of_issue,capacity,seats)
VALUES (13,'Alenia Aermacchi','M-346','Italy',2005,15,2)
ON CONFLICT DO NOTHING;
INSERT INTO airplane(id,brand,model,manufacturer,year_of_issue,capacity,seats)
VALUES (25,'Epic Aircraft','Epic Dynasty','United States',2013,25,6)
ON CONFLICT DO NOTHING;

-- INSERT INTO CAR_COST_EVALUATION()