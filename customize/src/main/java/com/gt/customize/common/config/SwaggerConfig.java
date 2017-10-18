package com.gt.customize.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * RestFul API 文档
 *
 * @author psr
 * @create 2017/6/15
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // 扫描包
	private static final String  BASEPACKAGE         = "com.gt.customize.core.controller";
    // 标题
    private static final String  TITLE               = "Customize API";
    // 描述
    private static final String  DESC                = "多粉项目应用类API";
    // 版本
    private static final String  VERSION             = "1.0.0";
    //
    private static final String  TERMS_OF_SERVICEURL = "NO terms of service";
    // 作者信息
    private static final Contact CONTACT             = new Contact( "psr", "http://www.duofriend.com", "3001303864@qq.com" );
    //
    private static final String  LICENSE             = "";
    //
    private static final String  LICENSE_URL         = "";
    
    /* .tags 第一个参数必须是Tag，后面的是 Tag 类型的可选参数 new Tag(String,String) 第一个参数是key，第二个参数是Value。注解@Api#tags传入的是tag的key */
    @Bean
    public Docket createRestApi() {
	    return new Docket( DocumentationType.SWAGGER_2 ).apiInfo( apiInfo() ).tags( new Tag( "customize", "多粉项目定制类API" ), getTags() ).select()
			.apis( RequestHandlerSelectors.basePackage( BASEPACKAGE ) ).paths( PathSelectors.any() ).build();
    }

	private Tag[] getTags() {
        Tag[] tags = { new Tag( "Customize", "多粉项目-定制类相关接口" ) };
        return tags;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo( TITLE, // 大标题
                DESC, // 小标题
                VERSION, // 版本
                TERMS_OF_SERVICEURL, CONTACT, // 作者
                LICENSE, // 链接显示文字
                LICENSE_URL// 网站链接
        );
    }
    
}
