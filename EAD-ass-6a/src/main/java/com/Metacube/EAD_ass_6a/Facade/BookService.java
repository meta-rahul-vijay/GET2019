package com.Metacube.EAD_ass_6a.Facade;

import java.sql.SQLException;

import com.Metacube.EAD_ass_6a.Dao.DatabaseOperations;
import com.Metacube.EAD_ass_6a.Models.Book;

public class BookService {
	
	static DatabaseOperations dbo = new DatabaseOperations();
	public boolean addBook(Book book) {
		int changes = 0;
		try {
			changes = dbo.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(changes == 1){
			return true;
		}
		return false;
	}
	public boolean deleteAllBooks() {
		int changes = 0;
		try{
			changes = dbo.deleteAllBooks();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(changes > 0){
			return true;
		}
		return false;
	}
	public boolean deleteBook(String title) {
		int changes = 0;
		try{
			changes = dbo.deleteBook(title);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(changes > 0){
			return true;
		}
		return false;
	}

}
