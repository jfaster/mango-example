package org.jfaster.mango.example;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

@DB(table = "card")
public interface CardDao {

    @SQL("select content from #table where id=:1")
    public String getContentById(int id);

    @SQL("insert into #table values(:1, :2)")
    public int insert(int id, String content);

}