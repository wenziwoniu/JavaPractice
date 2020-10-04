package javaee.spring.test.dao.impl;

import java.util.List;

import javaee.spring.test.dao.ITestDao;
import javaee.spring.test.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository("TestDaoImpl")
public class TestDaoImpl implements ITestDao {

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void saveStudent(Student entity) {
		entityManager.persist(entity);
	}

	@Override
	public void deleteStudent(Student entity) {
//		entityManager.remove(entityManager.merge(entity));
		String sqlString = "DELETE FROM STUDENT WHERE ID = :id";
		Query query = entityManager.createNativeQuery(sqlString);
		query.setParameter("id", entity.getId());
		query.executeUpdate();
	}
	
	@Override
	public Student updateStudent(Student entity) {
		String sqlString = "update student set student_name = :name where id = :id";
		Query query = entityManager.createNativeQuery(sqlString);
		query.setParameter("id", entity.getId());
		query.setParameter("name", entity.getStudentName());
//		query.setParameter("optlock", entity.getVersion());
		query.executeUpdate();
		return new Student();
	}

	@Override
	public Student findStudent(Long userId) {
		String sql = "SELECT ID,OPTLOCK FROM STUDENT WHERE ID = :userId";
		Query query = entityManager.createNativeQuery(sql, Student.class);
//		query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
		query.setParameter("userId", userId);
		List<Student> students = query.getResultList();
		return students.get(0);
//		return entityManager.find(Student.class, userId, LockModeType.PESSIMISTIC_WRITE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudent() {
		String sqlString = "SELECT * FROM STUDENT";
		Query query = entityManager.createNativeQuery(sqlString, Student.class);
		return query.getResultList();
	}

	@Override
	public Student findStudentByOptimistic(Long userId) {
		return entityManager.find(Student.class, userId);
	}

	@Override
	public void merge(Student student) {
		entityManager.merge(student);
	}

}
