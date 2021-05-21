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
	BookDao dao; // interface �����. ��Ű���� kr.ac.kopo.bookstore.dao �ֱ�.
		
	@Override  
	public List<Book> list() {

	/* bookdao �� �ִ� list() �� set���� �� ������ ������ 
		 list�� ** return list ���ִ� �޼ҵ��� */
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

		//dao���׵� item�̶�� �̸����� ��û.
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) {
		
		 dao.update(item);
		
	}
}
