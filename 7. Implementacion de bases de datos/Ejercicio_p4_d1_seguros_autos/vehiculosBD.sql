create database vehiculosBD;
use vehiculosBD;

-- Insertar registros en la tabla Vehiculo
INSERT INTO vehiculos (matricula, patente, marca, modelo, agno_fabricacion, num_ruedas) VALUES
('ABC123', 'XYZ123', 'Toyota', 'Corolla', 2010, 4),
('DEF456', 'LMN456', 'Honda', 'Civic', 2012, 4),
('GHI789', 'OPQ789', 'Ford', 'Focus', 2015, 4);

-- Insertar registros en la tabla Siniestro
INSERT INTO siniestros (fecha_siniestro, perdida_economica, id) VALUES
('2023-01-10', 112000.50, 1),
('2023-02-15', 125000.75, 1),
('2023-03-20', 80200.00, 1),
('2023-04-25', 200200.00, 2),
('2023-05-30', 95020.25, 3);
