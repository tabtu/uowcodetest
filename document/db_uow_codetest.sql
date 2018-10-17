/*
 Navicat Premium Data Transfer

 Source Server         : tabtu
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : db_uow_codetest

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 10/16/2018 20:52:51 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `db_app_adv`
-- ----------------------------
DROP TABLE IF EXISTS `db_app_adv`;
CREATE TABLE `db_app_adv` (
  `id` varchar(255) NOT NULL,
  `avaliable` bit(1) NOT NULL,
  `content` text,
  `count` int(11) NOT NULL,
  `enddate` datetime NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `sort` int(11) NOT NULL,
  `startdate` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `adv_cate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgt2vjlxkf9c05a9pmticn9ig4` (`adv_cate`),
  CONSTRAINT `FKgt2vjlxkf9c05a9pmticn9ig4` FOREIGN KEY (`adv_cate`) REFERENCES `db_app_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_app_category`
-- ----------------------------
DROP TABLE IF EXISTS `db_app_category`;
CREATE TABLE `db_app_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_shop_category`
-- ----------------------------
DROP TABLE IF EXISTS `db_shop_category`;
CREATE TABLE `db_shop_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_shop_item`
-- ----------------------------
DROP TABLE IF EXISTS `db_shop_item`;
CREATE TABLE `db_shop_item` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `item_cate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf5d9k9d08elirh9byx3s8ou3f` (`item_cate`),
  CONSTRAINT `FKf5d9k9d08elirh9byx3s8ou3f` FOREIGN KEY (`item_cate`) REFERENCES `db_shop_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_user_follow`
-- ----------------------------
DROP TABLE IF EXISTS `db_user_follow`;
CREATE TABLE `db_user_follow` (
  `user_id` varchar(255) NOT NULL,
  `follow_id` varchar(255) NOT NULL,
  KEY `FK8377tsdkvcb8rcm63fai0da8g` (`follow_id`),
  KEY `FKg2a1op7pq3m4xsvnslfisktfw` (`user_id`),
  CONSTRAINT `FK8377tsdkvcb8rcm63fai0da8g` FOREIGN KEY (`follow_id`) REFERENCES `db_user_user` (`id`),
  CONSTRAINT `FKg2a1op7pq3m4xsvnslfisktfw` FOREIGN KEY (`user_id`) REFERENCES `db_user_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_user_log`
-- ----------------------------
DROP TABLE IF EXISTS `db_user_log`;
CREATE TABLE `db_user_log` (
  `id` varchar(255) NOT NULL,
  `lgtime` datetime NOT NULL,
  `operation` varchar(255) NOT NULL,
  `lg_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKar9mis4023e2a0b7xprirodp4` (`lg_user`),
  CONSTRAINT `FKar9mis4023e2a0b7xprirodp4` FOREIGN KEY (`lg_user`) REFERENCES `db_user_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_user_membership`
-- ----------------------------
DROP TABLE IF EXISTS `db_user_membership`;
CREATE TABLE `db_user_membership` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avalible_date` datetime NOT NULL,
  `birth` datetime DEFAULT NULL,
  `gender` bit(1) NOT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `reportdate` datetime NOT NULL,
  `analysis_data` int(11) DEFAULT NULL,
  `analysis_member` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKltouae1pnv98wp5mtf8kiqgd2` (`analysis_data`),
  KEY `FKkvbdtemksj4uuocrul6416mx8` (`analysis_member`),
  CONSTRAINT `FKkvbdtemksj4uuocrul6416mx8` FOREIGN KEY (`analysis_member`) REFERENCES `db_user_membership` (`id`),
  CONSTRAINT `FKltouae1pnv98wp5mtf8kiqgd2` FOREIGN KEY (`analysis_data`) REFERENCES `db_user_membership` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_user_message`
-- ----------------------------
DROP TABLE IF EXISTS `db_user_message`;
CREATE TABLE `db_user_message` (
  `receiver` varchar(255) NOT NULL,
  `sender` varchar(255) NOT NULL,
  `sendtime` datetime NOT NULL,
  `isread` bit(1) NOT NULL,
  `logtime` datetime DEFAULT NULL,
  `text` text,
  PRIMARY KEY (`receiver`,`sender`,`sendtime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `db_user_user`
-- ----------------------------
DROP TABLE IF EXISTS `db_user_user`;
CREATE TABLE `db_user_user` (
  `id` varchar(255) NOT NULL,
  `createtime` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `is_member` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `updatetime` datetime NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_adv` int(11) DEFAULT NULL,
  `user_item` int(11) DEFAULT NULL,
  `user_member` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q1666dtx628koaid36jq9uf4` (`email`),
  UNIQUE KEY `UK_dguh6ctee86yeboqlyjg7qp9l` (`telephone`),
  UNIQUE KEY `UK_f159r96uue9uga26lrpdih0uy` (`username`),
  KEY `FKntevtlv8oy3hkhtike1822np2` (`user_adv`),
  KEY `FK9edjp804ijghah8sjlf2exivv` (`user_item`),
  KEY `FKgl7xfrcux1t0xpdb6bj5hnlbp` (`user_member`),
  CONSTRAINT `FK9edjp804ijghah8sjlf2exivv` FOREIGN KEY (`user_item`) REFERENCES `db_shop_category` (`id`),
  CONSTRAINT `FKgl7xfrcux1t0xpdb6bj5hnlbp` FOREIGN KEY (`user_member`) REFERENCES `db_user_membership` (`id`),
  CONSTRAINT `FKntevtlv8oy3hkhtike1822np2` FOREIGN KEY (`user_adv`) REFERENCES `db_app_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
