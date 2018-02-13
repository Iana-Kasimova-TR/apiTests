package com.epam.project.model.user;

import lombok.Data;

/**
 * Created by anakasimova on 11/02/2018.
 */
@Data
public class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
}
