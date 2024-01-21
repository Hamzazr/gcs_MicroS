package iir5.projet.Etudiant.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String firstName;
	 private String lastName;
	 private String phone;
	 private String email;
	 //private Long idGroup;





}
