package javaee.spring.test.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javaee.spring.test.dao.IAddressDao;
import javaee.spring.test.entity.Address;

import org.springframework.stereotype.Repository;

@Repository("AddressDaoImpl")
public class AddressDaoImpl implements IAddressDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Address findAddressById(Long id) {
		return entityManager.find(Address.class, id, LockModeType.PESSIMISTIC_WRITE);
	}

	@Override
	public Address findAddressByIdOptimistic(Long id) {
		return entityManager.find(Address.class, id);
	}

	@Override
	public void merge(Address address) {
		entityManager.merge(address);
		
	}

	@Override
	public void update(Address address) {
		String sqlString = "update address set address_name = :name where id = :id";
		Query query = entityManager.createNativeQuery(sqlString);
		query.setParameter("id", address.getId());
		query.setParameter("name", address.getAddressName());
		query.executeUpdate();
	}
	
}
