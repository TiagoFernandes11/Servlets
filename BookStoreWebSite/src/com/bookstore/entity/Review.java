package src.com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int ReviewId;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private int rating;

    private String headline;

    private String comment;

    @Column(name = "review_time")
    private Date reviewTime;
}
