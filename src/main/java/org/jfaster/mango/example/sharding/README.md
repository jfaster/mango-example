表分片与数据库分片(分表与分库)
=========================

分片相关文档请查看 http://mango.jfaster.org/sharding.html

表分片
-----

使用 [TableShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/TableShardingOrderDaoMain.java) 运行 [TableShardingOrderDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/TableShardingOrderDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

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

使用 [DatabaseShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/DatabaseShardingOrderDaoMain.java) 运行 [DatabaseShardingOrderDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/DatabaseShardingOrderDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example_db1** 与数据库 **jdbc:mysql://localhost:3306/mango_example_db2** 中同时创建下面的表

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

使用 [ShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDaoMain.java) 运行 [ShardingOrderDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example_db1** 与数据库 **jdbc:mysql://localhost:3306/mango_example_db2** 中同时创建下面的表

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

使用 [ShardingOrderDao2Main](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDao2Main.java) 运行 [ShardingOrder2Dao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrder2Dao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example_db1** 与数据库 **jdbc:mysql://localhost:3306/mango_example_db2** 中同时创建下面的表

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

使用 [ShardingOrderDao3Main](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDao3Main.java) 运行 [ShardingOrder3Dao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrder3Dao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example_db1** 与数据库 **jdbc:mysql://localhost:3306/mango_example_db2** 中同时创建下面的表

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
