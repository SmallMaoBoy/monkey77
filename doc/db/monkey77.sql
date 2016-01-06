/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : monkey77

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-01-03 23:45:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL,
  `account` varchar(25) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `role` tinyint(4) NOT NULL COMMENT '1代表超级管理员、2代表采购员、3代表店员',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_admin';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '111', '123456', '1', null);
INSERT INTO `t_admin` VALUES ('2', '111', '123456', '1', null);

-- ----------------------------
-- Table structure for `t_admin_shop`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_shop`;
CREATE TABLE `t_admin_shop` (
  `shop_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_10` (`shop_id`),
  KEY `FK_Reference_11` (`admin_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`admin_id`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_admin_shop';

-- ----------------------------
-- Records of t_admin_shop
-- ----------------------------

-- ----------------------------
-- Table structure for `t_cart`
-- ----------------------------
DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `good_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `good_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_14` (`good_id`),
  KEY `FK_Reference_15` (`user_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`good_id`) REFERENCES `t_good` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_cart';

-- ----------------------------
-- Records of t_cart
-- ----------------------------

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL COMMENT '商品种类名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_category';

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '苹果');
INSERT INTO `t_category` VALUES ('2', '梨子');
INSERT INTO `t_category` VALUES ('3', '草莓');
INSERT INTO `t_category` VALUES ('4', '桃类');
INSERT INTO `t_category` VALUES ('5', '樱桃');

-- ----------------------------
-- Table structure for `t_cookie_validate`
-- ----------------------------
DROP TABLE IF EXISTS `t_cookie_validate`;
CREATE TABLE `t_cookie_validate` (
  `id` int(11) NOT NULL,
  `session_id` varchar(50) NOT NULL COMMENT 'session产生的id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL COMMENT 'cookie产生时间',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_16` (`user_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_cookie_validate';

-- ----------------------------
-- Records of t_cookie_validate
-- ----------------------------
INSERT INTO `t_cookie_validate` VALUES ('1', 'saohfijaslkfnjkajfklasmflkjsalkfklas', '1', '2015-12-22 12:12:36');
INSERT INTO `t_cookie_validate` VALUES ('2', 'D9D78818D4EED87F27F7FF35CE64DB59', '4', '2015-12-22 12:32:14');
INSERT INTO `t_cookie_validate` VALUES ('3', '82A18E73860AB16F5ABA7FA4AF88DBE9', '4', '2015-12-22 15:21:56');
INSERT INTO `t_cookie_validate` VALUES ('4', '5540574ED86EF573519591CAD370DE95', '4', '2015-12-22 15:30:01');
INSERT INTO `t_cookie_validate` VALUES ('5', '8100DDDDF0A087D391E92BE20A09BE49', '4', '2015-12-22 15:32:40');
INSERT INTO `t_cookie_validate` VALUES ('6', '7EE89DB131886C60BD9991C6C48978A1', '4', '2015-12-22 15:39:54');
INSERT INTO `t_cookie_validate` VALUES ('7', '24C75E6832E5589A3DDE7D9866400557', '4', '2015-12-14 15:43:55');
INSERT INTO `t_cookie_validate` VALUES ('8', '24C75E6832E5589A3DDE7D9866400557', '4', '2015-12-22 16:13:06');
INSERT INTO `t_cookie_validate` VALUES ('9', '4F44915E01DB73AC998C4D74AD286387', '4', '2015-12-22 16:39:21');
INSERT INTO `t_cookie_validate` VALUES ('10', 'CAFDDC1EC38BC5208FB95EBB36FDFA08', '4', '2015-12-22 16:40:54');
INSERT INTO `t_cookie_validate` VALUES ('11', '381A95D18207D15FE473E812320B38C9', '4', '2015-12-22 16:52:11');
INSERT INTO `t_cookie_validate` VALUES ('12', '6DDA5B4492E1048C79A7A7FE469D116F', '4', '2015-12-23 00:58:03');
INSERT INTO `t_cookie_validate` VALUES ('13', '6DDA5B4492E1048C79A7A7FE469D116F', '4', '2015-12-23 00:59:20');
INSERT INTO `t_cookie_validate` VALUES ('14', '6DDA5B4492E1048C79A7A7FE469D116F', '4', '2015-12-23 01:10:51');
INSERT INTO `t_cookie_validate` VALUES ('15', '4BF1355E2FF02F372EA97FCE888D7B7B', '4', '2015-12-23 10:41:14');
INSERT INTO `t_cookie_validate` VALUES ('16', '4C986B16D8EA55B2CFE7FC10CF141485', '5', '2015-12-23 14:48:59');
INSERT INTO `t_cookie_validate` VALUES ('17', '4C986B16D8EA55B2CFE7FC10CF141485', '5', '2015-12-23 14:55:00');
INSERT INTO `t_cookie_validate` VALUES ('18', '3959AEE783A7736223FBF7B322B2E128', '4', '2015-12-25 15:01:48');
INSERT INTO `t_cookie_validate` VALUES ('19', '3959AEE783A7736223FBF7B322B2E128', '4', '2015-12-25 15:26:37');
INSERT INTO `t_cookie_validate` VALUES ('20', '3959AEE783A7736223FBF7B322B2E128', '6', '2015-12-25 15:30:54');

-- ----------------------------
-- Table structure for `t_good`
-- ----------------------------
DROP TABLE IF EXISTS `t_good`;
CREATE TABLE `t_good` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL COMMENT '商品名字',
  `price` float(7,2) NOT NULL COMMENT '商品价格',
  `number` smallint(6) NOT NULL COMMENT '商品剩余数量',
  `status` varchar(5) NOT NULL COMMENT '商品状态',
  `specification` varchar(25) NOT NULL COMMENT '商品规格介绍',
  `origin_place` varchar(25) NOT NULL COMMENT '商品产地',
  `title` varchar(100) NOT NULL COMMENT '展示标题',
  `pic_url` varchar(500) DEFAULT NULL COMMENT '首页图片',
  `category_id` int(11) DEFAULT NULL COMMENT '商品种类',
  `sale_volume` int(11) NOT NULL COMMENT '销量',
  `edible_method` varchar(20) DEFAULT NULL COMMENT '食用方式',
  `storage` varchar(20) DEFAULT NULL COMMENT '存储方式',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`category_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_good';

-- ----------------------------
-- Records of t_good
-- ----------------------------
INSERT INTO `t_good` VALUES ('0', '猕猴桃', '17.90', '1000', '热销', '1kg', '中国', '猕猴桃富含维C，VA等多种维生素和抗氧化物质，能抑制角质细胞抑制力，我们的猕猴桃都是采 摘于南方最大的果园，那里土地肥沃，所以鲜果特别鲜美', 'imgs/mihoutao.jpg', '1', '50', '大火爆炒', '冷藏');
INSERT INTO `t_good` VALUES ('1', '苹果', '19.80', '0', '热销', '1kg', '日本富士山', '进口红苹果，超甜，脆爽！', 'imgs/apple1.jpg', '1', '0', '大火爆炒', '冷藏');
INSERT INTO `t_good` VALUES ('2', '哈密瓜', '13.80', '1000', '热销', '1个', '中国新疆', '哈密瓜活动搞特价，超甜，超抵买', 'imgs/hamigua.jpg', '4', '101', '直接食用', '冷藏');
INSERT INTO `t_good` VALUES ('3', '西瓜', '12.80', '0', '热销', '1个', '中国', '天然水润防晒霜，西瓜的含水量在水果中是首屈一指的，所以特别适合夏季补充人体水分的损失；打造美腿的秘密武器，吃西瓜后排尿量会增加，能使盐分排出体外，减轻浮肿，特别是腿部浮肿；清新化妆水，新鲜的西瓜汁和鲜', 'imgs/watermelon.jpg', '4', '101', '大火爆炒', '避光存储');
INSERT INTO `t_good` VALUES ('4', '水蜜桃', '42.90', '0', '热销', '1kg', '中国', '水蜜桃', 'imgs/a5.jpg', '4', '5', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('5', '香蕉', '5.90', '800', '热销', '1kg', '中国', '香蕉', 'imgs/banana.jpg', '4', '5', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('6', '橘子', '14.80', '15', '热销', '1kg', '中国', '橘子', 'imgs/orange.jpg', '4', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('7', '樱桃', '21.20', '15', '热销', '10个', '中国', '好吃的樱桃桃', 'imgs/thumb.jpg', '5', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('8', '李子', '18.80', '15', '热销', '10个', '中国', '好吃的樱桃桃', 'imgs/lizi.jpg', '5', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('9', '黑加仑', '36.80', '15', '热销', '1kg', '美国', '好吃的樱桃桃', 'imgs/heijialun.jpg', '5', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('10', '榴莲', '78.90', '0', '热销', '1个', '印度', '好吃的樱桃桃', 'imgs/liulian.jpg', '5', '22', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('11', '柠檬', '2.50', '234', '热销', '1个', '中国', '柠檬', 'imgs/lemon.jpg', '5', '20', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('12', '火龙果', '3.20', '123', '热销', '1个', '中国', '火龙果', 'imgs/huolongguo.jpg', '5', '20', '低温烹饪', '避光存储');

-- ----------------------------
-- Table structure for `t_keywords`
-- ----------------------------
DROP TABLE IF EXISTS `t_keywords`;
CREATE TABLE `t_keywords` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT '搜索关键字',
  `count` int(11) NOT NULL COMMENT '搜索次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_keywords';

-- ----------------------------
-- Records of t_keywords
-- ----------------------------
INSERT INTO `t_keywords` VALUES ('1', '苹果', '29');
INSERT INTO `t_keywords` VALUES ('2', 'hamigua', '1');
INSERT INTO `t_keywords` VALUES ('3', '蜜桃', '560');
INSERT INTO `t_keywords` VALUES ('4', '哈密瓜', '60');
INSERT INTO `t_keywords` VALUES ('5', '草莓', '33');
INSERT INTO `t_keywords` VALUES ('6', '泥猴桃', '21');
INSERT INTO `t_keywords` VALUES ('7', '梨子', '82');
INSERT INTO `t_keywords` VALUES ('8', '桃', '93');
INSERT INTO `t_keywords` VALUES ('9', '新西兰', '58');
INSERT INTO `t_keywords` VALUES ('10', '四川', '86');
INSERT INTO `t_keywords` VALUES ('11', '香蕉', '7');
INSERT INTO `t_keywords` VALUES ('12', '西瓜', '48');
INSERT INTO `t_keywords` VALUES ('13', '火龙果', '88');
INSERT INTO `t_keywords` VALUES ('14', '??', '1');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL,
  `status` varchar(5) NOT NULL COMMENT '订单状态',
  `total_price` float(7,2) NOT NULL COMMENT '订单价格',
  `reamarks` varchar(200) DEFAULT NULL COMMENT '订单备注',
  `generated_time` datetime DEFAULT NULL COMMENT '生成订单时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `take_time` datetime DEFAULT NULL COMMENT '提取时间',
  `shop_id` int(11) DEFAULT NULL COMMENT '提取点id',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_9` (`shop_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_order';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL COMMENT '订单id',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `good_number` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`order_id`),
  KEY `FK_Reference_8` (`good_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`good_id`) REFERENCES `t_good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_order_detail';

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_product_pic`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_pic`;
CREATE TABLE `t_product_pic` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL COMMENT '商品id',
  `type` tinyint(4) NOT NULL COMMENT '图片类型：0代表轮廓图，1代表商品介绍图',
  `pic_url` varchar(500) NOT NULL COMMENT '商品详情图片位置',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`product_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`product_id`) REFERENCES `t_good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_product_pic';

-- ----------------------------
-- Records of t_product_pic
-- ----------------------------
INSERT INTO `t_product_pic` VALUES ('1', '1', '0', 'imgs/mihoutao1.jpg');
INSERT INTO `t_product_pic` VALUES ('2', '1', '0', 'imgs/mihoutao2.jpg');
INSERT INTO `t_product_pic` VALUES ('3', '1', '0', 'imgs/mihoutao1.jpg');
INSERT INTO `t_product_pic` VALUES ('4', '1', '0', 'imgs/mihoutao1.jpg');
INSERT INTO `t_product_pic` VALUES ('5', '1', '1', 'imgs/p2.jpg');
INSERT INTO `t_product_pic` VALUES ('6', '1', '1', 'imgs/p2.jpg');
INSERT INTO `t_product_pic` VALUES ('7', '1', '1', 'imgs/p2.jpg');

-- ----------------------------
-- Table structure for `t_root`
-- ----------------------------
DROP TABLE IF EXISTS `t_root`;
CREATE TABLE `t_root` (
  `id` int(11) NOT NULL,
  `account` varchar(50) DEFAULT NULL COMMENT '超级管理员账号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_root';

-- ----------------------------
-- Records of t_root
-- ----------------------------
INSERT INTO `t_root` VALUES ('1', '111', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `t_root` VALUES ('2', '121', 'E10ADC3949BA59ABBE56E057F20F883E');

-- ----------------------------
-- Table structure for `t_shop`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '提取点名字',
  `description` varchar(200) NOT NULL COMMENT '提取点介绍',
  `location` varchar(100) NOT NULL COMMENT '提取点位置',
  `is_default` tinyint(4) DEFAULT NULL COMMENT '是否为默认提取点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_shop';

-- ----------------------------
-- Records of t_shop
-- ----------------------------

-- ----------------------------
-- Table structure for `t_shop_good`
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_good`;
CREATE TABLE `t_shop_good` (
  `shop_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  PRIMARY KEY (`shop_id`,`good_id`),
  KEY `FK_Reference_4` (`good_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`good_id`) REFERENCES `t_good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_shop_good';

-- ----------------------------
-- Records of t_shop_good
-- ----------------------------

-- ----------------------------
-- Table structure for `t_show_pic`
-- ----------------------------
DROP TABLE IF EXISTS `t_show_pic`;
CREATE TABLE `t_show_pic` (
  `id` int(11) NOT NULL,
  `pic_url` varchar(500) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `good_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_17` (`good_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`good_id`) REFERENCES `t_good` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_show_pic';

-- ----------------------------
-- Records of t_show_pic
-- ----------------------------
INSERT INTO `t_show_pic` VALUES ('1', '/imgs/1446692884_pic.jpg', '1', 'nothing...', null);

-- ----------------------------
-- Table structure for `t_sms_identifying_code`
-- ----------------------------
DROP TABLE IF EXISTS `t_sms_identifying_code`;
CREATE TABLE `t_sms_identifying_code` (
  `id` int(11) NOT NULL,
  `mobile` varchar(20) NOT NULL COMMENT '手机号码',
  `identifying_code` varchar(10) NOT NULL COMMENT '验证码',
  `create_time` datetime NOT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_sms_identifying_code';

-- ----------------------------
-- Records of t_sms_identifying_code
-- ----------------------------
INSERT INTO `t_sms_identifying_code` VALUES ('1', '110', '123456', '2015-12-18 16:27:43');
INSERT INTO `t_sms_identifying_code` VALUES ('2', '110', '123555', '2015-12-18 16:28:20');
INSERT INTO `t_sms_identifying_code` VALUES ('3', '112', '123555', '2015-12-18 16:42:46');
INSERT INTO `t_sms_identifying_code` VALUES ('4', '112', '1235665', '2015-12-18 16:43:18');
INSERT INTO `t_sms_identifying_code` VALUES ('5', '13631405356', '7071', '2015-12-18 21:03:23');
INSERT INTO `t_sms_identifying_code` VALUES ('6', '13631315798', '4916', '2015-12-18 22:06:52');
INSERT INTO `t_sms_identifying_code` VALUES ('7', '13631315179', '5687', '2015-12-20 00:23:53');
INSERT INTO `t_sms_identifying_code` VALUES ('8', '13631315179', '2680', '2015-12-23 01:01:55');
INSERT INTO `t_sms_identifying_code` VALUES ('9', '13631315179', '9826', '2015-12-23 12:27:28');
INSERT INTO `t_sms_identifying_code` VALUES ('10', '13631315798', '3394', '2015-12-23 14:43:14');
INSERT INTO `t_sms_identifying_code` VALUES ('11', '13533867820', '9995', '2015-12-25 15:29:15');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `sex` tinyint(4) DEFAULT '0' COMMENT '性别',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_user';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '136', '123456', null);
INSERT INTO `t_user` VALUES ('2', '1', '136', '123456', null);
INSERT INTO `t_user` VALUES ('3', '1', '136', '123456', null);
INSERT INTO `t_user` VALUES ('4', '0', '13631315179', 'E10ADC3949BA59ABBE56E057F20F883E', 'mao');
INSERT INTO `t_user` VALUES ('5', '0', '13631315798', 'E10ADC3949BA59ABBE56E057F20F883E', '用户13631315798');
INSERT INTO `t_user` VALUES ('6', '0', '13533867820', 'EE95517FC8212A4211F6040DE06B9BE6', '??13533867820');

-- ----------------------------
-- Table structure for `t_user_good`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_good`;
CREATE TABLE `t_user_good` (
  `user_id` int(11) DEFAULT NULL,
  `good_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_12` (`good_id`),
  KEY `FK_Reference_13` (`user_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`good_id`) REFERENCES `t_good` (`id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_user_good';

-- ----------------------------
-- Records of t_user_good
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order`;
CREATE TABLE `t_user_order` (
  `user_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`order_id`),
  KEY `FK_Reference_6` (`order_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_user_order';

-- ----------------------------
-- Records of t_user_order
-- ----------------------------
