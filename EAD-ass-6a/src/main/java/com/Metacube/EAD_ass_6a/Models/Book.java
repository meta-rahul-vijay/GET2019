package com.Metacube.EAD_ass_6a.Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private int bookId;
	private String title;
	private String writer;
	private String publisher;
	private int publishedYear;
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", writer="
				+ writer + ", publisher=" + publisher + ", publishedYear="
				+ publishedYear + "]";
	}
	
}
