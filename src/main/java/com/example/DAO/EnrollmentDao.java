package com.example.DAO;

import com.example.Entities.Enrollment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public class EnrollmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Enrollment> getAllEnrollments() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Enrollment.class).list();
        }finally {

        session.close();}
    }


    public Enrollment addEnrollment(Enrollment enrollment) {
        Session session = sessionFactory.openSession();
        try{
            session.saveOrUpdate(enrollment);
        }
        finally {
        session.close();}
        return enrollment;
    }

    public Enrollment updateEnrollment(Enrollment enrollment){
        Session session = sessionFactory.openSession();
        try{
            long id = enrollment.getId();
            Enrollment e1 = session.get(Enrollment.class, id);
            e1.setStudent(enrollment.getStudent());
            e1.setCourse(enrollment.getCourse());
            e1.setStatus(enrollment.getStatus());
            return e1;
        }finally {

        session.close();}
    }

    public String deleteEnrollment(long id){
        Session session = sessionFactory.openSession();
        try{
            Enrollment id1 = session.get(Enrollment.class, id);
            session.delete(id1);
            return "The Enrollment is deleted succesfully";
        }
        finally {
        session.close();
        }
    }
}
