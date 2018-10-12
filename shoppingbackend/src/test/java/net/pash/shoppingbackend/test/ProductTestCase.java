package net.pash.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pash.shoppingbackend.dao.ProductDAO;
import net.pash.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.pash.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	@Test
	public void testAddCategory()
	{
		product = new Product();
		product.setName("Oppo s1 Selfie");
		product.setBrand("Oppo");
		product.setDescription("Oppos new phone in market");
		product.setUnitPrice(25000);
		product.setIsActive(1);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Something Went Wrong..!",true,productDAO.add(product));
	}
	
}
