package in.ashokit.repo;

import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

}
