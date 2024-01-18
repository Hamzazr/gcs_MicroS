package iir5.projet.Professeur.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String speciality;
}
