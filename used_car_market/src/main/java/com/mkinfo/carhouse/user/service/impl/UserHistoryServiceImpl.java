package com.mkinfo.carhouse.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mkinfo.carhouse.user.dao.UserHistoryMapper;
import com.mkinfo.carhouse.user.model.UserHistory;
import com.mkinfo.carhouse.user.service.UserHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆浏览历史 服务实现类
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryMapper, UserHistory> implements UserHistoryService {
    @Resource
    private UserHistoryMapper userHistoryMapper;

    @Override
    public List<UserHistory> userHistoryList(Map<String,Object> map) {
        return userHistoryMapper.userHistoryList(map);
    }
}
