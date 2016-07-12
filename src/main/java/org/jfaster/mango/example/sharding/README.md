Sharding
========

Documentation is at http://mango.jfaster.org/sharding.html

TableShardingOrderDao
---------------------

Use TableShardingOrderDaoMain to run TableShardingOrderDao

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

Use DatabaseShardingOrderDaoMain to run DatabaseShardingOrderDao

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

Use ShardingOrderDaoMain to run ShardingOrderDao

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

Use ShardingOrderDao2Main to run ShardingOrder2Dao

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

Use ShardingOrderDao3Main to run ShardingOrder3Dao

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
