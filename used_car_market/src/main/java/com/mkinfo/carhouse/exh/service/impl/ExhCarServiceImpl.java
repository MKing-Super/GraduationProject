package com.mkinfo.carhouse.exh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkinfo.carhouse.exh.dao.ExhCarMapper;
import com.mkinfo.carhouse.exh.model.ExhCar;
import com.mkinfo.carhouse.exh.service.ExhCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息 服务实现类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Service
public class ExhCarServiceImpl extends ServiceImpl<ExhCarMapper, ExhCar> implements ExhCarService {

    @Resource
    private ExhCarMapper exhCarMapper;

    @Override
    public List<ExhCar> completeExhCar() {
        return exhCarMapper.completeExhCar();
    }

    @Override
    public List<ExhCar> completeExhCarView(Map<String,Object> map) {
        return exhCarMapper.completeExhCarView(map);
    }

    @Override
    public ExhCar exhCarAndUser(String exhCarSheetid) {
        return exhCarMapper.exhCarAndUser(exhCarSheetid);
    }

    @Override
    public List<ExhCar> sysCheck(Map<String, Object> map) {
        return exhCarMapper.sysCheck(map);
    }

    @Override
    public List<ExhCar> userCarInformation(Map<String, Object> map) {
        return exhCarMapper.userCarInformation(map);
    }
}
