package com.demo;

import org.apache.ibatis.annotations.Mapper;
import com.demo.Book;
import java.util.List;

@Mapper
public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBooks();
}
