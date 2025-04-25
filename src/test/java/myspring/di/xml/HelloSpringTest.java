package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

// SpringExtension 클래스는 ApplicationContext(컨테이너) 객체를 생성하는 역할을 함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml") // 스프링 객체(bean) 설정 파일의 위치를 지정할 때 사용하는 어노테이션
public class HelloSpringTest {
	@Autowired
	Hello hello;
	
	@Test
	void helloSpringBean() {
		
	}
	
}
