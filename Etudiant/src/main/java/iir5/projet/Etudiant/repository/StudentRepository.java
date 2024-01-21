package iir5.projet.Etudiant.repository;



import iir5.projet.Etudiant.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //List<Student> findByGroupCourseId(Long groupId);
}
