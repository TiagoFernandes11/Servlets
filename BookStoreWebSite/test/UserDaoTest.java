import java.util.List;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import com.bookstore.service.UsersServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDaoTest {
	public static void main(String args[]) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserDAO userDAO = new UserDAO(entityManager);
		
		String email = "tiagofernandesribeiro@yahoo.com.br";
		String password = "minhasenha";
		
		System.out.println(userDAO.checkLogin(email, password));
		
	}
}
