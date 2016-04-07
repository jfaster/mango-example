package org.jfaster.mango.example.partition;

import org.jfaster.mango.partition.DataSourceRouter;

public class MyDataSourceRouter implements DataSourceRouter<Integer> {

    @Override
    public String getDataSourceName(Integer shardParam, int type) {
        return shardParam % 10 < 5 ? "datasource1" : "datasource2";
    }

}
