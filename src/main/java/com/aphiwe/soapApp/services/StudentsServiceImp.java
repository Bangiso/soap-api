package com.aphiwe.soapApp.services;
import com.aphiwe.soapApp.daos.StudentsDao;
import com.aphiwe.soapApp.models.Student;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService(endpointInterface = "com.aphiwe.soapApp.services.StudentsService")
public class StudentsServiceImp implements StudentsService{

    private static final Logger logger = LoggerFactory.getLogger(StudentsServiceImp.class);
    private static final DataSource ds = createConnection();
    private static final DBI dbi = new DBI(ds);

    @Inject
    private StudentsDao studentsDao = dbi.open(StudentsDao.class);

    public StudentsServiceImp(){};

    @WebMethod
    @Override
    public  Student getStudent(int id) {
        return studentsDao.findById(id);
    }

    @WebMethod
    @Override
    public List<Student> getStudentS(){
        return studentsDao.getAll();
    }

    @WebMethod
    @Override
    public boolean saveStudent(Student student) {
        try{
            int ret = studentsDao.insert(student);
            return ret>0;
        } catch (Throwable ex){
            logger.info(ex.getMessage());
            return false;
        }
    }

    @WebMethod
    @Override
    public boolean updateStudent(Student student) {
        try{
            int ret = studentsDao.update(student);
            return ret>0;
        } catch (Throwable ex){
            logger.info(ex.getMessage());
            return false;
        }
    }

    @WebMethod
    @Override
    public boolean deleteStudent(int id) {
        try{
            int ret = studentsDao.deleteById(id);
            return ret>0;
        } catch (Throwable ex){
            logger.info(ex.getMessage());
            return false;
        }
    }

    private static DataSource createConnection(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("test1234");
        dataSource.setUrl("jdbc:mysql://localhost:3306/StudentDB");
        dataSource.setMaxActive(10);
        dataSource.setMaxIdle(5);
        dataSource.setInitialSize(5);
        dataSource.setValidationQuery("SELECT 1");
        return dataSource;
    }

}
