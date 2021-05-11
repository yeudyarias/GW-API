
INSERT INTO pais (id_pais, nombre, descripcion) VALUES (1, 'Costa Rica','Costa Rica');
INSERT INTO pais (id_pais, nombre, descripcion) VALUES (2, 'Panama','Panama');
INSERT INTO pais (id_pais, nombre, descripcion) VALUES (3, 'Nicaragua','Nicaragua');
INSERT INTO pais (id_pais, nombre, descripcion) VALUES (4, 'Espana','Espana');

INSERT INTO cargo (id_cargo, nombre, descripcion) VALUES (1, 'Administrador','Administrador');
INSERT INTO cargo (id_cargo, nombre, descripcion) VALUES (2, 'Supervisor','Supervisor');
INSERT INTO cargo (id_cargo, nombre, descripcion) VALUES (3, 'Gerente','Gerente');

INSERT INTO `roles` (codigo, nombre) VALUES ('ROLE_USER','Usuario');
INSERT INTO `roles` (codigo, nombre) VALUES ('ROLE_ADMIN', 'Administrador');
INSERT INTO `roles` (codigo, nombre) VALUES ('ROLE_SUPERVISOR','Supervisor');


/* CREAMOS PERSONAS */
INSERT INTO persona (nombre,apellidos,identificacion,tipo_identificacion, fecha_nacimiento,email,direccion,sexo,estado_civil,telefono) VALUES ('Yeudy', 'Arias Alfaro','206330693','1', '1987-05-15', 'ygarialfa@gmail.com','Tronadora Tilaran','M', 'S', '84360288');
INSERT INTO persona (nombre,apellidos,identificacion,tipo_identificacion, fecha_nacimiento,email,direccion,sexo,estado_civil,telefono) VALUES ('Irene', 'Ugalde Perez','206330694','1', '1986-05-15', 'irene@gmail.com','Tronadora Tilaran','F', 'S', '84360287');
INSERT INTO persona (nombre,apellidos,identificacion,tipo_identificacion, fecha_nacimiento,email,direccion,sexo,estado_civil,telefono) VALUES ('Alberto', 'Ugalde Perez','206330695','1', '1988-05-15', 'alberto@gmail.com','Madrid','M', 'S', '84360286');


/* CREAMOS EMPLEADOS */

INSERT INTO empleado (id_empleado, id_cargo, id_pais,fecha_inicio,fecha_fin,tipo_salario,salario,monto_hora,estado,id_persona) VALUES (1,1,1,NOW(),NOW(),'1',3000,10,1,1);
INSERT INTO empleado (id_empleado, id_cargo, id_pais,fecha_inicio,fecha_fin,tipo_salario,salario,monto_hora,estado,id_persona) VALUES (2,2,1,NOW(),NOW(),'1',3000,10,1,2);
INSERT INTO empleado (id_empleado, id_cargo, id_pais,fecha_inicio,fecha_fin,tipo_salario,salario,monto_hora,estado,id_persona) VALUES (3,3,4,NOW(),NOW(),'1',3000,10,1,3);


/* Creamos algunos usuarios con sus roles*/ 
INSERT INTO `usuarios` (username, password, enabled,cambio_password,id_empleado) VALUES ('yeudy','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1,0,1);
INSERT INTO `usuarios` (username, password, enabled,cambio_password,id_empleado) VALUES ('irene','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1,0,2);
INSERT INTO `usuarios` (username, password, enabled,cambio_password,id_empleado) VALUES ('alberto','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1,0,3);


INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (3, 2);




