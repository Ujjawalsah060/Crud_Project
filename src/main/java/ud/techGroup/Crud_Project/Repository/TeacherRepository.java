package ud.techGroup.Crud_Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ud.techGroup.Crud_Project.Entity.Teacher;

import java.util.List;
import java.util.Optional;

@Repository

public interface TeacherRepository  extends JpaRepository<Teacher, Long>  {
     Optional<Teacher> findByIdAndDeletedFalse(Long id);
     List<Teacher> findAllByDeletedFalse();



}
