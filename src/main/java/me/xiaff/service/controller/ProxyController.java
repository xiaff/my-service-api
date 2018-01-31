package me.xiaff.service.controller;

import me.xiaff.service.service.ProxyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api/proxy")
public class ProxyController {

    @Resource
    private ProxyService proxyService;

    @GetMapping("/get/{num}")
    @ResponseBody
    public List getProxies(@PathVariable(name = "num") Integer number) {
        if (number > 1000) {
            number = 1000;
        } else if (number < 10) {
            number = 10;
        }
        return proxyService.getProxies(number);
    }
}
