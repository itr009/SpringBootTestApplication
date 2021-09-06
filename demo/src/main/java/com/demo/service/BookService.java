package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.BookEntity;
import com.demo.repository.BookRepository;


 
@Service
public class BookService {
     
    @Autowired
    BookRepository repository;
     
    public List<BookEntity> getAllEmployees()
    {
        List<BookEntity> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<BookEntity>();
        }
    }
     
  
    public List<BookEntity> findByBookNameContains(String bookName) throws RecordNotFoundException
    {
    	List<BookEntity> book = repository.findByBookNameContains(bookName);
         
        if(book.size()>0) {
            return book;
        } else {
            throw new RecordNotFoundException("No Book record exist for given id");
        }
    }
     
     public BookEntity createOrUpdateBook(BookEntity entity) throws RecordNotFoundException
    {
        Optional<BookEntity> book = repository.findById(entity.getId());
        
         System.out.println("entity"+entity.getBookName());
        if(book.isPresent())
        {
        	BookEntity newEntity = book.get();
            newEntity.setBookPublisher(entity.getBookPublisher());
            newEntity.setBookAuthor(entity.getBookAuthor());
            newEntity.setBookName(entity.getBookName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
   
}