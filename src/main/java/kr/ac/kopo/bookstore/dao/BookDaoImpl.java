package kr.ac.kopo.bookstore.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookstore.model.Book;

@Repository("BookDaoImpl")
public class BookDaoImpl implements BookDao {
	List<Book> list;

	/*������ ����. list�� ���ٸ�, �ű⿡ list �������̽���  
	imple�� ArrayList�� bookŸ������ ��������.*/
	
	/*�� �����ڸ� �̿��Ͽ� ��ü�� �����ٶ� �̰� ����ϴ� �� "������"�� 
	 * ��ĵ�� �ؼ� ��ü������.*/
	public BookDaoImpl() {
		if(list == null)
			list = new ArrayList<Book>();
		
		//Book ��ü �����, ���� set�޼ҵ� �̿��� �����ϱ�.
		Book item = new Book();
		item.setBookid(1);
		item.setBookname("������");
		item.setPublisher("������");
		item.setPrice(1000);
		
		list.add(item);
	}
	
// book ������ ��� list�� �������ִ� �޼ҵ�
	@Override
	public List<Book> list() {

		return list;
	}

	@Override
	public void add(Book item) {

		
	  list.add(item);   /*Book Ÿ���� list�� add �� �� �־��ֱ� */
	}

	@Override
	public void delete(int bookid) {

		
		for(Book item:list)
			//������ �� ���̵� �´ٸ� �����ϰڴ�
			if(item.getBookid() == bookid) {
				list.remove(item); // ��ü�� �����ؾ� �ϱ⶧���� item�̰� bookid �ȵ�.!!
				
				return; //�����ϰ� ��� �����ؾ� for�ȵ��� ���� �Ȼ���.
			}
	}

	@Override   /*������Ʈ �� å �ҷ����� ����*/
	public Book item(int bookid) {
		for(Book item : list)
			if(item.getBookid() == bookid) {
				return item; // ã�� bookid�� list�� ��¥ �ִٸ�, �� ��ü�� �����ض�.
			
			 //Ȥ�ö� å ��ã���� null �����ϵ���.
			}
		return null;
	
	}

	@Override
	public void update(Book item) {
		
		for(Book book : list) {
			if(book.getBookid() == item.getBookid()) { 
			/*�����ϰ��� ��ü�� id�� �� list�� �ִٸ�
�� ����Ʈ�� ��ü�� set���� �����Ͻÿ�. */
				
				//update�Ҷ� �� �������ֱ�.  list�� �̿��ϱ⿣ �ʹ� �����ؼ� , set���� 
				book.setBookid(item.getBookid());
				book.setBookname(item.getBookname());
				book.setPublisher(item.getPublisher());
				book.setPrice(item.getPrice());
			}
		}
	}
}
