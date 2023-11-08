package models;

import javax.persistence.*;

@Entity
@Table (name = "library")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "number_of_pages")
    private int numberOfPages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String bookName, int numberOfPages) {
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Models.Book{" +
                "bookName='" + bookName + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
