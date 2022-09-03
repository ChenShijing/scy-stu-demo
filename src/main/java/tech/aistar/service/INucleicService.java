package tech.aistar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tech.aistar.moudle.pojo.Nucleic;

import java.util.List;

public interface INucleicService {
    /**
     * 根据用户名去查找⽤户
     * @param
     * @return
     */

    List<Nucleic> loadAll(Integer status);

    /**
     *
     * @param status 0 1
     * @param pageNum 当前⻚
     * @param pageSize 每⻚显示的条数
     * @return
     */
    Page<Nucleic> loadAll(Integer status,Integer pageNum,Integer pageSize);

    /**
     * 根据id进⾏删除
     * @param id
     * @return
     */
    int delById(Integer id);
}
