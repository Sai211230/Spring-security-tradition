package com.sai.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringSecurityApplication.class, args);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        printBeansName(beanDefinitionNames);
    }

    private static void printBeansName(String[] beanNames) {
        int index = 1;
        for (String beanName : beanNames) {
            System.out.println(index + "：" + beanName);
            index ++;
        }
    }

}
