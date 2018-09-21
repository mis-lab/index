package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映射操作 title 数据表的接口
 * @author hanyuxiao
 */
@Repository
public interface TitleMapper {
    /**
     * 获取数据库当中所有方向信息
     * @return 所有方向的信息
     */
    List<TitleDO> selectAllTitlesWhichCanRead();
}
