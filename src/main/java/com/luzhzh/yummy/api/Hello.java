package com.luzhzh.yummy.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * Created by luzhzh on 6/13/2017.
 */
@RestController
public class Hello {

    @RequestMapping("/hello")
    String hello(){
        return "hello honey!";
    }

    @RequestMapping("/hello/{name}")
    String test(@PathVariable String name){
        Jedis jedis=new Jedis("redis.yummy.svc");
        jedis.set("name",name);

        return "ok";
    }

    @RequestMapping("/get")
    String get(){
        Jedis jedis=new Jedis("redis.yummy.svc");
        return jedis.get("name");
    }

}
