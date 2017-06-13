package com.luzhzh.yummy.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luzhzh on 6/13/2017.
 */
@RestController
public class Hello {

    @RequestMapping("/hello")
    String hello(){
        return "hello honey!";
    }
}
