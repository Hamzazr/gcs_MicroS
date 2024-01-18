package iir5.projet.Groupe.repository;

import iir5.projet.Groupe.entities.GroupCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCourseRepository extends JpaRepository<GroupCourse, Long> {
}

