/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EurekaApplicaion
 * Author:   shibun
 * Date:     2019/2/23 22:05
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.swing.*;

/**
 *
 * 启动类
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicaion {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicaion.class);
    }
}