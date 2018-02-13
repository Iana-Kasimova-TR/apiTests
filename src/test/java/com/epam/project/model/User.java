package com.epam.project.model;

import com.epam.project.model.user.Address;
import com.epam.project.model.user.Company;
import lombok.Data;

/**
 * Created by anakasimova on 11/02/2018.
 */
@Data
public class User {

    String id;
    String name;
    String username;
    Address address;
    String email;
    String phone;
    String website;
    Company company;


}
