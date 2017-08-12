package com.luzhzh.yummy.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luzhzh on 6/13/2017.
 * 用来做k8s 存活检测
 */
@RestController
public class Probe {

    /*@Autowired
    IPushClient client;*/

    @RequestMapping("/liveness")
    String getLivenessProbe() {
        System.out.print("f452s4a");
        return "ok";
    }



}
