package cn.edu.cqupt.mis.index.title;

import cn.edu.cqupt.mis.index.entity.TitleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitleQuery {

    private Logger logger = LoggerFactory.getLogger(TitleQuery.class);

    @Autowired
    TitleMapper mapper;

    public List<TitleDO> getAllTitles() {
        logger.info("getAllTitle");

        List<TitleDO> list = mapper.selectAllTitle();

        if (list == null) {
            list = new ArrayList<>(0);
        }

        return list;
    }
}
