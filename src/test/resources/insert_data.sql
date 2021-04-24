// hasła do użytkowników: Test12345

insert into users(id, email, enabled, password, username)
    values (1000, 'testtest1@gmail.com', 1, '$2y$12$PQQ6HxQwyM/7V61SCjbMceMPOiBLyrqcNMy3MKcxJn4dvz9OIhTVC', 'testtest1');
insert into users(id, email, enabled, password, username)
    values (1001, 'testtest2@gmail.com', 1, '$2y$12$PQQ6HxQwyM/7V61SCjbMceMPOiBLyrqcNMy3MKcxJn4dvz9OIhTVC', 'testtest2');
insert into users(id, email, enabled, password, username)
    values (1002, 'testtest3@gmail.com', 1, '$2y$12$PQQ6HxQwyM/7V61SCjbMceMPOiBLyrqcNMy3MKcxJn4dvz9OIhTVC', 'testtest3');

insert into roles(id, name)
    values (1, 'ROLE_USER');
insert into roles(id, name)
    values (2, 'ROLE_ADMIN');

insert into users_roles(user_id, role_id)
    values (1000, 1);
insert into users_roles(user_id, role_id)
    values (1001, 1);
insert into users_roles(user_id, role_id)
    values (1002, 1);

insert into trips(id, name, user_id)
    values (100, 'Polska', 1000);
insert into trips(id, name, user_id)
    values (101, 'Niemcy', 1000);
insert into trips(id, name, user_id)
    values (102, 'Czechy', 1001);
insert into trips(id, name, user_id)
    values (103, 'Słowacja', 1001);
insert into trips(id, name, user_id)
    values (104, 'Ukraina', 1002);

insert into destinations(id, day, hours, month, place, year, trip_id)
    values (101, 20, 10, 10, 'Berlin', 2022, 101);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (101, 20, 10, 10, 'Hamburg', 2022, 101);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (101, 20, 10, 10, 'Monachium', 2022, 101);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (102, 20, 10, 10, 'Praga', 2022, 102);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (102, 20, 10, 10, 'Ostrawa', 2022, 102);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (102, 20, 10, 10, 'Brno', 2022, 102);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (103, 20, 10, 10, 'Bratysława', 2022, 103);
insert into destinations(id, day, hours, month, place, year, trip_id)
    values (104, 20, 10, 10, 'Lwów', 2022, 104);
