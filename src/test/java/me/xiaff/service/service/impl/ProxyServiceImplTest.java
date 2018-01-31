package me.xiaff.service.service.impl;

import me.xiaff.service.model.Proxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyServiceImplTest {
    @Autowired
    private ProxyServiceImpl proxyService;

    @Test
    public void getProxies() {
        List<Proxy> proxies = proxyService.getProxies(10);
        proxies.forEach(System.out::println);
    }
}