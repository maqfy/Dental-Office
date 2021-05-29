package com.practice.dentistOffice.service;


import java.util.List;

import com.practice.dentistOffice.controller.StringAppoinment;
import com.practice.dentistOffice.model.Appoinment;
import com.practice.dentistOffice.model.User;



public interface UserService {
    User saveUser(User user);
    Appoinment saveMyUser(Appoinment appoinment);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    Long numberOfUsers();
}
