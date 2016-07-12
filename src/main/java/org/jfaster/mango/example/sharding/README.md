Sharding
========

Documentation is at http://mango.jfaster.org/sharding.html

TableShardingOrderDao
---------------------

Use [TableShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/TableShardingOrderDaoMain.java) to run [TableShardingOrderDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/TableShardingOrderDao.java)

Need to create the following table on database **mango_example**

```
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

DatabaseShardingOrderDao
------------------------

Use [DatabaseShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/DatabaseShardingOrderDaoMain.java) to run [DatabaseShardingOrderDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/DatabaseShardingOrderDao.java)

Need to create the following table on **both** database **mango_example_db1** and **mango_example_db2**

```
CREATE TABLE `t_order` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

ShardingOrderDao
----------------

Use [ShardingOrderDaoMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDaoMain.java) to run [ShardingOrderDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDao.java)

Need to create the following table on **both** database **mango_example_db1** and **mango_example_db2**

```
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

ShardingOrder2Dao
-----------------

Use [ShardingOrderDao2Main](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDao2Main.java) to run [ShardingOrder2Dao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrder2Dao.java)

Need to create the following table on **both** database **mango_example_db1** and **mango_example_db2**

```
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

ShardingOrder3Dao
-----------------

Use [ShardingOrderDao3Main](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrderDao3Main.java) to run [ShardingOrder3Dao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/sharding/ShardingOrder3Dao.java)

Need to create the following table on **both** database **mango_example_db1** and **mango_example_db2**

```
CREATE TABLE `t_order_0` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

```
CREATE TABLE `t_order_1` (
  `id` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
