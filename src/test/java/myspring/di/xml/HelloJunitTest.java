package myspring.di.xml;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Assertions에 포함 된 모든 static method를 import 한다. 
import static org.junit.jupiter.api.Assertions.*;

public class HelloJunitTest {
	
	@Test
	public void helloBean() {	//public 안써도 됨
		//System.out.println("Hello Junit"); // 이렇게 sysout 안쓰고 Assertions 씀
		//1. Container 객체 생성
		// 컨테이너를 만들어서 위치를 알려주니까 이런 출력이 나옴
		ApplicationContext context = new GenericXmlApplicationContext("classpath:hello-di.xml");
		// xml 경로가 다르거나 bean의 property의 name이 다르면 못찾아서 오류 출력됨
		// property의 name이 다르면 오류 출력으로 정확하게 나옴
		// xml 은 너무 민감해서 힘들음 그래서 어노테이션 사용함
		
		//2. Container 객체가 생성한 Spring Bean을 요청하기
		// hello-di.xml의 bean의 id값을 인자값으로 정확히 넣어야 됨
		// id로 bean을 얻어옴
		Hello helloById = (Hello)context.getBean("hello");
		Hello helloByType = context.getBean("hello", Hello.class);
		
		// 여기서 Singleton Pattern인지 확인하기 bean의 scope="singleton"(Default)
		// Spring Bean의 주소 비교
		System.out.println(helloById == helloByType);// 주소 비교
		// 같은 객체를 반환해준다

		// import static org.junit.jupiter.api.Assertions.*; 이거 추가해서 밑에 주석처리
		// Assertions.assertSame(helloById, helloByType); // 주소가 같으면 JUnit의 TestCase 초록불(성공)
		assertSame(helloById, helloByType); // 그래서 이거도 가능
		
		
		
	} 
	
}
