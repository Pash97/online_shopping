package net.pash.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.pash.shoppingbackend.dao.ProductDAO;
import net.pash.shoppingbackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	
	private SessionFactory sessionFactory; 
	/*
	 * Single
	 * 
	 */
	@Override
	public Product get(int productId) {
		try{
				return sessionFactory
						.getCurrentSession()
							.get(Product.class,Integer.valueOf(productId));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product",Product.class)
						.getResultList();
	}
	/*
	 * INSERT
	 * 
	 */
	@Override
	public boolean add(Product product) {
		try{
				sessionFactory
					.getCurrentSession()
						.persist(product);
				return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	/*
	 * UPDATE
	 * 
	 */
	@Override
	public boolean update(Product product) {
		try{
				sessionFactory
					.getCurrentSession()
						.update(product);
				return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	/*
	 * DELETE
	 * 
	 */
	@Override
	public boolean delete(Product product) {
		try{
				product.setIsActive(0);
				return this.update(product);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String setActiveProducts = "FROM Product WHERE isActive = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(setActiveProducts,Product.class)
						.setParameter("active", 1)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String setActiveProductsByCategory = "FROM Product WHERE isActive = :active AND categoryId = :categoryId";
			return sessionFactory
					.getCurrentSession()
						.createQuery(setActiveProductsByCategory,Product.class)
							.setParameter("active", 1)
							.setParameter("categoryId",categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE isActive :active ORDER BY id",Product.class)
						.setParameter("active", 1)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
