package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.vo.Book;

@Repository
public interface JpaBookRepository extends JpaRepository<Book, String> {
	public List<Book> findByBookid(String bookid);
	
	@Query(value ="select * from book order by bookid desc", nativeQuery = true)
	public List<Book> selectAllBookSortBookid();

}
