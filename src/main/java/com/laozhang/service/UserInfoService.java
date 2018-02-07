package com.laozhang.service;

import com.laozhang.entity.UserInfo;

/**
 * Created by zhangchengfu on 2018/2/5.
 */
public interface UserInfoService {
    /*通过username查找用户信息*/
    UserInfo findByUsername(String username);

    /*创建用户*/
    UserInfo createUserInfo(UserInfo userInfo);
}
