package com.laozhang.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 测试jsoup
 * Created by zhangchengfu on 2018/3/8.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJsoup {

    @Test
    public void test() throws IOException {
        String url = "https://gate.io/trade/EOS_USDT";
        Document document = Jsoup.connect(url).ignoreContentType(true).get();
        Element element = document.body();
        //获取最新价格
        Element span = element.getElementById("orderbook_last_rate");
        String lastRate = span.text();
    }
}
