package com.example.Service;

import com.example.DAO.CourseDao;
import com.example.Entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> allCourses() {
        return courseDao.allCourses();
    }

    public Course addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    public Course updateCourse(long id, Course course) {
        return courseDao.updateCourse(id , course);
    }

    public Course deleteCourseById(long id) {
        return courseDao.deleteCourse(id);
    }
}
