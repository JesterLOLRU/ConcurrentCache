package com.example.concurrentcache.controller;

import com.example.concurrentcache.service.CacheService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("cacheController")
@RequestMapping(value = "web/cache")
@Tag(name = "API для работы с кэшем")
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @PutMapping("/put")
    @Tag(name = "Положить кей-велью в кэш")
    public void putData(@RequestParam String key, @RequestParam String value) {
        cacheService.putData(key, value);
    }

    @GetMapping("/get")
    @Tag(name = "Получить велью по кею")
    public String getData(@RequestParam String key) {
        return cacheService.getData(key);
    }
}
