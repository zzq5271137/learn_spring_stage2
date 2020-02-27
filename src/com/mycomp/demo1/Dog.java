package com.mycomp.demo1;

import org.springframework.beans.factory.annotation.Value;

// @Component("dog")
public class Dog {

    @Value("大黄")
    public String dogname;
}
