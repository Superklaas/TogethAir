INSERT INTO airline (id, name) VALUES (1, 'Brussels Airlines');
INSERT INTO airline (id, name) VALUES (2, 'KLM');
INSERT INTO airline (id, name) VALUES (3, 'Air France');
INSERT INTO airline (id, name) VALUES (4, 'Lufthansa');

INSERT INTO airplane (id, brand, model) VALUES (1, 'Boeing', '747');
INSERT INTO airplane (id, brand, model) VALUES (2, 'Boeing', '737');
INSERT INTO airplane (id, brand, model) VALUES (3, 'Airbus', 'A320');
INSERT INTO airplane (id, brand, model) VALUES (4, 'Airbus', 'A380');

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

INSERT INTO airport (id, airport_code, country, name, region) VALUES (1, 'BRU', 'Belgium', 'Brussels', 'Europe');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (2, 'AMS', 'Netherlands', 'Amsterdam', 'Europe');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (3, 'CDG', 'France', 'Paris', 'Europe');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (4, 'JFK', 'United States', 'New York', 'North America');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (5, 'LAX', 'United States', 'Los Angeles', 'North America');
INSERT INTO airport (id, airport_code, country, name, region) VALUES (6, 'AEP', 'Argentina', 'Buenos Aires', 'South America');

INSERT INTO customer (id, name, credit_card_number, expiration_date)
VALUES (1, 'Filip', '4564-7896-8976-9876', '01/12');

INSERT INTO booking (id, date_booking, is_payed, payment_method, price_booking, customer_id) VALUES (1, '2021-01-07', true, 'CREDITCARD', 250, 1);

INSERT INTO discount (id, togeth_air_rate) VALUES (1, 5);

INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 6, 'HOLIDAY');
INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 4, 'NIGHT');
INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 5, 'REGULAR');
INSERT INTO discount_time_category_rate (discount_id, time_category_rate, time_category) VALUES (1, 8, 'WEEKEND');

INSERT INTO discount_travel_class_rate (discount_id, travel_class_rate, travel_class) VALUES (1, 4, 'BUSINESS');
INSERT INTO discount_travel_class_rate (discount_id, travel_class_rate, travel_class) VALUES (1, 2, 'ECONOMY');
INSERT INTO discount_travel_class_rate (discount_id, travel_class_rate, travel_class) VALUES (1, 5, 'FIRSTCLASS');

INSERT INTO discount_volume_discount (discount_id, volume_discount, volume) VALUES (1, 4, 2);
INSERT INTO discount_volume_discount (discount_id, volume_discount, volume) VALUES (1, 10, 5);

INSERT INTO employee_airline (id, name, airline_id) VALUES (1, 'Klaas', 1);

INSERT INTO employee_togethair (id, name) VALUES (1, 'Jonas');

INSERT INTO togethair.flight (id, arrival_time, base_price, departure_time, airline_id, airplane_id, departure_id, destination_id, discount_id)
VALUES (1, '2021-01-10 10:52:14', 200, '2021-01-09 19:52:21', 1, 2, 1, 5, 1);
INSERT INTO togethair.flight (id, arrival_time, base_price, departure_time, airline_id, airplane_id, departure_id, destination_id, discount_id)
VALUES (2, '2021-01-21 13:43:53', 50, '2021-01-21 11:43:48', 2, 1, 2, 3, 1);
INSERT INTO togethair.flight (id, arrival_time, base_price, departure_time, airline_id, airplane_id, departure_id, destination_id, discount_id)
VALUES (3, '2021-01-21 09:46:24', 300, '2021-01-20 16:46:05', 3, 4, 2, 6, 1);


INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (1, 35, 'BUSINESS');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (1, 267, 'ECONOMY');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (1, 10, 'FIRSTCLASS');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (2, 35, 'BUSINESS');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (2, 267, 'ECONOMY');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (2, 10, 'FIRSTCLASS');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (3, 35, 'BUSINESS');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (3, 267, 'ECONOMY');
INSERT INTO flight_available_seats (flight_id, available_seats, travel_class) VALUES (3, 10, 'FIRSTCLASS');


INSERT INTO passenger (id, name) VALUES (1, 'Jezus');

INSERT INTO ticket (id, travel_class, booking_id, flight_id, passenger_id) VALUES (1, 'ECONOMY', 1, 1, 1);




