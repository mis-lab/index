package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleMapper {
    /**
     * 获取数据库当中所有方向信息
     * @return 所有方向的信息
     */
    List<TitleDO> selectAllTitle();
}
