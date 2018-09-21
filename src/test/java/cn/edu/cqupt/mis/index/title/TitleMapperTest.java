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
        List<TitleDO> list = mapper.selectAllTitlesWhichCanRead();
        Assert.assertNotNull(list);
        Assert.assertEquals(3, list.size());
    }
}