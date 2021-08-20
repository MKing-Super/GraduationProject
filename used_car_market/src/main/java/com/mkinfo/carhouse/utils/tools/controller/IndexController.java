/**
 * projectName: used_car_market
 * fileName: IndexController.java
 * packageName: com.mkinfo.carhouse.utils.tools.controller
 * date: 2021-01-16 10:25
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version: V1.0
 * @author: MK
 * @className: IndexController
 * @packageName: com.mkinfo.carhouse.utils.tools.controller
 * @description: 首页controller
 * @date: 2021-01-16 10:25
 **/
@Controller

public class IndexController {

    /**
     * @title: toIndex
     * @path:    /
     * @description: 跳转到首页
     * @author: MK
     * @date: 2021-01-16 10:31
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-16 10:31 MK 修改
     */
    @RequestMapping("/")
    public String toIndex(){
        return "index.html";
    }



}
