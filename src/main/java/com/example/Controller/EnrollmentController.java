package com.example.Controller;

import com.example.Entities.Enrollment;
import com.example.Service.CourseService;
import com.example.Service.EnrollmentService;
import com.example.Service.StudentService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.hibernate.hql.spi.id.persistent.PersistentTableBulkIdStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Enrollment> getAllEnrollments(){
        return enrollmentService.getAllEnrollments();
    }

    @PostMapping
    public Enrollment addEnroll(@RequestBody Enrollment enrollment){
        studentService.getAllStudents();
        courseService.allCourses();
        return enrollmentService.addEnroll(enrollment);
    }

    @PutMapping
    public Enrollment updateEnroll(@RequestBody Enrollment enrollment){
        return enrollmentService.updateEnrollment(enrollment);
    }

    @DeleteMapping("/{id}")
    public String deleteEnroll(@PathVariable long id){
        return enrollmentService.deleteEnrollment(id);
    }
}
