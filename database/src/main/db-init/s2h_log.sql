/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : s2h_log

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-07-27 20:09:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bs_log
-- ----------------------------
DROP TABLE IF EXISTS `bs_log`;
CREATE TABLE `bs_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table` varchar(64) NOT NULL DEFAULT '',
  `rowid` int(11) NOT NULL DEFAULT '0',
  `usr_id` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `operate_type` varchar(4) NOT NULL DEFAULT '' COMMENT '增1，删2，改3，查4',
  `operate_name` varchar(64) NOT NULL DEFAULT '',
  `operate_description` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bs_log
-- ----------------------------
INSERT INTO `bs_log` VALUES ('1', '', '0', '0', '2018-07-20 14:45:55', '增加', '', '');
