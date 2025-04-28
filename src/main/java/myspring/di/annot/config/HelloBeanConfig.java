package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 설정 역할을 하는 클래스임 // 그래서 xml 파일 대신 사용해서 xml 파일이 필요없음
//<context:component-scan base-package="myspring.di.annot" />
@ComponentScan(basePackages = {"myspring.di.annot"})
//<context:property-placeholder location="classpath:values.properties" />
@PropertySource(value = "classpath:values.properties")
public class HelloBeanConfig {
	
}
