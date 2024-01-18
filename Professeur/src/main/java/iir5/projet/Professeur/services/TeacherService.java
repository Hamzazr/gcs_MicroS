package iir5.projet.Professeur.services;

import iir5.projet.Professeur.entities.Teacher;
import iir5.projet.Professeur.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) throws Exception {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isPresent()) {
            Teacher teacherToUpdate = existingTeacher.get();
            teacherToUpdate.setFirstName(updatedTeacher.getFirstName());
            teacherToUpdate.setLastName(updatedTeacher.getLastName());
            teacherToUpdate.setPhone(updatedTeacher.getPhone());
            teacherToUpdate.setEmail(updatedTeacher.getEmail());
            teacherToUpdate.setSpeciality(updatedTeacher.getSpeciality());

            return teacherRepository.save(teacherToUpdate);
        } else {
            throw new Exception("Student not found");
        }
    }

    public void deleteTeacher(Long id) throws Exception {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            teacherRepository.deleteById(id);
        } else {
            throw new Exception("Teacher not found");
        }
    }
}
