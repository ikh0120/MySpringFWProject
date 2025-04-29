package mylab.book.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	// 1) 생성자
	private List<Publication> items = new ArrayList<Publication>(); //장바구니
	
	// 2) 장바구니 조작 메서드
	public void addItem(Publication newBook) {
		items.add(newBook);
	}

	public List<Novel> LN = new ArrayList<Novel>();
	public List<Magazine> LM = new ArrayList<Magazine>();
	public List<ReferenceBoook> LR = new ArrayList<ReferenceBoook>();
	
	public boolean removeItem(String title) {
		for (Publication p : items) {
			if(p.getTitle()==title) {
				items.remove(p);
				return true;
			}	
		}
		return false;
	}

	public void displayCart() {
		for (Publication p : items) {
			if(p instanceof Novel) {
				Novel n = (Novel)p;
				LN.add(n);
			}
			if(p instanceof Magazine) {
				Magazine m = (Magazine)p;
				LM.add(m);
			}
			if(p instanceof ReferenceBoook) {
				ReferenceBoook r = (ReferenceBoook)p;
				LR.add(r);
			}
		}
		for(Publication p : LN) {
			items.add(p);
		}
		for(Publication p : LM) {
			items.add(p);
		}
		for(Publication p : LR) {
			items.add(p);
		}
		int num=0;		
		for(Publication pp : items) {
			num+=1;
			if(pp instanceof Novel) {
				Novel p = (Novel)pp;
				System.out.println(num+". "+p.getTitle() + " [소설] 저자:" + p.getAuthor() +", 장르:"+ p.getGenre()+", "+ p.getPage() +"쪽, "+p.getPrice() + "원, "+"출판일: "+p.getPublishDate());
			}
			if(pp instanceof Magazine) {
				Magazine p = (Magazine)pp;
				System.out.println(num+". "+p.getTitle() +"[잡지] 발행주기:"+p.getPublishPeriod()+", "+p.getPage()+"쪽, "+p.getPrice() + "원, 출판일:"+p.getPublishDate());
			}
			if(pp instanceof ReferenceBoook) {
				ReferenceBoook p = (ReferenceBoook)pp;
				System.out.println(num+". "+p.getTitle()+"[참고서] 분야:"+p.getField()+", "+ p.getPage()+"쪽, "+p.getPrice()+"원, 출판일:"+p.getPublishDate());
			}
		}
	}
	// 3) 가격 계산 메서드
	int aPrice=0;
	public int calculateTotalPrice() {
		for (Publication p : items) {
			aPrice+=p.getPrice();
		}
		return aPrice;
	}
	
	double dPrice=0;
	public double calculateDiscountedPrice() {
		for (Publication p : items) {
			if(p instanceof Magazine) {
				dPrice+=p.getPrice()*0.9;
			}
			if(p instanceof Novel) {
				dPrice+=p.getPrice()*0.85;
			}
			if(p instanceof ReferenceBoook) {
				dPrice+=p.getPrice()*0.8;
			}
			else {
				dPrice+=p.getPrice();
			}
		}
		return dPrice;
	}
//	4) 통계메서드
	public void printStatistics() {
		int m=0;
		int n=0;
		int r=0;
		int x=0;
		for (Publication p : items) {
			if(p instanceof Magazine) m+=1;
			if(p instanceof Novel) n+=1;
			if(p instanceof ReferenceBoook) r+=1;
			else x+=1;
		}
		System.out.println("Magazine: "+m);
		System.out.println("Novel: "+n);
		System.out.println("ReferenceBook: "+r);
		System.out.println("Other: " +x);		
	}
	
	//5) 메인메서드
	public static void main(String[] args) {
		// ShoppingCart 인스턴스 생성
		ShoppingCart sc = new ShoppingCart();

		// 출판물 생성
		Novel b1 = new Novel("빠삐용","베르나르베르베르","현대소설",396,9800,"2007-07-01");
		Magazine b2 = new Magazine("마이크로소프트", "매월", 328, 9900, "2000-10-01");
		Novel b3 = new Novel("어린왕자", "생택쥐페리", "고전소설", 204, 23200, "1892-02-16");
		Novel b4 = new Novel("백과사전", "김용호", "백과사전", 1124, 102800, "2011-03-22");
		ReferenceBoook b5 = new ReferenceBoook("쎈 수학", "자습서", 225, 18200, "2020-12-02");
		Magazine b6 = new Magazine("옷 잘입기", "매주", 28, 3900, "2013-10-01");
		Magazine b7 = new Magazine("돈 많이 버는 법", "매일", 102, 19900, "2025-04-30");
		ReferenceBoook b8 = new ReferenceBoook("태어난날", "경축일", 120, 99990000, "2000-01-20");
		
		//출판물 추가
		sc.addItem(b1);
		sc.addItem(b2);
		sc.addItem(b3);
		sc.addItem(b4);
		sc.addItem(b5);
		sc.addItem(b6);
		sc.addItem(b7);
		sc.addItem(b8);
		
		//장바구니 내용 출력
		sc.displayCart();
		//장바구니 통계 출력
		sc.printStatistics();
		
		boolean removed = sc.removeItem("빠삐용");
		System.out.println("빠삐용 삭제결과: "+removed);
//		sc.displayCart();
		
		
		
		
	}
}
