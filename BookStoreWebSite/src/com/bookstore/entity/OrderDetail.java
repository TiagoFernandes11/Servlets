package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(targetEntity = BookOrder.class)
    @JoinColumn(name = "order_id")
    private BookOrder orderId;

    @OneToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;

    @Column(name = "sub_total")
    private float subTotal;
}
