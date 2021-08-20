/**
 * projectName: used_car_market
 * fileName: BootstrapPractice.java
 * packageName: com.mkinfo.carhouse.utils.tools
 * date: 2020-12-30 11:08
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version: V1.0
 * @author: MK
 * @className: BootstrapPractice
 * @packageName: com.mkinfo.carhouse.utils.tools
 * @description: Bootstrap的代码练习
 * @date: 2020-12-30 11:08
 **/
@Controller
@RequestMapping("/bootstrap")
public class BootstrapPracticeController {

    /**
     * @title: practice
     * @path:    /bootstrap/topractice
     * @description: TODO
     * @author: MK
     * @date: 2021-01-16 10:34
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-16 10:34 MK 修改
     */
    @RequestMapping(value = "/topractice")
    public String practice(){
        return "utils/tools/BootstrapPractice/BootstrapPractice.html";
    }


}
