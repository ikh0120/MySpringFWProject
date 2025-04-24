package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		// Hello h = new Hello(); //여기서 h가 바로 this에 해당하는 객체
		// this	//현재 객체(instance) 자체
		// this.getClass() 	//현재 객체  h에 해당하는 클래스의 정보를 담은 Class 객체 반환
		// this.getClass().getName()  //클래스 이름을 패키지명.클래스명 형태로 반환
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}

	public Hello(String name, Printer printer) {
		System.out.println(this.getClass().getName() + " 오버로딩된 생성자 호출됨!");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		System.out.println("setNames() 메서드 호출됨");
		this.names = list;
	}

	public void setName(String name) {
		System.out.println("setName() 메서드 호출됨 " + name);
		this.name = name;
	}

	public void setPrinter(Printer printer) {
		System.out.println("setPrinter() 메서드 호출됨 " + printer.getClass().getName());
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
