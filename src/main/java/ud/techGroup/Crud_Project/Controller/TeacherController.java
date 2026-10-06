package ud.techGroup.Crud_Project.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ud.techGroup.Crud_Project.Entity.Teacher;
import ud.techGroup.Crud_Project.Services.TeacherServices;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController{

    private TeacherServices teacherServices;

    public TeacherController(TeacherServices teacherServices) {
        this.teacherServices = teacherServices;
    }
    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher( @RequestBody  Teacher teacherReq){

        Teacher createdTeacher= teacherServices.createTeacher(teacherReq);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);


    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable Long id){
        Teacher teacherResp = teacherServices.getTeacher(id);

        if(teacherResp == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(teacherResp);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
       List<Teacher>  teacherList = teacherServices.getAllTeacher();

       if(teacherList.isEmpty()){
           return null;
       }
       return ResponseEntity.ok(teacherList);

    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Teacher> updateTeacherDetails(@PathVariable Long id ,
                                                        @RequestBody Teacher teacherReq){
        Teacher updateTeacher = teacherServices.updateTeacherDetails(id , teacherReq) ;

        if(updateTeacher == null){
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(updateTeacher);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id){
        Boolean isDeleted = teacherServices.deleteTeacher(id);

        if(isDeleted == true){
            return ResponseEntity.ok("reord is deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/soft_delete_teacher/{id}")
    public ResponseEntity<String> softDeleteTeacher( @PathVariable Long id){
        Boolean isDeleted = teacherServices.softDeleteTeacher(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Reocrd is softly deleted");
    }
}

