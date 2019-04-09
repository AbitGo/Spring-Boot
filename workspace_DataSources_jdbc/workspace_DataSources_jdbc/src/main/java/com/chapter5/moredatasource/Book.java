package com.chapter5.moredatasource;

public class Book {
    private Integer id;
    private String name;
    private String author;

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
