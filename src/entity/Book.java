package entity;

public class Book {
	
	private int bookId;
	private String title;
	private String author;
	private String description;
	private String category;
	
	
	
	//constructor
	public Book(int bookId, String title, String author, String description, String category) {
		this.setBookId(bookId);
		this.setTitle(title);
		this.setAuthor(author);
		this.setDescription(description);
		this.setCategory(category);
		
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}





}
