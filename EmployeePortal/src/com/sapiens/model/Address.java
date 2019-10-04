package com.sapiens.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addressId;
	private String presentAddress;

	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="empref")
	private Employee empref1;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Employee getEmpref1() {
		return empref1;
	}

	public void setEmpref1(Employee empref1) {
		this.empref1 = empref1;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", presentAddress=" + presentAddress
				+ "]";
	}

	
	
	
}
