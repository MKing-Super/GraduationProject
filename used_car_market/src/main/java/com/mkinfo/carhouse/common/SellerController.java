/**
 * projectName: used_car_market
 * fileName: SellerController.java
 * packageName: com.mkinfo.carhouse.common
 * date: 2021-01-21 22:15
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mkinfo.carhouse.dict.model.BaseDict;
import com.mkinfo.carhouse.dict.service.BaseDictService;
import com.mkinfo.carhouse.middle.model.CarDetailedMiddle;
import com.mkinfo.carhouse.middle.service.CarDetailedMiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: MK
 * @className: SellerController
 * @packageName: com.mkinfo.carhouse.common
 * @description: 卖方
 * @date: 2021-01-21 22:15
 **/
@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CarDetailedMiddleService carDetailedMiddleService;
    /**
     * @title: toSelectCarType
     * @path:       /seller/toSelectCarType
     * @description: 跳转到选择车辆信息页面
     * @author: MK
     * @date: 2021-01-21 22:23
     * @param: [model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-21 22:23 MK 修改
     */
    @RequestMapping("/toSelectCarType")
    public String toSelectCarType(Model model){
        QueryWrapper<BaseDict> ew1 = new QueryWrapper<BaseDict>();
        ew1.eq("DICTENABLE", "1");
        ew1.eq("DICTTYPECODE", "car-brand");
        List<BaseDict> brandList = baseDictService.list(ew1);

        model.addAttribute("brandList", brandList);
        return "common/seller/Seller.html";
    }

    /**
     * @title: getCarSeries
     * @path:       /seller/getCarSeries
     * @description: TODO
     * @author: MK
     * @date: 2021-01-21 22:45
     * @param: [brand, series, model]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-21 22:45 MK 修改
     */
    @RequestMapping("/getCarSeries")
    @ResponseBody
    public List<BaseDict> getCarSeries(@RequestParam(value = "brand") String brand,
                                       @RequestParam(value = "series") String series,
                                       @RequestParam(value = "model") String model){
        QueryWrapper<CarDetailedMiddle> ew = new QueryWrapper<>();
        ew.eq("PARENTID",brand);
        List<CarDetailedMiddle> list = carDetailedMiddleService.list(ew);
        ArrayList<BaseDict> baseDicts = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            BaseDict one = baseDictService.getById(list.get(i).getChildren());
            baseDicts.add(one);
        }
        return baseDicts;
    }

    /**
     * @title: getCarSeries
     * @path:       /seller/getCarModel
     * @description: TODO
     * @author: MK
     * @date: 2021-01-21 22:45
     * @param: [brand, series, model]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-21 22:45 MK 修改
     */
    @RequestMapping("/getCarModel")
    @ResponseBody
    public List<BaseDict> getCarModel(@RequestParam(value = "brand") String brand,
                                       @RequestParam(value = "series") String series,
                                       @RequestParam(value = "model") String model){
        QueryWrapper<CarDetailedMiddle> ew = new QueryWrapper<>();
        ew.eq("PARENTID",series);
        List<CarDetailedMiddle> list = carDetailedMiddleService.list(ew);
        ArrayList<BaseDict> baseDicts = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            BaseDict one = baseDictService.getById(list.get(i).getChildren());
            baseDicts.add(one);
        }
        return baseDicts;
    }

}
