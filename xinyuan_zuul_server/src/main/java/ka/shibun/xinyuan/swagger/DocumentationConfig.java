/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DocumentationConfig
 * Author:   shibun
 * Date:     2019/2/23 22:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.swagger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author shibun
 * @create 2019/2/23
 * @since 1.0.0
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        //aigou网关前缀,employee网关路径   ；swagger的路径 ，以后增加了接口就在这配置就ok
        resources.add(swaggerResource("用户系统", "/xinyuan/employee/v2/api-docs", "2.0"));
        resources.add(swaggerResource("商品系统", "/aigou/product/v2/api-docs", "2.0"));
        resources.add(swaggerResource("基础系统", "/aigou/common/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}