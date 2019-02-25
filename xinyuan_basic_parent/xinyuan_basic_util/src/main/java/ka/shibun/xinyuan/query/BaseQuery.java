/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseQuery
 * Author:   shibun
 * Date:     2019/2/23 23:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.query;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
public abstract class BaseQuery {
    //当前页
    private Integer currentPage=1;
    //每页显示条数
    private Integer pageSize = 10;

    //排序的字段
    private String orderByName;

    //排序的类型
    private String orderByType = "asc";

    //new PageRequest(page,pageSize,sort) 得到当前页
    public int getJpaPage(){
        return currentPage-1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderByName() {
        return orderByName;
    }

    public void setOrderByName(String orderByName) {
        this.orderByName = orderByName;
    }

    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    //获取spe方法
    public abstract Specification createSpecification();

    //排序
    public Sort createSort(){

        Sort sort = null;
        if(orderByName != null){
            Sort.Direction direction = "asc".equals(orderByType)?Sort.Direction.ASC:Sort.Direction.DESC;
            sort = new Sort(direction,orderByName);
        }

        return sort;
    }

    //通过setPage 和 setRows 设置当前的页 以及每页显示的条数
    //easyui的分页
    public void setPage(int page){
        this.currentPage = page;
    }

    public void setRows(int rows){
        this.pageSize=rows;
    }
}
