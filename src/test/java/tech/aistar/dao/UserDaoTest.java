package tech.aistar.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.aistar.dao.IUserDao;
import tech.aistar.moudle.pojo.User;

import java.util.List;

@SpringBootTest
public class UserDaoTest {
    //测试IUserDao接口
    @Autowired
    private IUserDao userDao;
    //测试 - save
    //运⾏单元 -> 双击选中testSave⽅法 -> 右击 -> Run
    @Test
    public void testSave(){
        //模拟⼀个user对象
        //本质 - java内存中的对象持久化[保存]到磁盘上的数据库的表中.
        //创建user对象
        User user = new User();
        //setter赋值scy
        //因为id是⾃增⻓的,因此不需要设置
        //id是主键列 - ⽤来唯⼀确定⼀⾏ - 唯⼀的
        //唯⼀性
        user.setUsername("CC");
        user.setEmail("3310580877@qq.com");
        user.setGender("M");
        user.setPower(1);
        user.setPassword("789");
        //调⽤dao中的save⽅法
        userDao.save(user);
    }
    //测试查询⼀下所有的数据
    @Test
    public void testFindAll(){
        List<User> userList = userDao.findAll();

    }
    //测试 - 根据id进⾏删除
    @Test
    public void testDelById(){
        userDao.deleteById(2);
    }
    //测试 - 更新
    @Test
    public void testUpdate(){
        //更新的是db中存在的数据
        //1. 根据id进⾏查询,因为id是唯⼀的,返回的是⼀个单个对象
        User user=userDao.findById(3).get();

        //直接在内存中进⾏修改
        user.setPassword("456");
        user.setGender("F");

        //更新 - 内存中的对象同步到表中
        userDao.saveAndFlush(user);


    }

}
