package com.schh.spring6.iocxml.dimap;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStu {
    @Test
    public void TestStu() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dimap.xml");

        Student student = context.getBean("student", Student.class);

        student.run();


    }
}
