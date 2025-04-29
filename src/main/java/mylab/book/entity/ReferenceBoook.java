package mylab.book.entity;

public class ReferenceBoook extends Publication{
	public String field; //분야
	// 5. 실용주의프로그래머 [참고서] 	분야:소프트웨어공학, 496쪽, 25000원, 출판일:2007-01-14
	
	public ReferenceBoook(String title, String field, int page, int price, String publishDate) {
		super(title, page, price, publishDate);
		this.field = field;
	}
	
	public String getField() {
		return this.field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
