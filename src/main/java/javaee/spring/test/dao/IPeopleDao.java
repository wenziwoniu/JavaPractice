package javaee.spring.test.dao;

import javaee.spring.test.entity.People;
import javaee.spring.test.pojo.CommonQuery;
import javaee.spring.test.pojo.PageObject;

public interface IPeopleDao {

	public People findPeopleById(Long id);
	
	public People findPeopleByIdOptimistic(Long id);
	
	public void merge(People people);
	
	public void update(People people);
	
	public PageObject<People> selectPeoples(People people, CommonQuery query);
}
