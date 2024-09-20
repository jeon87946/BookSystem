package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.JpaBookRepository;
import com.example.demo.vo.Book;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookController {
	
	@Autowired
	JpaBookRepository jpaBook;
	
	//웹브라우저에서 입력(도서추가 창)
	@RequestMapping(value="/insertBookForm")
	public ModelAndView insertBook1() {
		
		
		ModelAndView mav = new ModelAndView();
		//html 페이지의 파일명 실행
		mav.setViewName("insertBook");
		
		return mav;
	}
	
	//도서 추가(실행)
	@RequestMapping(value="/insertBookControl")
	public ModelAndView insertBook2( Book book /* HttpServletRequest request */) {
		
//		String num = request.getParameter("bookid");
//		String name = request.getParameter("bookname");
//		String pub = request.getParameter("publisher");
//		String pri = request.getParameter("price");
//		
//		Book book = new Book();
//		book.setBookid(num);
//		book.setBookname(name);
//		book.setPublisher(pub);
//		book.setPrice(pri);
		
		jpaBook.save(book);
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("result", "도서 정보가 추가되었습니다.");
		
		mav.setViewName("insertBookResult");
		
		return mav;
	
	}
	
	//(도서 수정 실행)
	@RequestMapping(value="/updateBookControl")
	public ModelAndView updateBook2(Book book /* HttpServletRequest request */) {
		/*
		 * String num = request.getParameter("bookid"); String name =
		 * request.getParameter("bookname"); String pub =
		 * request.getParameter("publisher"); String pri =
		 * request.getParameter("price");
		 * 
		 * Book book = new Book(); book.setBookid(num); book.setBookname(name);
		 * book.setPublisher(pub); book.setPrice(pri);
		 */
	
		//데이터베이스에 저장
		jpaBook.save(book);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "도서 정보가 수정되었습니다.");
		mav.setViewName("updateBookResult");
		
		return mav;
		}
	
	@RequestMapping(value="updateBookForm")
	public ModelAndView updateBook1(HttpServletRequest request) {
		String bookid = request.getParameter("bookid");
		Book b = jpaBook.getById(bookid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", b);
		mav.setViewName("updateBook");
		
		return mav;
	}
	
	//전체 도서조회
	@RequestMapping(value="/" /*"selectAll"*/)
	public ModelAndView allBook1() {
		
//		List<Book> allList = jpaBook.findAll();
		List<Book> allList = jpaBook.selectAllBookSortBookid();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("allBook", allList);
		mav.setViewName("selectBookAll");
		return mav;
	}
	//도서 하나 조회
	@RequestMapping(value="selectBook")
	public ModelAndView viewBook1(HttpServletRequest request) {
		String bookid=request.getParameter("bookid");
		 Book b = jpaBook.getById(bookid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", b);
		mav.setViewName("selectBookOne");
		return mav;
	}
	
	
}
