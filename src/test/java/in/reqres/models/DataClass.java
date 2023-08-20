package in.reqres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataClass {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}
