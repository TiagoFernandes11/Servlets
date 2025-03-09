import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryTest {
	
	public static void main(String args[]) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Users user = new Users();
		user.setEmail("teste@teste.com");
		user.setFullName("Teste 3");
		user.setPassword("teste");
		
		UserDAO userDAO = new UserDAO(entityManager);
		userDAO.create(user);
		
		
	}
}
