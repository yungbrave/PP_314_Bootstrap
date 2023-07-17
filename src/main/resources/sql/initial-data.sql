insert into roles (id, name)
values (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

insert into users (id, name, email, password)
values (1, 'user_admin', 'user_admin@gmail.com', 100),
       (2, 'user', 'user@gmail.com', 100);

insert into users_roles
values (1, 1),
       (1, 2),
       (2, 1);

