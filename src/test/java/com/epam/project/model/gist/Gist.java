package com.epam.project.model.gist;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Map;


/**
 * Created by Iana_Kasimova on 14-Feb-18.
 */
@Data
public class Gist {
    @SerializedName("description")
    String description;
    @SerializedName("public")
    boolean publicOrNot;
    @SerializedName("files")
    Map<String, File> files;

    public Gist(String description, boolean publicOrNot, Map<String, File> files) {
        this.description = description;
        this.publicOrNot = publicOrNot;
        this.files = files;
    }
}
