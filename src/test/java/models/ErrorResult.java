package models;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ErrorResult {
    @Expose
    boolean status;
    @Expose
    ArrayList<ErrorFields> errorFields;
}
