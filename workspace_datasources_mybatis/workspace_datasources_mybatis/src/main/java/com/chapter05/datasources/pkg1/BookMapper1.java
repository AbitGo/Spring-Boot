package com.chapter05.datasources.pkg1;

import com.chapter05.datasources.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookMapper1 {
    List<Book> getAllBooks1();
}

