create database shop CHARACTER SET utf8;

CREATE USER 'back'@'localhost' IDENTIFIED BY 'admin123';
CREATE USER 'back'@'%' IDENTIFIED BY 'admin123';

GRANT ALL PRIVILEGES ON shop.* TO 'back'@'localhost';
GRANT ALL PRIVILEGES ON shop.* TO 'back'@'%';

use shop;

create table user
(
    id           int auto_increment
        primary key,
    name         varchar(20)                        not null,
    nickname     varchar(30)                        not null,
    password     varchar(255)                       not null,
    phone_number varchar(20)                        not null,
    email        varchar(100)                       not null,
    sex          char                               null,
    auth         varchar(10)                        null,
    create_at    datetime default CURRENT_TIMESTAMP null,
    login_at     datetime default CURRENT_TIMESTAMP null,
    constraint user_email_uindex
        unique (email)
);

create index user_name_index
    on user (name);

create table `order`
(
    id           int auto_increment
        primary key,
    user_id      int                                not null,
    order_number varchar(12)                        not null,
    product_name varchar(100)                       not null,
    order_at     datetime default CURRENT_TIMESTAMP null,
    constraint order_order_number_uindex
        unique (order_number)
);
