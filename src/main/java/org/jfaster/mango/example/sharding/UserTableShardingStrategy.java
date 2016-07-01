package org.jfaster.mango.example.sharding;

import org.jfaster.mango.sharding.TableShardingStrategy;

public class UserTableShardingStrategy implements TableShardingStrategy<Integer> {

    @Override
    public String getTargetTable(String table, Integer uid) {
        return table + "_" + (uid % 2);
    }

}
