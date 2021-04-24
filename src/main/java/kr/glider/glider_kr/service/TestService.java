package kr.glider.glider_kr.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    private List<String> list;

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
    }

    @Cacheable(value = "test")
    public String getInformation(String info) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list.stream().filter(x -> x.equals(info)).findFirst().get();
    }

    @CacheEvict(value = "test")
    public void createInformation(String info) {
        list.add(info);
    }
}
