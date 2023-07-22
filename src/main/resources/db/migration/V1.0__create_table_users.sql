CREATE TABLE users (
    id varchar(36) not null primary key ,
    username varchar(100) not null unique ,
    password varchar(15) not null ,
    create_at timestamp not null ,
    update_at timestamp not null ,
    email varchar(200) not null unique
);