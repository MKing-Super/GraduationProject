/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : used_car_market1

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2021-05-28 18:07:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_dict
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `DICTTYPECODE` varchar(20) DEFAULT NULL COMMENT '数据字典类别代码',
  `DICTTYPENAME` varchar(50) DEFAULT NULL COMMENT '数据字典类别名称',
  `DICTENABLE` varchar(5) DEFAULT NULL COMMENT '是否可用：1：使用0：停用',
  `CREATETIME` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of base_dict
-- ----------------------------
INSERT INTO `base_dict` VALUES ('04d67c19538748489e004495291ddbbf', 'car-model', '2017款 Sportback 40 TFSI 时尚型(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('0c10ce8b50f140deb981b2c11dbc0ba1', 'car-emissionstandard', '国六', '1', '2021-01-31 13:53:29');
INSERT INTO `base_dict` VALUES ('22250a2040d44991a6f26e0c0510be9f', 'car-propertyright', '私户', '1', '2021-01-23 22:54:01');
INSERT INTO `base_dict` VALUES ('2856809ff61c42538367d878a03c9e5b', 'car-level', '大型车', '1', '2021-01-31 13:35:48');
INSERT INTO `base_dict` VALUES ('3c2b60edd2cf40c889af2d93865da9ea', 'car-model', '2017款 28T 时尚型', '0', '2021-01-23 20:57:31');
INSERT INTO `base_dict` VALUES ('3f41dc6937574fea98ab16d44128dc5c', 'car-emissionstandard', '国五', '1', '2021-01-31 13:53:24');
INSERT INTO `base_dict` VALUES ('41f3b7ba1fb44feb88d2eac173401ad5', 'car-model', '2013款 Sportback 50 TFSI quattro(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('459e423d1b474b538054f47605327914', 'car-propertyright', '公户', '1', '2021-01-23 22:53:51');
INSERT INTO `base_dict` VALUES ('45b921a62ed346d7abbb230860afce03', 'car-emissionstandard', '国四', '1', '2021-01-31 13:53:19');
INSERT INTO `base_dict` VALUES ('4ade549286eb477bb1c4dfc765124b90', 'car-model', '2017款 Coupe 40 TFSI 时尚型(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('4fe63a0abf834fca85fcb557dc71e9e5', 'car-level', '中大型车', '1', '2021-01-31 13:36:45');
INSERT INTO `base_dict` VALUES ('5f0b91a3c03b48daa2b9545627093ae1', 'car-brand', '凯迪拉克', '1', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('61e64f9b67e5477ca0a295ff7476ebde', 'car-model', '2017款 Sportback 45 TFSI 运动型(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('6600060223554bbbaf9103c18bb13632', 'car-series', '凯迪拉克CT6', '1', '2021-01-23 21:03:10');
INSERT INTO `base_dict` VALUES ('69e47a94c6da42faa2110040b6f34692', 'car-state', '待售', '1', '2021-02-03 20:19:46');
INSERT INTO `base_dict` VALUES ('6d0b335851c5420a9da69bb41b86aed8', 'car-series', '奥迪A8L', '1', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('706c0be8e9664b08ad8b98d5d1859b08', 'car-model', '2019款 40 TFSI 时尚型 国V', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('710b87de66f742ac8d9492ec7189c70f', 'car-brand', '宝马', '1', '2021-02-03 20:06:31');
INSERT INTO `base_dict` VALUES ('72d4b53c648842aa98a499e125341ecd', 'car-model', '2016款 A8L 45 TFSI quattro豪华型(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('759bd4bfb2b94a7a8b88539b4a3b42f0', 'car-brand', '奥迪', '1', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('8b0c7c19157f49669a33309ac13a6991', 'car-model', '2018款 A8L 55 TFSI quattro尊贵型(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('8be639c3ce00439aa806a33cfadb15d3', 'car-series', '奥迪A4L', '1', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('9561cd682b4146d6b3bdba039dd9e7b1', 'car-model', '2019款 28T 豪华运动型', '0', '2021-01-23 21:03:22');
INSERT INTO `base_dict` VALUES ('b6a1afba191b440d9ed94819cb87abec', 'car-series', '奥迪A5', '1', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('b76d5739f94d481ba454b9d96c130717', 'car-series', '凯迪拉克ATS-L', '1', '2021-01-23 20:56:42');
INSERT INTO `base_dict` VALUES ('bf554dab6439428cbe626b5b35c0b7b2', 'car-state', '审核', '1', '2021-02-03 20:19:40');
INSERT INTO `base_dict` VALUES ('c08dc254eaed405f94b66e4ea720c9e4', 'car-model', '2017款 28T 技术型', '0', '2021-01-23 20:58:12');
INSERT INTO `base_dict` VALUES ('c0987069fa2e454aa9ad9a6444b84c9a', 'car-useproperties', '运营', '1', '2021-01-23 22:52:56');
INSERT INTO `base_dict` VALUES ('ce1b69fb343f41dbadefb51d83412cd0', 'car-level', '中型车', '1', '2021-01-31 13:36:35');
INSERT INTO `base_dict` VALUES ('d14bdc7c4a7940329cbe8ba7a5c3e075', 'car-model', '2020款 改款 325i M运动套装', '0', '2021-02-03 20:07:16');
INSERT INTO `base_dict` VALUES ('d8dba25b213340aa8ba2294b3342f446', 'car-series', '宝马3系', '1', '2021-02-03 20:06:51');
INSERT INTO `base_dict` VALUES ('dff9e98fde804ff4a90ee60022d270eb', 'car-state', '已售', '1', '2021-02-03 20:19:52');
INSERT INTO `base_dict` VALUES ('e01107650d8a48f9a010f3ff34c81e14', 'car-propertyright', '公转私', '1', '2021-01-23 22:54:15');
INSERT INTO `base_dict` VALUES ('e2a7b1c0ea36491eb826dfbca3a41a2d', 'car-model', '2019款 Sportback 40 TFSI 时尚型(进口)', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('ec2d207ad2d842118f8318006e5694b5', 'car-model', '2018款 30周年年型 40 TFSI 进取型', '0', '2021-01-01 00:00:00');
INSERT INTO `base_dict` VALUES ('f7b57a39eddf4f429dcdb0a5ab0911f7', 'car-model', '2019款 28T 豪华型', '0', '2021-01-23 21:03:39');
INSERT INTO `base_dict` VALUES ('fea60b8d47324801b0716e17c2a14672', 'car-useproperties', '非运营', '1', '2021-01-23 22:53:04');

-- ----------------------------
-- Table structure for car_detailed_middle
-- ----------------------------
DROP TABLE IF EXISTS `car_detailed_middle`;
CREATE TABLE `car_detailed_middle` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `PARENTID` varchar(50) DEFAULT NULL COMMENT '父级ID',
  `CHILDREN` varchar(50) DEFAULT NULL COMMENT '子级ID',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆详细信息中间表';

-- ----------------------------
-- Records of car_detailed_middle
-- ----------------------------
INSERT INTO `car_detailed_middle` VALUES ('0364e8b9e8cd4041a5d3e31c621b7691', 'd8dba25b213340aa8ba2294b3342f446', 'd14bdc7c4a7940329cbe8ba7a5c3e075');
INSERT INTO `car_detailed_middle` VALUES ('089166e731324f94b933b7af761ee10e', '6600060223554bbbaf9103c18bb13632', '9561cd682b4146d6b3bdba039dd9e7b1');
INSERT INTO `car_detailed_middle` VALUES ('274f0d2023f343f7ab7cf9e3f6920c6b', '759bd4bfb2b94a7a8b88539b4a3b42f0', 'b6a1afba191b440d9ed94819cb87abec');
INSERT INTO `car_detailed_middle` VALUES ('29c4c8acfcf54caa8d62d00def5977ae', 'b6a1afba191b440d9ed94819cb87abec', '61e64f9b67e5477ca0a295ff7476ebde');
INSERT INTO `car_detailed_middle` VALUES ('2bea714cd91b44bab895f91e403795a6', '6d0b335851c5420a9da69bb41b86aed8', '8b0c7c19157f49669a33309ac13a6991');
INSERT INTO `car_detailed_middle` VALUES ('34586c69de2b490c9530453ffc6d2595', '8be639c3ce00439aa806a33cfadb15d3', '706c0be8e9664b08ad8b98d5d1859b08');
INSERT INTO `car_detailed_middle` VALUES ('355d98b780ec424a835175fdb0e92102', '759bd4bfb2b94a7a8b88539b4a3b42f0', '8be639c3ce00439aa806a33cfadb15d3');
INSERT INTO `car_detailed_middle` VALUES ('3934dddcd2954338989d1a0ff58a6b3a', '5f0b91a3c03b48daa2b9545627093ae1', '6600060223554bbbaf9103c18bb13632');
INSERT INTO `car_detailed_middle` VALUES ('5061b24016274e86af2cb5d18c77d6bc', 'b76d5739f94d481ba454b9d96c130717', '3c2b60edd2cf40c889af2d93865da9ea');
INSERT INTO `car_detailed_middle` VALUES ('53745fe243744eff8c1a58ad2db4ee21', 'b6a1afba191b440d9ed94819cb87abec', 'e2a7b1c0ea36491eb826dfbca3a41a2d');
INSERT INTO `car_detailed_middle` VALUES ('7ae44544973f41d3a87446e80d59b3d9', '6600060223554bbbaf9103c18bb13632', 'f7b57a39eddf4f429dcdb0a5ab0911f7');
INSERT INTO `car_detailed_middle` VALUES ('7e9209db44d7495caf26160a3c6d3527', '759bd4bfb2b94a7a8b88539b4a3b42f0', '6d0b335851c5420a9da69bb41b86aed8');
INSERT INTO `car_detailed_middle` VALUES ('829507831fed47d19d2db9c5d30db7d5', '5f0b91a3c03b48daa2b9545627093ae1', 'b76d5739f94d481ba454b9d96c130717');
INSERT INTO `car_detailed_middle` VALUES ('924a512cf7074d7681ad4dc5f1b07c3a', '6d0b335851c5420a9da69bb41b86aed8', '72d4b53c648842aa98a499e125341ecd');
INSERT INTO `car_detailed_middle` VALUES ('9c6caa33f2ad47958b25622e4e989ad9', '710b87de66f742ac8d9492ec7189c70f', 'd8dba25b213340aa8ba2294b3342f446');
INSERT INTO `car_detailed_middle` VALUES ('b6e2b4a8cbf149d1ae7a061e0dbf1153', 'b6a1afba191b440d9ed94819cb87abec', '41f3b7ba1fb44feb88d2eac173401ad5');
INSERT INTO `car_detailed_middle` VALUES ('cbef156420cd46c4900fbff31ae7e1f4', 'b6a1afba191b440d9ed94819cb87abec', '4ade549286eb477bb1c4dfc765124b90');
INSERT INTO `car_detailed_middle` VALUES ('e7b1d643dee64da68450644f54bedf38', 'b6a1afba191b440d9ed94819cb87abec', '04d67c19538748489e004495291ddbbf');
INSERT INTO `car_detailed_middle` VALUES ('ee105603407d4b08bcc4a010e8f0d345', '8be639c3ce00439aa806a33cfadb15d3', 'ec2d207ad2d842118f8318006e5694b5');
INSERT INTO `car_detailed_middle` VALUES ('f43debbeb0c94ef59b9e17ba41ee0c51', 'b76d5739f94d481ba454b9d96c130717', 'c08dc254eaed405f94b66e4ea720c9e4');

-- ----------------------------
-- Table structure for exh_car
-- ----------------------------
DROP TABLE IF EXISTS `exh_car`;
CREATE TABLE `exh_car` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键',
  `REGISTRATIONTIME` varchar(15) DEFAULT NULL COMMENT '上牌时间',
  `MILEAGE` varchar(15) DEFAULT NULL COMMENT '表显里程',
  `TRANSFERRECORD` varchar(5) DEFAULT NULL COMMENT '过户次数',
  `PRICE` varchar(8) DEFAULT NULL COMMENT '车辆价格',
  `USEPROPERTIES` varchar(10) DEFAULT NULL COMMENT '使用性质',
  `PROPERTYRIGHT` varchar(10) DEFAULT NULL COMMENT '产权性质',
  `STATE` varchar(10) DEFAULT NULL COMMENT '车辆状态',
  `DETAILEDID` varchar(50) DEFAULT NULL COMMENT '详细信息ID',
  `USERID` varchar(50) DEFAULT NULL COMMENT '人员ID',
  `CREATETIME` varchar(25) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`SHEETID`),
  KEY `user_fk_car` (`USERID`),
  KEY `detailed_fk_car` (`DETAILEDID`),
  CONSTRAINT `detailed_fk_car` FOREIGN KEY (`DETAILEDID`) REFERENCES `exh_car_detailed` (`SHEETID`),
  CONSTRAINT `user_fk_car` FOREIGN KEY (`USERID`) REFERENCES `sys_user` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息';

-- ----------------------------
-- Records of exh_car
-- ----------------------------
INSERT INTO `exh_car` VALUES ('16df23fc378144fcba01d3f70d884cd8', '2020-03-06', '2.01', '1', '30.66', '运营', '私户', '已删除', '7fc340f53f3e4b3c948ed0c82df57776', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-03 20:10:37');
INSERT INTO `exh_car` VALUES ('1b64da76e41b4727934359c7b632e1c3', '2021-03-12', '11', '11', '12', '非运营', '公转私', '已售出', '7fc340f53f3e4b3c948ed0c82df57776', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-26 11:44:04');
INSERT INTO `exh_car` VALUES ('213e2d30aa2243a3bc27ae3a19710ba0', '2021-03-04', '1', '1', '11', '非运营', '公转私', '待售', '7fc340f53f3e4b3c948ed0c82df57776', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-26 11:42:29');
INSERT INTO `exh_car` VALUES ('255a07649c3b4780ab046719f2277a28', '2019-06-13', '5.6', '2', '30.66', '运营', '公户', '已售出', '414b4f7452a84c7f9371ad320825b249', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-01-31 14:32:10');
INSERT INTO `exh_car` VALUES ('733d90bdd70842b2b3f866bb9a63dc29', '2021-03-10', '10.11', '1', '20.01', '运营', '公户', '待售', '7fc340f53f3e4b3c948ed0c82df57776', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-10 20:29:05');
INSERT INTO `exh_car` VALUES ('750a613eb8604e6da1883e4399a74ea9', '2018-06-07', '8.5', '1', '12.5', '运营', '私户', '已售出', '0ebfaeead2204819900678fba2bd40d8', '000000', '2021-05-11 20:25:27');
INSERT INTO `exh_car` VALUES ('7dacf205bbf84bb9b37b2a0eeb85f819', '2021-03-12', '23', '23', '23', '非运营', '公转私', '待售', '7fc340f53f3e4b3c948ed0c82df57776', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-26 11:43:01');
INSERT INTO `exh_car` VALUES ('830ea515539545d4b493a3803ed6afa9', '2021-03-02', '11.3', '1', '12.4', '运营', '公户', '已售出', 'ba508a04d2ae48a08b3c2c82f6a53fe3', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-27 10:12:51');
INSERT INTO `exh_car` VALUES ('b41bb75804404000bcad9f453228343e', '2009-02-05', '4.5', '1', '15', '非运营', '公转私', '已售出', 'ba508a04d2ae48a08b3c2c82f6a53fe3', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-01-31 12:44:18');
INSERT INTO `exh_car` VALUES ('c2cf8c663e144b73b65582b97691adb7', '2020-07-16', '1.12', '0', '31.23', '非运营', '私户', '已删除', '7fc340f53f3e4b3c948ed0c82df57776', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-03 20:56:54');
INSERT INTO `exh_car` VALUES ('c8c44f9515294cef98aa7e60d973e9c1', '2021-03-03', '12', '1', '20.7', '非运营', '公转私', '待售', '414b4f7452a84c7f9371ad320825b249', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-26 19:55:47');
INSERT INTO `exh_car` VALUES ('d2c99f81b56248c797473f7af2a3e5c1', '2021-02-25', '12', '1', '12.6', '运营', '公户', '待售', 'ba508a04d2ae48a08b3c2c82f6a53fe3', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 21:10:06');

-- ----------------------------
-- Table structure for exh_car_detailed
-- ----------------------------
DROP TABLE IF EXISTS `exh_car_detailed`;
CREATE TABLE `exh_car_detailed` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `BRAND` varchar(20) DEFAULT NULL COMMENT '品牌',
  `SERIES` varchar(20) DEFAULT NULL COMMENT '车系',
  `MODEL` varchar(50) DEFAULT NULL COMMENT '车型',
  `MAUNFATURER` varchar(20) DEFAULT NULL COMMENT '厂商',
  `LEVEL` varchar(20) DEFAULT NULL COMMENT '等级',
  `ENGINE` varchar(20) DEFAULT NULL COMMENT '发动机',
  `GEARBOX` varchar(20) DEFAULT NULL COMMENT '变速箱',
  `SIZE` varchar(20) CHARACTER SET utf32 DEFAULT NULL COMMENT '尺寸',
  `STRUCTURE` varchar(20) DEFAULT NULL COMMENT '车身结构',
  `EMISSIONSTANDARD` varchar(50) DEFAULT NULL COMMENT '排放标准',
  `DISPLACEMENT` varchar(20) DEFAULT NULL COMMENT '排量',
  `FUELTYPE` varchar(20) DEFAULT NULL COMMENT '燃油类型',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆详细信息';

-- ----------------------------
-- Records of exh_car_detailed
-- ----------------------------
INSERT INTO `exh_car_detailed` VALUES ('08517537b8c64e2a949fbb0f01c30dfd', '奥迪', '奥迪A8L', '2016款 A8L 45 TFSI quattro豪华型(进口)', '奥迪(进口)', '大型车', '3.0T/290马力/V6', '8挡手自一体', '5268/1949/1471', '4门5座三厢车', '国五', '3.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('0ebfaeead2204819900678fba2bd40d8', '凯迪拉克', '凯迪拉克ATS-L', '2017款 28T 技术型', '上汽通用凯迪拉克', '中型车', '2.0T/279马力/L4', '8挡手自一体', '4730/1824/1426', '4门5座三厢车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('21eb0eaaee6c4b5094da17f6296595bc', '奥迪', '奥迪A5', '2013款 Sportback 50 TFSI quattro(进口)', '奥迪(进口)', '中型车', '3.0T/272马力/V6', '7挡双离合', '4712/1854/1391', '5门4座掀背车', '国五', '3.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('23bb219303854608aaa00c1d9f9763f0', '奥迪', '奥迪A5', '2017款 Coupe 40 TFSI 时尚型(进口)', '奥迪(进口)', '中型车', '2.0T/190马力/L4', '7挡双离合', '4700/1846/1371', '2门4座硬顶跑车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('28d139718ae4475eac9847ca84d5ea9b', '奥迪', '奥迪A4L', '2019款 40 TFSI 时尚型 国V', '一汽-大众奥迪', '中型车', '2.0T/190马力/L4', '7挡双离合', '4837/1843/1432', '4门5座三厢车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('394a7372b00646ea8ece7bf9fb56a1e9', '凯迪拉克', '凯迪拉克ATS-L', '2017款 28T 时尚型', '上汽通用凯迪拉克', '中型车', '2.0T/279马力/L4', '8挡手自一体', '5223/1879/1492', '4门5座三厢车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('414b4f7452a84c7f9371ad320825b249', '奥迪', '奥迪A8L', '2018款 A8L 55 TFSI quattro尊贵型(进口)', '奥迪(进口)', '大型车', '3.0T/340马力/V6', '8挡手自一体', '5302/1945/1487', '4门4座三厢车', '国五', '3.0T', '汽油+48V轻混系统');
INSERT INTO `exh_car_detailed` VALUES ('711c0c4cbfa0435389e8a7c9b8e1b276', '奥迪', '奥迪A5', '2017款 Sportback 45 TFSI 运动型(进口)', '奥迪(进口)', '中型车', '2.0T/252马力/L4', '7挡双离合', '4760/1843/1386', '5门5座掀背车', '国四', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('7fc340f53f3e4b3c948ed0c82df57776', '宝马', '宝马3系', '2020款 改款 325i M运动套装', '华晨宝马', '中型车', '2.0T/184马力/L4', '8挡手自一体', '4719/1827/1459', '4门5座三厢车', '国六', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('a2dfdf0926684641a505bbc8b0cb4f13', '奥迪', '奥迪A5', '2017款 Sportback 40 TFSI 时尚型(进口)', '奥迪(进口)', '中型车', '2.0T/190马力/L4', '7挡双离合', '4760/1843/1386', '5门5座掀背车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('b4efc65405244201b4266754c5b626cc', '奥迪', '奥迪A4L', '2018款 30周年年型 40 TFSI 进取型', '一汽-大众奥迪', '中型车', '2.0T/190马力/L4', '7挡双离合', '4818/1843/1432', '4门5座三厢车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('ba508a04d2ae48a08b3c2c82f6a53fe3', '凯迪拉克', '凯迪拉克CT6', '2019款 28T 豪华运动型', '上汽通用凯迪拉克', '中大型车', '2.0T/241马力/L4', '10挡手自一体', '5223/1879/1498', '4门5座三厢车', '国六', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('f39a138d6d964acfbe61dd6df2784fe6', '凯迪拉克', '凯迪拉克CT6', '2019款 28T 豪华型', '上汽通用凯迪拉克', '中大型车', '2.0T/241马力/L4', '10挡手自一体', '5223/1879/1492', '4门5座三厢车', '国五', '2.0T', '汽油');
INSERT INTO `exh_car_detailed` VALUES ('f640d1bde65c4c7eb61d4493629b0268', '奥迪', '奥迪A5', '2019款 Sportback 40 TFSI 时尚型(进口)', '奥迪(进口)', '中型车', '2.0T/190马力/L4', '7挡双离合', '4760/1843/1342', '5门5座掀背车', '国五', '2.0T', '汽油');

-- ----------------------------
-- Table structure for exh_pictures
-- ----------------------------
DROP TABLE IF EXISTS `exh_pictures`;
CREATE TABLE `exh_pictures` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `PATH` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  PRIMARY KEY (`SHEETID`),
  KEY `car_fk_pictures` (`CARID`),
  CONSTRAINT `car_fk_pictures` FOREIGN KEY (`CARID`) REFERENCES `exh_car` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆图片';

-- ----------------------------
-- Records of exh_pictures
-- ----------------------------
INSERT INTO `exh_pictures` VALUES ('01f1c4d047ce4341a6e68e2532d2cd88', '/pictures_upload/3eced1b205ba40e3b3ee5bfc93809282/1168056bb17e461f91c9307528fedc09.jpg', 'c2cf8c663e144b73b65582b97691adb7');
INSERT INTO `exh_pictures` VALUES ('0d4f5ceeddfe4432b1541ac36df09632', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/f102199102e94c47a85ee26facf202cd.jpg', '255a07649c3b4780ab046719f2277a28');
INSERT INTO `exh_pictures` VALUES ('16df61465d3c4747b2418005e4617425', '/pictures_upload/3eced1b205ba40e3b3ee5bfc93809282/5bee6aee6f06443dae15da94388dee5e.jpg', '16df23fc378144fcba01d3f70d884cd8');
INSERT INTO `exh_pictures` VALUES ('24a7f2f6865e4ade8aa6e515f0c2aa07', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/a9d620d3af6146e0aef787d4b47bf69b.jpg', '733d90bdd70842b2b3f866bb9a63dc29');
INSERT INTO `exh_pictures` VALUES ('409c61366da3402da46b17efd9843d9f', '/pictures_upload/5cb37fb45c2f4ff193ac340b50c5c133/df2c9d3781844615bfd54b4b7401732a.jpg', 'd2c99f81b56248c797473f7af2a3e5c1');
INSERT INTO `exh_pictures` VALUES ('40ccccc68ed04914ab659925a3132557', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/816e9569415c46208735515a3eb3825b.jpg', '830ea515539545d4b493a3803ed6afa9');
INSERT INTO `exh_pictures` VALUES ('4d44d60484074eac91d7dcbb73d29d56', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/6b2bad9c971443478dd070e7c81d2968.jpg', '733d90bdd70842b2b3f866bb9a63dc29');
INSERT INTO `exh_pictures` VALUES ('6c59a40b03fd43ba9a3aa60a7c9de513', '/pictures_upload/000000/35deea4702254886ac025f6c3143ab39.jpg', '750a613eb8604e6da1883e4399a74ea9');
INSERT INTO `exh_pictures` VALUES ('82870660191045f297fdb8ced63afd53', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/cd42d69f24224ed891c1b10e2965275c.jpeg', 'b41bb75804404000bcad9f453228343e');
INSERT INTO `exh_pictures` VALUES ('8f5f83a8833c4a19a5dd2a4b61c3f3ed', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/424434d80d474d6ab59258e47061841f.jpg', '830ea515539545d4b493a3803ed6afa9');
INSERT INTO `exh_pictures` VALUES ('a529320cefad4c07bc73fcae7ba2dc48', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/3e2d812efeb64ec089a1049f974cb17a.jpg', '7dacf205bbf84bb9b37b2a0eeb85f819');
INSERT INTO `exh_pictures` VALUES ('aade3dc03a3842879ba14b05db3c9832', '/pictures_upload/3eced1b205ba40e3b3ee5bfc93809282/1bb0a51e647548ef8c3c8cc79b2b66b2.jpg', 'c2cf8c663e144b73b65582b97691adb7');
INSERT INTO `exh_pictures` VALUES ('b08196086b7543de973a7030c93c6c71', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/b9e973828e9c410996076897811b73fc.jpg', '733d90bdd70842b2b3f866bb9a63dc29');
INSERT INTO `exh_pictures` VALUES ('be2656ce954a48bdb0f91362792ed77f', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/a10a0234670b458abeefb18b21b87d86.jpg', '1b64da76e41b4727934359c7b632e1c3');
INSERT INTO `exh_pictures` VALUES ('bf6d01ebedc548528aac0aa7e2e5bb65', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/25afb6d03c504a028453ebf5fea37379.jpg', 'c8c44f9515294cef98aa7e60d973e9c1');
INSERT INTO `exh_pictures` VALUES ('d12cd0b890e84f1698a2e9d18914c4ae', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/48e62522f426483183c8a8e88031b8d3.jpg', 'b41bb75804404000bcad9f453228343e');
INSERT INTO `exh_pictures` VALUES ('d94786c938604b6d9361d4672756a629', '/pictures_upload/000000/a271f4f3f32344af9393eff2fa2893c1.jpg', '750a613eb8604e6da1883e4399a74ea9');
INSERT INTO `exh_pictures` VALUES ('f10520f6a94d409d97cf217683777527', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/5621d44a4c5b474bbccdcc493f3b51f6.jpg', '255a07649c3b4780ab046719f2277a28');
INSERT INTO `exh_pictures` VALUES ('fa1a759d89e24ed681ece6bca79b549e', '/pictures_upload/ce98c9b4dd3441e3a5b00a06a7eff57b/6664e681fc04497fbe3c3c1cadd4ffac.jpg', '213e2d30aa2243a3bc27ae3a19710ba0');

-- ----------------------------
-- Table structure for sys_check
-- ----------------------------
DROP TABLE IF EXISTS `sys_check`;
CREATE TABLE `sys_check` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  `USERID` varchar(50) DEFAULT NULL COMMENT '人员ID',
  `STATE` varchar(5) DEFAULT NULL COMMENT '状态',
  `ADMINID` varchar(50) DEFAULT NULL COMMENT '管理人员ID',
  `STARTTIME` varchar(15) DEFAULT NULL COMMENT '审核开始时间',
  `ENDTIME` varchar(15) DEFAULT NULL COMMENT '审核结束时间',
  PRIMARY KEY (`SHEETID`),
  KEY `user_fk_check` (`ADMINID`),
  CONSTRAINT `user_fk_check` FOREIGN KEY (`ADMINID`) REFERENCES `sys_user` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核表';

-- ----------------------------
-- Records of sys_check
-- ----------------------------

-- ----------------------------
-- Table structure for sys_sale_car
-- ----------------------------
DROP TABLE IF EXISTS `sys_sale_car`;
CREATE TABLE `sys_sale_car` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  `SELLERID` varchar(50) DEFAULT NULL COMMENT '卖方ID',
  `BUYERID` varchar(50) DEFAULT NULL COMMENT '买方ID',
  `DEALTIME` varchar(20) DEFAULT NULL COMMENT '交易时间',
  `DEALPRICE` varchar(10) DEFAULT NULL COMMENT '交易价格',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已售出车辆';

-- ----------------------------
-- Records of sys_sale_car
-- ----------------------------
INSERT INTO `sys_sale_car` VALUES ('71d1cc60df55412c9073eae3f69da01e', '750a613eb8604e6da1883e4399a74ea9', '000000', null, '2021-05-21 19:53:04', '12.5');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键',
  `USERNAME` varchar(30) DEFAULT NULL COMMENT '用户名',
  `PHONE` varchar(15) DEFAULT NULL COMMENT '手机号',
  `PASSWORD` varchar(15) DEFAULT NULL COMMENT '密码',
  `PETNAME` varchar(20) DEFAULT NULL COMMENT '人员昵称',
  `PERSONNALCATEGORY` varchar(10) DEFAULT NULL COMMENT '人员类别',
  `GRADE` varchar(10) DEFAULT NULL COMMENT '等级',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('000000', 'ROOT', 'ROOT', '123', 'ROOT', 'root', 'root');
INSERT INTO `sys_user` VALUES ('383cbbeb417e4820a8f6b5f47970f53e', '小朋友', '123456', 'mm', '游客20210117090132', '0', '1');
INSERT INTO `sys_user` VALUES ('3eced1b205ba40e3b3ee5bfc93809282', '空白', '', '', '空白用户', '0', '1');
INSERT INTO `sys_user` VALUES ('5cb37fb45c2f4ff193ac340b50c5c133', null, '17861408888', 'mm', '小马', '0', '1');
INSERT INTO `sys_user` VALUES ('af1e8f45f7bf431cb61eb4982fec52b3', null, '12345678451111', 'aaaa', '游客20210425110431', '0', '1');
INSERT INTO `sys_user` VALUES ('ce98c9b4dd3441e3a5b00a06a7eff57b', '龙', '17861405200', 'mk', 'qw154', '0', '1');
INSERT INTO `sys_user` VALUES ('d1b71813b9024c88b2d58b190e451225', '阿坤', '3', 'mm', '游客20210117090130', '0', '1');

-- ----------------------------
-- Table structure for user_collections
-- ----------------------------
DROP TABLE IF EXISTS `user_collections`;
CREATE TABLE `user_collections` (
  `SHEETID` varchar(50) NOT NULL COMMENT '收藏表',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  `USERID` varchar(50) DEFAULT NULL COMMENT '人员ID',
  `COLLECTIONTIME` varchar(20) DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`SHEETID`),
  KEY `user_fk_collection` (`USERID`),
  KEY `car_fk_collection` (`CARID`),
  CONSTRAINT `car_fk_collection` FOREIGN KEY (`CARID`) REFERENCES `exh_car` (`SHEETID`),
  CONSTRAINT `user_fk_collection` FOREIGN KEY (`USERID`) REFERENCES `sys_user` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆收藏表';

-- ----------------------------
-- Records of user_collections
-- ----------------------------
INSERT INTO `user_collections` VALUES ('3c815ffd6c1446248ca4be4e8dc74b46', '213e2d30aa2243a3bc27ae3a19710ba0', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 17:04:40');
INSERT INTO `user_collections` VALUES ('5465a9823a0b4ae4829b133085b29fac', 'c8c44f9515294cef98aa7e60d973e9c1', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-27 10:14:52');
INSERT INTO `user_collections` VALUES ('6af7853ade784900ae4e38ebf17f3c9e', '16df23fc378144fcba01d3f70d884cd8', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-03 20:10:59');
INSERT INTO `user_collections` VALUES ('79d28d03fd4840a9b3b61c36bda11bf7', '733d90bdd70842b2b3f866bb9a63dc29', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 21:12:38');
INSERT INTO `user_collections` VALUES ('cd2dadc5b72d4493aed7a4329dfcf190', '7dacf205bbf84bb9b37b2a0eeb85f819', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 17:13:43');
INSERT INTO `user_collections` VALUES ('e471d1bdf38e4bcb92dfd785fc3b2f41', 'c2cf8c663e144b73b65582b97691adb7', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-10 21:29:25');

-- ----------------------------
-- Table structure for user_history
-- ----------------------------
DROP TABLE IF EXISTS `user_history`;
CREATE TABLE `user_history` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  `USERID` varchar(50) DEFAULT NULL COMMENT '人员ID',
  `TIME` varchar(20) DEFAULT NULL COMMENT '浏览时间',
  PRIMARY KEY (`SHEETID`),
  KEY `user_fk_history` (`USERID`),
  KEY `car_fk_history` (`CARID`),
  CONSTRAINT `car_fk_history` FOREIGN KEY (`CARID`) REFERENCES `exh_car` (`SHEETID`),
  CONSTRAINT `user_fk_history` FOREIGN KEY (`USERID`) REFERENCES `sys_user` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆浏览历史';

-- ----------------------------
-- Records of user_history
-- ----------------------------
INSERT INTO `user_history` VALUES ('2dc1529e12374d00a3f84c36051a92f1', '830ea515539545d4b493a3803ed6afa9', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-04-08 20:42:53');
INSERT INTO `user_history` VALUES ('35db3d2ab7984aceb2e2e58e1e084535', '16df23fc378144fcba01d3f70d884cd8', '000000', '2021-03-26 09:22:26');
INSERT INTO `user_history` VALUES ('3c61045070fe445784451b956a719d0d', '7dacf205bbf84bb9b37b2a0eeb85f819', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-04-25 11:23:02');
INSERT INTO `user_history` VALUES ('3ec41caca6124e8fa4085bfdbdce1998', 'c2cf8c663e144b73b65582b97691adb7', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-27 10:14:41');
INSERT INTO `user_history` VALUES ('61f3b758db5949d580a528612f6b6922', 'c2cf8c663e144b73b65582b97691adb7', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-03 21:30:54');
INSERT INTO `user_history` VALUES ('67a3bb88d47c4741bf80c240f6d61efc', '213e2d30aa2243a3bc27ae3a19710ba0', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 21:12:47');
INSERT INTO `user_history` VALUES ('76a15311f87447c3811ca30ef0abca13', '7dacf205bbf84bb9b37b2a0eeb85f819', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 17:13:49');
INSERT INTO `user_history` VALUES ('796690872b714db0906c655d6cb11c31', '733d90bdd70842b2b3f866bb9a63dc29', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-03-26 15:09:32');
INSERT INTO `user_history` VALUES ('7ef6003b073a40508e115465ef391090', 'b41bb75804404000bcad9f453228343e', '000000', '2021-03-10 21:08:12');
INSERT INTO `user_history` VALUES ('8894e4df7c824f1e861e05ea17cc8355', '733d90bdd70842b2b3f866bb9a63dc29', '5cb37fb45c2f4ff193ac340b50c5c133', '2021-03-26 21:12:35');
INSERT INTO `user_history` VALUES ('992aad8655484bbabbcf7aa843478e00', 'c8c44f9515294cef98aa7e60d973e9c1', '000000', '2021-05-21 21:29:20');
INSERT INTO `user_history` VALUES ('a17d7ba31fcc4ac5a8f234ef1500d895', '16df23fc378144fcba01d3f70d884cd8', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-03 20:10:58');
INSERT INTO `user_history` VALUES ('b986299e902b439186e58a92af86c723', '255a07649c3b4780ab046719f2277a28', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-02 22:13:58');
INSERT INTO `user_history` VALUES ('bb6cdb1a475c4c11910dd9a261e3df26', '7dacf205bbf84bb9b37b2a0eeb85f819', '000000', '2021-03-26 13:45:39');
INSERT INTO `user_history` VALUES ('d3910dda9c4c4ad88b64104f968762ee', 'c8c44f9515294cef98aa7e60d973e9c1', 'ce98c9b4dd3441e3a5b00a06a7eff57b', '2021-04-08 20:42:48');
INSERT INTO `user_history` VALUES ('daceae0c173540beac755beba364aab1', '750a613eb8604e6da1883e4399a74ea9', '000000', '2021-05-21 21:29:28');
INSERT INTO `user_history` VALUES ('ebb04de8c3ed4615b4dd37991e417bea', 'b41bb75804404000bcad9f453228343e', '3eced1b205ba40e3b3ee5bfc93809282', '2021-02-03 19:39:02');
INSERT INTO `user_history` VALUES ('f337de2844ec4f33bf83a09a3e370b49', '733d90bdd70842b2b3f866bb9a63dc29', '000000', '2021-03-10 21:07:11');
