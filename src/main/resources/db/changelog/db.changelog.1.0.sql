-- liquibase formatted sql

-- changeset T.Navitski:id1

CREATE TABLE app_user
(
    ID                VARCHAR(255) PRIMARY KEY NOT NULL,
    FIRST_NAME        VARCHAR(50)              NOT NULL,
    LAST_NAME         VARCHAR(50)              NOT NULL,
    EMAIL             VARCHAR(100)             NOT NULL,
    PHONE_NUMBER      VARCHAR(15),
    DATE_OF_BIRTH     DATE                     NOT NULL,
    IMAGE_URI         VARCHAR(1000),
    DATE_CREATED      DATE                     NOT NULL,
    DATE_LAST_UPDATED DATE,
    STATUS            VARCHAR(255)             NOT NULL
)

-- ROLLBACK DROP TABLE IF EXISTS APP_USER;
