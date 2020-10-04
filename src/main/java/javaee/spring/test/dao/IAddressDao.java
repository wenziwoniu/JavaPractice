package javaee.spring.test.dao;

import javaee.spring.test.entity.Address;

public interface IAddressDao {

	public Address findAddressById(Long id);
	
	public Address findAddressByIdOptimistic(Long id);
	
	public void merge(Address address);
	
	public void update(Address address);
	
	
}
