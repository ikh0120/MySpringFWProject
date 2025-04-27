package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloBeanSpringTest {
	@Autowired
	@Qualifier("helloBean")
	HelloBean hello; // 우선 HelloBean이라는 id의 빈을 찾음 없으면 HelloBean에서 만든 helloBean이라는 id의 빈을 @Component("helloBean")을 이용해서 만듬
	
	@Resource(name="${myPrinter}")
	PrinterBean printer;
	
	@Test
	void helloBean() {
//		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		
//		assertEquals("Hello 어노테이션", printer.toString());
		
		for(String name: hello.getNames()) {
			System.out.println(name);
		}
		System.out.println();
		System.out.println("hello.name=" + hello.name);
		System.out.println();
		System.out.println("Expected: " + "|Hello 어노테이션|");
		System.out.println("Actual: " + "|"+hello.sayHello()+"|");
		assertEquals("Hello 어노테이션".trim(), hello.sayHello().trim());
		
	}
}