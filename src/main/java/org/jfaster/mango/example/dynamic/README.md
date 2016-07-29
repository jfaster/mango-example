动态SQL
=======

动态SQL相关文档请查看 http://mango.jfaster.org/dynamic.html

动态SQL
-------

所有核心源码均在 [UserDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/dynamic/UserDao.java) 中，使用 [UserMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/dynamic/UserMain.java) 运行 [UserDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/dynamic/UserDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

