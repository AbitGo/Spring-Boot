package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/bookOps1")
    public void bookOps1(){
        Book b1 = new Book();
        b1.setName("bbb");
        b1.setAuthor("bbb1");
        int i = bookService.addBook(b1);
        System.out.println("addBook>>>"+i);

        Book b2 = new Book();
        b2.setAuthor("ccc1");
        b2.setId(1);
        b2.setName("ccc");
        int updateBook = bookService.updateBook(b2);
        System.out.println("updateBook>>>"+updateBook);

        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById>>>"+b3);

        int delete= bookService.deleteBookById(1);
        System.out.println("deleteBookById>>>"+delete);

        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>"+allBooks);
    }
}
