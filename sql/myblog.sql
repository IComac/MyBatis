# ************************************************************
# MySQL: 5.7
# Database: mysql
# Generation Time: 2019-04-13 11:24:33 +0000
# ************************************************************

# 这里引号有区别。一个是``反引号，一个是''引号
# /**/结尾都要以分号结尾

# Dump of table article
# ------------------------------------------------------------

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
	`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	`author_id` int(11) NOT NULL,
	`title` varchar(32) DEFAULT NULL,
	`type` tinyint(4) DEFAULT NULL,
	`author` varchar(32) DEFAULT NULL,
	`content` text,
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;

INSERT INTO `article` (`id`, `author_id`, `title`, `type`, `author`, `content`, `create_time`)
VALUES
	(1,1,'MyBatis 源码分析系列文章导读',8,'coolblog','MyBatis 源码分析系列文章导读','2018-07-15 15:30:09'),
	(2,2,'HashMap 源码详细分析(JDK1.8)',1,'coolblog','HashMap 源码详细分析(JDK1.8)','2018-01-18 15:29:13'),
	(3,1,'Java CAS 原理分析',1,'coolblog','Java CAS 原理分析','2018-05-15 15:28:33'),
	(4,1,'Spring IOC 容器源码分析 - 获取单例 bean',4,'coolblog','Spring IOC 容器源码分析 - 获取单例 bean','2018-06-01 00:00:00'),
	(5,1,'Spring IOC 容器源码分析 - 循环依赖的解决办法',4,'coolblog','Spring IOC 容器源码分析 - 循环依赖的解决办法','2018-06-08 00:00:00'),
	(6,2,'Spring AOP 源码分析系列文章导读',4,'coolblog','Spring AOP 源码分析系列文章导读','2018-06-17 00:00:00'),
	(7,2,'Spring AOP 源码分析 - 创建代理对象',4,'coolblog','Spring AOP 源码分析 - 创建代理对象','2018-06-20 00:00:00'),
	(8,1,'Spring MVC 原理探秘 - 一个请求的旅行过程',4,'coolblog','Spring MVC 原理探秘 - 一个请求的旅行过程','2018-06-29 00:00:00'),
	(9,2,'Spring MVC 原理探秘 - 容器的创建过程',4,'coolblog','Spring MVC 原理探秘 - 容器的创建过程','2018-06-30 00:00:00'),
	(10,2,'Spring IOC 容器源码分析系列文章导读',4,'coolblog','Spring IOC 容器源码分析系列文章导读','2018-05-30 00:00:00');

/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

# Dump of table author
#------------------------------------------------------------

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
	`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	`name` varchar(32) DEFAULT NULL,
	`age` tinyint(4) DEFAULT NULL,
	`sex` tinyint(4) DEFAULT NULL,
	`email` varchar(64) DEFAULT NULL,
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;

INSERT INTO `author` (`id`, `name`, `age`, `sex`, `email`)
VALUES
	(1,'icomac',25,0,'icomac@163.com'),
	(2,'coolblog',28,0,'coolblog.xyz@outlook.com');

/*!40000 ALTER TABLE `author` DISABLE KEYS */;
UNLOCK TABLES;
