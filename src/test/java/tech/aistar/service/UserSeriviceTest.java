package tech.aistar.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.aistar.moudle.pojo.User;

@SpringBootTest
public class UserSeriviceTest {
    @Autowired
    private  IUserService userService;

    @Test
    public void testLoadByEmail(){
        User user = userService.loadByEmail("2210580877@qq.com");
        System.out.println("user:"+user);
    }
}
