package org.jfaster.mango.example.cache;

import org.jfaster.mango.annotation.*;
import org.jfaster.mango.operator.cache.Day;

import java.util.List;

@DB
@Cache(prefix = "message", expire = Day.class)
public interface SingleKeyMultiValuesDao {

    @ReturnGeneratedId
    @SQL("insert into message(uid, content) values(:1.uid, :1.content)")
    public int insert(@CacheBy("uid") Message message);

    @SQL("delete from message where uid=:1 and id=:2")
    public int delete(@CacheBy int uid, int id);

    @SQL("update message set content=:1.content where id=:1.id and uid=:1.uid")
    public int update(@CacheBy("uid") Message message);

    @SQL("select id, uid, content from message where uid=:1 order by id")
    public List<Message> getMessages(@CacheBy int uid);

}
