package com.mycomp.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/*
 * 相当于在配置文件中写了:
 * <bean id="user" class="com.mycomp.demo1.User"/>
 *
 * @Component衍生出的三个注解:
 * 1. @Controller: web层
 * 2. @Service: service层
 * 3. @Repository: dao层
 * 目前为止, 四个注解的功能一模一样;
 *
 * 注解的属性注入:
 * 1. 可以不用提供set方法，直接在属性名上添加注解, 如添加@value("值")
 * 2. 如果提供了set方法，在set方法上添加注解, 如添加@value("值");
 *
 * 注解开发相关注解:
 * @Value: 设置普通属性值;
 * @Autowired: 设置对象类型的属性值;
 *             直接使用这种方式，是按照类型完全属性注入, 不需要在注解上使用id名称
 *             但是, 我们习惯还是按照名称完成属性注入, 有两种方式:
 *             (1). 必须让@Autowired注解与@Qualifier("id")一起使用;
 *             (2). 单独使用@Resource(name = "id");
 * @PostConstruct: 初始化方法
 * @PreDestroy: 销毁方法
 * @scope: 作用范围(单例还是多例)
 *
 */

// @Component("user")
// @Scope("singleton") 默认的
@Scope("prototype")
public class User {

    // @Value("zzq")
    public String name;

    // @Autowired
    public Dog dog;

    // @Autowired
    // @Qualifier("dog")
    @Resource(name = "dog")
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Value("zzq")
    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("user init...");
    }

    @PreDestroy
    public void destrpy() {
        System.out.println("user destroy...");
    }
}
