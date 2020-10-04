package javaee.spring.test.service;

import java.util.List;

import javaee.spring.test.entity.Student;

public interface ITestService {

	/**
	 * 功能 : 保存Student对象
	 * 开发：zwwang 2015-10-25 上午9:24:38
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
	 * 功能 : 根据ID查找CfLoginUser对象
	 * 开发：zwwang 2015-10-25 上午11:36:03
	 * @param userId 
	 * @return
	 */
	public Student findStudent(Long userId);
	/**
	 * 功能 : 使用mybatis存储数据
	 * 开发：zwwang 2015-10-25 下午5:22:52
	 * @param student
	 */
	public void insertStudent(Student student);
	
	/**
	 * 功能 : 获取STUDENT表中的所有记录
	 * 开发：zwwang 2015-10-28 上午10:52:37
	 * @return
	 */
	public List<Student> findAllStudent();
	
	public void insertStudents(List<Student> students);
	
	/**
	 * 功能 : 第一类丢失更新方法一
	 * 开发：zwwang 2016-1-12 下午7:24:40
	 * @param student
	 * @throws InterruptedException 
	 */
	public void lostUpdate1(Student student) throws InterruptedException;
	
	/**
	 * 功能 : 第一类丢失更新方法二
	 * 开发：zwwang 2016-1-12 下午7:25:07
	 * @param student
	 */
	public void lostUpdate2(Student student);
	
	/**
	 * 功能 : 脏读方法一
	 * 开发：zwwang 2016-1-13 上午9:37:17
	 */
	public void dirtyRead1();
	
	/**
	 * 功能 : 脏读方法二
	 * 开发：zwwang 2016-1-13 上午9:38:04
	 */
	public void dirtyRead2();
	
	/**
	 * 功能 : 虚读方法一
	 * 开发：zwwang 2016-1-13 上午10:13:48
	 */
	public void phantomRead1();
	
	/**
	 * 功能 : 虚读方法二
	 * 开发：zwwang 2016-1-13 上午10:14:02
	 */
	public void phantomRead2();
	
	/**
	 * 功能 : 不可重复读方法一
	 * 开发：zwwang 2016-1-13 上午10:39:04
	 */
	public void unrepeatedRead1();
	
	/**
	 * 功能 : 不可重复读方法二
	 * 开发：zwwang 2016-1-13 上午10:39:07
	 */
	public void unrepeatedRead2();
	
	public void persist();
	
	public void merge();
	
	public void mybatisInsert();
	
	public void mybatisUpdate();
	
	public void scene21();
	
	public void scene22();
	
	
}
