package com.bookstore.entity;

import com.mysql.cj.jdbc.Blob;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    private String title;

    private String author;

    private String description;

    private String isbn;

    private byte[] image;

    private float price;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "last_updated_time")
    private Date lastUpdatedTime;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;
}
