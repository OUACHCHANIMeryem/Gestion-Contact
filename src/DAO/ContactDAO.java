package DAO;

import modell.Contact;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;





public class ContactDAO {
		/** Add Contact
		 * @param categorie **/
		public void addContact(String nom,String prenom,String num_tel,String type_tel, String categorie) {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();

			try {
				
				
				Contact c = new Contact();

				c.setNom(nom);
				c.setPrenom(prenom);
				c.setNum_tel(num_tel);
				c.setType_tel(type_tel);
				c.setCategorie(categorie);

				session.save(c);
				transaction.commit();
				session.close();
				System.out.println("\n\n Details Added \n");

			} catch (HibernateException e) {
				System.out.println(e.getMessage());
				System.out.println("error");
			}
		}

		/** Show Contact **/
		public static List List_of_Contact() {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			List data = null;
			try {
			
				org.hibernate.query.Query query = session.createQuery("from Contact");

				data = query.list();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			return data;
		}
		
		/** Show Contact **/
		public static List  ListCategorie() {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			List data = null;
			try {
			
				org.hibernate.query.Query query = session.createQuery("from Categorie");

				data = query.list();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
			return data;
		}
		/*** delete contact **/
		public void deleteProject(int idContact) {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			 // 3. Get Session objects
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();

			try {
				Query query = session.createQuery("delete Contact where id_contact=:idContact");
				
				query.setParameter("idContact", idContact);
				query.executeUpdate();
				transaction.commit();
				session.close();
				System.out.println("\n\n Details Deleted \n");

			} catch (HibernateException e) {
				System.out.println(e.getMessage());
				System.out.println("error");
			}
		}


}
