import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend_Niit.DAO.UserDAO;
import com.niit.Backend_Niit.model.User;

public class UserTest 
{

private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private User user = null;

	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend_Niit");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	
	@Test
	public void testAddUser()
	{
		user = new User();
		user.setContactNumber("1236589903");
		user.setEmail("rohan_001@gmail.com");
		user.setFirstName("Rohan");
		user.setLastName("Mishra");
		user.setPassword("sup@1234");
		user.setRole("SUPPLIER");
		
		assertEquals("Error adding User" , true , userDAO.addUser(user));
	}
}
