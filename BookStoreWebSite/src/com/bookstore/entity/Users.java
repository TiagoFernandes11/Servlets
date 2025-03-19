package com.bookstore.entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name = "Users.findAll", query = "select u from Users u order by u.fullName"),
	@NamedQuery(name = "Users.countAll", query = "select count(u.userId) from Users u"),
	@NamedQuery(name = "Users.findByEmail", query = "select u from Users u where u.email = :email"),
	@NamedQuery(name = "Users.checkLogin", query = "select u from Users u where u.email = :email and u.password = :password")
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    private String email;

    private String password;

    @Column(name = "full_name")
    private String fullName;

	public Users() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
    
}
