/**
 * projectName: used_car_market
 * fileName: BootstrapTableController.java
 * packageName: com.mkinfo.carhouse.utils.tools.controller
 * date: 2021-01-14 11:19
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.tools.controller;

import com.alibaba.fastjson.JSONObject;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
import com.mkinfo.carhouse.utils.tools.model.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: V1.0
 * @author: MK
 * @className: BootstrapTableController
 * @packageName: com.mkinfo.carhouse.utils.tools.controller
 * @description: Bootstrap Table基本使用方法
 * @date: 2021-01-14 11:19
 **/
@Controller
@RequestMapping(value = "/BootstrapTable")
public class BootstrapTableController {

    /**
     * @title: toTable
     * @description: 跳转到 BootstrapTable.html
     * @path:        /BootstrapTable/toTable
     * @author: MK
     * @date: 2021-01-14 11:26
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-14 11:26 MK 修改
     */
    @RequestMapping(value = "/toTable")
    public String toTable(){
        return "utils/tools/BootstrapTable/BootstrapTable.html";
    }

    /**
     * @title: list
     * @description: 返回表格数据
     * @path:      /BootstrapTable/list
     * @author: MK
     * @date: 2021-01-14 22:02
     * @param: [limit, offset, departmentname, statu]
     * @return: com.alibaba.fastjson.JSONObject
     * @throws:
     * @modefied: 2021-01-14 22:02 MK 修改
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public JSONObject list(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                           @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        JSONObject json = new JSONObject();
        ArrayList<Department> departmentList = new ArrayList<>();
        int dataTotal = 66;     //假数据的长度
        for (Integer i = 0 ; i < dataTotal ; i++){      //造假
            Department department = new Department();
            department.setID(UUIDUtil.getUUID());
            Integer j = i + 1;
            department.setName("部门" + j);
            department.setLevel(j.toString());
            department.setDesc("666");
            departmentList.add(department);
        }
        int total = departmentList.size();          //数据总数
        int start,end;
        start = (pageNumber-1)*pageSize;
        end = start + pageSize;
        if (end>dataTotal){
            end = dataTotal;
        }
        List<Department> list = new ArrayList<>();
        for (int i = start;i<end;i++){
            list.add(departmentList.get(i));
        }
        json.put("total",total);
        json.put("rows",list);
        return json;
    }
}
