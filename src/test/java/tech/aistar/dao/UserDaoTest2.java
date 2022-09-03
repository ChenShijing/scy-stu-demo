package tech.aistar.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.moudle.pojo.User;

import java.util.List;

@SpringBootTest
public class UserDaoTest2 {
    @Autowired
    private IUserDao userDao;
    @Test
    public  void  testFindByMail(){
        User user=userDao.getByEmail("2210580877@qq.com");
        System.out.println(user);
    }
    @Test
    public void testFindId(){

        System.out.println(userDao.loadByById(3));
    }

    @Test
    public  void  testDelByGender(){
        int count = userDao.deleteByGender("M");
        System.out.println("删除了"+count+"行");
    }

    @Test
    public void testFindLike(){
        List<User> userList = userDao.findByUsernameContains("c");
        if(null!=userList&&userList.size()>0){
            userList.forEach(e->System.out.println(e));
        }else{
            System.out.println("没有数据");
        }
    }

    @Test
    public void testPage(){
        //内置分页
        //page-表示当前从0开始显示，显示第几页
        //size-表示每页显示的条数
        PageRequest pageable= PageRequest.of(1,2);

        //page对象-包含分页的所有数据
        Page<User> userPage= (Page<User>) userDao.findAll(pageable);
        List<User> users=userPage.getContent();
        users.forEach(e->System.out.println(e));
    }

    /*@Test
    public void testFindAndPages(){
        //内置的分⻚
        //设置分⻚的属性
        //page - 当前⻚,从0开始的
        //size - 每⻚显示的条数
        Pageable pageable = PageRequest.of(1,2);
        //内置的page对象 - 包含分⻚的所有的数据
        Page<User> userPage = userDao.findByUsernameContains("m",pageable);
        //具体的分⻚的的得到的数据
        List<User> users = userPage.getContent();
        users.forEach(e-> System.out.println(e));
    }*/
    @Test

    public void testFindAndPages(){
        //内置的分⻚
        //设置分⻚的属性
        //page - 当前⻚,从0开始的
        //size - 每⻚显示的条数
        Pageable pageable = PageRequest.of(1,2);
        //内置的page对象 - 包含分⻚的所有的数据
        //Page<User> userPage = userDao.findByUsernameContains("m",pageable);
        Page<User> userPage =
                userDao.findByUsernameContainsOrderByIdDesc("m",pageable);
        //具体的分⻚的的得到的数据
        List<User> users = userPage.getContent();
        users.forEach(e-> System.out.println(e));
    }
   /* @Test
    public void testFindByUsername() {
        User user = userDao.getByUsername("csj");
        System.out.println(user);

    }*/
}

