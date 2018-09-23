package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责处理工作室路径信息的查询与日志记录
 * @author hanyuxiao
 */
@Service
public class TitleQuery {

    private Logger logger = LoggerFactory.getLogger(TitleQuery.class);

    @Autowired
    TitleMapper mapper;

    /**
     * 默认获得工作室对外公布的发展方向，比如 Java 开发工程师，不获取那些没有公布的发展方向
     * 例如游戏动画设计
     *
     * @return 工作室对外公布的发展方向
     */
    public List<TitleDO> getAllCanReadTitles() {
        return getTitles(true);
    }

    /**
     * canRead 那些方向是否需要对外展示，需要对外展示的方向他们 canRead 的关键字的值为 true
     * 不需要展示的方向的 canRead 的关键字值为 false
     *
     * 这个方法是根据业务的需求选取那些需要对外展示的方向或者是不需要对外展示的方向
     *
     * @param canRead 是否需要对外展示
     * @return 需要对外展示的方向
     *         不需要对外展示的方向
     */
    private List<TitleDO> getTitles(boolean canRead) {
        List<TitleDO> list = mapper.selectTitleByCanRead(canRead);

        if (list == null) {
            logger.info("getTitles : canRead={}, result is null", canRead);
            list = new ArrayList<>(0);
        }

        return list;
    }
}
