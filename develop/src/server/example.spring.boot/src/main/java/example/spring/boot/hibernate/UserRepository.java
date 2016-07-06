package example.spring.boot.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserRepository  {
	
	// Private fields
	  
	  // An EntityManager will be automatically injected from entityManagerFactory
	  // setup on DatabaseConfig class.
	  @PersistenceContext
	  private EntityManager entityManager;
  
  /**
   * Save the user in the database.
   */
  public void create(UserEntity user) {
    entityManager.persist(user);
  }
  
  /**
   * Delete the user from the database.
   */
  public void delete(UserEntity user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
    else
      entityManager.remove(entityManager.merge(user));
    return;
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<UserEntity> getAll() {
//    return entityManager.createQuery("from UserEntity",UserEntity.class).getResultList();
	  return entityManager.createNativeQuery("select * from user", UserEntity.class).getResultList();
  }
  
  public UserEntity findUserByName(String name){
	  Query query = entityManager.createNativeQuery("select * from user where username=?", UserEntity.class);
	  query.setParameter(1, name);
	  return (UserEntity) query.getSingleResult();
  }
  
  
  /**
   * Return the user having the passed email.
   */
  public UserEntity getByEmail(String email) {
    return (UserEntity) entityManager.createQuery(
        "from User where email = :email")
        .setParameter("email", email)
        .getSingleResult();
  }

  /**
   * Return the user having the passed id.
   */
  public UserEntity getById(long id) {
    return entityManager.find(UserEntity.class, id);
  }

  /**
   * Update the passed user in the database.
   */
  public void update(UserEntity user) {
    entityManager.merge(user);
    return;
  }

//  public UserEntity findUserByName(){}
}