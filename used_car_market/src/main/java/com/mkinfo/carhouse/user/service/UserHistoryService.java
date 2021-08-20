package com.mkinfo.carhouse.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mkinfo.carhouse.user.model.UserHistory;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆浏览历史 服务类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public interface UserHistoryService extends IService<UserHistory> {
    /**
     * @title: userHistoryList
     * @path:
     * @description: 获取用户历史列表信息
     * @author: MK
     * @date: 2021-04-07 10:43
     * @param: [map]
     * @return: java.util.List<com.mkinfo.carhouse.user.model.UserHistory>
     * @throws:
     * @modefied: 2021-04-07 10:43 MK 修改
     */
    List<UserHistory> userHistoryList(Map<String,Object> map);
}
