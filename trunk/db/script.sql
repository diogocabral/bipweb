alter table category drop foreign key FK302BCFEBAB22698
alter table user drop foreign key FK36EBCB75229FA2
drop table if exists category
drop table if exists document
drop table if exists user
create table category (id integer not null auto_increment, name varchar(255), description varchar(255), criteria varchar(255), terms varchar(255), parent_id integer, primary key (id))
create table document (id bigint not null auto_increment, title varchar(255), url varchar(255), primary key (id))
create table user (username varchar(255) not null, password varchar(255), rootCategory_id integer, primary key (username))
alter table category add index FK302BCFEBAB22698 (parent_id), add constraint FK302BCFEBAB22698 foreign key (parent_id) references category (id)
alter table user add index FK36EBCB75229FA2 (rootCategory_id), add constraint FK36EBCB75229FA2 foreign key (rootCategory_id) references category (id)
