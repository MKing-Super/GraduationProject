package com.mkinfo.carhouse.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mkinfo.carhouse.sys.model.SysUser;
import com.mkinfo.carhouse.user.model.UserCollections;
import com.mkinfo.carhouse.user.service.UserCollectionsService;
import com.mkinfo.carhouse.utils.security.CommonUtil;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
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
 * 车辆收藏表 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/userCollections")
public class UserCollectionsController {
    @Autowired
    private UserCollectionsService userCollectionsService;

    /**
     * @title: toUserCollections
     * @path:       /userCollections/toUserCollections
     * @description: 跳转到用户收藏页面
     * @author: MK
     * @date: 2021-02-01 21:25
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-02-01 21:25 MK 修改
     */
    @RequestMapping("/toUserCollections")
    public String toUserCollections(){
        return "user/UserCollections/UserCollections.html";
    }

    /**
     * @title: userCollectionsAdd
     * @path:       /userCollections/userCollectionsAdd
     * @description: 将车辆添加到收藏表中
     * @author: MK
     * @date: 2021-02-02 19:46
     * @param: [exhCarSheetid]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-02 19:46 MK 修改
     */
    @RequestMapping("/userCollectionsAdd")
    @ResponseBody
    public Object userCollectionsAdd(@RequestParam(value = "exhCarSheetid") String exhCarSheetid,
                                     HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<>();
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        //用户未登录
        if (sysUser == null){
            result.put("msg","用户未登录！请及时登陆！");
            result.put("state","403");
        }else{      //用户已登陆
            QueryWrapper<UserCollections> userCollectionsEw = new QueryWrapper<>();
            userCollectionsEw.eq("CARID",exhCarSheetid);
            userCollectionsEw.eq("USERID",sysUser.getSheetid());
            UserCollections one = userCollectionsService.getOne(userCollectionsEw);
            //如果车辆收藏表中没有收藏信息
            if (one == null){
                //向表中插入信息
                UserCollections userCollections = new UserCollections();
                userCollections.setSheetid(UUIDUtil.getUUID());
                userCollections.setCarid(exhCarSheetid);
                userCollections.setUserid(sysUser.getSheetid());
                userCollections.setCollectiontime(CommonUtil.getNowTime());
                boolean save = userCollectionsService.save(userCollections);
                //插入车辆收藏表成功
                if (save){
                    result.put("msg","成功插入收藏表~（已收藏）");
                    result.put("state","1");
                }else {     //插入车辆收藏表失败
                    result.put("msg","插入车辆收藏表失败！（我要收藏）");
                    result.put("state","500");
                }
            }else {     //已经有了这条收藏信息
                //删除这条信息
                boolean remove = userCollectionsService.remove(userCollectionsEw);
                //删除成功
                if (remove){
                    result.put("msg","成功删除这条收藏信息~（我要收藏）");
                    result.put("state","0");
                }else {     //删除失败
                    result.put("msg","删除失败！（已收藏）");
                    result.put("state","1");
                }
            }
        }
        return result;
    }

    /**
     * @title: collectButton
     * @path:       /userCollections/collectButton
     * @description: 初始化收藏按钮
     * @author: MK
     * @date: 2021-02-02 20:42
     * @param: [exhCarSheetid, request]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-02 20:42 MK 修改
     */
    @RequestMapping("/collectButton")
    @ResponseBody
    public Object collectButton(@RequestParam(value = "exhCarSheetid") String exhCarSheetid,
                                     HttpServletRequest request){

        HashMap<String, Object> result = new HashMap<>();
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        //用户未登录
        if (sysUser == null){
            result.put("msg","用户未登录！请及时登陆！");
            result.put("state","403");
        }else{      //用户已登陆
            QueryWrapper<UserCollections> userCollectionsEw = new QueryWrapper<>();
            userCollectionsEw.eq("CARID",exhCarSheetid);
            userCollectionsEw.eq("USERID",sysUser.getSheetid());
            UserCollections one = userCollectionsService.getOne(userCollectionsEw);
            //收藏表中有数据，已收藏
            if (one != null){
                result.put("msg","");
                result.put("state","0");
            }else {     //收藏表中没有有数据，未收藏
                result.put("msg","");
                result.put("state","1");
            }
        }
        return result;
    }

    /**
     * @title: userCollectionsList
     * @path:       /userCollections/userCollectionsList
     * @description: 获取所有的车辆收藏信息
     * @author: MK
     * @date: 2021-02-02 21:25
     * @param: [request]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-02 21:25 MK 修改
     */
    @RequestMapping("/userCollectionsList")
    @ResponseBody
    public HashMap<String, Object> userCollectionsList(HttpServletRequest request,
                                          @RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                          @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        HashMap<String, Object> result = new HashMap<>();
        Page<UserCollections> page = new Page<>(pageNumber, pageSize);
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");

        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",sysUser.getSheetid());
        List<UserCollections> userCollections = userCollectionsService.userCollectionsList(map);
        System.out.println(userCollections);

        //用户已经登陆
        if (sysUser != null){
            QueryWrapper<UserCollections> userCollectionsEw = new QueryWrapper<>();
            userCollectionsEw.eq("USERID",sysUser.getSheetid());
            List<UserCollections> userCollectionsList = userCollectionsService.page(page,userCollectionsEw).getRecords();
            result.put("state","1");
            result.put("total", page.getTotal());
            result.put("rows", userCollections);
        }else {     //用户未登陆
            result.put("state","403");
            result.put("total", page.getTotal());
            result.put("rows", "用户未登录！请及时登陆！");
        }
        return result;
    }
}

