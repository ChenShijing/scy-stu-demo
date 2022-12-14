package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.aistar.dao.IUserDao;
import tech.aistar.moudle.pojo.ResultReturn;
import tech.aistar.moudle.pojo.User;
import tech.aistar.service.IUserService;

import javax.net.ssl.SSLEngine;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    //接受邮箱,并且进⾏验证码的⼀个发送功能
    //如果此处接受⼀个ajax传过来的json对象的值.
    //保证该⽅法的参数的名称和json对象的key的命名⾼度保持⼀致
    @Autowired
    private JavaMailSender sender;

    @GetMapping("sendCode")
    public ResultReturn sendCode(HttpServletRequest request, String email) {
        User user = userService.loadByEmail(email);

        if (null==user){
            return new ResultReturn("404","sorry,用户不存在！");
        }
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setFrom("2210580877@qq.com");
        msg.setSubject("阿里云验证码");

        //随机六位数
        //随机⼀个6位数
        int codeInt = (int) (Math.random()*100000+900000);
        String code = String.valueOf(codeInt);//int类型=>String类型
        msg.setText(code);
        msg.setTo(email);
        //发送
        sender.send(msg);
    //将刚刚⽣成的验证码存储到session作⽤域中.
        HttpSession session = request.getSession();
        session.setAttribute(email,code);
        return new ResultReturn("200","查收邮件!查看验证码!");


}
    @PostMapping("login")
    public ResultReturn login(HttpServletRequest request,String email,String
            code){
        //调⽤service中根据邮箱查找⽤户的⽅法
        User user = userService.loadByEmail(email);
        //判断该user是否为null
        if(null==user) {
            //return是⽤来结束整个⽅法的.下⾯的代码将不会执⾏.
            return new ResultReturn("404", "sorry,⽤户不存在!");
        }
        HttpSession session = request.getSession();
        //获取当前邮箱对应的session中的保存的code
        String codeSession = (String) session.getAttribute(email);
        if(null==codeSession){
            return new ResultReturn("500", "sorry,请先发送验证码!");
        }
        //验证码的⽐较
        if(codeSession.equals(code)){
            //为了将登录成功之后的⽤户名能够在各个⻚⾯中进⾏展示.
            //因此需要将这个⽤户名直接返回出去.
            return new ResultReturn("200", "登录成功!",user.getUsername());
        }
        return new ResultReturn("5xx", "登录失败!");
    }
}
