create database db_example;
select * from clothes;

CREATE DATABASE IF NOT EXISTS db_example;
USE db_example;

-- INSERT
INSERT INTO compras (cliente_id, fecha, total) VALUES
    (1, 20240523.1, 150),
    (2, 20240522.5, 85),
    (1, 20240521.8, 220),
    (3, 20240523.3, 110),
    (2, 20240520.2, 60);
