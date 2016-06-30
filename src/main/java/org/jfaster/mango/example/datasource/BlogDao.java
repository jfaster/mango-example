package org.jfaster.mango.example.datasource;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB(database = "db1")
public interface BlogDao {

    @ReturnGeneratedId
    @SQL("insert into blog(uid, title, content) values(:uid, :title, :content)")
    int addBlog(Blog blog);

    @SQL("select id, uid, title, content from blog where id = :1")
    Blog getBlog(int id);

}
