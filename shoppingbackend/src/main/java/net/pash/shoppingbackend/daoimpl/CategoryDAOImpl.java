package net.pash.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.pash.shoppingbackend.dao.CategoryDAO;
import net.pash.shoppingbackend.dto.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Getting a Single Category based on id
	 * */
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE is_active = :is_active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("is_active", true);
		return query.getResultList();
		
	}

	@Override
	public boolean add(Category category) {
		try{
			 sessionFactory.getCurrentSession().persist(category);	
			 return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	@Override
	public boolean update(Category category) {
		try{
			 sessionFactory.getCurrentSession().update(category);	
			 return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			 sessionFactory.getCurrentSession().update(category);	
			 return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
