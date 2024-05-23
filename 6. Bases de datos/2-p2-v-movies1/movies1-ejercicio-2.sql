
-- Crear un índice en el campo 'title'
CREATE INDEX idx_title ON movies (title);

-- Verificar la creación del índice
SHOW INDEX FROM movies;
