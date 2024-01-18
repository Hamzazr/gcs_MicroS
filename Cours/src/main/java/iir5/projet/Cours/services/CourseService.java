package iir5.projet.Cours.services;

import iir5.projet.Cours.entities.Course;
import iir5.projet.Cours.entities.GroupCourse;
import iir5.projet.Cours.model.CourseResponse;
import iir5.projet.Cours.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    private final String URL = "http://localhost:8888/SERVICE-COURSE";

    public List<Course> findAll() {
        return courseRepository.findAll();
    }


    public CourseResponse findById(Long id) throws Exception {
        Course course = courseRepository.findById(id).orElseThrow(() -> new Exception("Invalid Cours Id"));
        return CourseResponse.builder()
                .id(course.getId())
                .title(course.getDescription())
                .build();
    }


    public Course addcourse(Course cours) {
        return courseRepository.save(cours);
    }

    public Course updateCourse(Long id, Course updatedCourse) throws Exception {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course courseToUpdate = existingCourse.get();
            courseToUpdate.setTitle(updatedCourse.getTitle());
            courseToUpdate.setDescription(updatedCourse.getDescription());


            return courseRepository.save(courseToUpdate);
        } else {
            throw new Exception("Course not found");
        }
    }

    public void deleteCourse(Long id) throws Exception {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.deleteById(id);
        } else {
            throw new Exception("Course not found");
        }
    }
}
