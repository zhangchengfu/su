package com.laozhang.web;

import com.laozhang.util.Myproperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhangchengfu on 2018/2/2.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

    @Autowired
    private Myproperties myproperties;

    @Test
    public void getHello() throws Exception {
        System.out.println(myproperties.getTitle());
        Assert.assertEquals("纯洁的微笑", myproperties.getTitle());
    }
}
