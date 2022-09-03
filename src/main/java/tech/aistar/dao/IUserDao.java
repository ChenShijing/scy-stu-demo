package tech.aistar.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.aistar.moudle.pojo.Nucleic;
import tech.aistar.moudle.pojo.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IUserDao extends JpaRepository<User,Integer> {
    User getByEmail(String email);

    @Query(value = "select * from t_user where id=?1",nativeQuery = true)
    User loadByById(Integer id);

    @Query("from User where id=?1")
    User loadWithId(Integer id);
    @Modifying
    @Query("delete from User where gender=?1")
    int deleteByGender(String gender);

    List<User> findByUsernameContains(String username);

    //Page<User> findByUsernameContains(String username, Pageable pageable);
    Page<User> findByUsernameContainsOrderByIdDesc(String username,Pageable
            pageable);


    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);


}
