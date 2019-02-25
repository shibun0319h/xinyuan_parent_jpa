/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IBaseService
 * Author:   shibun
 * Date:     2019/2/23 23:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.service;

import ka.shibun.xinyuan.query.BaseQuery;
import org.springframework.data.domain.Page;

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
public interface IBaseService<T,ID extends Serializable> {
    //保存和修改
    void save(T t);
    //删除
    void delete(ID id);
    //查询单条
    T findOne(ID id);
    //查询所有
    List<T> findAll();
    //分页查询
    Page<T> findPageByQuery(BaseQuery baseQuery);
    //不带分页带条件的查询
    List<T> findByQuery(BaseQuery baseQuery);
    //根据jpql查询
    List findByJpql(String jpql,Object... values);
}