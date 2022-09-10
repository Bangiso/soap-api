package com.aphiwe.soapApp.daos;

import com.aphiwe.soapApp.models.Student;
import com.aphiwe.soapApp.utils.StudentMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(StudentMapper.class)
public interface StudentsDao{
    @SqlQuery("select id, name, gpa from students;")
    List<Student> getAll();
    @SqlQuery("select id, name, gpa from students where id = :id;")
    Student findById(@Bind("id") int id);
    @SqlUpdate("delete from students where id = :id;")
    int deleteById(@Bind("id") int id);
    @SqlUpdate("update students set name = :name, gpa=:gpa where id = :id;")
    int update(@BindBean Student student);
    @SqlUpdate("insert into students (id, name, gpa) values (:id, :name, :gpa);")
    int insert(@BindBean Student student);
}
