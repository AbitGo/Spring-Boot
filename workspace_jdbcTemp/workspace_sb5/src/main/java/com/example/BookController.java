package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("bookOps")
    public void bookOps(){
        Book book1 = new Book();
        book1.setAuthor("aba3");
        book1.setName("aba");
        int i = bookService.addBook(book1);
        System.out.println("addBook>>>>>"+i);
        Book book2 = new Book();
        book1.setAuthor("ac1");
        book1.setName("ac");
        int updateBook = bookService.updateBook(book2);
        System.out.println("updateBook>>>>>"+updateBook);
        Book book3 = bookService.getBookById(1);
        System.out.println("getBookById>>>>>"+book3);
        int delete = bookService.deleteBookById(2);
        System.out.println("deleteBookById>>>>>"+delete);
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>>>"+allBooks);
    }
}
