package com.aphiwe.soapApp.services;

import com.aphiwe.soapApp.models.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface StudentsService {

    @WebMethod
    public Student getStudent(int id);
    @WebMethod
    public List<Student> getStudentS();
    @WebMethod
    public boolean saveStudent(Student student);
    @WebMethod
    public boolean updateStudent(Student student);
    @WebMethod
    public boolean deleteStudent(int id);
}
