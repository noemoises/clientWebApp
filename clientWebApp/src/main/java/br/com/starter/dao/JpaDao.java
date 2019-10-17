package br.com.starter.dao;

import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.starter.model.Phones;
import br.com.starter.model.User;

public class JpaDao {
	private static JpaDao userJpa;
	private EntityManager entityManager;

	public static JpaDao getInstance() {
		if (userJpa == null) {
			userJpa = new JpaDao();
		}
		return userJpa;
	}

	public JpaDao() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("clientWebApp");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public void add(Object obj) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public Object findById(int id, String name) {
		if (name.equals("User")) {
			return entityManager.find(User.class, id);
		}
		return entityManager.find(Phones.class, id);
	}

	public List<?> findAll(String className) {
		return entityManager.createQuery("FROM " + className).getResultList();
	}

	public void update(Object obj) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Object obj) {
		try {
			if (obj.getClass().getSimpleName().equals("User")) {
				entityManager.getTransaction().begin();
				obj = entityManager.find(User.class, ((User) obj).getId());
				entityManager.remove(obj);
				entityManager.getTransaction().commit();				
			}else {
				entityManager.getTransaction().begin();
				obj = entityManager.find(Phones.class, ((Phones) obj).getId());
				entityManager.remove(obj);
				entityManager.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(int id, String className) {
		try {
			if (className.equals("User")) {
				User user = (User) findById(id, className);
				remove(user);				
			}else{
				Phones phones = (Phones) findById(id, className);
				remove(phones);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User login(String email, String password) {
		User user = null;
		user = findUser(email);
		if (!user.getPassword().equals(password)) {
			throw new InputMismatchException("You entered some incorrect data.");
		}
		return user;
	}

	private User findUser(String email) {
		User user = null;
		try {
			entityManager.getTransaction().begin();
			user = entityManager
					.createQuery("FROM User WHERE email = '" + email + '\'',
							User.class)
					.getResultList().get(0);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		} 
		return user;
	}
}
