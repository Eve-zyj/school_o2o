package cn.schoolo2o.schoolo2o.service;

import cn.schoolo2o.schoolo2o.mapper.AreaMapper;
import cn.schoolo2o.schoolo2o.pojo.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements  AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> getAreas() {
        return areaMapper.getAreas();
    }
}
