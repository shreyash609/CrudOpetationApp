package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Book;

public interface BookService {

	public List<Book> retrieve();
	
	public boolean saveData(Book book);
	
	public void deleteBook(Integer bookId);
}
