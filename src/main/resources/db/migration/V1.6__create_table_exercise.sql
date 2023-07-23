create table exercises (
    id varchar(36) not null primary key ,
    weight int not null ,
    repetitions int not null ,
    sets int not null ,
    notes varchar(256) ,
    workout_id varchar(36) not null ,

    foreign key (workout_id) references workouts(id)
)