package iir5.projet.Groupe.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String speciality;
}
