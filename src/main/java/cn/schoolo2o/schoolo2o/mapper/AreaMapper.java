package cn.schoolo2o.schoolo2o.mapper;

import cn.schoolo2o.schoolo2o.pojo.Area;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaMapper {
    /**
     * 获取区域信息
     * @return
     */
    List<Area> getAreas();
}
