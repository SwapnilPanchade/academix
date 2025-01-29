package com.example.Service;

import com.example.DAO.StudentDao;
import com.example.Entities.Student;
import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student addStudent(Student student) {
        return studentDao.addStudent(student);
    }
    public Student updateStudent(Student student){
        return studentDao.updateStudent(student);
    }

    public Student deleteStudent(long id){
        return studentDao.deleteStudent(id);
    }
}
