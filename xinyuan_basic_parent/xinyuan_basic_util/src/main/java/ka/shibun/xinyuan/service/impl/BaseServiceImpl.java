/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseServiceImpl
 * Author:   shibun
 * Date:     2019/2/23 23:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.service.impl;

import ka.shibun.xinyuan.query.BaseQuery;
import ka.shibun.xinyuan.repository.BaseRepository;
import ka.shibun.xinyuan.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T,ID> {

    @Autowired
    private BaseRepository<T,ID> baseRepository;

    @Override
    @Transactional
    public void save(T t) {
        baseRepository.save(t);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    public T findOne(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page<T> findPageByQuery(BaseQuery baseQuery) {
        return baseRepository.findPageByQuery(baseQuery);
    }

    @Override
    public List<T> findByQuery(BaseQuery baseQuery) {
        return baseRepository.findByQuery(baseQuery);
    }

    @Override
    public List findByJpql(String jpql, Object... values) {
        return baseRepository.findByJpql(jpql, values);
    }
}
