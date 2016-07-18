package org.jfaster.mango.example.functional;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB
public interface PersonDao {

    @ReturnGeneratedId
    @SQL("insert into person(name, gender) values(:name, :gender)")
    public int addPerson(Person p);

    @SQL("select name, gender from person where id = :1")
    public Person getPersonById(int id);

}
