package com.example.DAO;

import com.example.Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {


    @Autowired
    private SessionFactory sessionFactory;

    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Student.class).list();
        }finally {

        session.close();}
    }

    public Student addStudent(Student student){
        Session session = sessionFactory.openSession();
        try{
            session.saveOrUpdate(student);
        }finally {
        session.close();}
        return student;
    }

    public Student updateStudent(Student student){
        Session session = sessionFactory.openSession();
        try{
            long id = student.getId();
            Student s1 = session.get(Student.class, "id");
            s1.setEmail(student.getEmail());
            s1.setName(student.getName());
            s1.setPassword(student.getPassword());

        }finally {

        session.close();}
        return student;
    }

    public Student deleteStudent(long id){
        Session session = sessionFactory.openSession();
        try{
            Student s1 = session.get(Student.class, "id");
            session.delete(s1);
            return s1;
        }finally {
        session.close();}
    }
}
