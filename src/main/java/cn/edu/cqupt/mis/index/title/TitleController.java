package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 处理工作室路径信息的 Controller，负责分发请求与响应信息
 * @author hanyuxiao
 */
@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleQuery query;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public HashMap<String, List<TitleDO>> getAllTitle() {
        List<TitleDO> titleList  = query.getAllTitles();
        HashMap<String, List<TitleDO>> result = new HashMap<>(1);
        result.put("info", titleList);
        return result;
    }

}
