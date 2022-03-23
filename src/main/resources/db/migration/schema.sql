create table Person (
    id int auto_increment,
    name varchar(255) not null,
    age int not null,
    primary key(id)
);

create table Catalogue (
   id int primary key auto_increment,
   name varchar(255) not null
);

create table Catalogue_person(
    id int auto_increment,
    person_id int not null,
    catalogue_id int not null,
    primary key(id),
    foreign key (person_id) references Person(id),
    foreign key (catalogue_id) references Catalogue(id)
)
