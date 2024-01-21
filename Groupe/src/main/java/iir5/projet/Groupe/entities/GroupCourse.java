package iir5.projet.Groupe.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
	private Long student;

	//@ManyToMany
	//@JoinTable(
	//		name = "student_group_course",
	//		joinColumns = @JoinColumn(name = "group_course_id"),
	//		inverseJoinColumns = @JoinColumn(name = "student_id")
	//)
	//private List<Student> students = new ArrayList<>();

	//private Set<Student> students = new HashSet<>();

}
