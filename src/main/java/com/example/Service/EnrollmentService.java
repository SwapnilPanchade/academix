package com.example.Service;

import com.example.DAO.EnrollmentDao;
import com.example.Entities.Enrollment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.ResourceReaderRepositoryPopulatorBeanDefinitionParser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentDao enrollmentDao;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentDao.getAllEnrollments();
    }

    public Enrollment addEnroll(Enrollment enrollment) {
        return enrollmentDao.addEnrollment(enrollment);
    }


    public Enrollment updateEnrollment(Enrollment enrollment) {
        return enrollmentDao.updateEnrollment(enrollment);
    }
    public String deleteEnrollment(long id){
        return enrollmentDao.deleteEnrollment(id);
    }

    public Enrollment getById(long id) {
        return enrollmentDao.getById(id);
    }
}
