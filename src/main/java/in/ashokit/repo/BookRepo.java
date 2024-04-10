package in.ashokit.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

//	select * from Book where activeSW=:status
	public List<Book> findByActiveSW(String status);
}
