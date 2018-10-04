package net.pash.shoppingbackend.dao;

import java.util.List;

import net.pash.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
	