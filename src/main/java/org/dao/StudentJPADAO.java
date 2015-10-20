package org.dao;

import java.util.Date;
import java.util.List;

 import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Query;
import org.database.EMF;
import org.model.Student;

public class StudentJPADAO implements StudentDAO {

	String className = this.getClass().getSimpleName();

	public StudentJPADAO() {
		// TODO Auto-generated constructor stub
		System.out.println("StudentJPADAO --Constructor()");
		// System.out.println("Classname.Methodname"+className+"."+methodName);
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() before EMF");
		student.setCreated(new Date());
		
		EntityManager  pm = EMF.get().createEntityManager();
		try {
			 System.out.println("Classname.Methodname"+className+"."+methodName+ "() after EMF" );

			pm.persist(student);
			 System.out.println("Classname.Methodname"+className+"."+methodName+ "() after persist" );
		} catch (Exception ex) {
			// pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();

			return student;
		}
	}

	@Override
	public void removeStudent(long id) {
		// TODO Auto-generated method stub
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");
		// Todo todo = em.find(Todo.class, id);
	   //   em.remove(todo);
		EntityManager  pm = EMF.get().createEntityManager();
		try {
			//pm.currentTransaction().begin();

			// We don't have a reference to the selected Product.
			// So we have to look it up first,
			Student student = pm.find(Student.class, id); // student.getId());
			pm.remove(student);

		//	pm.currentTransaction().commit();
		} catch (Exception ex) {
		//	pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();
		}

	}

	@Override
	public Student updateStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		EntityManager  pm = EMF.get().createEntityManager();
		String name = student.getName();
		Date created = student.getCreated();

		try {
			//pm.currentTransaction().begin();
			// We don't have a reference to the selected Product.
			// So we have to look it up first,
			student = pm.find(Student.class, student.getId());
			student.setName(name);
			student.setCreated(created);
			pm.persist(student);
		//	pm.currentTransaction().commit();
		} catch (Exception ex) {
		//	pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();

			return student;
		}
	}

	// @SuppressWarnings("finally")
	@Override
	public List<Student> listStudents() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() before EMF");
		
		
		EntityManager  pm = EMF.get().createEntityManager();
		System.out.println(className + "." + methodName + "() after EMF");
		
		String query = "";
		List<Student> ls = null;
		try {
			// TODO Auto-generated method stub
		//	Query q = em.createQuery("select m from Todo m");
		  //  List<Todo> todos = q.getResultList();

			
		   /* query = "select from " + Student.class.getName();
			ls = (List<Student>) pm.newQuery(query).execute();*/
			query = "select T from " + Student.class.getName()+" T";
			
			Query q = pm.createQuery(query);
			System.out.println(className + "." + methodName + "() after createquery");
			
			ls =q.getResultList();
			// sop is for lazy reading
			System.out.println(className + "." + methodName + "() list size is " + ls.size());

		} catch (Exception ex) {
			// pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			/// @SuppressWarnings("unchecked")
			pm.close();
			return ls;
		}

	}

}
