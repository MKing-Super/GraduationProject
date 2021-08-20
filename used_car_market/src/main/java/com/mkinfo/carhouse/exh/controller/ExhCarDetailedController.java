package com.mkinfo.carhouse.exh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mkinfo.carhouse.dict.model.BaseDict;
import com.mkinfo.carhouse.dict.service.BaseDictService;
import com.mkinfo.carhouse.exh.model.ExhCarDetailed;
import com.mkinfo.carhouse.exh.service.ExhCarDetailedService;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 车辆详细信息 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/exhCarDetailed")
public class ExhCarDetailedController {

    @Autowired
    private ExhCarDetailedService exhCarDetailedService;
    @Autowired
    private BaseDictService baseDictService;

    /**
     * @title: toExhCarDetailed
     * @path:       /exhCarDetailed/toExhCarDetailed
     * @description: 跳转到车辆详细信息表页面
     * @author: MK
     * @date: 2021-01-23 17:44
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-23 17:44 MK 修改
     */
    @RequestMapping("/toExhCarDetailed")
    public String toExhCarDetailed(){
        return "exh/ExhCarDetailed/ExhCarDetailed.html";
    }

    /**
     * @title: toAdd
     * @path:       /exhCarDetailed/toAdd
     * @description: 跳转到车辆详情添加页面
     * @author: MK
     * @date: 2021-01-23 18:26
     * @param: [model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-23 18:26 MK 修改
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        //车辆品牌
        QueryWrapper<BaseDict> brandEw = new QueryWrapper<>();
        brandEw.eq("DICTENABLE", "1");
        brandEw.eq("DICTTYPECODE", "car-brand");
        List<BaseDict> brandList = baseDictService.list(brandEw);
        //车辆级别（大中小型车）
        QueryWrapper<BaseDict> levelEw = new QueryWrapper<>();
        levelEw.eq("DICTENABLE", "1");
        levelEw.eq("DICTTYPECODE", "car-level");
        List<BaseDict> levelList = baseDictService.list(levelEw);
        //排放标准
        QueryWrapper<BaseDict> emissionstandardEw = new QueryWrapper<>();
        emissionstandardEw.eq("DICTENABLE","1");
        emissionstandardEw.eq("DICTTYPECODE","car-emissionstandard");
        List<BaseDict> emissionstandardList = baseDictService.list(emissionstandardEw);

        model.addAttribute("brandList", brandList);
        model.addAttribute("levelList",levelList);
        model.addAttribute("emissionstandardList",emissionstandardList);
        return "exh/ExhCarDetailed/ExhCarDetailed_add.html";
    }

    /**
     * @title: list
     * @path:       /exhCarDetailed/list
     * @description: 获取所有的二手车详细信息
     * @author: MK
     * @date: 2021-01-23 18:01
     * @param: []
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-23 18:01 MK 修改
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        List<ExhCarDetailed> list = exhCarDetailedService.list();
        return list;
    }

    /**
     * @title: add
     * @path:       /exhCarDetailed/add
     * @description: 添加车辆详细信息数据
     * @author: MK
     * @date: 2021-01-23 19:45
     * @param: [exhCarDetailed]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-23 19:45 MK 修改
     */
    @RequestMapping("/add")
    @ResponseBody
    public boolean add(ExhCarDetailed exhCarDetailed){
        exhCarDetailed.setSheetid(UUIDUtil.getUUID());
        String brand = baseDictService.getById(exhCarDetailed.getBrand()).getDicttypename();
        String series = baseDictService.getById(exhCarDetailed.getSeries()).getDicttypename();
        String model = baseDictService.getById(exhCarDetailed.getModel()).getDicttypename();
        exhCarDetailed.setBrand(brand);
        exhCarDetailed.setSeries(series);
        exhCarDetailed.setModel(model);
        boolean save = exhCarDetailedService.save(exhCarDetailed);
        return save;
    }

}

