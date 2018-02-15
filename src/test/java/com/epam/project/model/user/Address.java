package com.epam.project.model.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by anakasimova on 11/02/2018.
 */
@Data
public class Address {
    @SerializedName("street")
    String street;
    @SerializedName("suite")
    String suite;
    @SerializedName("city")
    String city;
    @SerializedName("zipcode")
    String zipcode;
    @SerializedName("go")
    Geo geo;
}
