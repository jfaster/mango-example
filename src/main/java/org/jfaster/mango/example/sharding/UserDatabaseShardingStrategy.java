package org.jfaster.mango.example.sharding;

import org.jfaster.mango.sharding.DatabaseShardingStrategy;

public class UserDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

    @Override
    public String getDatabase(Integer uid) {
        return "db" + (uid % 2 + 1);
    }

}
