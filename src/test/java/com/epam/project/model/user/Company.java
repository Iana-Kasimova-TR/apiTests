package com.epam.project.model.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by anakasimova on 11/02/2018.
 */
@Data
public class Company {
    @SerializedName("name")
    String name;
    @SerializedName("catchPhrase")
    String catchPhrase;
    @SerializedName("bs")
    String  bs;
}
