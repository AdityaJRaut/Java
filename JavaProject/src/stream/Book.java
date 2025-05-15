package stream;

public class Book {

	private String bookName;
	private String authorName;
	private String Category;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, String authorName, String category) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		Category = category;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", authorName=" + authorName + ", Category=" + Category + "]";
	}
	
	
}
