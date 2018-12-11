# Hibernate One-To-Many Bi-Directional with Foreign Key Association [![HitCount](http://hits.dwyl.io/dawidpopiolkiewicz/hibernate-one-to-many-bi.svg)](http://hits.dwyl.io/dawidpopiolkiewicz/hibernate-one-to-many-bi)
Examples shows User and Course in one-to-many bi-directional relationships so it's possible to navigate by two sides - User to Course and 
User and Address are in one-to-one unidirectional relationship. That means only one side navigation is possible (in this case User to Address).

## :clapper: Screenshots
![onetomany](https://github.com/dawidpopiolkiewicz/hibernate-one-to-many-bi/blob/master/src/main/resources/img/onetomanyentities.jpg)
![onetomanydiagram](https://github.com/dawidpopiolkiewicz/hibernate-one-to-many-bi/blob/master/src/main/resources/img/onetomanydiagram.jpg)
![onetomanysql](https://github.com/dawidpopiolkiewicz/hibernate-one-to-many-bi/blob/master/src/main/resources/img/onetomanysql.jpg)
## :beginner: Technologies
* Hibernate 5.2.17
* MySQL 6.0.6
* Maven 4.0

## :construction_worker: Scripts used to create tables

```sql

create table address (
id int(11) not null auto_increment,
street varchar(45) default null,
city varchar(45) default null,
zip_code varchar(45) default null,
primary key (id)
);

create table user (
id int(11) not null auto_increment,
first_name varchar(45) default null,
last_name varchar(45) default null,
address_id int(11) default null,
primary key (id),
key FK_ADDRESS_idx (address_id),
constraint FK_ADDRESS foreign key (address_id)
references address (id)
);

create table course (
id int(11) not null auto_increment,
title varchar(128) default null,
user_id int(11) default null,
primary key (id),
unique key title_unique (title),
key FK_USER_idx (user_id),
constraint FK_USER
foreign key (user_id)
references user (id)
);
```
## :e-mail: Contact
Created by <dawid.popiolkiewicz@gmail.com> - feel free to contact me! :boom:
