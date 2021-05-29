package com.practice.dentistOffice.model;

import java.security.Principal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.http.HttpStatus;

import com.practice.dentistOffice.controller.StringAppoinment;

@Entity
@Table(name="appoinment")
public class Appoinment {
	
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
    
    
    
    
    @Transient
    private String token;
    
    
    public Appoinment(Long id, String firstname, String lastname, String email, String phone,  String token) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.token=token;
    }

	public Appoinment(StringAppoinment appoinment, HttpStatus ok) {
		// TODO Auto-generated constructor stub
	}

	public Appoinment(User user, HttpStatus ok) {
		// TODO Auto-generated constructor stub
	}

	public Appoinment(HttpStatus conflict) {
		// TODO Auto-generated constructor stub
	}

	public Appoinment(Object updateTreatments, HttpStatus created) {
		// TODO Auto-generated constructor stub
	}

	public Appoinment() {
		// TODO Auto-generated constructor stub
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFirstname() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Appoinment ok(Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}

}
