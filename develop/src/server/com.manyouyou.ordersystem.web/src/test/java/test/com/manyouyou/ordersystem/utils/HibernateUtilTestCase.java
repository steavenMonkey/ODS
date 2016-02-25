package test.com.manyouyou.ordersystem.utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.manyouyou.ordersystem.model.UserInfoModel;
import com.manyouyou.ordersystem.utils.SpringUtil;

public class HibernateUtilTestCase {
	
	private SessionFactory sf;
	@Before
	public void before(){
		sf = (SessionFactory) SpringUtil.getApplicationContext().getBean("sessionFactory");
	}
	
	@Test
	public void getSessionFactoryTest(){
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		System.out.println(session);
		
		SessionFactory sessionFacotry = (SessionFactory) SpringUtil.getApplicationContext().getBean("sessionFactory");
		Session session = sessionFacotry.getCurrentSession();
		System.out.println(session);
	}
	
	@Test
	public void testLoad(){
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		System.out.println(session);
		
		SessionFactory sessionFacotry = (SessionFactory) SpringUtil.getApplicationContext().getBean("sessionFactory");
		Session session = sessionFacotry.getCurrentSession();
		System.out.println(session);
		session.beginTransaction();
		UserInfoModel user = session.load(UserInfoModel.class, 1);
		System.out.println(user);
		session.getTransaction().commit();
	}
	
	
	@Test
	public void testHQL(){
		Session session = sf.getCurrentSession();
		String hql = "from UserInfoModel where name=?";
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter(0, "aa");
		UserInfoModel user = (UserInfoModel) query.list().get(0);
		System.out.println(user);
		session.getTransaction().commit();
	}
	
	
}
