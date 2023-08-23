package ng.hx.study.controller;

import com.alibaba.fastjson2.JSON;
import ng.hx.study.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping("/res1")
    public String getRes1(){
        return JSON.toJSONString(new Result(200, "资源服务8002 -> 资源1"));
    }

    @GetMapping("/res2")
    public String getRes2(){
        return JSON.toJSONString(new Result(200, "资源服务8002 -> 资源2"));
    }
}
