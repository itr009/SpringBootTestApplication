package com.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.BookEntity;
import com.demo.service.BookService;

 
@RestController
@RequestMapping("/books")
public class BookController
{
    @Autowired
    BookService service;
 
    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<BookEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
     @GetMapping("/{bookName}")
    public List<BookEntity> findByBookNameContains(@PathVariable("bookName") String bookName)
                                                    throws RecordNotFoundException {
    	 List<BookEntity> entity = service.findByBookNameContains(bookName);
 
        return entity;
    }
 
      @PostMapping
    public ResponseEntity<BookEntity> createOrUpdateBook(@RequestBody BookEntity book)
                                                    throws RecordNotFoundException {
    	  System.out.println("entity"+book.getBookName());
    	BookEntity updated = service.createOrUpdateBook(book);
        return new ResponseEntity<BookEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
   
 
}