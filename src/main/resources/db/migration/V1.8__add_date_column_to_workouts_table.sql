alter table workouts add column workout_date date;
update workouts set workout_date = current_date;