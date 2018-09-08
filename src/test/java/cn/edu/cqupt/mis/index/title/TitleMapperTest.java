package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.Application;
import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class TitleMapperTest {

    @Autowired
    TitleMapper mapper;

    @Test
    public void getAllTitleInfo() {
        List<TitleDO> list = mapper.selectAllTitles();

        Assert.assertNotNull(list);
        Assert.assertEquals(3, list.size());

        for (TitleDO titleDO : list) {
            if (titleDO.getId() == 1) {
                Assert.assertEquals("Java 开发工程师", titleDO.getTitleName());
                Assert.assertEquals("主要负责 Web 服务端开发", titleDO.getDescription());
                Assert.assertEquals("/images/Java.png", titleDO.getPictureUrl());

            }
            else if (titleDO.getId() == 2) {
                Assert.assertEquals("JavaScript 开发工程师", titleDO.getTitleName());
                Assert.assertEquals("主要负责 Web 客户端开发", titleDO.getDescription());
                Assert.assertEquals("/images/JavaScript.png", titleDO.getPictureUrl());
            }
            else if (titleDO.getId() == 3) {
                Assert.assertEquals("产品经理", titleDO.getTitleName());
                Assert.assertEquals("主要负责产品设计与运营", titleDO.getDescription());
                Assert.assertEquals("/images/Pm.png", titleDO.getPictureUrl());
            }
        }
    }
}