package com.Metacube.EAD_ass_6a.Resource;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Metacube.EAD_ass_6a.Facade.BookService;
import com.Metacube.EAD_ass_6a.Models.Book;


/*
 * Face error in mapping 415 unsupported media type  (2-3 hrs) 
 *  (jackson create object of Book and then set values individually)
 */

@Path("inventory")
public class BookResource {
	
	static BookService bookService = new BookService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("addBook")
	public String addBook(Book book){
		boolean isAdded = bookService.addBook(book);
		if (isAdded)
			return "Book Added";
		else
			return "try again";
	}
	
	public void updateBook(){
		
	}
	
	
	public void updateAllBooks(){
		
	}
	
	@DELETE
	@Path("deleteBook/{title}")
	public String deleteBook(@PathParam("title") String title){
		System.out.println("title = "+title);
		boolean isDeleted = bookService.deleteBook(title);
		if(isDeleted){
			return "Book deleted successfully";
		}else{
			return "No book left";
		}
	}
	
	
	@POST
	@Path("deleteAllBooks")
	public String deleteAllBooks(){
		boolean isDeleted = bookService.deleteAllBooks();
		if(isDeleted){
			return "Books Deleted Successfully";
		}else{
			return "No books left";
		}
	}
}
