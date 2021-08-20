/**
 * projectName: used_car_market
 * fileName: CommonController.java
 * packageName: com.mkinfo.carhouse.common
 * date: 2021-01-16 20:42
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version: V1.0
 * @author: MK
 * @className: CommonController
 * @packageName: com.mkinfo.carhouse.common
 * @description: 公共类
 * @date: 2021-01-16 20:42
 **/
@Controller
@RequestMapping(value = "/common")
public class CommonController {

    /**
     * @title: toAllFunctionPoints
     * @path:       /common/toAllFunctionPoints
     * @description: 跳转到系统中所有的功能点的页面
     * @author: MK
     * @date: 2021-03-10 21:15
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-03-10 21:15 MK 修改
     */
    @RequestMapping("/toAllFunctionPoints")
    public String toAllFunctionPoints(){
        return "/common/administrators/AllFunctionPoints.html";
    }

}
