import java.util.List;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import com.bookstore.service.UsersServices;

import jakarta.persistence.Persistence;

public class UserDaoTest {
	public static void main(String args[]) {
		
		UsersServices usersServices = new UsersServices();
		
		List<Users> users = usersServices.listAll();
		
		for(Users user : users) {
			System.out.println(user.getUserId() + ", " + user.getEmail() + ", " + user.getFullName());
		}
		
	}
}
