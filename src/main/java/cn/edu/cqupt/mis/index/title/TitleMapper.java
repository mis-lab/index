package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映射操作 title 数据表的接口
 * @author hanyuxiao
 */
@Repository
public interface TitleMapper {
    /**
     * 获取工作室当中所有方向的信息，参数 canRead 对应了数据表当中 can_read 这样一个
     * 字段，这个字段表示是否对外展示某一些数据，比如如果是主页请求，那么我们就只展示
     * can_read 为 true 的这样一些数据，不展示 can_read 为 false 的数据
     *
     * @return 根据是否对外公布来返回这样的一些数据
     */
    public List<TitleDO> selectTitleByCanRead(@Param(value = "canRead") boolean canRead);
}
