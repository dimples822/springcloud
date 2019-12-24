/*
Navicat MySQL Data Transfer

Source Server         : 47.106.102.235
Source Server Version : 50727
Source Host           : 47.106.102.235:3306
Source Database       : db_base_permission

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-12-24 20:54:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '科室id',
  `dept_name` varchar(255) DEFAULT NULL COMMENT '科室名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `permission_url` varchar(255) DEFAULT NULL COMMENT '菜单URL',
  `permission` varchar(255) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `permission_type` varchar(255) DEFAULT NULL COMMENT '权限类型，如button，menu',
  `status` tinyint(4) DEFAULT '1' COMMENT '用户状态，0不启用，1启用，默认为1 ',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('1', '添加用户', null, 'user:add', 'button', '1', '2019-11-14 18:06:49', null);

-- ----------------------------
-- Table structure for tb_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission_role`;
CREATE TABLE `tb_permission_role` (
  `permission_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限角色关联id',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`permission_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_permission_role
-- ----------------------------
INSERT INTO `tb_permission_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for tb_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_position`;
CREATE TABLE `tb_position` (
  `position_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '职位id',
  `position_name` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_position
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '管理员', '2019-11-14 02:49:57', null);
INSERT INTO `tb_role` VALUES ('2', '演示', '2019-11-14 16:54:17', null);

-- ----------------------------
-- Table structure for tb_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_dept`;
CREATE TABLE `tb_role_dept` (
  `role_dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色科室关联id',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '科室id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`role_dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_position`;
CREATE TABLE `tb_role_position` (
  `role_position_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关联id',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`role_position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_position
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role_u_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_u_group`;
CREATE TABLE `tb_role_u_group` (
  `role_u_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色用户组关联id',
  `u_group_id` bigint(20) DEFAULT NULL COMMENT '用户组id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`role_u_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_u_group
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_user`;
CREATE TABLE `tb_role_user` (
  `role_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色职位关联id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`role_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_user
-- ----------------------------
INSERT INTO `tb_role_user` VALUES ('1', '1', '1');
INSERT INTO `tb_role_user` VALUES ('2', '1', '2');
INSERT INTO `tb_role_user` VALUES ('3', '3', '1');

-- ----------------------------
-- Table structure for tb_u_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_u_group`;
CREATE TABLE `tb_u_group` (
  `u_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户组id',
  `group_name` varchar(255) DEFAULT NULL COMMENT '用户组名',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`u_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_u_group
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐',
  `status` tinyint(4) DEFAULT '1' COMMENT '用户状态，0不启用，1启用，默认为1 ',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `modify_date` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'f30d806c23f9b68a28bc2276a89fb84b', '791f8a13d2c6be83d0527fe1c28b7d3d', '1', '2019-11-13 21:51:25', null);
INSERT INTO `tb_user` VALUES ('2', 'root', 'b8b153d1e93cc5c9f90603b348641e8c', 'dd6f85eba673f756f17788efb7303499', '1', '2019-11-14 01:44:16', null);
INSERT INTO `tb_user` VALUES ('3', 'dimples', '$2a$10$TBrSoIWEiAQaEEPswpl1guJ7vqt6Z/lMLWD3lhDy0UAVxMHpSBvie', null, '1', '2019-12-09 20:44:19', null);

-- ----------------------------
-- Table structure for tb_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_dept`;
CREATE TABLE `tb_user_dept` (
  `user_dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户科室关联id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '科室id',
  PRIMARY KEY (`user_dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user_dept
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_position
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_position`;
CREATE TABLE `tb_user_position` (
  `user_position_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户职位关联id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位id',
  PRIMARY KEY (`user_position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user_position
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user_u_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_u_group`;
CREATE TABLE `tb_user_u_group` (
  `user_u_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户与用户组关联id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `u_group_id` bigint(20) DEFAULT NULL COMMENT '用户组id',
  PRIMARY KEY (`user_u_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user_u_group
-- ----------------------------
