/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : used_car_market

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2020-12-20 21:39:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_dict
-- ----------------------------
DROP TABLE IF EXISTS `base_dict`;
CREATE TABLE `base_dict` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `DICTTYPECODE` varchar(50) DEFAULT NULL COMMENT '数据字典类别代码',
  `DICTTYPENAME` varchar(20) DEFAULT NULL COMMENT '数据字典类别名称',
  `DICTITEMNAME` varchar(20) DEFAULT NULL COMMENT '数据字典项目名称',
  `DICTENABLE` varchar(5) DEFAULT NULL COMMENT '是否可用：1：使用0：停用',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of base_dict
-- ----------------------------

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
  PRIMARY KEY (`SHEETID`),
  KEY `user_fk_car` (`USERID`),
  KEY `detailed_fk_car` (`DETAILEDID`),
  CONSTRAINT `detailed_fk_car` FOREIGN KEY (`DETAILEDID`) REFERENCES `exh_car_detailed` (`SHEETID`),
  CONSTRAINT `user_fk_car` FOREIGN KEY (`USERID`) REFERENCES `sys_user` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息';

-- ----------------------------
-- Records of exh_car
-- ----------------------------

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

-- ----------------------------
-- Table structure for sale_car
-- ----------------------------
DROP TABLE IF EXISTS `sale_car`;
CREATE TABLE `sale_car` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  `SELLERID` varchar(50) DEFAULT NULL COMMENT '卖方ID',
  `BUYERID` varchar(50) DEFAULT NULL COMMENT '买方ID',
  `DEALTIME` varchar(20) DEFAULT NULL COMMENT '交易时间',
  `DEALPRICE` varchar(10) DEFAULT NULL COMMENT '交易价格',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已售出车辆';

-- ----------------------------
-- Records of sale_car
-- ----------------------------

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
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键',
  `PHONE` varchar(15) DEFAULT NULL COMMENT '手机号',
  `PASSWORD` varchar(15) DEFAULT NULL COMMENT '密码',
  `PETNAME` varchar(15) DEFAULT NULL COMMENT '人员昵称',
  `PERSONNALCATEGORY` varchar(10) DEFAULT NULL COMMENT '人员类别',
  `GRADE` varchar(10) DEFAULT NULL COMMENT '等级',
  PRIMARY KEY (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('000000', '17861405200', '123', 'ROOT', 'root', 'root');

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

-- ----------------------------
-- Table structure for user_history
-- ----------------------------
DROP TABLE IF EXISTS `user_history`;
CREATE TABLE `user_history` (
  `SHEETID` varchar(50) NOT NULL COMMENT '主键ID',
  `CARID` varchar(50) DEFAULT NULL COMMENT '车辆ID',
  `USERID` varchar(50) DEFAULT NULL COMMENT '人员ID',
  `TIME` varchar(15) DEFAULT NULL COMMENT '浏览时间',
  PRIMARY KEY (`SHEETID`),
  KEY `user_fk_history` (`USERID`),
  KEY `car_fk_history` (`CARID`),
  CONSTRAINT `car_fk_history` FOREIGN KEY (`CARID`) REFERENCES `exh_car` (`SHEETID`),
  CONSTRAINT `user_fk_history` FOREIGN KEY (`USERID`) REFERENCES `sys_user` (`SHEETID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆浏览历史';

-- ----------------------------
-- Records of user_history
-- ----------------------------
