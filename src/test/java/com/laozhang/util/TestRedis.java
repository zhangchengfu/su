package com.laozhang.util;

import com.laozhang.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangchengfu on 2018/2/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testobj() throws Exception {
        String formateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        User user = new User("aa","123","123@163.com","风云",formateDate);
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("com.laozhang", user);
        operations.set("com.laozhang.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.laozhang.f");
        boolean exists = redisTemplate.hasKey("com.laozhang.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        Assert.assertEquals("aa", operations.get("com.laozhang").getUserName());
    }
}
