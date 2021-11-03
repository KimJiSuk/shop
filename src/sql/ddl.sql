create database shop CHARACTER SET utf8;

CREATE USER 'back'@'localhost' IDENTIFIED BY 'admin123';
CREATE USER 'back'@'%' IDENTIFIED BY 'admin123';

GRANT ALL PRIVILEGES ON shop.* TO 'back'@'localhost';
GRANT ALL PRIVILEGES ON shop.* TO 'back'@'%';

use shop;

create table user
(
    id int auto_increment,
    name VARCHAR(20) not null,
    nickname VARCHAR(30) not null,
    password VARCHAR(255) not null,
    phone_number int not null,
    email VARCHAR(100) not null,
    sex CHAR null,
    create_at DATETIME default NOW() null,
    login_at DATETIME default NOW() null,
    constraint user_pk
        primary key (id)
);

create index user_name_index
    on user (name);

create unique index user_email_uindex
    on user (email);

create table `order`
(
    id int auto_increment,
    order_number VARCHAR(12) not null,
    product_name VARCHAR(100) not null,
    order_at DATETIME default NOW(),
    constraint order_pk
        primary key (id)
);

create unique index order_order_number_uindex
    on `order` (order_number);
