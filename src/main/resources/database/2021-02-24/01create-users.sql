--liquibase formatted sql
--changeset sorlowski:1

CREATE TABLE users (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username varchar ( 50 ) not null UNIQUE,
                      email varchar (50) not null UNIQUE,
                      password varchar ( 100 ) not null,
                      enabled boolean not null
);

--changeset sorlowski:2

insert into users (id, username, email, password, enabled)
values (1, 'test', 'sebekovsky@gmail.com', '{bcrypt}$2y$12$ZNBTfM5pnDml.7AlvBFKKu.vbRu/41B2OYF6Ah7VZA0YxqIPUyFjO', true);

insert into users (id, username, email, password, enabled)
values (2, 'sebastian', 'sebekovsky123@gmail.com', '{bcrypt}$2y$12$3.jsH5ZVkPlkotwnsin03.BnrM4BePRscpJzS3f2usAwnYMI4/fTG', true);

insert into users (id, username, email, password, enabled)
values (3, 'komputer123', 'sebastian@gmail.com', '{bcrypt}$2y$12$K5YDZZC07AH4Acp.CG8vQOqHhouS5PLUpDu.1ysZzD1KqlifGCs3i', true);