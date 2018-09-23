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

    /**
     * 获取工作室能够对外展示的发展方向的信息，比如 Java 开发工程师
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<String, List<TitleDO>> getAllTitle() {
        List<TitleDO> titleList  = query.getAllCanReadTitles();
        HashMap<String, List<TitleDO>> result = new HashMap<>(1);
        result.put("info", titleList);
        return result;
    }

}
