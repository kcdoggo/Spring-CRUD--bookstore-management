package kr.ac.kopo.bookstore.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookstore.model.Book;

@Repository("BookDaoImpl")
public class BookDaoImpl implements BookDao {
	List<Book> list;

	/*생성자 만듦. list가 없다면, 거기에 list 인터페이스의  
	imple인 ArrayList를 book타입으로 만들어줘라.*/
	
	/*이 생성자를 이용하여 객체를 만들텐때 이걸 사용하는 건 "스프링"이 
	 * 스캔을 해서 객체생성함.*/
	public BookDaoImpl() {
		if(list == null)
			list = new ArrayList<Book>();
		
		//Book 객체 만들기, 만들어서 set메소드 이용해 값정하기.
		Book item = new Book();
		item.setBookid(1);
		item.setBookname("스프링");
		item.setPublisher("폴리텍");
		item.setPrice(1000);
		
		list.add(item);
	}
	
// book 정보가 담긴 list를 리턴해주는 메소드
	@Override
	public List<Book> list() {

		return list;
	}

	@Override
	public void add(Book item) {

		
	  list.add(item);   /*Book 타입의 list에 add 로 값 넣어주기 */
	}

	@Override
	public void delete(int bookid) {

		
		for(Book item:list)
			//가져온 북 아이디가 맞다면 삭제하겠다
			if(item.getBookid() == bookid) {
				list.remove(item); // 객체를 삭제해야 하기때문에 item이고 bookid 안됨.!!
				
				return; //삭제하고 즉시 리턴해야 for안돌고 문제 안생김.
			}
	}

	@Override   /*업데이트 할 책 불러오는 거임*/
	public Book item(int bookid) {
		for(Book item : list)
			if(item.getBookid() == bookid) {
				return item; // 찾는 bookid가 list에 진짜 있다면, 그 객체를 리턴해라.
			
			 //혹시라도 책 못찾으면 null 리턴하도록.
			}
		return null;
	
	}

	@Override
	public void update(Book item) {
		
		for(Book book : list) {
			if(book.getBookid() == item.getBookid()) { 
			/*변경하고픈 객체의 id가 저 list에 있다면
그 리스트의 객체를 set으로 변경하시오. */
				
				//update할때 값 변경해주기.  list를 이용하기엔 너무 불편해서 , set으로 
				book.setBookid(item.getBookid());
				book.setBookname(item.getBookname());
				book.setPublisher(item.getPublisher());
				book.setPrice(item.getPrice());
			}
		}
	}
}
