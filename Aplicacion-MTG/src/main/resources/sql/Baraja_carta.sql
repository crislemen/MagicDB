CREATE TABLE baraja_carta(
  codigo_baraja INT,
  codigo_carta INT,
  PRIMARY KEY (codigo_baraja, codigo_carta),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),
  FOREIGN KEY (codigo_carta) REFERENCES carta(id)
);