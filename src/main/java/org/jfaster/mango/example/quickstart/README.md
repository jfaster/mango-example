快速开始
========

快速开始相关文档请查看 http://mango.jfaster.org/quickstart.html

HelloWorld
----------

所有的源码均在 [HelloWorld](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/quickstart/HelloWorld.java) 中

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `fruit`;
CREATE TABLE `fruit` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `num` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
