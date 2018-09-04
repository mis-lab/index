create database if not exists mis_index default character set utf8 collate utf8_general_ci;

use mis_index;

drop table if exists graduate;

drop table if exists title;

create table title(
  id int primary key auto_increment comment '唯一标识',
  title_name varchar(255) comment '工作室发展方向的名称，例如：Java JavaScript',
  picture_url varchar(255) comment '首页是个轮播图，所以这里放一个 url',
  description varchar(255) comment '职位的描述',
  unique (title_name)
);

insert into title (id, title_name,  description)
values (1, 'Java 开发工程师', '主要负责 Web 服务端开发');

insert into title (id, title_name,  description)
values (2, 'JavaScript 开发工程师', '主要负责 Web 客户端开发');

insert into title (id, title_name,  description)
values (3, '产品经理', '主要负责产品设计与运营');

create table graduate (
  id int primary key auto_increment comment '唯一标识',
  name varchar(255) comment '已经毕业人员的名字',
  title_id int comment '这个同学之前在工作室是什么方向的',
  job_name varchar(255) comment '毕业后所在的公司的名称',
  foreign key (title_id) references title(id)
);

