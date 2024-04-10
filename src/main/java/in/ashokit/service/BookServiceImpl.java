package in.ashokit.service;

import java.util.List;
import java.util.Optional;

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
		return bookRepo.findByActiveSW("Y");
		
	}

	@Override
	public boolean saveData(Book book) {
		book.setActiveSW("Y");
		return bookRepo.save(book) != null;
	}

	@Override
	public void deleteBook(Integer bookId) {
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			Book book = findById.get();
			book.setActiveSW("N");
			bookRepo.save(book);
		}
		
	}

	@Override
	public Book getBookId(Integer BookId) {
		Optional<Book> findById = bookRepo.findById(BookId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
}







