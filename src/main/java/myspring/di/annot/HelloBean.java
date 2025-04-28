package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* 
 * <context:component-scan base-package="myspring.di.annot" /> 
 * 사용해서 @Component, @Controller, @Repository, @Service 를 사용하여 
 * Spring IoC 컨테이너에 빈으로 등록됨
 * 이 빈에서 @Resourse, @Value 등을 사용해서 의존성 주입이나 값을 주입받을 수 있음
 */
@Component("helloBean")
public class HelloBean {
	/* <context:property-placeholder location="classpath:values.properties" />
	 * 해당 설정으로 values.properties의 변수를 꺼내옴 
	 * ex: "#{'${names.list.of.strings}'.split(',')}" */
	@Value("${myName}")//myName="어노테이션"
	String name;//name="어노테이션"
	
	/* 이건 자동으로 빈을 주입하지만 "${myPrinter}"는 동적인 값으로 빈을 주입 못함
	 * 그리고 이 두개는 타입 기반으로 의존성을 주입함
 	 * @Autowired // 
 	 * @Qualifier("${myPrinter}") // 
	 */
	@Resource(name="${myPrinter}") //myPrinter='stringPrinter"
	PrinterBean printer; //printer=stringPrinter
	
	@Value("#{'${names.list.of.strings}'.split(',')}") 
	List<String> names; //names=["Java","Spring","Kotlin"]

	public HelloBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}

	public HelloBean(String name, PrinterBean printer) {
		System.out.println(this.getClass().getName() + " 오버로딩된 생성자 호출됨!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}
/*	setter 메서드는 @Component 등으로 만든 Spring IoC Container에 저장 된 bean에서
 *  @Value, @Resource 등으로 값을 주입해서 필요없음
  	public void setNames(List<String> list) {
		System.out.println("setNames() 메서드 호출됨");
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() 메서드 호출됨 " + name);
		this.name = name;
	}

	public void setPrinter(PrinterBean printer) {
		System.out.println("setPrinter() 메서드 호출됨 " + printer.getClass().getName());
		this.printer = printer;
	}

 */

	public String sayHello() {
		return "Hello " + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}

}
