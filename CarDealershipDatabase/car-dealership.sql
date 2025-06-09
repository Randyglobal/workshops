use car_dealership;

-- create table dealership (
-- dealership_id int NOT NULL auto_increment,
-- d_name varchar(50) NOT NULL,
-- address varchar(50) NOT NULL,
-- phone varchar(50) NOT NULL,
-- primary key(dealership_id)
-- );

-- create table vehicles (
-- vin varchar(17) NOT NULL,
-- make varchar(50) NOT NULL,
-- model varchar(50) NOT NULL,
-- color varchar(50) NOT NULL,
-- v_year int NOT NULL,
-- mileage int NOT NULL,
-- price decimal(10, 2) NOT NULL,
-- primary key(vin)
-- );

-- create table inventory (
-- dealership_id int NOT NULL auto_increment,
-- vin varchar(17),
-- primary key(dealership_id, vin),
-- foreign key(dealership_id) references dealership(dealership_id),
-- foreign key(vin) references vehicles(vin)
-- );

-- create table customers(
--  id int Not null auto_increment,
--  FirstName varchar(50) not null,
--  LastName varchar(50) not null,
--  phone varchar(50) not null,
--  primary key(id)
-- );

-- create table sales_contracts (
-- id int NOT NULL auto_increment,
-- vin varchar(50) NOT NULL,
-- sale_date date,
-- sale_price decimal(10, 2) NOT NULL,
-- customer_id int NOT NULL,
-- salesperson_id int NOT NULL,
-- primary key(id),
-- foreign key(vin) references vehicles(vin),
-- foreign key(customer_id) references customers(id)
-- );

-- create table lease_contracts(
-- id int not null auto_increment,
-- vin varchar(50) not null,
-- lease_start_date date not null,
-- lease_end_date date not null,
-- monthly_payment decimal(10, 2) not null,
-- customer_id int not null,
-- lease_term_months int not null,
-- mileage_allowance int not null,
-- primary key (id),
-- foreign key(vin) references vehicles(vin),
-- foreign key(customer_id) references customers(id)
-- );

-- INSERT INTO dealership (d_name, address, phone) VALUES
-- ('City Auto Mall', '123 Main St, Anytown, CA', '555-1001'),
-- ('Luxury Motors', '45 Park Ave, Metropolis, NY', '555-2002'),
-- ('Economy Cars LLC', '789 Industrial Rd, Smallville, TX', '555-3003'),
-- ('Mountain View Auto', '101 Pine Ln, Evergreen, CO', '555-4004'),
-- ('Coastal Auto Deals', '22 Ocean Dr, Beachfront, FL', '555-5005');


-- INSERT INTO vehicles (vin, make, model, color, v_year, mileage, price) VALUES
-- ('VIN01', 'Toyota', 'Camry', 'Silver', 2022, 15000, 25000.00),
-- ('VIN02', 'Honda', 'Civic', 'Blue', 2023, 8000, 23500.00),
-- ('VIN03', 'Ford', 'F-150', 'Black', 2021, 30000, 45000.00),
-- ('VIN04', 'BMW', 'X5', 'White', 2024, 2500, 68000.00),
-- ('VIN05', 'Nissan', 'Rogue', 'Gray', 2023, 12000, 28000.00),
-- ('VIN06', 'Tesla', 'Model 3', 'Red', 2024, 5000, 42000.00),
-- ('VIN07', 'Jeep', 'Wrangler', 'Green', 2020, 55000, 32000.00);

-- INSERT INTO inventory (dealership_id, vin) VALUES
-- (1, 'VIN01'), 
-- (1, 'VIN02'), 
-- (2, 'VIN03'), 
-- (3, 'VIN04'), 
-- (4, 'VIN05'), 
-- (5, 'VIN06'), 
-- (1, 'VIN07');


-- INSERT INTO customers (FirstName, LastName, phone) VALUES
-- ('Alice', 'Smith', '555-6001'),
-- ('Bob', 'Johnson', '555-6002'),
-- ('Charlie', 'Brown', '555-6003'),
-- ('Diana', 'Prince', '555-6004'),
-- ('Eve', 'Adams', '555-6005');


-- INSERT INTO sales_contracts (vin, sale_date, sale_price, customer_id, salesperson_id) VALUES
-- ('VIN01', '2023-01-15', 24500.00, 1, 101), 
-- ('VIN03', '2023-02-20', 44000.00, 2, 102),
-- ('VIN05', '2023-03-10', 27500.00, 3, 101), 
-- ('VIN02', '2023-04-05', 23000.00, 4, 103), 
-- ('VIN07', '2023-05-12', 31500.00, 5, 102);


-- INSERT INTO lease_contracts (vin, lease_start_date, lease_end_date, monthly_payment, customer_id, lease_term_months, mileage_allowance) VALUES
-- ('VIN04', '2023-06-01', '2026-05-31', 750.00, 1, 36, 12000), 
-- ('VIN06', '2023-07-10', '2026-07-09', 550.00, 3, 36, 10000), 
-- ('VIN01', '2023-08-01', '2025-07-31', 350.00, 2, 24, 15000), 
-- ('VIN02', '2023-09-15', '2024-09-14', 280.00, 5, 12, 8000), 
-- ('VIN03', '2023-10-01', '2026-09-30', 600.00, 4, 36, 12000);

-- 1
-- select * from dealership;

-- 2
-- SELECT
--     dealership.d_name,
--     vehicles.make,
--     vehicles.model,
--     vehicles.vin
-- FROM
--     dealership
-- JOIN
--     inventory ON dealership.dealership_id = inventory.dealership_id
-- JOIN
--     vehicles ON inventory.vin = vehicles.vin
-- WHERE
--     dealership.d_name = 'City Auto Mall';

-- 3
-- select make, model, color from vehicles where vin = "VIN01"

-- 4
-- SELECT
--     dealership.d_name
-- FROM
--     dealership
-- JOIN
--     inventory ON dealership.dealership_id = inventory.dealership_id
-- JOIN
--     vehicles ON inventory.vin = vehicles.vin
-- WHERE
--     vehicles.vin = 'VIN01';

-- 5
-- SELECT DISTINCT
--     dealership.d_name
-- FROM
--     dealership
-- JOIN
--     inventory ON dealership.dealership_id = inventory.dealership_id
-- JOIN
--     vehicles ON inventory.vin = vehicles.vin
-- WHERE
--     vehicles.make = 'Toyota';


-- 6
-- SELECT
--     dealership.d_name AS DealershipName,
--     sales_contracts.id AS ContractID,
--     sales_contracts.sale_date AS SaleDate,
--     sales_contracts.sale_price AS SalePrice,
--     vehicles.make AS VehicleMake,
--     vehicles.model AS VehicleModel,
--     vehicles.vin AS VehicleVIN,
--     vehicles.color AS VehicleColor,
--     vehicles.v_year AS VehicleYear,
--     customers.FirstName AS CustomerFirstName,
--     customers.LastName AS CustomerLastName,
--     customers.phone AS CustomerPhone,
--     sales_contracts.salesperson_id AS SalespersonID
-- FROM
--     sales_contracts
-- JOIN
--     vehicles ON sales_contracts.vin = vehicles.vin
-- JOIN
--     inventory ON vehicles.vin = inventory.vin 
-- JOIN
--     dealership ON inventory.dealership_id = dealership.dealership_id
-- JOIN
--     customers ON sales_contracts.customer_id = customers.id
-- WHERE
--     dealership.dealership_id = 1 
--     AND sales_contracts.sale_date BETWEEN '2023-01-01' AND '2023-12-31';