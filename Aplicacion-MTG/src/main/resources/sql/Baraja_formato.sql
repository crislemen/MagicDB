CREATE TABLE baraja_formato(
  codigo_baraja INT,
  formato VARCHAR(50),
  PRIMARY KEY(codigo_baraja, formato),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)
);
