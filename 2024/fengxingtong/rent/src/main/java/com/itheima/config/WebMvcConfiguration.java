package com.itheima.config;

import com.itheima.interceptors.AdminInterceptor;
import com.itheima.interceptors.UserInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private UserInterceptor userInterceptor;
    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始添加拦截器...");
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/user/login","/user/user/register");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/employee/login","/admin/employee/register");

    }


//    @Bean
//    public Docket docket1(){
//        log.info("准备生成接口文档...");
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("汽车租赁系统项目接口文档")
//                .version("2.0")
//                .description("汽车租赁系统项目接口文档")
//                .build();
//
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .groupName("管理端接口")
//                .apiInfo(apiInfo)
//                .select()
//                //指定生成接口需要扫描的包
//                .apis(RequestHandlerSelectors.basePackage("com.itheima.controller.admin"))
//                .paths(PathSelectors.any())
//                .build();
//
//        return docket;
//    }
//
//
//    @Bean
//    public Docket docket2(){
//        log.info("准备生成接口文档...");
//        ApiInfo apiInfo = new ApiInfoBuilder()
//                .title("汽车租赁系统项目接口文档")
//                .version("2.0")
//                .description("汽车租赁系统项目接口文档")
//                .build();
//
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .groupName("用户端接口")
//                .apiInfo(apiInfo)
//                .select()
//                //指定生成接口需要扫描的包
//                .apis(RequestHandlerSelectors.basePackage("com.itheima.controller.user"))
//                .paths(PathSelectors.any())
//                .build();
//
//        return docket;
//    }
//
//
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        log.info("开始设置静态资源映射...");
//        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }



}