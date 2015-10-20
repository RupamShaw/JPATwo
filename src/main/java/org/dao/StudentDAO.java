package org.dao;

import java.util.List;

import org.model.Student;

public interface StudentDAO {
	Student addStudent(Student Student);
	void removeStudent(long id);
	Student updateStudent(Student Student);
	List<Student> listStudents();
}
