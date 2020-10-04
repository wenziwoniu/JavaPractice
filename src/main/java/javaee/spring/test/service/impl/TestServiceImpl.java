package javaee.spring.test.service.impl;

import java.util.List;

import javaee.spring.test.dao.IAddressDao;
import javaee.spring.test.dao.IPeopleDao;
import javaee.spring.test.dao.ITestDao;
import javaee.spring.test.dao.mybatis.IAddressMybatisDao;
import javaee.spring.test.dao.mybatis.IPeopleMybatisDao;
import javaee.spring.test.dao.mybatis.IStudentMybatisDao;
import javaee.spring.test.entity.Address;
import javaee.spring.test.entity.People;
import javaee.spring.test.entity.Student;
import javaee.spring.test.service.ITestService;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service("TestServiceImpl")
public class TestServiceImpl implements ITestService {

	@Resource(name = "TestDaoImpl")
	private ITestDao testDao;
	
	@Resource(name = "PeopleDaoImpl")
	private IPeopleDao peopleDao;
	
	@Resource(name = "AddressDaoImpl")
	private IAddressDao addressDao;
	

	@Autowired
	private IStudentMybatisDao studentMybatisDao;
	
	@Autowired
	private IPeopleMybatisDao peopleMybatisDao;
	
	@Autowired
	private IAddressMybatisDao addressMybatisDao;
//	@Transactional
//	public void saveStudent(Student entity) {
//		testDao.saveStudent(entity);
//	}
	
	public void saveStudent(List<Student> entitys) {
		testDao.saveStudent(entitys.get(0));
	}

	public void deleteStudent(Student entity) {
		testDao.deleteStudent(entity);
	}

	public Student updateStudent(Student entity) {
		return testDao.updateStudent(entity);
	}

	public Student findStudent(Long userId) {
		return testDao.findStudent(userId);
	}

	@Transactional(isolation = Isolation.DEFAULT)
	public void insertStudent(List<Student> students) throws InterruptedException{
				System.out.println("abc");
				studentMybatisDao.insert(students.get(0));
				Thread.sleep(20000);
				System.out.println("efg");
	}
	
//	public void insertStudent(Student students){
//				studentMybatisDao.insert(students);
////			studentMybatisDao.insert(student2);
//	}

	public List<Student> findAllStudent() {
		return studentMybatisDao.selectAll();
	}

	@Override
	public void saveStudent(Student entity) {
		
	}

	@Override
	public void insertStudent(Student student) {
		
	}

	@Override
	@Transactional
	public void insertStudents(List<Student> students) {
		for (Student student : students) {
//			studentMybatisDao.insert(student);
			testDao.saveStudent(student);
//			testDao.merge(student);
		}
	}

	@Override
	@Transactional
	public void lostUpdate1(Student student) {
		try {
			Long id = 1L;
			Student recordStudent =  testDao.findStudentByOptimistic(id);
			recordStudent.setStudentName("a");
			Thread.sleep(20000);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
	}

	@Override
	@Transactional
	public void lostUpdate2(Student student) {
		try {
			Long id = 1L;
			Student recordStudent = studentMybatisDao.selectByPrimaryKeyOptimistic(id);
			recordStudent.setStudentName("c");
			studentMybatisDao.updateByOptimistic(recordStudent);
		} catch (Exception e) {
			System.out.println("lost2");
		}
	}

	@Override
	@Transactional
	public void dirtyRead1() {
		try {
//			Long studentId = 1L;
//			Student recordStudent = testDao.findStudent(studentId);
//			recordStudent.setStudentName("xia");
//			testDao.updateStudent(recordStudent);
//			studentMybatisDao.updateByPrimaryKey(recordStudent);
			Student student1 = new Student();
			student1.setId(29L);
			student1.setStudentName("abcd");
			studentMybatisDao.insert(student1);
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			System.out.println("a");
//			Thread.sleep(10000);
			Student student = studentMybatisDao.selectByPrimaryKey(29L);
			System.out.println(student.getStudentName());
//			Student student3 = studentMybatisDao.selectByPrimaryKey(15L);
//			System.out.println(student3.getStudentName());
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public void dirtyRead2() {
		try {
			Long studentId = 38L;
//			Thread.sleep(10000);
			Student recordStudent = testDao.findStudentByOptimistic(studentId);
			recordStudent.setStudentName("2");
//			studentMybatisDao.updateByPrimaryKey(recordStudent);
			testDao.updateStudent(recordStudent);
			Student recordStudent2 = testDao.findStudent(studentId);
			System.out.println("dirty2:" + recordStudent2.getStudentName());
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public void phantomRead1() {
		try {
			List<Student> studentList = testDao.findAllStudent();
			System.out.println(studentList.size());
//			Thread.sleep(20000);
			List<Student> studentList2 = testDao.findAllStudent();
			System.out.println(studentList2.size());
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public void phantomRead2() {
		try {

			Student student = new Student();
			student.setStudentName("e");
//		testDao.saveStudent(student);
			studentMybatisDao.insert(student);
			Thread.sleep(10000);
			List<Student> studentList = studentMybatisDao.selectAll();
			
			System.out.println(studentList.size());
			System.out.println("abc");
		} catch (Exception e) {
		}
	}

	@Override
	@Transactional
	public void unrepeatedRead1() {
		try {
			Long studentId = 1L;
			Student recordStudent = testDao.findStudent(studentId);
			System.out.println("unrepeatedRead1:" + recordStudent.getStudentName());
			Thread.sleep(10000);
			Student recordStudent2 = testDao.findStudent(studentId);
			System.out.println("unrepeatedRead12:" + recordStudent2.getStudentName());
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void unrepeatedRead2() {
		try {
			Long studentId = 1L;
//			Thread.sleep(3000);
			Student recordStudent = testDao.findStudent(studentId);
			System.out.println("unrepeatedRead2:" + recordStudent.getStudentName());
//			recordStudent.setStudentName("xiala");
//			testDao.updateStudent(recordStudent);
		} catch (Exception e) {
		}
	}

	@Override
	@Transactional
	public void persist() {
		Long id = 2L;
//		Student student = testDao.findStudentByOptimistic(id);
		Student student = new Student();
//		student.setId(20L);
		student.setStudentName("H");
		testDao.saveStudent(student);
		System.out.println("abc");
	}

	@Override
	@Transactional
	public void merge() {
		Long id = 205L;
//		Student student = testDao.findStudentByOptimistic(id);
		Student student = new Student();
		student.setStudentName("a");
		student.setId(1L);
		student.setOptlock(2);
		testDao.merge(student);
		System.out.println("abc");
	}

	@Override
	@Transactional
	public void mybatisInsert() {
		Long id = 2L;
//		Student student = studentMybatisDao.selectByPrimaryKey(id);
		Student student = new Student();
//		student.setId(201L);
		student.setStudentName("liu");
		studentMybatisDao.insertSelective(student);
		System.out.println("abc");
	}

	@Override
	@Transactional
	public void mybatisUpdate() {
		Long id = 2L;
//		Student student = studentMybatisDao.selectByPrimaryKey(id);
		Student student = new Student();
		student.setId(300L);
		student.setStudentName("xx");
		studentMybatisDao.updateByPrimaryKeySelective(student);
	}

	@Override
	@Transactional
	public void scene21() {
		try {
			Long id = 1L;
			People people = peopleMybatisDao.selectByPrimaryKey(id);
			people.setPeopleName("z");
			peopleMybatisDao.updateByPrimaryKeySelective(people);
			Student student = studentMybatisDao.selectByPrimaryKey(id);
			student.setStudentName("a");
			studentMybatisDao.updateByPrimaryKeySelective(student);
			Thread.sleep(20000);
			System.out.println("abc");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void scene22() {
		try {
			Long id = 1L;
			Address address = addressMybatisDao.selectByPrimaryKey(id);
			address.setAddressName("z");
			addressMybatisDao.updateByPrimaryKeySelective(address);
			Student student = studentMybatisDao.selectByPrimaryKey(id);
			student.setStudentName("w");
			studentMybatisDao.updateByPrimaryKeySelective(student);
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
