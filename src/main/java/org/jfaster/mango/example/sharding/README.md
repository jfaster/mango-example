表分片与数据库分片(分表与分库)
=========================

分片相关文档请查看 http://mango.jfaster.org/sharding.html

表分片
-----

入口类 [TableShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/TableShardingOrderDaoMain.java)

需要在下面的数据库中

- **jdbc:mysql://localhost:3306/mango_example**

创建下面的表

```
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

数据库分片
--------

入口类 [DatabaseShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/DatabaseShardingOrderDaoMain.java)

需要在下面的3个数据库中

- **jdbc:mysql://localhost:3306/db0**
- **jdbc:mysql://localhost:3306/db1**
- **jdbc:mysql://localhost:3306/db2** 

同时创建下面的表

```
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

同时使用数据库分片与表分片
---------------------

入口类 [ShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDaoMain.java)

需要在下面的3个数据库中

- **jdbc:mysql://localhost:3306/db0**
- **jdbc:mysql://localhost:3306/db1**
- **jdbc:mysql://localhost:3306/db2** 

同时创建下面的表

```
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

精简分片代码
----------

入口类 [SmartShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/SmartShardingOrderDaoMain.java) 

需要在下面的3个数据库中

- **jdbc:mysql://localhost:3306/db0**
- **jdbc:mysql://localhost:3306/db1**
- **jdbc:mysql://localhost:3306/db2** 

同时创建下面的表

```
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

多维度分片策略
------------

入口类 [MultiDimenShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/MultiDimenShardingOrderDaoMain.java) 

需要在下面的3个数据库中

- **jdbc:mysql://localhost:3306/db0**
- **jdbc:mysql://localhost:3306/db1**
- **jdbc:mysql://localhost:3306/db2** 

同时创建下面的表

```
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
