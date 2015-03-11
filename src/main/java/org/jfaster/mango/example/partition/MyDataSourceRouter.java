package org.jfaster.mango.example.partition;

import org.jfaster.mango.partition.DataSourceRouter;

/**
 * @author ash
 */
public class MyDataSourceRouter implements DataSourceRouter {

    @Override
    public String getDataSourceName(Object shardParam) {
        if (!(shardParam instanceof Integer)) {
            throw new IllegalArgumentException("Parameter need Integer");
        }
        Integer num = (Integer) shardParam;
        return num % 10 < 5 ? "datasource1" : "datasource2";
    }

}
