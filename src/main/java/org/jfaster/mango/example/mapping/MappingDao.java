package org.jfaster.mango.example.mapping;

import org.jfaster.mango.annotation.*;

import java.util.List;

/**
 * @author ash
 */
@DB
public interface MappingDao {

    @ReturnGeneratedId
    @SQL("insert into mapping_user(name, user_age, update_time) values(:name, :userAge, :updateTime)")
    public int addMappingUser(MappingUser u);

    @SQL("select name from mapping_user where id = :1")
    public String getNameById(int id);

    @SQL("select id from mapping_user limit :1")
    public List<Integer> getIdsLimit(int limit);

    @SQL("select id, name, user_age, update_time from mapping_user where id = :1")
    public MappingUser getMappingUserById(int id);

    @SQL("select id, name, user_age, update_time from mapping_user where id in (:1)")
    public List<MappingUser> getMappingUsersById(List<Integer> ids);

    @Results({
            @Result(column = "id", property = "userId"),
            @Result(column = "name", property = "userName")
    })
    @SQL("select id, name, user_age, update_time from mapping_user where id = :1")
    public MappingUser2 getMappingUser2ById(int id);

    @Results({
            @Result(column = "id", property = "userId"),
            @Result(column = "name", property = "userName")
    })
    @SQL("select id, name, user_age, update_time from mapping_user where id in (:1)")
    public List<MappingUser2> getMappingUsers2ById(List<Integer> ids);

    @Mapper(UserMapper.class)
    @SQL("select id, name, user_age, update_time from mapping_user where id = :1")
    public MappingUser getMappingUserByIdMapper(int id);

    @Mapper(UserMapper.class)
    @SQL("select id, name, user_age, update_time from mapping_user where id in (:1)")
    public List<MappingUser> getMappingUsersByIdMapper(List<Integer> ids);

}
