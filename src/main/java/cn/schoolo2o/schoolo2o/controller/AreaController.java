package cn.schoolo2o.schoolo2o.controller;

import cn.schoolo2o.schoolo2o.pojo.Area;
import cn.schoolo2o.schoolo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping("/areaTest.html")
    public String areaTest(Model model){
        List<Area> areaList = areaService.getAreas();
        Area area = areaList.get(0);
        model.addAttribute("area",area);
        int name = area.getPriority();
        model.addAttribute("areaName",name);
        model.addAttribute("name","赵亚娟");
        model.addAttribute("areas",areaList);
        return "areaTest";
    }
}
