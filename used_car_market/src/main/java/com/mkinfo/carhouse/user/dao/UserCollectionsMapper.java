package com.mkinfo.carhouse.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mkinfo.carhouse.user.model.UserCollections;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆收藏表 Mapper 接口
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface UserCollectionsMapper extends BaseMapper<UserCollections> {
    List<UserCollections> userCollectionsList(Map<String,Object> map);
}
