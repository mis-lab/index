use mis_index;

delete from graduate;

delete from title;

insert into title (id, title_name, picture_url, description)
values (1, 'Java 开发工程师', '/images/Java.png', '主要负责 Web 服务端开发');

insert into title (id, title_name, picture_url, description)
values (2, 'JavaScript 开发工程师', '/images/JavaScript.png', '主要负责 Web 客户端开发');

insert into title (id, title_name, picture_url, description)
values (3, '产品经理', '/images/Pm.png', '主要负责产品设计与运营');

insert into graduate (id, name, title_id, job_name)
values (1, '何海源', 1, '云智维新');

insert into graduate (id, name, title_id, job_name)
values (2, '王欣瑜', 2, '云智维新');

insert into graduate (id, name, title_id, job_name)
values (8, '张金胜', 1, '阿里巴巴');

insert into graduate (id, name, title_id, job_name)
values (3, '周军', 1, '京东');

insert into  graduate (id, name, title_id, job_name)
values (4, '杨青', 1, '有赞');

insert into graduate (id, name, title_id, job_name)
values (5, '黄若星', 2, '字节跳动');

insert into graduate (id, name, title_id, job_name)
values (6, '方青', 2, '字节跳动');

insert into graduate (id, name, title_id, job_name)
values (7, '左逸飞', 3, '科大讯飞');