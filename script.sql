create database teamknowlogy;

use teamknowlogy;

create table secuences (
    id int not null auto_increment,
    dna text(500) not null,
    result tinyint(1) not null,
    primary key (id),
    key secuences_result_IDX (result) using btree,
    fulltext key secuences_dna_IDX (dna)
) engine=InnoDB charset=utf8;