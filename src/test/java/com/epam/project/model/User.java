package com.epam.project.model;

import com.epam.project.model.user.Address;
import com.epam.project.model.user.Company;
import com.epam.project.model.user.Geo;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by anakasimova on 11/02/2018.
 */
@Data
public class User {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("username")
    String username;
    @SerializedName("address")
    Address address;
    @SerializedName("email")
    String email;
    @SerializedName("phone")
    String phone;
    @SerializedName("website")
    String website;
    @SerializedName("company")
    Company company;
    @SerializedName("geo")
    Geo geo;


}
