CREATE DATABASE IF NOT EXISTS db_ecommerce_SuncionFabrizio;
USE db_ecommerce_SuncionFabrizio;

CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    marca VARCHAR(100),
    codigo_barras VARCHAR(50) UNIQUE
);

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(30) NOT NULL DEFAULT 'ROLE_USER'
);

INSERT INTO productos (nombre, categoria, precio, stock, marca, codigo_barras) VALUES
('Laptop Ideapad 3', 'Laptops', 2499.90, 10, 'Lenovo', '7501000000011'),
('Mouse Inalámbrico M185', 'Accesorios', 49.90, 50, 'Logitech', '7501000000028'),
('Monitor 24" FHD', 'Monitores', 549.00, 15, 'Samsung', '7501000000035');
