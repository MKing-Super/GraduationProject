package com.mkinfo.carhouse.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mkinfo.carhouse.exh.model.ExhCar;
import com.mkinfo.carhouse.exh.service.ExhCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * <p>
 * 审核表 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/sysCheck")
public class SysCheckController {
    @Autowired
    private ExhCarService exhCarService;

    /**
     * @title: toSysCheck
     * @path:       /sysCheck/toSysCheck
     * @description: 跳转到车辆审核页面
     * @author: MK
     * @date: 2021-02-03 20:34
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-02-03 20:34 MK 修改
     */
    @RequestMapping("/toSysCheck")
    public String toSysCheck(){
        return "sys/SysCheck/SysCheck.html";
    }

    /**
     * @title: sysCheckList
     * @path:       /sysCheck/sysCheckList
     * @description: 获取车辆审核的信息
     * @author: MK
     * @date: 2021-02-03 20:39
     * @param: []
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-03 20:39 MK 修改
     */
    @RequestMapping("/sysCheckList")
    @ResponseBody
    public Object sysCheckList(){
        HashMap map = new HashMap<String,Object>();
        map.put("state","审核");
        return exhCarService.sysCheck(map);
    }

    /**
     * @title: sysCheckAgree
     * @path:       /sysCheck/sysCheckAgree
     * @description: 车辆审核通过
     * @author: MK
     * @date: 2021-02-03 21:27
     * @param: [sheetid]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-03 21:27 MK 修改
     */
    @RequestMapping("/sysCheckAgree")
    @ResponseBody
    public boolean sysCheckAgree(@RequestParam(value = "sheetid",defaultValue = "") String sheetid){
        ExhCar exhCar = new ExhCar();
        exhCar.setSheetid(sheetid);
        exhCar.setState("待售");

        return exhCarService.updateById(exhCar);
    }

}

