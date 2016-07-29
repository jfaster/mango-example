事务
====

事务相关文档请查看 http://mango.jfaster.org/transaction.html

事务
----

所有核心源码均在 [AccountsDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/transaction/AccountsDao.java) 中，使用 [AccountsMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/transaction/AccountsMain.java) 或 [AccountsMain2](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/transaction/AccountsMain2.java) 运行 [AccountsDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/transaction/AccountsDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `uid` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
