package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("parent_id")
    private int parentId;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("preconditions")
    private String preconditions;
}
