package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private int id ;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private String author;
    @Column(columnDefinition = "date")
    private String dateOfWriting;

    public Blog() {
    }

    public Blog(int id, String title, String content, String author, String dateOfWriting) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }
}
