查询映射
=======

查询映射相关文档请查看 http://mango.jfaster.org/mapping.html

查询映射
-------

所有核心源码均在 [MappingDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/mapping/MappingDao.java) 中，使用 [MappingMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/mapping/MappingMain.java) 运行 [MappingDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/mapping/MappingDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `mapping_user`;
CREATE TABLE `mapping_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `user_age` int(11) NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

