package iir5.projet.Cours.controllers;

import iir5.projet.Cours.entities.Course;
import iir5.projet.Cours.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courRepository) {
        this.courseRepository = courRepository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course student) {
        return courseRepository.save(student);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        if (courseRepository.existsById(id)) {
            updatedCourse.setId(id);
            return courseRepository.save(updatedCourse);
        }
        return null; // Or handle the case where the student with the given ID doesn't exist
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}
