package cn.edu.cqupt.mis.index.graduate;

import cn.edu.cqupt.mis.index.Application;
import cn.edu.cqupt.mis.index.entity.GraduateDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class GraduateMapperTest {

    @Autowired
    GraduateMapper mapper;

    @Test
    public void selectAllGraduates() {
        List<GraduateDO> list = mapper.selectAllGraduates();

        Assert.assertNotNull(list);
        Assert.assertEquals(7, list.size());
    }

}