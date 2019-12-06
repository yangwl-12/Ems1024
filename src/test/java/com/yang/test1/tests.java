package com.yang.test1;

import com.yang.entity.Emp;
import com.yang.service.EmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class tests {
    @Test
    public void test5() {
        ApplicationContext ccx = new ClassPathXmlApplicationContext("spring-core.xml");
        EmpService ee = (EmpService) ccx.getBean("empServiceImpl");
        ee.modifyOne(new Emp("102", "sssshh", 100.0, 18, new Date()));
        System.out.println("123");

    }
}
