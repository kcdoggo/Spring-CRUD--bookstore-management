package kr.ac.kopo.bookstore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookstore.dao.BookDao;
import kr.ac.kopo.bookstore.model.Book;

@Service
public class BookServiceImple implements BookService {

	@Qualifier("BookDaoOracle")
	@Autowired
	BookDao dao; // interface 만들기. 패키지는 kr.ac.kopo.bookstore.dao 주기.
		
	@Override  
	public List<Book> list() {

	/* bookdao 에 있는 list() 는 set으로 북 정보를 저장한 
		 list를 ** return list 해주는 메소드임 */
		return dao.list();

	}

	@Override
	public void add(Book item) {
		
		dao.add(item);
	}

	@Override
	public void delete(int bookid) {

		
		dao.delete(bookid);
	}

	@Override
	public Book item(int bookid) {

		//dao한테도 item이라는 이름으로 요청.
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) {
		
		 dao.update(item);
		
	}
}
