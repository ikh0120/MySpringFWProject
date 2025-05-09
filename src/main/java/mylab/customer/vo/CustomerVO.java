package mylab.customer.vo;

import java.util.Date;

//DB 테이블과 1대1 매핑되는 데이터 객체
//테이블의 각 행(row, 가로)이 VO 객체 하나로 변환됨
public class CustomerVO{
	private int id;
	private String email;
	private String name;
	private int age;
	private Date entry_date;
	
	public CustomerVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerVO(String email, String name, int age) {
		this.email = email;
		this.name=name;
		this.age=age;
	}
	
	// Getter, Setter 메서드 추가
	public void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	
	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return this.email; }
	
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	
	public void setAge(int age) { this.age = age; }
	public int getAge() { return this.age; }
	
	public void setEntry_date(Date date) { this.entry_date = date; }
	public Date getEntry_date() { return this.entry_date; }
	
	
	
	
	
	
}