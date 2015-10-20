package org.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.database.*;
import org.model.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Path("/studentJerseyJPA")
@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })



public class TestingJerseyJPAResource {
	EntityManager pm =EMF.get().createEntityManager();

	public TestingJerseyJPAResource() {
		// TODO Auto-generated constructor stub
	}
	@GET
	public List<Student> getStudent() {
		System.out.println("hello getStudent fromstudentjersey");
		 Map<Long, Student> students = (Map<Long, Student>) getStudents();
		return new ArrayList<Student>(students.values());
	}
	
	
	public  Map<Long, Student> getStudents() {
		Map<Long, Student> students = new HashMap<>();
		// datastore();
		// this thread gives with package name class name
		// String className=
		// Thread.currentThread().getStackTrace()[1].getClassName();
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("DatabaseClass." + methodName + "() ");

		
		List<Student> lStudent = listStudents();
		// Result[] results = getResults();
		// Map<String, Result[]> resultsMap = new HashMap<String, Result[]>();
		if (lStudent.size() == 0) {
			System.out.println("DatabaseClass." + methodName + "() in if");
			students.put(1L, new Student(1, "Rupam!"));
			// students.put(2L, new Student(2L, "Deepak"));
			// System.out.println("end of if"+students);
		} else{

			for (Student student : lStudent) {
				students.put(student.getId(), student);
			}
		// sop is for lazy reading of hashmap
		System.out.println("DatabaseClass." + methodName + "() in else hashmap students size"+students.size());
		// students.put(1L, new Student(1, "Rupam!"));
		}
		return students;
	}
	
	@SuppressWarnings("finally")
	public List<Student> listStudents() {
	//	String methodName = new Object() {		}.getClass().getEnclosingMethod().getName();
	//	System.out.println(className + "." + methodName + "() ");
		/*EntityManagerFactory emfInstance =
		   		 Persistence.createEntityManagerFactory("transactions-optional");
			EntityManager pm =emfInstance.createEntityManager();*/

		
		String query = "";
		List<Student> ls = null;
		try {
			// TODO Auto-generated method stub
			// Query q = em.createQuery("select m from Todo m");
			// List<Todo> todos = q.getResultList();

			pm.getTransaction().begin();
			/*
			 * query = "select from " + Student.class.getName(); ls =
			 * (List<Student>) pm.newQuery(query).execute();
			 */
			query = "select T from " + Student.class.getName()+" T";

			Query q = pm.createQuery(query);
			ls = q.getResultList();
			// sop is for lazy reading
			System.out.println(  "() list size is " + ls.size());
			pm.getTransaction().commit();
		} catch (Exception ex) {
			 pm.getTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			/// @SuppressWarnings("unchecked")
			pm.close();
			return ls;
		}
	}
	@POST
		public Student addStudent(Student student) {
		System.out.println("hello addStudent from studentjersey");
		return  addStudentdc(student);
	}
	
	/*public Student addStudentd(Student student) {
		// student.setId(students.size() + 1);
		// students.put(student.getId(), student);
		
		return addStudentdc(student);

	}*/
	
	public Student addStudentdc(Student student) {
		
	System.out.println("in addstudentdc ");
	Student st=new Student();
		st=	addStudentdao(student);
		// student.setId(students.size() + 1);
		// students.put(student.getId(), student);
		return student;
	}
	
//	@Override
	public Student addStudentdao(Student student) {
		// TODO Auto-generated method stub
		 System.out.println("in addstudentdao");
		student.setCreated(new Date());
	//	EntityManager pm = EMF.get().createEntityManager();
	/*	EntityManagerFactory emfInstance =
		   		 Persistence.createEntityManagerFactory("transactions-optional");
			EntityManager pm =emfInstance.createEntityManager();
	*/	try {
			
			// System.out.println("Classname.Methodname"+className+"."+methodName);
			pm.getTransaction().begin();
			pm.persist(student);
			pm.getTransaction().commit();
			 System.out.println("end of addstudentdao data persisted");

		} catch (Exception ex) {
			pm.getTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();

			return student;
		}
	}
}
