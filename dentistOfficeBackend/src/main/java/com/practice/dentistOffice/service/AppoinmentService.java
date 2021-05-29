package com.practice.dentistOffice.service;

import com.practice.dentistOffice.model.Appoinment;
import com.practice.dentistOffice.repository.AppoinmentRepository;

public class AppoinmentService {

	private final AppoinmentRepository appoinmentRepository ;
	
	public AppoinmentService(AppoinmentRepository appoinmentRepository) {
		this.appoinmentRepository=appoinmentRepository;
	}

	public void saveReservation(Appoinment appoinment ) {
		appoinmentRepository.save(appoinment);
	}
	public Iterable<Appoinment> showAllReservations(){
		return appoinmentRepository.appoinment();
	}

	public Iterable<Appoinment> deleteUserByEmail(String email) {
		appoinmentRepository.deleteByEmail(email);
		return appoinmentRepository.findAll();
	}

	  public Appoinment updateReserve(final Appoinment appoinment){
	        return appoinmentRepository.save(appoinment);
	    }
	  public Appoinment findByEmail(final String email){
	        return appoinmentRepository.findByEmail(email);
	    }
	   public void deleteReserve(final Long appoinmentId){
		   appoinmentRepository.deleteById(appoinmentId);
	    }

	public static void deleteAppoinment(Object id) {
		// TODO Auto-generated method stub
		
	}

	public Iterable<Appoinment> showAllAppoinments() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object updateAppoinment(Appoinment appoinment) {
		// TODO Auto-generated method stub
		return null;
	}

	public Appoinment findByEmail(Object email) {
		// TODO Auto-generated method stub
		return null;
	}
}
