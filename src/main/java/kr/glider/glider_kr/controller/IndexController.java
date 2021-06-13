package kr.glider.glider_kr.controller;

import kr.glider.glider_kr.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/")
public class IndexController {
    @Autowired
    TestService testService;

    @RequestMapping("/v1/generate-cache")
    public String generateCache() {
        testService.createInformation();

        return "Cache Generate Success";
    }

    @RequestMapping("/v1/cache-test")
    public String cacheTest() {long start = System.currentTimeMillis();

        log.info("{}", testService.getInformation());
        log.info("{}", testService.getInformation());
        log.info("{}", testService.getInformation());
        log.info("{}", testService.getInformation());

        long end = System.currentTimeMillis();
        log.info("Cache : " + Long.toString(end-start));
        return "Greetings from Spring Boot!";
    }
}
