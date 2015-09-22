package org.jfaster.mango.example.function.generic;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB
public interface PersonDao {

    @ReturnGeneratedId
    @SQL("insert into person(name, gender, card) values(:name, :gender, :card)")
    public int addPerson(Person p);

    @SQL("select id, name, gender, card from person where id = :1")
    public Person getPersonById(int id);

}
