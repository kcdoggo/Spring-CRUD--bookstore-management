package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;


public interface BookDao {

	/*book�� list�� �����Ұ���*/
	 List<Book> list();  

/*book�� �߰��ϴ� �޼ҵ�*/
	void add(Book item);  

/*book�� �����ϴ� �޼ҵ�, list.remove �̿� !! intŸ���� bookid ���;��� */
	void delete(int bookid); 

/* ������Ʈ �� book�� �������� �޼ҵ�, For loop �̿� intŸ���� bookid ���;���*/
	Book item(int bookid); 

/*book�� ������Ʈ �ϴ� �޼ҵ�. set �̿� */
	void update(Book item); 

	
	
}
