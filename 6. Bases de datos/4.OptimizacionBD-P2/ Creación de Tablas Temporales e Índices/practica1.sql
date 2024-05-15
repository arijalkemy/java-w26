
-- PRACTICA: CREACION DE DTABLAS TEMPRALES E INDICES
USE movies_db;

-- EJERCICIO 1

-- 1. CREAR TABLA TEMPORAL TWD
CREATE TEMPORARY TABLE TWD
(
    id           int unsigned auto_increment
        primary key,
    created_at   timestamp     null,
    updated_at   timestamp     null,
    title        varchar(500)  null,
    number       int unsigned  null,
    release_date datetime      not null,
    rating       decimal(3, 1) not null,
    season       int unsigned  null
);

INSERT INTO TWD (SELECT e.id,
                        e.created_at,
                        e.updated_at,
                        e.title,
                        e.number,
                        e.release_date,
                        e.rating,
                        s.number as season
                 FROM episodes e
                          INNER JOIN seasons s ON e.season_id = s.id
                          INNER JOIN series se ON s.serie_id = se.id
                 WHERE se.title LIKE 'The Walking Dead');

-- 2. REALIZAR UNA CONSULTA PARA VER LOS EPISODIOS DE LA TEMPORADA 1
SELECT t.*
FROM TWD t
WHERE t.season = 1;

-- EJERCICIO 2
-- 1.
ALTER TABLE seasons
    ADD INDEX seasons_idx (number);
ALTER TABLE series
    ADD INDEX series_title_idx (title);

EXPLAIN
SELECT *
FROM seasons
WHERE number = 1;
-- 2. # Los indices los colocamos porque las capitulos asociados a una temporada no cambian
-- Ademas, es posible que sea un dato de alta concurrencia entre los usuarios, por ende optimizar su consulta puede mejorar el rendmiento del sistema. 
