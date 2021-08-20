package com.mkinfo.carhouse.middle.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mkinfo.carhouse.dict.model.BaseDict;
import com.mkinfo.carhouse.dict.service.BaseDictService;
import com.mkinfo.carhouse.middle.model.CarDetailedMiddle;
import com.mkinfo.carhouse.middle.service.CarDetailedMiddleService;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 车辆详细信息中间表 前端控制器
 * </p>
 *
 * @author MK
 * @since 2021-01-21
 */
@Controller
@RequestMapping("/carDetailedMiddle")
public class CarDetailedMiddleController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CarDetailedMiddleService carDetailedMiddleService;

    /**
     * @title: toCarDetailedMiddle
     * @path: /carDetailedMiddle/toCarDetailedMiddle
     * @description: TODO
     * @author: MK
     * @date: 2021-01-21 21:15
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-21 21:15 MK 修改
     */
    @RequestMapping(value = "/toCarDetailedMiddle")
    public String toCarDetailedMiddle(Model model) {
        QueryWrapper<BaseDict> ew1 = new QueryWrapper<>();
        ew1.eq("DICTENABLE", "1");
        ew1.eq("DICTTYPECODE", "car-brand");
        ew1.orderByDesc("CREATETIME");
        List<BaseDict> brandList = baseDictService.list(ew1);

        QueryWrapper<BaseDict> ew2 = new QueryWrapper<>();
        ew2.eq("DICTENABLE", "1");
        ew2.eq("DICTTYPECODE", "car-series");
        ew2.orderByDesc("CREATETIME");
        List<BaseDict> seriesList = baseDictService.list(ew2);

        QueryWrapper<BaseDict> ew3 = new QueryWrapper<>();
        ew3.eq("DICTENABLE", "1");
        ew3.eq("DICTTYPECODE", "car-model");
        ew3.orderByDesc("CREATETIME");
        List<BaseDict> modelList = baseDictService.list(ew3);

        model.addAttribute("brandList", brandList);
        model.addAttribute("seriesList", seriesList);
        model.addAttribute("modelList", modelList);
        return "middle/CarDetailedMiddle/CarDetailedMiddle.html";
    }

    /**
     * @title: carDetailedMiddleAdd
     * @path:       /carDetailedMiddle/carDetailedMiddleAdd
     * @description: TODO
     * @author: MK
     * @date: 2021-01-21 22:02
     * @param: [brand, series, model]
     * @return: boolean
     * @throws:
     * @modefied: 2021-01-21 22:02 MK 修改
     */
    @RequestMapping(value = "/carDetailedMiddleAdd")
    @ResponseBody
    public boolean carDetailedMiddleAdd(@RequestParam(value = "brand") String brand,
                                        @RequestParam(value = "series") String series,
                                        @RequestParam(value = "model") String model) {
        QueryWrapper<CarDetailedMiddle> ew = new QueryWrapper<>();
        ew.eq("PARENTID",brand);
        ew.eq("CHILDREN",series);
        CarDetailedMiddle one = carDetailedMiddleService.getOne(ew);
        if (one == null){
            CarDetailedMiddle middle1 = new CarDetailedMiddle();
            middle1.setSheetid(UUIDUtil.getUUID());
            middle1.setParentid(brand);
            middle1.setChildren(series);
            boolean save1 = carDetailedMiddleService.save(middle1);
        }

        CarDetailedMiddle middle2 = new CarDetailedMiddle();
        middle2.setSheetid(UUIDUtil.getUUID());
        middle2.setParentid(series);
        middle2.setChildren(model);
        boolean save2 = carDetailedMiddleService.save(middle2);

        BaseDict baseDict = new BaseDict();
        baseDict.setSheetid(model);
        baseDict.setDicttypecode("car-model");
        baseDict.setDictenable("0");
        baseDictService.updateById(baseDict);


        return save2;


    }

}

