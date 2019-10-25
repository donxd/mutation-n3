create database teamknowlogy;

use teamknowlogy;

create table secuences (
    id int not null auto_increment,
    dna text(500) not null,
    result tinyint(1) not null,
    primary key (id)
) engine=InnoDB charset=utf8;