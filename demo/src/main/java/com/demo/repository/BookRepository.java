package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.BookEntity;

 
@Repository
public interface BookRepository
        extends JpaRepository<BookEntity, Long> {
	
	List<BookEntity> findByBookNameContains(String bookName);
	
 
}
