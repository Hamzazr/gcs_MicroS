package iir5.projet.Cours.repository;


import iir5.projet.Cours.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
