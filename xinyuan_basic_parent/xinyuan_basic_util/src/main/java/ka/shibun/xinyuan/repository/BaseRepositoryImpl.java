/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseRepositoryImpl
 * Author:   shibun
 * Date:     2019/2/23 23:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.repository;

import ka.shibun.xinyuan.query.BaseQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
public class BaseRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {
    //用于操作数据库
    private final EntityManager entityManager;

    //必需要实现父类的这个构造器,这里手动构造父类
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }
    //分页查询的方法
    @Override
    public Page findPageByQuery(BaseQuery baseQuery) {
        //第一步：拿到所有高级查询条件
        Specification spec = baseQuery.createSpecification();
        //第二步:拿到排序的值
        Sort sort = baseQuery.createSort();
        //第三步:根据条件查询分页数据并且返回
        Pageable pageable = new PageRequest(baseQuery.getJpaPage(), baseQuery.getPageSize(),sort);
        Page<T> page = super.findAll(spec, pageable);
        return page;
    }

    @Override
    public List<T> findByQuery(BaseQuery baseQuery) {
        //第一步：拿到所有高级查询条件
        Specification spec = baseQuery.createSpecification();
        //第二步:拿到排序的值
        Sort sort = baseQuery.createSort();
        //第三步:拿到数据返回
        return findAll(spec, sort);
    }
    //select o from Employee o where o.name like ?
    @Override
    public List findByJpql(String jpql, Object... values) {
        //第一步:创建Query对象
        Query query = entityManager.createQuery(jpql);
        //第二步:把值设置到Query对象中去
        if (values!=null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i + 1, values[i]);
            }
        }
        //第三步：返回数据
        return query.getResultList();
    }
}