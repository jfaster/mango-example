package org.jfaster.mango.example.mapping;

import org.jfaster.mango.jdbc.AbstractRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ash
 */
public class UserMapper extends AbstractRowMapper<MappingUser> {

    @Override
    public MappingUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        MappingUser u = new MappingUser();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setUserAge(rs.getInt("userAge"));
        u.setUpdateTime(rs.getTimestamp("updateTime"));
        return u;
    }

}
