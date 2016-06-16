package org.jfaster.mango.example.sharding;

import org.jfaster.mango.sharding.TableShardingStrategy;

public class ModFiveTableShardingStrategy implements TableShardingStrategy<Integer> {

    @Override
    public String getTargetTable(String table, Integer shardingParameter) {
        return table + "_" + (shardingParameter % 5);
    }

}
