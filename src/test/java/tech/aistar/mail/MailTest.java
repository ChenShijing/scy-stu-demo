package tech.aistar.mail;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSender sender;

    @Test
    public  void  testSend(){
        //使用一个对象，来封装邮件的信息
        SimpleMailMessage msg = new SimpleMailMessage();
        //发送方邮箱
        msg.setFrom("2210580877@qq.com");
        //邮件标题-主题
        msg.setSubject("苏州建土豪学院");
        //邮件的正文
        msg.setText("苏州土豪学院邀请你参观选择！");
        //收件方
        msg.setTo("2366623383@qq.com");

        //发送
        sender.send(msg);
    }
}
