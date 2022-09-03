package tech.aistar.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.aistar.dao.INucleicDao;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.service.INucleicService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NucleicServiceImpl implements INucleicService {
    //service层调⽤dao层
    @Autowired
    private INucleicDao nucleicDao;

//    @Override
//    public Nucleic loadByUsername(String username){
//        //通过dao去和db进⾏直接的交互 - ⽐如获取数据
//        //可以对这个获取出来的数据进⾏进⼀步的处理
//
//        //可以对username进⾏⼀个格式的校验
//        return nucleicDao.getByUsername(username);
//    }

    @Override
    public List<Nucleic> loadAll(Integer status) {
        //当status为null的时候 - 查询所有的
        if(status == null)
            return nucleicDao.findAll();
        //status不为null,0或者1
        return nucleicDao.findByStatus(status);
    }
    @Override
    public Page<Nucleic> loadAll(Integer status,Integer pageNum,Integer pageSize){
        Pageable pageable =PageRequest.of(pageNum-1,pageSize);
        if (status == null){
            return nucleicDao.findAll(pageable);
        }
        return nucleicDao.findByStatus(status,pageable);
    }
    @Override
    public int delById(Integer id){
        return nucleicDao.delById(id);
    }




}
