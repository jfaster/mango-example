package org.jfaster.mango.example.partition;

import org.jfaster.mango.partition.TablePartition;

public class ModFiveTablePartition implements TablePartition {

    @Override
    public String getPartitionedTable(String table, Object shardParam) {
        if (!(shardParam instanceof Integer)) {
            throw new IllegalArgumentException("Parameter need Integer");
        }
        Integer num = (Integer) shardParam;
        return table + "_" + (num % 5);
    }

}
