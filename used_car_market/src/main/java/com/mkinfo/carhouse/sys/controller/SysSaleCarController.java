package com.mkinfo.carhouse.sys.controller;


import com.mkinfo.carhouse.exh.model.ExhCar;
import com.mkinfo.carhouse.exh.service.ExhCarService;
import com.mkinfo.carhouse.sys.model.SysSaleCar;
import com.mkinfo.carhouse.sys.service.SysSaleCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 已售出车辆 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/sysSaleCar")
public class SysSaleCarController {

    @Autowired
    private SysSaleCarService sysSaleCarService;
    @Autowired
    private ExhCarService exhCarService;

    /**
     * @title: toSysSaleCar
     * @path:       /sysSaleCar/toSysSaleCar
     * @description: 跳转到已售出车辆的页面
     * @author: MK
     * @date: 2021-02-08 21:20
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-02-08 21:20 MK 修改
     */
    @RequestMapping("/toSysSaleCar")
    public String toSysSaleCar(){
        return "sys/SysSaleCar/SysSaleCar.html";
    }

    /**
     * @title: sysSaleCarList
     * @path:       /sysSaleCar/sysSaleCarList
     * @description: 获取已经售出车辆的信息
     * @author: MK
     * @date: 2021-02-08 21:31
     * @param: []
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-08 21:31 MK 修改
     */
    @RequestMapping("/sysSaleCarList")
    @ResponseBody
    public Object sysSaleCarList(){
//        List<SysSaleCar> list = sysSaleCarService.list();
        //查看所有的已售出的车辆
        List<SysSaleCar> sysSaleCars = sysSaleCarService.sysSaleCarList();
        System.out.println(sysSaleCars);
        return sysSaleCars;
    }

}

