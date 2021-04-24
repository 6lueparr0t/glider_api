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

    @CacheEvict(value = "sampleCache")
    public void createInformation() {
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
    }

    @Cacheable(value = "sampleCache")
    public List<String> getInformation() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
