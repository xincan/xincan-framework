/*
 Navicat Premium Data Transfer

 Source Server         : 阿里-k8s-mysql-master-31110
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 192.168.1.81:31110
 Source Schema         : xincan-goods-dev

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 22/07/2021 19:33:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '商品ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `quantity` int(9) NOT NULL COMMENT '商品个数',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '商品描述',
  `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人员ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `edit_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编辑人员ID',
  `edit_time` datetime(0) NULL DEFAULT NULL COMMENT '编辑时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1417457974364454913', '印度小叶紫檀108颗老料包浆', 326.05, 10, '佛珠用途描述，把玩，收藏，专卖', '1285759156342562818', '2021-07-20 12:14:51', '1285759156342562818', '2021-07-20 12:14:51');
INSERT INTO `goods` VALUES ('1417726917956083714', '手机', 1888.89, 30, '8核4G，3个摄像头5000万像素', '1285759156342562818', '2021-07-21 06:03:32', '1285759156342562818', '2021-07-21 06:03:32');
INSERT INTO `goods` VALUES ('1418171811791101953', '老三样', 1000.00, 50, '野战蓝鲫、速攻2号、九一八', '1285759156342562818', '2021-07-22 11:31:23', '1285759156342562818', '2021-07-22 11:31:23');
INSERT INTO `goods` VALUES ('1418172078276206594', '鱼竿', 3288.88, 50, '化氏龙纹鲤只要3288.88就能拿下', '1285759156342562818', '2021-07-22 11:32:26', '1285759156342562818', '2021-07-22 11:32:26');

SET FOREIGN_KEY_CHECKS = 1;
