drop table users;

CREATE TABLE users (
    id varchar(36) not null primary key ,
    username varchar(100) not null unique ,
    password varchar(15) not null ,
    created_at timestamp not null ,
    updated_at timestamp ,
    email varchar(200) not null unique
);