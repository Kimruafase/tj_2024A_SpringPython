-- [1] DB 생성
--drop database if exists springpy;
--create database springpy;
--use springpy;

-- [2] 테이블 생성
drop table if exists user;
create table user(
    id int auto_increment,
    name varchar(20) not null,
    age int,
    primary key (id)
);

drop table if exists account;
create table Account(
    accnum int auto_increment,
    accexp varchar(255),
    accmoney int,
    accdate datetime default now(),
    primary key (accnum)
);

