INSERT INTO enfermedad (id, nombre) VALUES (1, 'Rubeola');
INSERT INTO enfermedad (id, nombre) VALUES (2, 'HIV');
INSERT INTO enfermedad (id, nombre) VALUES (3, 'Apendicitis');
INSERT INTO enfermedad (id, nombre) VALUES (4, 'Epistaxis');
INSERT INTO enfermedad (id, nombre) VALUES (5, 'Sarampion');
INSERT INTO enfermedad (id, nombre) VALUES (6, 'Asma');
INSERT INTO enfermedad (id, nombre) VALUES (7, 'Colecistitis');
INSERT INTO enfermedad (id, nombre) VALUES (8, 'Hemofilia');
INSERT INTO enfermedad (id, nombre) VALUES (9, 'Varicela');
INSERT INTO enfermedad (id, nombre) VALUES (10, 'Diabetes');
INSERT INTO enfermedad (id, nombre) VALUES (11, 'Epilepcia');
INSERT INTO enfermedad (id, nombre) VALUES (12, 'Desmayos/Mareos');
INSERT INTO enfermedad (id, nombre) VALUES (13, 'Hepatitis');
INSERT INTO enfermedad (id, nombre) VALUES (14, 'Ulceras');
INSERT INTO enfermedad (id, nombre) VALUES (15, 'Brucelosis');
INSERT INTO enfermedad (id, nombre) VALUES (16, 'Otra');

INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos Paciente */

INSERT INTO clientes (identificacion, nombre, fecha_nacimiento, sexo, grupo_sanguineo, estado_civil, religion, email, telefono, direccion, fecha_ingreso, observacion) VALUES ('206330693', 'Yeudy Arias Alfaro', '1987-05-15', 'm','a+','s', 'c', 'ygarialfa@gmail.com', '84360288','San Jose, sabana sur 50 sur de la pops','2020-05-05', 'Paciente cardiopata');
/* Creamos alguos contactos */

INSERT INTO contactos (nombre, parentesco, telefono, email, cliente_id, fecha_ingreso) VALUES ("Francela Arias Alfaro", "h", "88882222","franarial@gmail.com", 1, NOW());

/* Creamos enfermedades al paciente */

INSERT INTO paciente_enfermedad (cliente_id, enfermedad_id) VALUES(1, 1);
INSERT INTO paciente_enfermedad (cliente_id, enfermedad_id) VALUES(1, 7);
INSERT INTO paciente_enfermedad (cliente_id, enfermedad_id) VALUES(1, 11);
INSERT INTO paciente_enfermedad (cliente_id, enfermedad_id) VALUES(1, 13);
INSERT INTO paciente_enfermedad (cliente_id, enfermedad_id) VALUES(1, 16);

/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

