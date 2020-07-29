/*
 Navicat Premium Data Transfer

 Source Server         : center-50-root
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 192.168.3.50:3306
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 29/07/2020 09:35:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'åˆ›å»ºæ—¶é—´',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'ä¿®æ”¹æ—¶é—´',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'ç§Ÿæˆ·å­—æ®µ',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'xincan-order-dev.yaml', 'dev_group', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: alittlexincan@163.com\r\n        password: xincan-order-dev.yaml, dev, dev_group', '852b9431a6b4e93f7b04c9dd04858b3f', '2020-07-17 18:21:21', '2020-07-21 16:46:55', NULL, '192.168.3.21', '', 'xincan-dev-0001', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (2, 'xincan-user-dev.yaml', 'dev_group', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: alittlexincan@163.com\r\n        password: xincan-user-dev.yaml, dev, dev_group', '02c9d4c8f5982e47cfc1063826004092', '2020-07-17 18:22:01', '2020-07-21 16:47:11', NULL, '192.168.3.21', '', 'xincan-dev-0001', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (3, 'xincan-order-test.yaml', 'test_group', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: alittlexincan@163.com\r\n        password: xincan-order-test.yaml, test, test_group', '26f0328241b79647aad891d5e363d6ae', '2020-07-17 18:23:39', '2020-07-21 16:47:35', NULL, '192.168.3.21', '', 'xincan-test-0001', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (4, 'xincan-user-test.yaml', 'test_group', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: alittlexincan@163.com\r\n        password: xincan-user-test.yaml, test, test_group', '7eeb3f9628a84468708f709015185702', '2020-07-17 18:23:57', '2020-07-21 16:47:47', NULL, '192.168.3.21', '', 'xincan-test-0001', '', '', '', 'yaml', '');

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'å†…å®¹',
  `gmt_modified` datetime(0) NOT NULL COMMENT 'ä¿®æ”¹æ—¶é—´',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'ç§Ÿæˆ·å­—æ®µ',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'å¢žåŠ ç§Ÿæˆ·å­—æ®µ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_info_beta
-- ----------------------------
DROP TABLE IF EXISTS `config_info_beta`;
CREATE TABLE `config_info_beta`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `beta_ips` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'betaIps',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'åˆ›å»ºæ—¶é—´',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'ä¿®æ”¹æ—¶é—´',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'ç§Ÿæˆ·å­—æ®µ',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_info_tag
-- ----------------------------
DROP TABLE IF EXISTS `config_info_tag`;
CREATE TABLE `config_info_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tag_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_id',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'åˆ›å»ºæ—¶é—´',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'ä¿®æ”¹æ—¶é—´',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for config_tags_relation
-- ----------------------------
DROP TABLE IF EXISTS `config_tags_relation`;
CREATE TABLE `config_tags_relation`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'tag_name',
  `tag_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tag_type',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `nid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nid`) USING BTREE,
  UNIQUE INDEX `uk_configtagrelation_configidtag`(`id`, `tag_name`, `tag_type`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_tag_relation' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ä¸»é”®ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group IDï¼Œç©ºå­—ç¬¦è¡¨ç¤ºæ•´ä¸ªé›†ç¾¤',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'é…é¢ï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'ä½¿ç”¨é‡',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'å•ä¸ªé…ç½®å¤§å°ä¸Šé™ï¼Œå•ä½ä¸ºå­—èŠ‚ï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'èšåˆå­é…ç½®æœ€å¤§ä¸ªæ•°ï¼Œï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'å•ä¸ªèšåˆæ•°æ®çš„å­é…ç½®å¤§å°ä¸Šé™ï¼Œå•ä½ä¸ºå­—èŠ‚ï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'æœ€å¤§å˜æ›´åŽ†å²æ•°é‡',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'åˆ›å»ºæ—¶é—´',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'ä¿®æ”¹æ—¶é—´',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'é›†ç¾¤ã€å„Groupå®¹é‡ä¿¡æ¯è¡¨' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for his_config_info
-- ----------------------------
DROP TABLE IF EXISTS `his_config_info`;
CREATE TABLE `his_config_info`  (
  `id` bigint(64) UNSIGNED NOT NULL,
  `nid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'app_name',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `md5` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'ç§Ÿæˆ·å­—æ®µ',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'å¤šç§Ÿæˆ·æ”¹é€ ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------
INSERT INTO `his_config_info` VALUES (0, 1, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    id: \'dev_group\'\r\n    name: \'xincan-order-dev.yaml\'', 'e7811be08e5451ee8c18d0470893f78c', '2010-05-05 00:00:00', '2020-07-17 18:21:21', NULL, '192.168.3.21', 'I', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (0, 2, 'xincan-user-dev.yaml', 'dev_group', '', 'xincan:\r\n    id: \'dev_group\'\r\n    name: \'xincan-user-dev.yaml\'', '50c6986ad7d694012851ca4173dd31b7', '2010-05-05 00:00:00', '2020-07-17 18:22:01', NULL, '192.168.3.21', 'I', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (0, 3, 'xincan-order-test.yaml', 'test_group', '', 'xincan:\r\n    id: \'test_group\'\r\n    name: \'xincan-order-test.yaml\'', '29558fa02942fd443c77b4258b45f586', '2010-05-05 00:00:00', '2020-07-17 18:23:39', NULL, '192.168.3.21', 'I', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (0, 4, 'xincan-user-test.yaml', 'test_group', '', 'xincan:\r\n    id: \'test_group\'\r\n    name: \'xincan-user-test.yaml\'', '24c240d64537a09a13db7ccd0a71f3ee', '2010-05-05 00:00:00', '2020-07-17 18:23:57', NULL, '192.168.3.21', 'I', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (1, 5, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    id: \'dev_group\'\r\n    name: \'xincan-order-dev.yaml\'', 'e7811be08e5451ee8c18d0470893f78c', '2010-05-05 00:00:00', '2020-07-17 19:11:20', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 6, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    id: \'dev_group\'\r\n    name: \'xincan-order-dev.yamlsdfg\'', 'ae15839b09858fa5d9045048d13e6eb0', '2010-05-05 00:00:00', '2020-07-17 19:11:34', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 7, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    id: \'dev_group\'\r\n    name: \'xincan-order-dev.yaml\'', 'e7811be08e5451ee8c18d0470893f78c', '2010-05-05 00:00:00', '2020-07-20 16:57:59', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (2, 8, 'xincan-user-dev.yaml', 'dev_group', '', 'xincan:\r\n    id: \'dev_group\'\r\n    name: \'xincan-user-dev.yaml\'', '50c6986ad7d694012851ca4173dd31b7', '2010-05-05 00:00:00', '2020-07-20 16:58:13', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (3, 9, 'xincan-order-test.yaml', 'test_group', '', 'xincan:\r\n    id: \'test_group\'\r\n    name: \'xincan-order-test.yaml\'', '29558fa02942fd443c77b4258b45f586', '2010-05-05 00:00:00', '2020-07-20 16:58:31', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (4, 10, 'xincan-user-test.yaml', 'test_group', '', 'xincan:\r\n    id: \'test_group\'\r\n    name: \'xincan-user-test.yaml\'', '24c240d64537a09a13db7ccd0a71f3ee', '2010-05-05 00:00:00', '2020-07-20 16:58:41', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (1, 11, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    id: \'dev_group\'\r\n    name: \'xincan-order-dev.yaml\'', 'd3a86efcd71085fbea4b439a88938370', '2010-05-05 00:00:00', '2020-07-20 18:17:59', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (2, 12, 'xincan-user-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    id: \'dev_group\'\r\n    name: \'xincan-user-dev.yaml\'', '6c973cea2688728a1b2a0ebe5cf68fe4', '2010-05-05 00:00:00', '2020-07-20 18:18:23', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (3, 13, 'xincan-order-test.yaml', 'test_group', '', 'xincan:\r\n    enable: true\r\n    id: \'test_group\'\r\n    name: \'xincan-order-test.yaml\'', '4379c0803880234fad519a5fd8468bf0', '2010-05-05 00:00:00', '2020-07-20 18:18:39', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (4, 14, 'xincan-user-test.yaml', 'test_group', '', 'xincan:\r\n    enable: true\r\n    id: \'test_group\'\r\n    name: \'xincan-user-test.yaml\'', '0c0361667e03c934e5a78b51da4f1923', '2010-05-05 00:00:00', '2020-07-20 18:18:52', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (1, 15, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'eda1825d7f71ad80c0ba8a21a14e9fac', '2010-05-05 00:00:00', '2020-07-20 18:42:08', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 16, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: false\r\n    email:\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', '6bd3c6bab9f4258c8d40dafe7ae185c2', '2010-05-05 00:00:00', '2020-07-20 18:59:22', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 17, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'eda1825d7f71ad80c0ba8a21a14e9fac', '2010-05-05 00:00:00', '2020-07-20 19:00:43', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 18, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: false\r\n    email:\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', '6bd3c6bab9f4258c8d40dafe7ae185c2', '2010-05-05 00:00:00', '2020-07-20 19:04:13', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 19, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        enable: false\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'd4f27909ae803f2ee5bad9ba5d53bfc9', '2010-05-05 00:00:00', '2020-07-20 19:08:26', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 20, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        enable: true\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'a0659442f369789f5534e8e276083842', '2010-05-05 00:00:00', '2020-07-20 19:14:01', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 21, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        enable: false\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'd4f27909ae803f2ee5bad9ba5d53bfc9', '2010-05-05 00:00:00', '2020-07-21 09:29:25', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 22, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: false\r\n    email:\r\n        enable: false\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', '94d9fe5ba5ab2571e8e3dfdc3a794eb4', '2010-05-05 00:00:00', '2020-07-21 11:32:17', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 23, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        enable: true\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'a0659442f369789f5534e8e276083842', '2010-05-05 00:00:00', '2020-07-21 11:34:31', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 24, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        enable: false\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'd4f27909ae803f2ee5bad9ba5d53bfc9', '2010-05-05 00:00:00', '2020-07-21 11:39:06', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 25, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        enable: true\r\n        id: \'dev_group\'\r\n        name: \'xincan-order-dev.yaml\'', 'a0659442f369789f5534e8e276083842', '2010-05-05 00:00:00', '2020-07-21 11:49:40', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 26, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: false', '20cc08e077a44d7a982188d12bb2d3a3', '2010-05-05 00:00:00', '2020-07-21 11:51:39', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 27, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: false\r\n    email:\r\n        enable: false\r\n        id: xincan-order-dev.yaml\r\n        name: dev_group', 'e9cacc535a0072618220a5800683941e', '2010-05-05 00:00:00', '2020-07-21 12:05:49', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 28, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: false\r\n    email:\r\n        enable: true\r\n        id: xincan-order-dev.yaml\r\n        name: dev_group', 'e4696940f8fa298dacabc87efc516dcf', '2010-05-05 00:00:00', '2020-07-21 13:14:12', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 29, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enabled: false\r\n    email:\r\n        enabled: true\r\n        id: xincan-order-dev.yaml\r\n        name: dev_group', 'fbb8676c19c62409f4f4d1792ea331bb', '2010-05-05 00:00:00', '2020-07-21 13:14:54', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 30, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enabled: false\r\n    email:\r\n        enabled: true\r\n        address: xincan-order-dev.yaml\r\n        name: dev_group\r\n        password: dev', '799685f56a48b765ecafc86e5b9b56ec', '2010-05-05 00:00:00', '2020-07-21 13:15:51', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (1, 31, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enabled: false\r\n    email:\r\n        enabled: true\r\n        address: xincan-order-dev.yaml\r\n        login-name: dev_group\r\n        password: dev', '844bdc160aa553870757245a6339dec7', '2010-05-05 00:00:00', '2020-07-21 13:18:24', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (2, 32, 'xincan-user-dev.yaml', 'dev_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        id: \'dev_group\'\r\n        name: \'xincan-user-dev.yaml\'', 'c3abfb032a13cc2300be7e5a00681ac4', '2010-05-05 00:00:00', '2020-07-21 13:20:07', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (3, 33, 'xincan-order-test.yaml', 'test_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        id: \'test_group\'\r\n        name: \'xincan-order-test.yaml\'', '4ca0e295d588386b0055133639d4769e', '2010-05-05 00:00:00', '2020-07-21 13:20:55', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (4, 34, 'xincan-user-test.yaml', 'test_group', '', 'xincan:\r\n    enable: true\r\n    email:\r\n        id: \'test_group\'\r\n        name: \'xincan-user-test.yaml\'', 'a1d8ff25997c371fbdb34d6d76c4768f', '2010-05-05 00:00:00', '2020-07-21 13:21:08', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (1, 35, 'xincan-order-dev.yaml', 'dev_group', '', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: xincan-order-dev.yaml\r\n        login-name: dev_group\r\n        password: dev', 'a15ae49defd690d826ed9629d8b98211', '2010-05-05 00:00:00', '2020-07-21 16:46:55', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (2, 36, 'xincan-user-dev.yaml', 'dev_group', '', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: xincan-user-dev.yaml\r\n        login-name: dev_group\r\n        password: dev', '6656427ba76badf5b2d4c0e925c263a0', '2010-05-05 00:00:00', '2020-07-21 16:47:11', NULL, '192.168.3.21', 'U', 'xincan-dev-0001');
INSERT INTO `his_config_info` VALUES (3, 37, 'xincan-order-test.yaml', 'test_group', '', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: xincan-order-test.yaml\r\n        login-name: test_group\r\n        password: test', '7f0c48f1bc683b5d58521ff3d57885ee', '2010-05-05 00:00:00', '2020-07-21 16:47:35', NULL, '192.168.3.21', 'U', 'xincan-test-0001');
INSERT INTO `his_config_info` VALUES (4, 38, 'xincan-user-test.yaml', 'test_group', '', 'xincan:\r\n    enabled: true\r\n    email:\r\n        enabled: true\r\n        address: xincan-user-test.yaml\r\n        login-name: test_group\r\n        password: test', '2c8b632d2c3311690e6f802b76ea6d11', '2010-05-05 00:00:00', '2020-07-21 16:47:47', NULL, '192.168.3.21', 'U', 'xincan-test-0001');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `resource` varchar(512) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `action` varchar(8) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `role` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  UNIQUE INDEX `uk_username_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ä¸»é”®ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'é…é¢ï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'ä½¿ç”¨é‡',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'å•ä¸ªé…ç½®å¤§å°ä¸Šé™ï¼Œå•ä½ä¸ºå­—èŠ‚ï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'èšåˆå­é…ç½®æœ€å¤§ä¸ªæ•°',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'å•ä¸ªèšåˆæ•°æ®çš„å­é…ç½®å¤§å°ä¸Šé™ï¼Œå•ä½ä¸ºå­—èŠ‚ï¼Œ0è¡¨ç¤ºä½¿ç”¨é»˜è®¤å€¼',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'æœ€å¤§å˜æ›´åŽ†å²æ•°é‡',
  `gmt_create` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'åˆ›å»ºæ—¶é—´',
  `gmt_modified` datetime(0) NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT 'ä¿®æ”¹æ—¶é—´',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'ç§Ÿæˆ·å®¹é‡ä¿¡æ¯è¡¨' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tenant_info
-- ----------------------------
DROP TABLE IF EXISTS `tenant_info`;
CREATE TABLE `tenant_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `kp` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'kp',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_id',
  `tenant_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT 'tenant_name',
  `tenant_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'tenant_desc',
  `create_source` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'create_source',
  `gmt_create` bigint(20) NOT NULL COMMENT 'åˆ›å»ºæ—¶é—´',
  `gmt_modified` bigint(20) NOT NULL COMMENT 'ä¿®æ”¹æ—¶é—´',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '1', 'xincan-dev-0001', 'dev', '开发环境', 'nacos', 1594981023088, 1594981023088);
INSERT INTO `tenant_info` VALUES (2, '1', 'xincan-test-0001', 'test', '测试环境', 'nacos', 1594981049053, 1594981049053);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
