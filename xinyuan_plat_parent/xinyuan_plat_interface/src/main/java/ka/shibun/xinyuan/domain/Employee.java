/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Employee
 * Author:   shibun
 * Date:     2019/2/23 22:07
 * Description: 用户类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * 用户类
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@Entity
@Table(name = "t_employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}