package com.practice.dentistOffice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="treatments")
public class Treatments {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="service charge")
    private Double service_charge;

    @Column(name="explanation")
    private String explanation;

	
    public Treatments() {
    	
	}
    public Treatments(Long id, String name, Double service_charge, String explanation) {
		super();
		this.id = id;
		this.name = name;
		this.service_charge = service_charge;
		this.explanation = explanation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getService_charge() {
		return service_charge;
	}
	public void setService_charge(Double service_charge) {
		this.service_charge = service_charge;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
    
}
