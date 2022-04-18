/* Populate tabla regiones */
INSERT INTO regiones (nombre) VALUES ('Sudamérica');
INSERT INTO regiones (nombre) VALUES ('Centroamérica');
INSERT INTO regiones (nombre) VALUES ('Norteamérica');
INSERT INTO regiones (nombre) VALUES ('Europa');
INSERT INTO regiones (nombre) VALUES ('Asia');
INSERT INTO regiones (nombre) VALUES ('Africa');
INSERT INTO regiones (nombre) VALUES ('Oceanía');
INSERT INTO regiones (nombre) VALUES ('Antártida');

/* Populate tabla clientes */
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Jhoan', 'Carlosama', 'jhoan@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Pepe', 'Perez', 'pepe@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Flor', 'Flores', 'flor@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Juan', 'Josa', 'juan@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Jorge', 'Paz', 'jorge@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Felipe', 'Pelaez', 'felipe@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Flora', 'Marin', 'flora@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Dilan', 'Lopez', 'dilan@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('John', 'Lopez', 'john@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Ana', 'Andes', 'ana@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Pilar', 'Pastas', 'pilar@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Pedro', 'Diaz', 'pedro@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Violeta', 'Diaz', 'violeta@gmail.com', 1, '2022-01-01');
INSERT INTO clientes (nombre, apellido, email, region_id, create_at) VALUES ('Daniela', 'Pantoja', 'daniela@gmail.com', 1, '2022-01-01');

/* usuarios y roles */
INSERT INTO usuarios (username, password, nombre, apellido, email, enabled) VALUES ('jhoan', '$2a$10$rSg8no54yNofdsAO8jA8OeIyjGPin/KsTKIT1aaqZLF7RPcSywvp2', 'jhoan', 'diaz', 'jhoan@gmail.com', 1);
INSERT INTO usuarios (username, password, nombre, apellido, email, enabled) VALUES ('admin', '$2a$10$XSB6lBNFnb4l/3MJtrEU2e20Eeh0xYYKjUgEhPpvSgVoTKV/r5Y86', 'pepe', 'perez', 'pepe@gmail.com', 1);

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO users_authorities (user_id, role_id) VALUES (1, 1);
INSERT INTO users_authorities (user_id, role_id) VALUES (2, 2);
INSERT INTO users_authorities (user_id, role_id) VALUES (2, 1);

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);