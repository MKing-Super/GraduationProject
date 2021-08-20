package com.mkinfo.carhouse.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkinfo.carhouse.user.model.UserCollections;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆收藏表 服务类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface UserCollectionsService extends IService<UserCollections> {
    /**
     * @title: userCollectionsList
     * @path:
     * @description: 返回用户的收藏数据信息
     * @author: MK
     * @date: 2021-04-06 17:02
     * @param: [map]
     * @return: com.mkinfo.carhouse.user.model.UserCollections
     * @throws:
     * @modefied: 2021-04-06 17:02 MK 修改
     */
    List<UserCollections> userCollectionsList(Map<String,Object> map);
}
