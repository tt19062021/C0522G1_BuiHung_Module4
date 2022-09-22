package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBook;
    private String category;
    private int amount;
    private int sumBook;

    public Book() {
    }

    public Book(int id, String nameBook, String category, int amount) {
        this.id = id;
        this.nameBook = nameBook;
        this.category = category;
        this.amount = amount;
    }

    public Book(int id, String nameBook, String category, int amount, int sumBook) {
        this.id = id;
        this.nameBook = nameBook;
        this.category = category;
        this.amount = amount;
        this.sumBook = sumBook;
    }

    public int getSumBook() {
        return sumBook;
    }

    public void setSumBook(int sumBook) {
        this.sumBook = sumBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
