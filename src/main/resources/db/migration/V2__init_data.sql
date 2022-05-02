insert into person (name,age) values ('Jens',40);
insert into person (name,age) values ('Jensar',15);
insert into person (name,age) values ('Jensen',23);
insert into person (name,age) values ('Jensee',3);
insert into person (name,age) values ('Bob',15);
insert into person (name,age) values ('Bobar',90);
insert into person (name,age) values ('Bobby',56);
insert into person (name,age) values ('Bobsen',56);

insert into catalogue(name) values ('Oslo Katalog');
insert into catalogue(name) values ('Trondheim Katalog');
insert into catalogue(name) values ('Spesial Katalog');

-- Katalog Oslo
insert into catalogue_person(person_id,catalogue_id) values(1,1);
insert into catalogue_person(person_id,catalogue_id) values(2,1);
insert into catalogue_person(person_id,catalogue_id) values(3,1);
insert into catalogue_person(person_id,catalogue_id) values(4,1);
-- Katalog Trondheim
insert into catalogue_person(person_id,catalogue_id) values(5,2);
insert into catalogue_person(person_id,catalogue_id) values(6,2);
insert into catalogue_person(person_id,catalogue_id) values(7,2);
insert into catalogue_person(person_id,catalogue_id) values(8,2);
-- Katalog Spesial
insert into catalogue_person(person_id,catalogue_id) values(1,3);
insert into catalogue_person(person_id,catalogue_id) values(3,3);
insert into catalogue_person(person_id,catalogue_id) values(5,3);
insert into catalogue_person(person_id,catalogue_id) values(7,3);
