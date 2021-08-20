package com.mkinfo.carhouse.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkinfo.carhouse.sys.dao.SysSaleCarMapper;
import com.mkinfo.carhouse.sys.model.SysSaleCar;
import com.mkinfo.carhouse.sys.service.SysSaleCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 已售出车辆 服务实现类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Service
public class SysSaleCarServiceImpl extends ServiceImpl<SysSaleCarMapper, SysSaleCar> implements SysSaleCarService {
    @Resource
    private SysSaleCarMapper sysSaleCarMapper;
    @Override
    public List<SysSaleCar> sysSaleCarList() {
        return sysSaleCarMapper.sysSaleCarList();
    }
}
