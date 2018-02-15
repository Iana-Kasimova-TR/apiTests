package com.epam.project.model.gist;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by Iana_Kasimova on 14-Feb-18.
 */
@Data
public class File {
    @SerializedName("content")
    String content;

    public File(String content) {
        this.content = content;
    }
}
