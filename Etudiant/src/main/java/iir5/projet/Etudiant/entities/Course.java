package iir5.projet.Etudiant.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String title;
    private String description = "";
}