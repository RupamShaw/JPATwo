package org.resources;

import org.model.JPATes;
import org.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.database.*;

@Path("/jerseyJPATes")
@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class TestingResource {
	/// EntityManagerFactory emf =
	/// Persistence.createEntityManagerFactory("transactions-optional");

	// List<JPATes> a1=null;
	public TestingResource() {
		// TODO Auto-generated constructor stub
	}
	/*@POST
	public JPATes addst(JPATes jt){
		System.out.println("entered in poste before em" );
		EntityManager em =EMF.get().createEntityManager();

		
		System.out.println("entered in poste" );
	EntityTransaction tx = null;
	Date created = new Date();
	//JPATes a1 = new JPATes("myPre", "mySur", created);
	jt.setCreated(new Date());
	tx = em.getTransaction();
	tx.begin();
	em.persist(jt);
	tx.commit();

	System.out.println("testing JPA Jersey data persisted at time" + created);
	return jt;
	}*/
@POST
	
	public JPATes addStudents(JPATes jt)
	{
		System.out.println("entered in poste before setting em" );
		EntityManager em =EMF.get().createEntityManager();

		
		System.out.println("entered in poste" );
	EntityTransaction tx = null;
	Date created = new Date();
	//JPATes a1 = new JPATes("myPre", "mySur", created);
	jt.setCreated(new Date());
	tx = em.getTransaction();
	tx.begin();
	em.persist(jt);
	tx.commit();

	System.out.println("testing JPA Jersey data persisted at time" + created);
	return jt;
	}

	@GET
	public List<JPATes> getStudents() {
		List<JPATes> ls = null;
		//try {
			System.out.println("testing JPA Jersey");

		/*	EntityTransaction tx = null;
			Date created = new Date();
			JPATes a1 = new JPATes("myPre", "mySur", created);

			tx = em.getTransaction();
			tx.begin();
			em.persist(a1);
			tx.commit();

			System.out.println("testing JPA Jersey data persisted at time" + created);*/
			// em.getTransaction().begin();
			/*
			 * query = "select from " + Student.class.getName(); ls =
			 * (List<Student>) pm.newQuery(query).execute();
			 */
			EntityManager em = EMF.get().createEntityManager();

			String query = "select T from " + JPATes.class.getName() + " T";

			Query q = em.createQuery(query);
			ls = q.getResultList();
			// sop is for lazy reading
			System.out.println("() list size is " + ls.size());
			// em.getTransaction().commit();
			System.out.println("testing JPA Jersey data reading successful");
		/*} catch (Exception ex) {
			em.getTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			/// @SuppressWarnings("unchecked")
			em.close();
			return ls;
		}*/
			return ls;
	}
}
