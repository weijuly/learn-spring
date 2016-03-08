package com.weijuly.develop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weijuly.develop.knight.Knight;

public class SpringMain {

    public static void main(String[] args) {

	String className = SpringMain.class.getSimpleName();

	System.out.println(className + ".main(): begin>=>=>=>=>=>=>=>=>=>=>=>=>");

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	Knight knight = context.getBean(Knight.class);
	
	knight.embarkQuest();
	
	((ConfigurableApplicationContext)context).close();

	System.out.println(className + ".main(): end<=<=<=<=<=<=<=<=<=<=<=<=<=<=");
    }
}
