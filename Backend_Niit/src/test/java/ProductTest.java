import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend_Niit.DAO.ProductDAO;
import com.niit.Backend_Niit.model.Product;

public class ProductTest 
{

private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;

	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend_Niit");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	@Test
	public void testAddProduct()
	{
		product = new Product();
		
		product.setName("Galaxy Watch4");
		product.setBrand("Samsung");
		product.setDescription("Classic and premium design with rotating bezel");
		product.setUnitPrice(39990);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);
		product.setQuantity(8);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.addProduct(product));
	}
}
