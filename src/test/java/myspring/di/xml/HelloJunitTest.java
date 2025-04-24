package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJunitTest {
	
	@Test
	public void helloBean() {	//public 안써도 됨
		//System.out.println("Hello Junit"); // 이렇게 sysout 안쓰고 Assertions 씀
		//1. Container 객체 생성
		ApplicationContext context = new GenericXmlApplicationContext("");
	}
	
}
