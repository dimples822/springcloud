/*
Navicat MySQL Data Transfer

Source Server         : 47.106.102.235
Source Server Version : 50727
Source Host           : 47.106.102.235:3306
Source Database       : db_dimples_cloud

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-24 20:53:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) NOT NULL,
  `scope` varchar(255) NOT NULL,
  `authorized_grant_types` varchar(255) NOT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) NOT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` tinyint(4) DEFAULT NULL,
  `origin_secret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('dimples', null, '$2a$10$aSZTvMOtUAYUQ.75z2n3ceJd6dCIk9Vy3J/SKZUE4hBLd6sz7.6ge', 'all', 'password,refresh_token', null, null, '86400', '86400', null, '1', '123456');
