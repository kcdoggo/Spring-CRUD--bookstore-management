package kr.ac.kopo.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookstore.model.Book;
import kr.ac.kopo.bookstore.service.BookService;


@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired // �ʵ� ������ 
	BookService service; /*BookService interface ����
	(��Ű������ kr.ac.kopo.bookstore.service)*/
	
	
/*list�� ����, book ��ü�� �� �÷��������ӿ�ũ�� list�� �����س���. 
�׷��� list ����ؼ� ����*/
	@RequestMapping("/list") //model �з����Ϳ� ����
	public String list(Model model){
		
		//book Ŭ���� ����µ� ��Ű���� kr.ac.kopo.bookstore.model�� �ֱ�.
		List<Book> list = service.list(); /* BookService �������̽��� �ʵ��� 
		service�� list �޼ҵ尡 �־���ϴ� interfaceŬ���� ���� �޼ҵ常���.*/ 
		
		//�𵨿� �� �־��ֱ�
		model.addAttribute("list",list);
		
		return "list";
	}	
	
	//�ּҰ� add�̰�, �޼ҵ尡 GET�� ��쿡�� ó���ϰڴ� ��� �ǹ�.
	// GET �� ���������� �����͸� �����ڴٴ� �Ű�  POST�� ������ ��������������Ʈ��.
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
	
		return "add";
	}
	
	//�ּҰ� add�̰�, �޼ҵ尡 POST�� ��쿡�� ó���ϰڴ� ��� �ǹ�, ������ ������Ʈ
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Book item) { 

	/*Book ��ü�� �ʿ��� �Ŷ�� �������� �ϰ�
	 å ��ü �ϳ� �����. å ��ü�� �ʵ带 Ȯ��, request.getparameter(bookid) �Ѵ���.
   setbookid�ؼ� �� �������.*/
	
		//���� �� ����ҿ� ���, BookService 
		service.add(item);
		
		//redirect �� list �� �ּҷ� ��û..
	/* ��Ʈ�ѷ����� Ŭ���̾�Ʈ�� ��û�� ó���� ��(add�� ����),
		  �ٸ� �������� redirect �ϰ��� ���*/
		return "redirect:list";
	}

			/* jsp �������� achor �ּҷ� ���� bookid�� ����������.
	<td><a href="delete?bookid=${item.bookid}">����</a>  
delete ������ ���� ����, �з������� bookid�� �ٷ� ���� item.bookid jstl�� ����� �� �־��ٰŴ�.  */

	@RequestMapping("/delete")
	public String delete(int bookid) {
		
		service.delete(bookid);
		return "redirect:list";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(int bookid, Model model) { //�Ͼ��̵� �޾ƿ� int bookid
		//������ �� ��ü�� ����. dao���� for �� �̿��� �� ��ü�� �ִ°� �װԸ����� �˻��ϰ�  ����.
		Book item = service.item(bookid);
		
		//jsp�� �Ѱ��ַ���, �з����Ϳ� �� �־����, jsp������ jstl�� ${} �̷��� �о�ðŴ�.
		model.addAttribute("item",item); 
		
		return "update";
	}
	//������Ʈ �� �� ó��
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Book item) {
		
		service.update(item);
		return "redirect:list";
	}
}
