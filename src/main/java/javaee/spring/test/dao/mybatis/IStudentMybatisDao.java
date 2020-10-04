package javaee.spring.test.dao.mybatis;

import java.util.List;

import javaee.spring.test.entity.Student;

public interface IStudentMybatisDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Student record);
    
    int updateByOptimistic(Student record);
    
    /**
     * 功能 : 根据id获取STUDENT表中记录
     * 开发：zwwang 2016-1-13 下午2:18:57
     * @param id 
     * @return
     */
    Student selectByPrimaryKey(Long id);
    
    Student selectByPrimaryKeyOptimistic(Long id);
}