package net.pash.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.pash.shoppingbackend.dao.CategoryDAO;
import net.pash.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category = new Category();
		category.setId(1);
		category.setName("Laptop");
		category.setDescription("This is description of Laptop");
		category.setImageURL("CAT_01.jpg");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is description of Mobile");
		category.setImageURL("CAT_02.jpg");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Television");
		category.setDescription("This is description of Television");
		category.setImageURL("CAT_03.jpg");
		categories.add(category);
	}
	
	
	
	@Override
	public List<Category> list() {
		
		return categories;
	}



	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories)
		{
			if(category.getId()==id)
			{
				return category;
			}
		}
		return null;
	}

}
