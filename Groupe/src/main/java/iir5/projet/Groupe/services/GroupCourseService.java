package iir5.projet.Groupe.services;

import iir5.projet.Groupe.entities.GroupCourse;
import iir5.projet.Groupe.entities.Student;
import iir5.projet.Groupe.entities.Course;
import iir5.projet.Groupe.entities.Teacher;
import iir5.projet.Groupe.model.GroupCourseResponse;
import iir5.projet.Groupe.repository.GroupCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GroupCourseService {
    @Autowired
    private GroupCourseRepository groupcRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-GROUPEC";

    public List<GroupCourseResponse> findAll() {
        List<GroupCourse> groups = groupcRepository.findAll();
        ResponseEntity<Student[]> response = restTemplate.getForEntity(this.URL + "/api/student", Student[].class);
        Student[] students = response.getBody();
        return groups.stream().map((GroupCourse groupc) -> mapToGroupeCResponse (groupc, students)).toList();
    }


    private GroupCourseResponse mapToGroupeCResponse(GroupCourse groupC, Student[] students) {
        Student foundStudent = Arrays.stream(students)
                .filter(studentt -> studentt.getId().equals(groupC.getId()))
                .findFirst()
                .orElse(null);

        return GroupCourseResponse.builder()
                .id(groupC.getId())
                .name(groupC.getName())

                .build();
    }

    public GroupCourseResponse findById(Long id) throws Exception {
        GroupCourse groupeC = groupcRepository.findById(id).orElseThrow(() -> new Exception("Invalid GroupCourse Id"));
        Student student = restTemplate.getForObject(this.URL + "/api/students" + groupeC.getId(), Student.class);
        return GroupCourseResponse.builder()
                .id(groupeC.getId())
                .name(groupeC.getName())
                .student(student)
                .build();
    }


}
