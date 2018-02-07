package com.laozhang.dao;

import com.laozhang.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by zhangchengfu on 2018/2/5.
 */
public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
     /*通过username查找用户信息*/
    UserInfo findByUsername(String username);
}
