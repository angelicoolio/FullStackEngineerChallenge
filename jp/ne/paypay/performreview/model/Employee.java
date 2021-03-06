package jp.ne.paypay.performreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the entity class for Employee
 * @author angelicoolio
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="firsrName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="otherName")
	private String otherName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
}
