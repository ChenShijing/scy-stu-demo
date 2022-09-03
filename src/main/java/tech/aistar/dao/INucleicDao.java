package tech.aistar.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.aistar.moudle.pojo.Nucleic;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface INucleicDao extends JpaRepository<Nucleic,Integer> {
    List<Nucleic> findByStatus(Integer status);

    //分页

    Page<Nucleic> findByStatus(Integer status,Pageable pageable);
//    删除
    @Modifying
    @Query("delete from Nucleic where id=?1")
    int delById(Integer id);


}
