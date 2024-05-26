Drop database movies_db;
create database movies_db;
use movies_db;

INSERT INTO `genres` (`created_at`, `updated_at`, `name`, `ranking`, `active`) VALUES
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Action', 1, 1),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Comedy', 2, 1),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Drama', 3, 1),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Thriller', 4, 1);

-- Insertar datos en la tabla movies
INSERT INTO `movies` (`created_at`, `updated_at`, `title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) VALUES
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'The Shawshank Redemption', 9.3, 7, '1994-09-23 00:00:00', 142, 3),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Inception', 8.8, 4, '2010-07-16 00:00:00', 148, 1),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'The Godfather', 9.2, 5, '1972-03-24 00:00:00', 175, 3);

-- Insertar datos en la tabla actors
INSERT INTO `actors` (`created_at`, `updated_at`, `first_name`, `last_name`, `rating`, `favorite_movie_id`) VALUES
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Tom', 'Hanks', 8.5, 1),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Jennifer', 'Aniston', 7.9, 2),
('2024-05-25 09:00:00', '2024-05-25 09:00:00', 'Bryan', 'Cranston', 8.8, 3);

INSERT INTO actor_movie (created_at, updated_at, actor_id, movie_id)
VALUES
    ('2024-05-01 08:00:00', '2024-05-01 08:00:00', 1, 1),
    ('2024-05-02 09:00:00', '2024-05-02 09:00:00', 2, 3),
    ('2024-05-03 10:00:00', '2024-05-03 10:00:00', 3, 2);
    
INSERT INTO `series` (`created_at`, `updated_at`, `title`, `release_date`, `end_date`, `genre_id`) VALUES 
('2024-01-01 00:00:00', '2024-01-01 00:00:00', 'Stranger Things', '2016-07-15 00:00:00', '2024-01-01 00:00:00', 1),
('2024-01-02 00:00:00', '2024-01-02 00:00:00', 'The Witcher', '2019-12-20 00:00:00', '2024-01-01 00:00:00', 2),
('2024-01-03 00:00:00', '2024-01-03 00:00:00', 'Westworld', '2016-10-02 00:00:00', '2022-12-04 00:00:00', 1),
('2024-01-04 00:00:00', '2024-01-04 00:00:00', 'Black Mirror', '2011-12-04 00:00:00', '2023-06-15 00:00:00', 2),
('2024-01-05 00:00:00', '2024-01-05 00:00:00', 'The Mandalorian', '2019-11-12 00:00:00', '2024-01-01 00:00:00', 3),
('2024-01-06 00:00:00', '2024-01-06 00:00:00', 'Dark', '2017-12-01 00:00:00', '2020-06-27 00:00:00', 1);


INSERT INTO `seasons` (`id`, `created_at`, `updated_at`, `title`, `number`, `release_date`, `end_date`, `serie_id`) VALUES 
(1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 'Season 1', 1, '2016-07-15 00:00:00', '2016-08-15 00:00:00', 1),
(2, '2024-01-02 00:00:00', '2024-01-02 00:00:00', 'Season 1', 1, '2019-12-20 00:00:00', '2020-01-20 00:00:00', 2),
(3, '2024-01-03 00:00:00', '2024-01-03 00:00:00', 'Season 1', 1, '2016-10-02 00:00:00', '2016-11-02 00:00:00', 3),
(4, '2024-01-04 00:00:00', '2024-01-04 00:00:00', 'Season 1', 1, '2011-12-04 00:00:00', '2012-01-04 00:00:00', 4);

INSERT INTO `episodes` (`id`, `created_at`, `updated_at`, `title`, `number`, `release_date`, `rating`, `season_id`) VALUES 
(1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 'Episode 1', 1, '2016-07-15 00:00:00', 9.0, 1),
(2, '2024-01-02 00:00:00', '2024-01-02 00:00:00', 'Episode 2', 2, '2016-07-22 00:00:00', 8.5, 1),
(3, '2024-01-03 00:00:00', '2024-01-03 00:00:00', 'Episode 1', 1, '2019-12-20 00:00:00', 8.7, 2),
(4, '2024-01-04 00:00:00', '2024-01-04 00:00:00', 'Episode 2', 2, '2019-12-27 00:00:00', 8.6, 2),
(5, '2024-01-05 00:00:00', '2024-01-05 00:00:00', 'Episode 1', 1, '2016-10-02 00:00:00', 8.8, 3),
(6, '2024-01-06 00:00:00', '2024-01-06 00:00:00', 'Episode 2', 2, '2016-10-09 00:00:00', 8.9, 3);

INSERT INTO `actor_episode` (`id`, `created_at`, `updated_at`, `actor_id`, `episode_id`) VALUES 
(1, '2024-01-01 00:00:00', '2024-01-01 00:00:00', 1, 1),
(2, '2024-01-02 00:00:00', '2024-01-02 00:00:00', 2, 2),
(3, '2024-01-03 00:00:00', '2024-01-03 00:00:00', 3, 3);
