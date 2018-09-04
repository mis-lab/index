package cn.edu.cqupt.mis.index.graduate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理已经毕业了的同学的相关信息的 Controller，负责分发请求与响应请求
 * @author hanyuxiao
 */
@RestController
@RequestMapping("/graduate")
public class GraduateController {

    @Autowired
    private GraduateQuery query;

    @RequestMapping(value = "/jobDistribute", method = RequestMethod.GET)
    public Map<String, Map<String, Integer>> getGraduateJobDistribute () {
        Map<String, Integer> info = query.getJobDistributeInfo();
        Map<String, Map<String, Integer>> result = new HashMap<>(1);
        result.put("info", info);
        return result;
    }

}
