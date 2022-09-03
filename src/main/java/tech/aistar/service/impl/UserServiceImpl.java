package tech.aistar.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.aistar.dao.IUserDao;
import tech.aistar.moudle.pojo.User;
import tech.aistar.service.IUserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;


    @Override
    public User loadByEmail(String email){
        return userDao.getByEmail(email);
    }
}
