package com.spring.Model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	
	public static void main(String[] args) {
		//Ref
		ApplicationContext context =  new ClassPathXmlApplicationContext("bean.xml");
		Student s1 = (Student) context.getBean("s1");
		System.out.println(s1.toString());
		
		//Inner Bean
		Student s2 = (Student) context.getBean("s2");
		System.out.println(s2.toString());
		
		//Constructor Ref
		Student s3 = (Student) context.getBean("constrS3");
		System.out.println(s3.toString());
		
		//Autowiring matters at getBean(), supported for Objects.
		//Setters should be named accordingly
		
		//AutoWired byType --> only single bean matching the type, no need to match the name:
		//Student s4 = (Student) context.getBean("AutoWS4");
		//System.out.println(s4.toString());
		//No qualifying bean of type 'com.spring.Model.Address' available: expected single matching bean but found 3: addressBean,addressRef,addressWire
		ApplicationContext context2 =  new ClassPathXmlApplicationContext("AutoWireBean.xml");
		Student s5 = (Student) context2.getBean("AutoAddress");
		System.out.println(s5.toString());
		
		//AutoWrired byName --> name must match in getBean.
		Student s4 = (Student) context.getBean("AutoWS4");
		System.out.println(s4.toString());
		
		
	}
}
