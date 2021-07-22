/*
 Navicat Premium Data Transfer

 Source Server         : 阿里-k8s-mysql-master-31110
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 192.168.1.81:31110
 Source Schema         : nacos

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 22/07/2021 19:38:48
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
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_use` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `effect` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `c_schema` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfo_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 222 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info
-- ----------------------------
INSERT INTO `config_info` VALUES (1, 'transport.type', 'SEATA_GROUP', 'TCP', 'b136ef5f6a01d816991fe3cf7a6ac763', '2021-07-01 11:24:37', '2021-07-01 11:24:37', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (2, 'transport.server', 'SEATA_GROUP', 'NIO', 'b6d9dfc0fb54277321cebc0fff55df2f', '2021-07-01 11:24:37', '2021-07-01 11:24:37', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (3, 'transport.heartbeat', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-01 11:24:37', '2021-07-01 11:24:37', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (4, 'transport.enableClientBatchSendRequest', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-01 11:24:37', '2021-07-01 11:24:37', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (5, 'transport.threadFactory.bossThreadPrefix', 'SEATA_GROUP', 'NettyBoss', '0f8db59a3b7f2823f38a70c308361836', '2021-07-01 11:24:38', '2021-07-01 11:24:38', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (6, 'transport.threadFactory.workerThreadPrefix', 'SEATA_GROUP', 'NettyServerNIOWorker', 'a78ec7ef5d1631754c4e72ae8a3e9205', '2021-07-01 11:24:39', '2021-07-01 11:24:39', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (7, 'transport.threadFactory.serverExecutorThreadPrefix', 'SEATA_GROUP', 'NettyServerBizHandler', '11a36309f3d9df84fa8b59cf071fa2da', '2021-07-01 11:24:39', '2021-07-01 11:24:39', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (8, 'transport.threadFactory.shareBossWorker', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:40', '2021-07-01 11:24:40', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (9, 'transport.threadFactory.clientSelectorThreadPrefix', 'SEATA_GROUP', 'NettyClientSelector', 'cd7ec5a06541e75f5a7913752322c3af', '2021-07-01 11:24:40', '2021-07-01 11:24:40', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (10, 'transport.threadFactory.clientSelectorThreadSize', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-01 11:24:40', '2021-07-01 11:24:40', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (11, 'transport.threadFactory.clientWorkerThreadPrefix', 'SEATA_GROUP', 'NettyClientWorkerThread', '61cf4e69a56354cf72f46dc86414a57e', '2021-07-01 11:24:41', '2021-07-01 11:24:41', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (12, 'transport.threadFactory.bossThreadSize', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-01 11:24:41', '2021-07-01 11:24:41', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (13, 'transport.threadFactory.workerThreadSize', 'SEATA_GROUP', 'default', 'c21f969b5f03d33d43e04f8f136e7682', '2021-07-01 11:24:41', '2021-07-01 11:24:41', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (14, 'transport.shutdown.wait', 'SEATA_GROUP', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '2021-07-01 11:24:41', '2021-07-01 11:24:41', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (15, 'service.vgroupMapping.xincan_tx_group', 'SEATA_GROUP', 'xincan', 'eb7d7610f3cc42d5827bf6eb8b2fa988', '2021-07-01 11:24:42', '2021-07-01 11:24:42', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (16, 'service.xincan.grouplist', 'SEATA_GROUP', 'seata-service.seata:8091', 'd9beeb4105bdc0b251f9d3e86f9e67aa', '2021-07-01 11:24:42', '2021-07-01 11:24:42', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (17, 'service.enableDegrade', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:42', '2021-07-01 11:24:42', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (18, 'service.disableGlobalTransaction', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:43', '2021-07-01 11:24:43', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (19, 'client.rm.asyncCommitBufferLimit', 'SEATA_GROUP', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-01 11:24:43', '2021-07-01 11:24:43', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (20, 'client.rm.lock.retryInterval', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-01 11:24:43', '2021-07-01 11:24:43', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (21, 'client.rm.lock.retryTimes', 'SEATA_GROUP', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-01 11:24:43', '2021-07-01 11:24:43', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (22, 'client.rm.lock.retryPolicyBranchRollbackOnConflict', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-01 11:24:44', '2021-07-01 11:24:44', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (23, 'client.rm.reportRetryCount', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-01 11:24:44', '2021-07-01 11:24:44', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (24, 'client.rm.tableMetaCheckEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:44', '2021-07-01 11:24:44', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (25, 'client.rm.tableMetaCheckerInterval', 'SEATA_GROUP', '60000', '2b4226dd7ed6eb2d419b881f3ae9c97c', '2021-07-01 11:24:45', '2021-07-01 11:24:45', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (26, 'client.rm.sqlParserType', 'SEATA_GROUP', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2021-07-01 11:24:45', '2021-07-01 11:24:45', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (27, 'client.rm.reportSuccessEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:45', '2021-07-01 11:24:45', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (28, 'client.rm.sagaBranchRegisterEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:46', '2021-07-01 11:24:46', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (29, 'client.rm.tccActionInterceptorOrder', 'SEATA_GROUP', '-2147482648', 'f056d9efa5dae3872f9da035c83bcde8', '2021-07-01 11:24:46', '2021-07-01 11:24:46', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (30, 'client.tm.commitRetryCount', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-01 11:24:46', '2021-07-01 11:24:46', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (31, 'client.tm.rollbackRetryCount', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-01 11:24:47', '2021-07-01 11:24:47', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (32, 'client.tm.defaultGlobalTransactionTimeout', 'SEATA_GROUP', '60000', '2b4226dd7ed6eb2d419b881f3ae9c97c', '2021-07-01 11:24:47', '2021-07-01 11:24:47', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (33, 'client.tm.degradeCheck', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:24:48', '2021-07-01 11:24:48', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (34, 'client.tm.degradeCheckAllowTimes', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-01 11:24:48', '2021-07-01 11:24:48', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (35, 'client.tm.degradeCheckPeriod', 'SEATA_GROUP', '2000', '08f90c1a417155361a5c4b8d297e0d78', '2021-07-01 11:24:48', '2021-07-01 11:24:48', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (36, 'client.tm.interceptorOrder', 'SEATA_GROUP', '-2147482648', 'f056d9efa5dae3872f9da035c83bcde8', '2021-07-01 11:24:49', '2021-07-01 11:24:49', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (37, 'store.mode', 'SEATA_GROUP', 'db', 'd77d5e503ad1439f585ac494268b351b', '2021-07-01 11:24:49', '2021-07-01 11:24:49', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (38, 'store.lock.mode', 'SEATA_GROUP', 'file', '8c7dd922ad47494fc02c388e12c00eac', '2021-07-01 11:24:50', '2021-07-01 11:24:50', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (39, 'store.session.mode', 'SEATA_GROUP', 'file', '8c7dd922ad47494fc02c388e12c00eac', '2021-07-01 11:24:50', '2021-07-01 11:24:50', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (40, 'store.file.dir', 'SEATA_GROUP', 'file_store/data', '6a8dec07c44c33a8a9247cba5710bbb2', '2021-07-01 11:24:51', '2021-07-01 11:24:51', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (41, 'store.file.maxBranchSessionSize', 'SEATA_GROUP', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-01 11:24:51', '2021-07-01 11:24:51', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (42, 'store.file.maxGlobalSessionSize', 'SEATA_GROUP', '512', '10a7cdd970fe135cf4f7bb55c0e3b59f', '2021-07-01 11:24:51', '2021-07-01 11:24:51', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (43, 'store.file.fileWriteBufferCacheSize', 'SEATA_GROUP', '16384', 'c76fe1d8e08462434d800487585be217', '2021-07-01 11:24:52', '2021-07-01 11:24:52', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (44, 'store.file.flushDiskMode', 'SEATA_GROUP', 'async', '0df93e34273b367bb63bad28c94c78d5', '2021-07-01 11:24:52', '2021-07-01 11:24:52', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (45, 'store.file.sessionReloadReadSize', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-01 11:24:52', '2021-07-01 11:24:52', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (46, 'store.db.datasource', 'SEATA_GROUP', 'druid', '3d650fb8a5df01600281d48c47c9fa60', '2021-07-01 11:24:53', '2021-07-01 11:24:53', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (47, 'store.db.dbType', 'SEATA_GROUP', 'mysql', '81c3b080dad537de7e10e0987a4bf52e', '2021-07-01 11:24:53', '2021-07-01 11:24:53', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (48, 'store.db.driverClassName', 'SEATA_GROUP', 'com.mysql.jdbc.Driver', '683cf0c3a5a56cec94dfac94ca16d760', '2021-07-01 11:24:53', '2021-07-01 11:24:53', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (49, 'store.db.url', 'SEATA_GROUP', 'jdbc:mysql://mysql-master.mysql:3306/seata?useUnicode=true&rewriteBatchedStatements=true', '13d067065ee0549171de7a3b236e6fa2', '2021-07-01 11:24:54', '2021-07-01 11:24:54', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (50, 'store.db.user', 'SEATA_GROUP', 'root', '63a9f0ea7bb98050796b649e85481845', '2021-07-01 11:24:54', '2021-07-01 11:24:54', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (51, 'store.db.password', 'SEATA_GROUP', '123456', 'e10adc3949ba59abbe56e057f20f883e', '2021-07-01 11:24:54', '2021-07-01 11:24:54', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (52, 'store.db.minConn', 'SEATA_GROUP', '5', 'e4da3b7fbbce2345d7772b0674a318d5', '2021-07-01 11:24:55', '2021-07-01 11:24:55', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (53, 'store.db.maxConn', 'SEATA_GROUP', '30', '34173cb38f07f89ddbebc2ac9128303f', '2021-07-01 11:24:55', '2021-07-01 11:24:55', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (54, 'store.db.globalTable', 'SEATA_GROUP', 'global_table', '8b28fb6bb4c4f984df2709381f8eba2b', '2021-07-01 11:24:55', '2021-07-01 11:24:55', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (55, 'store.db.branchTable', 'SEATA_GROUP', 'branch_table', '54bcdac38cf62e103fe115bcf46a660c', '2021-07-01 11:24:56', '2021-07-01 11:24:56', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (56, 'store.db.queryLimit', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-01 11:24:57', '2021-07-01 11:24:57', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (57, 'store.db.lockTable', 'SEATA_GROUP', 'lock_table', '55e0cae3b6dc6696b768db90098b8f2f', '2021-07-01 11:24:57', '2021-07-01 11:24:57', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (58, 'store.db.maxWait', 'SEATA_GROUP', '5000', 'a35fe7f7fe8217b4369a0af4244d1fca', '2021-07-01 11:24:58', '2021-07-01 11:24:58', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (59, 'store.redis.mode', 'SEATA_GROUP', 'single', 'dd5c07036f2975ff4bce568b6511d3bc', '2021-07-01 11:24:58', '2021-07-01 11:24:58', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (60, 'store.redis.single.host', 'SEATA_GROUP', '127.0.0.1', 'f528764d624db129b32c21fbca0cb8d6', '2021-07-01 11:25:00', '2021-07-01 11:25:00', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (61, 'store.redis.single.port', 'SEATA_GROUP', '6379', '92c3b916311a5517d9290576e3ea37ad', '2021-07-01 11:25:01', '2021-07-01 11:25:01', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (62, 'store.redis.maxConn', 'SEATA_GROUP', '10', 'd3d9446802a44259755d38e6d163e820', '2021-07-01 11:25:02', '2021-07-01 11:25:02', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (63, 'store.redis.minConn', 'SEATA_GROUP', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2021-07-01 11:25:03', '2021-07-01 11:25:03', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (64, 'store.redis.maxTotal', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-01 11:25:03', '2021-07-01 11:25:03', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (65, 'store.redis.database', 'SEATA_GROUP', '0', 'cfcd208495d565ef66e7dff9f98764da', '2021-07-01 11:25:05', '2021-07-01 11:25:05', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (66, 'store.redis.queryLimit', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-01 11:25:06', '2021-07-01 11:25:06', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (67, 'server.recovery.committingRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-01 11:25:06', '2021-07-01 11:25:06', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (68, 'server.recovery.asynCommittingRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-01 11:25:07', '2021-07-01 11:25:07', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (69, 'server.recovery.rollbackingRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-01 11:25:08', '2021-07-01 11:25:08', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (70, 'server.recovery.timeoutRetryPeriod', 'SEATA_GROUP', '1000', 'a9b7ba70783b617e9998dc4dd82eb3c5', '2021-07-01 11:25:10', '2021-07-01 11:25:10', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (71, 'server.maxCommitRetryTimeout', 'SEATA_GROUP', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-01 11:25:10', '2021-07-01 11:25:10', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (72, 'server.maxRollbackRetryTimeout', 'SEATA_GROUP', '-1', '6bb61e3b7bce0931da574d19d1d82c88', '2021-07-01 11:25:11', '2021-07-01 11:25:11', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (73, 'server.rollbackRetryTimeoutUnlockEnable', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:25:11', '2021-07-01 11:25:11', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (74, 'server.distributedLockExpireTime', 'SEATA_GROUP', '10000', 'b7a782741f667201b54880c925faec4b', '2021-07-01 11:25:11', '2021-07-01 11:25:11', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (75, 'client.undo.dataValidation', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-01 11:25:12', '2021-07-01 11:25:12', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (76, 'client.undo.logSerialization', 'SEATA_GROUP', 'jackson', 'b41779690b83f182acc67d6388c7bac9', '2021-07-01 11:25:12', '2021-07-01 11:25:12', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (77, 'client.undo.onlyCareUpdateColumns', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-01 11:25:13', '2021-07-01 11:25:13', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (78, 'server.undo.logSaveDays', 'SEATA_GROUP', '7', '8f14e45fceea167a5a36dedd4bea2543', '2021-07-01 11:25:14', '2021-07-01 11:25:14', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (79, 'server.undo.logDeletePeriod', 'SEATA_GROUP', '86400000', 'f4c122804fe9076cb2710f55c3c6e346', '2021-07-01 11:25:14', '2021-07-01 11:25:14', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (80, 'client.undo.logTable', 'SEATA_GROUP', 'undo_log', '2842d229c24afe9e61437135e8306614', '2021-07-01 11:25:15', '2021-07-01 11:25:15', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (81, 'client.undo.compress.enable', 'SEATA_GROUP', 'true', 'b326b5062b2f0e69046810717534cb09', '2021-07-01 11:25:15', '2021-07-01 11:25:15', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (82, 'client.undo.compress.type', 'SEATA_GROUP', 'zip', 'adcdbd79a8d84175c229b192aadc02f2', '2021-07-01 11:25:16', '2021-07-01 11:25:16', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (83, 'client.undo.compress.threshold', 'SEATA_GROUP', '64k', 'bd44a6458bdbff0b5cac721ba361f035', '2021-07-01 11:25:17', '2021-07-01 11:25:17', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (84, 'log.exceptionRate', 'SEATA_GROUP', '100', 'f899139df5e1059396431415e770c6dd', '2021-07-01 11:25:17', '2021-07-01 11:25:17', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (85, 'transport.serialization', 'SEATA_GROUP', 'seata', 'b943081c423b9a5416a706524ee05d40', '2021-07-01 11:25:18', '2021-07-01 11:25:18', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (86, 'transport.compressor', 'SEATA_GROUP', 'none', '334c4a4c42fdb79d7ebc3e73b517e6f8', '2021-07-01 11:25:18', '2021-07-01 11:25:18', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (87, 'metrics.enabled', 'SEATA_GROUP', 'false', '68934a3e9455fa72420237eb05902327', '2021-07-01 11:25:19', '2021-07-01 11:25:19', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (88, 'metrics.registryType', 'SEATA_GROUP', 'compact', '7cf74ca49c304df8150205fc915cd465', '2021-07-01 11:25:20', '2021-07-01 11:25:20', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (89, 'metrics.exporterList', 'SEATA_GROUP', 'prometheus', 'e4f00638b8a10e6994e67af2f832d51c', '2021-07-01 11:25:20', '2021-07-01 11:25:20', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (90, 'metrics.exporterPrometheusPort', 'SEATA_GROUP', '9898', '7b9dc501afe4ee11c56a4831e20cee71', '2021-07-01 11:25:21', '2021-07-01 11:25:21', NULL, '10.244.29.128', '', 'seata-0001', NULL, NULL, NULL, 'text', NULL);
INSERT INTO `config_info` VALUES (112, 'xincan-user-dev.yaml', 'dev_group', 'address:\n  nacos: 192.168.1.81:31150\n  sentinel: 192.168.1.81:31160\n  mysql:\n    master: 192.168.1.81:31110\n    slave1: 192.168.1.81:31120\n    slave2: 192.168.1.81:31130\n\nserver:\n  port: 8000\n  undertow:\n    # 设置 HTTP POST 内容的最大长度，默认不做限制\n    #  max-http-post-size: -1\n    # 以下的配置会影响buffer,这些buffer会用于服务器连接的IO操作,有点类似netty的池化内存管理\n    # 每块buffer的空间大小,越小的空间被利用越充分\n    buffer-size: 1024\n    # 每个区分配的buffer数量 , 所以pool的大小是buffer-size * buffers-per-region\n    #  buffers-per-region: 1024 # 这个参数不需要写了\n    # 是否分配的直接内存\n    direct-buffers: true\n    threads:\n      # 设置IO线程数, 它主要执行非阻塞的任务,它们会负责多个连接, 默认设置每个CPU核心一个线程,数量和CPU 内核数目一样即可\n      io: 8\n      # 阻塞任务线程池, 当执行类似servlet请求阻塞操作, undertow会从这个线程池中取得线程,它的值设置取决于系统的负载  io-threads*8\n      worker: 64\n\nspring:\n  mvc:\n    throw-exception-if-no-handler-found: true\n\n  cloud:\n    nacos:\n      config:\n        namespace: xincan-${spring.profiles.active}-0001\n        server-addr: ${address.nacos}        # 配置中心url\n        group: ${spring.profiles.active}_group\n        file-extension: yaml                  # 配置文件类型\n        username: nacos\n        password: nacos\n      discovery:\n        server-addr: ${address.nacos}\n        group: ${spring.profiles.active}_group\n        namespace: xincan-${spring.profiles.active}-0001\n        username: nacos\n        password: nacos\n    sentinel:\n      transport:\n        dashboard: ${address.sentinel}\n        port: 8719\n      datasource:\n        flow:\n          nacos:\n            server-addr: ${address.nacos}\n            data-id: ${spring.application.name}-sentinel\n            group-id: ${spring.profiles.active}_group\n            namespace: xincan-${spring.profiles.active}-0001\n            data-type: json\n            rule-type: flow\n            username: nacos\n            password: nacos\n\n  datasource:\n    master:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.master}/xincan-user-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n    slave1:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.slave1}/xincan-user-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n    slave2:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.slave2}/xincan-user-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n\n# 解决Read Timeout 异常\nfeign:\n  client:\n    config:\n      default:\n        read-timeout: 60000\n        connect-timeout: 60000\n\nmanagement:\n  metrics:\n    export:\n      prometheus:\n        step: 1m\n  web:\n    server:\n      auto-time-requests: true\n  endpoints:\n    prometheus:\n      id: ${spring.application.name}\n    web:\n      exposure:\n         include: \'*\'\n        # include: health,info,prometheus,metrics,httptrace,threaddump,heapdump,${spring.application.name},nacos-config\n', 'b54abe8ad36b92cc5f3ee6559a37da4a', '2021-07-01 19:29:35', '2021-07-21 20:38:50', NULL, '10.244.29.129', '', 'xincan-dev-0001', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (209, 'xincan-goods-dev.yaml', 'dev_group', 'address:\n  nacos: 192.168.1.81:31150\n  sentinel: 192.168.1.81:31160\n  mysql:\n    master: 192.168.1.81:31110\n    slave1: 192.168.1.81:31120\n    slave2: 192.168.1.81:31130\n\nserver:\n  port: 8200\n  undertow:\n    # 设置 HTTP POST 内容的最大长度，默认不做限制\n    #  max-http-post-size: -1\n    # 以下的配置会影响buffer,这些buffer会用于服务器连接的IO操作,有点类似netty的池化内存管理\n    # 每块buffer的空间大小,越小的空间被利用越充分\n    buffer-size: 1024\n    # 每个区分配的buffer数量 , 所以pool的大小是buffer-size * buffers-per-region\n    #  buffers-per-region: 1024 # 这个参数不需要写了\n    # 是否分配的直接内存\n    direct-buffers: true\n    threads:\n      # 设置IO线程数, 它主要执行非阻塞的任务,它们会负责多个连接, 默认设置每个CPU核心一个线程,数量和CPU 内核数目一样即可\n      io: 8\n      # 阻塞任务线程池, 当执行类似servlet请求阻塞操作, undertow会从这个线程池中取得线程,它的值设置取决于系统的负载  io-threads*8\n      worker: 64\n\nspring:\n  mvc:\n    throw-exception-if-no-handler-found: true\n\n  cloud:\n    nacos:\n      config:\n        namespace: xincan-${spring.profiles.active}-0001\n        server-addr: ${address.nacos}        # 配置中心url\n        group: ${spring.profiles.active}_group\n        file-extension: yaml                  # 配置文件类型\n        username: nacos\n        password: nacos\n      discovery:\n        server-addr: ${address.nacos}\n        group: ${spring.profiles.active}_group\n        namespace: xincan-${spring.profiles.active}-0001\n        username: nacos\n        password: nacos\n    sentinel:\n      transport:\n        dashboard: ${address.sentinel}\n        port: 8719\n      datasource:\n        flow:\n          nacos:\n            server-addr: ${address.nacos}\n            data-id: ${spring.application.name}-sentinel\n            group-id: ${spring.profiles.active}_group\n            namespace: xincan-${spring.profiles.active}-0001\n            data-type: json\n            rule-type: flow\n            username: nacos\n            password: nacos\n\n  datasource:\n    master:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.master}/xincan-goods-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n    slave1:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.slave1}/xincan-goods-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n    slave2:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.slave2}/xincan-goods-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n\n# 解决Read Timeout 异常\nfeign:\n  client:\n    config:\n      default:\n        read-timeout: 60000\n        connect-timeout: 60000\n\nmanagement:\n  metrics:\n    export:\n      prometheus:\n        step: 1m\n  web:\n    server:\n      auto-time-requests: true\n  endpoints:\n    prometheus:\n      id: ${spring.application.name}\n    web:\n      exposure:\n        include: \'*\'\n        # include: health,info,prometheus,metrics,httptrace,threaddump,heapdump,${spring.application.name},nacos-config\n', '9558269b89fb705be6ab6a6059924697', '2021-07-20 17:24:48', '2021-07-21 20:39:17', NULL, '10.244.29.129', '', 'xincan-dev-0001', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (210, 'xincan-order-dev.yaml', 'dev_group', 'address:\n  nacos: 192.168.1.81:31150\n  sentinel: 192.168.1.81:31160\n  mysql:\n    master: 192.168.1.81:31110\n    slave1: 192.168.1.81:31120\n    slave2: 192.168.1.81:31130\n\nserver:\n  port: 8100\n  undertow:\n    # 设置 HTTP POST 内容的最大长度，默认不做限制\n    #  max-http-post-size: -1\n    # 以下的配置会影响buffer,这些buffer会用于服务器连接的IO操作,有点类似netty的池化内存管理\n    # 每块buffer的空间大小,越小的空间被利用越充分\n    buffer-size: 1024\n    # 每个区分配的buffer数量 , 所以pool的大小是buffer-size * buffers-per-region\n    #  buffers-per-region: 1024 # 这个参数不需要写了\n    # 是否分配的直接内存\n    direct-buffers: true\n    threads:\n      # 设置IO线程数, 它主要执行非阻塞的任务,它们会负责多个连接, 默认设置每个CPU核心一个线程,数量和CPU 内核数目一样即可\n      io: 8\n      # 阻塞任务线程池, 当执行类似servlet请求阻塞操作, undertow会从这个线程池中取得线程,它的值设置取决于系统的负载  io-threads*8\n      worker: 64\n\nspring:\n  mvc:\n    throw-exception-if-no-handler-found: true\n\n  cloud:\n    nacos:\n      config:\n        namespace: xincan-${spring.profiles.active}-0001\n        server-addr: ${address.nacos}        # 配置中心url\n        group: ${spring.profiles.active}_group\n        file-extension: yaml                  # 配置文件类型\n        username: nacos\n        password: nacos\n      discovery:\n        server-addr: ${address.nacos}\n        group: ${spring.profiles.active}_group\n        namespace: xincan-${spring.profiles.active}-0001\n        username: nacos\n        password: nacos\n    sentinel:\n      transport:\n        dashboard: ${address.sentinel}\n        port: 8719\n      datasource:\n        flow:\n          nacos:\n            server-addr: ${address.nacos}\n            data-id: ${spring.application.name}-sentinel\n            group-id: ${spring.profiles.active}_group\n            namespace: xincan-${spring.profiles.active}-0001\n            data-type: json\n            rule-type: flow\n            username: nacos\n            password: nacos\n\n  datasource:\n    master:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.master}/xincan-order-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n    slave1:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.slave1}/xincan-order-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n    slave2:\n      driver-class-name: com.mysql.cj.jdbc.Driver\n      jdbc-url: jdbc:mysql://${address.mysql.slave2}/xincan-order-${spring.profiles.active}?useSSL=true&useUnicode=true&characterEncoding=utf-8&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true&serverTimezone=GMT\n      username: root\n      password: 123456\n\n# 解决Read Timeout 异常\nfeign:\n  client:\n    config:\n      default:\n        read-timeout: 60000\n        connect-timeout: 60000\n\nmanagement:\n  metrics:\n    export:\n      prometheus:\n        step: 1m\n  web:\n    server:\n      auto-time-requests: true\n  endpoints:\n    prometheus:\n      id: ${spring.application.name}\n    web:\n      exposure:\n        include: \'*\'\n        # include: health,info,prometheus,metrics,httptrace,threaddump,heapdump,${spring.application.name},nacos-config\n', '75a6738f94117eade125ac6da02b3a17', '2021-07-20 20:37:56', '2021-07-21 20:39:04', NULL, '10.244.29.129', '', 'xincan-dev-0001', '', '', '', 'yaml', '');
INSERT INTO `config_info` VALUES (217, 'xincan-user-sentinel', 'dev_group', '[\r\n    {\r\n        \"resource\": \"/get/user\",\r\n        \"limitApp\": \"default\",\r\n        \"grade\": 1,\r\n        \"count\": 1,\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0,\r\n        \"clusterMode\": false\r\n    }\r\n]', 'b4c91ec125ab8f0cdefa28afce1187e3', '2021-07-22 19:22:16', '2021-07-22 19:22:16', NULL, '10.244.29.129', '', 'xincan-dev-0001', NULL, NULL, NULL, 'json', NULL);
INSERT INTO `config_info` VALUES (218, 'xincan-goods-sentinel', 'dev_group', '[\n    {\n        \"resource\": \"/{ids}\",\n        \"limitApp\": \"default\",\n        \"grade\": 1,\n        \"count\": 1,\n        \"strategy\": 0,\n        \"controlBehavior\": 0,\n        \"clusterMode\": false\n    }\n]', 'fb4a35a7ae20831c9390242c8b9b14d3', '2021-07-22 19:22:48', '2021-07-22 19:26:36', NULL, '10.244.29.129', '', 'xincan-dev-0001', '', '', '', 'json', '');
INSERT INTO `config_info` VALUES (219, 'xincan-order-sentinel', 'dev_group', '[\r\n    {\r\n        \"resource\": \"/get/user\",\r\n        \"limitApp\": \"default\",\r\n        \"grade\": 1,\r\n        \"count\": 1,\r\n        \"strategy\": 0,\r\n        \"controlBehavior\": 0,\r\n        \"clusterMode\": false\r\n    }\r\n]', 'b4c91ec125ab8f0cdefa28afce1187e3', '2021-07-22 19:23:19', '2021-07-22 19:23:19', NULL, '10.244.29.129', '', 'xincan-dev-0001', NULL, NULL, NULL, 'json', NULL);
INSERT INTO `config_info` VALUES (220, 'xincan-user-rules-flow', 'SENTINEL_GROUP', '[{\"app\":\"xincan-user\",\"clusterConfig\":{\"acquireRefuseStrategy\":0,\"clientOfflineTime\":2000,\"fallbackToLocalWhenFail\":true,\"resourceTimeout\":2000,\"resourceTimeoutStrategy\":0,\"sampleCount\":10,\"strategy\":0,\"thresholdType\":0,\"windowIntervalMs\":1000},\"clusterMode\":false,\"controlBehavior\":0,\"count\":1.0,\"gmtCreate\":1625234627413,\"gmtModified\":1625234627413,\"grade\":1,\"id\":127,\"ip\":\"192.168.2.22\",\"limitApp\":\"default\",\"port\":8720,\"resource\":\"/get/user\",\"strategy\":0}]', '309b99e2b3e77e9333ad5b139b0dda88', '2021-07-22 19:24:05', '2021-07-22 19:24:05', NULL, '10.244.29.129', '', 'xincan-dev-0001', NULL, NULL, NULL, 'json', NULL);

-- ----------------------------
-- Table structure for config_info_aggr
-- ----------------------------
DROP TABLE IF EXISTS `config_info_aggr`;
CREATE TABLE `config_info_aggr`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'group_id',
  `datum_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'datum_id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '内容',
  `gmt_modified` datetime(0) NOT NULL COMMENT '修改时间',
  `app_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfoaggr_datagrouptenantdatum`(`data_id`, `group_id`, `tenant_id`, `datum_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '增加租户字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_aggr
-- ----------------------------

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
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfobeta_datagrouptenant`(`data_id`, `group_id`, `tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_beta' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_beta
-- ----------------------------

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
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT 'source user',
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'source ip',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_configinfotag_datagrouptenanttag`(`data_id`, `group_id`, `tenant_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'config_info_tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config_info_tag
-- ----------------------------

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
-- Records of config_tags_relation
-- ----------------------------

-- ----------------------------
-- Table structure for group_capacity
-- ----------------------------
DROP TABLE IF EXISTS `group_capacity`;
CREATE TABLE `group_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数，，0表示使用默认值',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_group_id`(`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '集群、各Group容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of group_capacity
-- ----------------------------

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
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `src_user` text CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `src_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `op_type` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '' COMMENT '租户字段',
  PRIMARY KEY (`nid`) USING BTREE,
  INDEX `idx_gmt_create`(`gmt_create`) USING BTREE,
  INDEX `idx_gmt_modified`(`gmt_modified`) USING BTREE,
  INDEX `idx_did`(`data_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '多租户改造' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of his_config_info
-- ----------------------------

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `resource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `action` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE INDEX `uk_role_permission`(`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE INDEX `idx_user_role`(`username`, `role`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('nacos', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for tenant_capacity
-- ----------------------------
DROP TABLE IF EXISTS `tenant_capacity`;
CREATE TABLE `tenant_capacity`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `tenant_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
  `quota` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '配额，0表示使用默认值',
  `usage` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '使用量',
  `max_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
  `max_aggr_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '聚合子配置最大个数',
  `max_aggr_size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
  `max_history_count` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '最大变更历史数量',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '租户容量信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_capacity
-- ----------------------------

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
  `gmt_create` bigint(20) NOT NULL COMMENT '创建时间',
  `gmt_modified` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_tenant_info_kptenantid`(`kp`, `tenant_id`) USING BTREE,
  INDEX `idx_tenant_id`(`tenant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'tenant_info' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tenant_info
-- ----------------------------
INSERT INTO `tenant_info` VALUES (1, '1', 'seata-0001', 'seata', 'seata专属空间', 'nacos', 1625109961740, 1625109961740);
INSERT INTO `tenant_info` VALUES (2, '1', 'xincan-dev-0001', 'xincan', '个人应用', 'nacos', 1625111624317, 1625111624317);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('nacos', '$2a$10$EuWPZHzz32dJN7jexM34MOeYirDdFAZm2kuWj7VEOJhhZkDrxfvUu', 1);

SET FOREIGN_KEY_CHECKS = 1;
