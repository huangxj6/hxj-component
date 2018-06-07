-- MySQL dump 10.13  Distrib 5.7.12, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: test2
-- ------------------------------------------------------
-- Server version	5.7.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_acl`
--

DROP TABLE IF EXISTS `sys_acl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_acl` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `code` varchar(20) NOT NULL DEFAULT '' COMMENT '权限码',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限名称',
  `acl_module_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '权限所在的权限模块id',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '请求的url, 可以填正则表达式',
  `type` int(11) unsigned NOT NULL DEFAULT '3' COMMENT '类型，1：菜单，2：按钮，3：其他',
  `status` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '权限在当前模块下的顺序，由小到大',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一个更新者的ip地址',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_acl`
--

LOCK TABLES `sys_acl` WRITE;
/*!40000 ALTER TABLE `sys_acl` DISABLE KEYS */;
INSERT INTO `sys_acl` VALUES (1,'20171015095130_26','进入产品管理界面',1,'/sys/product/product.page',1,1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(2,'20171015095322_14','查询产品列表',1,'/sys/product/page.json',2,1,2,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(3,'20171015095350_69','产品上架',1,'/sys/product/online.json',2,1,3,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(4,'20171015095420_7','产品下架',1,'/sys/product/offline.json',2,1,4,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(5,'20171015212626_63','进入订单页',2,'/sys/order/order.page',1,1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(6,'20171015212657_12','查询订单列表',2,'/sys/order/list.json',2,1,2,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(7,'20171015212907_36','进入权限管理页',7,'/sys/aclModule/acl.page',1,1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(8,'20171015212938_27','进入角色管理页',8,'/sys/role/role.page',1,1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(9,'20171015213009_0','进入用户管理页',9,'/sys/dept/dept.page',1,1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(10,'20171016230429_8','进入权限更新记录页面',11,'/sys/log/log.page',1,1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10');
/*!40000 ALTER TABLE `sys_acl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_acl_module`
--

DROP TABLE IF EXISTS `sys_acl_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_acl_module` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限模块id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '权限模块名称',
  `parent_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上级权限模块id',
  `level` varchar(200) NOT NULL DEFAULT '' COMMENT '权限模块层级',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '权限模块在当前层级下的顺序，由小到大',
  `status` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='权限模块表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_acl_module`
--

LOCK TABLES `sys_acl_module` WRITE;
/*!40000 ALTER TABLE `sys_acl_module` DISABLE KEYS */;
INSERT INTO `sys_acl_module` VALUES (1,'产品管理',0,'0',1,1,'product','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(2,'订单管理',0,'0',2,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(3,'公告管理',0,'0',3,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(4,'出售中产品管理',1,'0.1',1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(5,'下架产品管理',1,'0.1',2,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(6,'权限管理',0,'0',4,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(7,'权限管理',6,'0.6',1,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(8,'角色管理',6,'0.6',2,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(9,'用户管理',6,'0.6',2,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(10,'运维管理',0,'0',6,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10'),(11,'权限更新记录管理',6,'0.6',4,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10');
/*!40000 ALTER TABLE `sys_acl_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '上级部门id',
  `level` varchar(200) NOT NULL DEFAULT '' COMMENT '部门层级',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '部门在当前层级下的顺序，由小到大',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新操作者的ip地址',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'技术部',0,'0',1,'技术部','system','1','2017-10-11 10:10:10','2018-05-12 16:25:55'),(2,'后端开发2',1,'0.1',2,'后端开发2','admin','127.0.0.1','2017-10-11 10:10:10','2018-05-19 17:04:05'),(3,'前端开发',1,'0.1',2,'','system-update','3','2017-10-11 10:10:10','2018-05-12 16:25:56'),(4,'UI设计',1,'0.1',3,'','system','4','2017-10-11 10:10:10','2018-05-12 16:25:57'),(12,'客服部',0,'0',4,'','Admin','6','2017-10-11 10:10:10','2018-05-12 16:25:59'),(47,'php开发',2,'0.1.2',1,'','admin','127.0.0.1','2018-05-19 16:18:41','2018-05-19 17:04:05'),(61,'uhu',0,'0',78,'drdr','admin','127.0.0.1','2018-06-02 17:03:27','2018-06-02 17:03:27');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '权限更新的类型，1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系',
  `target_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '基于type后指定的对象id，比如用户、权限、角色等表的主键',
  `old_value` text NOT NULL COMMENT '旧值',
  `new_value` text NOT NULL COMMENT '新值',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `status` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '当前是否复原过，0：没有，1：复原过',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (2,1,12,'','{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":3,\"operator\":\"Admin\",\"operateTime\":1508166002610,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(3,1,12,'{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":3,\"operator\":\"Admin\",\"operateTime\":1508166003000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508166009313,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(4,2,4,'','{\"id\":4,\"username\":\"Kate\",\"telephone\":\"13144445555\",\"mail\":\"kate@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166166297,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(5,2,4,'{\"id\":4,\"username\":\"Kate\",\"telephone\":\"13144445555\",\"mail\":\"kate@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166166000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":4,\"username\":\"Kate\",\"telephone\":\"13144445555\",\"mail\":\"kate@qq.com\",\"deptId\":1,\"status\":1,\"remark\":\"sss\",\"operator\":\"Admin\",\"operateTime\":1508166171320,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(6,3,10,'','{\"id\":10,\"name\":\"运维管理\",\"parentId\":0,\"level\":\"0\",\"seq\":5,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166212527,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(7,3,10,'{\"id\":10,\"name\":\"运维管理\",\"parentId\":0,\"level\":\"0\",\"seq\":5,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166213000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":10,\"name\":\"运维管理\",\"parentId\":0,\"level\":\"0\",\"seq\":6,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166217376,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(8,3,11,'','{\"id\":11,\"name\":\"权限更新记录管理\",\"parentId\":6,\"level\":\"0.6\",\"seq\":4,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166246805,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(9,4,10,'','{\"id\":10,\"code\":\"20171016230429_8\",\"name\":\"进入权限更新记录页面\",\"aclModuleId\":1,\"url\":\"/sys/log/log.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1508166269419,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(10,4,10,'{\"id\":10,\"code\":\"20171016230429_8\",\"name\":\"进入权限更新记录页面\",\"aclModuleId\":1,\"url\":\"/sys/log/log.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1508166269000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":10,\"name\":\"进入权限更新记录页面\",\"aclModuleId\":11,\"url\":\"/sys/log/log.page\",\"type\":1,\"status\":1,\"seq\":1,\"operator\":\"Admin\",\"operateTime\":1508166288589,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(11,5,5,'','{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166301130,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(12,5,5,'{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508166301000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508166307317,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(13,6,4,'[7,8,9]','[7,8,9,10]','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(14,7,4,'[1]','[1,4]','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(15,2,5,'','{\"id\":5,\"username\":\"服务员A\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170918338,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(16,2,5,'{\"id\":5,\"username\":\"服务员A\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170918000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":5,\"username\":\"服务员B\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170924698,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(17,2,5,'{\"id\":5,\"username\":\"服务员B\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170925000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":5,\"username\":\"服务员A\",\"telephone\":\"18677778888\",\"mail\":\"service@qq.com\",\"password\":\"25D55AD283AA400AF464C76D713C07AD\",\"deptId\":12,\"status\":1,\"operator\":\"Admin\",\"operateTime\":1508170934791,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(18,1,12,'{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508166009000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":12,\"name\":\"客服部A\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170966051,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(19,1,12,'{\"id\":12,\"name\":\"客服部A\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170966000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":12,\"name\":\"客服部\",\"parentId\":0,\"level\":\"0\",\"seq\":4,\"operator\":\"Admin\",\"operateTime\":1508170975242,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(20,5,5,'{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508166307000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":5,\"name\":\"运维管理员A\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508170997531,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(21,5,5,'{\"id\":5,\"name\":\"运维管理员A\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508170998000,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','{\"id\":5,\"name\":\"运维管理员\",\"type\":1,\"status\":1,\"remark\":\"运维\",\"operator\":\"Admin\",\"operateTime\":1508171007651,\"operateIp\":\"0:0:0:0:0:0:0:1\"}','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(22,7,4,'[1,4]','[1,4,2,3,5]','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(23,7,4,'[1,4,2,3,5]','[1,4]','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(24,6,5,'[]','[7,8,9,10]','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0),(25,6,5,'[7,8,9,10]','[]','Admin','0:0:0:0:0:0:0:1',1,'2017-10-11 10:10:10','2017-10-11 10:10:10',0);
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(20) NOT NULL,
  `type` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '角色的类型，1：管理员角色，2：其他',
  `status` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '状态，1：可用，0：冻结',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'产品管理员',1,1,'产品管理员','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2018-05-20 13:47:14',0),(2,'订单管理员',1,1,'订单管理员','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2018-05-20 13:47:08',0),(3,'公告管理员',1,1,'公告管理员','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2018-05-20 13:47:12',0),(4,'权限管理员',1,1,'权限管理员','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2018-05-20 13:47:10',0),(5,'运维管理员',1,1,'运维管理员','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2018-05-20 13:47:01',0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_acl`
--

DROP TABLE IF EXISTS `sys_role_acl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_acl` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  `acl_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '权限id',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(200) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_acl`
--

LOCK TABLES `sys_role_acl` WRITE;
/*!40000 ALTER TABLE `sys_role_acl` DISABLE KEYS */;
INSERT INTO `sys_role_acl` VALUES (9,4,7,'Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(10,4,8,'Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(11,4,9,'Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(12,4,10,'Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0);
/*!40000 ALTER TABLE `sys_role_acl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_user`
--

DROP TABLE IF EXISTS `sys_role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='角色用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user`
--

LOCK TABLES `sys_role_user` WRITE;
/*!40000 ALTER TABLE `sys_role_user` DISABLE KEYS */;
INSERT INTO `sys_role_user` VALUES (16,4,1,'Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(17,4,4,'Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0);
/*!40000 ALTER TABLE `sys_role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名称',
  `telephone` varchar(13) NOT NULL DEFAULT '' COMMENT '手机号',
  `mail` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `dept_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '用户所在部门的id',
  `status` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结状态，2：删除',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `seq` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'Admin','18612344321','admin@qq.com','25D55AD283AA400AF464C76D713C07AD',1,1,'admin','system','127.0.0.1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(2,'Jimin','13188889999','jimin@qq.com','25D55AD283AA400AF464C76D713C07AD',1,1,'jimin.zheng','Admin','127.0.0.1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(3,'Jimmy','13812344311','jimmy@qq.com','25D55AD283AA400AF464C76D713C07AD',2,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2018-05-13 12:12:20',999),(4,'Kate','13144445555','kate@qq.com','25D55AD283AA400AF464C76D713C07AD',1,1,'sss','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(5,'服务员A','18677778888','service@qq.com','25D55AD283AA400AF464C76D713C07AD',12,1,'','Admin','0:0:0:0:0:0:0:1','2017-10-11 10:10:10','2017-10-11 10:10:10',0),(6,'aa','','','',0,1,'','','','2018-06-03 10:32:08','2018-06-03 10:32:08',0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-07  7:18:28
