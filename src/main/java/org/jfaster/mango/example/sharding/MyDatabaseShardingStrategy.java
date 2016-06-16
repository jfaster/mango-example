package org.jfaster.mango.example.sharding;

import org.jfaster.mango.sharding.DatabaseShardingStrategy;

public class MyDatabaseShardingStrategy implements DatabaseShardingStrategy<Integer> {

    @Override
    public String getDatabase(Integer shardingParameter) {
        return shardingParameter % 10 < 5 ? "datasource1" : "datasource2";
    }

}
