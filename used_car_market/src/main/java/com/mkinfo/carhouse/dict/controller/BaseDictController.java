package com.mkinfo.carhouse.dict.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mkinfo.carhouse.dict.model.BaseDict;
import com.mkinfo.carhouse.dict.service.BaseDictService;
import com.mkinfo.carhouse.utils.security.CommonUtil;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/baseDict")
public class BaseDictController {

    @Autowired
    private BaseDictService baseDictService;

    /**
     * @title: toBaseDict
     * @path:       /baseDict/toBaseDict
     * @description: 跳转到数据字典页面
     * @author: MK
     * @date: 2021-01-17 17:23
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-17 17:23 MK 修改
     */
    @RequestMapping(value = "/toBaseDict")
    public String toBaseDict(){
        return "dict/BaseDict/BaseDict.html";
    }

    /**
     * @title: dictAdd
     * @path:       /baseDict/dictAdd
     * @description: 添加一条数据数据
     * @author: MK
     * @date: 2021-01-20 20:24
     * @param: [baseDict]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-20 20:24 MK 修改
     */
    @RequestMapping(value = "/dictAdd")
    @ResponseBody
    public boolean dictAdd(BaseDict baseDict, Model model){
        QueryWrapper<BaseDict> ew = new QueryWrapper<>();
        ew.eq("DICTTYPENAME",baseDict.getDicttypename());
        BaseDict one = baseDictService.getOne(ew);
        if (one != null){
            model.addAttribute("msg","数据库中已经存在该品牌！");
            return false;
        }else {
            baseDict.setSheetid(UUIDUtil.getUUID());
            baseDict.setCreatetime(CommonUtil.getNowTime());
            boolean save = baseDictService.save(baseDict);
            if (save){
                model.addAttribute("msg","添加成功~");
            }else {
                model.addAttribute("msg","添加失败！");
            }
            return save;
        }

    }

}

