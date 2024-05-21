-- Insertando datos en la tabla Teacher
INSERT INTO teacher (first_name, last_name, email) VALUES ('John', 'Doe', 'john.doe@example.com');
INSERT INTO teacher (first_name, last_name, email) VALUES ('Jane', 'Smith', 'jane.smith@example.com');

-- Insertando datos en la tabla Course
INSERT INTO course (name, teacher_id) VALUES ('Mathematics', 1);
INSERT INTO course (name, teacher_id) VALUES ('Physics', 2);

-- Insertando datos en la tabla course_mentor (tabla de unión Many-to-Many)
INSERT INTO course_mentor (course_id, mentor_id) VALUES (1, 2); -- Jane Smith como mentora de Mathematics
INSERT INTO course_mentor (course_id, mentor_id) VALUES (2, 1); -- John Doe como mentor de Physics

-- Insertando datos en la tabla students
INSERT INTO students (identification, name, last_name) VALUES ('123456789', 'Alice', 'Brown');
INSERT INTO students (identification, name, last_name) VALUES ('987654321', 'Bob', 'Johnson');

-- Insertando datos en la tabla StudentCourseCalification
INSERT INTO student_course_calification (course_id, student_id, calification1, calification2) VALUES (1, 1, 85.0, 90.0);
INSERT INTO student_course_calification (course_id, student_id, calification1, calification2) VALUES (1, 2, 78.0, 82.0);
INSERT INTO student_course_calification (course_id, student_id, calification1, calification2) VALUES (2, 1, 88.0, 91.0);
INSERT INTO student_course_calification (course_id, student_id, calification1, calification2) VALUES (2, 2, 84.0, 89.0);
