# 账务管理系统

src包结构说明

![src包结构说明](D:\Users\lenovo\Desktop\Java-账务管理系统\src包结构说明.jpg)



运行环境：
	JDK、MySql5.0
软件：
	IntelliJ IDEA 2024.1.4（教育版也行）
	navicat
	MySql
步骤：
	打开navicat准备数据库数据>>>建立连接-->新建数据库zhangwu，字符集选择utf-8类型-->新建查询，粘贴数据库代码-->生成两张表zhangwu、zw_user
	打开IntelliJ IDEA，改变druid.properties中的配置信息>>>打开项目结构，选择合适的jdk版本>>>寻找是否有报错的地方，解决

![druid.properties中配置信息](D:\Users\lenovo\Desktop\Java-账务管理系统\druid.properties中配置信息.png)

​	运行MainView>>>输入数据库表中保存的用户名密码>>>登录成功，选择业务>>>结束后结束运行


说明：这只能作为大学课程设计作业，项目可能还有很多不完善的地方，可以留言批评改正



数据库文件准备

```mysql
/*
 Navicat Premium Data Transfer

 Source Server         : pan
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : zhangwu

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 04/09/2024 19:20:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zhangwu
-- ----------------------------
DROP TABLE IF EXISTS `zhangwu`;
CREATE TABLE `zhangwu`  (
  `zwid` int(11) NOT NULL AUTO_INCREMENT,
  `flname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  `zhanghu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` date NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`zwid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhangwu
-- ----------------------------
INSERT INTO `zhangwu` VALUES (1, '吃饭支出', 247, '交通银行', '2016-03-02', '家庭聚餐');
INSERT INTO `zhangwu` VALUES (2, '工资收入', 12345, '现金', '2016-03-15', '开工资了');
INSERT INTO `zhangwu` VALUES (3, '服装支出', 3333, '交通银行', '2024-06-27', '买买买');
INSERT INTO `zhangwu` VALUES (4, '吃饭支出', 325, '现金', '2016-06-18', '朋友聚餐');
INSERT INTO `zhangwu` VALUES (5, '学习', 2222, '交通银行', '2022-02-19', '报班');
INSERT INTO `zhangwu` VALUES (6, '股票收入', 5000, '工商银行', '2016-10-28', '股票又大涨');
INSERT INTO `zhangwu` VALUES (7, '工资收入', 5000, '交通银行', '2016-10-28', '又开工资了');
INSERT INTO `zhangwu` VALUES (8, '礼金支出', 5000, '现金', '2016-10-28', '朋友结婚');
INSERT INTO `zhangwu` VALUES (9, '其他支出', 1560, '现金', '2016-10-29', '丢钱了');
INSERT INTO `zhangwu` VALUES (10, '交通支出', 2300, '交通银行', '2016-10-29', '油价还在涨啊');
INSERT INTO `zhangwu` VALUES (12, '工资收入', 1000, '现金', '2016-10-30', '开资');
INSERT INTO `zhangwu` VALUES (13, '交通支出', 2000, '现金', '2016-10-30', '机票好贵');
INSERT INTO `zhangwu` VALUES (14, '工资收入', 5000, '现金', '2016-10-30', '又开资');
INSERT INTO `zhangwu` VALUES (15, '学习', 200, '现金', '2024-06-27', '别管我');
INSERT INTO `zhangwu` VALUES (18, '游戏', 200, '微信', '2024-07-12', '皮肤');

-- ----------------------------
-- Table structure for zw_user
-- ----------------------------
DROP TABLE IF EXISTS `zw_user`;
CREATE TABLE `zw_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zw_user
-- ----------------------------
INSERT INTO `zw_user` VALUES (1, '潘潘', '123456');

SET FOREIGN_KEY_CHECKS = 1;

```

