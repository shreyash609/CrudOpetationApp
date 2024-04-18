package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Book;
import in.ashokit.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService=bookService;
	}

	@GetMapping("/firstpage")
	public ModelAndView firstPage() {

		ModelAndView mav=new ModelAndView();
		List<Book> retrieve = bookService.retrieve();

		mav.addObject("book",retrieve);
		mav.setViewName("index");

		return mav;
	}

	@GetMapping("/secondpage")
	public ModelAndView secondPage() {

		ModelAndView mav=new ModelAndView();

		mav.addObject("book",new Book());
		mav.setViewName("form");
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView saveData(Book book) {
 
		ModelAndView mav=new ModelAndView();
		boolean saveData = bookService.saveData(book);
		if(saveData) {
			mav.addObject("sucess","Data Inserted Successfully");
		}else {
			mav.addObject("NotSucess","Error");
		}

		mav.setViewName("form");

		return mav;
	}

	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId") Integer BookId) {

		bookService.deleteBook(BookId);

		ModelAndView mav=new ModelAndView();

		List<Book> retrieve = bookService.retrieve();
		mav.addObject("book",retrieve);
		mav.setViewName("index");

		return mav;
	}
	
	@GetMapping("/update")
	public ModelAndView update(@RequestParam("bookId") Integer bookId) {
		
		ModelAndView mav=new ModelAndView();
		Book book = bookService.getBookId(bookId);
		mav.addObject("book",book);
		mav.setViewName("form");
		return mav;
	}	
}
