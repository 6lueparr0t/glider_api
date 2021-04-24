package kr.glider.glider_kr.controller;

import kr.glider.glider_kr.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/generate-cache")
    public String generateCache() {
        testService.createInformation("test");

        return "Cache Generate Success";
    }

    @RequestMapping("/cache-test")
    public String cacheTest() {long start = System.currentTimeMillis();

        testService.getInformation("test");
        testService.getInformation("test");
        testService.getInformation("test");
        testService.getInformation("test");

        long end = System.currentTimeMillis();
        log.info("Cache : " + Long.toString(end-start));
        return "Greetings from Spring Boot!";
    }
}
