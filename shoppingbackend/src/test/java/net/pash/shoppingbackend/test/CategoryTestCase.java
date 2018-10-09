package net.pash.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pash.shoppingbackend.dao.CategoryDAO;
import net.pash.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.pash.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
/*@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("Television");
		category.setDescription("This is description of Television");
		category.setImageURL("CAT_04.jpg");
		assertEquals("Successfully added a category inside the table..!",true,categoryDAO.add(category));
		
	}*/
	/*@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(3);
		assertEquals("Successfully fetched a single category from the table..!","Television",category.getName());
	}*/
	/*@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Successfully updated a single category from the table..!",true,categoryDAO.update(category));
	}*/
	/*@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Successfully Deleted a single category from the table..!",true,categoryDAO.delete(category));
	}*/
	@Test
	public void testDeleteCategory()
	{
		
		assertEquals("Successfully Fetched categories from the table..!",3,categoryDAO.list().size());
	}
	
}
