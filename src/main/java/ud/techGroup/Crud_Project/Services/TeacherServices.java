package ud.techGroup.Crud_Project.Services;


import org.springframework.stereotype.Service;
import ud.techGroup.Crud_Project.Entity.Teacher;
import ud.techGroup.Crud_Project.Repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service

public class TeacherServices {

    private TeacherRepository teacherRepository;

    public TeacherServices(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacherReq){
        teacherReq.setDeleted(false);

        Teacher teacherResp = teacherRepository.save (teacherReq);
        return  teacherResp;


    }

    public Teacher getTeacher(Long id){
        Optional<Teacher> teacherResp = teacherRepository.findByIdAndDeletedFalse(id);
        if(teacherResp.isPresent()){
            return teacherResp.get();
        }
        return null;
    }

    public List<Teacher> getAllTeacher(){
        List<Teacher> teacherList = teacherRepository.findAllByDeletedFalse();
        return teacherList;
    }

    public Teacher updateTeacherDetails(Long  id,  Teacher teacherReq){
        Optional<Teacher> updatTeachers = teacherRepository.findByIdAndDeletedFalse(id);

        if(updatTeachers.isEmpty()){
            return  null;
        }
        Teacher teacherToSave = updatTeachers.get();
        teacherToSave.setAddress(teacherReq.getAddress());
        teacherToSave.setDepartment(teacherReq.getDepartment());
        teacherToSave.setName(teacherReq.getName());
        teacherToSave.setSubject(teacherReq.getSubject());
        teacherToSave.setFaculty(teacherReq.getFaculty());

        return  teacherRepository.save(teacherToSave);

    }

    public Boolean deleteTeacher(Long id){
        Boolean isDeleted = teacherRepository.existsById(id);
        if(!isDeleted){
            return  false;

        }
        teacherRepository.deleteById(id);
        return true;
    }

    public Boolean softDeleteTeacher( Long id){
        Optional<Teacher> teacherUpdate = teacherRepository.findByIdAndDeletedFalse(id);
        if(teacherUpdate.isEmpty()){
            return false;
        }
        Teacher teacherToSave = teacherUpdate.get();
        teacherToSave.setDeleted(true);
        teacherRepository.save(teacherToSave);
        return true;
    }


}
