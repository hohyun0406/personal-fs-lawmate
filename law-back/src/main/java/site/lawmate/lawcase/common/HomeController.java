package com.rod.api.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String hello(){
        return "Welcome To String Boot !";
    }

    @PostMapping("/api/name")
    public Map<String,?> name (@RequestBody Map<String,?> map){
        String name = (String)map.get("name");
        log.info("리퀘스트가 가져온 이름 : {}", name);
        Map<String,String> respMap = new HashMap<>();
        respMap.put("name", "환영합니다" + name);
        return respMap;
    }
}
