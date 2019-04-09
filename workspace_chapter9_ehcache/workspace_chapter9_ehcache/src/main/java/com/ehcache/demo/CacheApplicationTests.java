package com.ehcache.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {
    @Autowired
    BookDao bookDao;
    @Test
    public void contextLoads(){
        bookDao.getBookById(1);
        bookDao.getBookById(1);
        bookDao.deleteBookById(1);

        Book book3 = bookDao.getBookById(1);
        System.out.println("Book3:"+book3);
        Book book_new = new Book();
        book_new.setName("1111");
        book_new.setAuthor("2222");
        book_new.setId(1);

        bookDao.updateBookById(book_new);

        Book book4 = bookDao.getBookById(1);
        System.out.println("Book4:"+book4);
    }
}
