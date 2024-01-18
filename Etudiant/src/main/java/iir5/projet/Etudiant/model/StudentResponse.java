package iir5.projet.Etudiant.model;

import iir5.projet.Etudiant.entities.GroupCourse;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private GroupCourse groups;
}
