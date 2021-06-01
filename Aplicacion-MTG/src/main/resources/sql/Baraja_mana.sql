CREATE TABLE baraja_mana(
  codigo_baraja INT,
  nombre_mana VARCHAR(50),
  PRIMARY KEY (codigo_baraja, nombre_mana),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),
  FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)
);