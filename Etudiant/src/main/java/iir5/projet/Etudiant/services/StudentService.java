package iir5.projet.Etudiant.services;

import iir5.projet.Etudiant.entities.GroupCourse;
import iir5.projet.Etudiant.entities.Student;
import iir5.projet.Etudiant.model.StudentResponse;
import iir5.projet.Etudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-ETUDIANT";

    public List<StudentResponse> findAll() {
        List<Student> cars = studentRepository.findAll();
        ResponseEntity<GroupCourse[]> response = restTemplate.getForEntity(this.URL + "/api/students", GroupCourse[].class);
        GroupCourse[] groupeC = response.getBody();
        return cars.stream().map((Student student) -> mapToCarResponse(student, groupeC)).toList();
    }

    private StudentResponse mapToCarResponse(Student student, GroupCourse[] groups) {
        GroupCourse foundGroupe = Arrays.stream(groups)
                .filter(groupe -> groupe.getId().equals(groupe.getId()))
                .findFirst()
                .orElse(null);

        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .phone(student.getPhone())
                .email(student.getEmail())
                .groups(foundGroupe)
                .build();
    }


    public StudentResponse findById(Long id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new Exception("Invalid Etudiant Id"));
        GroupCourse groupeC = restTemplate.getForObject(this.URL + "/api/students" + student.getId(), GroupCourse.class);
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .phone(student.getPhone())
                .email(student.getEmail())
                .groups(groupeC)
                .build();
    }
}
