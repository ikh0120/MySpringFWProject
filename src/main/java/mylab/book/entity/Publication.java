package mylab.book.entity;

import java.util.Date;

public class Publication {
	private String title; //제목
	private String publishDate; //풀판일
	private int page; //페이지
	private int price; //가격
	
	public Publication() {}
	
	public Publication(String title, int page, int price, String publishDate) {
		this.title = title;
		this.page = page;
		this.price = price;
		this.publishDate = publishDate;
	}
	
	
	// Getter, Setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	@Override
	public String toString() {
		return title; 
	}
	
	
	
	
}
