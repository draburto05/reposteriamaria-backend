USE reposteria_bk;
--------------------------------------------------
SELECT * FROM category;

-- ALTER TABLE category MODIFY descripcion VARCHAR(200);

INSERT INTO category (nombre_categoria, descripcion) VALUES
('Pasteles', 'Bizcocho suave, dulce y esponjoso'),
('Mojaditos', 'Bizcocho bañado en tres leches con diferentes toppings'),
('Tartas', 'Fruta fresca sobre base de galleta dulce y crujiente'),
('Galletas', 'Crujientes y deliciosas'),
('Cupcakes', 'Pequeños pastelitos decorados y rellenos');

-- DELETE FROM category where idcategory <26;
-- ALTER TABLE category auto_increment = 1;
----------------------------------------------------

INSERT INTO client (nombre, appaterno, apmaterno, email, contrasena, telefono, direccion) VALUES
('Amauri', 'Rincón', 'López', 'amauri@gmail.com', '1234', 9991205502, 'Tabasco, México'),
('Daniela', 'Ruiz', 'Aburto', 'danielaruiz@gmail.com', 'abcd123', 5575256754, 'Querétaro, Querétaro'),
('Yarumi', 'Garcia', 'Mendez', 'yarugm@gmail.com', 'yaru123', 5582937933, 'CDMX'),
('Mario', 'Ramos', 'Garcia', 'marioramos@gmail.com', 'mariora', 1234567890, 'Teziutlan, Puebla'),
('Marcos', 'Garnica', 'Rios','marcosgarnica@gmail.com', 'garnica1', 0123456789, 'CDMX');
SELECT * FROM client;
SELECT * FROM `order_buy`;


ALTER TABLE client MODIFY telefono VARCHAR(10);

ALTER TABLE `order_buy` DROP COLUMN ordecol;
ALTER TABLE `order_buy` DROP COLUMN categoria;

ALTER TABLE `order_buy` MODIFY idorder int auto_increment;

INSERT INTO `order_buy`(fecha, precio, tipo_entrega, client_idcliente)VALUES
('2025-07-18', 390, 'domicilio', 1),
('2025-07-19', 400, 'recoger en tienda', 2),
('2025-07-17', 280, 'domicilio', 3),
('2025-07-16', 65, 'recoger en tienda', 5),
('2025-07-15', 3000, 'domicilio', 4);


Select * from category;

INSERT INTO payment_method (tipo) VALUES
('pago en efectivo' ),
('pago con tarjeta' ),
('transferencia' ),
('OXXO' ),
('VALES ELECTRONICOS');
SELECT * FROM payment_method;

INSERT INTO product (nombre_producto, precio_producto, stock, tamano, sabor, imagen, order_idorder, category_idcategory) VALUES
('Pastel de 3 leches frutal',380.00,25,'mediano','fresas con crema','www.pasteldefresa.com',1,1),
('Tarta de queso', 390.00, 8, 'mediano', 'frutos rojos', 'www.tartaqueso.com',2,3),
('Mojadito 3 leches', 60.00, 10, 'individual', 'chocofresa', 'www.bizcocho.com',2,2),
('Cupcake chocolate', 30.00, 20, 'individual', 'chocolate', 'www.cupcakechocolate.com', 3, 5),
('Galletas chispas chocolate', 15.00, 50, 'individual', 'chocolate', 'www.galletaschispaschocolate.com', 4, 4);

SELECT * FROM product;

INSERT INTO shipment (direccion_entrega, num_seguimiento, estatus, order_idorder) VALUES
('Tabasco, México', 10000001, 'Preparando pedido', 1),
('Querétaro, Querétaro', 10000002, 'Pedido entregado', 2),
('CDMX', 10000003, "Pedido enviado", 3),
('CDMX', 10000004, "Pedido entregado", 4),
('Teziutlan, Puebla', 10000005, "Preparando pedido", 5);

SELECT * FROM shipment;

INSERT INTO payment_method_has_order (order_idorder) VALUES
( 1 ) , 
( 2 ) , 
( 3 ) , 
( 4 ) , 
( 5 ) ;

SELECT * FROM payment_method_has_order;
