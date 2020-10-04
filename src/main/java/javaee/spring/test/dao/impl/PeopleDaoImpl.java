package javaee.spring.test.dao.impl;

import java.util.List;

import javaee.spring.test.dao.IPeopleDao;
import javaee.spring.test.entity.People;
import javaee.spring.test.pojo.CommonQuery;
import javaee.spring.test.pojo.PageObject;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("PeopleDaoImpl")
public class PeopleDaoImpl implements IPeopleDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public People findPeopleById(Long id) {
		return entityManager.find(People.class, id, LockModeType.PESSIMISTIC_WRITE);
	}

	@Override
	public People findPeopleByIdOptimistic(Long id) {
		return entityManager.find(People.class, id);
	}

	@Override
	public void merge(People people) {
		entityManager.merge(people);
	}

	@Override
	public void update(People people) {
		String sqlString = "update PEOPLE set people_name = :name where id = :id";
		Query query = entityManager.createNativeQuery(sqlString);
		query.setParameter("id", people.getId());
		query.setParameter("name", people.getPeopleName());
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageObject<People> selectPeoples(People people, CommonQuery commonQuery) {
		StringBuilder countString = new StringBuilder("SELECT COUNT(*) FROM PEOPLE \n");
		if (people.getPeopleName() != null && people.getPeopleName() != "") {
			countString.append("WHERE PEOPLE_NAME = :peopleName");
		}
		Query countQuery = entityManager.createNativeQuery(countString.toString());
		if (people.getPeopleName() != null && people.getPeopleName() != "") {
			countQuery.setParameter("peopleName", people.getPeopleName());
		}
		Long totalCount = Long.parseLong(countQuery.getSingleResult().toString());
		StringBuilder sqlString = new StringBuilder("SELECT * FROM PEOPLE \n");
		if (people.getPeopleName() != null && people.getPeopleName() != "") {
			sqlString.append("WHERE PEOPLE_NAME = :peopleName");
		}
		Query query = entityManager.createNativeQuery(sqlString.toString(), People.class);
		if (people.getPeopleName() != null && people.getPeopleName() != "") {
			query.setParameter("peopleName", people.getPeopleName());
		}
		query.setFirstResult(commonQuery.getStart());
		query.setMaxResults(commonQuery.getNumPerPage());
		List<People> list = query.getResultList();
		PageObject<People> pageObject = new PageObject<People>();
		pageObject.setTotalCount(totalCount);
		pageObject.setList(list);
		return pageObject;
	}

}
