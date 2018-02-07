package com.laozhang.domain;

import com.laozhang.entity.UserInfo;
import com.laozhang.service.UserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangchengfu on 2018/2/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() throws Exception {
        String formateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        User user = userRepository.save(new User("aa","123","123@163.com","风云",formateDate));

        Assert.assertEquals(1, userRepository.findAll().size());

        System.out.println("User.id: " + user.getId());
    }

    @Test
    public void createUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("测试");
        userInfo.setPassword("123456");
        userInfo.setState((byte) 0);
        userInfo.setUsername("test");
        userInfoService.createUserInfo(userInfo);
    }
}
