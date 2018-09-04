package cn.edu.cqupt.mis.index.graduate;

import cn.edu.cqupt.mis.index.entity.GraduateDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GraduateQuery {

    private Logger logger = LoggerFactory.getLogger(GraduateQuery.class);

    @Autowired
    GraduateMapper mapper;

    /**
     * 这个方法的名字可能有点奇怪，获取工作分布信息，就是统计在阿里巴巴有多少人，在百度有多少人
     *
     * @return 返回在每个公司有的人数
     */
    public Map<String, Integer> getJobDistributeInfo() {
        logger.info("getJobDistributeInfo");

        HashMap<String, Integer> distribute = new HashMap<>();

        List<GraduateDO> list = mapper.selectAllGraduates();

        if (list != null) {
            for (GraduateDO graduateDO : list) {
                String jobName = graduateDO.getJobName();
                Integer count = distribute.getOrDefault(jobName, 0) + 1;
                distribute.put(jobName, count);
            }
        }

        return distribute;
    }
}
