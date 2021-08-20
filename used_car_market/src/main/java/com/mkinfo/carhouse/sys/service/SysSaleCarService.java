package com.mkinfo.carhouse.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkinfo.carhouse.sys.model.SysSaleCar;

import java.util.List;

/**
 * <p>
 * 已售出车辆 服务类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface SysSaleCarService extends IService<SysSaleCar> {

    List<SysSaleCar> sysSaleCarList();
}
