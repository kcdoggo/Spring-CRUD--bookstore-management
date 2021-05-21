package kr.ac.kopo.bookstore.service;
import java.util.List;

import kr.ac.kopo.bookstore.model.Book;

public interface BookService {

	List<Book> list();

	void add(Book item);  

	void delete(int bookid); 

	Book item(int bookid);   

	void update(Book item);
	
	
	
}
