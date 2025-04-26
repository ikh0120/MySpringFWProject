package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

// SpringExtension 클래스는 ApplicationContext(컨테이너) 객체를 생성하는 역할을 함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml") // 스프링 객체(bean) 설정 파일의 위치를 지정할 때 사용하는 어노테이션
public class HelloSpringTest {
	@Autowired // context.getBean("hello", Hello.class); 이거처럼 매핑해줌
	Hello hello;
	
	// 여긴 설명 주석 넣느라 못들음 찾아봐야 됨
	/*
	 * @Autowired
	 * Printer printer;
	 * 이런 오류 생김 오류 뜨면 <Ctrl>+f 눌러서 Caused by 검색 ㄱㄱ
	 * Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'myspring.di.xml.Printer' available: expected single matching bean but found 2: strPrinter,conPrinter
	 * 왜냐? 
	 * hello-di.xml에는 id가 printer인 빈이 없어 strPrinter로 맞춰줌
	 */
	@Autowired
	Printer strPrinter;
	
	@Autowired
	@Qualifier("strPrinter") // Autowired 어노테이션 쓸 때 빈 id가 안같을 때 이렇게 지정해줘서 id가 "strPrinter"인 bean 가져오기
	Printer printer;
	
	@Resource(name = "hello") // bean의 id값을 name에 넣어줌 이건 @Autowired, @Qualifier("hello")와 같은 javax.annotation.Resource
	Hello helloBean;
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		/* 여긴 설명 주석 넣느라 못들음 찾아봐야 됨*/
		hello.print();
		
		assertEquals("Hello 스프링", strPrinter.toString());
		/*
		 * System.out.println(strPrinter); //Hello 스프링
		 * System.out.println(strPrinter.toString()); //Hello 스프링
		 * System.out.println(strPrinter.getClass()); // class myspring.di.xml.StringPrinter
		 * System.out.println(strPrinter.getClass().getName()); // myspring.di.xml.StringPrinter
		 */
		/* assertEquals("Hello 스프링", printer); 
		 * // 이거는 System.out.println() 안에서 인스턴스 객체를 넣었을 때 toString()이 자동으로 붙는게 아니라서 JUnitTest 통과 못함*/
		assertEquals("Hello 스프링", printer.toString());
		
		// 1. sayHello()반환값은 "Hello 스프링"이라 반환되는 문자열 값이 같아서 true 
		// 2. "hello" bean 객체가 singleton Pattern이라 "hello"bean을 사용하면 모두 같은 인스턴스임
		assertEquals("Hello 스프링", helloBean.sayHello());

	}
	
}
