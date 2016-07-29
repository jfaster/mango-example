参数绑定
=======

参数绑定相关文档请查看 http://mango.jfaster.org/binding.html

参数绑定
-------

所有核心源码均在 [BindingUserDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/binding/BindingUserDao.java) 中，使用 [BindingMain](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/binding/BindingMain.java) 运行 [BindingUserDao](https://github.com/jfaster/mango-example/blob/master/src/main/java/org/jfaster/mango/example/binding/BindingUserDao.java)

需要在数据库 **jdbc:mysql://localhost:3306/mango_example** 中创建下面的表

```
DROP TABLE IF EXISTS `binding_user`;
CREATE TABLE `binding_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
