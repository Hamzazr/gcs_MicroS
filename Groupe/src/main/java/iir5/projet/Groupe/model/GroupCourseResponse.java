package iir5.projet.Groupe.model;

import iir5.projet.Groupe.entities.Course;
import iir5.projet.Groupe.entities.Student;
import iir5.projet.Groupe.entities.Teacher;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCourseResponse {
    private Long id;
    private String name;
    private Teacher teacherid;
    private Course cours;
    private Student student;


}
