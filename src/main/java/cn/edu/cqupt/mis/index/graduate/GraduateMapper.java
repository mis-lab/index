package cn.edu.cqupt.mis.index.graduate;

import cn.edu.cqupt.mis.index.entity.GraduateDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映射操作 graduate 数据表的接口
 * @author hanyuxiao
 */
@Repository
public interface GraduateMapper {

    /**
     * 从数据库当中选取所有的已经毕业了的同学的信息
     * @return 所有已经毕业了的同学的信息
     */
    List<GraduateDO> selectAllGraduates();
}
