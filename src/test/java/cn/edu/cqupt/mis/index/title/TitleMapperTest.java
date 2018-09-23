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
    public void getAllTitleInfo_false() {
        List<TitleDO> list = mapper.selectTitleByCanRead(true);
        Assert.assertNotNull(list);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void getAllTitleInfo_true() {
        List<TitleDO> list = mapper.selectTitleByCanRead(false);
        Assert.assertNotNull(list);
        Assert.assertEquals(0, list.size());
    }
}