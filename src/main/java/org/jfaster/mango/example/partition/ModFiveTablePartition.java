package org.jfaster.mango.example.partition;

import org.jfaster.mango.partition.TablePartition;

public class ModFiveTablePartition implements TablePartition<Integer> {

    @Override
    public String getPartitionedTable(String table, Integer shardParam, int type) {
        return table + "_" + (shardParam % 5);
    }

}
