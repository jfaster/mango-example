package org.jfaster.mango.example.cache;

import org.jfaster.mango.annotation.Cache;
import org.jfaster.mango.annotation.CacheBy;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.operator.cache.Hour;

/**
 * @author ash
 */
@DB
@Cache(prefix = "user", expire = Hour.class, num = 2)
public interface MultiParameterSingleKeyDao {

    @SQL("select uid, name from user where uid=:1 and name=:2")
    public User getByUidAndName(@CacheBy int uid, @CacheBy String name);

    @SQL("select uid, name from user where uid=:1.uid and name=:1.name")
    public User getByUidAndName(@CacheBy("uid,name") User user);

}
