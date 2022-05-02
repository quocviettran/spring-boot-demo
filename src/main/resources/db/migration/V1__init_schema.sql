create table Person (
    id int generated always as identity,
    name varchar(255) not null,
    age int not null,
    primary key(id)
);

create table Catalogue (
   id int generated always as identity,
   name varchar(255) not null,
   primary key(id)
);

create table Catalogue_person(
    id int generated always as identity,
    person_id int not null,
    catalogue_id int not null,
    primary key(id),
    foreign key (person_id) references Person(id),
    foreign key (catalogue_id) references Catalogue(id)
);
