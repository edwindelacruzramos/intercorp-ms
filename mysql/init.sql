-- Para ms01
CREATE DATABASE IF NOT EXISTS db_ms01_kafka CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE db_ms01_kafka;

CREATE TABLE IF NOT EXISTS person_record (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             firstname VARCHAR(100),
    lastname VARCHAR(100),
    city VARCHAR(100),
    country VARCHAR(100),
    firstname2 VARCHAR(100),
    lastname2 VARCHAR(100),
    email VARCHAR(150),
    random INT,
    random_float DOUBLE,
    bool TINYINT(1),
    date DATE,
    reg_ex TEXT,
    enum_value VARCHAR(50),
    age INT,
    created_at DATETIME(6)
    );

DROP TABLE IF EXISTS person_elt;

CREATE TABLE person_elt (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            person_id BIGINT NOT NULL,
                            elt_value VARCHAR(100),
                            FOREIGN KEY (person_id) REFERENCES person_record(id) ON DELETE CASCADE
);

-- Para ms04
CREATE DATABASE IF NOT EXISTS db_ms04_kafka CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE db_ms04_kafka;

CREATE TABLE IF NOT EXISTS person_record (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             firstname VARCHAR(100),
    lastname VARCHAR(100),
    city VARCHAR(100),
    country VARCHAR(100),
    firstname2 VARCHAR(100),
    lastname2 VARCHAR(100),
    email VARCHAR(150),
    random INT,
    random_float DOUBLE,
    bool TINYINT(1),
    date DATE,
    reg_ex TEXT,
    enum_value VARCHAR(50),
    age INT,
    created_at DATETIME(6)
    );

DROP TABLE IF EXISTS person_elt;

CREATE TABLE person_elt (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            person_id BIGINT NOT NULL,
                            elt_value VARCHAR(100),
                            FOREIGN KEY (person_id) REFERENCES person_record(id) ON DELETE CASCADE
);
