package com.mkinfo.carhouse.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mkinfo.carhouse.user.model.UserHistory;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆浏览历史 Mapper 接口
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface UserHistoryMapper extends BaseMapper<UserHistory> {

    List<UserHistory> userHistoryList(Map<String,Object> map);

}
