DROP DATABASE IF EXISTS db_elementary_school_management;
CREATE DATABASE IF NOT EXISTS db_elementary_school_management;
USE db_elementary_school_management;

SELECT DATABASE() AS 'Current Database';

# Enums
SELECT * FROM tb_discipline;
SELECT * FROM tb_period;
SELECT * FROM tb_room;
SELECT * FROM tb_time;

SELECT * FROM tb_student;
SELECT * FROM tb_teacher;

CREATE TABLE IF NOT EXISTS tb_student
(
    id                 BIGINT UNSIGNED AUTO_INCREMENT,
    name               VARCHAR(50) NOT NULL,
    email              VARCHAR(50) NOT NULL,
    cpf                VARCHAR(50) NOT NULL,
    birth_date         DATE        NOT NULL,
    parent_name        VARCHAR(50) NOT NULL,
    parent_email       VARCHAR(50) NOT NULL,
    parent_phone       VARCHAR(50) NOT NULL,
    allergies          VARCHAR(50) NULL,
    medical_conditions VARCHAR(50) NULL,
    street             VARCHAR(50) NOT NULL,
    number             VARCHAR(50) NOT NULL,
    complement         VARCHAR(50) NULL,
    neighborhood       VARCHAR(50) NOT NULL,
    city               VARCHAR(50) NOT NULL,
    state              VARCHAR(50) NOT NULL,
    country            VARCHAR(50) NOT NULL,
    zip_code           VARCHAR(50) NOT NULL,

    UNIQUE (email),
    UNIQUE (cpf),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_teacher
(
    id           BIGINT UNSIGNED AUTO_INCREMENT,
    name         VARCHAR(50) NOT NULL,
    email        VARCHAR(50) NOT NULL,
    cpf          VARCHAR(50) NOT NULL,
    birth_date   DATE        NOT NULL,
    street       VARCHAR(50) NOT NULL,
    number       VARCHAR(50) NOT NULL,
    complement   VARCHAR(50) NULL,
    neighborhood VARCHAR(50) NOT NULL,
    city         VARCHAR(50) NOT NULL,
    state        VARCHAR(50) NOT NULL,
    country      VARCHAR(50) NOT NULL,
    zip_code     VARCHAR(50) NOT NULL,

    UNIQUE (email),
    UNIQUE (cpf),

    PRIMARY KEY (id)
);




CREATE TABLE IF NOT EXISTS tb_discipline
(
    id          BIGINT UNSIGNED AUTO_INCREMENT,
    name        ENUM (
        'MATH',
        'PHYSICS',
        'CHEMISTRY',
        'BIOLOGY',
        'HISTORY',
        'GEOGRAPHY',
        'PHILOSOPHY',
        'SOCIOLOGY',
        'PORTUGUESE',
        'ENGLISH',
        'SPANISH',
        'ARTS',
        'PHYSICAL_EDUCATION'
        )            NOT NULL,
    description TEXT NOT NULL,

    UNIQUE (name),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_period
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name ENUM ('MORNING', 'AFTERNOON', 'NIGHT') NOT NULL,

    UNIQUE (name),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_room
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name ENUM (
        'SALA01',
        'SALA02',
        'SALA03',
        'SALA04',
        'SALA05',
        'SALA06',
        'SALA07',
        'SALA08',
        'SALA09',
        'SALA10'
        ) NOT NULL,

    UNIQUE (name),

    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_time
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    name ENUM (
        'MORNING',
        'AFTERNOON',
        'EVENING',
        'NIGHT',
        'INTEGRAL') NOT NULL,

    UNIQUE (name),

    PRIMARY KEY (id)
);