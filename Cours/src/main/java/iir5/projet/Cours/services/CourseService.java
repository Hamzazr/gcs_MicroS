package iir5.projet.Cours.services;

import iir5.projet.Cours.entities.Course;
import iir5.projet.Cours.entities.GroupCourse;
import iir5.projet.Cours.model.CourseResponse;
import iir5.projet.Cours.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-COURSE";


    public CourseResponse findById(Long id) throws Exception {
        Course course = courseRepository.findById(id).orElseThrow(() -> new Exception("Invalid Cours Id"));
        return CourseResponse.builder()
                .id(course.getId())
                .title(course.getDescription())
                .build();
    }
}
