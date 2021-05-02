DROP DATABASE IF EXISTS magic;
CREATE DATABASE IF NOT EXISTS magic;

USE magic;

CREATE TABLE baraja(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    precio FLOAT,
    numero_cartas INT,
    balance_mana INT 
);
CREATE TABLE baraja_formato(
    codigo_baraja INT,
    formato VARCHAR(50),
    PRIMARY KEY(codigo_baraja,formato),
    FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)  
);
CREATE TABLE baraja_colores(
    codigo_baraja INT,
    colores VARCHAR(30),
    PRIMARY KEY (codigo_baraja,colores),
    FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo) 
);
CREATE TABLE mana(
    nombre VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(30),
    descripcion VARCHAR(150)  
);
CREATE TABLE baraja_mana(
    codigo_baraja INT,
    nombre_mana VARCHAR(50),
    PRIMARY KEY (codigo_baraja,nombre_mana),
    FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),
    FOREIGN KEY (nombre_mana) REFERENCES mana(nombre) 
);
CREATE TABLE mana_produce(
    nombre_mana VARCHAR(50),
    mana_produce VARCHAR(50),
    PRIMARY KEY (nombre_mana,mana_produce),
    FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)  
);
CREATE TABLE artista(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido1 VARCHAR(50),
    apellido2 VARCHAR(50),
    numero_artes INT     
);
CREATE TABLE formato(
    nombre VARCHAR(50) PRIMARY KEY,
    descripcion VARCHAR(150), 
    baneo BOOLEAN
);
CREATE TABLE expansion(
    simbolo CHAR PRIMARY KEY,
    nombre VARCHAR(50),
    fecha_lanzamiento DATE    
);
CREATE TABLE carta(
    nombre VARCHAR(80) PRIMARY KEY,
    tipo VARCHAR(20),
    descripcion VARCHAR(150),
    coste_mana INT,
    fuerza INT,
    resistencia INT,
    precio FLOAT,
    codigo_artista INT,
    nombre_formato VARCHAR(50),
    simbolo_expansion CHAR,
    FOREIGN  KEY (codigo_artista) REFERENCES artista(codigo),
    FOREIGN KEY (nombre_formato) REFERENCES formato(nombre),
    FOREIGN KEY (simbolo_expansion) REFERENCES expansion(simbolo)          
);
CREATE TABLE baraja_carta(
    codigo_baraja INT,
    nombre_carta VARCHAR(80),
    PRIMARY KEY (codigo_baraja,nombre_carta),
    FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),
    FOREIGN KEY (nombre_carta) REFERENCES carta(nombre) 
);