
CREATE SEQUENCE cultural_building_sequence START 7 INCREMENT 50;


-- create table cinema (
--     number_of_balconies int4 not null,
--     scene varchar(255) not null,
--     id_place int8 not null,
--     primary key (id_place)
-- );
--
-- create table cultural_building (
--     id_place int8 not null,
--     address varchar(253) not null,
--     capacity int4 not null,
--     name varchar(255) not null,
--     type_of_building varchar(255) not null,
--     primary key (id_place)
-- );
--
-- create table theater (
--      screen_size int4 not null,
--      screen_type varchar(255) not null,
--      id_place int8 not null,
--      primary key (id_place)
-- );
--
--
-- alter table cinema
--     add constraint FKkfl2pard931sxcpjid8tflxqb
--         foreign key (id_place)
--             references cultural_building;
--
-- alter table theater
--     add constraint FKh4qs15du66emr5gf1ma2buavv
--         foreign key (id_place)
--             references cultural_building;


-- alter table cinema
--     drop constraint FKkfl2pard931sxcpjid8tflxqb;
--
-- alter table theater
--     drop constraint FKh4qs15du66emr5gf1ma2buavv;
--
--
-- drop table if exists cinema cascade;
--
-- drop table if exists cultural_building cascade;
--
-- drop table if exists theater cascade;
--
-- drop sequence if exists cultural_building_sequence;
--
--
