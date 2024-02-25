DROP DATABASE IF EXISTS db_elementary_school_management;
CREATE DATABASE IF NOT EXISTS db_elementary_school_management;
USE db_elementary_school_management;

SELECT DATABASE() AS 'Current Database';

SELECT * FROM tb_teacher;
SELECT * FROM tb_discipline;

CREATE TABLE IF NOT EXISTS tb_teacher
(
    id         BIGINT UNSIGNED AUTO_INCREMENT,
    name       VARCHAR(50) NOT NULL,
    cpf        VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NOT NULL,
    phone      VARCHAR(50) NOT NULL,
    address    VARCHAR(50) NOT NULL,
    birth_date DATE        NOT NULL,

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