package tech.aistar.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import tech.aistar.moudle.pojo.Nucleic;


import java.util.Date;
import java.util.List;

@SpringBootTest
public class NucleicDaoTest {
    @Autowired
    private INucleicDao nucleicDao;

    @Test
    public void testSave(){

        Nucleic nucleic=new Nucleic();

        nucleic.setUserId(6);
        nucleic.setUsername("sj");
        nucleic.setCreateDate(new Date());
        nucleic.setStatus(1);// 1绿码  2红码
        nucleic.setRemark("healthy");
        nucleic.setUrl("xxx05.png");

        nucleicDao.save(nucleic);
    }
    @Test
    public void testFindAll(){
        List<Nucleic> nucleicList = nucleicDao.findAll();
        nucleicList.forEach(System.out::println);
    }
    @Test
    public void testDelById(){
        nucleicDao.deleteById(17);
    }

    @Test
    public void testUpdate(){
        Nucleic nucleic =nucleicDao.findById(16).get();

        nucleic.setUsername("ss");

        nucleicDao.saveAndFlush(nucleic);
    }
    @Test
    public void testFindByStatus(){
        List<Nucleic> nucleicList = nucleicDao.findByStatus(1);
        if(null!=nucleicList && nucleicList.size()>0){
            nucleicList.forEach(e-> System.out.println(e));
        }else{
            System.out.println("sorry");
        }

    }

    }







