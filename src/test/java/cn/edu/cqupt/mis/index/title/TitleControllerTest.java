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
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class TitleControllerTest {

    @Autowired
    TitleController controller;

    @Test
    public void getAllTitle() {
        Map<String, List<TitleDO>> result = controller.getAllTitle();
        List<TitleDO> list = result.get("info");
        Assert.assertEquals(3, list.size());
    }
}