基本操作
=======

基本操作相关文档请查看 http://mango.jfaster.org/basic.html

基本操作
-------

所有核心源码均在 [UserDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/basic/UserDao.java) 中，使用 [UserMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/basic/UserMain.java) 运行 [UserDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/basic/UserDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `money` bigint(21) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
