alter table category drop foreign key FK302BCFEBAB22698
alter table category drop foreign key FK302BCFE2864BA77
alter table history drop foreign key FK373FE4949AF421C4
alter table history drop foreign key FK373FE49482AC7C5F
alter table user_category drop foreign key FK60616F238849BE6
alter table user_category drop foreign key FK60616F2F8330EC2
drop table if exists category
drop table if exists history
drop table if exists user
drop table if exists user_category
create table category (id bigint not null auto_increment, name varchar(255), description varchar(255), criteria varchar(255), shared bit not null, owner_username varchar(255), parent_id bigint, primary key (id))
create table history (id bigint not null auto_increment, title varchar(255), url varchar(255), score float, feedbackScore float, category_id bigint, user_username varchar(255), primary key (id))
create table user (username varchar(255) not null, password varchar(255), primary key (username))
create table user_category (users_username varchar(255) not null, categories_id bigint not null, primary key (users_username, categories_id))
alter table category add index FK302BCFEBAB22698 (parent_id), add constraint FK302BCFEBAB22698 foreign key (parent_id) references category (id)
alter table category add index FK302BCFE2864BA77 (owner_username), add constraint FK302BCFE2864BA77 foreign key (owner_username) references user (username)
alter table history add index FK373FE4949AF421C4 (category_id), add constraint FK373FE4949AF421C4 foreign key (category_id) references category (id)
alter table history add index FK373FE49482AC7C5F (user_username), add constraint FK373FE49482AC7C5F foreign key (user_username) references user (username)
alter table user_category add index FK60616F238849BE6 (categories_id), add constraint FK60616F238849BE6 foreign key (categories_id) references category (id)
alter table user_category add index FK60616F2F8330EC2 (users_username), add constraint FK60616F2F8330EC2 foreign key (users_username) references user (username)
