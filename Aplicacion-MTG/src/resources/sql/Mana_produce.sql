CREATE TABLE mana_produce(
  nombre_mana VARCHAR(50),
  mana_produce VARCHAR(50),
  PRIMARY KEY (nombre_mana, mana_produce),
  FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)
);