package com.example.bookcatalog.model;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

    @Column(nullable = false)
    private String bookTitle;

    @Column(nullable = false)
    private String bookAuthor;

    @Column(nullable = false)
    private String bookPublisher;

    @Column(nullable = false)
    private Integer publicYear;

    @Column(nullable = false)
    private String publicCountry;

    @Column(nullable = false)
    private Integer quantityPages;

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) { this.idBook = idBook; }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public Integer getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(Integer publicYear) {
        this.publicYear = publicYear;
    }

    public String getPublicCountry() {
        return publicCountry;
    }

    public void setPublicCountry(String publicCountry) {
        this.publicCountry = publicCountry;
    }

    public Integer getQuantityPages() {
        return quantityPages;
    }

    public void setQuantityPages(Integer quantityPages) {
        this.quantityPages = quantityPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", publicYear=" + publicYear +
                ", publicCountry='" + publicCountry + '\'' +
                ", quantityPages=" + quantityPages +
                '}';
    }
}
