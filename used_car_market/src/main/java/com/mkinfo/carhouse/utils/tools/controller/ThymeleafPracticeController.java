/**
 * projectName: used_car_market
 * fileName: ThymeleafPracticeController.java
 * packageName: com.mkinfo.carhouse.utils.tools.controller
 * date: 2021-01-20 17:28
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version: V1.0
 * @author: MK
 * @className: ThymeleafPracticeController
 * @packageName: com.mkinfo.carhouse.utils.tools.controller
 * @description: Thmyeleaf练习
 * @date: 2021-01-20 17:28
 **/
@Controller
@RequestMapping(value = "/thmyeleaf")
public class ThymeleafPracticeController {

    /**
     * @title: th
     * @path:       /thmyeleaf/th
     * @description: 跳转到ThymeleafPractice页面
     * @author: MK
     * @date: 2021-01-20 17:55
     * @param: [model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-20 17:55 MK 修改
     */
    @RequestMapping(value = "/th")
    public String th(Model model){
        String msg = "<h1>这是h1</h1>";
        model.addAttribute("msg",msg);
        return "utils/tools/ThymeleafPractice/ThymeleafPractice.html";
    }

    @RequestMapping(value = "/HtmlPractice")
    public String HtmlPractice(){
        return "utils/tools/ThymeleafPractice/HtmlPractice.html";
    }
}
