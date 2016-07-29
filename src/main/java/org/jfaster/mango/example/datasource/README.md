数据源工厂
=========

数据源工厂相关文档请查看 http://mango.jfaster.org/datasource.html

单一数据库
---------

使用 [ArticleMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/ArticleMain.java) 运行 [ArticleDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/ArticleDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

主从数据库
---------

使用 [MasterSlaveArticleMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/MasterSlaveArticleMain.java) 运行 [ArticleDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/ArticleDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

混合数据库集群
------------

使用 [MultipleDatabaseMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/MultipleDatabaseMain.java) 运行 [BlogDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/BlogDao.java) 与 [CommentDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/datasource/CommentDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example_db1** 中创建下面的表

```
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

同时还需要在数据库 **jdbc:mysql://localhost:3306/mango_example_db2** 中创建下面的表

```
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

