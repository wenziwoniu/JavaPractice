package javaee.spring.test.service.impl;

import javaee.spring.test.dao.IPeopleDao;
import javaee.spring.test.entity.People;
import javaee.spring.test.pojo.CommonQuery;
import javaee.spring.test.pojo.PageObject;
import javaee.spring.test.service.IPeopleService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("PeopleServiceImpl")
public class PeopleServiceImpl implements IPeopleService {
	
	@Resource(name = "PeopleDaoImpl")
	private IPeopleDao peopleDao;

	@Override
	public PageObject<People> selectPeoples(People people, CommonQuery query) {
		PageObject<People> pageObject = peopleDao.selectPeoples(people, query);
		pageObject.setNumPerPage(query.getNumPerPage());
		pageObject.setPageNum(query.getPageNum());
		return pageObject;
	}

	@Override
	public void savePeople(People people) {
		peopleDao.merge(people);
	}
	

}
