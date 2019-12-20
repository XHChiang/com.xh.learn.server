/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : s2h_usr

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-27 20:09:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL DEFAULT '0' COMMENT '分组ID',
  `email` varchar(64) NOT NULL DEFAULT '',
  `account` varchar(64) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `phone_number` varchar(255) NOT NULL DEFAULT '',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`) USING HASH,
  UNIQUE KEY `account` (`account`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES ('1', '0', 'a', 'a', '', '', '', '0', '2018-07-20 14:02:03', null);
INSERT INTO `usr` VALUES ('2', '0', 'b', 'b', '', '', '', '0', '2018-07-27 13:27:41', null);
INSERT INTO `usr` VALUES ('3', '0', 'c', 'c', '', '', '', '0', '2018-07-26 13:28:39', null);
INSERT INTO `usr` VALUES ('4', '0', 'd', 'd', '', '', '', '0', '2018-07-27 14:57:15', null);

-- ----------------------------
-- Table structure for usr_group
-- ----------------------------
DROP TABLE IF EXISTS `usr_group`;
CREATE TABLE `usr_group` (
  `id` int(11) NOT NULL,
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `name` varchar(32) NOT NULL DEFAULT '',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父分组ID',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述信息',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr_group
-- ----------------------------
