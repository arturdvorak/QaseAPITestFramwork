package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorFields {
    @Expose
    @SerializedName("field")
    private String errorField;
    @Expose
    @SerializedName("error")
    private String errorMessage;
}
