package com.mkinfo.carhouse.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mkinfo.carhouse.sys.model.SysSaleCar;

import java.util.List;

/**
 * <p>
 * 已售出车辆 Mapper 接口
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface SysSaleCarMapper extends BaseMapper<SysSaleCar> {
    /**
     * @title: sysSaleCarList
     * @path:
     * @description: 返回已售出的车辆信息
     * @author: MK
     * @date: 2021-05-21 20:20
     * @param: []
     * @return: java.util.List<com.mkinfo.carhouse.sys.model.SysSaleCar>
     * @throws:
     * @modefied: 2021-05-21 20:20 MK 修改
     */
    List<SysSaleCar> sysSaleCarList();
}
