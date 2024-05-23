INSERT INTO test_case (description, tested, passed, number_of_tries, last_update)
VALUES
    ('Prueba de creación de usuario', TRUE, TRUE, 1, '2024-05-01'),
    ('Verificación de autenticación de usuario', TRUE, TRUE, 2, '2024-05-02'),
    ('Validación de actualización de datos del perfil', FALSE, NULL, 0, '2024-05-03'),
    ('Prueba de eliminación de cuenta de usuario', TRUE, FALSE, 3, '2024-05-04'),
    ('Revisión de recuperación de contraseña', TRUE, TRUE, 2, '2024-05-05'),
    ('Prueba de acceso a endpoint restringido', FALSE, NULL, 0, '2024-05-06'),
    ('Validación de creación de token JWT', TRUE, TRUE, 1, '2024-05-07'),
    ('Prueba de validación de entrada de datos', TRUE, FALSE, 2, '2024-05-08'),
    ('Verificación de logout de usuario', TRUE, TRUE, 1, '2024-05-09'),
    ('Prueba de límite de tasa de solicitudes', TRUE, FALSE, 3, '2024-05-10');