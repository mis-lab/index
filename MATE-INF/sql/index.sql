create database if not exists mis_index default character set utf8 collate utf8_general_ci;

use mis_index;

drop table if exists graduate;

drop table if exists title;

create table title(
  id int primary key auto_increment comment '唯一标识',
  title_name varchar(255) comment '工作室发展方向的名称，例如：Java JavaScript',
  picture_url varchar(255) comment '这个方向的图标',
  description varchar(255) comment '职位的描述，主要是描述了这个方向在我们工作室主要做什么事情',
  can_read boolean comment '表示这个方向是否在工作室主页当中展示，1 表示是，0 表示没有' default false,
  unique (title_name)
);

create table graduate (
  id int primary key auto_increment comment '唯一标识',
  student_id varchar(255) comment '学号 这里可以为空，因为有的学长学姐把学号忘记了',
  name varchar(255) comment '已经毕业人员的名字',
  title_id int comment '这个同学之前在工作室是什么方向的',
  job_name varchar(255) comment '毕业后所在的公司的名称',
  foreign key (title_id) references title(id)
);

