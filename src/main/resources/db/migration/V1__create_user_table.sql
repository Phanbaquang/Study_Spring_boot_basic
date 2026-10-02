CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255),
    name VARCHAR(255),
    "phoneNumber" VARCHAR(10),
    address VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    cccd VARCHAR(255),
    last_login TIMESTAMP,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS products (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255),
    price DECIMAL(19, 2),
    category VARCHAR(255),
    status VARCHAR(255)
    );
