package mylab.book.entity;

public class Novel extends Publication{
	String author; // 저자
	String genre; // 장르
	
	public Novel(String title, String author, String genre, int page, int price, String publishDate) {
		super(title, page, price, publishDate);
		this.author = author;
		this.genre = genre;
	}
	
	/*
	 * 3. 빠삐용 [소설] 저자:베르나르베르베르, 	장르:현대소설, 396쪽, 9800원, 출판일:2007-07-01
	 * 4. 남한산성 [소설] 저자:김훈, 			장르:대하소설, 383쪽, 11000원, 출판일:2007-04-14
	 * 6. 소년이온다 [소설] 저자:한강, 			장르:장편소설, 216쪽, 15000원, 출판일:2014-05-01
	 * 7. 작별하지않는다 [소설] 저자:한강, 		장르:장편소설, 332쪽, 15120원, 출판일:2021-09-09
	 */
	
	
	//Getter, Setter
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return null;
	}
}
