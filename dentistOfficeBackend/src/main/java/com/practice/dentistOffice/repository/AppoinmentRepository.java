package com.practice.dentistOffice.repository;

import com.practice.dentistOffice.model.Appoinment;

public interface AppoinmentRepository {

	Iterable<Appoinment> appoinment();

	void deleteById(Long appoinmentId);

	Appoinment findByEmail(String email);

	Appoinment save(Appoinment appoinment);

	Iterable<Appoinment> findAll();

	void deleteByEmail(String email);

}
