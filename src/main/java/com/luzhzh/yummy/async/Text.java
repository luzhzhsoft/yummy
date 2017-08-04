package com.luzhzh.yummy.async;

import com.bw.dc.point.ae.portal.ActivationeventAsV2;
import com.bw.dc.point.ae.portal.CreatenewmoduleAsV4;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Created by luzhzh on 7/11/2017.
 */
@RestController
public class Text {

    @RequestMapping("/test")
    public ResponseBodyEmitter hanle(){
        ActivationeventAsV2 activationeventAsV2=new ActivationeventAsV2();
        CreatenewmoduleAsV4 createnewmoduleAsV4=new CreatenewmoduleAsV4();
        ResponseBodyEmitter emitter=new ResponseBodyEmitter();
        new Thread(()->{
            while (true){
                System.out.print("fds");
                try {
                    emitter.send("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //emitter.complete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return emitter;
    }

}
