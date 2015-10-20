package org;

import java.io.IOException;
import java.util.Date;

import javax.jdo.JDOEnhancer;
import javax.jdo.JDOHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.JPATes;
@SuppressWarnings("serial")
public class JPATWOServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		

		
		resp.getWriter().println("Hello rup5");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("transactions-optional");
			 EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        Date created=new Date();
		JPATes a1 = new JPATes("myPre", "mySur", created);

    tx = em.getTransaction();
        tx.begin(); 
            em.persist(a1);
        tx.commit();
	}
}
