package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = {"created", "updated"})
public class Case {
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("position")
    private int position;
    @Expose
    @SerializedName("suite_id")
    private int suite_id;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("preconditions")
    private String preconditions;
    @Expose
    @SerializedName("postconditions")
    private String postconditions;
    @Expose
    @SerializedName("created")
    private String created;
    @Expose
    @SerializedName("updated")
    private String updated;
}
