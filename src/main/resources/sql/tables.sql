drop table if exists users;

drop table if exists roles;

drop table if exists users_roles;

create table if not exists users (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) not null,
    password VARCHAR(45) not null,
    email VARCHAR(45) not null
);