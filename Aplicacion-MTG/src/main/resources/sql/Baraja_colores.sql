CREATE TABLE baraja_colores(
  codigo_baraja INT,
  colores VARCHAR(30),
  PRIMARY KEY (codigo_baraja, colores),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)
);