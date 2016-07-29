集成缓存
=======

集成缓存相关文档请查看 http://mango.jfaster.org/cache.html

单key取单值
----------

使用 [SingleKeySingeValueMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/cache/SingleKeySingeValueMain.java) 运行 [SingleKeySingeValueDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/cache/SingleKeySingeValueDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

单key取多值
----------

使用 [SingleKeyMultiValuesMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/cache/SingleKeyMultiValuesMain.java) 运行 [SingleKeyMultiValuesDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/cache/SingleKeyMultiValuesDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `key_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

多key取多值
----------

使用 [MultiKeysMultiValuesMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/cache/MultiKeysMultiValuesMain.java) 运行 [MultiKeysMultiValuesDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/cache/MultiKeysMultiValuesDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```