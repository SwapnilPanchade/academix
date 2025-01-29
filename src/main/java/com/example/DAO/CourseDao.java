package com.example.DAO;

import com.example.Entities.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Course> allCourses() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Course.class).list();
        } finally {
            session.close();
        }
    }

    @Transactional
    public Course addCourse(Course course) {
        Session session = sessionFactory.openSession();
        try {
            session.saveOrUpdate(course);
        } finally {
            session.close();
        }
        return course;
    }

    @Transactional
    public Course updateCourse(long id, Course course) {
        Session session = sessionFactory.openSession();
        Course course1 = null;
        try {
            course1 = session.get(Course.class, "id");
            course1.setTitle(course.getTitle());
            course1.setCoursePrice(course.getCoursePrice());
            course1.setDescription(course.getDescription());
            course1.setDuration(course.getDuration());
        } finally {

            session.close();
        }
        return course;
    }

    @Transactional
    public Course deleteCourse(long id){
        Session session = sessionFactory.openSession();
        try{
            Course course = session.get(Course.class, "id");
            session.delete(course);
            return course;
        }finally {
        session.close();}
    }
}
