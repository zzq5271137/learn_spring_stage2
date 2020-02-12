package com.mycomp.demo1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        User user1 = (User) applicationContext.getBean("user");
        System.out.println(user1.name);
        System.out.println(user1.dog.dogname);

        User user2 = (User) applicationContext.getBean("user");
        System.out.println(user1);
        System.out.println(user2);

        applicationContext.close();
    }

}
