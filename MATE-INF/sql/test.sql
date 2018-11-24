use mis_index;

delete from graduate;

delete from title;

insert into title (id, title_name, picture_url, description, can_read)
values
       (1, 'Java 开发工程师', '/images/Java.svg', '主要负责 Web 服务端开发', true),
       (2, 'JavaScript 开发工程师', '/images/JavaScript.svg', '主要负责 Web 客户端开发', true),
       (3, '产品经理', '/images/PM.svg', '主要负责产品设计与运营', true);

insert into graduate (id, name, title_id, job_name, student_id)
values
       (1, '何海源', 1, '云智维新', '2012210001'),
       (2, '王欣瑜', 2, '云智维新', '2013210001'),
       (8, '张金胜', 1, '阿里巴巴', '2013210002'),
       (3, '周军', 1, '京东', '2014210001'),
       (4, '杨青', 1, '有赞', '2014210002'),
       (5, '黄若星', 2, '字节跳动', '2014210003'),
       (6, '方青', 2, '字节跳动', '2014210004'),
       (7, '左逸飞', 3, '科大讯飞', '2014210005');
