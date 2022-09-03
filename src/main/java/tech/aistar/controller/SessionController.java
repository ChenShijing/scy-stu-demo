package tech.aistar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.moudle.pojo.ResultReturn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("ses")
public class SessionController {
    @GetMapping("from")
    public  String from(HttpServletRequest request){
        //获取session对象
        HttpSession session = request.getSession();
        //将数据放入session作用域中
        session.setAttribute("username","admin");
        return "redirect:/ses/to";

    }
    @ResponseBody
    @GetMapping("to")
    public ResultReturn to(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        return  new ResultReturn("200","session作用域",username);
    }
}
