/*
Navicat MySQL Data Transfer

Source Server         : 毕设项目
Source Server Version : 50169
Source Host           : 192.168.9.62:3306
Source Database       : itripdb

Target Server Type    : MYSQL
Target Server Version : 50169
File Encoding         : 65001

Date: 2017-05-08 15:26:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for itrip_area_dic
-- ----------------------------
DROP TABLE IF EXISTS `itrip_area_dic`;
CREATE TABLE `itrip_area_dic` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '区域名称',
  `areaNo` varchar(255) DEFAULT NULL COMMENT '区域编号',
  `parent` varchar(255) DEFAULT NULL COMMENT '父级区域',
  `isActivated` int(11) NOT NULL DEFAULT '1' COMMENT '0:未激活 1:已激活',
  `isTradingArea` int(11) DEFAULT NULL COMMENT '是否是商圈(0:不是 1:是)',
  `isHot` int(1) NOT NULL COMMENT '(0:不是 1：是)',
  `level` int(11) DEFAULT NULL COMMENT '区域级别(0:国家级 1:省级 2:市级 3:县/区)',
  `creationDate` datetime DEFAULT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3653 DEFAULT CHARSET=utf8 COMMENT='区域字典表';

-- ----------------------------
-- Records of itrip_area_dic
-- ----------------------------
INSERT INTO `itrip_area_dic` VALUES ('2', '北京市22', '110100', '1', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-06 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('20', '天津市', '120000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('21', '天津市', '120100', '20', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('39', '河北省', '130000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('40', '石家庄市', '130100', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('65', '唐山市', '130200', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('81', '秦皇岛市', '130300', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('90', '邯郸市', '130400', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('111', '邢台市', '130500', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('132', '保定市', '130600', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('159', '张家口市', '130700', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('178', '承德市', '130800', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('191', '沧州市', '130900', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('209', '廊坊市', '131000', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('221', '衡水市', '131100', '39', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('234', '山西省', '140000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('235', '太原市', '140100', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('247', '大同市', '140200', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('260', '阳泉市', '140300', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('267', '长治市', '140400', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('282', '晋城市', '140500', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('290', '朔州市', '140600', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('298', '晋中市', '140700', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('311', '运城市', '140800', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('326', '忻州市', '140900', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('342', '临汾市', '141000', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('361', '吕梁市', '141100', '234', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('376', '内蒙古自治区', '150000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('377', '呼和浩特市', '150100', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('388', '包头市', '150200', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('399', '乌海市', '150300', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('404', '赤峰市', '150400', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('418', '通辽市', '150500', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('428', '鄂尔多斯市', '150600', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('438', '呼伦贝尔市', '150700', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('453', '巴彦淖尔市', '150800', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('462', '乌兰察布市', '150900', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('475', '兴安盟', '152200', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('482', '锡林郭勒盟', '152500', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('495', '阿拉善盟', '152900', '376', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('499', '辽宁省', '210000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('500', '沈阳市', '210100', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('515', '大连市', '210200', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('527', '鞍山市', '210300', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('536', '抚顺市', '210400', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('545', '本溪市', '210500', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('553', '丹东市', '210600', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('561', '锦州市', '210700', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('570', '营口市', '210800', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('578', '阜新市', '210900', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('587', '辽阳市', '211000', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('596', '盘锦市', '211100', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('602', '铁岭市', '211200', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('611', '朝阳市', '211300', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('620', '葫芦岛市', '211400', '499', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('628', '吉林省', '220000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('629', '长春市', '220100', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('641', '吉林市', '220200', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('652', '四平市', '220300', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('660', '辽源市', '220400', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('666', '通化市', '220500', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('675', '白山市', '220600', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('683', '松原市', '220700', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('690', '白城市', '220800', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('697', '延边朝鲜族自治州', '222400', '628', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('706', '黑龙江省', '230000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('707', '哈尔滨市', '230100', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('727', '齐齐哈尔市', '230200', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('745', '鸡西市', '230300', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('756', '鹤岗市', '230400', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('766', '双鸭山市', '230500', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('776', '大庆市', '230600', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('787', '伊春市', '230700', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('806', '佳木斯市', '230800', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('818', '七台河市', '230900', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('824', '牡丹江市', '231000', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('836', '黑河市', '231100', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('844', '绥化市', '231200', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('856', '大兴安岭地区', '232700', '706', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('860', '上海市', '310000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('861', '上海市', '310100', '860', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('880', '江苏省', '320000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('881', '南京市', '320100', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('896', '无锡市', '320200', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('906', '徐州市', '320300', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('918', '常州市', '320400', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('927', '苏州市', '320500', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('938', '南通市', '320600', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('948', '连云港市', '320700', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('957', '淮安市', '320800', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('967', '盐城市', '320900', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('978', '扬州市', '321000', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('986', '镇江市', '321100', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('994', '泰州市', '321200', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1002', '宿迁市', '321300', '880', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1009', '浙江省', '330000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1010', '杭州市', '330100', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1025', '宁波市', '330200', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1038', '温州市', '330300', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1051', '嘉兴市', '330400', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1060', '湖州市', '330500', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1067', '绍兴市', '330600', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1075', '金华市', '330700', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1086', '衢州市', '330800', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1094', '舟山市', '330900', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1100', '台州市', '331000', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1111', '丽水市', '331100', '1009', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1122', '安徽省', '340000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1123', '合肥市', '340100', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1134', '芜湖市', '340200', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1144', '蚌埠市', '340300', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1153', '淮南市', '340400', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1161', '马鞍山市', '340500', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1169', '淮北市', '340600', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1175', '铜陵市', '340700', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1181', '安庆市', '340800', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1194', '黄山市', '341000', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1203', '滁州市', '341100', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1213', '阜阳市', '341200', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1223', '宿州市', '341300', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1230', '六安市', '341500', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1239', '亳州市', '341600', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1245', '池州市', '341700', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1251', '宣城市', '341800', '1122', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1260', '福建省', '350000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1261', '福州市', '350100', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1276', '厦门市', '350200', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1284', '莆田市', '350300', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1291', '三明市', '350400', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1305', '泉州市', '350500', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1319', '漳州市', '350600', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1332', '南平市', '350700', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1344', '龙岩市', '350800', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1353', '宁德市', '350900', '1260', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1364', '江西省', '360000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1365', '南昌市', '360100', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1376', '景德镇市', '360200', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1382', '萍乡市', '360300', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1389', '九江市', '360400', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1404', '新余市', '360500', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1408', '鹰潭市', '360600', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1413', '赣州市', '360700', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1433', '吉安市', '360800', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1448', '宜春市', '360900', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1460', '抚州市', '361000', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1473', '上饶市', '361100', '1364', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1487', '山东省', '370000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1488', '济南市', '370100', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1500', '青岛市', '370200', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1514', '淄博市', '370300', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1524', '枣庄市', '370400', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1532', '东营市', '370500', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1539', '烟台市', '370600', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1553', '潍坊市', '370700', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1567', '济宁市', '370800', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1581', '泰安市', '370900', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1589', '威海市', '371000', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1595', '日照市', '371100', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1601', '莱芜市', '371200', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1605', '临沂市', '371300', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1619', '德州市', '371400', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1632', '聊城市', '371500', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1642', '滨州市', '371600', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1651', '菏泽市', '371700', '1487', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1662', '河南省', '410000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1663', '郑州市', '410100', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1677', '开封市', '410200', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1689', '洛阳市', '410300', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1706', '平顶山市', '410400', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1718', '安阳市', '410500', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1729', '鹤壁市', '410600', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1736', '新乡市', '410700', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1750', '焦作市', '410800', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1762', '濮阳市', '410900', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1770', '许昌市', '411000', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1778', '漯河市', '411100', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1785', '三门峡市', '411200', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1793', '南阳市', '411300', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1808', '商丘市', '411400', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1819', '信阳市', '411500', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1831', '周口市', '411600', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1843', '驻马店市', '411700', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1855', '河南省直辖行政区', '419000', '1662', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1857', '湖北省', '420000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1858', '武汉市', '420100', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1873', '黄石市', '420200', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1881', '十堰市', '420300', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1891', '宜昌市', '420500', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1906', '襄阳市', '420600', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1917', '鄂州市', '420700', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1922', '荆门市', '420800', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1929', '孝感市', '420900', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1938', '荆州市', '421000', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1948', '黄冈市', '421100', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1960', '咸宁市', '421200', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1968', '随州市', '421300', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1973', '恩施土家族苗族自治州', '422800', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1982', '湖北省直辖行政区', '429000', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1983', '仙桃市', '429004', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1984', '潜江市', '429005', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1985', '天门市', '429006', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1986', '神农架林区', '429021', '1857', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1987', '湖南省', '430000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1988', '长沙市', '430100', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1999', '株洲市', '430200', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2010', '湘潭市', '430300', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2017', '衡阳市', '430400', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2031', '邵阳市', '430500', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2045', '岳阳市', '430600', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2056', '常德市', '430700', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2067', '张家界市', '430800', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2073', '益阳市', '430900', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2081', '郴州市', '431000', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2094', '永州市', '431100', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2107', '怀化市', '431200', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2121', '娄底市', '431300', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2128', '湘西土家族苗族自治州', '433100', '1987', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2137', '广东省', '440000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2138', '广州市', '440100', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2152', '韶关市', '440200', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2164', '深圳市', '440300', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2172', '珠海市', '440400', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2177', '汕头市', '440500', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2186', '佛山市', '440600', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2193', '江门市', '440700', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2202', '湛江市', '440800', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2213', '茂名市', '440900', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2221', '肇庆市', '441200', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2231', '惠州市', '441300', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2238', '梅州市', '441400', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2248', '汕尾市', '441500', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2254', '河源市', '441600', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2262', '阳江市', '441700', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2268', '清远市', '441800', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2278', '东莞市', '441900', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2279', '中山市', '442000', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2280', '潮州市', '445100', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2285', '揭阳市', '445200', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2292', '云浮市', '445300', '2137', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2299', '广西壮族自治区', '450000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2300', '南宁市', '450100', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2314', '柳州市', '450200', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2326', '桂林市', '450300', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2345', '梧州市', '450400', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2354', '北海市', '450500', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2360', '防城港市', '450600', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2366', '钦州市', '450700', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2372', '贵港市', '450800', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2379', '玉林市', '450900', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2387', '百色市', '451000', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2401', '贺州市', '451100', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2407', '河池市', '451200', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2420', '来宾市', '451300', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2428', '崇左市', '451400', '2299', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2437', '海南省', '460000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2438', '海口市', '460100', '2437', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2444', '三亚市', '460200', '2437', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2446', '三沙市', '460300', '2437', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2450', '海南省直辖行政区', '469000', '2437', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2467', '重庆市', '500000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2468', '重庆市', '500100', '2467', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2508', '四川省', '510000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2509', '成都市', '510100', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2530', '自贡市', '510300', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2538', '攀枝花市', '510400', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2545', '泸州市', '510500', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2554', '德阳市', '510600', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2562', '绵阳市', '510700', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2573', '广元市', '510800', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2582', '遂宁市', '510900', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2589', '内江市', '511000', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2596', '乐山市', '511100', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2609', '南充市', '511300', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2620', '眉山市', '511400', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2628', '宜宾市', '511500', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2640', '广安市', '511600', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2647', '达州市', '511700', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2656', '雅安市', '511800', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2666', '巴中市', '511900', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2672', '资阳市', '512000', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2678', '阿坝藏族羌族自治州', '513200', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2692', '甘孜藏族自治州', '513300', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2711', '凉山彝族自治州', '513400', '2508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2729', '贵州省', '520000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2730', '贵阳市', '520100', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2742', '六盘水市', '520200', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2747', '遵义市', '520300', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2763', '安顺市', '520400', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2771', '毕节市', '520500', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2780', '铜仁市', '520600', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2791', '黔西南布依族苗族自治州', '522300', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2800', '黔东南苗族侗族自治州', '522600', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2817', '黔南布依族苗族自治州', '522700', '2729', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2830', '云南省', '530000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2831', '昆明市', '530100', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2847', '曲靖市', '530300', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2858', '玉溪市', '530400', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2868', '保山市', '530500', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2875', '昭通市', '530600', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2888', '丽江市', '530700', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2895', '普洱市', '530800', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2907', '临沧市', '530900', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2917', '楚雄彝族自治州', '532300', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2928', '红河哈尼族彝族自治州', '532500', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2942', '文山壮族苗族自治州', '532600', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2951', '西双版纳傣族自治州', '532800', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2955', '大理白族自治州', '532900', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2968', '德宏傣族景颇族自治州', '533100', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2974', '怒江傈僳族自治州', '533300', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2979', '迪庆藏族自治州', '533400', '2830', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2983', '西藏自治区', '540000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2984', '拉萨市', '540100', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('2994', '昌都地区', '542100', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3006', '山南地区', '542200', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3019', '日喀则地区', '542300', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3038', '那曲地区', '542400', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3049', '阿里地区', '542500', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3057', '林芝地区', '542600', '2983', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3065', '陕西省', '610000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3066', '西安市', '610100', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3081', '铜川市', '610200', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3087', '宝鸡市', '610300', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3101', '咸阳市', '610400', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3117', '渭南市', '610500', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3130', '延安市', '610600', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3145', '汉中市', '610700', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3158', '榆林市', '610800', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3172', '安康市', '610900', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3184', '商洛市', '611000', '3065', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3193', '甘肃省', '620000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3194', '兰州市', '620100', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3204', '嘉峪关市', '620200', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3206', '金昌市', '620300', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3210', '白银市', '620400', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3217', '天水市', '620500', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3226', '武威市', '620600', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3232', '张掖市', '620700', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3240', '平凉市', '620800', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3249', '酒泉市', '620900', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3258', '庆阳市', '621000', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3268', '定西市', '621100', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3277', '陇南市', '621200', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3288', '临夏回族自治州', '622900', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3297', '甘南藏族自治州', '623000', '3193', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3306', '青海省', '630000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3307', '西宁市', '630100', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3316', '海东地区', '632100', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3323', '海北藏族自治州', '632200', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3328', '黄南藏族自治州', '632300', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3333', '海南藏族自治州', '632500', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3339', '果洛藏族自治州', '632600', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3346', '玉树藏族自治州', '632700', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3353', '海西蒙古族藏族自治州', '632800', '3306', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3359', '宁夏回族自治区', '640000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3360', '银川市', '640100', '3359', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3368', '石嘴山市', '640200', '3359', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3373', '吴忠市', '640300', '3359', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3380', '固原市', '640400', '3359', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3387', '中卫市', '640500', '3359', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3392', '新疆维吾尔自治区', '650000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3393', '乌鲁木齐市', '650100', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3403', '克拉玛依市', '650200', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3409', '吐鲁番地区', '652100', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3413', '哈密地区', '652200', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3417', '昌吉回族自治州', '652300', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3425', '博尔塔拉蒙古自治州', '652700', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3429', '巴音郭楞蒙古自治州', '652800', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3439', '阿克苏地区', '652900', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3449', '克孜勒苏柯尔克孜自治州', '653000', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3454', '喀什地区', '653100', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3467', '和田地区', '653200', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3476', '伊犁哈萨克自治州', '654000', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3487', '塔城地区', '654200', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3495', '阿勒泰地区', '654300', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3529', '王府井', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3503', '自治区直辖县级行政区划', '659000', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3504', '石河子市', '659001', '3392', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3528', '万柳', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3527', '中关村', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3526', '三里屯', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3508', '台湾省', '710000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3509', '香港特别行政区', '810000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3510', '澳门特别行政区', '820000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3525', '三元桥', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3524', '国贸', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3523', '菜市口', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3522', '西单', '', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3515', '台湾市', '710100', '3508', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3516', '香港市', '810100', '3509', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3517', '澳门市', '820100', '3510', '1', null, '0', '2', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('1', '北京市', '110000', '0', '1', null, '0', '1', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3600', '中国', '000000', '-1', '1', null, '0', '0', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3518', '美国', '000001', '-1', '1', null, '0', '0', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3519', '加拿大', '000002', '-1', '1', null, '0', '0', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3520', '澳大利亚', '000003', '-1', '1', null, '0', '0', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3521', '日本', '000004', '-1', '1', null, '0', '0', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3601', '南京路', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3602', '小白楼', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3603', '南开', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3604', '鼓楼', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3605', '红桥', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3606', '河北区中山路', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3607', '大胡同', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3608', '和平路滨江道', '', '21', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3609', '南京西路', '', '860', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3610', '淮海中路', '', '860', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3611', '浦东', '', '860', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3612', '徐家汇', '', '860', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3613', '长宁中山公园', '', '860', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3614', '古北', '', '860', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3615', '新街口', '', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3616', '山西路', '', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3617', '珠江路', '', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3618', '夫子庙', '', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3619', '前门', null, '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3620', '亚运村、奥体中心地区', ' ', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3621', '大红门、南苑地区', ' ', '2', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3622', '迪士尼度假区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3623', '人民广场地区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3624', '浦东陆家嘴黄金融贸易区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3625', '浦东机场核心区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3626', '虹桥地区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3627', '外滩地区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3628', '浦东新国际博览中心', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3629', '虹桥枢纽地区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3630', '火车站、天河体育场', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3631', '番禹长隆、广州南站附近', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3632', '珠江新城、五羊新城', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3633', '新白云国际机场', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3634', '海珠广场、北京路步行街', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3635', '珠江南（河南）地区', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3636', '环市东路附近', ' ', '2138', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3637', '新街口地区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3638', '夫子庙地区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3639', '玄武湖湖南路地区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3640', '辽宁开发区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3641', '河西地区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3642', '明故宫及南京博物院地区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3643', '雨花台（高铁南站）区', ' ', '881', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3644', '西湖湖滨商圈', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3645', '西湖风景区及灵隐度假村', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3646', '武林广场附近', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3647', '火车东站', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3648', '西溪湿地', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3649', '火车城站及西湖大道周边', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3650', '钱江新城', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3651', '滨海地区', ' ', '1010', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);
INSERT INTO `itrip_area_dic` VALUES ('3652', '光大会展中心 徐家汇地区', ' ', '861', '1', '1', '0', '3', '2017-05-04 14:52:31', null, '2017-05-04 14:52:31', null);

-- ----------------------------
-- Table structure for itrip_comment
-- ----------------------------
DROP TABLE IF EXISTS `itrip_comment`;
CREATE TABLE `itrip_comment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hotelId` bigint(20) DEFAULT NULL COMMENT '如果产品是酒店的话 改字段保存酒店id',
  `productId` bigint(11) NOT NULL COMMENT '商品id',
  `orderId` bigint(11) DEFAULT NULL COMMENT '订单id',
  `productType` int(255) NOT NULL COMMENT '商品类型(0:旅游产品 1:酒店产品 2:机票产品)',
  `content` text COMMENT '评论内容',
  `userId` bigint(11) NOT NULL COMMENT '用户编号',
  `isHavingImg` int(255) NOT NULL COMMENT '是否包含图片(当用户上传评论时检测)0:无图片 1:有图片',
  `positionScore` int(255) DEFAULT NULL COMMENT '位置评分',
  `facilitiesScore` int(255) DEFAULT NULL COMMENT '设施评分',
  `serviceScore` int(255) DEFAULT NULL COMMENT '服务评分',
  `hygieneScore` int(255) NOT NULL COMMENT '卫生评分',
  `score` int(255) DEFAULT NULL COMMENT '综合评分',
  `tripMode` varchar(255) DEFAULT NULL COMMENT '出游类型',
  `isOk` int(255) DEFAULT NULL COMMENT '是否满意（0：有待改善 1：值得推荐）',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of itrip_comment
-- ----------------------------
INSERT INTO `itrip_comment` VALUES ('1', '1', '1', '1', '1', '1111', '0', '0', null, null, null, '0', '4', null, '1', '0000-00-00 00:00:00', null, null, null);
INSERT INTO `itrip_comment` VALUES ('2', '1', '0', null, '0', null, '0', '0', null, null, null, '0', '2', null, '0', '0000-00-00 00:00:00', null, null, null);
INSERT INTO `itrip_comment` VALUES ('3', '2', '0', null, '0', null, '0', '0', null, null, null, '0', '5', null, '0', '0000-00-00 00:00:00', null, null, null);

-- ----------------------------
-- Table structure for itrip_hotel
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel`;
CREATE TABLE `itrip_hotel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hotelName` varchar(255) DEFAULT NULL COMMENT '酒店名称',
  `countryId` bigint(11) NOT NULL COMMENT '所在国家id',
  `provinceId` bigint(11) DEFAULT NULL COMMENT '所在省份id',
  `cityId` bigint(11) DEFAULT NULL COMMENT '所在城市id',
  `address` varchar(255) NOT NULL COMMENT '酒店所在地址',
  `details` text COMMENT '酒店介绍（保存附文本）',
  `facilities` text COMMENT '酒店设施',
  `hotelPolicy` text COMMENT '酒店政策',
  `hotelType` int(1) NOT NULL COMMENT '酒店类型(1:国内酒店 2:国际酒店)',
  `hotelLevel` int(1) NOT NULL COMMENT '(1:经济酒店  2:二星级酒店  3:三星级 4:四星酒店 5星酒店)',
  `isGroupPurchase` int(1) NOT NULL COMMENT '是否是团购酒店',
  `minPrice` decimal(10,0) DEFAULT NULL COMMENT '最低价',
  `maxPrice` decimal(10,0) DEFAULT NULL COMMENT '最高价',
  `redundantCityName` varchar(255) DEFAULT NULL COMMENT '城市名称 冗余字段',
  `redundantProvinceName` varchar(255) DEFAULT NULL COMMENT '省名称 冗余字段',
  `redundantCountryName` varchar(255) NOT NULL COMMENT '国家名称 冗余字段',
  `redundantHotelStore` int(22) DEFAULT NULL COMMENT '酒店库存（冗余，每天开定时任务的时候更新）',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='酒店表';

-- ----------------------------
-- Records of itrip_hotel
-- ----------------------------
INSERT INTO `itrip_hotel` VALUES ('1', '北京首都大酒店',3600,1,2,'北京 东城区 前门东大街3号 ，近正义路。','','[\r\n    {\r\n        \"rootName\": \"通用设施\",\r\n        \"leafs\": [\r\n            {\r\n                \"name\": \"免费旅游交通图\",\r\n                \"pic\": \"icon-map-marker\"\r\n            },\r\n            {\r\n                \"name\": \"有无线上网\",\r\n                \"pic\": \"icon-rss\"\r\n            },\r\n            {\r\n                \"name\": \"大堂免费报纸\",\r\n                \"pic\": \"icon-file-alt\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"rootName\": \"活动设施\",\r\n        \"leafs\": [\r\n            {\r\n                \"name\": \"KTV\",\r\n                \"pic\": \"icon-ok-circle\"\r\n            },\r\n            {\r\n                \"name\": \"棋牌室\",\r\n                \"pic\": \"icon-ok-circle\"\r\n            },\r\n            {\r\n                \"name\": \"桌球室\",\r\n                \"pic\": \"icon-ok-circle\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"rootName\": \"服务项目\",\r\n        \"leafs\": [\r\n            {\r\n                \"name\": \"外币兑换服务\",\r\n                \"pic\": \"icon-money\"\r\n            },\r\n            {\r\n                \"name\": \"会议厅\",\r\n                \"pic\": \"icon-ok-circle\"\r\n            },\r\n            {\r\n                \"name\": \"商务中心\",\r\n                \"pic\": \"icon-ok-circle\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"rootName\": \"客房设施\",\r\n        \"leafs\": [\r\n            {\r\n                \"name\": \"24小时热水\",\r\n                \"pic\": \"icon-medkit\"\r\n            },\r\n            {\r\n                \"name\": \"浴衣\",\r\n                \"pic\": \"icon-envelope\"\r\n            },\r\n            {\r\n                \"name\": \"迷你吧\",\r\n                \"pic\": \"icon-coffee\"\r\n            },\r\n            {\r\n                \"name\": \"房内保险箱\",\r\n                \"pic\": \"icon-lock\"\r\n            }\r\n        ]\r\n    },\r\n]','        {\r\n            \"description\": \"入住时间：15:00以后 离店时间：12:00以前\",\r\n            \"name\": \"入住和离店\"\r\n        },\r\n        {\r\n            \"description\": \"不接受18岁以下客人单独入住。\r\n														1岁以下婴儿使用现有床铺免费，不含儿童早餐。\r\n														1岁以下婴儿加婴儿床免费，不含儿童早餐。\r\n														1-18岁儿童使用现有床铺免费，不含儿童早餐。\r\n														1-18岁儿童加床收费，每晚RMB300.00，不含儿童早餐。\r\n														6-12岁儿童早餐为人民币105 / 位 / （包含10％服务费）。6岁以下儿童增订早餐免费。\",\r\n            \"name\": \"儿童政策\"\r\n        },\r\n        {\r\n            \"description\": \"自助早餐 RMB 210\",\r\n            \"name\": \"膳食安排\"\r\n        },\r\n        {\r\n            \"description\": \"不可携带宠物\",\r\n            \"name\": \"宠物\"\r\n        }',1,5,0,'北京市','北京市','中国',8,'2017-04-25 00:00:00',NULL,'2017-05-08 00:00:00',NULL);
INSERT INTO `itrip_hotel` VALUES ('2', '如家精选酒店（天津南京路小白楼地铁站店）', '3600', '20', '21', '天津 和平区 南京路59号5-12层 ，近外国语大学。 【 滨江道、小白楼、五大道风景区 天津站、古文化街、意大利风情区 】', '', '', '', '1', '3', '0', '100', '400', '天津市', '天津市', '中国', '8', '2017-04-25 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('3', '北京紫玉度假酒店', '3600', '1', '21', '北京 朝阳区 紫玉东路1号 ，近北辰购物中心。', '', '', '', '1', '3', '0', '779', '2400', '北京市', '北京市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('4', '北京天坛和颐酒店', '3600', '1', '21', '北京 东城区 安乐林路10号22号楼 ，地铁14号线，景泰路上，近北京南站、天坛公园、前门崇文门、天坛医院、天桥、木樨园、方庄。', '', '', '', '1', '4', '0', null, null, '北京市', '北京市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('5', '北京伯豪瑞廷酒店', '3600', '1', '21', '北京 东城区 安乐林路10号22号楼 ，地铁14号线，景泰路上，近北京南站、天坛公园、前门崇文门、天坛医院、天桥、木樨园、方庄。', '', '', '', '1', '3', '0', null, null, '北京市', '北京市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('6', '人民大会堂宾馆', '3600', '1', '21', '北京 西城区 西交民巷甲19号（人民大会堂南门对面） ，近天安门广场。', '', '', '', '1', '5', '0', null, null, '北京市', '北京市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('7', '北京亚奥国际酒店', '3600', '1', '21', '北京 朝阳区 北沙滩大屯路甲1号 ，近北沙滩桥东南角。', '', '', '', '1', '4', '0', '487', '765', '北京市', '北京市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('8', '上海宝安大酒店', '3600', '860', '861', '上海 浦东新区 东方路800号 ，近崂山东路。', '', '', '', '1', '4', '0', '487', '765', '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('9', '浦江精选酒店（上海静安寺地铁站店）（原南京西路店）  ', '3600', '860', '861', '上海 静安区 南京西路1856号4楼 ，近乌鲁木齐路。', '', '', '', '1', '4', '0', '273', '387', '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('10', '上海陆家嘴联洋和颐酒店', '3600', '860', '861', '上海 浦东新区 杨高中路2108号 ，近芳甸路口。', '', '', '', '1', '4', '0', '488', '880', '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('11', '上海虹桥枢纽美居酒店', '3600', '860', '861', '上海 长宁区 虹桥国际机场空港一路398号 ，近迎宾一路。', '', '', '', '1', '4', '0', null, null, '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('12', '上海中山公园和颐至尊酒店 ', '3600', '860', '861', '上海 长宁区 延安西路1119号西侧 ，近番禺路。', '', '', '', '1', '4', '0', null, null, '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('13', '上海宜林君亭酒店', '3600', '860', '861', '上海 虹口区 四川北路1755号 ，近海伦西路。', '', '', '', '1', '4', '0', '612', '722', '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('14', '全季酒店（上海虹桥中山西路店）', '3600', '860', '861', '上海 长宁区 中山西路908号 ，近凯虹路。', '', '', '', '1', '4', '0', '612', '722', '上海市', '上海市', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('15', '南京玄武饭店', '3600', '880', '881', '南京 鼓楼区 中央路193号 ，近湖南路, 玄武湖。', '', '', '', '1', '4', '0', '988', '2288', '南京市', '江苏省', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);
INSERT INTO `itrip_hotel` VALUES ('16', '南京古南都大桥饭店', '3600', '880', '881', '南京 鼓楼区 建宁路255号 ，近大桥南路（东接南京火车站及长途客运总站，西临中山码头，紧邻长江大桥、阅江楼、静海寺，国际博览中心）。', '', '', '', '1', '4', '0', '263', '638', '南京市', '江苏省', '中国', '8', '2017-04-26 00:00:00', null, '2017-05-08 00:00:00', null);

-- ----------------------------
-- Table structure for itrip_hotel_extend_property
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel_extend_property`;
CREATE TABLE `itrip_hotel_extend_property` (
  `id` bigint(11) NOT NULL,
  `hotelId` bigint(11) DEFAULT NULL COMMENT '酒店id',
  `extendPropertyId` bigint(11) DEFAULT NULL COMMENT '推广属性',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of itrip_hotel_extend_property
-- ----------------------------
INSERT INTO `itrip_hotel_extend_property` VALUES ('1', '1', '13');
INSERT INTO `itrip_hotel_extend_property` VALUES ('2', '1', '14');
INSERT INTO `itrip_hotel_extend_property` VALUES ('3', '1', '15');
INSERT INTO `itrip_hotel_extend_property` VALUES ('4', '2', '13');
INSERT INTO `itrip_hotel_extend_property` VALUES ('5', '2', '13');

-- ----------------------------
-- Table structure for itrip_hotel_keyword
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel_keyword`;
CREATE TABLE `itrip_hotel_keyword` (
  `id` bigint(11) NOT NULL,
  `hotelId` bigint(11) NOT NULL,
  `keywordId` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of itrip_hotel_keyword
-- ----------------------------

-- ----------------------------
-- Table structure for itrip_hotel_order
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel_order`;
CREATE TABLE `itrip_hotel_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(11) NOT NULL COMMENT '用户id',
  `orderType` int(11) DEFAULT NULL COMMENT '订单类型(0:旅游产品 1:酒店产品 2：机票产品)',
  `orderNo` int(11) NOT NULL COMMENT '订单号',
  `hotelId` bigint(20) DEFAULT NULL COMMENT '冗余字段 酒店id',
  `hotelName` varchar(255) DEFAULT NULL COMMENT '冗余字段 酒店名称',
  `roomId` bigint(11) NOT NULL COMMENT '房间id',
  `count` int(11) NOT NULL COMMENT '消耗数量',
  `bookingDays` int(255) NOT NULL COMMENT '预订天数',
  `checkInDate` datetime NOT NULL COMMENT '入住时间',
  `checkOutDate` datetime NOT NULL COMMENT '退房时间',
  `orderStatus` int(255) NOT NULL COMMENT '订单状态（0：待支付 1:已取消 2:支付成功 3:已消费）',
  `payAmount` decimal(10,0) DEFAULT NULL COMMENT '支付金额',
  `payType` int(255) DEFAULT NULL COMMENT '支付方式:1:支付宝 2:微信 3:到店付',
  `noticePhone` varchar(255) DEFAULT NULL COMMENT '联系手机号',
  `noticeEmail` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `specialRequirement` text COMMENT '特殊需求',
  `isNeedInvoice` int(1) DEFAULT NULL COMMENT '是否需要发票（0：不需要 1：需要）',
  `invoiceType` int(255) DEFAULT NULL COMMENT '发票类型（0：个人 1：公司）',
  `invoiceHead` varchar(255) DEFAULT NULL COMMENT '发票抬头',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of itrip_hotel_order
-- ----------------------------
INSERT INTO `itrip_hotel_order` VALUES ('1', '1', null, '1', '1', '1', '1', '1', '1', '2016-01-01 00:00:00', '2016-01-02 00:00:00', '1', '1', '1', '1', '1', '', '1', '1', '1', '2016-01-01 00:00:00', '1', '2016-01-01 00:00:00', '1');

-- ----------------------------
-- Table structure for itrip_hotel_room
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel_room`;
CREATE TABLE `itrip_hotel_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `hotelId` bigint(11) NOT NULL COMMENT '酒店ID',
  `roomTitle` varchar(255) NOT NULL COMMENT '房间名称',
  `roomPrice` decimal(10,0) NOT NULL COMMENT '房间价格',
  `roomBedTypeId` bigint(11) NOT NULL COMMENT '酒店床型',
  `isHavingBreakfast` int(255) NOT NULL COMMENT '是否包含早餐',
  `payType` int(1) NOT NULL COMMENT '1:在线付 2:到店付 3:不限',
  `satisfaction` decimal(11,0) NOT NULL COMMENT '满意度（冗余字段，在用户评论后更新）',
  `isBook` int(1) NOT NULL COMMENT '是否可预订(0:不可以 1:可以)',
  `isCancel` int(1) NOT NULL COMMENT '是否可取消(0:不可 1:可以)',
  `isTimelyResponse` int(11) DEFAULT NULL COMMENT '是否及时响应(0:不及时 1:及时)',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='酒店房间表';

-- ----------------------------
-- Records of itrip_hotel_room
-- ----------------------------
INSERT INTO `itrip_hotel_room` VALUES ('1', '1', '高级客房', '628', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('2', '1', '标准遮阳客房', '605', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('3', '1', '特惠家庭套房', '1099', '4', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('4', '1', '标准套房', '1381', '4', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('5', '1', '行政套房', '1677', '4', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('6', '3', '商务大床房', '275', '3', '1', '2', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('7', '3', '标准双床房', '275', '2', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('8', '3', '精选商务房', '294', '3', '1', '3', '4', '1', '1', '1', '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('9', '3', '精选双床房', '294', '2', '1', '1', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('10', '3', '精选印象房', '379', '3', '1', '1', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('11', '3', '精选高级商务房', '313', '3', '1', '1', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('12', '4', '豪华客房', '779', '2', '1', '1', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('13', '4', '庭院房', '879', '3', '1', '2', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('14', '4', '阳台大床房', '1985', '3', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('15', '4', '露台汤池房', '1985', '3', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('16', '4', '豪华套房', '2200', '3', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('17', '4', '行政套房', '2400', '3', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('18', '5', '高级客房', '628', '2', '0', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('19', '5', '标准遮阳客房', '605', '2', '0', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('20', '5', '特惠家庭套房', '679', '4', '1', '3', '4', '1', '1', '1', '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('21', '5', '标准套房', '699', '4', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('22', '6', '高级大床房', '1222', '3', '0', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('23', '6', '行政间', '1546', '3', '0', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('24', '6', '豪华间', '1575', '3', '1', '3', '4', '1', '1', '1', '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('25', '6', '高级双床间', '2891', '2', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('26', '7', '行政标准间', '487', '2', '0', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('27', '7', '商务标准间', '491', '2', '0', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('28', '7', '商务大床房', '765', '3', '1', '3', '4', '1', '1', '1', '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('29', '7', '行政标准间', '579', '2', '1', '3', '4', '1', '1', '1', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('30', '8', '行政标准间', '487', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('31', '8', '商务标准间', '491', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('32', '8', '商务大床房', '765', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('33', '8', '行政标准间', '579', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('34', '9', '惠选大床房', '273', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('35', '9', '精选大床房', '290', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('36', '9', '商务大床房', '358', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('37', '9', '精选标准间', '368', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('38', '9', '精选景观大床房', '387', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('39', '10', '惠选大床房', '488', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('40', '10', '精选大床房', '488', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('41', '10', '商务大床房', '508', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('42', '10', '精选标准间', '568', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('43', '10', '精选景观大床房', '880', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('44', '11', '惠选大床房', '456', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('45', '11', '精选大床房', '488', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('46', '11', '商务大床房', '508', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('47', '11', '精选标准间', '568', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('48', '11', '精选景观大床房', '651', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('49', '12', '惠选大床房', '387', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('50', '12', '精选大床房', '388', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('51', '12', '商务大床房', '508', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('52', '12', '精选标准间', '568', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('53', '12', '精选景观大床房', '651', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('54', '13', '惠选大床房', '612', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('55', '13', '精选大床房', '688', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('56', '13', '商务大床房', '508', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('57', '13', '精选标准间', '568', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('58', '13', '精选景观大床房', '722', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('59', '14', '惠选大床房', '612', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('60', '14', '精选大床房', '688', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('61', '14', '商务大床房', '508', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('62', '14', '精选标准间', '568', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('63', '14', '精选景观大床房', '722', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('64', '14', '惠选大床房', '988', '2', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('65', '14', '精选大床房', '1038', '3', '0', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('66', '14', '商务大床房', '1128', '3', '1', '3', '4', '1', '1', null, '2017-04-27 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('67', '14', '精选标准间', '1588', '2', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_room` VALUES ('68', '14', '精选景观大床房', '2288', '3', '1', '3', '4', '1', '1', null, '2017-04-25 00:00:00', null, null, null);

-- ----------------------------
-- Table structure for itrip_hotel_temp_store
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel_temp_store`;
CREATE TABLE `itrip_hotel_temp_store` (
  `id` bigint(11) NOT NULL,
  `hotelId` int(11) NOT NULL,
  `roomId` bigint(11) NOT NULL COMMENT '商品id',
  `recordDate` datetime NOT NULL COMMENT '记录时间',
  `store` int(11) NOT NULL COMMENT '库存',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实时库存表';

-- ----------------------------
-- Records of itrip_hotel_temp_store
-- ----------------------------

-- ----------------------------
-- Table structure for itrip_hotel_trading_area
-- ----------------------------
DROP TABLE IF EXISTS `itrip_hotel_trading_area`;
CREATE TABLE `itrip_hotel_trading_area` (
  `id` bigint(11) NOT NULL,
  `hotelId` bigint(11) DEFAULT NULL COMMENT '酒店id',
  `areaId` bigint(11) DEFAULT NULL COMMENT '商圈id',
  `creationDate` datetime DEFAULT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of itrip_hotel_trading_area
-- ----------------------------
INSERT INTO `itrip_hotel_trading_area` VALUES ('1', '1', '3619', '2017-04-26 00:00:00', '0', null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('2', '4', '3621', '2017-04-26 00:00:00', '0', null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('3', '2', '3602', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('4', '3', '3620', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('5', '5', '3524', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('6', '7', '3620', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('7', '6', '3619', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('8', '8', '3624', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('9', '9', '3609', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('10', '10', '3624', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('11', '11', '3626', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('12', '12', '3623', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('13', '13', '3652', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('14', '14', '3626', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_hotel_trading_area` VALUES ('15', '15', '3604', '2017-04-26 00:00:00', null, null, null);

-- ----------------------------
-- Table structure for itrip_image
-- ----------------------------
DROP TABLE IF EXISTS `itrip_image`;
CREATE TABLE `itrip_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(255) NOT NULL COMMENT '图片类型(0:酒店图片1:房间图片2:评论图片)',
  `targetId` bigint(11) NOT NULL COMMENT '关联id',
  `position` int(2) DEFAULT NULL COMMENT '图片s上传顺序位置',
  `imgUrl` varchar(255) NOT NULL COMMENT '图片地址',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
-- Records of itrip_image
-- ----------------------------

-- ----------------------------
-- Table structure for itrip_label_dic
-- ----------------------------
DROP TABLE IF EXISTS `itrip_label_dic`;
CREATE TABLE `itrip_label_dic` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT 'key值',
  `value` varchar(255) DEFAULT NULL COMMENT 'value值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `parentId` bigint(20) NOT NULL COMMENT '父级标签id(1级标签则为0)',
  `pic` varchar(255) DEFAULT NULL COMMENT '标签图片地址',
  `creationDate` datetime DEFAULT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COMMENT='标签字典表';

-- ----------------------------
-- Records of itrip_label_dic
-- ----------------------------
INSERT INTO `itrip_label_dic` VALUES ('1', '床型', null, null, '0', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('2', '大床', null, null, '1', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('3', '双床', null, null, '1', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('4', '多床', null, null, '1', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('5', '单人床', null, null, '1', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('6', '酒店设施', null, null, '0', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('7', '通用设施', null, null, '6', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('8', '活动设施', null, null, '6', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('9', '服务项目', null, null, '6', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('10', '客房设施', null, null, '6', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('11', '免费停车场', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('12', '推广属性', null, null, '0', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('13', '有无线上网', null, null, '12', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('14', '免费停车', null, null, '12', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('15', '提供餐饮', null, null, '12', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('16', '酒店特色', null, null, '0', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('17', '东南亚风情', null, '酒店到处都是草坪和热带的大叶绿植，还有大海、沙滩，有着浓浓的海边度假风情。', '16', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('18', '24小时停车', null, null, '6', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('19', '免费交通图', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('20', '免费交通图', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('21', '有可无线上网的公共区域', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('22', '大堂免费报纸', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('23', '中餐厅', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('24', '西餐厅', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('25', '咖啡厅', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('26', '酒吧', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('27', '残疾人客房', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('28', '前台贵重物品保险柜', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('29', '电梯', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('30', '中央空调', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('31', '所有公共及私人场所严禁吸烟', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('32', '多功能厅', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('33', '公共音响系统', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('34', '非经营性客人休息区', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('35', '无烟楼层', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('36', '行政楼层', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('37', '行政酒廊', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('38', '多媒体演示系统', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('39', '公共区域闭路电视监控系统', null, null, '7', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('40', '室内游泳池', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('41', '健身室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('42', '茶室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('43', '会议厅', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('44', '商务中心', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('45', '外币兑换服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('46', '旅游票务服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('47', '洗衣服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('48', '送餐服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('49', '邮政服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('50', '专职行李员', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('51', '行李寄存', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('52', '叫醒服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('53', '接机服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('54', '租车服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('55', '礼宾服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('56', '24小时前台服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('57', '专职门童', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('58', '信用卡结算服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('59', '一次性账单结算服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('60', '24小时大堂经理', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('61', '接站服务', null, null, '9', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('62', '免费洗漱用品(6样以上)', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('63', '免费瓶装水', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('64', '免费报纸', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('65', '客房WIFI覆盖免费', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('66', '国内长途电话', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('67', '国际长途电话', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('68', '拖鞋', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('69', '书桌', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('70', '浴室化妆放大镜', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('71', '24小时热水', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('72', '电热水壶', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('73', '熨衣设备', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('74', '小冰箱', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('75', '浴衣', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('76', '多种规格电源插座', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('77', '浴缸', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('78', '独立淋浴间', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('79', '吹风机', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('80', '房内保险箱', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('81', '中央空调', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('82', '有线频道', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('83', '卫星频道', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('84', '液晶电视机', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('85', '闹钟', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('86', '针线包', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('87', '220V电压插座', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('88', '遮光窗帘', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('89', '手动窗帘', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('90', '备用床具', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('91', '床具:毯子或被子', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('92', '欢迎礼品', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('93', '浴室', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('94', '沙发', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('95', '电子秤', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('96', '房间内高速上网', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('97', '淋浴', null, null, '10', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('98', 'KTV', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('99', '棋牌室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('100', '桌球室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('101', '乒乓球室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('102', '网球场', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('103', '残按摩室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('104', '桑拿浴室', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('105', '前室外游泳池', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('106', 'SPA', null, null, '8', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('107', '出游类型', null, null, '0', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('108', '商务出差', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('109', '朋友出游', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('110', '情侣出游', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('111', '家庭亲子', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('112', '独自旅行', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('113', '代人预定', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('114', '其他', null, null, '107', null, null, null, null, null);
INSERT INTO `itrip_label_dic` VALUES ('115','休闲度假',NULL,'你可以在spa馆享受安静的理疗，也可以来到室外享受托艇冲浪、 滑水、航海等海上活动','16',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `itrip_label_dic` VALUES ('116','亲子时刻',NULL,'儿童乐园、室外泳池、私人海滩等设施都是全家感 受亲子时光的好去处','16',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `itrip_label_dic` VALUES ('117','会议酒店',NULL,'这里是召开会议的理想场所，配备先进的会议设施， 并可提供完善的会议服务','16',NULL,NULL,NULL,NULL,NULL);

-- ----------------------------
-- Table structure for itrip_order_link_user
-- ----------------------------
DROP TABLE IF EXISTS `itrip_order_link_user`;
CREATE TABLE `itrip_order_link_user` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `orderId` bigint(11) NOT NULL COMMENT '订单id',
  `linkUserId` bigint(11) NOT NULL COMMENT '联系人id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of itrip_order_link_user
-- ----------------------------

-- ----------------------------
-- Table structure for itrip_product_store
-- ----------------------------
DROP TABLE IF EXISTS `itrip_product_store`;
CREATE TABLE `itrip_product_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `productType` int(10) NOT NULL COMMENT '商品类型(0:旅游产品 1:酒店产品 2:机票产品)',
  `productId` bigint(11) NOT NULL COMMENT '商品id',
  `store` int(10) NOT NULL COMMENT '商品库存',
  `creationDate` datetime NOT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='原始库存表';

-- ----------------------------
-- Records of itrip_product_store
-- ----------------------------
INSERT INTO `itrip_product_store` VALUES ('1', '1', '1', '20', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('2', '1', '2', '20', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('3', '1', '3', '20', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('4', '1', '4', '20', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('5', '1', '5', '20', '2017-04-25 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('6', '3', '6', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('7', '3', '7', '30', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('8', '3', '8', '30', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('9', '3', '9', '35', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('10', '3', '10', '30', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('11', '3', '11', '30', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('12', '3', '12', '30', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('13', '4', '13', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('14', '4', '14', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('15', '4', '15', '13', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('16', '4', '16', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('17', '4', '17', '5', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('18', '5', '18', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('19', '5', '19', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('20', '5', '20', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('21', '5', '21', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('22', '6', '22', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('23', '6', '23', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('24', '6', '24', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('25', '6', '25', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('26', '7', '26', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('27', '7', '27', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('28', '7', '28', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('29', '7', '29', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('30', '8', '30', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('31', '8', '31', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('32', '8', '32', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('33', '8', '33', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('34', '9', '34', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('35', '9', '35', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('36', '9', '36', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('37', '9', '37', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('38', '9', '38', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('39', '10', '39', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('40', '10', '40', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('41', '10', '41', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('42', '10', '42', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('43', '10', '43', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('44', '11', '44', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('45', '11', '45', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('46', '11', '46', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('47', '11', '47', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('48', '11', '48', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('49', '12', '49', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('50', '12', '50', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('51', '12', '51', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('52', '12', '52', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('53', '12', '53', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('54', '13', '54', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('55', '13', '55', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('56', '13', '56', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('57', '13', '57', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('58', '13', '58', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('59', '14', '59', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('60', '14', '60', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('61', '14', '61', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('62', '14', '62', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('63', '14', '63', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('64', '15', '64', '20', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('65', '15', '65', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('66', '15', '66', '15', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('67', '15', '67', '10', '2017-04-26 00:00:00', null, null, null);
INSERT INTO `itrip_product_store` VALUES ('68', '15', '68', '15', '2017-04-26 00:00:00', null, null, null);

-- ----------------------------
-- Table structure for itrip_user
-- ----------------------------
DROP TABLE IF EXISTS `itrip_user`;
CREATE TABLE `itrip_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userCode` varchar(255) DEFAULT NULL COMMENT '若是第三方登录，系统将自动生成唯一账号；自注册用户则为邮箱或者手机号',
  `userPassword` varchar(255) DEFAULT NULL COMMENT '若是第三方登录，系统将自动生成唯一密码；自注册用户则为自定义密码',
  `userType` int(5) DEFAULT NULL COMMENT '用户类型（标识：0 自注册用户 1 微信登录 2 QQ登录 3 微博登录）',
  `flatID` bigint(20) DEFAULT NULL COMMENT '平台ID（根据不同登录用户，进行相应存入：自注册用户主键ID、微信ID、QQID、微博ID）',
  `userName` varchar(255) NOT NULL COMMENT '用户昵称',
  `weChat` varchar(255) DEFAULT NULL COMMENT '微信号',
  `QQ` varchar(255) DEFAULT NULL COMMENT 'qq账号',
  `weibo` varchar(255) DEFAULT NULL COMMENT '微博账号',
  `baidu` varchar(255) DEFAULT NULL COMMENT '百度账号',
  `activated` int(1) DEFAULT NULL COMMENT '是否激活,默认是false',
  `creationDate` datetime DEFAULT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of itrip_user
-- ----------------------------

-- ----------------------------
-- Table structure for itrip_user_link_user
-- ----------------------------
DROP TABLE IF EXISTS `itrip_user_link_user`;
CREATE TABLE `itrip_user_link_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `linkUserName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '常用联系人姓名',
  `linkIdCardType` int(1) DEFAULT NULL COMMENT '证件类型：(0-身份证，1-护照，2-学生证，3-军人证，4-驾驶证，5-旅行证)',
  `linkIdCard` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件号码',
  `linkPhone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '常用联系人电话',
  `userId` bigint(11) DEFAULT NULL COMMENT '用户id',
  `creationDate` datetime DEFAULT NULL,
  `createdBy` bigint(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  `modifiedBy` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of itrip_user_link_user
-- ----------------------------
