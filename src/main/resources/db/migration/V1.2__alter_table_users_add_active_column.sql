alter table users add column active smallint default 1;
update users set active = 1;