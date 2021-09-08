package com.spring.Model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {

		// Autowiring thru constructor:
		// the object arg of Address is picked byName, and the bean is created and
		// passed to Student.
		ApplicationContext con2 = new ClassPathXmlApplicationContext("bean.xml");
		Student s3 = (Student) con2.getBean("AutoWS5");
		System.out.println(s3.toString());

		ApplicationContext con = new ClassPathXmlApplicationContext("AutoWireBean.xml");
		/*
		 * Scope classes Singleton(default), prototype(N instances), request, session,
		 * global-session
		 */

		Student s1 = (Student) con.getBean("AutoAddress");
		s1.callObj();
		Student s2 = (Student) con.getBean("AutoAddress");

		// Same when used singleton and by default, when used prototype gives n
		// instances per call.
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}
}
