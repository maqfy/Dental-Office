package com.practice.dentistOffice.service;

import com.practice.dentistOffice.controller.StringAppoinment;
import com.practice.dentistOffice.model.Treatments;

public interface TreatmentsService {

	Long numberOfProducts();

	Object saveTreatments(Treatments treatments);

	Object updateTreatments(Treatments treatments);

	void deleteTreatments(Object id);

	Object findAllTreatments();

	Long numberOfTreatments();

	Treatments findTreatmentsByname(String name);

	StringAppoinment findAllTreatment();

}
