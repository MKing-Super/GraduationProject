package com.mkinfo.carhouse.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mkinfo.carhouse.sys.model.SysUser;
import com.mkinfo.carhouse.sys.service.SysUserService;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * <p>
 * 人员表 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * @title: toLogin
     * @path: /sysUser/toLogin
     * @description: 跳转到登陆页面
     * @author: MK
     * @date: 2021-01-16 10:15
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-16 10:15 MK 修改
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "sys/SysUser/login.html";
    }

    /**
     * @title: toRegister
     * @path: /sysUser/toRegister
     * @description: 跳转到注册页面
     * @author: MK
     * @date: 2021-01-16 10:16
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-16 10:16 MK 修改
     */
    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "sys/SysUser/register.html";
    }

    /**
     * @title: toEditUser
     * @path: /sysUser/toPersonalCenter
     * @description: 跳转到个人中心
     * @author: MK
     * @date: 2021-01-17 11:02
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-17 11:02 MK 修改
     */
    @RequestMapping(value = "/toPersonalCenter")
    public String toPersonalCenter(HttpSession session) {
        SysUser sysUser = (SysUser) session.getAttribute("SYS_USER");
        if ("root".equals(sysUser.getPersonnalcategory())) {     //如果登陆人为root等级，则进入管理界面
            return "common/administrators/AdminCenter.html";
        } else {     //普通用户，进入个人中心
            return "sys/SysUser/PersonalCenter.html";
        }
    }

    /**
     * @title: get
     * @path: /sysUser/get
     * @description: 注册
     * @author: MK
     * @date: 2021-01-16 11:30
     * @param: []
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-16 11:30 MK 修改
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public Object register(@RequestParam(value = "phone") String phone,
                           @RequestParam(value = "password") String password) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<SysUser> ew = new QueryWrapper<>();
        ew.eq("PHONE", phone);
        SysUser one = sysUserService.getOne(ew);
        if (one == null) {
            SysUser sysUser = new SysUser();
            sysUser.setSheetid(UUIDUtil.getUUID());
            sysUser.setPhone(phone);
            sysUser.setPassword(password);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhMMss");
            sysUser.setPetname("游客" + simpleDateFormat.format(date));
            sysUser.setPersonnalcategory("0");
            sysUser.setGrade("1");
            boolean save = sysUserService.save(sysUser);
            map.put("state", true);
            map.put("msg", sysUser);
            return map;
        } else {
            map.put("state", false);
            map.put("msg", "");
            return map;
        }
    }

    /**
     * @title: login
     * @path: /sysUser/login
     * @description: 登陆
     * @author: MK
     * @date: 2021-01-16 11:30
     * @param: []
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-16 11:30 MK 修改
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "phone") String phone,
                        @RequestParam(value = "password") String password,
                        HttpSession session,
                        Model model) {
        QueryWrapper<SysUser> ew = new QueryWrapper<>();
        ew.eq("PHONE", phone);
        ew.eq("PASSWORD", password);
        SysUser one = sysUserService.getOne(ew);
        if (one != null) {
            session.setAttribute("SYS_USER", one);
            model.addAttribute("msg", "登陆成功~");
            return "redirect:/";        //登陆成功返回首页
        } else {
            model.addAttribute("msg", "密码错误登陆失败！");
            return "sys/SysUser/login.html";    //登陆失败返回登录页
        }
    }

    /**
     * @title: logout
     * @path: /sysUser/logout
     * @description: 用户退出
     * @author: MK
     * @date: 2021-01-18 19:56
     * @param: [session]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-18 19:56 MK 修改
     */
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index.html";
    }

    /**
     * @title: toAccountManagement
     * @path: /sysUser/toAccountManagement
     * @description: 跳转到账号管理的页面
     * @author: MK
     * @date: 2021-02-09 16:33
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-02-09 16:33 MK 修改
     */
    @RequestMapping("/toAccountManagement")
    public String toAccountManagement(HttpServletRequest request, Model model) {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        model.addAttribute("sysUser", sysUser);
        return "sys/SysUser/AccountManagement.html";
    }

    /**
     * @title: accountManagement
     * @path:      /sysUser/accountManagement
     * @description: 更新系统用户字段
     * @author: MK
     * @date: 2021-02-10 15:37
     * @param: [sysUser]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-02-10 15:37 MK 修改
     */
    @RequestMapping("/accountManagement")
    @ResponseBody
    public Object accountManagement(SysUser sysUser) {
        return sysUserService.updateById(sysUser);
    }

}

