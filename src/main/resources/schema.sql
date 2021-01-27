create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null
);

create table if not exists Hamburger (
  id identity,
  name varchar(50) not null,
  createdAt timestamp not null
);

create table if not exists Hamburger_Ingredients (
  hamburger bigint not null,
  ingredient varchar(4) not null
);

alter table Hamburger_Ingredients
    add foreign key (hamburger) references Hamburger(id);
alter table Hamburger_Ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Order_Hamburger (
	id identity,
    name varchar(50) not null,
);

create table if not exists Hamburger_Order_Hamburgers(
  hamburgerOrder bigint not null,
  hamburger bigint not null
);

alter table Hamburger_Order_Hamburgers
    add foreign key (hamburgerOrder) references Order_Hamburger(id);
alter table Hamburger_Order_Hamburgers
    add foreign key (hamburger) references Hamburger(id);