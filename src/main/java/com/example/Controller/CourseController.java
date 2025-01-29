package com.example.Controller;

import com.example.DAO.CourseDao;
import com.example.Entities.Course;
import com.example.Service.CourseService;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseReactiveDataAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> allCourses(){
        return courseService.allCourses();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable long id, @RequestBody Course course){
        return courseService.updateCourse(id , course);
    }

    @DeleteMapping("/{id}")
    public Course deleteCourse(@PathVariable long id){
        return courseService.deleteCourseById(id);
    }
}
