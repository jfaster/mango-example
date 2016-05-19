table

```
CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `key_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
