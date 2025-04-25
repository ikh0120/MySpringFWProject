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
		//System.out.println("Hello Junit"); // 이렇게 sysout 안쓰고 Assertions 씀
		//1. Container 객체 생성
		/*
		 * hello-di.xml 파일을 읽는다
		 * <bean> 태그들을 모두 읽어서, 각각을 Spring 컨테이너에 등록하고 인스턴스를 생성함
		 * <bean id="hello" 안에 <property>가 있으니까 setter 메서드를 이용해서 필드에 값을 주입함
		 */
		/*
		 * context에는 strPrinter, conPrinter, hello 3개의 객체가 들어가있음
		 */ 
		/* Window/Show View/Other.../Navigator 탭을 키면 여기에
		 * target에 classes, test-classes 폴더가 생기는데 하위 파일에 내가 만든 객체(bean)들이 있다.  
		 */
//		이거 @BeforeEach 어노테이션이 붙은 void container() 쪽으로
//		ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		
		
		//2. Container 객체가 생성한 Spring Bean을 요청하기
		// Hello helloById = context.hello; // context는 객체(bean)들을 저장하고 있는 컨테이너일 뿐 hello라는 필드가 존재하지 않아서 에러남
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		/*
		 * Hello helloByType = context.getBean("hello", Hello.class);는 
		 * 이 밑의 주석과 같음
		 * Hello helloByType = new Hello();
		 * helloByType.setName("스프링");
		 * helloByType.setPrinter(strPrinter); // strPrinter는 context.getBean("strPrinter", StringPrinter.class");로 가져온 객체(bean)임
		 */
		
		// 여기서 Singleton Pattern인지 확인하기 bean의 scope="singleton"(Default)
		// Spring Bean의 주소 비교
		System.out.println(helloById == helloByType);// 문자열 비교가 아니고, 객체의 "주소"(즉, 메모리 위치) 가 같은지를 비교
		// 같은 객체를 반환해준다

		// import static org.junit.jupiter.api.Assertions.*; 이거 추가해서 밑에 주석처리
		// Assertions.assertSame(helloById, helloByType); // 주소가 같으면 JUnit의 TestCase 초록불(성공)
		/*
		 * 객체의 주소값을 비교해서 같으면 True, 다르면 False 반환
		 * helloById == helloByType은 
		 * 	// 자바에서 객체 주소를 비교하는 기본 연산자이고
		 * Assertions.assertSame(helloById, helloByType)은
		 *	// JUnit의 검증 메서드로 객체가 같은 주소를 가리키는지 체크하는 것
		 */
		assertSame(helloById, helloByType);
		
		/*2025-04-25 시작*/
		//값을 비교하기 // <property name="name" value="스프링" /> 이 설정 테스트 한 것임
		/* 앞과 뒤의 인자가 같은지 비교해줌 틀리면 JUnit이 틀리면 빨갛게 나오고
		 * 들어간 파라미터가 같으면 초록불*/
		assertEquals("Hello 스프링", helloById.sayHello());
		
		/* 
		 * helloById에 print()가 잘 호출되었냐 보는거
		 * 이거 로직 재밌음 
		 */
		helloById.print();
		
		// Container 객체가 생성한 StringPrinter 스프링빈 요청하기
		/*둘다 됨*/ //<property name="printer" ref="strPrinter" /> 이 설정 테스트 한 것임
		// Printer printer = context.getBean("strPrinter", StringPrinter.class);
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
		
	} 
	
}
