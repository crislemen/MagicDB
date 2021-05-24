
DROP DATABASE IF EXISTS magic;
CREATE DATABASE IF NOT EXISTS  magic CHARACTER SET utf8 COLLATE utf8_general_ci;

USE magic;
CREATE TABLE baraja(
  codigo INT PRIMARY KEY,
  nombre VARCHAR(50),
  precio FLOAT,
  numero_cartas INT,
  balance_mana INT
);

CREATE TABLE artista(
  codigo INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  numero_artes INT
);

CREATE TABLE formato(
  nombre VARCHAR(50) PRIMARY KEY,
  descripcion VARCHAR(350),
  baneo BOOLEAN
); 

CREATE TABLE mana(
  nombre VARCHAR(50) PRIMARY KEY,
  tipo VARCHAR(30),
  descripcion VARCHAR(150)
);

CREATE TABLE expansion(
  simbolo VARCHAR(3) PRIMARY KEY,
  nombre VARCHAR(50),
  fecha_lanzamiento DATE
);

CREATE TABLE baraja_formato(
  codigo_baraja INT,
  formato VARCHAR(50),
  PRIMARY KEY(codigo_baraja, formato),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)
);


CREATE TABLE baraja_colores(
  codigo_baraja INT,
  colores VARCHAR(30),
  PRIMARY KEY (codigo_baraja, colores),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo)
);


CREATE TABLE baraja_mana(
  codigo_baraja INT,
  nombre_mana VARCHAR(50),
  PRIMARY KEY (codigo_baraja, nombre_mana),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),
  FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)
);

CREATE TABLE mana_produce(
  nombre_mana VARCHAR(50),
  mana_produce VARCHAR(50),
  PRIMARY KEY (nombre_mana, mana_produce),
  FOREIGN KEY (nombre_mana) REFERENCES mana(nombre)
);

CREATE TABLE carta(
  id INT PRIMARY KEY, 
  nombre_carta VARCHAR(80),
  tipo TEXT,
  simbolo_expansion VARCHAR(3),
  rareza CHAR,  
  coste_mana TEXT,
  coste_mana_convertido INT, 
  fuerza TEXT,
  resistencia TEXT ,
  loyalty INT, 
  descripcion TEXT,
  codigo_artista INT,
  color TEXT, 
  generated_mana text,
  nombre_formato VARCHAR(50),  
  FOREIGN KEY (codigo_artista) REFERENCES artista(codigo),
  FOREIGN KEY (nombre_formato) REFERENCES formato(nombre),
  FOREIGN KEY (simbolo_expansion) REFERENCES expansion(simbolo)
);

CREATE TABLE baraja_carta(
  codigo_baraja INT,
  codigo_carta INT,
  PRIMARY KEY (codigo_baraja, codigo_carta),
  FOREIGN KEY (codigo_baraja) REFERENCES baraja(codigo),
  FOREIGN KEY (codigo_carta) REFERENCES carta(id)
);

-- INSERTS DE BARAJA --
INSERT INTO baraja VALUES(1, "golgari", 120, 100, 40);
INSERT INTO baraja VALUES(2, "boltron", 100, 100, 35);
INSERT INTO baraja VALUES(3, "artefactos", 90, 60, 22);
INSERT INTO baraja VALUES(4, "caballeros", 250.200, 100, 37);
INSERT INTO baraja VALUES(5, "zombies", 400.100, 100, 38);
-- END --

-- INSERTS DE ARTISTA --
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Nils","Hamm",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jim","Nelson",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Volkan","Baga",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Erica","Yang",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Daniel","Ljunggren",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Yan","Li",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Ryan","Pancoast",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Chris","Rallis",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Eytan","Zana",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Howard","Lyon",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("John","Stanko",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Daarken",null,4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Miles","Johnston",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Bastien L.","Deharme",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jonas","De Ro",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Marco","Nelor",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("John","Avon",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Greg","Staples",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Ryan","Yee",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Seb","Mckinnon",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Kev","Walker",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jaime","Jones",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Cliff","Childs",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Johannes","Voss",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Lius","Lasahido",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Scott","Murphy",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("David","Gaillet",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("D. Alexander","Gregory",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("James","Paick",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("James","Zapata",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Peter","Mohrbacher",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Steve","Belledin",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Chase","Stone",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Paolo","Parente",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Ted","Galaday",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Torstein","Nordstrand",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Julie","Dillon",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Mark","Zug",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Sam","Burley",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Kekai","Kotaki",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES (" Victor Adame","Minguez",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("James","Ryman",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Viktor","Titov",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Christopher","Moeller",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Matt","Cavotta",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jason","Rainville",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Vincent","Proce",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Magali","Villeneuve",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Svetlin","Velinov",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Josu","Hernaiz",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Anthony","Palumbo",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jason A.","Engle",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jeff","Simpson",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Matt","Stewart",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Mike","Bierek",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Yeong-Hao","Han",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Adam","Paquette",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Donato","Giancola",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jakub","Kasper",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Mark","Winters",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Raymond","Swanland",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("QuINTOn","Hoover",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Karla","Ortiz",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Warren","Mahy",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Rob","Alexander",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jim","Murray",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Lucas","Graciano",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Mathias","Kollros",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Allen","Williams",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Johann","Bodin",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("rk ","Post",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Steve","Luke",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Philip","Straub",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Carl","Critchlow",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Ryan","Yee",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jeremy","Jarvis",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Vance","Kovacs",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Min","Yum",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Wesley","Burt",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Izzy",null,3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Steve","Argyle",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Raoul","Vitale",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Pete","Venters",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jesper","Ejsing",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("David","Palumbo",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Sam","Wood",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Todd","Lockwood",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Lars","Grant-West",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Andrew","Robinson",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Terese","Nielsen",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Titus","Lunter",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Christine","Choi",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Dave","Kendall",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jasper","Sandner",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Cyril","Van der Haegen",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Filip","Burburan",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Slawomir","Maniak",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Tyler","Jacobson",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Aaron","Miller",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Goran","Josic",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Steve","Prescott",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jason","Felix",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Anthony S.","Waters",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Noah","Bradley",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Michael","Komarck",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Dan","Frazier",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Larry","Elmore",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Deruchenko","Alexander",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Joseph","Meehan",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Eric","Deschamps",6);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Aleksi","Briclot",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Lake","Hurwitz",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Anastasia","Ovchinnikova",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Zack","Stella",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Lindsey","Look",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Richard","Wright",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Cynthia","Sheppard",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Zoltan","Boros",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Dan","Scott",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Chris","Rahn",4);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Anna","Steinbauer",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Kieran","Yanner",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Willian","Murai",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Rebecca","Guay",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("John","Severin",1);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Jack","Wang",3);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Eric","Velhagen",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Winona","Nelson",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Igor","Kieryluk",10);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Craig J","Spearin",2);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Clint","Cearley",5);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Junq","Park",6);
INSERT INTO artista(nombre,apellido,numero_artes) VALUES ("Karl","Kopinski",4);
-- END --

-- INSERTS DE FORMATO --
INSERT INTO
  formato
VALUES
  (
    'Estándar',
    'El formato estándar usa las colecciones de Magic más recientes',
    true
  );
INSERT INTO
  formato
VALUES
  (
    'Booster Draft',
    'Los jugadores abren sus sobre, y por turnos, eligen cartas de los mismos para construir mazos de 40 cartas',
    false
  );
INSERT INTO
  formato
VALUES(
    'Pauper',
    'Es un formato construido de Magic, en el que sólo se permite el uso de cartas comunes.',
    true
  );
INSERT INTO
  formato
VALUES
  (
    'Mazo Cerrado',
    'Cada jugador abre seis sobres y compite con un mazo compuesto por 40 cartas de esos sobres',
    false
  );
INSERT INTO
  formato
VALUES
  (
    'Modern',
    'Las cartas que van desde la colección basica - Octava edición y Mirrodin hasta la fecha actual son legales en este formato',
    true
  );
INSERT INTO
  formato
VALUES
  (
    'Commander',
    "Cada jugador elige una criatura legendaria como 'comandante' y contruye un mazo de 99 cartas en torno a esa criatura",
    true
  );
INSERT INTO
  formato
VALUES
  (
    'Legacy',
    'Permite cartas de todas las colecciones legales, pero prohíbe ciertas cartas para proporcionar un equilibrio de fuerzas',
    true
  );
INSERT INTO
  formato
VALUES
  (
    'Vintage',
    "Es el más potente de los formatos construidos y permite utilizar las llamadas 'Power 9' nueve poderosas cartas de la historia de Magic",
    true
  );
INSERT INTO
  formato
VALUES
  (
    'Brawl',
    'Brawl se parece un poco a Estándar y otro poco a Commander',
    true
  );
INSERT INTO
  formato
VALUES
  (
    "Gigante de dos cabezas",
    "Dos jugadores comparten turnos y un total de vidas para enfrentarse a otra pareja de jugadores",
    false
  );
INSERT INTO
  formato
VALUES
  (
    "Bloque",
    "Cada bloque de expansiones tiene su propio formato Construido, que solo permite cartas publicadas de las expansiones de dicho bloque",
    true
  );
INSERT INTO
  formato
VALUES
  (
    "Pioneer",
    "Todos los lanzamientos de Estándar desde Regreso a Rávnica en adelante son legales",
    true
  );
INSERT INTO
  formato
VALUES
  (
    "Formato Conspiracy",
    "Conspiracy es un formato Booster Draft para varios jugadores",
    false
  );
INSERT INTO
  formato
VALUES
  (
    "Cerrado por Equipos",
    "El formato Cerrado por Equipos combina toda la diversion de Mazo Cerrado con dos de tus amigos y te permite construir potentes mazos de 40 cartas para jugar en equipo",
    false
  );
-- END --

-- ISNERTS DE MANA --
INSERT INTO mana VALUES ('Bosque','Tierra Basica',null);
INSERT INTO mana VALUES ('Montania','Tierra Basica',null);
INSERT INTO mana VALUES ('Llanura','Tierra Basica',null);
INSERT INTO mana VALUES ('Pantano','Tierra Basica',null);
INSERT INTO mana VALUES ('Isla','Tierra Basica',null);
-- END --

-- INSERTS DE EXPANSION --
INSERT INTO expansion VALUES('ORI', 'Magic Orígenes', '2015-07-08');
-- END --

INSERT INTO baraja_formato VALUES (1, 'Commander');
INSERT INTO baraja_formato VALUES (2, 'Commander');
INSERT INTO baraja_formato VALUES (3, 'Pauper');
INSERT INTO baraja_formato VALUES (4, 'Commander');
INSERT INTO baraja_formato VALUES (5, 'Commander');
-- END --

-- INSERTS DE BARAJA_COLORES --
INSERT INTO baraja_colores VALUES(1, "Azul/Negro");
INSERT INTO baraja_colores VALUES(2, "Azul/Negro");
INSERT INTO baraja_colores VALUES(3, "Rojo/Azul");
INSERT INTO baraja_colores VALUES(4,"Blanco");
INSERT INTO baraja_colores VALUES(5,"Negro");
-- END --

-- INSERTS DE BARAJA_MANA --
INSERT INTO baraja_mana VALUES(1, "Bosque");
INSERT INTO baraja_mana VALUES(2, "Montania");
INSERT INTO baraja_mana VALUES(3, "Llanura");
INSERT INTO baraja_mana VALUES(4, "Pantano");
INSERT INTO baraja_mana VALUES(5, "Isla");
-- END --

-- INSERTS DE MANA_PRODUCE --
INSERT INTO mana_produce VALUES('Bosque','Verde');
INSERT INTO mana_produce VALUES('Montania','Rojo');
INSERT INTO mana_produce VALUES('Llanura','Blanco');
INSERT INTO mana_produce VALUES('Pantano','Negro');
INSERT INTO mana_produce VALUES('Isla','Azul');
-- END --


-- INSERTS DE CARTA --

INSERT INTO
  carta(id,nombre_carta,tipo,simbolo_expansion,rareza,coste_mana,coste_mana_convertido,fuerza,resistencia,loyalty,descripcion,codigo_artista,color,generated_mana,nombre_formato)
VALUES
  (
    398411,
    'Abbot of Keral Keep',
    'Creature — Human Monk',
    'ORI',
    'R',
    '{1}{R}',
    2,
    2,
    1,
    NULL,
    'Prowess #_(Whenever you cast a noncreature spell, this creature gets +1/+1 until end of turn.)_#£When Abbot of Keral Keep enters the battlefield, exile the top card of your library. Until end of turn, you may play that card.',
    
    108,
    'R',
    NULL,
    'Commander'
  ),
  (
    398574,
    'Acolyte of the Inferno',
    'Creature — Human Monk',
    'ORI',
    'U',
    '{2}{R}',
    3,
    3,
    1,
    null,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£Whenever Acolyte of the Inferno becomes blocked by a creature, it deals 2 damage to that creature.',  
    109,
    'R',
    NULL,
    'Commander'
  );
INSERT INTO
  carta(id,nombre_carta,tipo,simbolo_expansion,rareza,coste_mana,coste_mana_convertido,fuerza,resistencia,loyalty,descripcion,codigo_artista,color,generated_mana,nombre_formato)
VALUES
  (
    398578,
    'Act of Treason',
    'Sorcery',
    'ORI',
    'C',
    '{2}{R}',
    3,
    null,
    null,
    null,
    'Gain control of target creature until end of turn. Untap that creature. It gains haste until end of turn. #_(It can attack and {T} this turn.)_#',
    
    110,
    'R',
    NULL,
    'Commander'
  ),
  (
    401452,
    'Aegis Angel',
    'Creature — Angel',
    'ORI',
    'R',
    '{4}{W}{W}',
    6,
    5,
    5,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£When Aegis Angel enters the battlefield, another target permanent gains indestructible for as long as you control Aegis Angel. #_(Effects that say "destroy" don''t destroy it. A creature with indestructible can''t be destroyed by damage.)_#',
    
    111,
    'W',
    NULL,
    'Commander'
  ),
  (
    398565,
    'Aerial Volley',
    'Instant',
    'ORI',
    'C',
    '{G}',
    1,
    null,
    null,
    NULL,
    'Aerial Volley deals 3 damage divided as you choose among one, two, or three target creatures with flying.',
    
    112,
    'G',
    NULL,
    'Commander'
  ),
  (
    398656,
    'Akroan Jailer',
    'Creature — Human Soldier',
    'ORI',
    'C',
    '{W}',
    1,
    1,
    1,
    NULL,
    '{2}{W}, {T}: Tap target creature.',
    
    113,
    'W',
    NULL,
    'Commander'
  ),
  (
    398604,
    'Akroan Sergeant',
    'Creature — Human Soldier',
    'ORI',
    'C',
    '{2}{R}',
    3,
    2,
    2,
    NULL,
    'First strike #_(This creature deals combat damage before creatures without first strike.)_#£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
    
    114,
    'R',
    NULL,
    'Commander'
  ),
  (
    398640,
    'Alchemist''s Vial',
    'Artifact',
    'ORI',
    'C',
    '{2}',
    2,
    NULL,
    NULL,
    NULL,
    'When Alchemist''s Vial enters the battlefield, draw a card.£{1}, {T}, Sacrifice Alchemist''s Vial: Target creature can''t attack or block this turn.',
    
    115,
    'A',
    NULL,
    'Commander'
  ),
  (
    398436,
    'Alhammarret, High Arbiter',
    'Legendary Creature — Sphinx',
    'ORI',
    'R',
    '{5}{U}{U}',
    7,
    5,
    5,
    NULL,
    'Flying£As Alhammarret, High Arbiter enters the battlefield, each opponent reveals their hand. You choose the name of a nonland card revealed this way.£Your opponents can''t cast spells with the chosen name #_(as long as this creature is on the battlefield)_#.',
   
    116,
    'U',
    NULL,
    'Commander'
  ),
  (
    398564,
    'Alhammarret''s Archive',
    'Legendary Artifact',
    'ORI',
    'M',
    '{5}',
    5,
    NULL,
    NULL,
    NULL,
    'If you would gain life, you gain twice that much life instead.£If you would draw a card except the first one you draw in each of your draw steps, draw two cards instead.',
   
    116,
    'A',
    NULL,
    'Commander'
  ),
  (
    398603,
    'Ampryn Tactician',
    'Creature — Human Soldier',
    'ORI',
    'C',
    '{2}{W}{W}',
    4,
    3,
    3,
    NULL,
    'When Ampryn Tactician enters the battlefield, creatures you control get +1/+1 until end of turn.',
    
    117,
    'W',
    NULL,
    'Commander'
  ),
  (
    398474,
    'Anchor to the Aether',
    'Sorcery',
    'ORI',
    'U',
    '{2}{U}',
    3,
    NULL,
    NULL,
    NULL,
    'Put target creature on top of its owner''s library. Scry 1. #_(Look at the top card of your library. You may put that card on the bottom of your library.)_#',
    
    118,
    'U',
    NULL,
    'Commander'
  ),
  (
    398418,
    'Angel''s Tomb',
    'Artifact',
    'ORI',
    'U',
    '{3}',
    3,
    NULL,
    NULL,
    NULL,
    'Whenever a creature enters the battlefield under your control, you may have Angel''s Tomb become a 3/3 white Angel artifact creature with flying until end of turn.',
    
    119,
    'A',
    NULL,
    'Commander'
  ),
  (
    398437,
    'Animist''s Awakening',
    'Sorcery',
    'ORI',
    'R',
    '{X}{G}',
    1,
    null,
    null,
    NULL,
    'Reveal the top X cards of your library. Put all land cards from among them onto the battlefield tapped and the rest on the bottom of your library in a random order.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, untap those lands.',
    
    120,
    'G',
    NULL,
    'Commander'
  ),
  (
    398455,
    'Anointer of Champions',
    'Creature — Human Cleric',
    'ORI',
    'U',
    '{W}',
    1,
    1,
    1,
    NULL,
    '{T}: Target attacking creature gets +1/+1 until end of turn.',
    
    121,
    'W',
    NULL,
    'Commander'
  ),
  (
    398571,
    'Archangel of Tithes',
    'Creature — Angel',
    'ORI',
    'M',
    '{1}{W}{W}{W}',
    4,
    3,
    5,
    NULL,
    'Flying£As long as Archangel of Tithes is untapped, creatures can''t attack you or planeswalkers you control unless their controller pays {1} for each of those creatures.£As long as Archangel of Tithes is attacking, creatures can''t block unless their controller pays {1} for each of those creatures.',
    
    117,
    'W',
    NULL,
    'Commander'
  ),
  (
    398462,
    'Artificers Epiphany',
    'Instant',
    'ORI',
    'C',
    '{2}{U}',
    3,
    NULL,
    NULL,
    NULL ,
    'Draw two cards. If you control no artifacts, discard a card.',
    122,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398674,
    'Aspiring Aeronaut',
    'Creature — Human Artificer',
    'ORI',
    'C',
    '{3}{U}',
    4,
    1,
    2,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£When Aspiring Aeronaut enters the battlefield, create a 1/1 colorless Thopter artifact creature token with flying.',
    
    123,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398678,
    'Auramancer',
    'Creature — Human Wizard',
    'ORI',
    'C',
    '{2}{W}',
    3,
    2,
    2,
    NULL,
    'When Auramancer enters the battlefield, you may return target enchantment card from your graveyard to your hand.',
    
    124,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398667,
    'Avaricious Dragon',
    'Creature — Dragon',
    'ORI',
    'M',
    '{2}{R}{R}',
    4,
    4,
    4,
    NULL,
    'Flying£At the beginning of your draw step, draw an additional card.£At the beginning of your end step, discard your hand.',
    
    120,
    'R',
    NULL,
    'Commander'
    
  ),
  (
    398627,
    'Aven Battle Priest',
    'Creature — Bird Cleric',
    'ORI',
    'C',
    '{5}{W}',
    6,
    3,
    3,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£When Aven Battle Priest enters the battlefield, you gain 3 life.',
    
    6,
    'W',
    NULL,
    'Pauper'
    
  ),
  (
    398417,
    'Battlefield Forge',
    'Land',
    'ORI',
    'R',
    null,
    0,
    null,
    null,
    null,
    '{T}: Add {C}.£{T}: Add {R} or {W}. Battlefield Forge deals 1 damage to you.',
    
    6,
    'L',
    '{R}{W}{C}',
    'Estándar'
  ),
  (
    398439,
    'Bellows Lizard',
    'Creature — Lizard',
    'ORI',
    'C',
    '{R}',
    1,
    1,
    1,
    NULL,
    '{1}{R}: Bellows Lizard gets +1/+0 until end of turn.',
    
    126,
    'R',
    null,
    'Pauper'
  ),
  (
    398660,
    'Blazing Hellhound',
    'Creature — Elemental Dog',
    'ORI',
    'U',
    '{2}{B}{R}',
    4,
    4,
    3,
    NULL,
    '{1}, Sacrifice another creature: Blazing Hellhound deals 1 damage to any target.',
    
    127,
    'RB',
    NULL,
    'Modern'
  ),
  (
    398628,
    'Blessed Spirits',
    'Creature — Spirit',
    'ORI',
    'U',
    '{2}{W}',
    3,
    2,
    2,
    NULL,
    'Flying£Whenever you cast an enchantment spell, put a +1/+1 counter on Blessed Spirits.',
    
    121,
    'W',
    NULL,
    'Brawl'
  ),
  (
    398618,
    'Blightcaster',
    'Creature — Human Wizard',
    'ORI',
    'U',
    '{3}{B}',
    4,
    2,
    3,
    NULL,
    'Whenever you cast an enchantment spell, you may have target creature get -2/-2 until end of turn.',
    
    128,
    'B',
    NULL,
    'Brawl'

  ),
  (
    398527,
    'Blood-Cursed Knight',
    'Creature — Vampire Knight',
    'ORI',
    'U',
    '{1}{W}{B}',
    3,
    3,
    2,
    NULL,
    'As long as you control an enchantment, Blood-Cursed Knight gets +1/+1 and has lifelink. #_(Damage dealt by this creature also causes you to gain that much life.)_#',
    
    128,
    'WB',
    NULL,
    'Brawl'
  ),
  (
    398606,
    'Boggart Brute',
    'Creature — Goblin Warrior',
    'ORI',
    'C',
    '{2}{R}',
    3,
    3,
    2,
    NULL,
    'Menace #_(This creature can''t be blocked except by two or more creatures.)_#',
    
    129,
    'R',
    NULL,
    'Pauper'

  ),
  (
    398665,
    'Bonded Construct',
    'Artifact Creature — Construct',
    'ORI',
    'C',
    '{1}',
    1,
    2,
    1,
    NULL,
    'Bonded Construct can''t attack alone.',
    
    130,
    'A',
    NULL,
    'Pauper'

  ),
  (
    398539,
    'Bone to Ash',
    'Instant',
    'ORI',
    'C',
    '{2}{U}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'Counter target creature spell.£Draw a card.',
    
    131,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398635,
    'Bounding Krasis',
    'Creature — Fish Lizard',
    'ORI',
    'U',
    '{1}{G}{U}',
    3,
    3,
    3,
    NULL,
    'Flash #_(You may cast this spell any time you could cast an instant.)_#£When Bounding Krasis enters the battlefield, you may tap or untap target creature.',
    
    126,
    'GU',
    NULL,
    'Brawl'
  ),
  (
    398532,
    'Brawler''s Plate',
    'Artifact — Equipment',
    'ORI',
    'U',
    '{3}',
    3,
    NULL,
    NULL,
    NULL,
    'Equipped creature gets +2/+2 and has trample. #_(It can deal excess combat damage to the player or planeswalker it''s attacking.)_#£Equip {4} #_({4}: Attach to target creature you control. Equip only as a sorcery.)_#',

    132,
    'A',
    NULL,
    'Brawl'
  ),
  (
    398480,
    'Calculated Dismissal',
    'Instant',
    'ORI',
    'C',
    '{2}{U}',
    3,
    NULL,
    NULL,
    NULL,
    'Counter target spell unless its controller pays {3}.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, scry 2. #_(To scry 2, look at the top two cards of your library, then put any number of them on the bottom of your library and the rest on top in any order.)_#',
    
    133,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398457,
    'Call of the Full Moon',
    'Enchantment — Aura',
    'ORI',
    'U',
    '{1}{R}',
    2,
    NULL,
    NULL,
    NULL, 
    'Enchant creature£Enchanted creature gets +3/+2 and has trample. #_(It can deal excess combat damage to the player or planeswalker it''s attacking.)_#£At the beginning of each upkeep, if a player cast two or more spells last turn, sacrifice Call of the Full Moon.',
    
    1,
    'R',
    NULL,
    'Brawl'
  ),
  (
    398473,
    'Catacomb Slug',
    'Creature — Slug',
    'ORI',
    'C',
    '{4}{B}',
    5,
    2,
    6,
    NULL,
    NULL,
    
    1,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398409,
    'Caustic Caterpillar',
    'Creature — Insect',
    'ORI',
    'C',
    '{G}',
    1,
    1,
    1,
    NULL,
    '{1}{G}, Sacrifice Caustic Caterpillar: Destroy target artifact or enchantment.',
    
    126,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398504,
    'Caves of Koilos',
    'Land',
    'ORI',
    'R',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{T}: Add {W} or {B}. Caves of Koilos deals 1 damage to you.',
    
    2,
    'L',
    '{W}{B}{C}',
    'Commander'
  ),
  (
    398488,
    'Celestial Flare',
    'Instant',
    'ORI',
    'C',
    '{W}{W}',
    2,
    NULL,
    NULL,
    NULL,
    'Target player sacrifices an attacking or blocking creature.',
    
    131,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398422,
    'Chandra, Fire of Kaladesh',
    'Legendary Creature — Human Shaman',
    'ORI',
    'M',
    '{1}{R}{R}',
    3,
    2,
    2,
    NULL,
    'Whenever you cast a red spell, untap Chandra, Fire of Kaladesh.£{T}: Chandra, Fire of Kaladesh deals 1 damage to target player or planeswalker. If Chandra has dealt 3 or more damage this turn, exile her, then return her to the battlefield transformed under her owner''s control.',
    
    110,
    'R',
    NULL,
    'Modern'
  ),
  (
    398423,
    'Chandra, Roaring Flame',
    'Legendary Planeswalker — Chandra',
    'ORI',
    'M',
    NULL,
    NULL,
    NULL,
    4,
    4,
    '+1: Chandra, Roaring Flame deals 2 damage to target player or planeswalker.£−2: Chandra, Roaring Flame deals 2 damage to target creature.£−7: Chandra, Roaring Flame deals 6 damage to each opponent. Each player dealt damage this way gets an emblem with "At the beginning of your upkeep, this emblem deals 3 damage to you."',
    
    110,
    'R',
    NULL,
    'Commander'
  ),
  (
    398632,
    'Chandra''s Fury',
    'Instant',
    'ORI',
    'C',
    '{4}{R}',
    5,
    NULL,
    NULL,
    NULL,
    'Chandra''s Fury deals 4 damage to target player or planeswalker and 1 damage to each creature that player or that planeswalker''s controller controls.',
    
    3,
    'R',
    NULL,
    'Legacy'
  ),
  (
    398416,
    'Chandra''s Ignition',
    'Sorcery',
    'ORI',
    'R',
    '{3}{R}{R}',
    5,
    NULL,
    NULL,
    NULL,
    'Target creature you control deals damage equal to its power to each other creature and each opponent.',
    
    110,
    'R',
    NULL,
    'Brawl'
  ),
  (
    398560,
    'Charging Griffin',
    'Creature — Griffin',
    'ORI',
    'C',
    '{3}{W}',
    4,
    2,
    2,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£Whenever Charging Griffin attacks, it gets +1/+1 until end of turn.',
   
    4,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398581,
    'Chief of the Foundry',
    'Artifact Creature — Construct',
    'ORI',
    'U',
    '{3}',
    3,
    2,
    3,
    NULL,
    'Other artifact creatures you control get +1/+1.',
   
    5,
    'A',
    NULL,
    'Legacy'
  ),
  (
    '398672',
    'Citadel Castellan',
    'Creature — Human Knight',
    'ORI',
    'U',
    '{1}{G}{W}',
    3,
    2,
    3,
    NULL,
    'Vigilance #_(Attacking doesn''t cause this creature to tap.)_#£Renown 2 #_(When this creature deals combat damage to a player, if it isn''t renowned, put two +1/+1 counters on it and it becomes renowned.)_#',
    
    113,
    'GW',
    NULL,
    'Legacy'
  ),
  (
    398542,
    'Clash of Wills',
    'Instant',
    'ORI',
    'U',
    '{X}{U}',
    1,
    NULL,
    NULL,
    NULL,
    'Counter target spell unless its controller pays {X}.',
   
    6,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398607,
    'Claustrophobia',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{1}{U}{U}',
    3,
    NULL,
    NULL,
    NULL,
    'Enchant creature£When Claustrophobia enters the battlefield, tap enchanted creature.£Enchanted creature doesn''t untap during its controller''s untap step.',
    
    7,
    'U',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398451,
    'Cleric of the Forward Order',
    'Creature — Human Cleric',
    'ORI',
    'C',
    '{1}{W}',
    2,
    2,
    2,
    NULL,
    'When Cleric of the Forward Order enters the battlefield, you gain 2 life for each creature you control named Cleric of the Forward Order.',
   
    8,
    'W',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398616,
    'Cobblebrute',
    'Creature — Elemental',
    'ORI',
    'C',
    '{3}{R}',
    4,
    5,
    2,
    NULL,
    NULL,
    
    9,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398419,
    'Conclave Naturalists',
    'Creature — Dryad',
    'ORI',
    'U',
    '{4}{G}',
    5,
    4,
    4,
    NULL,
    'When Conclave Naturalists enters the battlefield, you may destroy target artifact or enchantment.',
    
    10,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398512,
    'Consecrated by Blood',
    'Enchantment — Aura',
    'ORI',
    'U',
    '{2}{B}{B}',
    4,
    NULL,
    NULL,
    NULL,
    'Enchant creature£Enchanted creature gets +2/+2 and has flying and "Sacrifice two other creatures: Regenerate this creature." #_(The next time the creature would be destroyed this turn, it isn''t. Instead tap it, remove all damage from it, and remove it from combat.)_#',
    
    11,
    'B',
    NULL,
    'Commander'
  ),
  (
    398446,
    'Consul''s Lieutenant',
    'Creature — Human Soldier',
    'ORI',
    'U',
    '{W}{W}',
    2,
    2,
    1,
    NULL,
    'First strike£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£Whenever Consul''s Lieutenant attacks, if it''s renowned, other attacking creatures you control get +1/+1 until end of turn.',
    
    12,
    'W',
    NULL,
    'Commander'
  ),
  (
    398415,
    'Cruel Revival',
    'Instant',
    'ORI',
    'U',
    '{4}{B}',
    5,
    NULL,
    NULL,
    NULL,
    'Destroy target non-Zombie creature. It can''t be regenerated. Return up to one target Zombie card from your graveyard to your hand.',
    
    13,
    'B',
    NULL,
    'Brawl'
  ),
  (
    398466,
    'Dark Dabbling',
    'Instant',
    'ORI',
    'C',
    '{2}{B}',
    3,
    NULL,
    NULL,
    NULL,
    'Regenerate target creature. Draw a card. #_(The next time the creature would be destroyed this turn, it isn''t. Instead tap it, remove all damage from it, and remove it from combat.)_#£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, also regenerate each other creature you control.',
    
    14,
    'B',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398525,
    'Dark Petition',
    'Sorcery',
    'ORI',
    'R',
    '{3}{B}{B}',
    5,
    NULL,
    NULL,
    NULL, 
    'Search your library for a card, put that card INTO your hand, then shuffle.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, add {B}{B}{B}.',
    
    129,
    'B',
    '{B}',
    'Commander'
  ),
  (
    398652,
    'Day''s Undoing',
    'Sorcery',
    'ORI',
    'M',
    '{2}{U}',
    3,
    NULL,
    NULL,
    NULL,
    'Each player shuffles their hand and graveyard INTO their library, then draws seven cards. If it''s your turn, end the turn. #_(Exile all spells and abilities from the stack, including this card. Discard down to your maximum hand size. Damage wears off, and "this turn" and "until end of turn" effects end.)_#',
    
    15,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398500,
    'Deadbridge Shaman',
    'Creature — Elf Shaman',
    'ORI',
    'C',
    '{2}{B}',
    3,
    3,
    1,
    NULL,
    'When Deadbridge Shaman dies, target opponent discards a card.',
    
    1,
    'B',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398605,
    'Deep-Sea Terror',
    'Creature — Serpent',
    'ORI',
    'C',
    '{4}{U}{U}',
    6,
    6,
    6,
    NULL,
    'Deep-Sea Terror cant attack unless there are seven or more cards in your graveyard.',
   
    16,
    'U',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398486,
    'Demolish',
    'Sorcery',
    'ORI',
    'C',
    '{3}{R}',
    4,
    NULL,
    NULL,
    NULL,
    'Destroy target artifact or land.',
    
    17,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398433,
    'Demonic Pact',
    'Enchantment',
    'ORI',
    'M',
    '{2}{B}{B}',
    4,
    NULL,
    NULL,
    NULL,
    'At the beginning of your upkeep, choose one that hasnt been chosen — Demonic Pact deals 4 damage to any target and you gain 4 life. Target opponent discards two cards. Draw two cards. You lose the game.',
    
    111,
    'B',
    NULL,
    'Commander'
  ),
  (
    398587,
    'Despoiler of Souls',
    'Creature — Horror',
    'ORI',
    'R',
    '{B}{B}',
    2,
    3,
    1,
    NULL,
    'Despoiler of Souls cant block.£{B}{B}, Exile two other creature cards from your graveyard: Return Despoiler of Souls from your graveyard to the battlefield.',
    
    18,
    'B',
    NULL,
    'Legacy'
  ),
  (
    398583,
    'Disciple of the Ring',
    'Creature — Human Wizard',
    'ORI',
    'M',
    '{3}{U}{U}',
    5,
    3,
    4,
    NULL,
    '{1}, Exile an instant or sorcery card from your graveyard: Choose one — Counter target noncreature spell unless its controller pays {2}. Disciple of the Ring gets +1/+1 until end of turn. Tap target creature. Untap target creature.',
    
    131,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398528,
    'Disperse',
    'Instant',
    'ORI',
    'C',
    '{1}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Return target nonland permanent to its owners hand.',
    
    75,
    'U',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398580,
    'Displacement Wave',
    'Sorcery',
    'ORI',
    'R',
    '{X}{U}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Return all nonland permanents with mana value X or less to their owners hands.',
    
    20,
    'U',
    NULL,
    'Legacy'
  ),
  (
    401453,
    'Divine Verdict',
    'Instant',
    'ORI',
    'C',
    '{3}{W}',
    4,
    NULL,
    NULL,
    NULL,
    'Destroy target attacking or blocking creature.',
    
    21,
    'W',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    1398647,
    'Dragon Fodder',
    'Sorcery',
    'ORI',
    'C',
    '{1}{R}',
    2,
    NULL,
    NULL,
    NULL,
    'Create two 1/1 red Goblin creature tokens.',
    
    22,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398405,
    'Dreadwaters',
    'Sorcery',
    'ORI',
    'C',
    '{3}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'Target player mills X cards, where X is the number of lands you control.',
    
    23,
    'U',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398546,
    'Dwynen, Gilt-Leaf Daen',
    'Legendary Creature — Elf Warrior',
    'ORI',
    'R',
    '{2}{G}{G}',
    4,
    3,
    4,
    NULL,
    'Reach£Other Elf creatures you control get +1/+1.£Whenever Dwynen, Gilt-Leaf Daen attacks, you gain 1 life for each attacking Elf you control.',
   
    24,
    'G',
    NULL,
    'Legacy'
  ),
  (
    398609,
    'Dwynen''s Elite',
    'Creature — Elf Warrior',
    'ORI',
    'U',
    '{1}{G}',
    2,
    2,
    2,
    NULL,
    'When Dwynen''s Elite enters the battlefield, if you control another Elf, create a 1/1 green Elf Warrior creature token.',
    
    25,
    'G',
    NULL,
    'Commander'
  ),
  (
    401454,
    'Eagle of the Watch',
    'Creature — Bird',
    'ORI',
    'C',
    '{2}{W}',
    3,
    2,
    1,
    NULL,
    'Flying, vigilance',
   
    26,
    'W',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398406,
    'Elemental Bond',
    'Enchantment',
    'ORI',
    'U',
    '{2}{G}',
    3,
    NULL,
    NULL,
    NULL,
    'Whenever a creature with power 3 or greater enters the battlefield under your control, draw a card.',
    
    27,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398554,
    'Elvish Visionary',
    'Creature — Elf Shaman',
    'ORI',
    'C',
    '{1}{G}',
    2,
    1,
    1,
    NULL,
    'When Elvish Visionary enters the battlefield, draw a card.',
    
    28,
    'G',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398576,
    'Embermaw Hellion',
    'Creature — Hellion',
    'ORI',
    'R',
    '{3}{R}{R}',
    5,
    4,
    5,
    NULL,
    'Trample #_(This creature can deal excess combat damage to the player or planeswalker it''s attacking.)_#£If another red source you control would deal damage to a permanent or player, it deals that much damage plus 1 to that permanent or player instead.',
   
    29,
    'R',
    NULL,
    'Commander'
  ),
  (
    398414,
    'Enlightened Ascetic',
    'Creature — Cat Monk',
    'ORI',
    'C',
    '{1}{W}',
    2,
    1,
    1,
    NULL,
    'When Enlightened Ascetic enters the battlefield, you may destroy target enchantment.',
   
    30,
    'W',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398654,
    'Enshrouding Mist',
    'Instant',
    'ORI',
    'C',
    '{W}',
    1,
    NULL,
    NULL,
    NULL,
    'Target creature gets +1/+1 until end of turn. Prevent all damage that would be dealt to it this turn. If it''s renowned, untap it.',
    
    10,
    'W',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398493,
    'Enthralling Victor',
    'Creature — Human Warrior',
    'ORI',
    'U',
    '{3}{R}',
    4,
    3,
    2,
    NULL,
    'When Enthralling Victor enters the battlefield, gain control of target creature an opponent controls with power 2 or less until end of turn. Untap that creature. It gains haste until end of turn. #_(It can attack and {T} this turn.)_#',
    
    128,
    'R',
    NULL,
    'Brawl'
  ),
  (
    398584,
    'Erebos''s Titan',
    'Creature — Giant',
    'ORI',
    'M',
    '{1}{B}{B}{B}',
    4,
    5,
    5,
    NULL,
    'As long as your opponents control no creatures, Erebos''s Titan has indestructible. #_(Damage and effects that say "destroy" don''t destroy it.)_#£Whenever a creature card leaves an opponent''s graveyard, you may discard a card. If you do, return Erebos''s Titan from your graveyard to your hand.',
    
    31,
    'B',
    NULL,
    'Commander'
  ),
  (
    398573,
    'Evolutionary Leap',
    'Enchantment',
    'ORI',
    'R',
    '{1}{G}',
    2,
    NULL,
    NULL,
    NULL,
    '{G}, Sacrifice a creature: Reveal cards from the top of your library until you reveal a creature card. Put that card INTO your hand and the rest on the bottom of your library in a random order.',
    
    120,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398548,
    'Evolving Wilds',
    'Land',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}, Sacrifice Evolving Wilds: Search your library for a basic land card, put it onto the battlefield tapped, then shuffle.',
    
    32,
    'L',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398513,
    'Exquisite Firecraft',
    'Sorcery',
    'ORI',
    'R',
    '{1}{R}{R}',
    3,
    NULL,
    NULL,
    NULL,
    'Exquisite Firecraft deals 4 damage to any target.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, this spell can''t be countered.',
    33,
    'R',
    NULL,
    'Commander'
  ),
  (
    398535,
    'Eyeblight Assassin',
    'Creature — Elf Assassin',
    'ORI',
    'C',
    '{2}{B}',
    3,
    2,
    2,
    NULL,
    'When Eyeblight Assassin enters the battlefield, target creature an opponent controls gets -1/-1 until end of turn.',
    
    119,
    'B',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398645,
    'Eyeblight Massacre',
    'Sorcery',
    'ORI',
    'U',
    '{2}{B}{B}',
    4,
    NULL,
    NULL,
    NULL,
    'Non-Elf creatures get -2/-2 until end of turn.',
    
    129,
    'B',
    NULL,
    'Commander'
  ),
  (
    398459,
    'Faerie Miscreant',
    'Creature — Faerie Rogue',
    'ORI',
    'C',
    '{U}',
    1,
    1,
    1,
    NULL,
    'Flying£When Faerie Miscreant enters the battlefield, if you control another creature named Faerie Miscreant, draw a card.',
    
    32,
    'U',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398633,
    'Fetid Imp',
    'Creature — Imp',
    'ORI',
    'C',
    '{1}{B}',
    2,
    1,
    2,
    NULL,
    'Flying£{B}: Fetid Imp gains deathtouch until end of turn. #_(Any amount of damage it deals to a creature is enough to destroy it.)_#',
    
    1,
    'B',
    NULL,
    'Gigante de dos cabezas'

  ),
  (
    398497,
    'Fiery Conclusion',
    'Instant',
    'ORI',
    'U',
    '{1}{R}',
    2,
    NULL,
    NULL,
    NULL, 
    'As an additional cost to cast this spell, sacrifice a creature.£Fiery Conclusion deals 5 damage to target creature.',
   
    34,
    'R',
    NULL,
    'Commander'
  ),
  (
    401463,
    'Fiery Hellhound',
    'Creature — Elemental Dog',
    'ORI',
    'C',
    '{1}{R}{R}',
    3,
    2,
    2,
    NULL,
    '{R}: Fiery Hellhound gets +1/+0 until end of turn.',
    
    35,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398516,
    'Fiery Impulse',
    'Instant',
    'ORI',
    'C',
    '{R}',
    1,
    NULL,
    NULL,
    NULL,
    'Fiery Impulse deals 2 damage to target creature.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, Fiery Impulse deals 3 damage instead.',
    
    12,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398590,
    'Firefiend Elemental',
    'Creature — Elemental',
    'ORI',
    'C',
    '{3}{R}',
    4,
    3,
    2,
    NULL,
    'Haste #_(This creature can attack and {T} as soon as it comes under your control.)_#£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
    
    36,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398547,
    'Flameshadow Conjuring',
    'Enchantment',
    'ORI',
    'R',
    '{3}{R}',
    4,
    NULL,
    NULL,
    NULL,
    'Whenever a nontoken creature enters the battlefield under your control, you may pay {R}. If you do, create a token that''s a copy of that creature. That token gains haste. Exile it at the beginning of the next end step.',
    
    20,
    'R',
    NULL,
    'Brawl'
  ),
  (
    401459,
    'Flesh to Dust',
    'Instant',
    'ORI',
    'C',
    '{3}{B}{B}',
    5,
    NULL,
    NULL,
    NULL,
    'Destroy target creature. It can''t be regenerated.',
   
    37,
    'B',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398625,
    'Fleshbag Marauder',
    'Creature — Zombie Warrior',
    'ORI',
    'U',
    '{2}{B}',
    3,
    3,
    1,
    NULL,
    'When Fleshbag Marauder enters the battlefield, each player sacrifices a creature.',
    
    38,
    'B',
    NULL,
    'Brawl'
  ),
  (
    398454,
    'Forest',
    'Basic Land — Forest',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    15,
    'L',
    '{G}',
    'Gigante de dos cabezas'

  ),
  (
    398613,
    'Foundry of the Consuls',
    'Land',
    'ORI',
    'U',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{5}, {T}, Sacrifice Foundry of the Consuls: Create two 1/1 colorless Thopter artifact creature tokens with flying.',
   
    39,
    'L',
    '{C}',
    'Commander'
  ),
  (
    398501,
    'Gaea''s Revenge',
    'Creature — Elemental',
    'ORI',
    'R',
    '{5}{G}{G}',
    7,
    8,
    5,
    NULL,
    'This spell can''t be countered.£Haste£Gaea''s Revenge can''t be the target of nongreen spells or abilities from nongreen sources.',
    
    40,
    'G',
    NULL,
    'Commander'
  ),
  (
    398448,
    'Gather the Pack',
    'Sorcery',
    'ORI',
    'U',
    '{1}{G}',
    2,
    NULL,
    NULL,
    NULL,
    'Reveal the top five cards of your library. You may put a creature card from among them INTO your hand. Put the rest INTO your graveyard.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, put up to two creature cards from among the revealed cards INTO your hand instead of one.',
    
    129,
    'G',
    NULL,
    'Commander'
  ),
  (
    398517,
    'Ghirapur Aether Grid',
    'Enchantment',
    'ORI',
    'U',
    '{2}{R}',
    3,
    NULL,
    NULL,
    NULL,
    'Tap two untapped artifacts you control: Ghirapur Aether Grid deals 1 damage to any target.',
    
    117,
    'R',
    NULL,
    'Brawl'
  ),
  (
    398681,
    'Ghirapur Gearcrafter',
    'Creature — Human Artificer',
    'ORI',
    'C',
    '{2}{R}',
    3,
    2,
    1,
    NULL,
    'When Ghirapur Gearcrafter enters the battlefield, create a 1/1 colorless Thopter artifact creature token with flying. #_(A creature with flying can''t be blocked except by creatures with flying or reach.)_#',
    
    41,
    'R',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398429,
    'Gideon, Battle-Forged',
    'Legendary Planeswalker — Gideon',
    'ORI',
    'M',
    NULL,
    NULL,
    NULL,
    '3',
    '3',
    '+2: Up to one target creature an opponent controls attacks Gideon, Battle-Forged during its controller''s next turn if able.£+1: Until your next turn, target creature gains indestructible. Untap that creature.£0: Until end of turn, Gideon, Battle-Forged becomes a 4/4 Human Soldier creature with indestructible that''s still a planeswalker. Prevent all damage that would be dealt to him this turn.',
    
    123,
    'W',
    NULL,
    'Commander'
  ),
  (
    398471,
    'Gideon''s Phalanx',
    'Instant',
    'ORI',
    'R',
    '{5}{W}{W}',
    7,
    NULL,
    NULL,
    NULL,
    'Create four 2/2 white Knight creature tokens with vigilance.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, creatures you control gain indestructible until end of turn.',
   
    42,
    'W',
    NULL,
    'Commander'
  ),
  (
    398495,
    'Gilt-Leaf Winnower',
    'Creature — Elf Warrior',
    'ORI',
    'R',
    '{3}{B}{B}',
    5,
    4,
    3,
    NULL,
    'Menace #_(This creature can''t be blocked except by two or more creatures.)_#£When Gilt-Leaf Winnower enters the battlefield, you may destroy target non-Elf creature whose power and toughness aren''t equal.',
   
    43,
    'B',
    NULL,
    'Brawl'
  ),
  (
    398413,
    'Gnarlroot Trapper',
    'Creature — Elf Druid',
    'ORI',
    'U',
    '{B}',
    1,
    1,
    1,
    NULL,
    '{T}, Pay 1 life: Add {G}. Spend this mana only to cast an Elf creature spell.£{T}: Target attacking Elf you control gains deathtouch until end of turn. #_(Any amount of damage it deals to a creature is enough to destroy it.)_#',
    
    44,
    'B',
    '{G}',
    'Commander'
  ),
  (
    398598,
    'Goblin Glory Chaser',
    'Creature — Goblin Warrior',
    'ORI',
    'U',
    '{R}',
    1,
    1,
    1,
    NULL,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£As long as Goblin Glory Chaser is renowned, it has menace. #_(It can''t be blocked except by two or more creatures.)_#',
    
    18,
    'R',
    NULL,
    'Commander'
  ),
  (
    398537,
    'Goblin Piledriver',
    'Creature — Goblin Warrior',
    'ORI',
    'R',
    '{1}{R}',
    2,
    1,
    2,
    NULL,
    'Protection from blue #_(This creature can''t be blocked, targeted, dealt damage, or enchanted by anything blue.)_#£Whenever Goblin Piledriver attacks, it gets +2/+0 until end of turn for each other attacking Goblin.',
    
    45,
    'R',
    NULL,
    'Brawl'
  ),
  (
    398585,
    'Gold-Forged Sentinel',
    'Artifact Creature — Chimera',
    'ORI',
    'U',
    '{6}',
    6,
    4,
    4,
    NULL,
    'Flying',
    
    30,
    'A',
    NULL,
    'Legacy'
  ),
  (
    398558,
    'Grasp of the Hieromancer',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{1}{W}',
    2,
    NULL,
    NULL,
    NULL,
    'Enchant creature£Enchanted creature gets +1/+1 and has "Whenever this creature attacks, tap target creature defending player controls."',
    
    129,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398526,
    'Graveblade Marauder',
    'Creature — Human Warrior',
    'ORI',
    'R',
    '{2}{B}',
    3,
    1,
    4,
    NULL,
    'Deathtouch #_(Any amount of damage this deals to a creature is enough to destroy it.)_#£Whenever Graveblade Marauder deals combat damage to a player, that player loses life equal to the number of creature cards in your graveyard.',
    
    46,
    'B',
    NULL,
    'Brawl'
  ),
  (
    398509,
    'Guardian Automaton',
    'Artifact Creature — Construct',
    'ORI',
    'C',
    '{4}',
    4,
    3,
    3,
    NULL,
    'When Guardian Automaton dies, you gain 3 life.',
    
    47,
    'A',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398553,
    'Guardians of Meletis',
    'Artifact Creature — Golem',
    'ORI',
    'C',
    '{3}',
    3,
    0,
    6,
    NULL,
    'Defender #_(This creature can''t attack.)_#',
    
    48,
    'A',
    NULL,
    'Gigante de dos cabezas'
  ),
  (
    398505,
    'Hallowed Moonlight',
    'Instant',
    'ORI',
    'R',
    '{1}{W}',
    2,
    NULL,
    NULL,
    NULL,
    'Until end of turn, if a creature would enter the battlefield and it wasn''t cast, exile it instead.£Draw a card.',
    
    55,
    'W',
    NULL,
    'Commander'
  ),
  (
    398572,
    'Hangarback Walker',
    'Artifact Creature — Construct',
    'ORI',
    'R',
    '{X}{X}',
    0,
    0,
    0,
    NULL,
    'Hangarback Walker enters the battlefield with X +1/+1 counters on it.£When Hangarback Walker dies, create a 1/1 colorless Thopter artifact creature token with flying for each +1/+1 counter on Hangarback Walker.£{1}, {T}: Put a +1/+1 counter on Hangarback Walker.',
    
    12,
    'A',
    NULL,
    'Commander'
  ),
  (
    398569,
    'Harbinger of the Tides',
    'Creature — Merfolk Wizard',
    'ORI',
    'R',
    '{U}{U}',
    2,
    2,
    2,
    NULL,
    'You may cast Harbinger of the Tides as though it had flash if you pay {2} more to cast it. #_(You may cast it any time you could cast an instant.)_#£When Harbinger of the Tides enters the battlefield, you may return target tapped creature an opponent controls to its owner''s hand.',
    
    49,
    'U',
    NULL,
    'Brawl'
  ),
  (
    398563,
    'Healing Hands',
    'Sorcery',
    'ORI',
    'C',
    '{2}{W}',
    3,
    NULL,
    NULL,
    NULL,
    'Target player gains 4 life.£Draw a card.',
    
    50,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398408,
    'Heavy Infantry',
    'Creature — Human Soldier',
    'ORI',
    'C',
    '{4}{W}',
    5,
    3,
    4,
    NULL,
    'When Heavy Infantry enters the battlefield, tap target creature an opponent controls.',
    
    27,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398588,
    'Helm of the Gods',
    'Artifact — Equipment',
    'ORI',
    'R',
    '{1}',
    1,
    NULL,
    NULL,
    NULL,
    'Equipped creature gets +1/+1 for each enchantment you control.£Equip {1} #_({1}: Attach to target creature you control. Equip only as a sorcery.)_#',
    
    51,
    'A',
    NULL,
    'Commander'
  ),
  (
    398460,
    'Herald of the Pantheon',
    'Creature — Centaur Shaman',
    'ORI',
    'R',
    '{1}{G}',
    2,
    2,
    2,
    NULL,
    'Enchantment spells you cast cost {1} less to cast.£Whenever you cast an enchantment spell, you gain 1 life.',
    
    52,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398676,
    'Hitchclaw Recluse',
    'Creature — Spider',
    'ORI',
    'C',
    '{2}{G}',
    3,
    1,
    4,
    NULL,
    'Reach',
    
    53,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398611,
    'Hixus, Prison Warden',
    'Legendary Creature — Human Soldier',
    'ORI',
    'R',
    '{3}{W}{W}',
    5,
    4,
    4,
    NULL,
    'Flash #_(You may cast this spell any time you could cast an instant.)_#£Whenever a creature deals combat damage to you, if Hixus, Prison Warden entered the battlefield this turn, exile that creature until Hixus leaves the battlefield. #_(That creature returns under its owner''s control.)_#',
   
    8,
    'W',
    NULL,
    'Brawl'
  ),
  (
    398450,
    'Honored Hierarch',
    'Creature — Human Druid',
    'ORI',
    'R',
    '{G}',
    1,
    1,
    1,
    NULL,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£As long as Honored Hierarch is renowned, it has vigilance and "{T}: Add one mana of any color."',
    
    54,
    'G',
    '{W}{U}{B}{R}{G}',
    'Commander'
  ),
  (
    398666,
    'Hydrolash',
    'Instant',
    'ORI',
    'U',
    '{2}{U}',
    3,
    NULL,
    NULL,
    NULL,
    'Attacking creatures get -2/-0 until end of turn.£Draw a card.',
    
    131,
    'U',
    NULL,
    'Commander'
  ),
  (
    398582,
    'Infectious Bloodlust',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{1}{R}',
    2,
    NULL,
    NULL,
    NULL,
    'Enchant creature£Enchanted creature gets +2/+1, has haste, and attacks each combat if able.£When enchanted creature dies, you may search your library for a card named Infectious Bloodlust, reveal it, put it INTO your hand, then shuffle.',
    
    118,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398638,
    'Infernal Scarring',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{1}{B}',
    2,
    NULL,
    NULL,
    NULL,
    'Enchant creature£Enchanted creature gets +2/+0 and has "When this creature dies, draw a card."',
    
    55,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398503,
    'Infinite Obliteration',
    'Sorcery',
    'ORI',
    'R',
    '{1}{B}{B}',
    3,
    NULL,
    NULL,
    NULL,
    'Choose a creature card name. Search target opponent''s graveyard, hand, and library for any number of cards with that name and exile them. Then that player shuffles.',
    
    56,
    'B',
    NULL,
    'Legacy'
  ),
  (
    401456,
    'INTO the Void',
    'Sorcery',
    'ORI',
    'U',
    '{3}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'Return up to two target creatures to their owners'' hands.',
    
    12,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398653,
    'Iroas''s Champion',
    'Creature — Human Soldier',
    'ORI',
    'U',
    '{1}{R}{W}',
    3,
    2,
    2,
    NULL,
    'Double strike #_(This creature deals both first-strike and regular combat damage.)_#',
   
    16,
    'WR',
    NULL,
    'Legacy'
  ),
  (
    398477,
    'Island',
    'Basic Land — Island',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
   
    116,
    'L',
    '{U}',
    'Pauper'
  ),
  (
    398435,
    'Jace, Telepath Unbound',
    'Legendary Planeswalker — Jace',
    'ORI',
    'M',
    NULL,
    NULL,
    NULL,
    '5',
    '5',
    '+1: Up to one target creature gets -2/-0 until your next turn.£−3: You may cast target instant or sorcery card from your graveyard this turn. If that spell would be put INTO your graveyard this turn, exile it instead.£−9: You get an emblem with "Whenever you cast a spell, target opponent mills five cards."',
    
    22,
    'U',
    NULL,
    'Commander'
  ),
  (
    398434,
    'Jace, Vryn''s Prodigy',
    'Legendary Creature — Human Wizard',
    'ORI',
    'M',
    '{1}{U}',
    2,
    0,
    2,
    NULL,
    '{T}: Draw a card, then discard a card. If there are five or more cards in your graveyard, exile Jace, Vryn''s Prodigy, then return him to the battlefield transformed under his owner''s control.',
    
    22,
    'U',
    NULL,
    'Brawl'
  ),
  (
    398614,
    'Jace''s Sanctum',
    'Enchantment',
    'ORI',
    'R',
    '{3}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'Instant and sorcery spells you cast cost {1} less to cast.£Whenever you cast an instant or sorcery spell, scry 1. #_(Look at the top card of your library. You may put that card on the bottom of your library.)_#',
    
    57,
    'U',
    NULL,
    'Brawl'
  ),
  (
    398530,
    'Jayemdae Tome',
    'Artifact',
    'ORI',
    'U',
    '{4}',
    4,
    NULL,
    NULL,
    NULL,
    '{4}, {T}: Draw a card.',
    
    58,
    'A',
    NULL,
    'Brawl'
  ),
  (
    398536,
    'Jhessian Thief',
    'Creature — Human Rogue',
    'ORI',
    'U',
    '{2}{U}',
    3,
    1,
    3,
    NULL,
    'Prowess #_(Whenever you cast a noncreature spell, this creature gets +1/+1 until end of turn.)_#£Whenever Jhessian Thief deals combat damage to a player, draw a card.',
    
    13,
    'U',
    NULL,
    'Commander'
  ),
  (
    398642,
    'Joraga Invocation',
    'Sorcery',
    'ORI',
    'U',
    '{4}{G}{G}',
    6,
    NULL,
    NULL,
    NULL,
    'Each creature you control gets +3/+3 until end of turn and must be blocked this turn if able.',
    
    122,
    'G',
    NULL,
    'Commander'
  ),
  (
    398420,
    'Knight of the Pilgrim''s Road',
    'Creature — Human Knight',
    'ORI',
    'C',
    '{2}{W}',
    3,
    3,
    2,
    NULL,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
    
    27,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398594,
    'Knight of the White Orchid',
    'Creature — Human Knight',
    'ORI',
    'R',
    '{W}{W}',
    2,
    2,
    2,
    NULL,
    'First strike£When Knight of the White Orchid enters the battlefield, if an opponent controls more lands than you, you may search your library for a Plains card, put it onto the battlefield, then shuffle.',
    
    38,
    'W',
    NULL,
    'Brawl'
  ),
  (
    398622,
    'Knightly Valor',
    'Enchantment — Aura',
    'ORI',
    'U',
    '{4}{W}',
    5,
    NULL,
    NULL,
    NULL,
    'Enchant creature£When Knightly Valor enters the battlefield, create a 2/2 white Knight creature token with vigilance. #_(Attacking doesn''t cause it to tap.)_#£Enchanted creature gets +2/+2 and has vigilance.',
    
    54,
    'W',
    NULL,
    'Commander'
  ),
  (
    398443,
    'Kothophed, Soul Hoarder',
    'Legendary Creature — Demon',
    'ORI',
    'R',
    '{4}{B}{B}',
    6,
    6,
    6,
    NULL,
    'Flying£Whenever a permanent owned by another player is put INTO a graveyard from the battlefield, you draw a card and you lose 1 life.',
    
    59,
    'B',
    NULL,
    'Commander'
  ),
  (
    398428,
    'Kytheon, Hero of Akros',
    'Legendary Creature — Human Soldier',
    'ORI',
    'M',
    '{W}',
    1,
    2,
    1,
    NULL,
    'At end of combat, if Kytheon, Hero of Akros and at least two other creatures attacked this combat, exile Kytheon, then return him to the battlefield transformed under his owner''s control.£{2}{W}: Kytheon gains indestructible until end of turn.',
    
    123,
    'W',
    NULL,
    'Commander'
  ),
  (
    398561,
    'Kytheon''s Irregulars',
    'Creature — Human Soldier',
    'ORI',
    'R',
    '{2}{W}{W}',
    4,
    4,
    3,
    NULL,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£{W}{W}: Tap target creature.',
    
    60,
    'W',
    NULL,
    'Commander'
  ),
  (
    398470,
    'Kytheon''s Tactics',
    'Sorcery',
    'ORI',
    'C',
    '{1}{W}{W}',
    3,
    NULL,
    NULL,
    NULL,
    'Creatures you control get +2/+1 until end of turn.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, those creatures also gain vigilance until end of turn. #_(Attacking doesn''t cause them to tap.)_#',
    
    61,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398597,
    'Languish',
    'Sorcery',
    'ORI',
    'R',
    '{2}{B}{B}',
    4,
    NULL,
    NULL,
    NULL,
    'All creatures get -4/-4 until end of turn.',
    
    53,
    'B',
    NULL,
    'Modern'
  ),
  (
    398634,
    'Leaf Gilder',
    'Creature — Elf Druid',
    'ORI',
    'C',
    '{1}{G}',
    2,
    2,
    1,
    NULL,
    '{T}: Add {G}.',
    
    62,
    'G',
    '{G}',
    'Pauper'
  ),
  (
    398538,
    'Lightning Javelin',
    'Sorcery',
    'ORI',
    'C',
    '{3}{R}',
    4,
    NULL,
    NULL,
    NULL,
    'Lightning Javelin deals 3 damage to any target. Scry 1. #_(Look at the top card of your library. You may put that card on the bottom of your library.)_#',
    
    20,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398442,
    'Liliana, Defiant Necromancer',
    'Legendary Planeswalker — Liliana',
    'ORI',
    'M',
    NULL,
    NULL,
    NULL,
    '3',
    '3',
    '+2: Each player discards a card.£−X: Return target nonlegendary creature card with mana value X from your graveyard to the battlefield.£−8: You get an emblem with "Whenever a creature dies, return it to the battlefield under your control at the beginning of the next end step."',
    
    63,
    'B',
    NULL,
    'Commander'
  ),
  (
    398441,
    'Liliana, Heretical Healer',
    'Legendary Creature — Human Cleric',
    'ORI',
    'M',
    '{1}{B}{B}',
    3,
    2,
    3,
    NULL,
    'Lifelink£Whenever another nontoken creature you control dies, exile Liliana, Heretical Healer, then return her to the battlefield transformed under her owner''s control. If you do, create a 2/2 black Zombie creature token.',
    
    63,
    'B',
    NULL,
    'Commander'
  ),
  (
    398482,
    'Llanowar Empath',
    'Creature — Elf Shaman',
    'ORI',
    'C',
    '{3}{G}',
    4,
    2,
    2,
    NULL,
    'When Llanowar Empath enters the battlefield, scry 2, then reveal the top card of your library. If it''s a creature card, put it INTO your hand. #_(To scry 2, look at the top two cards of your library, then put any number of them on the bottom of your library and the rest on top in any order.)_#',
    
    64,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398589,
    'Llanowar Wastes',
    'Land',
    'ORI',
    'R',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{T}: Add {B} or {G}. Llanowar Wastes deals 1 damage to you.',
    
    65,
    'L',
    '{B}{G}{C}',
    'Commander'
  ),
  (
    398494,
    'Macabre Waltz',
    'Sorcery',
    'ORI',
    'C',
    '{1}{B}',
    2,
    NULL,
    NULL,
    NULL,
    'Return up to two target creature cards from your graveyard to your hand, then discard a card.',
    
    66,
    'B',
    NULL,
    'Commander'
  ),
  (
    398426,
    'Mage-Ring Bully',
    'Creature — Human Warrior',
    'ORI',
    'C',
    '{1}{R}',
    2,
    2,
    2,
    NULL,
    'Prowess #_(Whenever you cast a noncreature spell, this creature gets +1/+1 until end of turn.)_#£Mage-Ring Bully attacks each combat if able.',
    
    133,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398533,
    'Mage-Ring Network',
    'Land',
    'ORI',
    'U',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{1}, {T}: Put a storage counter on Mage-Ring Network.£{T}, Remove any number of storage counters from Mage-Ring Network: Add {C} for each storage counter removed this way.',

    132,
    'L',
    '{C}',
    'Legacy'
  ),
  (
    398620,
    'Mage-Ring Responder',
    'Artifact Creature — Golem',
    'ORI',
    'R',
    '{7}',
    7,
    7,
    7,
    NULL,
    'Mage-Ring Responder doesn''t untap during your untap step.£{7}: Untap Mage-Ring Responder.£Whenever Mage-Ring Responder attacks, it deals 7 damage to target creature defending player controls.',
    
    57,
    'A',
    NULL,
    'Legacy'
  ),
  (
    398496,
    'Magmatic Insight',
    'Sorcery',
    'ORI',
    'U',
    '{R}',
    1,
    NULL,
    NULL,
    NULL,
    'As an additional cost to cast this spell, discard a land card.£Draw two cards.',
    
    6,
    'R',
    NULL,
    'Commander'
  ),
  (
    401457,
    'Mahamoti Djinn',
    'Creature — Djinn',
    'ORI',
    'R',
    '{4}{U}{U}',
    6,
    5,
    6,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#',
    
    18,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398556,
    'Malakir Cullblade',
    'Creature — Vampire Warrior',
    'ORI',
    'U',
    '{1}{B}',
    2,
    1,
    1,
    NULL,
    'Whenever a creature an opponent controls dies, put a +1/+1 counter on Malakir Cullblade.',
    
    129,
    'B',
    NULL,
    'Modern'
  ),
  (
    398456,
    'Managorger Hydra',
    'Creature — Hydra',
    'ORI',
    'R',
    '{2}{G}',
    3,
    1,
    1,
    NULL,
    'Trample£Whenever a player casts a spell, put a +1/+1 counter on Managorger Hydra.',
    
    67,
    'G',
    NULL,
    'Commander'
  ),
  (
    398577,
    'Mantle of Webs',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{1}{G}',
    2,
    NULL,
    NULL,
    NULL,
    'Enchant creature£Enchanted creature gets +1/+3 and has reach. #_(It can block creatures with flying.)_#',
    
    68,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398670,
    'Maritime Guard',
    'Creature — Merfolk Soldier',
    'ORI',
    'C',
    '{1}{U}',
    2,
    1,
    3,
    NULL,
    NULL,
    
    69,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398499,
    'Meteorite',
    'Artifact',
    'ORI',
    'U',
    '{5}',
    5,
    NULL,
    NULL,
    NULL,
    'When Meteorite enters the battlefield, it deals 2 damage to any target.£{T}: Add one mana of any color.',
   
    26,
    'A',
    '{W}{U}{B}{R}{G}',
    'Commander'
  ),
  (
    398662,
    'Might of the Masses',
    'Instant',
    'ORI',
    'C',
    '{G}',
    1,
    NULL,
    NULL,
    NULL,
    'Target creature gets +1/+1 until end of turn for each creature you control.',
    
    70,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398630,
    'Mighty Leap',
    'Instant',
    'ORI',
    'C',
    '{1}{W}',
    2,
    NULL,
    NULL,
    NULL,
    'Target creature gets +2/+2 and gains flying until end of turn.',
    
    71,
    'W',
    NULL,
    'Pauper'
  ),
  (
    401460,
    'Mind Rot',
    'Sorcery',
    'ORI',
    'C',
    '{2}{B}',
    3,
    NULL,
    NULL,
    NULL,
    'Target player discards two cards.',
    
    72,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398596,
    'Mizzium Meddler',
    'Creature — Vedalken Wizard',
    'ORI',
    'R',
    '{2}{U}',
    3,
    1,
    4,
    NULL,
    'Flash #_(You may cast this spell any time you could cast an instant.)_#£When Mizzium Meddler enters the battlefield, you may change a target of target spell or ability to Mizzium Meddler.',
    
    70,
    'U',
    NULL,
    'Modern'
  ),
  (
    398649,
    'Molten Vortex',
    'Enchantment',
    'ORI',
    'R',
    '{R}',
    1,
    NULL,
    NULL,
    NULL,
    '{R}, Discard a land card: Molten Vortex deals 2 damage to any target.',
    
    73,
    'R',
    NULL,
    'Modern'
  ),
  (
    398425,
    'Mountain',
    'Basic Land — Mountain',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
   
    39,
    'L',
    '{R}',
    'Pauper'
  ),
  (
    398641,
    'Murder Investigation',
    'Enchantment — Aura',
    'ORI',
    'U',
    '{1}{W}',
    2,
    NULL,
    NULL,
    NULL,
    'Enchant creature you control£When enchanted creature dies, create X 1/1 white Soldier creature tokens, where X is its power.',
    
    129,
    'W',
    NULL,
    'Commander'
  ),
  (
    398440,
    'Nantuko Husk',
    'Creature — Zombie Insect',
    'ORI',
    'C',
    '{2}{B}',
    3,
    2,
    2,
    NULL,
    'Sacrifice a creature: Nantuko Husk gets +2/+2 until end of turn.',
    
    74,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398491,
    'Necromantic Summons',
    'Sorcery',
    'ORI',
    'U',
    '{4}{B}',
    5,
    NULL,
    NULL,
    NULL,
    'Put target creature card from a graveyard onto the battlefield under your control.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, that creature enters the battlefield with two additional +1/+1 counters on it.',
    
    75,
    'B',
    NULL,
    'Commander'
  ),
  (
    398629,
    'Negate',
    'Instant',
    'ORI',
    'C',
    '{1}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Counter target noncreature spell.',
    
    76,
    'U',
    NULL,
    'Pauper'
  ),
  (
    401461,
    'Nightmare',
    'Creature — Nightmare Horse',
    'ORI',
    'R',
    '{5}{B}',
    6,
    '*',
    '*',
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£Nightmare''s power and toughness are each equal to the number of Swamps you control.',
    
    77,
    'B',
    NULL,
    'Commander'
  ),
  (
    398562,
    'Nightsnare',
    'Sorcery',
    'ORI',
    'C',
    '{3}{B}',
    4,
    NULL,
    NULL,
    NULL,
    'Target opponent reveals their hand. You may choose a nonland card from it. If you do, that player discards that card. If you don''t, that player discards two cards.',
    
    78,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398432,
    'Nissa, Sage Animist',
    'Legendary Planeswalker — Nissa',
    'ORI',
    'M',
    NULL,
    NULL,
    NULL,
    '3',
    '3',
    '+1: Reveal the top card of your library. If it''s a land card, put it onto the battlefield. Otherwise, put it INTO your hand.£−2: Create Ashaya, the Awoken World, a legendary 4/4 green Elemental creature token.£−7: Untap up to six target lands. They become 6/6 Elemental creatures. They''re still lands.',
    
    79,
    'G',
    NULL,
    'Commander'
  ),
  (
    398438,
    'Nissa, Vastwood Seer',
    'Legendary Creature — Elf Scout',
    'ORI',
    'M',
    '{2}{G}',
    3,
    2,
    2,
    NULL,
    'When Nissa, Vastwood Seer enters the battlefield, you may search your library for a basic Forest card, reveal it, put it INTO your hand, then shuffle.£Whenever a land enters the battlefield under your control, if you control seven or more lands, exile Nissa, then return her to the battlefield transformed under her owner''s control.',
    
    79,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398593,
    'Nissa''s Pilgrimage',
    'Sorcery',
    'ORI',
    'C',
    '{2}{G}',
    3,
    NULL,
    NULL,
    NULL,
    'Search your library for up to two basic Forest cards, reveal those cards, and put one onto the battlefield tapped and the rest INTO your hand. Then shuffle.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, search your library for up to three basic Forest cards instead of two.',
    
    54,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398506,
    'Nissa''s Revelation',
    'Sorcery',
    'ORI',
    'R',
    '{5}{G}{G}',
    7,
    NULL,
    NULL,
    NULL,
    'Scry 5, then reveal the top card of your library. If it''s a creature card, you draw cards equal to its power and you gain life equal to its toughness.',
    
    80,
    'G',
    NULL,
    'Commander'
  ),
  (
    398465,
    'Nivix Barrier',
    'Creature — Illusion Wall',
    'ORI',
    'C',
    '{3}{U}',
    4,
    0,
    4,
    NULL,
    'Flash #_(You may cast this spell any time you could cast an instant.)_#£Defender #_(This creature can''t attack.)_#£When Nivix Barrier enters the battlefield, target attacking creature gets -4/-0 until end of turn.',
    
    68,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398551,
    'Orbs of Warding',
    'Artifact',
    'ORI',
    'R',
    '{5}',
    5,
    NULL,
    NULL,
    NULL,
    'You have hexproof. #_(You can''t be the target of spells or abilities your opponents control.)_#£If a creature would deal damage to you, prevent 1 of that damage.',
    
    70,
    'A',
    NULL,
    'Modern'
  ),
  (
    398644,
    'Orchard Spirit',
    'Creature — Spirit',
    'ORI',
    'C',
    '{2}{G}',
    3,
    2,
    2,
    NULL,
    'Orchard Spirit can''t be blocked except by creatures with flying or reach.',
    
    10,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398668,
    'Outland Colossus',
    'Creature — Giant',
    'ORI',
    'R',
    '{3}{G}{G}',
    5,
    6,
    6,
    NULL,
    'Renown 6 #_(When this creature deals combat damage to a player, if it isn''t renowned, put six +1/+1 counters on it and it becomes renowned.)_#£Outland Colossus can''t be blocked by more than one creature.',
    
    7,
    'G',
    NULL,
    'Commander'
  ),
  (
    398631,
    'Patron of the Valiant',
    'Creature — Angel',
    'ORI',
    'U',
    '{3}{W}{W}',
    5,
    4,
    4,
    NULL,
    'Flying£When Patron of the Valiant enters the battlefield, put a +1/+1 counter on each creature you control with a +1/+1 counter on it.',
    
    81,
    'W',
    NULL,
    'Modern'
  ),
  (
    398531,
    'Pharika''s Disciple',
    'Creature — Centaur Warrior',
    'ORI',
    'C',
    '{3}{G}',
    4,
    2,
    3,
    NULL,
    'Deathtouch #_(Any amount of damage this deals to a creature is enough to destroy it.)_#£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
    
    133,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398453,
    'Pia and Kiran Nalaar',
    'Legendary Creature — Human Artificer',
    'ORI',
    'R',
    '{2}{R}{R}',
    4,
    2,
    2,
    NULL,
    'When Pia and Kiran Nalaar enters the battlefield, create two 1/1 colorless Thopter artifact creature tokens with flying.£{2}{R}, Sacrifice an artifact: Pia and Kiran Nalaar deals 2 damage to any target.',
    
    110,
    'R',
    NULL,
    'Commander'
  ),
  (
    398541,
    'Plains',
    'Basic Land — Plains',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    82,
    'L',
    '{W}',
    'Pauper'
  ),
  (
    401465,
    'Plummet',
    'Instant',
    'ORI',
    'C',
    '{1}{G}',
    2,
    NULL,
    NULL,
    NULL,
    'Destroy target creature with flying.',
    
    83,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398657,
    'Possessed Skaab',
    'Creature — Zombie',
    'ORI',
    'U',
    '{3}{U}{B}',
    5,
    3,
    2,
    NULL,
    'When Possessed Skaab enters the battlefield, return target instant, sorcery, or creature card from your graveyard to your hand.£If Possessed Skaab would die, exile it instead.',
    
    11,
    'UB',
    NULL,
    'Commander'
  ),
  (
    398449,
    'Prickleboar',
    'Creature — Boar',
    'ORI',
    'C',
    '{4}{R}',
    5,
    3,
    3,
    NULL,
    'As long as it''s your turn, Prickleboar gets +2/+0 and has first strike. #_(It deals combat damage before creatures without first strike.)_#',
    
    84,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398639,
    'Priest of the Blood Rite',
    'Creature — Human Cleric',
    'ORI',
    'R',
    '{3}{B}{B}',
    5,
    2,
    2,
    NULL,
    'When Priest of the Blood Rite enters the battlefield, create a 5/5 black Demon creature token with flying.£At the beginning of your upkeep, you lose 2 life.',
    
    85,
    'B',
    NULL,
    'Modern'
  ),
  (
    398646,
    'Prism Ring',
    'Artifact',
    'ORI',
    'U',
    '{1}',
    1,
    NULL,
    NULL,
    NULL,
    'As Prism Ring enters the battlefield, choose a color.£Whenever you cast a spell of the chosen color, you gain 1 life.',
   
    5,
    'A',
    NULL,
    'Legacy'
  ),
  (
    401466,
    'Prized Unicorn',
    'Creature — Unicorn',
    'ORI',
    'U',
    '{3}{G}',
    4,
    2,
    2,
    NULL,
    'All creatures able to block Prized Unicorn do so.',
    
    86,
    'G',
    NULL,
    'Modern'
  ),
  (
    398479,
    'Psychic Rebuttal',
    'Instant',
    'ORI',
    'U',
    '{1}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Counter target instant or sorcery spell that targets you.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, you may copy the spell countered this way. You may choose new targets for the copy.',
    
    87,
    'U',
    NULL,
    'Commander'
  ),
  (
    398427,
    'Pyromancer''s Goggles',
    'Legendary Artifact',
    'ORI',
    'M',
    '{5}',
    5,
    NULL,
    NULL,
    NULL,
    '{T}: Add {R}. When that mana is spent to cast a red instant or sorcery spell, copy that spell and you may choose new targets for the copy.',
   
    29,
    'A',
    '{R}',
    'Commander'
  ),
  (
    398557,
    'Rabid Bloodsucker',
    'Creature — Vampire',
    'ORI',
    'C',
    '{4}{B}',
    5,
    3,
    2,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£When Rabid Bloodsucker enters the battlefield, each player loses 2 life.',
    
    20,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398467,
    'Ramroller',
    'Artifact Creature — Juggernaut',
    'ORI',
    'U',
    '{3}',
    3,
    2,
    3,
    NULL,
    'Ramroller attacks each combat if able.£Ramroller gets +2/+0 as long as you control another artifact.',
    
    130,
    'A',
    NULL,
    'Commander'
  ),
  (
    398601,
    'Ravaging Blaze',
    'Instant',
    'ORI',
    'U',
    '{X}{R}{R}',
    2,
    NULL,
    NULL,
    NULL,
    'Ravaging Blaze deals X damage to target creature. £#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, Ravaging Blaze also deals X damage to that creature''s controller.',
    
    111,
    'R',
    NULL,
    'Commander'
  ),
  (
    398637,
    'Read the Bones',
    'Sorcery',
    'ORI',
    'C',
    '{2}{B}',
    3,
    NULL,
    NULL,
    NULL,
    'Scry 2, then draw two cards. You lose 2 life.',
    
    88,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398591,
    'Reave Soul',
    'Sorcery',
    'ORI',
    'C',
    '{1}{B}',
    2,
    NULL,
    NULL,
    NULL,
    'Destroy target creature with power 3 or less.',
    
    85,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398543,
    'Reclaim',
    'Instant',
    'ORI',
    'C',
    '{G}',
    1,
    NULL,
    NULL,
    NULL,
    'Put target card from your graveyard on top of your library.',
    
    89,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398521,
    'Reclusive Artificer',
    'Creature — Human Artificer',
    'ORI',
    'U',
    '{2}{U}{R}',
    4,
    2,
    3,
    NULL,
    'Haste #_(This creature can attack and {T} as soon as it comes under your control.)_#£When Reclusive Artificer enters the battlefield, you may have it deal damage to target creature equal to the number of artifacts you control.',
    
    117,
    'UR',
    NULL,
    'Commander'
  ),
  (
    398476,
    'Relic Seeker',
    'Creature — Human Soldier',
    'ORI',
    'R',
    '{1}{W}',
    2,
    2,
    2,
    NULL,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£When Relic Seeker becomes renowned, you may search your library for an Equipment card, reveal it, put it INTO your hand, then shuffle.',
    
    3,
    'W',
    NULL,
    'Commander'
  ),
  (
    398468,
    'Returned Centaur',
    'Creature — Zombie Centaur',
    'ORI',
    'C',
    '{3}{B}',
    4,
    2,
    4,
    NULL,
    'When Returned Centaur enters the battlefield, target player mills four cards.',
    
    67,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398575,
    'Revenant',
    'Creature — Spirit',
    'ORI',
    'U',
    '{4}{B}',
    5,
    '*',
    '*',
    NULL,
    'Flying£Revenant''s power and toughness are each equal to the number of creature cards in your graveyard.',
    
    90,
    'B',
    NULL,
    'Brawl'
  ),
  (
    398663,
    'Rhox Maulers',
    'Creature — Rhino Soldier',
    'ORI',
    'C',
    '{4}{G}',
    5,
    4,
    4,
    NULL,
    'Trample #_(This creature can deal excess combat damage to the player or planeswalker it''s attacking.)_#£Renown 2 #_(When this creature deals combat damage to a player, if it isn''t renowned, put two +1/+1 counters on it and it becomes renowned.)_#',
    
    118,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398464,
    'Ringwarden Owl',
    'Creature — Bird',
    'ORI',
    'C',
    '{3}{U}{U}',
    5,
    3,
    3,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£Prowess #_(Whenever you cast a noncreature spell, this creature gets +1/+1 until end of turn.)_#',
    
    91,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398523,
    'Rogue''s Passage',
    'Land',
    'ORI',
    'U',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{4}, {T}: Target creature can''t be blocked this turn.',
    
    92,
    'L',
    '{C}',
    'Commander'
  ),
  (
    398643,
    'Runed Servitor',
    'Artifact Creature — Construct',
    'ORI',
    'U',
    '{2}',
    2,
    2,
    2,
    NULL,
    'When Runed Servitor dies, each player draws a card.',
    
    55,
    'A',
    NULL,
    'Commander'
  ),
  (
    398461,
    'Scab-Clan Berserker',
    'Creature — Human Berserker',
    'ORI',
    'R',
    '{1}{R}{R}',
    3,
    2,
    2,
    NULL,
    'Haste£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£Whenever an opponent casts a noncreature spell, if Scab-Clan Berserker is renowned, Scab-Clan Berserker deals 2 damage to that player.',
    
    93,
    'R',
    NULL,
    'Legacy'
  ),
  (
    398478,
    'Scrapskin Drake',
    'Creature — Zombie Drake',
    'ORI',
    'C',
    '{2}{U}',
    3,
    2,
    3,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£Scrapskin Drake can block only creatures with flying.',
    
    21,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398487,
    'Screeching Skaab',
    'Creature — Zombie',
    'ORI',
    'C',
    '{1}{U}',
    2,
    2,
    1,
    NULL,
    'When Screeching Skaab enters the battlefield, mill two cards.',
    
    131,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398579,
    'Seismic Elemental',
    'Creature — Elemental',
    'ORI',
    'U',
    '{3}{R}{R}',
    5,
    4,
    4,
    NULL,
    'When Seismic Elemental enters the battlefield, creatures without flying can''t block this turn.',
    
    94,
    'R',
    NULL,
    'Modern'
  ),
  (
    398545,
    'Send to Sleep',
    'Instant',
    'ORI',
    'C',
    '{1}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Tap up to two target creatures.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, those creatures don''t untap during their controllers'' next untap steps.',
    
    117,
    'U',
    NULL,
    'Pauper'
  ),
  (
    401462,
    'Sengir Vampire',
    'Creature — Vampire',
    'ORI',
    'U',
    '{3}{B}{B}',
    5,
    4,
    4,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£Whenever a creature dealt damage by Sengir Vampire this turn dies, put a +1/+1 counter on Sengir Vampire.',
    
    21,
    'B',
    NULL,
    'Legacy'
  ),
  (
    398659,
    'Sentinel of the Eternal Watch',
    'Creature — Giant Soldier',
    'ORI',
    'U',
    '{5}{W}',
    6,
    4,
    6,
    NULL,
    'Vigilance #_(Attacking doesn''t cause this creature to tap.)_#£At the beginning of combat on each opponent''s turn, tap target creature that player controls.',
    
    14,
    'W',
    NULL,
    'Commander'
  ),
  (
    398608,
    'Separatist Voidmage',
    'Creature — Human Wizard',
    'ORI',
    'C',
    '{3}{U}',
    4,
    2,
    2,
    NULL,
    'When Separatist Voidmage enters the battlefield, you may return target creature to its owner''s hand.',
    
    46,
    'U',
    NULL,
    'Pauper'
  ),
  (
    401455,
    'Serra Angel',
    'Creature — Angel',
    'ORI',
    'U',
    '{3}{W}{W}',
    5,
    4,
    4,
    NULL,
    'Flying, vigilance',
    
    18,
    'W',
    NULL,
    'Legacy'
  ),
  (
    398522,
    'Shadows of the Past',
    'Enchantment',
    'ORI',
    'U',
    '{1}{B}',
    2,
    NULL,
    NULL,
    NULL,
    'Whenever a creature dies, scry 1. #_(Look at the top card of your library. You may put that card on the bottom of your library.)_#£{4}{B}: Each opponent loses 2 life and you gain 2 life. Activate only if there are four or more creature cards in your graveyard.',
    
    75,
    'B',
    NULL,
    'Commander'
  ),
  (
    398489,
    'Shaman of the Pack',
    'Creature — Elf Shaman',
    'ORI',
    'U',
    '{1}{B}{G}',
    3,
    3,
    2,
    NULL,
    'When Shaman of the Pack enters the battlefield, target opponent loses life equal to the number of Elves you control.',
    
    119,
    'GB',
    NULL,
    'Commander'
  ),
  (
    398552,
    'Shambling Ghoul',
    'Creature — Zombie',
    'ORI',
    'C',
    '{1}{B}',
    2,
    2,
    3,
    NULL,
    'Shambling Ghoul enters the battlefield tapped.',
    
    109,
    'B',
    NULL,
    'Pauper'
  ),
  (
    401464,
    'Shivan Dragon',
    'Creature — Dragon',
    'ORI',
    'R',
    '{4}{R}{R}',
    6,
    5,
    5,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£{R}: Shivan Dragon gets +1/+0 until end of turn.',
    
    58,
    'R',
    NULL,
    'Commander'
  ),
  (
    398444,
    'Shivan Reef',
    'Land',
    'ORI',
    'R',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{T}: Add {U} or {R}. Shivan Reef deals 1 damage to you.',
    
    65,
    'L',
    '{U}{R}{C}',
    'Commander'
  ),
  (
    398524,
    'Sigil of the Empty Throne',
    'Enchantment',
    'ORI',
    'R',
    '{3}{W}{W}',
    5,
    NULL,
    NULL,
    NULL,
    'Whenever you cast an enchantment spell, create a 4/4 white Angel creature token with flying.',
    
    95,
    'W',
    NULL,
    'Commander'
  ),
  (
    398515,
    'Sigil of Valor',
    'Artifact — Equipment',
    'ORI',
    'U',
    '{2}',
    2,
    NULL,
    NULL,
    NULL,
    'Whenever equipped creature attacks alone, it gets +1/+1 until end of turn for each other creature you control.£Equip {1} #_({1}: Attach to target creature you control. Equip only as a sorcery.)_#',
    
    119,
    'A',
    NULL,
    'Commander'
  ),
  (
    398592,
    'Sigiled Starfish',
    'Creature — Starfish',
    'ORI',
    'U',
    '{1}{U}',
    2,
    0,
    3,
    NULL,
    '{T}: Scry 1. #_(Look at the top card of your library. You may put that card on the bottom of your library.)_#',
    
    1,
    'U',
    NULL,
    'Commander'
  ),
  (
    398559,
    'Skaab Goliath',
    'Creature — Zombie Giant',
    'ORI',
    'U',
    '{5}{U}',
    6,
    6,
    9,
    NULL,
    'As an additional cost to cast this spell, exile two creature cards from your graveyard.£Trample',
    
    3,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398430,
    'Skyraker Giant',
    'Creature — Giant',
    'ORI',
    'U',
    '{2}{R}{R}',
    4,
    4,
    3,
    NULL,
    'Reach',
    
    113,
    'R',
    NULL,
    'Modern'
  ),
  (
    398650,
    'Skysnare Spider',
    'Creature — Spider',
    'ORI',
    'U',
    '{4}{G}{G}',
    6,
    6,
    6,
    NULL,
    'Vigilance #_(Attacking doesn''t cause this creature to tap.)_#£Reach #_(This creature can block creatures with flying.)_#',
    
    96,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398669,
    'Smash to Smithereens',
    'Instant',
    'ORI',
    'C',
    '{1}{R}',
    2,
    NULL,
    NULL,
    NULL,
    'Destroy target artifact. Smash to Smithereens deals 3 damage to that artifact''s controller.',
    
    83,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398626,
    'Somberwald Alpha',
    'Creature — Wolf',
    'ORI',
    'U',
    '{3}{G}',
    4,
    3,
    2,
    NULL,
    'Whenever a creature you control becomes blocked, it gets +1/+1 until end of turn.£{1}{G}: Target creature you control gains trample until end of turn. #_(It can deal excess combat damage to the player or planeswalker it''s attacking.)_#',
    
    96,
    'G',
    NULL,
    'Commander'
  ),
  (
    398485,
    'Soulblade Djinn',
    'Creature — Djinn',
    'ORI',
    'R',
    '{3}{U}{U}',
    5,
    4,
    3,
    NULL,
    'Flying£Whenever you cast a noncreature spell, creatures you control get +1/+1 until end of turn.',
   
    43,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398520,
    'Sphinx''s Tutelage',
    'Enchantment',
    'ORI',
    'U',
    '{2}{U}',
    3,
    NULL,
    NULL,
    NULL,
    'Whenever you draw a card, target opponent mills two cards. If two nonland cards that share a color were milled this way, repeat this process.£{5}{U}: Draw a card, then discard a card.',
    
    97,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398624,
    'Stalwart Aven',
    'Creature — Bird Soldier',
    'ORI',
    'C',
    '{2}{W}',
    3,
    1,
    3,
    NULL,
    'Flying #_(This creature can''t be blocked except by creatures with flying or reach.)_#£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
   
    26,
    'W',
    NULL,
    'Modern'
  ),
  (
    398475,
    'Starfield of Nyx',
    'Enchantment',
    'ORI',
    'M',
    '{4}{W}',
    '5',
    NULL,
    NULL,
    NULL,
    'At the beginning of your upkeep, you may return target enchantment card from your graveyard to the battlefield.£As long as you control five or more enchantments, each other non-Aura enchantment you control is a creature in addition to its other types and has base power and base toughness each equal to its mana value.',
    
    98,
    'W',
    NULL,
    'Legacy'
  ),
  (
    398549,
    'Stratus Walk',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{1}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Enchant creature£When Stratus Walk enters the battlefield, draw a card.£Enchanted creature has flying. #_(It can''t be blocked except by creatures with flying or reach.)_#£Enchanted creature can block only creatures with flying.',
    
    99,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398458,
    'Subterranean Scout',
    'Creature — Goblin Scout',
    'ORI',
    'C',
    '{1}{R}',
    2,
    2,
    1,
    NULL,
    'When Subterranean Scout enters the battlefield, target creature with power 2 or less can''t be blocked this turn.',
    
    67,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398602,
    'Suppression Bonds',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{3}{W}',
    4,
    NULL,
    NULL,
    NULL,
    'Enchant nonland permanent£Enchanted permanent can''t attack or block, and its activated abilities can''t be activated.',
   
    8,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398507,
    'Swamp',
    'Basic Land — Swamp',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
   
    29,
    'L',
    '{B}',
    'Pauper'
  ),
  (
    398481,
    'Swift Reckoning',
    'Sorcery',
    'ORI',
    'U',
    '{1}{W}',
    2,
    NULL,
    NULL,
    NULL,
    '#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, you may cast Swift Reckoning as though it had flash. #_(You may cast it any time you could cast an instant.)_#£Destroy target tapped creature.',
    
    120,
    'W',
    NULL,
    'Commander'

  ),
  (
    398492,
    'Sword of the Animist',
    'Legendary Artifact — Equipment',
    'ORI',
    'R',
    '{2}',
    2,
    NULL,
    NULL,
    NULL,
    'Equipped creature gets +1/+1.£Whenever equipped creature attacks, you may search your library for a basic land card, put it onto the battlefield tapped, then shuffle.£Equip {2}',
   
    5,
    'A',
    NULL,
    'Commander'
  ),
  (
    398651,
    'Sylvan Messenger',
    'Creature — Elf',
    'ORI',
    'U',
    '{3}{G}',
    4,
    2,
    2,
    NULL,
    'Trample #_(This creature can deal excess combat damage to the player or planeswalker it''s attacking.)_#£When Sylvan Messenger enters the battlefield, reveal the top four cards of your library. Put all Elf cards revealed this way INTO your hand and the rest on the bottom of your library in any order.',
    
    51,
    'G',
    NULL,
    'Commander'
  ),
  (
    398612,
    'Tainted Remedy',
    'Enchantment',
    'ORI',
    'R',
    '{2}{B}',
    '3',
    NULL,
    NULL,
    NULL,
    'If an opponent would gain life, that player loses that much life instead.',
    
    80,
    'B',
    NULL,
    'Commander'
  ),
  (
    398483,
    'Talent of the Telepath',
    'Sorcery',
    'ORI',
    'R',
    '{2}{U}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'Target opponent reveals the top seven cards of their library. You may cast an instant or sorcery spell from among them without paying its mana cost. Then that player puts the rest INTO their graveyard.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, you may cast up to two instant and/or sorcery spells from among the revealed cards instead of one.',
    
    31,
    'U',
    NULL,
    'Brawl'
  ),
  (
    401467,
    'Terra Stomper',
    'Creature — Beast',
    'ORI',
    'R',
    '{3}{G}{G}{G}',
    6,
    8,
    8,
    NULL,
    'This spell can''t be countered.£Trample #_(This creature can deal excess combat damage to the player or planeswalker it''s attacking.)_#',
    
    100,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398679,
    'The Great Aurora',
    'Sorcery',
    'ORI',
    'M',
    '{6}{G}{G}{G}',
    9,
    NULL,
    NULL,
    NULL,
    'Each player shuffles all cards from their hand and all permanents they own INTO their library, then draws that many cards. Each player may put any number of land cards from their hand onto the battlefield. Exile The Great Aurora.',
   
    39,
    'G',
    NULL,
    'Brawl'
  ),
  (
    398514,
    'Thopter Engineer',
    'Creature — Human Artificer',
    'ORI',
    'U',
    '{2}{R}',
    3,
    1,
    3,
    NULL,
    'When Thopter Engineer enters the battlefield, create a 1/1 colorless Thopter artifact creature token with flying.£Artifact creatures you control have haste. #_(They can attack and {T} as soon as they come under your control.)_#',
    
    101,
    'R',
    NULL,
    'Legacy'
  ),
  (
    398519,
    'Thopter Spy Network',
    'Enchantment',
    'ORI',
    'R',
    '{2}{U}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'At the beginning of your upkeep, if you control an artifact, create a 1/1 colorless Thopter artifact creature token with flying.£Whenever one or more artifact creatures you control deal combat damage to a player, draw a card.',

    132,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398407,
    'Thornbow Archer',
    'Creature — Elf Archer',
    'ORI',
    'C',
    '{B}',
    1,
    1,
    2,
    NULL,
    'Whenever Thornbow Archer attacks, each opponent who doesn''t control an Elf loses 1 life.',
    
    21,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398595,
    'Throwing Knife',
    'Artifact — Equipment',
    'ORI',
    'U',
    '{2}',
    2,
    NULL,
    NULL,
    NULL,
    'Equipped creature gets +2/+0.£Whenever equipped creature attacks, you may sacrifice Throwing Knife. If you do, Throwing Knife deals 2 damage to any target.£Equip {2} #_({2}: Attach to target creature you control. Equip only as a sorcery.)_#',
    
    68,
    'A',
    NULL,
    'Commander'
  ),
  (
    398655,
    'Thunderclap Wyvern',
    'Creature — Drake',
    'ORI',
    'U',
    '{2}{W}{U}',
    4,
    2,
    3,
    NULL,
    'Flash #_(You may cast this spell any time you could cast an instant.)_#£Flying£Other creatures you control with flying get +1/+1.',
    
    102,
    'WU',
    NULL,
    'Brawl'
  ),
  (
    398445,
    'Timberpack Wolf',
    'Creature — Wolf',
    'ORI',
    'C',
    '{1}{G}',
    2,
    2,
    2,
    NULL,
    'Timberpack Wolf gets +1/+1 for each other creature you control named Timberpack Wolf.',
    
    17,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398648,
    'Titanic Growth',
    'Instant',
    'ORI',
    'C',
    '{1}{G}',
    2,
    NULL,
    NULL,
    NULL,
    'Target creature gets +4/+4 until end of turn.',
    
    7,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398680,
    'Titan''s Strength',
    'Instant',
    'ORI',
    'C',
    '{R}',
    1,
    NULL,
    NULL,
    NULL,
    'Target creature gets +3/+1 until end of turn. Scry 1. #_(Look at the top card of your library. You may put that card on the bottom of your library.)_#',
    
    133,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398619,
    'Topan Freeblade',
    'Creature — Human Soldier',
    'ORI',
    'C',
    '{1}{W}',
    2,
    2,
    2,
    NULL,
    'Vigilance #_(Attacking doesn''t cause this creature to tap.)_#£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
   
    24,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398623,
    'Tormented Thoughts',
    'Sorcery',
    'ORI',
    'U',
    '{2}{B}',
    3,
    NULL,
    NULL,
    NULL,
    'As an additional cost to cast this spell, sacrifice a creature.£Target player discards a number of cards equal to the sacrificed creature''s power.',
    
    69,
    'B',
    NULL,
    'Legacy'
  ),
  (
    398599,
    'Totem-Guide Hartebeest',
    'Creature — Antelope',
    'ORI',
    'U',
    '{4}{W}',
    5,
    2,
    5,
    NULL,
    'When Totem-Guide Hartebeest enters the battlefield, you may search your library for an Aura card, reveal it, put it INTO your hand, then shuffle.',
    
    17,
    'W',
    NULL,
    'Modern'
  ),
  (
    398600,
    'Touch of Moonglove',
    'Instant',
    'ORI',
    'C',
    '{B}',
    1,
    NULL,
    NULL,
    NULL,
    'Target creature you control gets +1/+0 and gains deathtouch until end of turn. Whenever a creature dealt damage by that creature dies this turn, its controller loses 2 life. #_(Any amount of damage a creature with deathtouch deals to a creature is enough to destroy it.)_#',
   
    26,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398615,
    'Tower Geist',
    'Creature — Spirit',
    'ORI',
    'U',
    '{3}{U}',
    4,
    2,
    2,
    NULL,
    'Flying£When Tower Geist enters the battlefield, look at the top two cards of your library. Put one of them INTO your hand and the other INTO your graveyard.',
    
    80,
    'U',
    NULL,
    'Commander'
  ),
  (
    398610,
    'Tragic Arrogance',
    'Sorcery',
    'ORI',
    'R',
    '{3}{W}{W}',
    5,
    NULL,
    NULL,
    NULL,
    'For each player, you choose from among the permanents that player controls an artifact, a creature, an enchantment, and a planeswalker. Then each player sacrifices all other nonland permanents they control.',
    
    128,
    'W',
    NULL,
    'Commander'
  ),
  (
    398463,
    'Turn to Frog',
    'Instant',
    'ORI',
    'U',
    '{1}{U}',
    2,
    NULL,
    NULL,
    NULL,
    'Until end of turn, target creature loses all abilities and becomes a blue Frog with base power and toughness 1/1.',
    
    64,
    'U',
    NULL,
    'Commander'
  ),
  (
    398484,
    'Undead Servant',
    'Creature — Zombie',
    'ORI',
    'C',
    '{3}{B}',
    4,
    3,
    2,
    NULL,
    'When Undead Servant enters the battlefield, create a 2/2 black Zombie creature token for each card named Undead Servant in your graveyard.',
   
    30,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398568,
    'Undercity Troll',
    'Creature — Troll',
    'ORI',
    'U',
    '{1}{G}',
    2,
    2,
    2,
    NULL,
    'Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#£{2}{G}: Regenerate Undercity Troll. #_(The next time this creature would be destroyed this turn, it isn''t. Instead tap it, remove all damage from it, and remove it from combat.)_#',
    
    102,
    'G',
    NULL,
    'Legacy'
  ),
  (
    398452,
    'Unholy Hunger',
    'Instant',
    'ORI',
    'C',
    '{3}{B}{B}',
    5,
    NULL,
    NULL,
    NULL,
    'Destroy target creature.£#_Spell mastery_# — If there are two or more instant and/or sorcery cards in your graveyard, you gain 2 life.',
    
    25,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398447,
    'Valeron Wardens',
    'Creature — Human Monk',
    'ORI',
    'U',
    '{2}{G}',
    3,
    1,
    3,
    NULL,
    'Renown 2 #_(When this creature deals combat damage to a player, if it isn''t renowned, put two +1/+1 counters on it and it becomes renowned.)_#£Whenever a creature you control becomes renowned, draw a card.',
    
    10,
    'G',
    NULL,
    'Legacy'
  ),
  (
    398529,
    'Valor in Akros',
    'Enchantment',
    'ORI',
    'U',
    '{3}{W}',
    4,
    NULL,
    NULL,
    NULL,
    'Whenever a creature enters the battlefield under your control, creatures you control get +1/+1 until end of turn.',
    
    129,
    'W',
    NULL,
    'Legacy'
  ),
  (
    398469,
    'Vastwood Gorger',
    'Creature — Wurm',
    'ORI',
    'C',
    '{5}{G}',
    6,
    5,
    6,
    NULL,
    NULL,
    
    122,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398498,
    'Veteran''s Sidearm',
    'Artifact — Equipment',
    'ORI',
    'C',
    '{2}',
    2,
    NULL,
    NULL,
    NULL,
    'Equipped creature gets +1/+1.£Equip {1} #_({1}: Attach to target creature you control. Equip only as a sorcery.)_#',
    
    99,
    'A',
    NULL,
    'Pauper'
  ),
  (
    398658,
    'Vine Snare',
    'Instant',
    'ORI',
    'C',
    '{2}{G}',
    3,
    NULL,
    NULL,
    NULL,
    'Prevent all combat damage that would be dealt this turn by creatures with power 4 or less.',
    
    129,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398636,
    'Volcanic Rambler',
    'Creature — Elemental',
    'ORI',
    'C',
    '{5}{R}',
    6,
    6,
    4,
    NULL,
    '{2}{R}: Volcanic Rambler deals 1 damage to target player or planeswalker.',
    
    47,
    'R',
    NULL,
    'Pauper'
  ),
  (
    398567,
    'Vryn Wingmare',
    'Creature — Pegasus',
    'ORI',
    'R',
    '{2}{W}',
    3,
    2,
    1,
    NULL,
    'Flying£Noncreature spells cost {1} more to cast.',
    
    20,
    'W',
    NULL,
    'Legacy'
  ),
  (
    398673,
    'War Horn',
    'Artifact',
    'ORI',
    'U',
    '{3}',
    3,
    NULL,
    NULL,
    NULL,
    'Attacking creatures you control get +1/+0.',
    
    88,
    'A',
    NULL,
    'Brawl'
  ),
  (
    398621,
    'War Oracle',
    'Creature — Human Cleric',
    'ORI',
    'U',
    '{2}{W}{W}',
    4,
    3,
    3,
    NULL,
    'Lifelink #_(Damage dealt by this creature also causes you to gain that much life.)_#£Renown 1 #_(When this creature deals combat damage to a player, if it isn''t renowned, put a +1/+1 counter on it and it becomes renowned.)_#',
    
    101,
    'W',
    NULL,
    'Commander'
  ),
  (
    398540,
    'Watercourser',
    'Creature — Elemental',
    'ORI',
    'C',
    '{2}{U}',
    3,
    2,
    3,
    NULL,
    '{U}: Watercourser gets +1/-1 until end of turn.',
    
    68,
    'U',
    NULL,
    'Pauper'
  ),
  (
    401458,
    'Weave Fate',
    'Instant',
    'ORI',
    'C',
    '{3}{U}',
    4,
    NULL,
    NULL,
    NULL,
    'Draw two cards.',
    
    114,
    'U',
    NULL,
    'Pauper'
  ),
  (
    398544,
    'Weight of the Underworld',
    'Enchantment — Aura',
    'ORI',
    'C',
    '{3}{B}',
    4,
    NULL,
    NULL,
    NULL,
    'Enchant creature£Enchanted creature gets -3/-2.',
    
    79,
    'B',
    NULL,
    'Pauper'
  ),
  (
    398410,
    'Whirler Rogue',
    'Creature — Human Rogue Artificer',
    'ORI',
    'U',
    '{2}{U}{U}',
    4,
    2,
    2,
    NULL,
    'When Whirler Rogue enters the battlefield, create two 1/1 colorless Thopter artifact creature tokens with flying.£Tap two untapped artifacts you control: Target creature can''t be blocked this turn.',
    
    128,
    'U',
    NULL,
    'Brawl'
  ),
  (
    398508,
    'Wild Instincts',
    'Sorcery',
    'ORI',
    'C',
    '{3}{G}',
    4,
    NULL,
    NULL,
    NULL,
    'Target creature you control gets +2/+2 until end of turn. It fights target creature an opponent controls. #_(Each deals damage equal to its power to the other.)_#',
    
    129,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398502,
    'Willbreaker',
    'Creature — Human Wizard',
    'ORI',
    'R',
    '{3}{U}{U}',
    5,
    2,
    3,
    NULL,
    'Whenever a creature an opponent controls becomes the target of a spell or ability you control, gain control of that creature for as long as you control Willbreaker.',
    
    119,
    'U',
    NULL,
    'Legacy'
  ),
  (
    398511,
    'Woodland Bellower',
    'Creature — Beast',
    'ORI',
    'M',
    '{4}{G}{G}',
    6,
    6,
    5,
    NULL,
    'When Woodland Bellower enters the battlefield, you may search your library for a nonlegendary green creature card with mana value 3 or less, put it onto the battlefield, then shuffle.',
    
    94,
    'G',
    NULL,
    'Commander'
  ),
  (
    398566,
    'Yavimaya Coast',
    'Land',
    'ORI',
    'R',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    '{T}: Add {C}.£{T}: Add {G} or {U}. Yavimaya Coast deals 1 damage to you.',
    
    103,
    'L',
    '{G}{U}{C}',
    'Legacy'
  ),
  (
    398424,
    'Yeva''s Forcemage',
    'Creature — Elf Shaman',
    'ORI',
    'C',
    '{2}{G}',
    3,
    2,
    2,
    NULL,
    'When Yeva''s Forcemage enters the battlefield, target creature gets +2/+2 until end of turn.',
    
    110,
    'G',
    NULL,
    'Pauper'
  ),
  (
    398671,
    'Yoked Ox',
    'Creature — Ox',
    'ORI',
    'C',
    '{W}',
    1,
    0,
    4,
    NULL,
    NULL,
    
    75,
    'W',
    NULL,
    'Pauper'
  ),
  (
    398661,
    'Zendikar Incarnate',
    'Creature — Elemental',
    'ORI',
    'U',
    '{2}{R}{G}',
    4,
    '*',
    4,
    NULL,
    'Zendikar Incarnate''s power is equal to the number of lands you control.',
    
    67,
    'GR',
    NULL,
    'Modern'
  ),
  (
    398518,
    'Zendikar''s Roil',
    'Enchantment',
    'ORI',
    'U',
    '{3}{G}{G}',
    5,
    NULL,
    NULL,
    NULL,
    '#_Landfall_# — Whenever a land enters the battlefield under your control, create a 2/2 green Elemental creature token.',
   
    39,
    'G',
    NULL,
    'Commander'
  ),
  (
    398421,
    'Forest',
    'Basic Land — Forest',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    17,
    'L',
    '{G}',
    'Pauper'
  ),
  (
    398570,
    'Forest',
    'Basic Land — Forest',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    15,
    'L',
    '{G}',
    'Pauper'
  ),
  (
    398617,
    'Forest',
    'Basic Land — Forest',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    47,
    'L',
    '{G}',
    'Pauper'
  ),
  (
    398431,
    'Island',
    'Basic Land — Island',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
   
    116,
    'L',
    '{U}',
    'Pauper'
  ),
  (
    398586,
    'Island',
    'Basic Land — Island',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,

    132,
    'L',
    '{U}',
    'Pauper'
  ),
  (
    398664,
    'Island',
    'Basic Land — Island',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,

    132,
    'L',
    '{U}',
    'Pauper'
  ),
  (
    398412,
    'Mountain',
    'Basic Land — Mountain',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
   
    39,
    'L',
    '{R}',
    'Pauper'
  ),
  (
    398490,
    'Mountain',
    'Basic Land — Mountain',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    104,
    'L',
    '{R}',
    'Pauper'
  ),
  (
    398510,
    'Mountain',
    'Basic Land — Mountain',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    104,
    'L',
    '{R}',
    'Pauper'
  ),
  (
    398534,
    'Plains',
    'Basic Land — Plains',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    105,
    'L',
    '{W}',
    'Pauper'
  ),
  (
    398550,
    'Plains',
    'Basic Land — Plains',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    57,
    'L',
    '{W}',
    'Pauper'
  ),
  (
    398675,
    'Plains',
    'Basic Land — Plains',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    105,
    'L',
    '{W}',
    'Pauper'
  ),
  (
    398472,
    'Swamp',
    'Basic Land — Swamp',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,

    132,
    'L',
    '{B}',
    'Pauper'
  ),
  (
    398555,
    'Swamp',
    'Basic Land — Swamp',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,

    106,
    'L',
    '{B}',
    'Pauper'
  ),
  (
    398677,
    'Swamp',
    'Basic Land — Swamp',
    'ORI',
    'C',
    NULL,
    0,
    NULL,
    NULL,
    NULL,
    NULL,
    
    107,
    'L',
    '{B}',
    'Pauper'
  );
-- END --

INSERT INTO baraja_carta VALUES(1, 398574);
INSERT INTO baraja_carta VALUES(2, 398578);
INSERT INTO baraja_carta VALUES(3, 401452);
INSERT INTO baraja_carta VALUES(4, 398565);
INSERT INTO baraja_carta VALUES(5, 398656);


-- Procedimientos almacenados --

-- pa_artista_cartas --
--Este procedimiento funciona de manera que dando un nombre de artista. Devuelva los nomnbres de las cartas que tiene este artista. --
 drop procedure if EXISTS pa_artista_carta;
 delimiter //
 create procedure pa_artista_carta(in p_artista varchar(50))
 begin
   select carta.nombre_carta
     from carta INNER  JOIN artista ON carta.codigo_artista = artista.codigo
     where artista.nombre = p_artista;
 end //
 delimiter ;
 -- Vamos a comprobar que ha funcionado el almacenamiento almacenado --
 call pa_artista_carta('Winona');
-- END --