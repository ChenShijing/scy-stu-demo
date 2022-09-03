package tech.aistar.moudle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data//空参构造，getter/setter,toString,equals&hashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity //这个类是一个实体类，表和这个类对应
@Table(name = "t_user")
//@Component // 也是用来将该bean的生命周期交给spring容器进行管理的
public class User implements Serializable {

    //corejava
    //思想
    //传统的方式 - 主动创建对象User user = new User(); // 对象的创建
    //                     user.setName("admin"); // 对象的使用
    //谁使用对象,谁去创建对象

    //弊端 - 对象的创建和对象的使用耦合在一块儿了.
    //场景 - 谁吃饭,谁做饭 ->  效果:吃和做是分离 -> "做饭比较麻烦"

    //开发中有的对象
    //1. 重量级的对象   ->  这个对象比较占内存.
    //2. 创建麻烦的对象 -> 该对象的构建的过程比较繁琐.

    //实现对象的生命交给IOC容器进行管理(Spring框架)
    //开发者是直接从这个容器中去获取这个对象

    //spring - IOC/DI  AOP

    //空参构造
//    public User(){
//        System.out.println("空参构造...");
//    }
    //对象标识符
    @Id
    @GeneratedValue //主键生成的策略 -根据底层数据库的驱动来决定的，mysql -自增长的策略
    private Integer id;
    //用户名唯一性
    private String username;
    private String email;
    private String password;
    private String gender;//性别
    private int power;//0代表管理员，1代表用户

}
