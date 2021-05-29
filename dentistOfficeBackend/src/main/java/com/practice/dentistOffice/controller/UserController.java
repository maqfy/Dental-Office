package com.practice.dentistOffice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.boot.project.jwt.JwtTokenProvider;
import com.practice.dentistOffice.model.Appoinment;
import com.practice.dentistOffice.model.Role;
import com.practice.dentistOffice.model.Transaction;
import com.practice.dentistOffice.model.Treatments;
import com.practice.dentistOffice.model.User;
import com.practice.dentistOffice.service.AppoinmentService;
import com.practice.dentistOffice.service.TransactionService;
import com.practice.dentistOffice.service.TreatmentsService;
import com.practice.dentistOffice.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private AppoinmentService appoinmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TreatmentsService treatmentsService;

    @Autowired
    private TransactionService transactionService;
    
    @GetMapping("/api/user/search/{name}")
	public Treatments searchTreatments(@PathVariable String name) {
		return treatmentsService.findTreatmentsByname(name);
	}

    @PostMapping("/api/user/registration")
    public Appoinment register(@RequestBody User user){
        if(userService.findByUsername(user.getUsername())!=null){
            return new Appoinment( HttpStatus.CONFLICT);
        }
		//default role.
        user.setRole(Role.USER);
        return new Appoinment (userService.saveUser(user), HttpStatus.CREATED);
    }
    @PostMapping("api/user/appoinment")
    @Transactional
    public String Appoinment(@RequestBody Appoinment appoinment, HttpServletRequest request) {
    	appoinmentService.saveReservation(appoinment);
        return "Hello "+appoinment.getFirstname()+", your Appoinment is successful!";
    }
    @GetMapping("/api/user/appoinment-list")
   	public Iterable<Appoinment> showAllUsers() {
   		return appoinmentService.showAllAppoinments();
   	}

    @GetMapping("/api/user/login")
    public Appoinment getUser(Principal principal){
		//principal = httpServletRequest.getUserPrincipal.
        if(principal == null){
            //logout will also use here so we should return ok http status.
            return Appoinment.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));

        return new Appoinment (user, HttpStatus.OK);
    }

  

    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction){
        transaction.setPurchaseDate(LocalDateTime.now());
         transactionService.saveTransaction(transaction);
         return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/api/user/treatments")
    public Appoinment getAllProducts(){
        return new Appoinment(treatmentsService.findAllTreatment(), HttpStatus.OK);
    }
}
