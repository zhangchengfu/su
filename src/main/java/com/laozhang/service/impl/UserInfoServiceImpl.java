package com.laozhang.service.impl;

import com.laozhang.dao.UserInfoDao;
import com.laozhang.entity.UserInfo;
import com.laozhang.service.UserInfoService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by zhangchengfu on 2018/2/5.
 */

@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

    @Override
    public UserInfo createUserInfo(UserInfo userInfo) {
        userInfo.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                "md5",
                userInfo.getPassword(),
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
                2
        ).toHex();
        userInfo.setPassword(newPassword);
        return userInfoDao.save(userInfo);
    }
}
