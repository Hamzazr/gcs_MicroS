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
import java.util.stream.Collectors;

@Service
public class GroupCourseService {
    @Autowired
    private GroupCourseRepository groupcRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-GROUPEC";

    public List<GroupCourseResponse> findAll() {

        List<GroupCourse> groups = groupcRepository.findAll();
        //List<Student> student = Arrays.asList(restTemplate.getForObject(this.URL + "/api/student", Student[].class));
        //return student.stream().map(car -> mapToGroupeCResponse(car, clients)).collect(Collectors.toList());
        //ResponseEntity<Student> response = Arrays.asList(restTemplate.getForEntity(this.URL + "/api/student", Student[].class));
        //Student[] students = response.getBody();
        List<Student> student = Arrays.asList(restTemplate.getForObject(this.URL + "/api/student", Student[].class));
        return groups.stream().map((GroupCourse groupc) -> mapToGroupeCResponse (groupc, student)).toList();
        //return groups.stream().map(groupc -> mapToGroupeCResponse(groupc, student).collect(Collectors.toList()));
    }


    private GroupCourseResponse mapToGroupeCResponse(GroupCourse groupC, List<Student> students) {
        Student foundStudent = students.stream()
                .filter(studentt -> studentt.getId().equals(groupC.getId()))
                .findFirst()
                .orElse(null);

        return GroupCourseResponse.builder()
                .id(groupC.getId())
                .name(groupC.getName())
                .student(foundStudent)
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
