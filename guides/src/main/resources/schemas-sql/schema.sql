-- Active: 1715090636063@@localhost@33060@guides-app
CREATE DATABASE `guides-app`;

USE `guides-app`;

CREATE TABLE authentication_strategies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    strategy_name VARCHAR(255),
    strategy_type VARCHAR(255),
    strategy_description TEXT
);

CREATE TABLE payment_adapters (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    adapter_name VARCHAR(255),
    adapter_type VARCHAR(255),
    adapter_description TEXT
);

CREATE TABLE profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    last_name VARCHAR(255),
    gender VARCHAR(10),
    dni VARCHAR(20),
    email VARCHAR(255),
    phone_number VARCHAR(20),
    username VARCHAR(255),
    password VARCHAR(255),
    authentication_strategy_id BIGINT,
    credential_id VARCHAR(255),
    photo_id VARCHAR(255),
    score DOUBLE,
    booked BOOLEAN,
    cities TEXT,
    payment_adapter_id BIGINT,
    profile_type VARCHAR(20),
    CONSTRAINT fk_auth_strategy FOREIGN KEY (authentication_strategy_id) REFERENCES authentication_strategies (id),
    CONSTRAINT fk_tourist_payment_adapter FOREIGN KEY (payment_adapter_id) REFERENCES payment_adapters (id)
);

CREATE TABLE services (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255),
    `type` VARCHAR(255),
    `language` VARCHAR(255)
);

CREATE TABLE guide_services (
    profile_id BIGINT,
    service_id BIGINT,
    PRIMARY KEY (profile_id, service_id),
    FOREIGN KEY (profile_id) REFERENCES profiles (id),
    FOREIGN KEY (service_id) REFERENCES services (id)
);

CREATE TABLE trips (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profile_id BIGINT,
    guide_id BIGINT,
    service_id BIGINT,
    start_date DATE,
    end_date DATE,
    FOREIGN KEY (profile_id) REFERENCES profiles (id) ON DELETE CASCADE,
    FOREIGN KEY (guide_id) REFERENCES profiles (id),
    FOREIGN KEY (service_id) REFERENCES services (id)
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    trip_id BIGINT,
    profile_id BIGINT,
    sign_payment DOUBLE,
    total_amount DOUBLE,
    status VARCHAR(255),
    FOREIGN KEY (trip_id) REFERENCES trips (id),
    FOREIGN KEY (profile_id) REFERENCES profiles (id)
);

CREATE TABLE facturas (
    nro_factura BIGINT AUTO_INCREMENT PRIMARY KEY,
    reserva_id BIGINT,
    profile_id BIGINT,
    comision DOUBLE,
    total DOUBLE,
    FOREIGN KEY (reserva_id) REFERENCES books (id),
    FOREIGN KEY (profile_id) REFERENCES profiles (id)
);

CREATE TABLE reviews (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profile_id BIGINT,
    score INT,
    comment VARCHAR(255),
    FOREIGN KEY (profile_id) REFERENCES profiles (id) ON DELETE CASCADE
);

CREATE TABLE trophies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    profile_id BIGINT,
    type VARCHAR(255),
    FOREIGN KEY (profile_id) REFERENCES profiles (id) ON DELETE CASCADE
);

CREATE TABLE guides_cities (
    profile_id BIGINT,
    city VARCHAR(255),
    PRIMARY KEY (profile_id, city),
    FOREIGN KEY (profile_id) REFERENCES profiles (id)
);

ALTER TABLE facturas ADD COLUMN pendiente DOUBLE;

ALTER TABLE `profiles` ADD COLUMN `autenticacion` VARCHAR(255);

ALTER TABLE `profiles` ADD COLUMN `total_reviews` INT;