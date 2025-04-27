package myspring.di.xml;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Assertions에 포함 된 모든 static method를 import 한다. 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class HelloJunitTest {
	ApplicationContext context ;
	
	@BeforeEach
	void container() {
		//1. Container 객체 생성
		context = new GenericXmlApplicationContext("classpath:hello-di.xml");
	}
	
	@Test
	public void helloBean() {	//public 안써도 됨
		//1. Container 객체 생성
		/* Window/Show View/Other.../Navigator 탭을 키면 여기에
		 * target에 classes, test-classes 폴더가 생기는데 하위 파일에 내가 만든 객체(bean)들이 있다.  
		 */
		/*
		 * @BeforeEach 어노테이션 위에서 ApplicationContext context 인스턴스가 만들어지고 
		 * @BeforeEach 어노테이션이 붙은 void container() 안에서 context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		 * ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		 */
		
		//2. Container 객체가 생성한 Spring Bean을 요청하기
		// Hello helloById = context.hello; // context는 객체(bean)들을 저장하고 있는 컨테이너일 뿐 hello라는 필드가 존재하지 않아서 에러남
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		/*
		 * 여기서 Singleton Pattern인지 확인하기 bean의 scope="singleton"(Default)
		 * singleton 패턴이란: bean으로 만든 객체들은 모두 같은 인스턴스로 침
		 * "hello"라는  id의 bean은 singleton 스코프로 선언해서 "hello" 빈을 사용한 인스턴스는 모두 같음
		 * 다르게 설정하려면 scope를  "prototype"으로 설정해야 됨
		 */
		/* Spring Bean의 주소 비교 // 문자열 비교가 아니고, 객체의 "주소"(즉, 메모리 위치) 가 같은지를 비교 두개 다 같은 말
		 * == 는 자바에서 객체 주소를 비교하는 기본 연산자이고
		 * assertSame은 JUnit의 검증 메서드로 객체가 같은 주소를 가리키는지 체크하는 메서드임
		*/
		System.out.println(helloById == helloByType);
		assertSame(helloById, helloByType);
		
		assertEquals("Hello 스프링", helloById.sayHello());
		
		//// 이거로 helloById와 helloByType은 singleton 객체라 하나의 인스턴스에서 print()로 buffer에 넣어도 둘 다 적용됨
		helloById.print();
		
		// Container 객체가 생성한 StringPrinter 스프링빈 요청하기
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());

		/*
		System.out.println();
		System.out.println();
//		System.out.println(helloByType.name);
		*/
		System.out.println();
		System.out.println();		
		// helloByType.printer.toString 호출
		System.out.println(helloByType.printer);

		// "hello"라는  id의 bean은 singleton 스코프로 선언해서 인스턴스 이름은 달라도 같은 인스턴스라 쳐서 둘 다 같다고 나옴
		assertSame(helloById, helloByType);
		assertEquals(helloById, helloByType);
		
	} 
	
}
