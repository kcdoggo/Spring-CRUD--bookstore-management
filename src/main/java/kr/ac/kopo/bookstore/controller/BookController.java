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
	@Autowired // 필드 인젝션 
	BookService service; /*BookService interface 생성
	(패키지명은 kr.ac.kopo.bookstore.service)*/
	
	
/*list의 목적, book 객체를 다 컬렉션프레임워크인 list에 저장해놨음. 
그래서 list 출력해서 볼거*/
	@RequestMapping("/list") //model 패러미터에 삽입
	public String list(Model model){
		
		//book 클래스 만드는데 패키지를 kr.ac.kopo.bookstore.model로 주기.
		List<Book> list = service.list(); /* BookService 인터페이스의 필드인 
		service에 list 메소드가 있어야하니 interface클래스 가서 메소드만들기.*/ 
		
		//모델에 값 넣어주기
		model.addAttribute("list",list);
		
		return "list";
	}	
	
	//주소가 add이고, 메소드가 GET일 경우에만 처리하겠다 라는 의미.
	// GET 은 서버측에서 데이터를 빼오겠다는 거고  POST가 데이터 수정삭제업데이트임.
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
	
		return "add";
	}
	
	//주소가 add이고, 메소드가 POST일 경우에만 처리하겠다 라는 의미, 데이터 업데이트
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Book item) { 

	/*Book 객체가 필요한 거라고 스프링이 일고
	 책 객체 하나 만들것. 책 객체의 필드를 확인, request.getparameter(bookid) 한다음.
   setbookid해서 값 집어넣음.*/
	
		//얻어온 걸 저장소에 등록, BookService 
		service.add(item);
		
		//redirect 는 list 저 주소로 요청..
	/* 컨트롤러에서 클라이언트의 요청을 처리한 후(add를 한후),
		  다른 페이지로 redirect 하고픈 경우*/
		return "redirect:list";
	}

			/* jsp 페이지의 achor 주소로 여기 bookid가 보내질거임.
	<td><a href="delete?bookid=${item.bookid}">삭제</a>  
delete 매핑한 데로 가고, 패러미터의 bookid는 바로 위에 item.bookid jstl로 출력한 걸 넣어줄거다.  */

	@RequestMapping("/delete")
	public String delete(int bookid) {
		
		service.delete(bookid);
		return "redirect:list";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(int bookid, Model model) { //북아이디 받아옴 int bookid
		//수정할 북 객체를 얻어옴. dao에서 for 문 이용해 이 객체에 있는게 그게맞은지 검사하고  얻어옴.
		Book item = service.item(bookid);
		
		//jsp에 넘겨주려면, 패러미터에 모델 넣어야지, jsp에서는 jstl로 ${} 이렇게 읽어올거다.
		model.addAttribute("item",item); 
		
		return "update";
	}
	//업데이트 한 후 처리
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Book item) {
		
		service.update(item);
		return "redirect:list";
	}
}
