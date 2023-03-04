create table IF NOT EXISTS course
(
    id     bigint       not null AUTO_INCREMENT,
    name   varchar(255) not null,
    author varchar(255) not null,
    primary key (id)
);
