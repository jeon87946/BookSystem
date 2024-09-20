package com.example.demo.jpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.vo.Book;

@SpringBootTest
public class SelectTest {
	
	@Autowired //인터페이스 상속 -
	JpaBookRepository jpaBook;
	
	@Test
	void Select() {
		List<Book> allBook = jpaBook.findAll();
		System.out.println("JpaBookRepository: allbook()=" + allBook);
		
		Optional<Book> book = jpaBook.findById("9");
		
		System.out.print("JpaBoookRepository:findById()=" + "book");
	}
}
