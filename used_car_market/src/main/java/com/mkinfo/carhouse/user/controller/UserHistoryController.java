package com.mkinfo.carhouse.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mkinfo.carhouse.sys.model.SysUser;
import com.mkinfo.carhouse.user.model.UserHistory;
import com.mkinfo.carhouse.user.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 车辆浏览历史 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/userHistory")
public class UserHistoryController {

    @Autowired
    private UserHistoryService userHistoryService;

    /**
     * @title: toUserHistory
     * @path:       /userHistory/toUserHistory
     * @description: 跳转到用户浏览历史页面
     * @author: MK
     * @date: 2021-02-02 22:00
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-02-02 22:00 MK 修改
     */
    @RequestMapping("/toUserHistory")
    public String toUserHistory(){
        return "user/UserHistory/UserHistory.html";
    }

    /**
     * @title: userHistoryList
     * @path:       /userHistory/userHistoryList
     * @description: 获取用户浏览信息表
     * @author: MK
     * @date: 2021-02-02 22:06
     * @param: [request, pageNumber, pageSize]
     * @return: java.util.HashMap<java.lang.String,java.lang.Object>
     * @throws:
     * @modefied: 2021-02-02 22:06 MK 修改
     */
    @RequestMapping("/userHistoryList")
    @ResponseBody
    public HashMap<String, Object> userHistoryList(HttpServletRequest request,
                                                       @RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        HashMap<String, Object> result = new HashMap<>();
        Page<UserHistory> page = new Page<>(pageNumber, pageSize);
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");

        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",sysUser.getSheetid());
        List<UserHistory> userHistories = userHistoryService.userHistoryList(map);
        System.out.println(userHistories);

        //用户已经登陆
        if (sysUser != null){
            QueryWrapper<UserHistory> userHistoryEw = new QueryWrapper<>();
            userHistoryEw.eq("USERID",sysUser.getSheetid());
            List<UserHistory> userHistoryList = userHistoryService.page(page, userHistoryEw).getRecords();
            result.put("state","1");
            result.put("total", page.getTotal());
            result.put("rows", userHistories);
        }else {     //用户未登陆
            result.put("state","403");
            result.put("total", page.getTotal());
            result.put("rows", "用户未登录！请及时登陆！");
        }
        return result;
    }

}

