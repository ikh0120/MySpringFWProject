package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class, loader=AnnotationConfigContextLoader.class)
/** loader=AnnotationConfigContextLoader.class 이거는 JUnit5 이상부터는 안해도 상관없음 */
/* 
 * @ContextConfiguration(locations = "classpath:hello-di.xml")
 * 원래는 이렇게 locations 속성에 xml 경로를 줬는데 
 * 지금은 HelloBeanConfig.java에서 xml 설정파일을 대신해서 classes 속성에 줌
 */
/* 
 * BeanFactory <- ApplicationContext <- GenericXmlApplicationContext
 * BeanFactory: Spring IoC 컨테이너의 기본 인터페이스
 * ApplicationContext: BeanFactory를 상속한 더 확장된 인터페이스
 * GenericXmlApplicationContext: ApplicaitonContext의 구현체(xml 방식)
 */
/* 
 * 하지만
 * xml 설정파일을 사용하지 않아 GenericXmlApplicaitonContext를 쓰지 않음
 * xml이 아니기에 
 * AnnotationConfigApplicationContext: ApplicaitonContext의 구현체(Config 방식)를 사용함
 * BeanFactory <- ApplicationContext <- AnnotationConfigApplicaitonContext
 */
/**
 * GenericXmlApplicaitonContext: Xml 설정 처리할 때 사용
 * AnnotationConfigApplicaitonContext: Java 기반 설정 클래스를 처리할 때 사용
 */
// @Configuration을 사용하는 클래스를 만들 때 내부적으로 Class AnnotationConfigApplicationContext가 컨테이너 역할을 한다. 
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Test
	void helloBean() {
		assertEquals("Hello 어노테이션",hello.sayHello());
	}
	
}
