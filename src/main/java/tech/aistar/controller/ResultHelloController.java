package tech.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.moudle.pojo.ResultReturn;

@Controller
public class ResultHelloController {
    //映射路径,整个应⽤中必须保证唯⼀性,否则会抛出异常
    @ResponseBody
    @GetMapping("test")// 将这个⽅法的返回结果转换成json字符串 => key:value形式
    public ResultReturn hello(){
        return new ResultReturn("200", "测试");
    }

}
