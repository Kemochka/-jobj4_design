insert into users (id, name, role_id) values (1, 'Oleg', 1);
insert into users (id, name, role_id) values (2, 'Igor', 2);
insert into users (id, name, role_id) values (3, 'Vlad', 3);

insert into roles (id, name) values (1, 'Admin');
insert into roles (id, name) values (2, 'User');
insert into roles (id, name) values (3, 'Director');

insert into rules (id, name) values (1, 'Admin rules');
insert into rules (id, name) values (2, 'User rules');
insert into rules (id, name) values (3, 'Director rules');

insert into roles_rules (role_id, rule_id) values (1, 1);
insert into roles_rules (role_id, rule_id) values (2, 2);
insert into roles_rules (role_id, rule_id) values (3, 3);

insert into items (id, name, user_id, category_id, states_id) values (1, 'Items 1', 1, 1, 1);
insert into items (id, name, user_id, category_id, states_id) values (2, 'Items 2', 2, 2, 2);
insert into items (id, name, user_id, category_id, states_id) values (3, 'Items 3', 3, 3, 3);

insert into comments (id, name, items_id) values (1, 'Comment1', 1);
insert into comments (id, name, items_id) values (2, 'Comment2', 2);
insert into comments (id, name, items_id) values (3, 'Comment3', 3);

insert into attachs (id, name, items_id) values (1, 'Attachs1', 1);
insert into attachs (id, name, items_id) values (2, 'Attachs2', 2);
insert into attachs (id, name, items_id) values (3, 'Attachs3', 3);

insert into states (id, name) values (1, 'State1');
insert into states (id, name) values (2, 'State2');
insert into states (id, name) values (3, 'State3');

insert into categories (id, name) values (1, 'Categories1');
insert into categories (id, name) values (2, 'Categories2');
insert into categories (id, name) values (3, 'Categories3');