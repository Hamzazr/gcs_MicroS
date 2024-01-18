package iir5.projet.Groupe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GroupCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Long cours;
	private Long teacher;

	// Establishing many-to-many relationship with Student
	@ManyToMany
	@JoinTable(
			name = "group_course_student",
			joinColumns = @JoinColumn(name = "group_course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	private Set<Student> students = new HashSet<>();

}
