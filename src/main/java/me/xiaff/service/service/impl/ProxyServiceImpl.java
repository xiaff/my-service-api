package me.xiaff.service.service.impl;

import me.xiaff.service.entity.ProxyOrder;
import me.xiaff.service.model.Proxy;
import me.xiaff.service.repository.ProxyOrderRepo;
import me.xiaff.service.service.ProxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProxyServiceImpl implements ProxyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyServiceImpl.class);

    @Resource
    private ProxyOrderRepo myProxyOrderRepo;

    @Override
    public List<Proxy> getProxies(int number) {
        Optional<ProxyOrder> proxyOrderOptional = myProxyOrderRepo.findById(1L);
        if (!proxyOrderOptional.isPresent()) {
            LOGGER.warn("NO proxy order found!");
            return null;
        }
        ProxyOrder proxyOrder = proxyOrderOptional.get();
        String orderId = proxyOrder.getOrderId();

        String baseUrl = "http://proxy.mimvp.com/api/fetch.php";
        String country = "中国";
        String resultFields = "1";

        String url = baseUrl
                + "?orderid=" + orderId
                + "&num=" + number
                + "&country=" + country
                + "&result_fields=" + resultFields;
        RestTemplate restTemplate = new RestTemplate();
        String resultStr = restTemplate.getForObject(url, String.class);
        if (StringUtils.isEmpty(resultStr)) {
            return null;
        }
        String[] lines = resultStr.split("\n");
        List<Proxy> proxyList = new ArrayList<>();
        for (String line : lines) {
            line = line.trim();
            if (!line.contains(":")) {
                LOGGER.error("CANNOT get proxy from http://proxy.mimvp.com !");
                LOGGER.warn("Maybe NEED TO PAY it!");
                return null;
            }
            String[] tokens = line.split(":");
            Proxy proxy = new Proxy(tokens[0], Integer.parseInt(tokens[1]));
            proxyList.add(proxy);
        }
        return proxyList;
    }
}
