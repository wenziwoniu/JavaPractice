package javaee.spring.test.service;

import javaee.spring.test.entity.People;
import javaee.spring.test.pojo.CommonQuery;
import javaee.spring.test.pojo.PageObject;

public interface IPeopleService {

	public PageObject<People> selectPeoples(People people, CommonQuery query);
	
	public void savePeople(People people);
}
