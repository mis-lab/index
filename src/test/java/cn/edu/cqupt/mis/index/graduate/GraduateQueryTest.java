package cn.edu.cqupt.mis.index.graduate;

import cn.edu.cqupt.mis.index.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class GraduateQueryTest {

    @Autowired
    GraduateQuery query;

    @Test
    public void countNumberByJobName() {
        Map<String, Integer> result = query.getJobDistributeInfo();

        Assert.assertNotNull(result);

        String[] jobNames = {"阿里巴巴","云智维新","京东","有赞","字节跳动"};

        Assert.assertEquals(1, result.getOrDefault(jobNames[0], 0).intValue());
        Assert.assertEquals(2, result.getOrDefault(jobNames[1], 0).intValue());
        Assert.assertEquals(1, result.getOrDefault(jobNames[2], 0).intValue());
        Assert.assertEquals(1, result.getOrDefault(jobNames[3], 0).intValue());
        Assert.assertEquals(2, result.getOrDefault(jobNames[4], 0).intValue());
    }
}