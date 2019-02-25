/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseRepository
 * Author:   shibun
 * Date:     2019/2/23 23:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.repository;

import ka.shibun.xinyuan.query.BaseQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

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
@NoRepositoryBean//该接口不会创建这个接口的实例
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {
    //公共的方法
    //根据Query拿到分页对象(分页)
    Page findPageByQuery(BaseQuery baseQuery);

    //根据Query拿到对应的所有数据(不分页)
    List<T> findByQuery(BaseQuery baseQuery);

    //根据jpql与对应的参数拿到数据
    List findByJpql(String jpql, Object... values);
}