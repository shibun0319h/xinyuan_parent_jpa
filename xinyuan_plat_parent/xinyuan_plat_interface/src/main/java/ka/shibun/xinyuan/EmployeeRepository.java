/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeRepository
 * Author:   shibun
 * Date:     2019/2/23 23:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import ka.shibun.xinyuan.domain.Employee;
import ka.shibun.xinyuan.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
public interface EmployeeRepository extends BaseRepository<Employee,Long> {

}