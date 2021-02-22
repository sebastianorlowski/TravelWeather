create table users(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      email varchar ( 50 ) not null UNIQUE,
                      password varchar ( 100 ) not null,
                      enabled boolean not null
);