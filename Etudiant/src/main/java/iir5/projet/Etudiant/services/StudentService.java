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
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-ETUDIANT";

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) throws Exception {
        Optional<Student> studiant = studentRepository.findById(id);
        if (studiant.isPresent()) {
            return studiant.get();
        } else {
            throw new Exception("Client not found");
        }
    }

    private StudentResponse mapTostudentResponse(Student student, GroupCourse[] groups) {
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




    public List<StudentResponse> findByGroupId(Long groupId) {
        List<Student> students = studentRepository.findByGroupCourseId(groupId);
        ResponseEntity<GroupCourse> response = restTemplate.getForEntity(this.URL + "/api/groupCourses/" + groupId, GroupCourse.class);
        GroupCourse group = response.getBody();

        return students.stream()
                .map(student -> mapTostudentResponse(student, new GroupCourse[]{group}))
                .toList();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) throws Exception {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student studentToUpdate = existingStudent.get();
            studentToUpdate.setFirstName(updatedStudent.getFirstName());
            studentToUpdate.setEmail(updatedStudent.getEmail());
            studentToUpdate.setLastName(updatedStudent.getLastName());
            studentToUpdate.setPhone(updatedStudent.getPhone());

            return studentRepository.save(studentToUpdate);
        } else {
            throw new Exception("Student not found");
        }
    }

    public void deleteClient(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
        } else {
            throw new Exception("Student not found");
        }
    }
}
