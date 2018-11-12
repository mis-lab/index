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

insert into title (id, title_name, picture_url, description, can_read)
values
       (1, 'Java 开发工程师', '/images/Java.svg', '主要负责 Web 服务端开发', true),
       (2, 'JavaScript 开发工程师', '/images/JavaScript.svg', '主要负责 Web 客户端开发', true),
       (3, '产品经理', '/images/PM.svg', '主要负责产品设计与运营', true),
       (4, '游戏动画设计', '', '', false),
       (5, '市场营销', '', '', false),
       (6, '测试工程师', '', '', false),
       (7, '软件开发工程师', '', '', false ),
       (8, 'iOS开发工程师', '', '', false ),
       (9, 'HR', '', '', false );

insert into graduate (id, name, title_id, job_name, student_id)
values
       (1, '陈嘉君', 2, '中移物联网', '2011211426'),
       (2, '程楷', 4, '凡乐科技', ''),
       (3, '雷光龙', 1, '思客技术', '2012211162'),
       (4, '曹榆', 5, '中移物联网', '2012211141'),
       (5, '雷鹏', 1, '美团', '08050120'),
       (6, '李敏', 7, '中信银行', 'S100701017'),
       (7, '百聪敏', 2, '腾讯', '2010211493'),
       (8, '吕海', 1, '阿里巴巴', ''),
       (9, '肖航', 3, 'YEX', '2011211228'),
       (10, '曾祥雯', 6, '绿盟科技', '2010211486'),
       (11, '王欣瑜', 2, '云兴维智', '2013210956'),
       (12, '冯迪', 1, '蚂蚁金服', '2012211140'),
       (13, '苏丹', 2, '阿里巴巴', '2014210868'),
       (14, '张永聪', 7, '小米', '2012211156'),
       (15, '黄若星', 2, '字节跳动', '2014210844'),
       (16, '刘晓梅', 8, '美丽星', '2012211115'),
       (17, '陈英豪', 1, '云兴维智', '2012211192'),
       (18, '唐德刚', 7, '蘑菇街', '2012211136'),
       (19, '曹强', 2, '北京神州绿盟信息安全股份有限公司', '2012211161'),
       (20, '朱珍珍', 2, '北京杏树林信息有限公司', '2012211114'),
       (21, '左逸飞', 3, '科大讯飞', '2014210870'),
       (22, '刘启丽', 3, '第四范式', '201221171'),
       (23, '毛家杰', 1, '深圳市随手科技有限公司', '2012211157'),
       (24, '魏超', 1, '猪八戒', '2012211193'),
       (25, '张怡斐', 9, '华为', '2012211073'),
       (26, '周军', 1, '京东', '2014210884'),
       (27, '牛勤艳', 2, '重庆海尔小额贷款有限公司', '2012211170'),
       (28, '罗琴', 2, '途风网', '2012211120'),
       (29, '杨青', 1, '有赞', '2014210872'),
       (30, '何海源', 1, '云兴维智', '2012211158'),
       (31, '方青', 2, '字节跳动', ''),
       (32, '张金胜', 1, '阿里巴巴', ''),
       (33, '韩雨潇', 1, '百度', '2015210989'),
       (34, '粱焕勋', 1, '广东联通', '2015210952'),
       (35, '马里杰', 7, 'ThoughtWorks', '2011211258'),
       (36, '戴林甫', 1, '华为', '2015210985');
