-- Alter Table Statements

ALTER TABLE bikeRentals
RENAME TO bike_rentals;

ALTER TABLE bikes
ADD COLUMN properties JSON;

ALTER TABLE feedback
MODIFY COLUMN comments VARCHAR(1000);

ALTER TABLE bikes
CHANGE COLUMN model brand VARCHAR(50) NOT NULL; 

ALTER TABLE bikes
DROP COLUMN properties;

ALTER TABLE bikes
ADD COLUMN properties JSON NOT NULL AFTER model;

-- Insert Statements

INSERT INTO users (first_name, last_name, email, date_registered)
VALUES ('Savannah', 'Robins', 'savrobins24@gmail.com', '2022-10-22');

INSERT INTO stations (name, location, capacity)
VALUES ('Town Market', POINT(42.0980, 19.0994), 12);

INSERT INTO bikes (brand, properties, status, current_station_id)
VALUES ('CityBikeCo', '{"model": "UrbanCruiser",
			"frameMaterial": "Steel",
			"wheelSize": "26 inches",
			"gears": 7,
			"brakeType": "Rim brakes",
			"suspension": false,
			"basketIncluded": true
			}', 
                        'AVAILABLE',
                        1);

INSERT INTO bike_rentals(time_start, time_end, cost, user_id, bike_id, station_start_id, station_end_id)
VALUES ('2023-05-30 10:30:00', '2023-05-30 10:42:00', 0.24, 2, 1, 1, 2);

INSERT INTO rental_transactions (date, amount, type, user_id, rental_id)
VALUES ('2023-05-30 10:43:00', 0.24, 'Cash', 2, 1);

INSERT INTO passes (type, price, valid_from, valid_to, user_id) 
VALUES ('Monthly', 120.00, '2023-07-01', '2023-08-01', 1);

INSERT INTO events (name, date, location, organizer_id)
VALUES ('City Marathon', '2023-07-14', POINT(42.1036, 19.0930), 1);

INSERT INTO feedback (date, rating, comments, user_id)
VALUES ('2023-05-31', 5, "I had an amazing experience with the bike rental service. 
			 The bikes were in excellent condition, 
                         and the rental process was seamless and convenient.",
                         2);

INSERT INTO pass_bike_rentals (time_start, time_end, bikes_bike_id, station_start_id, station_end_id, passes_pass_id)
VALUES ('2023-05-29 14:40:00', '2023-05-29 15:20:00', 2, 2, 3, 1);

INSERT INTO pass_transactions(date, type, amount, user_id, pass_id)
VALUES ('2023-05-20 10:30:00', 'Credit card', 120.00, 1, 1);

-- Update Statements

UPDATE passes
SET type = 'Annual'
WHERE pass_id = 1;

UPDATE users
SET email = 'percolicmonte@gmail.com'
WHERE user_id = 3;

UPDATE bikes
SET status = 'RENTED'
WHERE bike_id = 1;

UPDATE rental_transactions
SET date = '2023-05-30 10:50:00'
WHERE user_id = 
	    (SELECT user_id
            FROM users
            WHERE last_name = "Smith");

UPDATE events
SET date = '2023-07-14 16:00:00' 
WHERE event_id = 1;

UPDATE feedback
SET rating = 4
WHERE feedback_id = 1;

UPDATE stations
SET capacity = 8
WHERE station_id = 3;

UPDATE pass_transactions
SET amount = 118
WHERE user_id = 
(SELECT user_id
 FROM users
 WHERE first_name = 'Savannah' AND last_name = "Robins");

UPDATE bikes
SET properties = JSON_SET(properties, '$.gears', 8)
WHERE bike_id = 1;

UPDATE bikes
SET properties = JSON_SET(properties, '$.wheelSize', '27.5 inches')
WHERE bike_id = 2;

-- Delete Statements

DELETE from users
WHERE user_id = 4;

DELETE from feedback
WHERE user_id = 1;

DELETE FROM events
WHERE event_id = 2;

DELETE FROM rental_transactions 
WHERE user_id = 
	(SELECT user_id
 	FROM users
 	WHERE first_name = 'Jasmina');

DELETE FROM bikes
WHERE bike_id = 3;

DELETE FROM maintenance 
WHERE maintenance_id = 2;

DELETE FROM events 
WHERE organizer_id = 
	(SELECT user_id
 	FROM users
 	WHERE last_name = 'Robins');

DELETE FROM stations
WHERE station_id = 4;

DELETE FROM maintenance 
	WHERE technician_id = 
	(SELECT technician_id
	FROM technicians
	WHERE last_name = 'Brown');

DELETE FROM passes
WHERE user_id = 5;

-- Join all tables in the database

SELECT * FROM users u
LEFT JOIN bike_rentals br USING (user_id)
LEFT JOIN rental_transactions rt ON rt.rental_id = br.rental_id
LEFT JOIN bikes USING (bike_id)
LEFT JOIN stations s ON bikes.current_station_id = s.station_id
LEFT JOIN passes p ON p.user_id = u.user_id
LEFT JOIN pass_bike_rentals pbr ON p.pass_id = pbr.passes_pass_id
LEFT JOIN pass_transactions pt ON pt.pass_id = p.pass_id
LEFT JOIN bikes b2 ON pbr.bikes_bike_id = b2.bike_id
LEFT JOIN stations s1 ON s1.station_id = b2.current_station_id
LEFT JOIN maintenance m ON m.bike_id = bikes.bike_id
LEFT JOIN technicians t USING (technician_id)
LEFT JOIN feedback f ON f.user_id = u.user_id
LEFT JOIN events e ON e.organizer_id = u.user_id;

-- Statements with JOINs

SELECT event_id,
       name AS 'event_name', 
       date AS 'event_date', 
       CONCAT(u.first_name, ' ', u.last_name) AS event_organizer,
       email AS 'organizer_email'
FROM events e
JOIN users u
ON e.organizer_id = u.user_id;

SELECT rental_id, cost, first_name, last_name
FROM bike_rentals
RIGHT JOIN users
USING (user_id)
WHERE cost > 0.30;

SELECT rental_id, cost, first_name, last_name
FROM bike_rentals
LEFT JOIN users
USING (user_id);

SELECT u.user_id, first_name, last_name, rating, comments
FROM users u
JOIN feedback f
ON u.user_id = f.user_id;

SELECT station_id, name, location, capacity, brand, status
FROM stations s
LEFT JOIN bikes b
ON s.station_id = b.current_station_id
UNION
SELECT station_id, name, location, capacity, brand, status
FROM stations s
RIGHT JOIN bikes b
ON s.station_id = b.current_station_id;

SELECT maintenance_id, date_start, description, first_name, last_name, phone_number
FROM maintenance
JOIN technicians
USING (technician_id)
WHERE date_end IS NULL;

SELECT pass_id, 
       p.type AS pass_type,
       date AS transaction_date, 
       pt.type AS transaction_type, 
       amount,
       first_name, 
       last_name
FROM passes p
JOIN pass_transactions pt
USING (pass_id)
JOIN users u
ON pt.user_id = u.user_id;

-- Statements with Aggregate functions AND GROUP BY without HAVING

SELECT user_id, SUM(cost) AS total
FROM bike_rentals
GROUP BY user_id 
ORDER BY total DESC;

SELECT SUM(capacity) AS total_capacity,
       AVG(capacity) AS average_capacity,
       MAX(capacity) AS maximum_capacity,
       MIN(capacity) AS minimum_capacity
FROM stations;

SELECT u.user_id, u.first_name, u.last_name, AVG(br.cost) AS average_cost
FROM users u
LEFT JOIN bike_rentals br ON u.user_id = br.user_id
GROUP BY u.user_id, u.first_name, u.last_name;

SELECT u.user_id, first_name, last_name, COUNT(br.rental_id) AS total_rentals
FROM users u
LEFT JOIN bike_rentals br ON u.user_id = br.user_id
GROUP BY u.user_id, u.first_name, u.last_name;

SELECT u.user_id, first_name, last_name, COUNT(e.event_id) AS total_events
FROM users u
LEFT JOIN events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.first_name, u.last_name;

SELECT p.type, SUM(pt.amount) AS total_revenue
FROM passes p
LEFT JOIN pass_transactions pt ON p.pass_id = pt.pass_id
GROUP BY p.type;

SELECT b.brand, COUNT(br.rental_id) AS total_rentals, MAX(br.cost) AS max_cost
FROM bikes b
LEFT JOIN bike_rentals br ON b.bike_id = br.bike_id
GROUP BY b.brand
ORDER BY total_rentals;

-- Statements with Aggregate functions AND GROUP BY WITH HAVING

SELECT user_id, SUM(cost) AS total
FROM bike_rentals
GROUP BY user_id
HAVING total > 100 
ORDER BY total DESC;

SELECT u.user_id, u.first_name, u.last_name, AVG(br.cost) AS average_cost
FROM users u
LEFT JOIN bike_rentals br ON u.user_id = br.user_id
GROUP BY u.user_id, u.first_name, u.last_name
HAVING average_cost >= 20;

SELECT s.station_id, s.name, COUNT(b.bike_id) AS bike_count
FROM stations s
LEFT JOIN bikes b ON s.station_id = b.current_station_id
GROUP BY s.station_id, s.name
HAVING bike_count > 4
ORDER BY bike_count DESC;

SELECT t.technician_id, first_name, last_name, COUNT(m.bike_id) AS maintenance_count
FROM technicians t
LEFT JOIN maintenance m ON t.technician_id = m.technician_id
GROUP BY t.technician_id, t.first_name, t.last_name
HAVING maintenance_count >= 3;

SELECT u.user_id, first_name, last_name, COUNT(br.rental_id) AS rental_count
FROM users u
LEFT JOIN bikeRentals br ON u.user_id = br.user_id
GROUP BY u.user_id, u.first_name, u.last_name
HAVING rental_count > 5;

SELECT p.type, SUM(pt.amount) AS total_revenue
FROM passes p
LEFT JOIN pass_transactions pt ON p.pass_id = pt.pass_id
GROUP BY p.type
HAVING total_revenue > 100;

SELECT u.user_id, first_name, last_name, COUNT(e.event_id) AS total_events
FROM users u
LEFT JOIN events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.first_name, u.last_name
HAVING total_events >= 2
ORDER BY total_events DESC;
