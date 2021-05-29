package com.practice.dentistOffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name= "insuranceinformation")
public class InuranceInformance {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;
    
    
    @Column(name="address")
    private String address;
    
    @Column(name="insurance company")
    private String insurance_company;
    
    @Column(name="PCP name")
    private String PCP_name;

    @Column(name="expiration date")
    private String expiration_date;
    
    @Transient
    private String token;

	public InuranceInformance(Long id, String firstname, String lastname, String email, String phone, String address,
			String insurance_company, String pCP_name, String expiration_date, String token) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.insurance_company = insurance_company;
		this.PCP_name = pCP_name;
		this.expiration_date = expiration_date;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInsurance_company() {
		return insurance_company;
	}

	public void setInsurance_company(String insurance_company) {
		this.insurance_company = insurance_company;
	}

	public String getPCP_name() {
		return PCP_name;
	}

	public void setPCP_name(String pCP_name) {
		PCP_name = pCP_name;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
}
