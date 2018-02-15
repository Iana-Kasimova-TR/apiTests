package com.epam.project.model.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by anakasimova on 11/02/2018.
 */
@Data
public class Geo {
    @SerializedName("lat")
    String lat;
    @SerializedName("lng")
    String lng;
}
