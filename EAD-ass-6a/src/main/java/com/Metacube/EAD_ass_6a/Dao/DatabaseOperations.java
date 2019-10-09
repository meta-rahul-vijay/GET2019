package com.Metacube.EAD_ass_6a.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Metacube.EAD_ass_6a.Models.Book;

public class DatabaseOperations {
	
	static JDBCConnection dataLayer = new JDBCConnection();
	
	static{
		dataLayer.setDriver();
		dataLayer.setConnection();	
	}
	
	public int addBook(Book insBook) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement insertStmt = con.prepareStatement("insert into book(book_id, title, writer, publisher, published_year) values(?,?,?,?,?)");
		insertStmt.setInt(1, insBook.getBookId());
		insertStmt.setString(2, insBook.getTitle());
		insertStmt.setString(3, insBook.getWriter());
		insertStmt.setString(4, insBook.getPublisher());
		insertStmt.setInt(5, insBook.getPublishedYear());
		
		int changes = 0;
		try{
			changes = insertStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		insertStmt.clearParameters();
		return changes;
	}

	public int deleteAllBooks() throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement deleteStmt = con.prepareStatement("delete from book");
		int changes = 0;
		try{
			changes = deleteStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		deleteStmt.clearParameters();
		return changes;
	}

	public int deleteBook(String title) throws SQLException {
		Connection con = dataLayer.getConnection();
		PreparedStatement deleteStmt = con.prepareStatement("delete from book where title = ?");
		deleteStmt.setString(1, title);
		int changes = 0;
		try{
			changes = deleteStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return changes;
	}
	
}
