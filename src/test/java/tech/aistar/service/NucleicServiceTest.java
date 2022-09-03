package tech.aistar.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.aistar.moudle.pojo.Nucleic;

import java.util.List;

@SpringBootTest
public class NucleicServiceTest {
    @Autowired
    private INucleicService nucleicService;
    @Test
    public void testLoadAll(){
        nucleicService.loadAll(0).forEach(e-> System.out.println(e));
    }
    @Test
    public void testLoadAllPage(){
        Page<Nucleic> page = nucleicService.loadAll(0,2,2);
        //获取分⻚的数据
        List<Nucleic> nucleicList = page.getContent();
        nucleicList.forEach(e-> System.out.println(e));
    }

}
