package myspring.di.xml.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired // Enviroment 인터페이스를 알아서 주입(Injection) 해줘
	private Environment env; 
	
	
	/* @Component와 @Bean 어노테이션 차이점
	 *  - 같은점: Spring Bean을 나타내는 어노테이션
	 *  - 차이점: @Component는 클래스 위에 선언하고 @Bean은 메소드 위에 선언한다
	 *  - 외부 라이브러리에서 제공하는 클래스를 SpringBean으로 설정하는 경우에는  @Bean 어노테이션을 사용한다
	 */
	/* @Bean 어노테이션에 대한 설명
	 * @Target(value={ANNOTATION_TYPE, METHOD}) // 다른 어노테이션 위나 메서드 위에 선언할 수 있다
	 * @Retention(value=RUNTIME) // Runtime
	 * 
	 * @Documented   
	 * //Indicates that a method produces a bean to be managed by the Spring container. 
 	 * 
	 * Overview
	 * 
	 * The names and semantics of the attributes to this annotation are intentionallysimilar to those of the <bean/> element in the Spring XML schema.
	 * //xml 파일의 bean 태그와 동일하다 
	 */
	/* 외부 라이브러리 클래스는 @Component, @Bean을 사용해서 코드를 수정할 수 있지만
	 * 다른사람이 만든거라 고쳐도 의미 없음
	 * 스프링 빈으로 만들려면 
	 * 메서드를 선언하고 고친 다음
	 * @Bean을 붙이면 빈으로 등록 가능
	 */
	@Bean	
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello(); // <alt> + <shift> l
		
		/* hello.setName("${myName}") == hello.setName("스프링") 
		 * values.properties에서 값이 변할 수 있는 "스프링"을 넣어줌
		 * 변동될 수 있는 값을 한 번에 바꿀 수 있도록 넣어주는 것
		 * env.getProperty("myname1") == "스프링" // env.getProperty는 값을 가져와 줌
		 */
		hello.setName(env.getProperty("myname1")); //myName1=스프링
		hello.setPrinter(stringPrinter());
		hello.setNames(namesList());
		return hello;
	}
	
	@Bean
	public List<String> namesList(){
		return Arrays.asList("Java","Spring","Kotlin"); // asList(T... a) 여기서 ...은 가변 인자라 몇개든지 인수가 들어갈 수 있음
	}
}
