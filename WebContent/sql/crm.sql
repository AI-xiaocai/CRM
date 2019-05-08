/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.17-log : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crm`;

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `custName` varchar(255) DEFAULT NULL,
  `custSource` varchar(255) DEFAULT NULL,
  `custPhone` varchar(255) DEFAULT NULL,
  `custMobile` varchar(255) DEFAULT NULL,
  `custLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FKo6oqtbbjmu6890to85xbpymcd` (`custLevel`),
  CONSTRAINT `FKo6oqtbbjmu6890to85xbpymcd` FOREIGN KEY (`custLevel`) REFERENCES `t_dict` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`cid`,`custName`,`custSource`,`custPhone`,`custMobile`,`custLevel`) values (1,'腾讯','网络推广','11111','22222',1),(3,'苹果<美国>','广告','12345','54321',3),(4,'美团','报纸','00000','88888',2),(5,'网易','广告','121212','121212',2),(6,'百度','报纸','343434','343434',1);

/*Table structure for table `t_dict` */

DROP TABLE IF EXISTS `t_dict`;

CREATE TABLE `t_dict` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_dict` */

insert  into `t_dict`(`did`,`dname`) values (1,'VIP客户'),(2,'普通客户'),(3,'SVIP客户');

/*Table structure for table `t_linkman` */

DROP TABLE IF EXISTS `t_linkman`;

CREATE TABLE `t_linkman` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lkmName` varchar(255) DEFAULT NULL,
  `lkmGender` varchar(255) DEFAULT NULL,
  `lkmPhone` varchar(255) DEFAULT NULL,
  `lkmMobile` varchar(255) DEFAULT NULL,
  `clid` int(11) DEFAULT NULL,
  PRIMARY KEY (`lid`),
  KEY `FKjtgu0oocf35ij4fmulu123vwk` (`clid`),
  CONSTRAINT `FKjtgu0oocf35ij4fmulu123vwk` FOREIGN KEY (`clid`) REFERENCES `t_customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_linkman` */

insert  into `t_linkman`(`lid`,`lkmName`,`lkmGender`,`lkmPhone`,`lkmMobile`,`clid`) values (1,'麻花藤','男','12345','12345',1),(2,'乔布斯','男','66666','99999',3);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`uid`,`username`,`password`,`address`) values (1,'zhan123','123','中国'),(2,'zhan666','666','美国');

/*Table structure for table `t_visit` */

DROP TABLE IF EXISTS `t_visit`;

CREATE TABLE `t_visit` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `vaddress` varchar(255) DEFAULT NULL,
  `vcontent` varchar(255) DEFAULT NULL,
  `uvid` int(11) DEFAULT NULL,
  `cvid` int(11) DEFAULT NULL,
  PRIMARY KEY (`vid`),
  KEY `FKnbsiiqbdcpvtugygwe4vj42s0` (`uvid`),
  KEY `FKfq1vs5t876wufr6l5tctnopps` (`cvid`),
  CONSTRAINT `FKfq1vs5t876wufr6l5tctnopps` FOREIGN KEY (`cvid`) REFERENCES `t_customer` (`cid`),
  CONSTRAINT `FKnbsiiqbdcpvtugygwe4vj42s0` FOREIGN KEY (`uvid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_visit` */

insert  into `t_visit`(`vid`,`vaddress`,`vcontent`,`uvid`,`cvid`) values (1,'深圳TiMi工作室','体验王者荣耀',1,1),(2,'苹果总部','和库克喝茶',1,3),(3,'中北大学','美团外卖',2,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
