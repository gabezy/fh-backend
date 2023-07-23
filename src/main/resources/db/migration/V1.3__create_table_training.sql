create table training (
    id varchar(36) not null primary key ,
    name varchar(256) not null ,
    created_at timestamp not null,
    updated_at timestamp ,
    user_id varchar(36) not null ,
    foreign key (user_id) references users(id)
)