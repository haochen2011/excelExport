package com.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {



    @GetMapping("/hi-feign")
    public String hiFeign() {
        return "hi";
    }
}