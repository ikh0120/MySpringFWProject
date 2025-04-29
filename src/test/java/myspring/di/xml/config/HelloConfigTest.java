package myspring.di.xml.config;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloConfigTest {
	@Autowired
	List<String> nameList;
	
	@Autowired
	Hello hello;
	
	@Resource(name = "strPrinter")
	Printer printer;
	
	@Test
	void tesHelloConfig() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
		assertEquals("Java", hello.getNames().get(0));
	}
	
	@Test
	void testNameList() {
		// nameList 요소 뿌리기
		for (String name : nameList) {
			System.out.println(name);
		}
		
		
	}
	
}
