/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : monkey77

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-01-15 14:32:24
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
-- Table structure for `t_business`
-- ----------------------------
DROP TABLE IF EXISTS `t_business`;
CREATE TABLE `t_business` (
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `id` int(11) NOT NULL,
  `worklocation` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_business
-- ----------------------------
INSERT INTO `t_business` VALUES ('alex', '123', '0', '', '');
INSERT INTO `t_business` VALUES ('zhuang', '123', '1', 'zzz', 'nan');
INSERT INTO `t_business` VALUES ('togogo', 'asd', '2', 'asd', 'asd');
INSERT INTO `t_business` VALUES ('sad', '123', '3', 's', 's');
INSERT INTO `t_business` VALUES ('庄毛毛', '123', '8', '北京', '男');
INSERT INTO `t_business` VALUES ('在阿斯顿', '123', '9', '北京dd', '男');
INSERT INTO `t_business` VALUES ('为', '可以', '11', '谷歌', '什么');
INSERT INTO `t_business` VALUES ('在阿斯顿', '123', '12', '北京dd', '男');
INSERT INTO `t_business` VALUES ('在阿斯顿', '123', '13', '北京dd', '男');
INSERT INTO `t_business` VALUES ('zzz', '11', '14', '11', '11');

-- ----------------------------
-- Table structure for `t_buyer`
-- ----------------------------
DROP TABLE IF EXISTS `t_buyer`;
CREATE TABLE `t_buyer` (
  `id` int(5) NOT NULL,
  `account` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `worklocation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_buyer
-- ----------------------------
INSERT INTO `t_buyer` VALUES ('0', 'alexbuyer', '123456', 'Alexsander', 'male', 'China');
INSERT INTO `t_buyer` VALUES ('1', 'zhuang ', 'zhuang ', 'zhuang', 'zhuang', 'zhuang');

-- ----------------------------
-- Table structure for `t_buyorder`
-- ----------------------------
DROP TABLE IF EXISTS `t_buyorder`;
CREATE TABLE `t_buyorder` (
  `id` int(20) NOT NULL,
  `good` varchar(1024) DEFAULT NULL COMMENT '商品（苹果什么的）',
  `buyinprice` int(20) DEFAULT NULL COMMENT '买入价格',
  `status` varchar(20) DEFAULT NULL COMMENT '订单状态',
  `dayprice` int(20) DEFAULT NULL COMMENT '当天的水果价格',
  `number` varchar(20) DEFAULT NULL COMMENT '买入商品数量（例：苹果多少斤）',
  `sum` varchar(20) DEFAULT NULL COMMENT '总计',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_buyorder
-- ----------------------------
INSERT INTO `t_buyorder` VALUES ('0', '苹果', '5', '待发送', '4', '20', null);
INSERT INTO `t_buyorder` VALUES ('1', '香蕉', '1', '待发送', '2', '10', null);
INSERT INTO `t_buyorder` VALUES ('2', '梨', '2', '逾期作废', '3', '50', null);
INSERT INTO `t_buyorder` VALUES ('3', '猕猴桃', '10', '待付款', '11', '22', null);
INSERT INTO `t_buyorder` VALUES ('4', '草莓', '1', '待完善', '2', '5', null);
INSERT INTO `t_buyorder` VALUES ('5', '蓝莓', '1', '待完善', '2', '5', null);
INSERT INTO `t_buyorder` VALUES ('6', '桃子', '1', '待完善', '2', '5', null);
INSERT INTO `t_buyorder` VALUES ('7', '罗汉果', '1', '待完善', '2', '1', null);
INSERT INTO `t_buyorder` VALUES ('8', '火龙果', '1', '待完善', '2', '1', null);
INSERT INTO `t_buyorder` VALUES ('9', '哈密瓜', '1', '待完善', '2', '1', null);
INSERT INTO `t_buyorder` VALUES ('10', '木瓜', '1', '待完善', '2', '1', null);
INSERT INTO `t_buyorder` VALUES ('11', '核桃', '2', '待完善', '5', '10', null);

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
INSERT INTO `t_cart` VALUES ('2', '1', '200', '6');
INSERT INTO `t_cart` VALUES ('2', '5', '100', '7');

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
INSERT INTO `t_cookie_validate` VALUES ('21', '287FCD393704B1238FDD8DB51543E158', '4', '2016-01-10 14:37:34');
INSERT INTO `t_cookie_validate` VALUES ('22', '4786939878AF71416E4FEFED6DAA037E', '4', '2016-01-11 16:09:36');
INSERT INTO `t_cookie_validate` VALUES ('23', '43E5C0BE1FF84E2CA7D1D130EE3782C0', '4', '2016-01-11 16:23:49');
INSERT INTO `t_cookie_validate` VALUES ('24', '43E5C0BE1FF84E2CA7D1D130EE3782C0', '4', '2016-01-11 16:32:17');
INSERT INTO `t_cookie_validate` VALUES ('25', '7008E27E1EB0D96CF21C3B52729D6B3F', '4', '2016-01-11 21:07:01');
INSERT INTO `t_cookie_validate` VALUES ('26', '7008E27E1EB0D96CF21C3B52729D6B3F', '4', '2016-01-11 21:11:09');
INSERT INTO `t_cookie_validate` VALUES ('27', '7008E27E1EB0D96CF21C3B52729D6B3F', '4', '2016-01-11 21:12:10');
INSERT INTO `t_cookie_validate` VALUES ('28', '0A7B685313770466A0069FE05CEE9FBF', '4', '2016-01-12 20:27:14');
INSERT INTO `t_cookie_validate` VALUES ('29', '6BC63CFAFB1DAB4E9F9C73ACAC10957A', '6', '2016-01-12 20:41:39');
INSERT INTO `t_cookie_validate` VALUES ('30', '537D2F9B01A81489A3C48490D7B88C03', '6', '2016-01-12 22:20:53');
INSERT INTO `t_cookie_validate` VALUES ('31', '198BF18AA697F7DEE649025CD64D0129', '4', '2016-01-12 23:36:50');
INSERT INTO `t_cookie_validate` VALUES ('32', 'CF1952584A8B9D51517E3149C29BC0BA', '6', '2016-01-13 10:02:10');
INSERT INTO `t_cookie_validate` VALUES ('33', '28D66271EE72DE854934B13CBB8F36B4', '6', '2016-01-13 10:04:39');
INSERT INTO `t_cookie_validate` VALUES ('34', '28D66271EE72DE854934B13CBB8F36B4', '6', '2016-01-13 11:37:00');
INSERT INTO `t_cookie_validate` VALUES ('35', '9C21318A6760AA15473766BC29E727E2', '4', '2016-01-13 11:40:12');
INSERT INTO `t_cookie_validate` VALUES ('36', '863075FB9EC3B7F411D218635039AC87', '6', '2016-01-13 12:15:10');

-- ----------------------------
-- Table structure for `t_day_sale`
-- ----------------------------
DROP TABLE IF EXISTS `t_day_sale`;
CREATE TABLE `t_day_sale` (
  `id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `num` int(11) NOT NULL COMMENT '商品数目',
  `sale_date` date NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`),
  KEY `fk_day_sale_good` (`good_id`),
  CONSTRAINT `fk_day_sale_good` FOREIGN KEY (`good_id`) REFERENCES `t_good` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_day_sale
-- ----------------------------
INSERT INTO `t_day_sale` VALUES ('1', '4', '2', '2016-01-10');
INSERT INTO `t_day_sale` VALUES ('2', '4', '2', '2016-01-11');
INSERT INTO `t_day_sale` VALUES ('3', '1', '213', '2016-01-12');
INSERT INTO `t_day_sale` VALUES ('4', '9', '52', '2016-01-12');
INSERT INTO `t_day_sale` VALUES ('5', '0', '9', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('6', '5', '104', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('7', '8', '10', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('8', '11', '8', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('9', '2', '8', '2016-01-12');
INSERT INTO `t_day_sale` VALUES ('10', '7', '7', '2016-01-12');
INSERT INTO `t_day_sale` VALUES ('11', '6', '8', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('12', '12', '3', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('13', '7', '11', '2016-01-13');
INSERT INTO `t_day_sale` VALUES ('14', '2', '10', '2016-01-13');

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
INSERT INTO `t_good` VALUES ('1', '苹果', '19.80', '0', '热销', '1kg', '日本富士山', '进口红苹果，超甜，脆爽！', 'imgs/apple1.jpg', '1', '200', '大火爆炒', '冷藏');
INSERT INTO `t_good` VALUES ('2', '哈密瓜', '13.80', '1000', '热销', '1个', '中国新疆', '哈密瓜活动搞特价，超甜，超抵买', 'imgs/hamigua.jpg', '4', '101', '直接食用', '冷藏');
INSERT INTO `t_good` VALUES ('3', '西瓜', '12.80', '0', '热销', '1个', '中国', '天然水润防晒霜，西瓜的含水量在水果中是首屈一指的，所以特别适合夏季补充人体水分的损失；打造美腿的秘密武器，吃西瓜后排尿量会增加，能使盐分排出体外，减轻浮肿，特别是腿部浮肿；清新化妆水，新鲜的西瓜汁和鲜', 'imgs/watermelon.jpg', '4', '101', '大火爆炒', '避光存储');
INSERT INTO `t_good` VALUES ('4', '水蜜桃', '42.90', '0', '热销', '1kg', '中国', '水蜜桃', 'imgs/a5.jpg', '4', '5', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('5', '香蕉', '5.00', '400', '热销', '1kg', '中国', '香蕉', 'imgs/banana.jpg', '4', '5', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('6', '橘子', '14.80', '15', '热销', '1kg', '中国', '橘子', 'imgs/orange.jpg', '4', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('7', '樱桃', '21.20', '15', '热销', '10个', '中国', '好吃的樱桃桃', 'imgs/thumb.jpg', '5', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('8', '李子', '18.80', '15', '热销', '10个', '中国', '好吃的樱桃桃', 'imgs/lizi.jpg', '5', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('9', '黑加仑', '36.80', '15', '热销', '1kg', '美国', '好吃的樱桃桃', 'imgs/heijialun.jpg', '5', '50', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('10', '榴莲', '78.90', '0', '热销', '1个', '印度', '好吃的樱桃桃', 'imgs/liulian.jpg', '5', '22', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('11', '柠檬', '6.00', '234', '热销', '1个', '中国', '柠檬', 'imgs/lemon.jpg', '5', '20', '低温烹饪', '避光存储');
INSERT INTO `t_good` VALUES ('12', '火龙果', '4.50', '367', '热销', '1个', '中国', '火龙果', 'imgs/huolongguo.jpg', '5', '20', '低温烹饪', '避光存储');

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
INSERT INTO `t_keywords` VALUES ('1', '苹果', '30');
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
INSERT INTO `t_keywords` VALUES ('12', '西瓜', '50');
INSERT INTO `t_keywords` VALUES ('13', '火龙果', '88');
INSERT INTO `t_keywords` VALUES ('14', '??', '1');
INSERT INTO `t_keywords` VALUES ('15', '榴莲', '3');
INSERT INTO `t_keywords` VALUES ('16', '中国', '2');
INSERT INTO `t_keywords` VALUES ('17', '日本', '1');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL,
  `status` varchar(1024) NOT NULL COMMENT '订单状态',
  `total_price` float(7,2) DEFAULT NULL COMMENT '订单价格',
  `generated_time` datetime DEFAULT NULL COMMENT '生成订单时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `take_time` datetime DEFAULT NULL COMMENT '提取时间',
  `shop_id` int(11) DEFAULT NULL COMMENT '提取点id',
  `remarks` varchar(255) DEFAULT NULL,
  `pay_way` varchar(10) DEFAULT NULL COMMENT '支付方式',
  `order_no` varchar(20) NOT NULL COMMENT '订单号',
  `submission_time` datetime DEFAULT NULL COMMENT '订单提交时间',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_9` (`shop_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`shop_id`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_order';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('0', '已送至提取点中', '100.00', '2016-01-05 01:22:22', '2016-01-01 01:22:32', '2016-01-01 01:22:37', null, '找人代拿', null, '', null);
INSERT INTO `t_order` VALUES ('1', '已送至提取点中', '200.00', null, null, null, null, '随便写', null, '', null);
INSERT INTO `t_order` VALUES ('2', '已送至提取点中', '21.00', null, null, null, null, null, '货到付款', 'MK201601091515430001', null);
INSERT INTO `t_order` VALUES ('3', '待完善', null, '2016-01-10 16:13:39', null, null, null, null, null, 'MK201601101613390001', null);
INSERT INTO `t_order` VALUES ('4', '待完善', null, '2016-01-10 16:20:49', null, null, null, null, null, 'MK201601101620490001', null);
INSERT INTO `t_order` VALUES ('5', '待完善', null, '2016-01-10 16:23:22', null, null, null, null, null, 'MK201601101623220001', null);
INSERT INTO `t_order` VALUES ('6', '待完善', null, '2016-01-10 16:23:49', null, null, null, null, null, 'MK201601101623490001', null);
INSERT INTO `t_order` VALUES ('7', '待完善', null, '2016-01-10 16:46:09', null, null, null, null, null, 'MK201601101646090001', null);
INSERT INTO `t_order` VALUES ('8', '待付款', null, '2016-01-10 16:47:22', null, null, '1', '加饭', '在线支付', 'MK201601101647220001', '2016-01-10 18:15:07');
INSERT INTO `t_order` VALUES ('9', '待完善', null, '2016-01-10 17:13:01', null, null, null, null, null, 'MK201601101713010001', null);
INSERT INTO `t_order` VALUES ('10', '待完善', null, '2016-01-10 17:13:33', null, null, null, null, null, 'MK201601101713330001', null);
INSERT INTO `t_order` VALUES ('11', '待完善', null, '2016-01-10 17:17:05', null, null, null, null, null, 'MK201601101717050001', null);
INSERT INTO `t_order` VALUES ('12', '待购买', null, '2016-01-11 01:46:05', null, null, '1', '加饭', '在线支付', 'MK201601110146050001', '2016-01-11 01:47:16');
INSERT INTO `t_order` VALUES ('13', '待完善', null, '2016-01-12 14:03:55', null, null, null, null, null, 'MK201601121403550001', null);
INSERT INTO `t_order` VALUES ('14', '待完善', null, '2016-01-12 14:04:20', null, null, null, null, null, 'MK201601121404200001', null);
INSERT INTO `t_order` VALUES ('15', '待完善', null, '2016-01-12 14:13:59', null, null, null, null, null, 'MK201601121413590001', null);
INSERT INTO `t_order` VALUES ('16', '待完善', null, '2016-01-12 14:14:38', null, null, null, null, null, 'MK201601121414380001', null);
INSERT INTO `t_order` VALUES ('17', '待完善', null, '2016-01-12 14:15:36', null, null, null, null, null, 'MK201601121415360001', null);
INSERT INTO `t_order` VALUES ('18', '待完善', null, '2016-01-12 14:20:55', null, null, null, null, null, 'MK201601121420550001', null);
INSERT INTO `t_order` VALUES ('19', '待完善', null, '2016-01-12 14:21:09', null, null, null, null, null, 'MK201601121421090001', null);
INSERT INTO `t_order` VALUES ('20', '待完善', null, '2016-01-12 14:21:24', null, null, null, null, null, 'MK201601121421240001', null);
INSERT INTO `t_order` VALUES ('21', '待完善', null, '2016-01-12 14:22:36', null, null, null, null, null, 'MK201601121422360001', null);
INSERT INTO `t_order` VALUES ('22', '待完善', null, '2016-01-12 14:24:11', null, null, null, null, null, 'MK201601121424110001', null);
INSERT INTO `t_order` VALUES ('23', '待完善', null, '2016-01-12 14:26:08', null, null, null, null, null, 'MK201601121426080001', null);
INSERT INTO `t_order` VALUES ('24', '待完善', null, '2016-01-12 15:00:24', null, null, null, null, null, 'MK201601121500240001', null);
INSERT INTO `t_order` VALUES ('25', '待完善', null, '2016-01-12 15:00:35', null, null, null, null, null, 'MK201601121500350001', null);
INSERT INTO `t_order` VALUES ('26', '待完善', null, '2016-01-12 15:49:00', null, null, null, null, null, 'MK201601121549000001', null);
INSERT INTO `t_order` VALUES ('27', '待完善', null, '2016-01-12 16:15:05', null, null, null, null, null, 'MK201601121615050001', null);
INSERT INTO `t_order` VALUES ('28', '待完善', null, '2016-01-12 16:17:21', null, null, null, null, null, 'MK201601121617210001', null);
INSERT INTO `t_order` VALUES ('29', '待完善', null, '2016-01-12 16:17:51', null, null, null, null, null, 'MK201601121617510001', null);
INSERT INTO `t_order` VALUES ('30', '待完善', null, '2016-01-12 17:09:18', null, null, null, null, null, 'MK201601121709180001', null);
INSERT INTO `t_order` VALUES ('31', '待完善', null, '2016-01-12 17:25:31', null, null, null, null, null, 'MK201601121725310001', null);
INSERT INTO `t_order` VALUES ('32', '待购买', null, '2016-01-12 18:22:43', null, null, '1', '', '线下支付', 'MK201601121822430001', '2016-01-12 18:22:49');
INSERT INTO `t_order` VALUES ('33', '待购买', null, '2016-01-12 18:24:15', null, null, '1', '加饭啊', '线下支付', 'MK201601121824150001', '2016-01-12 18:24:26');
INSERT INTO `t_order` VALUES ('34', '待购买', null, '2016-01-12 18:26:32', null, null, '1', '试试', '线下支付', 'MK201601121826320001', '2016-01-12 18:26:42');
INSERT INTO `t_order` VALUES ('35', '待完善', null, '2016-01-12 18:29:57', null, null, null, null, null, 'MK201601121829570001', null);
INSERT INTO `t_order` VALUES ('36', '待完善', null, '2016-01-12 18:30:16', null, null, null, null, null, 'MK201601121830160001', null);
INSERT INTO `t_order` VALUES ('37', '待购买', null, '2016-01-12 18:31:01', null, null, '1', '', '线下支付', 'MK201601121831010001', '2016-01-12 18:31:08');
INSERT INTO `t_order` VALUES ('38', '待完善', null, '2016-01-12 18:34:23', null, null, null, null, null, 'MK201601121834230001', null);
INSERT INTO `t_order` VALUES ('39', '待购买', null, '2016-01-12 18:36:36', null, null, '1', '暗暗', '线下支付', 'MK201601121836360001', '2016-01-12 18:36:45');
INSERT INTO `t_order` VALUES ('40', '待购买', null, '2016-01-12 19:47:37', null, null, '1', '', '线下支付', 'MK201601121947370001', '2016-01-12 19:47:45');
INSERT INTO `t_order` VALUES ('41', '待购买', null, '2016-01-12 19:48:01', null, null, '1', '', '线下支付', 'MK201601121948010001', '2016-01-12 19:48:09');
INSERT INTO `t_order` VALUES ('42', '待购买', null, '2016-01-12 19:49:41', null, null, '1', '', '线下支付', 'MK201601121949410001', '2016-01-12 19:49:50');
INSERT INTO `t_order` VALUES ('43', '待购买', null, '2016-01-12 19:54:17', null, null, '1', '', '线下支付', 'MK201601121954170001', '2016-01-12 19:54:25');
INSERT INTO `t_order` VALUES ('44', '待购买', null, '2016-01-12 19:56:28', null, null, '1', '', '线下支付', 'MK201601121956280001', '2016-01-12 19:56:34');
INSERT INTO `t_order` VALUES ('45', '待购买', null, '2016-01-12 20:06:45', null, null, '1', '', '线下支付', 'MK201601122006450001', '2016-01-12 20:06:58');
INSERT INTO `t_order` VALUES ('46', '待完善', null, '2016-01-12 20:18:50', null, null, null, null, null, 'MK201601122018500001', null);
INSERT INTO `t_order` VALUES ('47', '待购买', null, '2016-01-12 20:27:18', null, null, '1', '', '线下支付', 'MK201601122027180001', '2016-01-12 20:28:25');
INSERT INTO `t_order` VALUES ('48', '待购买', null, '2016-01-12 20:30:24', null, null, '1', '', '线下支付', 'MK201601122030240001', '2016-01-12 20:30:32');
INSERT INTO `t_order` VALUES ('49', '待购买', null, '2016-01-12 20:31:49', null, null, '5', '', '线下支付', 'MK201601122031490001', '2016-01-12 20:31:56');
INSERT INTO `t_order` VALUES ('50', '待完善', null, '2016-01-12 20:41:14', null, null, null, null, null, 'MK201601122041140001', null);
INSERT INTO `t_order` VALUES ('51', '待购买', null, '2016-01-12 20:42:37', null, null, '1', '', '线下支付', 'MK201601122042370001', '2016-01-12 20:43:04');
INSERT INTO `t_order` VALUES ('52', '待购买', null, '2016-01-12 20:43:47', null, null, '1', '', '线下支付', 'MK201601122043470001', '2016-01-12 20:43:58');
INSERT INTO `t_order` VALUES ('53', '待完善', null, '2016-01-12 20:44:36', null, null, null, null, null, 'MK201601122044360001', null);
INSERT INTO `t_order` VALUES ('54', '待完善', null, '2016-01-12 20:46:28', null, null, null, null, null, 'MK201601122046280001', null);
INSERT INTO `t_order` VALUES ('55', '待完善', null, '2016-01-12 21:57:38', null, null, null, null, null, 'MK201601122157380001', null);
INSERT INTO `t_order` VALUES ('56', '待完善', null, '2016-01-12 22:15:59', null, null, null, null, null, 'MK201601122215590001', null);
INSERT INTO `t_order` VALUES ('57', '待完善', null, '2016-01-12 22:21:03', null, null, null, null, null, 'MK201601122221030001', null);
INSERT INTO `t_order` VALUES ('58', '待完善', null, '2016-01-12 23:37:01', null, null, null, null, null, 'MK201601122337010001', null);
INSERT INTO `t_order` VALUES ('59', '待购买', null, '2016-01-12 23:37:47', null, null, '9', '', '线下支付', 'MK201601122337470001', '2016-01-12 23:37:56');
INSERT INTO `t_order` VALUES ('60', '待完善', null, '2016-01-12 23:38:20', null, null, null, null, null, 'MK201601122338200001', null);
INSERT INTO `t_order` VALUES ('61', '待完善', null, '2016-01-13 10:04:57', null, null, null, null, null, 'MK201601131004570001', null);
INSERT INTO `t_order` VALUES ('62', '待完善', null, '2016-01-13 10:26:27', null, null, null, null, null, 'MK201601131026270001', null);
INSERT INTO `t_order` VALUES ('63', '待完善', null, '2016-01-13 10:27:37', null, null, null, null, null, 'MK201601131027370001', null);
INSERT INTO `t_order` VALUES ('64', '待完善', null, '2016-01-13 10:27:57', null, null, null, null, null, 'MK201601131027570001', null);
INSERT INTO `t_order` VALUES ('65', '待购买', null, '2016-01-13 10:30:32', null, null, '9', '', '线下支付', 'MK201601131030320001', '2016-01-13 10:30:42');
INSERT INTO `t_order` VALUES ('66', '待购买', null, '2016-01-13 10:31:33', null, null, '9', '', '线下支付', 'MK201601131031330001', '2016-01-13 10:31:46');
INSERT INTO `t_order` VALUES ('67', '待购买', null, '2016-01-13 10:57:12', null, null, '9', '', '线下支付', 'MK201601131057120001', '2016-01-13 10:57:31');
INSERT INTO `t_order` VALUES ('68', '待购买', null, '2016-01-13 10:57:50', null, null, '1', '', '线下支付', 'MK201601131057500001', '2016-01-13 10:57:57');
INSERT INTO `t_order` VALUES ('69', '待完善', null, '2016-01-13 10:58:05', null, null, null, null, null, 'MK201601131058050001', null);
INSERT INTO `t_order` VALUES ('70', '待完善', null, '2016-01-13 10:59:33', null, null, null, null, null, 'MK201601131059330001', null);
INSERT INTO `t_order` VALUES ('71', '待完善', null, '2016-01-13 11:00:23', null, null, null, null, null, 'MK201601131100230001', null);
INSERT INTO `t_order` VALUES ('72', '待购买', null, '2016-01-13 11:03:26', null, null, '11', '', '线下支付', 'MK201601131103260001', '2016-01-13 11:04:25');
INSERT INTO `t_order` VALUES ('73', '待购买', null, '2016-01-13 11:04:41', null, null, '12', '', '线下支付', 'MK201601131104410001', '2016-01-13 11:04:49');
INSERT INTO `t_order` VALUES ('74', '待完善', null, '2016-01-13 11:05:16', null, null, null, null, null, 'MK201601131105160001', null);
INSERT INTO `t_order` VALUES ('75', '待购买', null, '2016-01-13 11:40:17', null, null, '11', '', '线下支付', 'MK201601131140170001', '2016-01-13 11:40:23');
INSERT INTO `t_order` VALUES ('76', '待完善', null, '2016-01-13 11:46:56', null, null, null, null, null, 'MK201601131146560001', null);
INSERT INTO `t_order` VALUES ('77', '待完善', null, '2016-01-13 11:46:58', null, null, null, null, null, 'MK201601131146580001', null);
INSERT INTO `t_order` VALUES ('78', '待完善', null, '2016-01-13 11:47:03', null, null, null, null, null, 'MK201601131147030001', null);
INSERT INTO `t_order` VALUES ('79', '待完善', null, '2016-01-13 11:47:23', null, null, null, null, null, 'MK201601131147230001', null);
INSERT INTO `t_order` VALUES ('80', '待完善', null, '2016-01-13 11:47:27', null, null, null, null, null, 'MK201601131147270001', null);
INSERT INTO `t_order` VALUES ('81', '待完善', null, '2016-01-13 11:47:29', null, null, null, null, null, 'MK201601131147290001', null);
INSERT INTO `t_order` VALUES ('82', '待完善', null, '2016-01-13 11:47:31', null, null, null, null, null, 'MK201601131147310001', null);
INSERT INTO `t_order` VALUES ('83', '待完善', null, '2016-01-13 11:47:31', null, null, null, null, null, 'MK201601131147310002', null);
INSERT INTO `t_order` VALUES ('84', '待完善', null, '2016-01-13 11:47:33', null, null, null, null, null, 'MK201601131147330001', null);
INSERT INTO `t_order` VALUES ('85', '待购买', null, '2016-01-13 11:48:05', null, null, '11', '', '线下支付', 'MK201601131148050001', '2016-01-13 11:48:15');
INSERT INTO `t_order` VALUES ('86', '待购买', null, '2016-01-13 12:16:19', null, null, '5', '', '线下支付', 'MK201601131216190001', '2016-01-13 12:16:33');

-- ----------------------------
-- Table structure for `t_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
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
INSERT INTO `t_order_detail` VALUES ('1', '10', '1', '2');
INSERT INTO `t_order_detail` VALUES ('2', '10', '9', '8');
INSERT INTO `t_order_detail` VALUES ('3', '10', '0', '1');
INSERT INTO `t_order_detail` VALUES ('4', '11', '0', '1');
INSERT INTO `t_order_detail` VALUES ('5', '11', '9', '8');
INSERT INTO `t_order_detail` VALUES ('6', '11', '1', '2');
INSERT INTO `t_order_detail` VALUES ('7', '12', '5', '100');
INSERT INTO `t_order_detail` VALUES ('8', '12', '1', '200');
INSERT INTO `t_order_detail` VALUES ('9', '13', '1', '2');
INSERT INTO `t_order_detail` VALUES ('10', '13', '0', '1');
INSERT INTO `t_order_detail` VALUES ('11', '13', '9', '8');
INSERT INTO `t_order_detail` VALUES ('12', '14', '1', '2');
INSERT INTO `t_order_detail` VALUES ('13', '14', '0', '1');
INSERT INTO `t_order_detail` VALUES ('14', '14', '9', '8');
INSERT INTO `t_order_detail` VALUES ('15', '15', '0', '1');
INSERT INTO `t_order_detail` VALUES ('16', '15', '1', '2');
INSERT INTO `t_order_detail` VALUES ('17', '15', '9', '8');
INSERT INTO `t_order_detail` VALUES ('18', '16', '0', '1');
INSERT INTO `t_order_detail` VALUES ('19', '16', '1', '2');
INSERT INTO `t_order_detail` VALUES ('20', '16', '9', '8');
INSERT INTO `t_order_detail` VALUES ('21', '17', '0', '2');
INSERT INTO `t_order_detail` VALUES ('22', '17', '1', '3');
INSERT INTO `t_order_detail` VALUES ('23', '17', '9', '9');
INSERT INTO `t_order_detail` VALUES ('24', '18', '0', '2');
INSERT INTO `t_order_detail` VALUES ('25', '18', '9', '9');
INSERT INTO `t_order_detail` VALUES ('26', '18', '5', '1');
INSERT INTO `t_order_detail` VALUES ('27', '18', '1', '3');
INSERT INTO `t_order_detail` VALUES ('28', '19', '9', '10');
INSERT INTO `t_order_detail` VALUES ('29', '19', '5', '1');
INSERT INTO `t_order_detail` VALUES ('30', '19', '0', '2');
INSERT INTO `t_order_detail` VALUES ('31', '19', '1', '3');
INSERT INTO `t_order_detail` VALUES ('32', '20', '9', '10');
INSERT INTO `t_order_detail` VALUES ('33', '20', '0', '2');
INSERT INTO `t_order_detail` VALUES ('34', '20', '8', '1');
INSERT INTO `t_order_detail` VALUES ('35', '20', '5', '1');
INSERT INTO `t_order_detail` VALUES ('36', '20', '1', '3');
INSERT INTO `t_order_detail` VALUES ('37', '21', '11', '1');
INSERT INTO `t_order_detail` VALUES ('38', '21', '9', '10');
INSERT INTO `t_order_detail` VALUES ('39', '21', '5', '1');
INSERT INTO `t_order_detail` VALUES ('40', '21', '8', '1');
INSERT INTO `t_order_detail` VALUES ('41', '21', '0', '2');
INSERT INTO `t_order_detail` VALUES ('42', '21', '1', '3');
INSERT INTO `t_order_detail` VALUES ('43', '22', '5', '4');
INSERT INTO `t_order_detail` VALUES ('44', '22', '0', '2');
INSERT INTO `t_order_detail` VALUES ('45', '22', '9', '12');
INSERT INTO `t_order_detail` VALUES ('46', '22', '11', '5');
INSERT INTO `t_order_detail` VALUES ('47', '22', '8', '6');
INSERT INTO `t_order_detail` VALUES ('48', '22', '1', '3');
INSERT INTO `t_order_detail` VALUES ('49', '23', '1', '3');
INSERT INTO `t_order_detail` VALUES ('50', '23', '8', '6');
INSERT INTO `t_order_detail` VALUES ('51', '23', '11', '5');
INSERT INTO `t_order_detail` VALUES ('52', '23', '9', '12');
INSERT INTO `t_order_detail` VALUES ('53', '23', '5', '4');
INSERT INTO `t_order_detail` VALUES ('54', '23', '0', '2');
INSERT INTO `t_order_detail` VALUES ('55', '24', '5', '4');
INSERT INTO `t_order_detail` VALUES ('56', '24', '1', '3');
INSERT INTO `t_order_detail` VALUES ('57', '24', '11', '5');
INSERT INTO `t_order_detail` VALUES ('58', '24', '8', '6');
INSERT INTO `t_order_detail` VALUES ('59', '24', '0', '2');
INSERT INTO `t_order_detail` VALUES ('60', '24', '9', '12');
INSERT INTO `t_order_detail` VALUES ('61', '25', '1', '3');
INSERT INTO `t_order_detail` VALUES ('62', '25', '8', '6');
INSERT INTO `t_order_detail` VALUES ('63', '25', '9', '12');
INSERT INTO `t_order_detail` VALUES ('64', '25', '0', '2');
INSERT INTO `t_order_detail` VALUES ('65', '25', '11', '2');
INSERT INTO `t_order_detail` VALUES ('66', '25', '5', '4');
INSERT INTO `t_order_detail` VALUES ('67', '26', '9', '12');
INSERT INTO `t_order_detail` VALUES ('68', '26', '0', '2');
INSERT INTO `t_order_detail` VALUES ('69', '26', '1', '3');
INSERT INTO `t_order_detail` VALUES ('70', '26', '8', '6');
INSERT INTO `t_order_detail` VALUES ('71', '26', '5', '4');
INSERT INTO `t_order_detail` VALUES ('72', '26', '11', '2');
INSERT INTO `t_order_detail` VALUES ('73', '27', '11', '2');
INSERT INTO `t_order_detail` VALUES ('74', '27', '0', '2');
INSERT INTO `t_order_detail` VALUES ('75', '27', '8', '7');
INSERT INTO `t_order_detail` VALUES ('76', '27', '1', '3');
INSERT INTO `t_order_detail` VALUES ('77', '27', '5', '4');
INSERT INTO `t_order_detail` VALUES ('78', '27', '9', '12');
INSERT INTO `t_order_detail` VALUES ('79', '28', '5', '4');
INSERT INTO `t_order_detail` VALUES ('80', '28', '8', '7');
INSERT INTO `t_order_detail` VALUES ('81', '28', '11', '2');
INSERT INTO `t_order_detail` VALUES ('82', '28', '0', '2');
INSERT INTO `t_order_detail` VALUES ('83', '28', '9', '12');
INSERT INTO `t_order_detail` VALUES ('84', '28', '1', '3');
INSERT INTO `t_order_detail` VALUES ('85', '29', '11', '2');
INSERT INTO `t_order_detail` VALUES ('86', '29', '9', '12');
INSERT INTO `t_order_detail` VALUES ('87', '29', '8', '7');
INSERT INTO `t_order_detail` VALUES ('88', '29', '5', '4');
INSERT INTO `t_order_detail` VALUES ('89', '29', '1', '3');
INSERT INTO `t_order_detail` VALUES ('90', '29', '0', '2');
INSERT INTO `t_order_detail` VALUES ('91', '30', '5', '4');
INSERT INTO `t_order_detail` VALUES ('92', '30', '8', '7');
INSERT INTO `t_order_detail` VALUES ('93', '30', '9', '12');
INSERT INTO `t_order_detail` VALUES ('94', '30', '0', '2');
INSERT INTO `t_order_detail` VALUES ('95', '30', '11', '2');
INSERT INTO `t_order_detail` VALUES ('96', '30', '1', '3');
INSERT INTO `t_order_detail` VALUES ('97', '31', '1', '3');
INSERT INTO `t_order_detail` VALUES ('98', '31', '9', '12');
INSERT INTO `t_order_detail` VALUES ('99', '31', '11', '2');
INSERT INTO `t_order_detail` VALUES ('100', '31', '5', '4');
INSERT INTO `t_order_detail` VALUES ('101', '31', '0', '2');
INSERT INTO `t_order_detail` VALUES ('102', '31', '8', '7');
INSERT INTO `t_order_detail` VALUES ('103', '32', '5', '4');
INSERT INTO `t_order_detail` VALUES ('104', '32', '1', '3');
INSERT INTO `t_order_detail` VALUES ('105', '32', '9', '12');
INSERT INTO `t_order_detail` VALUES ('106', '32', '8', '7');
INSERT INTO `t_order_detail` VALUES ('107', '32', '0', '2');
INSERT INTO `t_order_detail` VALUES ('108', '32', '11', '2');
INSERT INTO `t_order_detail` VALUES ('109', '33', '5', '4');
INSERT INTO `t_order_detail` VALUES ('110', '33', '0', '2');
INSERT INTO `t_order_detail` VALUES ('111', '33', '1', '3');
INSERT INTO `t_order_detail` VALUES ('112', '33', '9', '12');
INSERT INTO `t_order_detail` VALUES ('113', '33', '11', '2');
INSERT INTO `t_order_detail` VALUES ('114', '33', '8', '7');
INSERT INTO `t_order_detail` VALUES ('115', '34', '9', '12');
INSERT INTO `t_order_detail` VALUES ('116', '34', '8', '7');
INSERT INTO `t_order_detail` VALUES ('117', '34', '11', '2');
INSERT INTO `t_order_detail` VALUES ('118', '34', '5', '4');
INSERT INTO `t_order_detail` VALUES ('119', '34', '0', '2');
INSERT INTO `t_order_detail` VALUES ('120', '34', '1', '3');
INSERT INTO `t_order_detail` VALUES ('121', '35', '5', '4');
INSERT INTO `t_order_detail` VALUES ('122', '35', '9', '12');
INSERT INTO `t_order_detail` VALUES ('123', '35', '11', '2');
INSERT INTO `t_order_detail` VALUES ('124', '35', '0', '2');
INSERT INTO `t_order_detail` VALUES ('125', '35', '1', '3');
INSERT INTO `t_order_detail` VALUES ('126', '35', '8', '7');
INSERT INTO `t_order_detail` VALUES ('127', '36', '9', '12');
INSERT INTO `t_order_detail` VALUES ('128', '36', '8', '7');
INSERT INTO `t_order_detail` VALUES ('129', '36', '1', '3');
INSERT INTO `t_order_detail` VALUES ('130', '36', '11', '2');
INSERT INTO `t_order_detail` VALUES ('131', '36', '0', '2');
INSERT INTO `t_order_detail` VALUES ('132', '36', '5', '4');
INSERT INTO `t_order_detail` VALUES ('133', '37', '11', '2');
INSERT INTO `t_order_detail` VALUES ('134', '37', '1', '3');
INSERT INTO `t_order_detail` VALUES ('135', '37', '5', '4');
INSERT INTO `t_order_detail` VALUES ('136', '37', '9', '12');
INSERT INTO `t_order_detail` VALUES ('137', '37', '8', '7');
INSERT INTO `t_order_detail` VALUES ('138', '37', '0', '2');
INSERT INTO `t_order_detail` VALUES ('139', '38', '11', '2');
INSERT INTO `t_order_detail` VALUES ('140', '38', '8', '7');
INSERT INTO `t_order_detail` VALUES ('141', '38', '9', '12');
INSERT INTO `t_order_detail` VALUES ('142', '38', '5', '4');
INSERT INTO `t_order_detail` VALUES ('143', '38', '0', '2');
INSERT INTO `t_order_detail` VALUES ('144', '38', '1', '3');
INSERT INTO `t_order_detail` VALUES ('145', '39', '5', '4');
INSERT INTO `t_order_detail` VALUES ('146', '39', '8', '7');
INSERT INTO `t_order_detail` VALUES ('147', '39', '9', '12');
INSERT INTO `t_order_detail` VALUES ('148', '39', '1', '3');
INSERT INTO `t_order_detail` VALUES ('149', '39', '11', '2');
INSERT INTO `t_order_detail` VALUES ('150', '39', '0', '2');
INSERT INTO `t_order_detail` VALUES ('151', '40', '2', '1');
INSERT INTO `t_order_detail` VALUES ('152', '41', '2', '2');
INSERT INTO `t_order_detail` VALUES ('153', '42', '7', '1');
INSERT INTO `t_order_detail` VALUES ('154', '43', '2', '1');
INSERT INTO `t_order_detail` VALUES ('155', '44', '2', '1');
INSERT INTO `t_order_detail` VALUES ('156', '45', '7', '1');
INSERT INTO `t_order_detail` VALUES ('157', '46', '11', '1');
INSERT INTO `t_order_detail` VALUES ('158', '47', '11', '1');
INSERT INTO `t_order_detail` VALUES ('159', '48', '2', '1');
INSERT INTO `t_order_detail` VALUES ('160', '49', '2', '1');
INSERT INTO `t_order_detail` VALUES ('161', '51', '6', '3');
INSERT INTO `t_order_detail` VALUES ('162', '51', '7', '2');
INSERT INTO `t_order_detail` VALUES ('163', '51', '11', '1');
INSERT INTO `t_order_detail` VALUES ('164', '52', '7', '2');
INSERT INTO `t_order_detail` VALUES ('165', '52', '11', '1');
INSERT INTO `t_order_detail` VALUES ('166', '52', '6', '1');
INSERT INTO `t_order_detail` VALUES ('167', '53', '7', '1');
INSERT INTO `t_order_detail` VALUES ('168', '53', '6', '2');
INSERT INTO `t_order_detail` VALUES ('169', '54', '7', '1');
INSERT INTO `t_order_detail` VALUES ('170', '54', '6', '2');
INSERT INTO `t_order_detail` VALUES ('171', '55', '7', '1');
INSERT INTO `t_order_detail` VALUES ('172', '55', '6', '2');
INSERT INTO `t_order_detail` VALUES ('173', '55', '11', '1');
INSERT INTO `t_order_detail` VALUES ('174', '56', '6', '2');
INSERT INTO `t_order_detail` VALUES ('175', '56', '7', '1');
INSERT INTO `t_order_detail` VALUES ('176', '56', '11', '1');
INSERT INTO `t_order_detail` VALUES ('177', '57', '6', '2');
INSERT INTO `t_order_detail` VALUES ('178', '57', '11', '1');
INSERT INTO `t_order_detail` VALUES ('179', '57', '7', '1');
INSERT INTO `t_order_detail` VALUES ('180', '58', '2', '1');
INSERT INTO `t_order_detail` VALUES ('181', '59', '7', '1');
INSERT INTO `t_order_detail` VALUES ('182', '60', '11', '1');
INSERT INTO `t_order_detail` VALUES ('183', '61', '2', '1');
INSERT INTO `t_order_detail` VALUES ('184', '61', '6', '2');
INSERT INTO `t_order_detail` VALUES ('185', '61', '7', '2');
INSERT INTO `t_order_detail` VALUES ('186', '61', '11', '1');
INSERT INTO `t_order_detail` VALUES ('187', '62', '2', '1');
INSERT INTO `t_order_detail` VALUES ('188', '62', '12', '1');
INSERT INTO `t_order_detail` VALUES ('189', '62', '7', '2');
INSERT INTO `t_order_detail` VALUES ('190', '62', '11', '1');
INSERT INTO `t_order_detail` VALUES ('191', '62', '6', '2');
INSERT INTO `t_order_detail` VALUES ('192', '63', '12', '1');
INSERT INTO `t_order_detail` VALUES ('193', '63', '6', '2');
INSERT INTO `t_order_detail` VALUES ('194', '63', '7', '2');
INSERT INTO `t_order_detail` VALUES ('195', '63', '11', '1');
INSERT INTO `t_order_detail` VALUES ('196', '63', '2', '1');
INSERT INTO `t_order_detail` VALUES ('197', '65', '11', '1');
INSERT INTO `t_order_detail` VALUES ('198', '66', '7', '1');
INSERT INTO `t_order_detail` VALUES ('201', '67', '2', '2');
INSERT INTO `t_order_detail` VALUES ('202', '67', '12', '1');
INSERT INTO `t_order_detail` VALUES ('203', '68', '2', '1');
INSERT INTO `t_order_detail` VALUES ('204', '68', '0', '1');
INSERT INTO `t_order_detail` VALUES ('205', '69', '7', '2');
INSERT INTO `t_order_detail` VALUES ('206', '70', '7', '2');
INSERT INTO `t_order_detail` VALUES ('207', '71', '7', '2');
INSERT INTO `t_order_detail` VALUES ('208', '72', '7', '2');
INSERT INTO `t_order_detail` VALUES ('209', '73', '7', '2');
INSERT INTO `t_order_detail` VALUES ('210', '73', '2', '1');
INSERT INTO `t_order_detail` VALUES ('211', '74', '2', '1');
INSERT INTO `t_order_detail` VALUES ('212', '75', '2', '1');
INSERT INTO `t_order_detail` VALUES ('215', '76', '2', '2');
INSERT INTO `t_order_detail` VALUES ('216', '76', '8', '3');
INSERT INTO `t_order_detail` VALUES ('217', '77', '8', '3');
INSERT INTO `t_order_detail` VALUES ('218', '77', '2', '2');
INSERT INTO `t_order_detail` VALUES ('219', '78', '2', '2');
INSERT INTO `t_order_detail` VALUES ('220', '78', '8', '3');
INSERT INTO `t_order_detail` VALUES ('221', '84', '2', '1');
INSERT INTO `t_order_detail` VALUES ('222', '85', '2', '1');
INSERT INTO `t_order_detail` VALUES ('223', '85', '0', '1');
INSERT INTO `t_order_detail` VALUES ('224', '86', '7', '2');
INSERT INTO `t_order_detail` VALUES ('225', '86', '2', '2');
INSERT INTO `t_order_detail` VALUES ('226', '86', '8', '3');

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
  `is_default` tinyint(4) DEFAULT NULL COMMENT '是否为默认提取点',
  `lat` float(9,6) NOT NULL,
  `lng` float(9,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='t_shop';

-- ----------------------------
-- Records of t_shop
-- ----------------------------
INSERT INTO `t_shop` VALUES ('1', '我家超市', '111', null, '0.000000', '0.000000');
INSERT INTO `t_shop` VALUES ('5', '公园店', '天坛公园里面', null, '116.419754', '39.884670');
INSERT INTO `t_shop` VALUES ('9', '我家超市', '海定区', null, '116.302505', '39.963177');
INSERT INTO `t_shop` VALUES ('11', '318', '我家', null, '116.400246', '39.925560');
INSERT INTO `t_shop` VALUES ('12', '4333', 'haiding', null, '116.340164', '39.976006');
INSERT INTO `t_shop` VALUES ('13', 'wojia', 'haidian', null, '116.305092', '39.965389');

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
INSERT INTO `t_user_order` VALUES ('1', '5');
INSERT INTO `t_user_order` VALUES ('1', '6');
INSERT INTO `t_user_order` VALUES ('4', '7');
INSERT INTO `t_user_order` VALUES ('4', '8');
INSERT INTO `t_user_order` VALUES ('4', '10');
INSERT INTO `t_user_order` VALUES ('4', '11');
INSERT INTO `t_user_order` VALUES ('2', '12');
INSERT INTO `t_user_order` VALUES ('4', '13');
INSERT INTO `t_user_order` VALUES ('4', '14');
INSERT INTO `t_user_order` VALUES ('4', '15');
INSERT INTO `t_user_order` VALUES ('4', '16');
INSERT INTO `t_user_order` VALUES ('4', '17');
INSERT INTO `t_user_order` VALUES ('4', '18');
INSERT INTO `t_user_order` VALUES ('4', '19');
INSERT INTO `t_user_order` VALUES ('4', '20');
INSERT INTO `t_user_order` VALUES ('4', '21');
INSERT INTO `t_user_order` VALUES ('4', '22');
INSERT INTO `t_user_order` VALUES ('4', '23');
INSERT INTO `t_user_order` VALUES ('4', '24');
INSERT INTO `t_user_order` VALUES ('4', '25');
INSERT INTO `t_user_order` VALUES ('4', '26');
INSERT INTO `t_user_order` VALUES ('4', '27');
INSERT INTO `t_user_order` VALUES ('4', '28');
INSERT INTO `t_user_order` VALUES ('4', '29');
INSERT INTO `t_user_order` VALUES ('4', '30');
INSERT INTO `t_user_order` VALUES ('4', '31');
INSERT INTO `t_user_order` VALUES ('4', '32');
INSERT INTO `t_user_order` VALUES ('4', '33');
INSERT INTO `t_user_order` VALUES ('4', '34');
INSERT INTO `t_user_order` VALUES ('4', '35');
INSERT INTO `t_user_order` VALUES ('4', '36');
INSERT INTO `t_user_order` VALUES ('4', '37');
INSERT INTO `t_user_order` VALUES ('4', '38');
INSERT INTO `t_user_order` VALUES ('4', '39');
INSERT INTO `t_user_order` VALUES ('4', '40');
INSERT INTO `t_user_order` VALUES ('4', '41');
INSERT INTO `t_user_order` VALUES ('4', '42');
INSERT INTO `t_user_order` VALUES ('4', '43');
INSERT INTO `t_user_order` VALUES ('4', '44');
INSERT INTO `t_user_order` VALUES ('4', '45');
INSERT INTO `t_user_order` VALUES ('4', '46');
INSERT INTO `t_user_order` VALUES ('4', '47');
INSERT INTO `t_user_order` VALUES ('4', '48');
INSERT INTO `t_user_order` VALUES ('4', '49');
INSERT INTO `t_user_order` VALUES ('4', '50');
INSERT INTO `t_user_order` VALUES ('6', '51');
INSERT INTO `t_user_order` VALUES ('6', '52');
INSERT INTO `t_user_order` VALUES ('6', '53');
INSERT INTO `t_user_order` VALUES ('6', '54');
INSERT INTO `t_user_order` VALUES ('6', '55');
INSERT INTO `t_user_order` VALUES ('6', '56');
INSERT INTO `t_user_order` VALUES ('6', '57');
INSERT INTO `t_user_order` VALUES ('4', '58');
INSERT INTO `t_user_order` VALUES ('4', '59');
INSERT INTO `t_user_order` VALUES ('4', '60');
INSERT INTO `t_user_order` VALUES ('6', '61');
INSERT INTO `t_user_order` VALUES ('6', '62');
INSERT INTO `t_user_order` VALUES ('6', '63');
INSERT INTO `t_user_order` VALUES ('6', '64');
INSERT INTO `t_user_order` VALUES ('4', '65');
INSERT INTO `t_user_order` VALUES ('4', '66');
INSERT INTO `t_user_order` VALUES ('6', '67');
INSERT INTO `t_user_order` VALUES ('6', '68');
INSERT INTO `t_user_order` VALUES ('4', '69');
INSERT INTO `t_user_order` VALUES ('4', '70');
INSERT INTO `t_user_order` VALUES ('4', '71');
INSERT INTO `t_user_order` VALUES ('4', '72');
INSERT INTO `t_user_order` VALUES ('4', '73');
INSERT INTO `t_user_order` VALUES ('4', '74');
INSERT INTO `t_user_order` VALUES ('4', '75');
INSERT INTO `t_user_order` VALUES ('6', '76');
INSERT INTO `t_user_order` VALUES ('6', '77');
INSERT INTO `t_user_order` VALUES ('6', '78');
INSERT INTO `t_user_order` VALUES ('4', '84');
INSERT INTO `t_user_order` VALUES ('4', '85');
INSERT INTO `t_user_order` VALUES ('6', '86');
