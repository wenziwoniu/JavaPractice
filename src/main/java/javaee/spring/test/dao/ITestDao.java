package javaee.spring.test.dao;

import java.util.List;

import javaee.spring.test.entity.Student;

public interface ITestDao {
	
	/**
	 * 功能 : 保存Student对象
	 * 开发：zwwang 2015-10-25 上午9:23:01
	 * @param entity Student对象
	 */
	public void saveStudent(Student entity);
	
	/**
	 * 功能 : 删除实体
	 * 开发：zwwang 2015-10-25 上午11:42:39
	 * @param entity
	 */
	public void deleteStudent(Student entity);
	
	/**
	 * 功能 : 更新Student对象
	 * 开发：zwwang 2015-10-25 上午11:33:05
	 * @param entity Student对象
	 * @return
	 */
	public Student updateStudent(Student entity);
	
	/**
	 * 功能 : 根据ID查找Student对象
	 * 开发：zwwang 2015-10-25 上午11:36:03
	 * @param userId 
	 * @return
	 */
	public Student findStudent(Long userId);
	
	/**
	 * 功能 : 获取STUDENT表中的所有记录
	 * 开发：zwwang 2015-10-28 上午10:52:37
	 * @return
	 */
	public List<Student> findAllStudent();
	
	public Student findStudentByOptimistic(Long userId);
	
	public void merge(Student student);
}
