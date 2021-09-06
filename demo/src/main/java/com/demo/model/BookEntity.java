package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_BOOKS")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="BOOK_NAME")
    private String bookName;
    
    @Column(name="BOOK_AUTHOR")
    private String bookAuthor;
    
    @Column(name="BOOK_PUBLISHER")
    private String bookPublisher;
    
    
    
    

    public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getBookName() {
		return bookName;
	}





	public void setBookName(String bookName) {
		this.bookName = bookName;
	}





	public String getBookAuthor() {
		return bookAuthor;
	}





	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}





	public String getBookPublisher() {
		return bookPublisher;
	}





	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}





	@Override
    public String toString() {
        return "BookEntity [id=" + id + ", bookName=" + bookName + 
                ", bookAuthor=" + bookAuthor + ", bookPublisher=" + bookPublisher   + "]";
    }
}