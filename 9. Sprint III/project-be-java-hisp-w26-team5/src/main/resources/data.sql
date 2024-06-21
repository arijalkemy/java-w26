-- Insert into user_entity
INSERT INTO user_entity (id_user, first_name, last_name, role, username, password, registration_date)
VALUES (718926436, 'John', 'Doe', 'SELLER', 'johndoe', '$2a$12$eXmV975B8NM4gfFghvqJF./xU.mXooIUtgRVpOPTlimxIm44jVjWK', CURRENT_TIMESTAMP),
       (12497864, 'Carlos', 'Alcaraz', 'MANAGER', 'calcaraz', '$2a$12$eXmV975B8NM4gfFghvqJF./xU.mXooIUtgRVpOPTlimxIm44jVjWK', CURRENT_TIMESTAMP);

/*
-- Insert into product
INSERT INTO product (id_product, id_seller, name, description, type, creation_date)
VALUES (1, 718926436, 'Docena de huevos', 'Huevos de gallina de campo 12u.', 'FS', CURRENT_TIMESTAMP);

-- Insert into warehouse
INSERT INTO warehouse (id_warehouse, id_user, name, location)
VALUES (1, 12497864, 'Deposito Principal', 'Avenida Santa Fe 8923'),
(2, 12497864, 'Deposito Sin Uso', 'Avenida Santa Fe 8923');

-- Insert into sector
INSERT INTO sector (id_warehouse, name, type, temperature)
VALUES (1,'Sector Frescos', 'FS', 12),
(1,'Sector Refrigerados', 'RF', 5),
(1,'Sector Congelados', 'FF', 0);
*/
-- Insert into batch
-- INSERT INTO batch (id_batch, batch_number, id_product, id_sector, current_temperature, minimum_temperature, manufacturing_date, manufacturing_time, expiration_date, initial_quantity, current_quantity, entry_date)
-- VALUES (1, 'Batch 1', 1, 1, 20.0, 15.0, '2022-01-01', '2022-01-01 00:00:00', '2023-01-01', 12, 12, CURRENT_TIMESTAMP);