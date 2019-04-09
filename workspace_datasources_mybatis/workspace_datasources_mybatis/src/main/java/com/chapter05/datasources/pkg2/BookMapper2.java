package com.chapter05.datasources.pkg2;

import com.chapter05.datasources.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper2 {
    List<Book> getAllBooks2();
}

