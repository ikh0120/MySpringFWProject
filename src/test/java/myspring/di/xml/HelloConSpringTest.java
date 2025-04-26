package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/* @ExtendWith + @ContextConfiguration을 쓰면
 * ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml"); 코드 없이
 * 스프링 컨테이너를 자동으로 생성하고, hello-di.xml 파일을 읽어 Bean 등록까지 해준다.
 */
@ExtendWith(SpringExtension.class)// ApplicationContext context; 
@ContextConfiguration(locations = "classpath:hello-di.xml") //context = new GenericXmlApplicationContext("classpath:hello-di.xml");
public class HelloConSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;
	
	@Test
	void helloCons() {
		// System.out.println(hello.sayHello()); // "Hello 생성자" 출력
		assertEquals("Hello 생성자", hello.sayHello());
		hello.print(); // hello.name = "생성자"; // hello.printer = 컨테이너에 미리 만들어 둔 ConsolePrinter(); // hello.names = ["스프링프레임워크", "스프링부트", "스프링클라우드"];
	
		assertEquals(3, hello.getNames().size());
		
		assertEquals("스프링클라우드", hello.getNames().get(2));// 리스트 인덱스 2 반환
		
		// list 값 모두 출력하기
		// hello.getNames() ==> List<String> 타입
		for (String name : hello.getNames()) {
			System.out.println(name);
		}
		// Iterable 인터페이스의 forEach(Consumer) 메서드 호출하기
		// 람다식 함수형 인터페이스 아직 안함(안할듯)
		
		
	}
}
