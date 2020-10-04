package javaee.spring.test.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PEOPLE")
public class People implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String peopleName;
	private int optlock;

	// Constructors

	/** default constructor */
	public People() {
	}

	/** full constructor */
	public People(String peopleName) {
		this.peopleName = peopleName;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PEOPLE_NAME", length = 32)
	public String getPeopleName() {
		return this.peopleName;
	}

	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}


	@Column(name = "OPTLOCK", length = 32)
	public int getOptlock() {
		return optlock;
	}

	public void setOptlock(int optlock) {
		this.optlock = optlock;
	}
	

}