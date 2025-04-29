package mylab.book.entity;

public class Magazine extends Publication{
	public String publishPeriod; //발행 주기
	
	 /*
	  * 1. 마이크로소프트 [잡지] 	발행주기:매월, 328쪽, 9900원, 출판일:2007-10-01
	  * 2. 경영과컴퓨터 [잡지]	 	발행주기:매월, 316쪽, 9000원, 출판일:2007-10-03
	  */
	public Magazine(String title, String publishPeriod, int page, int price, String publishDate) {
		super(title, page, price, publishDate);
		this.publishPeriod = publishPeriod;
	}

	
	//Getter, Setter
	public String getPublishPeriod() {
		return publishPeriod;
	}



	public void setPublishPeriod(String publishPeriod) {
		this.publishPeriod = publishPeriod;
	}



	@Override
	public String toString() {
		return null;
	}
}
