package iir5.projet.Etudiant.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCourse {
	 private Long id;
	 private String name;
	 private Long cours;
	 private Long teacher;

}
