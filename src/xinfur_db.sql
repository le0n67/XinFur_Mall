/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50719 (5.7.19)
 Source Host           : localhost:3306
 Source Schema         : xinfur_db

 Target Server Type    : MySQL
 Target Server Version : 50719 (5.7.19)
 File Encoding         : 65001

 Date: 03/04/2025 16:30:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
create database xinfur_db;
-- ----------------------------
-- Table structure for furn
-- ----------------------------
DROP TABLE IF EXISTS `furn`;
CREATE TABLE `furn`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `maker` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `sales` int(10) UNSIGNED NOT NULL,
  `stock` int(10) UNSIGNED NOT NULL,
  `img_path` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of furn
-- ----------------------------
INSERT INTO `furn` VALUES (1, '北欧风格小桌子', '东星家居', 180.00, 65, 1, 'assets/images/product-image/6.jpg');
INSERT INTO `furn` VALUES (2, '猩猩床头柜', '猩猩家居', 80.00, 79, 45, 'assets/images/product-image/13.jpg');
INSERT INTO `furn` VALUES (3, '典雅风格小台灯', '猩猩家居', 50.00, 12, 4, 'assets/images/product-image/3.jpg');
INSERT INTO `furn` VALUES (4, 'simple椅子', '东星家居', 100.00, 5, 3, 'assets/images/product-image/1.jpg');
INSERT INTO `furn` VALUES (5, '无敌垃圾桶凳子', '猩猩董事长', 9999.99, 0, 3, 'assets/images/product-image/bin.jpg');
INSERT INTO `furn` VALUES (6, '花狗的猫', '花狗', 999.00, 1, 0, 'assets/images/product-image/lrh.jpg');
INSERT INTO `furn` VALUES (8, '地板|略有磨损', '东星家居', 288.00, 1007, 103, 'assets/images/product-image/16.jpg');
INSERT INTO `furn` VALUES (15, '猩猩演讲台', '黑心猩', 99999.00, 0, 1, 'assets/images/product-image/speech.jpg');
INSERT INTO `furn` VALUES (16, '黑心猩猩床', '黑心猩', 999.00, 1, 0, 'assets/images/product-image/default.jpg');
INSERT INTO `furn` VALUES (17, '老韩衣柜', '老韩', 200.00, 123, 111, 'assets/images/product-image/10.jpg');
INSERT INTO `furn` VALUES (19, '提醒标识牌', '猩猩家居', 2.00, 4, 3, 'assets/images/product-image/notice.jpg');
INSERT INTO `furn` VALUES (20, '四维置物柜', '三体人', 3.00, 3, 15, 'assets/images/product-image/7.jpg');
INSERT INTO `furn` VALUES (21, '小东星同款学习桌', '东星家居', 4.00, 4, 155, 'assets/images/product-image/8.jpg');
INSERT INTO `furn` VALUES (22, '三爪鱼夜灯', '海底小纵队', 15.00, 3, 26, 'assets/images/product-image/12.jpg');
INSERT INTO `furn` VALUES (23, '金铲铲门牌', 'Timi', 0.99, 123, 33, 'assets/images/product-image/jcc.jpg');
INSERT INTO `furn` VALUES (24, '野生自习桌', '猩猩家居', 0.00, 999, 999, 'assets/images/product-image/lq.jpg');
INSERT INTO `furn` VALUES (25, '宠物坐便器', '猩猩爱宠', 800.00, 12, 80, 'assets/images/product-image/wc.jpg');
INSERT INTO `furn` VALUES (26, '天然泥土沙发', '猩猩爱宠', 0.01, 999, 999, 'assets/images/product-image/sofa.jpg');
INSERT INTO `furn` VALUES (27, '开业大酬宾', '买一斤送半斤', 1.00, 1, 1, 'assets/images/product-image/b1cbd065-5c58-4f85-91e3-48a6ffc9c7bb_1721312117097_chii.jpg');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin@admin.com');
INSERT INTO `member` VALUES (2, 'root', '63a9f0ea7bb98050796b649e85481845', 'root@root.com');
INSERT INTO `member` VALUES (3, 'Dog', 'e10adc3949ba59abbe56e057f20f883e', 'dog@dog.com');
INSERT INTO `member` VALUES (4, 'Gandalf', 'ab17850978e36aaf6a2b8808f1ded971', 'gandalf@ring.com');
INSERT INTO `member` VALUES (5, 'Piping', 'bad6a32d43d221c434470192ee1dbf4d', 'piping@ring.com');
INSERT INTO `member` VALUES (6, 'Leon', '5c443b2003676fa5e8966030ce3a86ea', 'le0n67@163.com');
INSERT INTO `member` VALUES (7, 'Bob', '65ba841e01d6db7733e90a5b7f9e6f80', 'bob@bbbb.com');
INSERT INTO `member` VALUES (8, 'Jerry', '30035607ee5bb378c71ab434a6d05410', 'jerry@cat.com');
INSERT INTO `member` VALUES (9, 'Trump', '81dc9bdb52d04dc20036dbd8313ed055', '123@123.com');
INSERT INTO `member` VALUES (10, 'nobody', 'e10adc3949ba59abbe56e057f20f883e', 'nobody@qq.com');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `member_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('17209442637112', '2024-07-14 16:04:24', 368.00, 0, 2);
INSERT INTO `order` VALUES ('17209442758672', '2024-07-14 16:04:36', 80.00, 0, 2);
INSERT INTO `order` VALUES ('17209446541842', '2024-07-14 16:10:54', 80.00, 0, 2);
INSERT INTO `order` VALUES ('17210516970412', '2024-07-15 21:54:57', 468.00, 0, 2);
INSERT INTO `order` VALUES ('17320880086642', '2024-11-20 15:33:29', 999.00, 0, 2);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NOT NULL,
  `count` int(11) NOT NULL,
  `total_price` decimal(11, 2) NOT NULL,
  `order_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (33, '猩猩床头柜', 80.00, 1, 80.00, '17209442637112');
INSERT INTO `order_item` VALUES (34, '地板|略有磨损', 288.00, 1, 288.00, '17209442637112');
INSERT INTO `order_item` VALUES (35, '猩猩床头柜', 80.00, 1, 80.00, '17209442758672');
INSERT INTO `order_item` VALUES (36, '猩猩床头柜', 80.00, 1, 80.00, '17209446541842');
INSERT INTO `order_item` VALUES (37, '猩猩床头柜', 80.00, 1, 80.00, '17210516970412');
INSERT INTO `order_item` VALUES (38, 'simple椅子', 100.00, 1, 100.00, '17210516970412');
INSERT INTO `order_item` VALUES (39, '地板|略有磨损', 288.00, 1, 288.00, '17210516970412');
INSERT INTO `order_item` VALUES (40, '黑心猩猩床', 999.00, 1, 999.00, '17320880086642');

SET FOREIGN_KEY_CHECKS = 1;
