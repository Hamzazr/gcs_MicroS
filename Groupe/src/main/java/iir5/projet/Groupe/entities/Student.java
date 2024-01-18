package iir5.projet.Groupe.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
        private Long id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        @ManyToMany(mappedBy = "students")
        private Set<GroupCourse> groupCourses = new HashSet<>();
}
