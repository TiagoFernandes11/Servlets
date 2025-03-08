package src.com.bookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    private String address;

    private String city;

    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "zip_code")
    private String zipCode;

    private String password;

    @Column(name = "register_date")
    private Date registerDate;
}
