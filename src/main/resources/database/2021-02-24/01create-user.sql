--liquibase formatted sql
--changeset sorlowski:1

CREATE TABLE users(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username varchar ( 50 ) not null UNIQUE,
                      password varchar ( 100 ) not null,
                      enabled boolean not null
);

--changeset sorlowski:2

insert into users (id, username, password, enabled)
values (1, 'test', '{bcrypt}$2y$12$oal6VgjMFBeH./Z9xS0T0Oe9y3YkE1S7o9jcQr3Qtlh394eiMI0TK', true);