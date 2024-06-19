INSERT INTO "user" (username, password, firstname, lastname, role) VALUES ('Yair','$2a$10$SdVWxFhSMnE3Nv4oX62mW.jI1JjxX7Hm3A01SNG3fFUKRFterwhru', 'Yair', 'Yair', 'ADMIN'), ('Joaquin','$2a$10$PbX7Eh4lgoHtLn29yhXh/OAmi1v6rJgNhOJvMY68.tdVn9EHhayaC', 'Joaquin', 'Joaquin', 'USER'), ('Isay','$2a$10$EMm5BTDeeW1dboPW9neC5uPqqkIelhzPgODkoB7VnOexlPnzmicpG', 'Isay', 'Isay', 'ADMIN'), ('Mau', '$2a$10$tKLHNnVmtsYJPlGY.7Ry1uxB8ffI.5PO0svtxR5youIYkOA0d9bU.', 'Mau', 'Mau', 'USER'), ('Manu', '$2a$10$GlBJcWCQxMbGQKI.mUb9ruWXFIdnKSvRFpqpHKY5ulAwF.5Qo/On6', 'Manu', 'Manu', 'ADMIN'), ('Gonzalo', '$2a$10$WYfs13zE8caN4RZW4HlSS.ms/g3QIT/Egb9ivEZarcCw/BLixPSeW', 'Gonzalo', 'Gonzalo', 'USER'), ('Leonardo', '$2a$10$7Cb5B/TOf2lGgbudcLb2CO77gabVxJCgwNy8paRzFWvp16pAULcbW', 'Leonardo', 'Leonardo', 'ADMIN'), ('Luis', '$2a$10$nqssWHMDv1N6T017y9nH9Oksh5NMwgQwtQpA/9v/gk1nbRs60f9ye', 'Luis', 'Luis', 'USER'), ('Miguel', '$2a$10$F/R38R6es.5MrbPSHUxvouYekpWLJsdBOEAhwIRmgBs6w3.2S0ZaG', 'Miguel', 'Miguel', 'ADMIN'), ('Natalia', '$2a$10$JSHU1JZAGs4wZbbIPs9RsOPpthRYHRwnNGzXV5HQLPFO0Lxa0C6W.', 'Natalia', 'Natalia', 'USER'), ('Oscar', '$2a$10$Ko6eV85LYvDGO5uMtrlQjeVaMQMdCNE4cI4P6ka9bW7Uhwy5d7aCa', 'Oscar', 'Oscar', 'ADMIN'), ('Pablo', '$2a$10$t5RF8f3wrHNeFB5ZaVrY7On1sh58ovMoLSHE7kMyvRlylnaynZA8O', 'Pablo', 'Pablo', 'USER'), ('Quetzalli', '$2a$10$ah.8LLjnhvsRoz3YNgW6AOL7J3flpAN5XrpLL0d8kdHeJsdmH/Mti', 'Quetzalli', 'Quetzalli', 'ADMIN'), ('Ricardo', '$2a$10$RvLhjYGK8kYx0lkWl68NJuPfvKnGbW9ho/FtPdUnuJUp31dhg.qrG', 'Ricardo', 'Ricardo', 'USER'), ('Sofia', '$2a$10$3zSOf1wqeVH2t/3u6er9NeCW.Yz6yQ/gzH01Zi0EKuBX.sIRj0V1a', 'Sofia', 'Sofia', 'ADMIN'), ('Tania', '$2a$10$O0tyo91998bY1/5ZPcdtOeiuNXqThG6JXBMg/n2T8eF9GSXDmwz5C', 'Tania', 'Tania', 'USER'), ('Uriel', '$2a$10$T3yPmDGY2dKvROlbFqKtG.ThIpyO9Qw3bphCXTK6sJXPv8BmLTnUK', 'Uriel', 'Uriel', 'ADMIN'), ('Valeria', '$2a$10$sHj4lCeDWD.81CACpWHdTu9eIXb/7UW0I1rP4ZkB9DXnj6GfB6EPu', 'Valeria', 'Valeria', 'USER'), ('Wendy', '$2a$10$Pl.aqNvfiS1y2QgOtHqxPeUhNEwOC8Ze2X/wUdbl7oU47UQBBPXOy', 'Wendy', 'Wendy', 'ADMIN'), ('Ximena', '$2a$10$6q/EOeJZD2W.trEaDSEIBuE21/s1ppDAzPLkYpB4fctFyxtGiaSgq', 'Ximena', 'Ximena', 'USER'), ('Yael', '$2a$10$HoIIo6x1XO35cvuwJeezFeXZM6pLu8eENWiizLH/GYeJod1kHsEBu', 'Yael', 'Yael', 'ADMIN'), ('Zoe', '$2a$10$kLdO2PoCGNTGCuNeYsI11u9sLECVp4SYuodH./VcN3S0kSk8VHLmu', 'Zoe', 'Zoe', 'USER'), ('Seller','$2a$10$6.Jiqj4fmjCPb488JouNyO45P9X2rrUnSXd3V2Qewyt.vSUzi9Ph6','Seller','Seller','SELLER');

INSERT INTO warehouse (name) VALUES ('Warehouse 1'), ('Warehouse 2'), ('Warehouse 3'), ('Warehouse 4'), ('Warehouse 5');

INSERT INTO user_warehouse (user_id, warehouse_id) VALUES (1,1),(3,1),(5,1),(7,2),(9,2),(11,2),(13,3),(15,3),(17,4),(19,4),(21,5);

INSERT INTO section (capacity,type,warehouse_id) VALUES (500,'FS',1),(5,'RF',1),(5,'FF',1),(4,'FS',2),(4,'RF',2),(4,'FF',2),(3,'FS',3),(3,'RF',3),(3,'FF',3),(2,'FS',4),(2,'RF',4),(2,'FF',4),(1,'FS',5),(1,'RF',5),(1,'FF',5);

INSERT INTO product (name, price, type, seller_id) VALUES ('Product 1', 10.25, 'FS', 23), ('Product 2', 15.50, 'RF', 23), ('Product 3', 20.75, 'FF', 23), ('Product 4', 25.00, 'FS', 23), ('Product 5', 30.25, 'RF', 23), ('Product 6', 35.50, 'FF', 23), ('Product 7', 40.75, 'FS', 23), ('Product 8', 45.00, 'RF', 23), ('Product 9', 50.25, 'FF', 23), ('Product 10', 55.50, 'FS', 23), ('Product 11', 60.75, 'RF', 23), ('Product 12', 65.00, 'FF', 23), ('Product 13', 70.25, 'FS', 23), ('Product 14', 75.50, 'RF', 23), ('Product 15', 80.75, 'FF', 23), ('Product 16', 85.00, 'FS', 23), ('Product 17', 90.25, 'RF', 23), ('Product 18', 95.50, 'FF', 23), ('Product 19', 100.75, 'FS', 23), ('Product 20', 105.00, 'RF', 23), ('Product 21', 110.25, 'FF', 23), ('Product 22', 115.50, 'FS', 23), ('Product 23', 120.75, 'RF', 23), ('Product 24', 125.00, 'FF', 23), ('Product 25', 130.25, 'FS', 23), ('Product 26', 135.50, 'RF', 23), ('Product 27', 140.75, 'FF', 23), ('Product 28', 145.00, 'FS', 23), ('Product 29', 150.25, 'RF', 23), ('Product 30', 155.50, 'FF', 23);

INSERT INTO inbound_order (inbound_order_id,section_id,user_id,order_date,order_number) VALUES (1,1,1,'2025-01-01',23),(2,1,1,'2025-01-02',44),(3,1,1,'2025-01-03',24),(4,1,1,'2025-01-04',45),(5,1,1,'2025-01-05',25),(6,2,3,'2025-01-01',26),(7,2,3,'2025-01-02',27),(8,3,5,'2025-01-01',28),(9,4,7,'2025-01-01',29),(10,5,9,'2025-01-01',30),(11,6,11,'2025-01-01',31);

INSERT INTO batch_stock(batch_stock_id,current_temperature,minimum_temperature,initial_quantity,current_quantity,manufacturing_date,manufacturing_time,due_date,inbound_order_id,product_id) VALUES (1,10.0,5.0,1,1,'2025-01-01','2025-01-01T10:00:00','2025-01-02',1,1),(2,10.0,5.0,1,1,'2025-01-02','2025-01-02T10:00:00','2025-01-03',2,4),(3,10.0,5.0,1,1,'2025-01-03','2025-01-03T10:00:00','2025-01-04',3,7),(4,10.0,5.0,1,1,'2025-01-04','2025-01-04T10:00:00','2025-01-05',4,10),(5,10.0,5.0,1,1,'2025-01-05','2025-01-05T10:00:00','2025-01-06',5,13),(6,10.0,5.0,2,2,'2025-01-01','2025-01-01T10:00:00','2025-01-02',6,2),(7,10.0,5.0,2,2,'2025-01-02','2025-01-02T10:00:00','2025-01-03',7,5),(8,10.0,5.0,3,3,'2025-01-01','2025-01-01T10:00:00','2025-01-02',8,3),(9,10.0,5.0,2,2,'2025-01-01','2025-01-01T10:00:00','2025-01-02',9,1),(10,10.0,5.0,2,2,'2025-01-01','2025-01-01T10:00:00','2025-01-02',10,2),(11,10.0,5.0,2,2,'2025-01-01','2025-01-01T10:00:00','2025-01-02',11,6);

INSERT INTO cart(cart_date,order_status,total_price,buyer_id) VALUES ('2025-01-10','CARRITO',NULL,2),('2025-01-11','CARRITO',NULL,4),('2025-01-12','CARRITO',NULL,6),('2025-01-13','CARRITO',NULL,8);

INSERT INTO product_in_cart(quantity,product_id,cart_id) VALUES (3,1,1),(3,2,1),(1,13,1),(2,1,2),(10,10,2),(1,7,3);

ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;










