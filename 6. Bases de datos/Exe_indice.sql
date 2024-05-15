explain select * from series where title = "The Walking Dead";

-- Le agrege un indice al titulo de las series, ya que una busqueda por titulo va a ser frecuente.
-- Tambien el titulo no va a cambiar nunca, asi que no va a generar costos de mantenimiento.