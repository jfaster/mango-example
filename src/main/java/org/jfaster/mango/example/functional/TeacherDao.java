package org.jfaster.mango.example.functional;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB
public interface TeacherDao {

    @ReturnGeneratedId
    @SQL("insert into teacher(name, student_ids) values(:name, :studentIds)")
    public int addTeacher(Teacher t);

    @SQL("select name, student_ids from teacher where id = :1")
    public Teacher getTeacherById(int id);

}
