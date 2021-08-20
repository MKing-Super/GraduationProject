package com.mkinfo.carhouse.exh.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mkinfo.carhouse.dict.model.BaseDict;
import com.mkinfo.carhouse.dict.service.BaseDictService;
import com.mkinfo.carhouse.exh.model.ExhCar;
import com.mkinfo.carhouse.exh.model.ExhCarDetailed;
import com.mkinfo.carhouse.exh.model.ExhPictures;
import com.mkinfo.carhouse.exh.service.ExhCarDetailedService;
import com.mkinfo.carhouse.exh.service.ExhCarService;
import com.mkinfo.carhouse.exh.service.ExhPicturesService;
import com.mkinfo.carhouse.middle.model.CarDetailedMiddle;
import com.mkinfo.carhouse.middle.service.CarDetailedMiddleService;
import com.mkinfo.carhouse.sys.model.SysSaleCar;
import com.mkinfo.carhouse.sys.model.SysUser;
import com.mkinfo.carhouse.sys.service.SysSaleCarService;
import com.mkinfo.carhouse.sys.service.SysUserService;
import com.mkinfo.carhouse.user.model.UserCollections;
import com.mkinfo.carhouse.user.model.UserHistory;
import com.mkinfo.carhouse.user.service.UserCollectionsService;
import com.mkinfo.carhouse.user.service.UserHistoryService;
import com.mkinfo.carhouse.utils.security.CommonUtil;
import com.mkinfo.carhouse.utils.security.UUIDUtil;
import com.mkinfo.carhouse.utils.tools.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息 前端控制器
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Controller
@RequestMapping("/exhCar")
public class ExhCarController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private ExhCarService exhCarService;
    @Autowired
    private ExhCarDetailedService exhCarDetailedService;
    @Autowired
    private ExhPicturesService exhPicturesService;
    @Autowired
    private CarDetailedMiddleService carDetailedMiddleService;
    @Autowired
    private UserHistoryService userHistoryService;
    @Autowired
    private UserCollectionsService userCollectionsService;
    @Autowired
    private SysSaleCarService sysSaleCarService;

    /**
     * @title: toExhCar
     * @path:       /exhCar/toExhCar
     * @description: 跳转到车辆展示页面
     * @author: MK
     * @date: 2021-01-23 21:14
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-23 21:14 MK 修改
     */
    @RequestMapping("/toExhCar")
    public String toExhCar(){
        return "exh/ExhCar/ExhCarList.html";
    }

    /**
     * @title: toExhCarView
     * @path:       /exhCar/toExhCarView
     * @description: 跳转到车辆详细视图页面
     * @author: MK
     * @date: 2021-01-28 20:31
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-28 20:31 MK 修改
     */
    @RequestMapping("/toExhCarView")
    public String toExhCarView(Model model){
        //品牌
        QueryWrapper<BaseDict> brandEw = new QueryWrapper<>();
        brandEw.eq("DICTENABLE", "1");
        brandEw.eq("DICTTYPECODE", "car-brand");
        List<BaseDict> brandList = baseDictService.list(brandEw);
        //使用性质
        QueryWrapper<BaseDict> usepropertiesEw = new QueryWrapper<>();
        usepropertiesEw.eq("DICTENABLE", "1");
        usepropertiesEw.eq("DICTTYPECODE", "car-useproperties");
        List<BaseDict> usepropertiesList = baseDictService.list(usepropertiesEw);
        //产权性质
        QueryWrapper<BaseDict> propertyrightEw = new QueryWrapper<>();
        propertyrightEw.eq("DICTENABLE", "1");
        propertyrightEw.eq("DICTTYPECODE", "car-propertyright");
        List<BaseDict> propertyrightList = baseDictService.list(propertyrightEw);
        //车辆等级
        QueryWrapper<BaseDict> levelEw = new QueryWrapper<>();
        levelEw.eq("DICTENABLE", "1");
        levelEw.eq("DICTTYPECODE", "car-level");
        List<BaseDict> levelList = baseDictService.list(levelEw);
        //排放标准
        QueryWrapper<BaseDict> emissionstandardEw = new QueryWrapper<>();
        emissionstandardEw.eq("DICTENABLE", "1");
        emissionstandardEw.eq("DICTTYPECODE", "car-emissionstandard");
        List<BaseDict> emissionstandardList = baseDictService.list(emissionstandardEw);


        model.addAttribute("brandList", brandList);
        model.addAttribute("usepropertiesList", usepropertiesList);
        model.addAttribute("propertyrightList", propertyrightList);
        model.addAttribute("levelList", levelList);
        model.addAttribute("emissionstandardList", emissionstandardList);
        return "exh/ExhCar/ExhCarView.html";
    }

    /**
     * @title: toExhCarAdd
     * @path:       /exhCar/toExhCarAdd
     * @description: 跳转到车辆详细信息增加页面
     * @author: MK
     * @date: 2021-01-23 21:17
     * @param: [model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-23 21:17 MK 修改
     */
    @RequestMapping("/toExhCarAdd")
    public String toExhCarAdd(Model model){
        //车辆品牌
        QueryWrapper<BaseDict> ew1 = new QueryWrapper<>();
        ew1.eq("DICTENABLE", "1");
        ew1.eq("DICTTYPECODE", "car-brand");
        List<BaseDict> brandList = baseDictService.list(ew1);
        //使用性质
        QueryWrapper<BaseDict> ew2 = new QueryWrapper<>();
        ew2.orderByDesc("DICTENABLE","1");
        ew2.eq("DICTTYPECODE","car-useproperties");
        List<BaseDict> usepropertiesList = baseDictService.list(ew2);
        //产权性质
        QueryWrapper<BaseDict> ew3 = new QueryWrapper<>();
        ew3.orderByDesc("DICTENABLE","1");
        ew3.eq("DICTTYPECODE","car-propertyright");
        List<BaseDict> propertyrightList = baseDictService.list(ew3);

        model.addAttribute("brandList", brandList);
        model.addAttribute("usepropertiesList", usepropertiesList);
        model.addAttribute("propertyrightList", propertyrightList);
        return "exh/ExhCar/ExhCar_add.html";
    }

    /**
     * @title: exhCarAdd
     * @path:       /exhCar/exhCarAdd
     * @description: 提交上架车辆的数据
     * @author: MK
     * @date: 2021-01-23 23:13
     * @param: [brand, series, model, exhCar] [品牌，车系，车型，车辆基本信息]
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-23 23:13 MK 修改
     */
    @RequestMapping("/exhCarAdd")
    @ResponseBody
    public Object exhCarAdd(@RequestParam("brand") String brand,
                             @RequestParam("series") String series,
                             @RequestParam("model") String model,
                             ExhCar exhCar
                                ) {
        //通过品牌、车系、车型找到相应车辆的详细信息
        QueryWrapper<ExhCarDetailed> exhCarDetailedEw = new QueryWrapper<>();
        exhCarDetailedEw.eq("BRAND",baseDictService.getById(brand).getDicttypename());
        exhCarDetailedEw.eq("SERIES",baseDictService.getById(series).getDicttypename());
        exhCarDetailedEw.eq("MODEL",baseDictService.getById(model).getDicttypename());
        ExhCarDetailed one = exhCarDetailedService.getOne(exhCarDetailedEw);
        //获取信息，向车辆基础表里插入数据
        exhCar.setSheetid(UUIDUtil.getUUID());
        //车辆状态
        exhCar.setState("审核");
        exhCar.setDetailedid(one.getSheetid());
        exhCar.setCreatetime(CommonUtil.getNowTime());
        //保存车辆基本信息
        boolean save = exhCarService.save(exhCar);
        HashMap<String, Object> result = new HashMap<>();
        if (save){
            result.put("msg",exhCar);
        }else {
            result.put("msg","");
        }
        return result;
    }

    /**
     * @title: list
     * @path:       /exhCar/list
     * @description: 返回所有车辆的基本信息，没有图片，仅限于管理员使用
     * @author: MK
     * @date: 2021-01-24 9:41
     * @param: []
     * @return: java.lang.Object
     * @throws:
     * @modefied: 2021-01-24 9:41 MK 修改
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(){
        return exhCarService.completeExhCar();
    }

    /**
     * @title: picutreUpload
     * @path:       /exhCar/picutreUpload
     * @description: 车辆图片的上传，若有多张图片，则是一张一张的多次上传，并不是同时上传
     * @author: MK
     * @date: 2021-01-26 22:03
     * @param: [file] [图片信息]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @throws:
     * @modefied: 2021-01-26 22:03 MK 修改
     */
    @RequestMapping("/picutreUpload")
    @ResponseBody
    public Map<String, Object> picutreUpload(@RequestParam("images") MultipartFile file,
                                             HttpServletRequest request,
                                             String carId) {
        //从session中取得用户相关信息
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        Map<String, Object> result = new HashMap<>();
        try {
            //图片上传地址
            //本地硬盘的映射地址
            String mappingPath = "E:\\git\\used_car_market_upload";
            //相对地址
            String relativePath = "\\pictures_upload\\" + sysUser.getSheetid();
            //完整的地址
            String picturesPath = mappingPath + relativePath;
            File filePath = new File(picturesPath);
            //若文件夹不存在，则创建一个文件夹
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            //原文件的名称
            String pictureName = file.getOriginalFilename();
            //存入本地磁盘的文件后缀名
            String afterName = pictureName.substring(pictureName.lastIndexOf(".") + 1);
            //存入本地磁盘的文件名
            String newPictureName = UUIDUtil.getUUID() + "." + afterName;
            // 对文件进行存储处理
            byte[] bytes = file.getBytes();
            Path path = Paths.get(picturesPath, "\\" + newPictureName);
            Files.write(path, bytes);

            //未替换斜杠的文件名
            String databaseName = relativePath + "\\" + newPictureName;
            //存入数据库的地址和文件名（已经替换斜杠）
            String newDatabaseName = databaseName.replaceAll("\\\\", "/");
            //上传的车辆图片的相关信息
            ExhPictures exhPictures = new ExhPictures();
            exhPictures.setSheetid(UUIDUtil.getUUID());
            exhPictures.setPath(newDatabaseName);
            exhPictures.setCarid(carId);
            //存入数据库
            exhPicturesService.save(exhPictures);

            result.put("msg", "上传成功！");
            result.put("result", true);
        } catch (IOException e) {
            result.put("msg", "出错了");
            result.put("result", false);
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    /**
     * @title: exhCarViewList
     * @path:       /exhCar/exhCarViewList
     * @description: 车辆视图查询
     * @author: MK
     * @date: 2021-01-28 21:54
     * @param: [pageNumber, pageSize]
     * @return: java.util.List<com.mkinfo.carhouse.exh.model.ExhCar>
     * @throws:
     * @modefied: 2021-01-28 21:54 MK 修改
     */
    @RequestMapping("/exhCarViewList")
    @ResponseBody
    public Object exhCarViewList(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                 @RequestParam(value = "pageSize",defaultValue = "40") int pageSize,
                                 @RequestParam(value = "brand",defaultValue = "") String brand,
                                 @RequestParam(value = "series",defaultValue = "") String series,
                                 @RequestParam(value = "price",defaultValue = "0") String price,
                                 @RequestParam(value = "vehicleAge",defaultValue = "0") String vehicleAge,
                                 @RequestParam(value = "mileage",defaultValue = "0") String mileage,
                                 @RequestParam(value = "useproperties",defaultValue = "") String useproperties,
                                 @RequestParam(value = "propertyright",defaultValue = "") String propertyright,
                                 @RequestParam(value = "level",defaultValue = "") String level,
                                 @RequestParam(value = "emissionstandard",defaultValue = "") String emissionstandard,
                                 @RequestParam(value = "fueltype",defaultValue = "") String fueltype){
        //开始条数
        int start = (pageNumber-1)*pageSize;
        //结束条数
        int rows = pageNumber*pageSize;
        //价格字符串处理
        double minPrice = 0;    //价格下限
        double maxPrice = 0;    //价格上限
        String REGEX_CHINESE = "[\u4e00-\u9fa5]";   // 中文正则
        String priceStr = price.replaceAll(REGEX_CHINESE, "");  //去除中文
        //判断有无‘-’
        if (priceStr.contains("-")){    //如有可以确定价格的上限和下限
            //取‘-’左边的值
            String left = priceStr.substring(0, priceStr.indexOf("-"));
            //取‘-’右面的值
            String right = priceStr.substring(left.length()+1, priceStr.length());
            if (!"".equals(left)){  //空字符串不赋值
                minPrice = Double.parseDouble(left);
            }
            if (!"".equals(right)){ //空字符串不赋值
                maxPrice = Double.parseDouble(right);
            }
        }else {     //若无，说明价格只有一个上限或者一个下限
            //n万以下
            if (Double.parseDouble(priceStr) < 10.0){
                maxPrice = Double.parseDouble(priceStr);
            }else {     //n万以上
                minPrice = Double.parseDouble(priceStr);
            }
        }

        //车龄字符串处理
        int minVehicleAge = 0;
        int maxVehicleAge = 0;
        String vehicleAgeStr = vehicleAge.replaceAll(REGEX_CHINESE, "");
        int vehicleAgeTemp = Integer.parseInt(vehicleAgeStr);
        if (vehicleAgeTemp >= 8 && "8年以上".equals(vehicleAge)){   //8年以上
            minVehicleAge = vehicleAgeTemp;
        }else {         //8年以下
            maxVehicleAge = vehicleAgeTemp;
        }
        //里程字符串处理
        double minMileage = 0;
        double maxMileage = 0;
        String mileageStr = mileage.replaceAll(REGEX_CHINESE, "");
        double mileageTemp = Double.parseDouble(mileageStr);
        if (mileageTemp >= 10 && "10万公里以上".equals(mileage)){
            minMileage = mileageTemp;
        }else {
            maxMileage = mileageTemp;
        }


        //查询条件
        Map<String, Object> map = new HashMap<>();
        map.put("start",start);                     //开始条数
        map.put("rows",rows);                       //结束条数
        map.put("brand",brand);                     //品牌
        map.put("series",series);                   //车系
        map.put("minPrice",minPrice);               //价格（下限）
        map.put("maxPrice",maxPrice);               //价格（上限）
        map.put("minVehicleAge",minVehicleAge);     //车龄（8年以上）
        map.put("maxVehicleAge",maxVehicleAge);     //车龄（8年以下）
        map.put("minMileage",minMileage);           //里程（10万公里以上）
        map.put("maxMileage",maxMileage);           //里程（10万公里内）
        map.put("useproperties",useproperties);     //使用性质
        map.put("propertyright",propertyright);     //产权性质
        map.put("level",level);                     //车辆等级
        map.put("emissionstandard",emissionstandard);   //排放标准
        map.put("fueltype",fueltype);               //燃油类型
        map.put("state","待售");                      //车辆状态
        List<ExhCar> exhCarsList = exhCarService.completeExhCarView(map);
        System.out.println(exhCarsList);

        Map<String, Object> result = new HashMap<>();
        result.put("total",10);
        result.put("rows",exhCarsList);
        return exhCarsList;
    }

    /**
     * @title: getCarSeries
     * @path:       /exhCar/getCarSeries
     * @description: 根据车辆品牌获取车系
     * @author: MK
     * @date: 2021-01-30 14:46
     * @param: [brand]
     * @return: java.util.List<com.mkinfo.carhouse.dict.model.BaseDict>
     * @throws:
     * @modefied: 2021-01-30 14:46 MK 修改
     */
    @RequestMapping("/getCarSeries")
    @ResponseBody
    public List<BaseDict> getCarSeries(@RequestParam(value = "brand") String brand){
        QueryWrapper<CarDetailedMiddle> ew = new QueryWrapper<>();
        ew.eq("PARENTID",brand);
        List<CarDetailedMiddle> list = carDetailedMiddleService.list(ew);
        ArrayList<BaseDict> baseDicts = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            BaseDict one = baseDictService.getById(list.get(i).getChildren());
            baseDicts.add(one);
        }
        return baseDicts;
    }

    /**
     * @title: toCarInformation
     * @path:       /exhCar/toCarInformation
     * @description: 跳转到车辆详细信息页面
     * @author: MK
     * @date: 2021-01-31 18:46
     * @param: [sheetid]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-31 18:46 MK 修改
     */
    @RequestMapping("/toCarInformation/{exhCarSheetid}")
    public String toCarInformation(@PathVariable String exhCarSheetid,HttpServletRequest request,Model model){
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        //用户已经登录
        if (sysUser != null){
            QueryWrapper<UserHistory> userHistoryEw = new QueryWrapper<>();
            userHistoryEw.eq("CARID",exhCarSheetid);
            userHistoryEw.eq("USERID",sysUser.getSheetid());
            UserHistory one = userHistoryService.getOne(userHistoryEw);
            //历史浏览信息中不存在这条信息，此时向表中插入数据
            UserHistory userHistory = new UserHistory();
            if (one == null){
                userHistory.setSheetid(UUIDUtil.getUUID());
                userHistory.setCarid(exhCarSheetid);
                userHistory.setUserid(sysUser.getSheetid());
                userHistory.setTime(CommonUtil.getNowTime());
                //向浏览表中增加一条数据
                userHistoryService.save(userHistory);
            }else {     //历史浏览信息中有这条信息，此时更新数据的浏览时间
                userHistory.setSheetid(one.getSheetid());
                userHistory.setTime(CommonUtil.getNowTime());
                //从浏览表中修改一条数据
                userHistoryService.updateById(userHistory);
            }
        }

        //查出该车的所有信息
        ExhCar exhCar = exhCarService.exhCarAndUser(exhCarSheetid);
        model.addAttribute("exhCar",exhCar);
        return "exh/ExhCar/CarInformation.html";
    }

    /**
     * @title: deleteCar
     * @path:       /exhCar/deleteCar
     * @description: 管理员删除
     * @author: MK
     * @date: 2021-03-26 10:09
     * @param: [sheetid]
     * @return: boolean
     * @throws:
     * @modefied: 2021-03-26 10:09 MK 修改
     */
    @RequestMapping("/deleteCar")
    @ResponseBody
    public boolean deleteCar(String sheetid){
        String[] split = sheetid.split(",");
        if (sheetid != null){
            for (int i = 0 ; i < split.length ; i++){
                ExhCar exhCar = new ExhCar();
                exhCar.setSheetid(split[i]);
                exhCar.setState("已删除");
                //修改车辆状态
                boolean b = exhCarService.updateById(exhCar);
            }
        }
        return true;
    }

    /**
     * @title: carCheckRefuse
     * @path:       /exhCar/carCheckRefuse
     * @description: 审核车辆不通过
     * @author: MK
     * @date: 2021-03-26 13:24
     * @param: [sheetid]
     * @return: boolean
     * @throws:
     * @modefied: 2021-03-26 13:24 MK 修改
     */
    @RequestMapping("/carCheckRefuse")
    @ResponseBody
    public boolean carCheckRefuse(String sheetid){

        ExhCar exhCar = new ExhCar();
        exhCar.setSheetid(sheetid);
        exhCar.setState("审核未通过");
        //修改车辆状态
        boolean b = exhCarService.updateById(exhCar);
        return b;
    }

    /**
     * @title: toCollectionCarInformation
     * @path:       /exhCar/toCollectionCarInformation
     * @description: 收藏跳到车辆详情
     * @author: MK
     * @date: 2021-03-26 13:53
     * @param: [exhCarSheetid, request, model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-03-26 13:53 MK 修改
     */
    @RequestMapping("/toCollectionCarInformation/{sheetid}")
    public String toCollectionCarInformation(@PathVariable String sheetid,HttpServletRequest request,Model model){
        //根据收藏表获取车辆id
        UserCollections byId = userCollectionsService.getById(sheetid);
        String exhCarSheetid = byId.getCarid();

        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        //用户已经登录
        if (sysUser != null){
            QueryWrapper<UserHistory> userHistoryEw = new QueryWrapper<>();
            userHistoryEw.eq("CARID",exhCarSheetid);
            userHistoryEw.eq("USERID",sysUser.getSheetid());
            UserHistory one = userHistoryService.getOne(userHistoryEw);
            //历史浏览信息中不存在这条信息，此时向表中插入数据
            UserHistory userHistory = new UserHistory();
            if (one == null){
                userHistory.setSheetid(UUIDUtil.getUUID());
                userHistory.setCarid(exhCarSheetid);
                userHistory.setUserid(sysUser.getSheetid());
                userHistory.setTime(CommonUtil.getNowTime());
                //向浏览表中增加一条数据
                userHistoryService.save(userHistory);
            }else {     //历史浏览信息中有这条信息，此时更新数据的浏览时间
                userHistory.setSheetid(one.getSheetid());
                userHistory.setTime(CommonUtil.getNowTime());
                //从浏览表中修改一条数据
                userHistoryService.updateById(userHistory);
            }
        }

        //查出该车的所有信息
        ExhCar exhCar = exhCarService.exhCarAndUser(exhCarSheetid);
        model.addAttribute("exhCar",exhCar);
        return "exh/ExhCar/CarInformation.html";
    }

    /**
     * @title: toHistoryCarInformation
     * @path:       /exhCar/toHistoryCarInformation
     * @description: 从浏览历史中查看
     * @author: MK
     * @date: 2021-03-26 17:10
     * @param: [sheetid, request, model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-03-26 17:10 MK 修改
     */
    @RequestMapping("/toHistoryCarInformation/{sheetid}")
    public String toHistoryCarInformation(@PathVariable String sheetid,HttpServletRequest request,Model model){
        //根据收藏表获取车辆id
        UserHistory byId = userHistoryService.getById(sheetid);
        String exhCarSheetid = byId.getCarid();

        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        //用户已经登录
        if (sysUser != null){
            QueryWrapper<UserHistory> userHistoryEw = new QueryWrapper<>();
            userHistoryEw.eq("CARID",exhCarSheetid);
            userHistoryEw.eq("USERID",sysUser.getSheetid());
            UserHistory one = userHistoryService.getOne(userHistoryEw);
            //历史浏览信息中不存在这条信息，此时向表中插入数据
            UserHistory userHistory = new UserHistory();
            if (one == null){
                userHistory.setSheetid(UUIDUtil.getUUID());
                userHistory.setCarid(exhCarSheetid);
                userHistory.setUserid(sysUser.getSheetid());
                userHistory.setTime(CommonUtil.getNowTime());
                //向浏览表中增加一条数据
                userHistoryService.save(userHistory);
            }else {     //历史浏览信息中有这条信息，此时更新数据的浏览时间
                userHistory.setSheetid(one.getSheetid());
                userHistory.setTime(CommonUtil.getNowTime());
                //从浏览表中修改一条数据
                userHistoryService.updateById(userHistory);
            }
        }

        //查出该车的所有信息
        ExhCar exhCar = exhCarService.exhCarAndUser(exhCarSheetid);
        model.addAttribute("exhCar",exhCar);
        return "exh/ExhCar/CarInformation.html";
    }

    /**
     * @title: toUserCarInformation
     * @path:      /exhCar/toUserCarInformation
     * @description: 跳转到用户上架车辆信息页面
     * @author: MK
     * @date: 2021-04-07 11:42
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-04-07 11:42 MK 修改
     */
    @RequestMapping("/toUserCarInformationList")
    public String toUserCarInformationList(){
        return "user/UserCarInformation/UserCarInformation.html";
    }

    /**
     * @title: userCarInformation
     * @path:       /exhCar/userCarInformation
     * @description: 获取用户上架车辆的信息
     * @author: MK
     * @date: 2021-04-07 11:19
     * @param: [userid]
     * @return: java.util.List<com.mkinfo.carhouse.exh.model.ExhCar>
     * @throws:
     * @modefied: 2021-04-07 11:19 MK 修改
     */
    @RequestMapping("/userCarInformationList")
    @ResponseBody
    public List<ExhCar> userCarInformationList(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,
                                           @RequestParam(value = "pageSize",defaultValue = "40") int pageSize,
                                           HttpServletRequest request){
        SysUser sysUser = (SysUser) request.getSession().getAttribute("SYS_USER");
        HashMap<String, Object> map = new HashMap<>();
        map.put("userid",sysUser.getSheetid());
        return exhCarService.userCarInformation(map);
    }

    /**
     * @title: toUserCarInformation
     * @path:       /exhCar/toUserCarInformation
     * @description: 用户上架车辆的查看
     * @author: MK
     * @date: 2021-04-07 13:57
     * @param: [sheetid, request, model]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-04-07 13:57 MK 修改
     */
    @RequestMapping("/toUserCarInformation/{sheetid}")
    public String toUserCarInformation(@PathVariable String sheetid,Model model){
        //查出该车的所有信息
        ExhCar exhCar = exhCarService.exhCarAndUser(sheetid);
        model.addAttribute("exhCar",exhCar);
        return "exh/ExhCar/CarInformation.html";
    }

    /**
     * @title: toUserCarSold
     * @path:       /exhCar/toUserCarSold
     * @description: 用户车辆信息的已售出
     * @author: MK
     * @date: 2021-04-07 14:28
     * @param: [sheetid]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-04-07 14:28 MK 修改
     */
    @RequestMapping("/toUserCarSold/{sheetid}")
    public String toUserCarSold(@PathVariable String sheetid){
        //更新车辆展示表中的状态
        ExhCar exhCar = new ExhCar();
        exhCar.setSheetid(sheetid);
        exhCar.setState("已售出");
        exhCarService.updateById(exhCar);

        //查出相应的信息
        ExhCar byId = exhCarService.getById(sheetid);
        System.out.println(byId);
        //将信息存放到车辆卖出表中
        SysSaleCar sysSaleCar = new SysSaleCar();
        sysSaleCar.setSheetid(UUIDUtil.getUUID());
        sysSaleCar.setCarid(sheetid);
        sysSaleCar.setSellerid(byId.getUserid());
        sysSaleCar.setDealtime(CommonUtil.getNowTime());
        sysSaleCar.setDealprice(byId.getPrice());
        sysSaleCarService.save(sysSaleCar);
        return "user/UserCarInformation/UserCarInformation.html";
    }
}

