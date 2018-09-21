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
public class GraduateControllerTest {

    @Autowired
    GraduateController controller;

    @Test
    public void getGraduateJobDistribute_null() {
        Map<String, Map<String, Integer>> result = controller.getGraduateJobDistribute();
        Map<String, Integer> distribute = result.get("info");
        Assert.assertNotNull(distribute);
        Assert.assertEquals(6, distribute.size());
    }

}