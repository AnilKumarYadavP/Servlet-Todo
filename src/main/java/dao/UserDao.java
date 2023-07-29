package dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Task;
import dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		System.out.println(" done");
	}
	
	
	public User fectchByEmail(String email) {
		List<User> list=entityManager.createQuery("select x from User x where email=?1").setParameter(1, email).getResultList();
				if(list.isEmpty())
					return null;
				else
					return list.get(0);
	}
		
	public void save(Task task) {
		entityTransaction.begin();
		entityManager.persist(task);
		entityTransaction.commit();
	}
	public List<Task> fetchAllTasks()
	{
		return entityManager.createQuery("select x from Task x").getResultList(); 
	}
	

}
