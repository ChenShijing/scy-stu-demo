package tech.aistar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.aistar.moudle.pojo.ResultReturn;
import tech.aistar.moudle.pojo.User;

@RestController
@RequestMapping("param")
public class ParamController {

    @GetMapping("hello")
    public ResultReturn hello(Integer id,String username){
        System.out.println("id"+id);
        System.out.println("username"+username);

        //后端返回数据给前端，并且转换成json字符
        return new ResultReturn("200","摆地摊",id+":"+username);
    }

    @GetMapping("test01")
    public ResultReturn test01(User user) {
        System.out.println("user:" + user);
        return new ResultReturn("200", "摆地摊", user);
    }
}
