package org.jfaster.mango.example.datasource;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;

/**
 * @author ash
 */
@DB
public interface ArticleDao {

    @ReturnGeneratedId
    @SQL("insert into article(uid, title, content) values(:uid, :title, :content)")
    public int addArticle(Article article);

    @SQL("select id, uid, title, content from article where id = :1")
    public Article getArticle(int id);

}
