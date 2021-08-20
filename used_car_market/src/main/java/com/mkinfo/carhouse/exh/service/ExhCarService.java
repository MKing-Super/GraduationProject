package com.mkinfo.carhouse.exh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkinfo.carhouse.exh.model.ExhCar;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息 服务类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface ExhCarService extends IService<ExhCar> {

    /**
     * @title: completeExhCar
     * @path:
     * @description: 获取完整的车辆信息
     * @author: MK
     * @date: 2021-01-24 18:48
     * @param: []
     * @return: java.util.List<com.mkinfo.carhouse.exh.model.ExhCar>
     * @throws:
     * @modefied: 2021-01-24 18:48 MK 修改
     */
    public List<ExhCar> completeExhCar();

    /**
     * @title: completeExhCarView
     * @path:
     * @description: 获取完整的车辆视图信息
     * @author: MK
     * @date: 2021-01-28 21:26
     * @param: []
     * @return: java.util.List<com.mkinfo.carhouse.exh.model.ExhCar>
     * @throws:
     * @modefied: 2021-01-28 21:26 MK 修改
     */
    public List<ExhCar> completeExhCarView(Map<String,Object> map);

    /**
     * @title: exhCarAndUser
     * @path:
     * @description: 获取一辆汽车的所有信息（包括拥有用户的信息）
     * @author: MK
     * @date: 2021-01-31 18:38
     * @param: [exhCarSheetid]
     * @return: com.mkinfo.carhouse.exh.model.ExhCar
     * @throws:
     * @modefied: 2021-01-31 18:38 MK 修改
     */
    public ExhCar exhCarAndUser(String exhCarSheetid);

    /**
     * @title: sysCheck
     * @path:
     * @description: 车辆审核页面
     * @author: MK
     * @date: 2021-02-03 20:50
     * @param: [map] [需要查询的参数]
     * @return: java.util.List<com.mkinfo.carhouse.exh.model.ExhCar>
     * @throws:
     * @modefied: 2021-02-03 20:50 MK 修改
     */
    public List<ExhCar> sysCheck(Map<String,Object> map);

    /**
     * @title: userCarInformation
     * @path:
     * @description: 获取登陆用户的上架车辆
     * @author: MK
     * @date: 2021-04-07 11:26
     * @param: [map]
     * @return: java.util.List<com.mkinfo.carhouse.exh.model.ExhCar>
     * @throws:
     * @modefied: 2021-04-07 11:26 MK 修改
     */
    List<ExhCar> userCarInformation(Map<String,Object> map);
}
