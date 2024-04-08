package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Book;
import in.ashokit.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService{

	private BookRepo bookRepo;
	
	public BookServiceImpl( BookRepo bookRepo) {
		 this.bookRepo=bookRepo;
	}
	
	@Override
	public List<Book> retrieve() {
		return (List<Book>) bookRepo.findAll();
	}

	@Override
	public boolean saveData(Book book) {
		return bookRepo.save(book) != null;
	}

	@Override
	public void deleteBook(Integer bookId) {
		bookRepo.deleteById(bookId);
	}
}
