-- Insertar mentores
INSERT INTO mentors (name, last_name, email) VALUES
                                                 ('Mentor 1', 'Apellido 1', 'mentor1@example.com'),
                                                 ('Mentor 2', 'Apellido 2', 'mentor2@example.com'),
                                                 ('Mentor 3', 'Apellido 3', 'mentor3@example.com');

-- Insertar profesores
INSERT INTO teachers (name, last_name, email) VALUES
                                                  ('Profesor 1', 'Apellido 1', 'profesor1@example.com'),
                                                  ('Profesor 2', 'Apellido 2', 'profesor2@example.com'),
                                                  ('Profesor 3', 'Apellido 3', 'profesor3@example.com');

-- Insertar estudiantes
INSERT INTO students (identification, name, last_name) VALUES
                                                           ('ID1', 'Estudiante 1', 'Apellido 1'),
                                                           ('ID2', 'Estudiante 2', 'Apellido 2'),
                                                           ('ID3', 'Estudiante 3', 'Apellido 3');

-- Insertar cursos
INSERT INTO courses (name, teacher_id) VALUES
                                           ('Curso 1', 1),
                                           ('Curso 2', 2),
                                           ('Curso 3', 3);

-- Insertar relaciones entre cursos y mentores
INSERT INTO courses_mentors (course_id, mentor_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 2),
                                                       (3, 3);

-- Insertar relaciones entre estudiantes y cursos con calificaciones
INSERT INTO student_course (calification1, calification2, course_id, student_id) VALUES
                                                                                     (9.5, 8.0, 1, 1),
                                                                                     (8.0, 7.2, 1, 2),
                                                                                     (7.2, 6.8, 2, 2),
                                                                                     (6.8, 6.5, 3, 3);
