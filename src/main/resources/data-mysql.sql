INSERT INTO airline (id, name) VALUES (1, 'Brussels Airlines');
INSERT INTO airline (id, name) VALUES (2, 'KLM');
INSERT INTO airline (id, name) VALUES (3, 'Air France');
INSERT INTO airline (id, name) VALUES (4, 'Lufthansa');

INSERT INTO airplane (id, brand, model) VALUES (1, 'Boeing', '747');
INSERT INTO airplane (id, brand, model) VALUES (2, 'Boeing', '737');
INSERT INTO airplane (id, brand, model) VALUES (3, 'Airbus', 'A320');
INSERT INTO airplane (id, brand, model) VALUES (4, 'Airbus', 'A380');

INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (1, 1);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (1, 4);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (2, 2);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (2, 3);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (2, 4);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (3, 4);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (4, 1);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (4, 2);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (4, 3);
INSERT INTO airline_airplanes (airlines_id, airplanes_id) VALUES (4, 4);

INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (1, 50, 'BUSINESS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (1, 400, 'ECONOMY');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (1, 20, 'FIRSTCLASS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (2, 40, 'BUSINESS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (2, 300, 'ECONOMY');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (2, 10, 'FIRSTCLASS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (3, 40, 'BUSINESS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (3, 300, 'ECONOMY');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (3, 10, 'FIRSTCLASS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (4, 50, 'BUSINESS');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (4, 400, 'ECONOMY');
INSERT INTO airplane_capacity (airplane_id, capacity, travel_class) VALUES (4, 20, 'FIRSTCLASS');

INSERT INTO airport (id, airport_code, country, name, region) VALUES (1, 'BRU', 'Belgium', 'Zaventem', 'Europe');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (2, 'AMS', 'Netherlands', 'Schiphol', 'Europe');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (3, 'CDG', 'France', 'Charles de Gaulle', 'Europe');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (4, 'JFK', 'United States', 'John F Kennedy', 'North America');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (5, 'LAX', 'Los Angeles', 'Los Angeles Airport', 'North America');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (6, 'AEP', 'Buenos Aires', 'Aeroparque Jorge Newbery', 'South America');

INSERT INTO customer (id, name, customer_number) VALUES (1, 'Filip', 1234);

INSERT INTO booking (id, date_booking, is_payed, payment_method, price_booking, customer_id) VALUES (2, '2021-01-07', true, 'CREDITCARD', 250, 1);

INSERT INTO discount (id, togeth_air_rate) VALUES (1, 5);

INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 6, 'HOLIDAY');
INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 4, 'NIGHT');
INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 5, 'REGULAR');
INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 8, 'WEEKEND');

INSERT INTO discount_travel_class_rate (discount_id, travel_class_rate, travel_class) VALUES (1, 4, 'BUSINESS');
INSERT INTO discount_travel_class_rate (discount_id, travel_class_rate, travel_class) VALUES (1, 2, 'ECONOMY');
INSERT INTO discount_travel_class_rate (discount_id, travel_class_rate, travel_class) VALUES (1, 5, 'FIRSTCLASS');

INSERT INTO togethair.discount_volume_discount (discount_id, volume_discount, volume) VALUES (1, 4, 2);
INSERT INTO togethair.discount_volume_discount (discount_id, volume_discount, volume) VALUES (1, 10, 5);


