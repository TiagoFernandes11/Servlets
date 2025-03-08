package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import src.com.bookstore.entity.Customer;

import java.util.Date;

public class CustomerTest {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setEmail("teste@teste.com.br");
        customer.setPassword("teste");
        customer.setCity("São Paulo");
        customer.setCountry("Brasil");
        customer.setPhoneNumber("11999999999");
        customer.setZipCode("00000000");
        customer.setRegisterDate(new Date());

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        entityManager.close();

        System.out.println("Customer persisted");
    }
}
