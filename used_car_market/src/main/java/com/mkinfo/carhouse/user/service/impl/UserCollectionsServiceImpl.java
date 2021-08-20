package com.mkinfo.carhouse.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkinfo.carhouse.user.dao.UserCollectionsMapper;
import com.mkinfo.carhouse.user.model.UserCollections;
import com.mkinfo.carhouse.user.service.UserCollectionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆收藏表 服务实现类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Service
public class UserCollectionsServiceImpl extends ServiceImpl<UserCollectionsMapper, UserCollections> implements UserCollectionsService {
    @Resource
    private UserCollectionsMapper userCollectionsMapper;

    @Override
    public List<UserCollections> userCollectionsList(Map<String,Object> map) {
        return userCollectionsMapper.userCollectionsList(map);
    }
}
