package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;


public interface BookDao {

	/*book을 list에 저장할거임*/
	 List<Book> list();  

/*book을 추가하는 메소드*/
	void add(Book item);  

/*book을 삭제하는 메소드, list.remove 이용 !! int타입의 bookid 얻어와야해 */
	void delete(int bookid); 

/* 업데이트 할 book을 꺼내오는 메소드, For loop 이용 int타입의 bookid 얻어와야해*/
	Book item(int bookid); 

/*book을 업데이트 하는 메소드. set 이용 */
	void update(Book item); 

	
	
}
