package iir5.projet.Groupe.controllers;

import iir5.projet.Groupe.entities.GroupCourse;
import iir5.projet.Groupe.repository.GroupCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/groups")
public class GroupCourseController {

    private final GroupCourseRepository groupCourseRepository;

    @Autowired
    public GroupCourseController(GroupCourseRepository groupCourseRepository) {
        this.groupCourseRepository = groupCourseRepository;
    }

    @GetMapping
    public List<GroupCourse> getAllGroupCourses() {
        return groupCourseRepository.findAll();
    }

    @GetMapping("/{id}")
    public GroupCourse getGroupCourseById(@PathVariable Long id) {
        return groupCourseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public GroupCourse createGroupCourse(@RequestBody GroupCourse groupCourse) {
        return groupCourseRepository.save(groupCourse);
    }

    @PutMapping("/{id}")
    public GroupCourse updateGroupCourse(@PathVariable Long id, @RequestBody GroupCourse updatedGroupCourse) {
        if (groupCourseRepository.existsById(id)) {
            updatedGroupCourse.setId(id);
            return groupCourseRepository.save(updatedGroupCourse);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteGroupCourse(@PathVariable Long id) {
        groupCourseRepository.deleteById(id);
    }


}
