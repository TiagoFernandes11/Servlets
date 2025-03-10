package com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;

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

	public OrderDetail() {
		super();
	}

	public BookOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(BookOrder orderId) {
		this.orderId = orderId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
    
    
}
