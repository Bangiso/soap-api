package com.aphiwe.soapApp.utils;

import com.aphiwe.soapApp.models.Student;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper  implements ResultSetMapper<Student>{

    public Student map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException    {
        return  new Student(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getDouble("gpa"));
    }
}
