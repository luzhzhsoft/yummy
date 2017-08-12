package com.luzhzh.yummy.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by luzhzh on 6/16/2017.
 * 用来管理存储空间的
 */
@RestController
@RequestMapping("/storage")
public class StorageApi {

    @Autowired
    Environment env;

/*    @Autowired
   public static IPushClient client = null;


    @Bean
    public static IPushClient getIPushClient() {
        if (client == null) {
            client = new PushClient();

        }
        return client;
    }*/

    @RequestMapping("/base")
    String getBase() {
        return env.getProperty("storage.dir");
    }


    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public void getValue(HttpServletRequest request, HttpServletResponse response) {
        String path = extractPathFromPattern(request);
        path = getBase() + path;

        File file = new File(path);


    }


    private String extractPathFromPattern(final HttpServletRequest request) {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
    }

}
