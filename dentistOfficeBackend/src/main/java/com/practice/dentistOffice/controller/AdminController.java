package com.practice.dentistOffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practice.dentistOffice.model.Appoinment;
import com.practice.dentistOffice.model.Treatments;
import com.practice.dentistOffice.model.User;
import com.practice.dentistOffice.service.AppoinmentService;
import com.practice.dentistOffice.service.TransactionService;
import com.practice.dentistOffice.service.TreatmentsService;
import com.practice.dentistOffice.service.UserService;



@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AppoinmentService appoinmentService;
    
    
    @Autowired
    private TreatmentsService treatmentsService;

    @Autowired
    private TransactionService transactionService;

    //user
    @PutMapping("/api/admin/user-update")
    public Appoinment updateUser(@RequestBody User user) {
        User existUser = userService.findByUsername(user.getUsername());
        if (existUser != null && !existUser.getId().equals(user.getId())) {
            return new Appoinment(HttpStatus.CONFLICT);
        }
        return new Appoinment(userService.updateUser(user), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/user-delete")
    public Appoinment deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return new Appoinment(HttpStatus.OK);
    }
    
    @GetMapping("api/admin/delete/{email}")
   	public Iterable<Appoinment> deleteUser(@PathVariable String email){
   		return appoinmentService.deleteUserByEmail(email);
   	}

       @GetMapping("/api/admin/user-all")
       public Appoinment findAllUsers(){
           return new Appoinment((StringAppoinment) userService.findAllUsers(), HttpStatus.OK);
       }

       @GetMapping("/api/admin/user-number")
       public Appoinment numberOfUsers(){
           Long number = userService.numberOfUsers();
           StringAppoinment appoinment = new StringAppoinment();
           appoinment.setAppoinment(number.toString());
           //to return it, we will use String Response because long is not a suitable response for rest api
           return new Appoinment(appoinment, HttpStatus.OK);
       }


//reserve
   // This can be also @DeleteMapping.
    @PostMapping("/api/admin/appoinment-delete")
    public Appoinment deleteReserve(@RequestBody Appoinment appoinment){
    	AppoinmentService.deleteAppoinment(appoinment.getId());
        return new Appoinment( HttpStatus.OK);
    }
    @GetMapping("/api/admin/appoinment-all")
	public Iterable<Appoinment> showAllUsers() {
		return appoinmentService.showAllAppoinments();
	}
    
    @PutMapping("/api/admin/appoinment-update")
    public Appoinment updateAppoinment(@RequestBody Appoinment appoinment) {
    	Appoinment existAppoinment = appoinmentService.findByEmail(appoinment.getEmail());
        if (existAppoinment != null && !existAppoinment.getId().equals(appoinment.getId())) {
            return new Appoinment (HttpStatus.CONFLICT);
        }
        return new Appoinment (AppoinmentService.updateAppoinment(appoinment), HttpStatus.CREATED);
    }
   
    
    //product
    @PostMapping("/api/admin/treatments-create")
    public Appoinment createDentalServices(@RequestBody Treatments treatments){
        return new Appoinment((StringAppoinment) treatmentsService.saveTreatments(treatments), HttpStatus.CREATED);
    }
//    @GetMapping("api/admin/delete/{email}")
//	public Iterable<Reserve> deleteReserve(@PathVariable String email){
//		return reserveService.deleteUserByEmail(email);
//	}

    @PutMapping("/api/admin/treatments-update")
    public Appoinment updateProduct(@RequestBody Treatments treatments){
        return new Appoinment(treatmentsService.updateTreatments(treatments), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/treatments-delete")
    public Appoinment deleteProduct(@RequestBody Treatments treatments){
    	treatmentsService.deleteTreatments(treatments.getId());
        return new Appoinment(HttpStatus.OK);
    }

    @GetMapping("/api/admin/treatments-all")
    public ResponseEntity<?> findAllProducts(){
        return new ResponseEntity<>(treatmentsService.findAllTreatments(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/treatments-number")
    public Appoinment numberOfTreatments(){
        Long number = treatmentsService.numberOfTreatments();
        StringAppoinment appoinment = new StringAppoinment();
        appoinment.setAppoinment(number.toString());
        return new Appoinment (appoinment, HttpStatus.OK);
    }

    //transaction
    @GetMapping("/api/admin/transaction-all")
    public Appoinment findAllTransactions(){
        return new Appoinment (transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("api/admin/transaction-number")
    public Appoinment numberOfTransactions(){
        Long number = transactionService.numberOfTransactions();
        StringAppoinment appoinment = new StringAppoinment();
        appoinment.setaAppoinment(number.toString());
        return new Appoinment (appoinment, HttpStatus.OK);
    }
}

