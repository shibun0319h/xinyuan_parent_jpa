/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseRepositoryFactoryBean
 * Author:   shibun
 * Date:     2019/2/23 23:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
public class BaseRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID> {

    public BaseRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new MyRepositoryFactory<T,ID>(entityManager); //注：这里创建是我们的自定义类
    }

    //继承JpaRepositoryFactory后，把返回的对象修改成我们自己的实现
    private static  class MyRepositoryFactory<T,ID extends Serializable>   extends JpaRepositoryFactory {
        private final EntityManager entityManager;
        /**
         * Creates a new {@link JpaRepositoryFactory}.
         *
         * @param entityManager must not be {@literal null}
         */
        public MyRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
            this.entityManager = entityManager;
        }
        //这里返回最后的功能对象 返回自己的实现类 仓库的信息对象
        @Override
        protected Object getTargetRepository(RepositoryInformation information) {
            return new BaseRepositoryImpl<T,ID>((Class<T>)information.getDomainType(),entityManager);
        }
        //确定功能对象的类型
        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseRepositoryImpl.class;
        }
    }

}
