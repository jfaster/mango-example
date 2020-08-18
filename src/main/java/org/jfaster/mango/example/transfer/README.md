函数式调用
=========

函数式调用相关文档请查看 http://mango.jfaster.org/functional.html

列表与字符串互转
--------------

使用 [TeacherMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/functional/TeacherMain.java) 运行 [TeacherDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/functional/TeacherDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `student_ids` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

枚举与数字互转
------------

使用 [PersonMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/functional/PersonMain.java) 运行 [PersonDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/functional/PersonDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `gender` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

复杂类与字符串互转
---------------

使用 [CardMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/functional/CardMain.java) 运行 [CardDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/functional/CardDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `sub_card` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
