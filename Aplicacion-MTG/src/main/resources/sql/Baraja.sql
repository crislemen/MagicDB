CREATE TABLE if not exists baraja(
  codigo INT PRIMARY KEY,
  nombre VARCHAR(50),
  precio FLOAT,
  numero_cartas INT,
  balance_mana INT
);