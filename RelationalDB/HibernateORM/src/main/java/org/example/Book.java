package org.example;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "ISBN", nullable = false)
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PublisherName")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AuthorName")
    private Author author;

    @Column(name = "AuthorAddress")
    private String authorAddress;

    @Column(name = "Year")
    private Integer year;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Price")
    private BigDecimal price = BigDecimal.ZERO; // Default value

    // Constructors
    public Book() {
    }

    public Book(String isbn, Publisher publisher, Author author, String authorAddress, Integer year, String title, BigDecimal price) {
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = author;
        this.authorAddress = authorAddress;
        this.year = year;
        this.title = title;
        this.price = price;
    }

    // Getter and setter methods
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // toString method for printing
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", publisher=" + (publisher != null ? publisher.getName() : null) +
                ", author=" + (author != null ? author.getName() : null) +
                ", authorAddress='" + authorAddress + '\'' +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
