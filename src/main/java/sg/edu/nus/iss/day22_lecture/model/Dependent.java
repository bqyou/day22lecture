package sg.edu.nus.iss.day22_lecture.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependent {

    private Integer id;

    private String fullname;

    private String relationship;

    private Date birthDate;

}
