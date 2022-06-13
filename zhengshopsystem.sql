/*
Navicat MySQL Data Transfer

Source Server         : ZHENG
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : zhengshopsystem

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2021-06-13 17:25:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carcode` varchar(255) NOT NULL,
  `usercode` varchar(255) NOT NULL,
  `goodcode` varchar(255) NOT NULL,
  `goodnumber` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL DEFAULT '0',
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uscode` (`usercode`),
  KEY `gocode` (`goodcode`),
  CONSTRAINT `gocode` FOREIGN KEY (`goodcode`) REFERENCES `goods` (`goodcode`),
  CONSTRAINT `uscode` FOREIGN KEY (`usercode`) REFERENCES `user` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', '1', 'sasass2121asa', 'sdadaasdada', '1', '0', '1');
INSERT INTO `car` VALUES ('2', 'e31uuzrcztedv0tm', 'x3ouxvnpec53lxb0', 'mje1gwdxxlsmm1vb', '3', '1', '06/09/2021 11:50 AM');
INSERT INTO `car` VALUES ('3', '41gq14c47m10oq7r', 'x3ouxvnpec53lxb0', '7pogp1o894i9ldzb', '3', '1', '06/09/2021 11:52 AM');
INSERT INTO `car` VALUES ('4', 'r1rhcifr96a1lk3v', 'x3ouxvnpec53lxb0', '4t3qrbrqy0bwo2vk', '2', '1', '06/10/2021 14:27 PM');
INSERT INTO `car` VALUES ('5', 'g0qyycl0ysedhpu7', 'x3ouxvnpec53lxb0', 'j0058q5cxwpmx6mh', '1', '1', '06/10/2021 14:28 PM');
INSERT INTO `car` VALUES ('6', '3esk4t2so1l7qo4t', 'x3ouxvnpec53lxb0', 'oedg6axoar2e1436', '3', '1', '06/10/2021 15:18 PM');
INSERT INTO `car` VALUES ('7', 'a4nq1f7nuoju4efh', 'x3ouxvnpec53lxb0', 'sdadaasdada', '1', '1', '06/11/2021 15:05 PM');
INSERT INTO `car` VALUES ('8', 'rxz9xhg93i54warh', 'x3ouxvnpec53lxb0', 'qpxnzmpk6u653oit', '1', '1', '06/12/2021 14:25 PM');
INSERT INTO `car` VALUES ('9', 'pstowzr33l835wnp', 'x3ouxvnpec53lxb0', 'mje1gwdxxlsmm1vb', '2', '1', '06/12/2021 14:31 PM');
INSERT INTO `car` VALUES ('10', 'putkjfjc1fmy2azp', 'x3ouxvnpec53lxb0', 't83jho9g5c2wwaky', '1', '1', '06/12/2021 14:43 PM');
INSERT INTO `car` VALUES ('11', 'qoonr2clryfudaw9', 'x3ouxvnpec53lxb0', 'ohb3ae351m5yicbr', '1', '1', '06/12/2021 14:47 PM');
INSERT INTO `car` VALUES ('12', 'jvaxyx1jtsmruwzu', 'x3ouxvnpec53lxb0', '4t3qrbrqy0bwo2vk', '1', '1', '06/12/2021 14:50 PM');
INSERT INTO `car` VALUES ('13', '1ccg0ywulgzv5izw', 'x3ouxvnpec53lxb0', 'swuswidwd12121', '1', '1', '06/12/2021 14:52 PM');
INSERT INTO `car` VALUES ('14', 'hhvuvmn2pwuk105q', 'x3ouxvnpec53lxb0', '4t3qrbrqy0bwo2vk', '1', '1', '06/12/2021 15:26 PM');
INSERT INTO `car` VALUES ('15', 'rvuvtboe8aw6305s', 'x3ouxvnpec53lxb0', 'mje1gwdxxlsmm1vb', '1', '1', '06/12/2021 15:26 PM');
INSERT INTO `car` VALUES ('16', 'g8i12ih45uqunnfh', 'x3ouxvnpec53lxb0', 'sdadaasdada', '1', '1', '06/12/2021 15:27 PM');
INSERT INTO `car` VALUES ('17', 'tdf9ouwu0nrhehl0', 'x3ouxvnpec53lxb0', 'swuswidwd12121', '1', '1', '06/12/2021 15:27 PM');
INSERT INTO `car` VALUES ('18', 'oh8itacc8b6p9yu0', 'x3ouxvnpec53lxb0', 'oedg6axoar2e1436', '1', '1', '06/12/2021 15:28 PM');
INSERT INTO `car` VALUES ('19', 'ijnupmaker2312xn', 'x3ouxvnpec53lxb0', 'swuswidwd12121', '1', '1', '06/12/2021 15:28 PM');
INSERT INTO `car` VALUES ('20', 'r1vzv9iuovda5b78', 'x3ouxvnpec53lxb0', 'sdadaasdada', '1', '1', '06/12/2021 15:53 PM');
INSERT INTO `car` VALUES ('21', 'spx9f9lh2y4bnjfj', 'x3ouxvnpec53lxb0', 'sdadaasdada', '1', '1', '06/13/2021 15:18 PM');
INSERT INTO `car` VALUES ('22', 'c4kkhe0u63oarzny', 'x3ouxvnpec53lxb0', 'swuswidwd12121', '1', '1', '06/13/2021 15:18 PM');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodcode` varchar(255) NOT NULL,
  `goodname` varchar(255) NOT NULL,
  `gooddetail` varchar(255) NOT NULL,
  `goodprice` varchar(255) NOT NULL,
  `gooddiscount` varchar(255) NOT NULL,
  `goodusercode` varchar(255) NOT NULL,
  `goodstate` varchar(255) NOT NULL DEFAULT '0',
  `goodimagecode` varchar(255) NOT NULL,
  `gooddate` varchar(255) NOT NULL,
  `goodtypecode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `gooduser_usercode` (`goodusercode`),
  KEY `goodcode` (`goodcode`),
  KEY `goodtypecodegood` (`goodtypecode`),
  CONSTRAINT `goodtypecodegood` FOREIGN KEY (`goodtypecode`) REFERENCES `goodtype` (`goodtypecode`),
  CONSTRAINT `gooduser_usercode` FOREIGN KEY (`goodusercode`) REFERENCES `user` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', 'sdadaasdada', '索尼212122（SONY）京品家电 KD-65X9100H', '索尼（SONY）京品家电 KD-65X9100H 65英寸 4K超高清 游戏电视 全面屏AI智能 HDMI2.1 支持4K120Hz输入', '6499.00', '9', 'x3ouxvnpec53lxb0', '1', '2', '06/10/2021 15:21 PM', '1');
INSERT INTO `goods` VALUES ('3', 'swuswidwd12121', '小米电视4A 60英寸', '小米电视4A 60英寸 L60M5-4A 4K超高清 HDR 内置小爱 2GB+8GB 教育电视 人工智能语音网络液晶平板电视', '2799.00', '8', 'sasass2121asa', '1', '3', '	05/12/2021 1:56 PM', '1');
INSERT INTO `goods` VALUES ('4', 'ogj4ssehw6tsw4lf', 'RedmeMax红米电视4A 60英寸2121', 'Redme红米电视4A 60英寸22 L60M5-4A 4K超高清 HDR 内置小爱 2GB+8GB 教育电视 人工智能语音网络液晶平板电视', '2799.00', '8', 'sqwsnwnsw', '1', 'jpbqbjjmsld8p3xk', '05/26/2021 15:24 PM', '1');
INSERT INTO `goods` VALUES ('5', 'fnv1hjr6d2ixunnv', '红米电视4S 50英寸', '红米电视4S 50英寸 L60M5-4A 4K超高清 HDR 内置小爱 2GB+8GB 教育电视 人工智能语音网络液晶平板电视', '2899.00', '9', 'sqwsnwnsw', '0', 'exhqpsdhw3ec3yah', '05/26/2021 15:25 PM', '3');
INSERT INTO `goods` VALUES ('7', 'qpxnzmpk6u653oit', '荣耀Play5', '荣耀Play5 韦骁龙推荐 5G 66W超级快充 6400万超清四摄 6.53英寸大屏 8GB+128GB 冰岛幻境 双卡双待 全网通', '2099.00', '9', 'sqwsnwnsw', '1', '4tnbsk20elobe9bm', '05/26/2021 15:29 PM', '2');
INSERT INTO `goods` VALUES ('8', 't83jho9g5c2wwaky', '晟旎尚品 衣架', '晟旎尚品 衣架 塑料衣架20只晾衣架无痕衣架宽肩防滑衣服挂干湿两用衣服撑子成人儿童衣服架加厚衣架子混色', '39.90', '9', 'sqwsnwnsw', '1', '5q318ri88z4pe37h', '05/30/2021 18:03 PM', '1');
INSERT INTO `goods` VALUES ('9', 'mje1gwdxxlsmm1vb', 'Apple iPad Pro 11英寸平板电脑', 'Apple iPad Pro 11英寸平板电脑 2021年新款(128G WLAN版/M1芯片Liquid视网膜屏/MHQR3CH/A) 深空灰色', '6199.00', '9', 'sqwsnwnsw', '1', 'ym3ei01d6h6g3qcx', '06/07/2021 14:54 PM', '3');
INSERT INTO `goods` VALUES ('10', '1d8zwxg3lra5q1a8', '荣耀30 Pro', '荣耀30 Pro 50倍远摄 麒麟990 5G 4000万超感光摄影 3200W美颜自拍 游戏手机 全网通版8GB+128GB 绿野仙踪', '3789.00', '9', 'sqwsnwnsw', '1', 'hdc8yxrjptqtlols', '06/07/2021 14:56 PM', '3');
INSERT INTO `goods` VALUES ('11', 'ohb3ae351m5yicbr', 'vivo X60 Pro', 'vivo X60 Pro 12GB+256GB 华彩 5G手机 蔡司光学镜头 超稳微云台四摄 三星5nm旗舰芯片 双模5G全网通手机', '4498.00', '9', 'sqwsnwnsw', '1', 'u6h6ky6yvn3f43gg', '06/07/2021 14:58 PM', '3');
INSERT INTO `goods` VALUES ('12', '4t3qrbrqy0bwo2vk', 'vivo X60', 'vivo X60曲屏版 8G+128G 华彩 5G手机 专业影像旗舰 蔡司光学镜头 三星5nm旗舰芯片 超稳微云台 夜色更精彩', '3499.00', '9', 'sqwsnwnsw', '1', 'n3trtvhl9wlyzta5', '06/07/2021 15:00 PM', '3');
INSERT INTO `goods` VALUES ('13', 'j0058q5cxwpmx6mh', '小米11 5G', '小米11 5G 骁龙888 2K AMOLED四曲面柔性屏 1亿像素 55W有线闪充 50W无线闪充 8GB+128GB 蓝色 游戏手机', '3798.00', '8', 'sqwsnwnsw', '1', '1joj1n8m1li94b8r', '06/08/2021 16:46 PM', '3');
INSERT INTO `goods` VALUES ('14', '7pogp1o894i9ldzb', 'OPPO K9', 'OPPO K9 手机 5G新品 65W超级闪充 长续航游戏手机 k7x升级版 oppok9 8G+128G 黑桃K 全网通套餐【两年保修+晒单返20】', '1999.00', '9', 'sqwsnwnsw', '1', 'a0s34inw41zraaa0', '06/08/2021 16:47 PM', '3');
INSERT INTO `goods` VALUES ('15', 'oedg6axoar2e1436', '森海塞尔（Sennheiser）GameZero', '森海塞尔（Sennheiser）GameZero 专业降噪游戏吃鸡耳机 封闭式头戴式 降噪话筒 声音精准定位 黑色', '749.00', '9', 'sqwsnwnsw', '1', 'd9b2o52uhri4hecw', '06/08/2021 16:49 PM', '3');
INSERT INTO `goods` VALUES ('16', 'gwd6f6awyv5txpf9', '美厨（maxcook）', '美厨（maxcook）炒锅铁锅30CM 燃气炉电磁炉通用 无涂层 可用铁铲 MDB-30', '49.00', '9', 'sqwsnwnsw', '1', '94opco4dirwihvk8', '06/08/2021 16:53 PM', '1');
INSERT INTO `goods` VALUES ('17', 'eezuwkktp5ggp4nk', '贝科姆 基于51单片机声波测距仪', '贝科姆 基于51单片机声波测距仪设计DIY语音GSM防盗倒车雷达报警器套件 ③换1602液晶显示 套餐一：万用板散件', '45.00', '9', 'sqwsnwnsw', '1', '13k2efq9tb6n5gff', '06/08/2021 16:56 PM', '3');
INSERT INTO `goods` VALUES ('18', '8kj1g1ezmtk9g7pw', 'TUMI/途明Alpha Bravo系列时尚皮质拼接男士Davis电脑双肩背包', '商品名称：【618限时礼遇】TUMI/途明Alpha Bravo系列时尚皮质拼接男士Davis电脑双肩背包商品编号：23330157193店铺： TUMI官方旗舰店商品毛重：1.5kg货号：0232682NVY里料材质：织物外料材质：锦纶是否防水：防泼水闭合方式：拉链风格：欧美时尚适用人群：青年内部结构：电脑插袋，拉链暗袋，手机袋，证件袋流行元素：拼接容纳电脑尺寸：14.1-15英寸适用场景：商务图案：纯色颜色：蓝色', '3110.00', '9', 'sqwsnwnsw', '1', 'wa4qjoggroowepoz', '06/08/2021 16:58 PM', 'hg9y40ovzu60ob2k');
INSERT INTO `goods` VALUES ('19', 'fjnze1adeixc6eah', '梅见青梅酒12度梅酒果酒150ml单瓶装', '梅见青梅酒12度梅酒果酒150ml单瓶装', '25.00', '9', 'sqwsnwnsw', '1', 'iz9vzgxs40303fkk', '06/08/2021 17:01 PM', '9');
INSERT INTO `goods` VALUES ('20', 'k4sdvxkc5hhdcty3', '美杜Meidu 镜子', '美杜Meidu 镜子折叠化妆镜大号台式梳妆镜高清便携镜书桌面宿舍寝室随身镜女 方形折叠化妆镜【中号黑色】', '19.00', '9', 'sqwsnwnsw', '1', 'ak46cmc2qje8ltih', '06/08/2021 17:05 PM', '1');

-- ----------------------------
-- Table structure for `goodtype`
-- ----------------------------
DROP TABLE IF EXISTS `goodtype`;
CREATE TABLE `goodtype` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `goodtypecode` varchar(255) NOT NULL,
  `typename` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `goodtype` (`goodtypecode`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodtype
-- ----------------------------
INSERT INTO `goodtype` VALUES ('1', '1', '家用电器');
INSERT INTO `goodtype` VALUES ('2', '2', '手机');
INSERT INTO `goodtype` VALUES ('3', '3', '数码');
INSERT INTO `goodtype` VALUES ('4', '4', '电脑');
INSERT INTO `goodtype` VALUES ('5', '5', '男装');
INSERT INTO `goodtype` VALUES ('6', '6', '女装');
INSERT INTO `goodtype` VALUES ('7', '7', '女鞋');
INSERT INTO `goodtype` VALUES ('8', '8', '男鞋');
INSERT INTO `goodtype` VALUES ('9', '9', '食品');
INSERT INTO `goodtype` VALUES ('10', '10', '图书');
INSERT INTO `goodtype` VALUES ('11', '11', '生鲜');
INSERT INTO `goodtype` VALUES ('19', 'hg9y40ovzu60ob2k', '家居');
INSERT INTO `goodtype` VALUES ('20', 'jfn0j602wc3qddk9', '美妆');
INSERT INTO `goodtype` VALUES ('21', 'qqg6hql4ygwq774a', '房产');

-- ----------------------------
-- Table structure for `images`
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagecode` varchar(255) NOT NULL,
  `imageusercode` varchar(255) NOT NULL,
  `image1` varchar(255) NOT NULL,
  `image2` varchar(255) NOT NULL,
  `image3` varchar(255) NOT NULL,
  `image4` varchar(255) NOT NULL,
  `image5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------
INSERT INTO `images` VALUES ('2', '2', 'sas212a21ss2121asa', 'dqddqdqww.PNG', 'dfuekfheufhhfeukf.PNG', 'drggsegrff.PNG', 'kweejbedkw.PNG', 'ludhdedheu.PNG');
INSERT INTO `images` VALUES ('3', '3', 'sasass2121asa', 'skdwidiw.PNG', 'djiedie223.PNG', 'fhrufr55.PNG', 'skdwidiw.PNG', 'djiedie223.PNG');
INSERT INTO `images` VALUES ('4', 'fwlof0fnhpqu960j', 'sqwsnwnsw', 'i1n9m0u29r442x2816210083986511.PNG', 'fs4frr4pxbppnekk16202766728012.PNG', 'e5o8xmbilmmiekcr16218145987043.PNG', 'mrrv0snjzsx2w2z516230306398874.PNG', '7vfo40b6p84v99xg16211675284105.PNG');
INSERT INTO `images` VALUES ('5', 'dd5i723tm2pebgyd', 'sqwsnwnsw', '27gqpda5x7gckim416231422566371.PNG', 'm3htfioej03kbvtz16223508692232.PNG', 'ou2wvm4wawtuppbm16206804617953.PNG', '0luwo0dnuiwrhjvj16205917160954.PNG', 'hl3q59xgdta1hzon16232250528145.PNG');
INSERT INTO `images` VALUES ('6', 'tw4hjwvupg71cdew', 'sqwsnwnsw', 'ibhqca2hirl5abhm16219326658751.PNG', '08mv9dcmsy6plarc16215538864402.PNG', 'e1sa1m68bucd24q616206060697383.PNG', '09ujeni13t26wwrn16215055123474.PNG', 'ri7bubae16cqy8m516225723842935.PNG');
INSERT INTO `images` VALUES ('7', 'jpbqbjjmsld8p3xk', 'sqwsnwnsw', 'jefgks7r3vuchij516230831169111.PNG', '4jer8w66mxlecaat16229344751132.PNG', 'txkwdvi50vu1c0yq16238566655393.PNG', 'rc2ot2wl7acduwda16206224811074.PNG', '69yid20h3n7k6fqr16210055579925.PNG');
INSERT INTO `images` VALUES ('8', 'exhqpsdhw3ec3yah', 'sqwsnwnsw', '0t18yqu7194blupi1622899231415111.PNG', 'f51agz2t6op16gds1619888816887222.PNG', '2h1oqlbal627u64q1622915642184333.PNG', 'l5rhs1e895zxsoti1623413439031444.PNG', '2ug7z2hngd7ervef1622061726438555.PNG');
INSERT INTO `images` VALUES ('10', '4tnbsk20elobe9bm', 'sqwsnwnsw', '8pym4xcxrlmotu9x1622327986577112.PNG', 'eiw87hxk89lxyset1620130031358222.PNG', 'pfgwgr7s1e6fy4zj1623197545775333.PNG', 'v3gl2vmzx4f98k0v1623813484689112.PNG', '7x7jyem8sevnjnzt1621680018892222.PNG');
INSERT INTO `images` VALUES ('11', '5q318ri88z4pe37h', 'sqwsnwnsw', 'j5jlc9bej685r63416234729141301.PNG', 'f6okassf9bwjuwp516229813247912.PNG', 'jespfgritc7m1ve616206820753543.PNG', 'lr8272z3hx4tonqc16226396278964.PNG', '1wim15jinu75k9xe16233596817055.PNG');
INSERT INTO `images` VALUES ('12', 'ym3ei01d6h6g3qcx', 'sqwsnwnsw', 'st2yt356lvrvtoo316239274065171.PNG', '2fhjxzfoa3n7g16u16220914943132.PNG', 'cf8m6eh3n5nl4ib816229832957783.PNG', '5cxw7v7i5xhutanc16224587304604.PNG', 'u0xm95c30fxnnpav16209895773365.PNG');
INSERT INTO `images` VALUES ('13', 'hdc8yxrjptqtlols', 'sqwsnwnsw', 'n6ean09205cwu6mq16226370937432121.PNG', 'a450cdbtmuynw35u16215254460982121.PNG', 'a2ejkc6jpy28lppm1623897695589444.PNG', 'napvp0ixauufhj3i162428768250533.PNG', 'z8iz8lk7nj2we1jk1621350681195444.PNG');
INSERT INTO `images` VALUES ('14', 'u6h6ky6yvn3f43gg', 'sqwsnwnsw', '0m7ng9zpjuf67ufr16213312251023232dsds.PNG', '0dwk612yomol79vq1622841296016dsds.PNG', 'u359peoizhysadl21624457441481dsdsds.PNG', 'osryb7c14wehowod16223039985443.PNG', 'y76whuua3vnib8zx162323249141533.PNG');
INSERT INTO `images` VALUES ('15', 'n3trtvhl9wlyzta5', 'sqwsnwnsw', 'lntlfswik0o80nu01625049991593fddwdwdw.PNG', '77kks4r5w42nznbv16247940562763232dsds.PNG', '00o6ow0hmp6qhqzl1623926861698444.PNG', 'pvk34ll5m71bpi5j1624912883330dwdwdwd.PNG', 'bxjahwyv6vkgralr1622557797434dwdwdwd.PNG');
INSERT INTO `images` VALUES ('16', '1joj1n8m1li94b8r', 'sqwsnwnsw', 'xwjjiqubw3cele1l16249051687991.PNG', 'mv05ev87k0r7uitk16240781312772.PNG', '6bbn7q4ah16udfk916212198306083.PNG', 'qn6t6yxu79n83pzo16250343006914.PNG', '5h1qol4oh6nalumi16248260538605.PNG');
INSERT INTO `images` VALUES ('17', 'a0s34inw41zraaa0', 'sqwsnwnsw', 'g62o2lq0iz7vdiub162288192509022.PNG', '9qt48vvuau6km5mq16232091147054.PNG', 'tvkh1mg4v04lb9o316248072463391.PNG', 'oxcm1nbtswwj16e316211490888145.PNG', 'xo6rlaapo6ciew5k16230841257832.PNG');
INSERT INTO `images` VALUES ('18', 'd9b2o52uhri4hecw', 'sqwsnwnsw', 'ia0d4kr3m6a14z4t16223628650142121.PNG', 'o5nbdja2ejymbslg162450047624321212212.PNG', 'n8skgi461ez5o332162527410100421212221212.PNG', 'duyd0czy0p9rclr116232737815342121.PNG', 'w8cozc81hh9v38cr162330449293721212212.PNG');
INSERT INTO `images` VALUES ('19', '94opco4dirwihvk8', 'sqwsnwnsw', '45nqncc2xg3hwkq916239770239652121212121.PNG', 'vnncf8ryy2l5vf1b1622112488743212122121221.PNG', 'ogmcrvh48baz5w89162325418054821212121221212.PNG', '1d7n6x6a6ij9vufj162136810110221212121221212.PNG', 'qnyu0a7ydxn2kqmu1622286942003212122121221.PNG');
INSERT INTO `images` VALUES ('20', '13k2efq9tb6n5gff', 'sqwsnwnsw', 'aycgt6m5yuj886c916241588922732121212121212121.PNG', '9vmpns7bbwmvun9q162215850117821212121212.PNG', 'gxask2eu26zwernf162272935655521212121212.PNG', 'mzki9sf44f92onpb16211215627692121212121212121.PNG', 'a935559x5zjnpqrt162258000926711111.PNG');
INSERT INTO `images` VALUES ('21', 'wa4qjoggroowepoz', 'sqwsnwnsw', 'j1k43twraqbqx5181624349167647fwdwdwd.PNG', 'sn8yxa55nfivzojm1624031858658fwdwdw.PNG', '38i0szwmisrgyq9z1622032069955544dsdwd.PNG', 'j40ixuep9d43wpq81621649764040fwdwdwd.PNG', 'd5hf4s6t69fa5u421625253708099fwdwdw.PNG');
INSERT INTO `images` VALUES ('22', 'iz9vzgxs40303fkk', 'sqwsnwnsw', '89qyuzb81yel0qrs1624485796959fdedd.PNG', 'a9zk3v6ua3pbjh0a1624950993250fefwf.PNG', 'yhzy7p336vthpt0r1623944088978ffsdfes.PNG', 'pnp7s09fj932u8xz1625195665832fsddfsfs.PNG', 'amiaj8w05qh6lr2y1623792657395ffsdfes.PNG');
INSERT INTO `images` VALUES ('23', 'ak46cmc2qje8ltih', 'sqwsnwnsw', 'dznls6lrhuf5wdxh1623643802170csaxw.PNG', 'n23fly5kbqqvdj6f1623710648484dadadad.PNG', 'dsf8i977eaiji7s91621542087894dadadawd.PNG', 'jr4vqxltdvqr834c1621387396408dadawdawd.PNG', 'i1umj40xa22pts7j1621795254091dadadad.PNG');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menucode` varchar(255) NOT NULL,
  `menuname` varchar(255) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `menucode` (`menucode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderdetailcode` varchar(255) NOT NULL,
  `usersellercode` varchar(255) NOT NULL,
  `userbuyercode` varchar(255) NOT NULL,
  `ordercode` varchar(255) NOT NULL,
  `goodcode` varchar(255) NOT NULL,
  `goodnumber` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL DEFAULT '0',
  `date` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userscode` (`usersellercode`),
  KEY `userbcode` (`userbuyercode`),
  CONSTRAINT `userbcode` FOREIGN KEY (`userbuyercode`) REFERENCES `user` (`usercode`),
  CONSTRAINT `userscode` FOREIGN KEY (`usersellercode`) REFERENCES `user` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', 'huoew7d0ylg0tnq7', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'huoew7d0ylg0tnq7', 'mje1gwdxxlsmm1vb', '1', '0', '06/11/2021 14:55 PM', '6199.0');
INSERT INTO `orderdetail` VALUES ('2', 'huoew7d0ylg0tnq7', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'huoew7d0ylg0tnq7', '7pogp1o894i9ldzb', '2', '0', '06/11/2021 14:55 PM', '3998.0');
INSERT INTO `orderdetail` VALUES ('3', 'pdrivaihkzktic7g', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'pdrivaihkzktic7g', 'mje1gwdxxlsmm1vb', '1', '4', '06/11/2021 15:02 PM', '6199.0');
INSERT INTO `orderdetail` VALUES ('4', 'pdrivaihkzktic7g', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'pdrivaihkzktic7g', '7pogp1o894i9ldzb', '2', '4', '06/11/2021 15:02 PM', '3998.0');
INSERT INTO `orderdetail` VALUES ('5', 'vki0eaqgmen1dv4l', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'vki0eaqgmen1dv4l', '4t3qrbrqy0bwo2vk', '1', '1', '06/11/2021 15:04 PM', '3499.0');
INSERT INTO `orderdetail` VALUES ('6', 'uo7wip100bxzwcib', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'uo7wip100bxzwcib', 'j0058q5cxwpmx6mh', '1', '0', '06/11/2021 15:05 PM', '3798.0');
INSERT INTO `orderdetail` VALUES ('7', 'uo7wip100bxzwcib', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'uo7wip100bxzwcib', 'oedg6axoar2e1436', '1', '0', '06/11/2021 15:05 PM', '749.0');
INSERT INTO `orderdetail` VALUES ('8', '6guo1aqo6y3gzywi', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', '6guo1aqo6y3gzywi', 'qpxnzmpk6u653oit', '1', '1', '06/12/2021 14:31 PM', '2099.0');
INSERT INTO `orderdetail` VALUES ('9', '6guo1aqo6y3gzywi', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', '6guo1aqo6y3gzywi', 'mje1gwdxxlsmm1vb', '1', '1', '06/12/2021 14:31 PM', '6199.0');
INSERT INTO `orderdetail` VALUES ('10', 'cgfczl99jc31y74d', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'cgfczl99jc31y74d', 'qpxnzmpk6u653oit', '2', '0', '06/12/2021 14:31 PM', '4198.0');
INSERT INTO `orderdetail` VALUES ('11', 'cgfczl99jc31y74d', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'cgfczl99jc31y74d', 'mje1gwdxxlsmm1vb', '1', '0', '06/12/2021 14:31 PM', '6199.0');
INSERT INTO `orderdetail` VALUES ('12', '9pmo5yxis6kgdv3m', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', '9pmo5yxis6kgdv3m', 'mje1gwdxxlsmm1vb', '2', '1', '06/12/2021 14:32 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('13', 'ta7dxi5wfeje23tw', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'ta7dxi5wfeje23tw', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:34 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('14', 'jtgp6wn03okz3luc', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', 'jtgp6wn03okz3luc', 'sdadaasdada', '8', '0', '06/12/2021 14:36 PM', '51992.0');
INSERT INTO `orderdetail` VALUES ('15', 'inhri55o366ulnja', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'inhri55o366ulnja', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:43 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('16', 'inhri55o366ulnja', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'inhri55o366ulnja', 't83jho9g5c2wwaky', '1', '0', '06/12/2021 14:43 PM', '39.9');
INSERT INTO `orderdetail` VALUES ('17', 'g7jfryigw3vwqnjl', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'g7jfryigw3vwqnjl', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:47 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('18', 'g7jfryigw3vwqnjl', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'g7jfryigw3vwqnjl', 'ohb3ae351m5yicbr', '1', '0', '06/12/2021 14:47 PM', '4498.0');
INSERT INTO `orderdetail` VALUES ('19', 'uvwwgw0x3aro5up1', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'uvwwgw0x3aro5up1', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:50 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('20', 'uvwwgw0x3aro5up1', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'uvwwgw0x3aro5up1', '4t3qrbrqy0bwo2vk', '1', '0', '06/12/2021 14:50 PM', '3499.0');
INSERT INTO `orderdetail` VALUES ('21', 'i7mnh0kf3v71sxrt', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'i7mnh0kf3v71sxrt', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:51 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('22', 'i7mnh0kf3v71sxrt', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'i7mnh0kf3v71sxrt', '4t3qrbrqy0bwo2vk', '1', '0', '06/12/2021 14:51 PM', '3499.0');
INSERT INTO `orderdetail` VALUES ('23', 'kvntxjn6xzse3qez', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'kvntxjn6xzse3qez', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:53 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('24', 'kvntxjn6xzse3qez', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'kvntxjn6xzse3qez', '4t3qrbrqy0bwo2vk', '1', '0', '06/12/2021 14:53 PM', '3499.0');
INSERT INTO `orderdetail` VALUES ('25', 't4p6vz4cnmezzj9b', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 't4p6vz4cnmezzj9b', 'mje1gwdxxlsmm1vb', '2', '0', '06/12/2021 14:55 PM', '12398.0');
INSERT INTO `orderdetail` VALUES ('26', 't4p6vz4cnmezzj9b', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 't4p6vz4cnmezzj9b', '4t3qrbrqy0bwo2vk', '1', '0', '06/12/2021 14:55 PM', '3499.0');
INSERT INTO `orderdetail` VALUES ('27', 'rluknj5kyiivekta', 'sasass2121asa', 'x3ouxvnpec53lxb0', 'rluknj5kyiivekta', 'swuswidwd12121', '1', '0', '06/12/2021 14:56 PM', '2799.0');
INSERT INTO `orderdetail` VALUES ('28', 'ow70vhpj07kk2fkz', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'ow70vhpj07kk2fkz', '4t3qrbrqy0bwo2vk', '1', '0', '06/12/2021 15:26 PM', '3499.0');
INSERT INTO `orderdetail` VALUES ('29', 'ow70vhpj07kk2fkz', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'ow70vhpj07kk2fkz', 'mje1gwdxxlsmm1vb', '1', '0', '06/12/2021 15:26 PM', '6199.0');
INSERT INTO `orderdetail` VALUES ('30', 'g6w7faevltyayz2p', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', 'g6w7faevltyayz2p', 'sdadaasdada', '1', '1', '06/12/2021 15:27 PM', '6499.0');
INSERT INTO `orderdetail` VALUES ('31', 'g6w7faevltyayz2p', 'sasass2121asa', 'x3ouxvnpec53lxb0', 'g6w7faevltyayz2p', 'swuswidwd12121', '1', '1', '06/12/2021 15:27 PM', '2799.0');
INSERT INTO `orderdetail` VALUES ('32', 'hql4r57p5w7ct6h6', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'hql4r57p5w7ct6h6', 'oedg6axoar2e1436', '1', '1', '06/12/2021 15:28 PM', '749.0');
INSERT INTO `orderdetail` VALUES ('33', 'hql4r57p5w7ct6h6', 'sasass2121asa', 'x3ouxvnpec53lxb0', 'hql4r57p5w7ct6h6', 'swuswidwd12121', '1', '1', '06/12/2021 15:28 PM', '2799.0');
INSERT INTO `orderdetail` VALUES ('34', 'b3q9mxk0n1xcw1ae', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', 'b3q9mxk0n1xcw1ae', 'sdadaasdada', '1', '1', '06/12/2021 15:53 PM', '6499.0');
INSERT INTO `orderdetail` VALUES ('35', 'xk3gwg1n8jlvlfw0', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', 'xk3gwg1n8jlvlfw0', 'sdadaasdada', '1', '0', '06/12/2021 15:59 PM', '6499.0');
INSERT INTO `orderdetail` VALUES ('36', '3ofbupmmwsf16dcg', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', '3ofbupmmwsf16dcg', 'sdadaasdada', '1', '0', '06/12/2021 15:59 PM', '6499.0');
INSERT INTO `orderdetail` VALUES ('37', 'trt2tzezpekdhn2h', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'trt2tzezpekdhn2h', '7pogp1o894i9ldzb', '1', '1', '06/12/2021 16:00 PM', '1999.0');
INSERT INTO `orderdetail` VALUES ('38', 'piopk5w3f18yvn30', 'sqwsnwnsw', 'x3ouxvnpec53lxb0', 'piopk5w3f18yvn30', '1d8zwxg3lra5q1a8', '1', '1', '06/12/2021 17:15 PM', '3789.0');
INSERT INTO `orderdetail` VALUES ('43', 'tspmllq0ami68d6s', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', 'tspmllq0ami68d6s', 'sdadaasdada', '1', '1', '06/13/2021 16:17 PM', '6499.0');
INSERT INTO `orderdetail` VALUES ('44', 'jagnpo7qlhrxit76', 'x3ouxvnpec53lxb0', 'x3ouxvnpec53lxb0', 'jagnpo7qlhrxit76', 'sdadaasdada', '1', '1', '06/13/2021 17:01 PM', '6499.0');
INSERT INTO `orderdetail` VALUES ('45', 'jagnpo7qlhrxit76', 'sasass2121asa', 'x3ouxvnpec53lxb0', 'jagnpo7qlhrxit76', 'swuswidwd12121', '1', '1', '06/13/2021 17:01 PM', '2799.0');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordercode` varchar(255) NOT NULL,
  `usercode` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userrcode` (`usercode`),
  CONSTRAINT `userrcode` FOREIGN KEY (`usercode`) REFERENCES `user` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'huoew7d0ylg0tnq7', 'x3ouxvnpec53lxb0', '0', '06/11/2021 14:55 PM', '10197.0');
INSERT INTO `orders` VALUES ('2', 'pdrivaihkzktic7g', 'x3ouxvnpec53lxb0', '4', '06/11/2021 15:02 PM', '10197.0');
INSERT INTO `orders` VALUES ('3', 'vki0eaqgmen1dv4l', 'x3ouxvnpec53lxb0', '1', '06/11/2021 15:04 PM', '3499.0');
INSERT INTO `orders` VALUES ('4', 'uo7wip100bxzwcib', 'x3ouxvnpec53lxb0', '1', '06/11/2021 15:05 PM', '4547.0');
INSERT INTO `orders` VALUES ('5', '6guo1aqo6y3gzywi', 'x3ouxvnpec53lxb0', '1', '06/12/2021 14:31 PM', '8298.0');
INSERT INTO `orders` VALUES ('6', 'cgfczl99jc31y74d', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:31 PM', '10397.0');
INSERT INTO `orders` VALUES ('7', '9pmo5yxis6kgdv3m', 'x3ouxvnpec53lxb0', '1', '06/12/2021 14:32 PM', '12398.0');
INSERT INTO `orders` VALUES ('8', 'ta7dxi5wfeje23tw', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:34 PM', '12398.0');
INSERT INTO `orders` VALUES ('9', 'jtgp6wn03okz3luc', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:36 PM', '51992.0');
INSERT INTO `orders` VALUES ('10', 'inhri55o366ulnja', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:43 PM', '12437.9');
INSERT INTO `orders` VALUES ('11', 'g7jfryigw3vwqnjl', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:47 PM', '16896.0');
INSERT INTO `orders` VALUES ('12', 'uvwwgw0x3aro5up1', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:50 PM', '15897.0');
INSERT INTO `orders` VALUES ('13', 'i7mnh0kf3v71sxrt', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:51 PM', '15897.0');
INSERT INTO `orders` VALUES ('14', 'kvntxjn6xzse3qez', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:53 PM', '15897.0');
INSERT INTO `orders` VALUES ('15', 't4p6vz4cnmezzj9b', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:55 PM', '15897.0');
INSERT INTO `orders` VALUES ('16', 'rluknj5kyiivekta', 'x3ouxvnpec53lxb0', '0', '06/12/2021 14:56 PM', '2799.0');
INSERT INTO `orders` VALUES ('17', 'ow70vhpj07kk2fkz', 'x3ouxvnpec53lxb0', '0', '06/12/2021 15:26 PM', '9698.0');
INSERT INTO `orders` VALUES ('18', 'g6w7faevltyayz2p', 'x3ouxvnpec53lxb0', '1', '06/12/2021 15:27 PM', '9298.0');
INSERT INTO `orders` VALUES ('19', 'hql4r57p5w7ct6h6', 'x3ouxvnpec53lxb0', '1', '06/12/2021 15:28 PM', '3548.0');
INSERT INTO `orders` VALUES ('20', 'b3q9mxk0n1xcw1ae', 'x3ouxvnpec53lxb0', '1', '06/12/2021 15:53 PM', '6499.0');
INSERT INTO `orders` VALUES ('21', 'xk3gwg1n8jlvlfw0', 'x3ouxvnpec53lxb0', '0', '06/12/2021 15:59 PM', '6499.0');
INSERT INTO `orders` VALUES ('22', '3ofbupmmwsf16dcg', 'x3ouxvnpec53lxb0', '0', '06/12/2021 15:59 PM', '6499.0');
INSERT INTO `orders` VALUES ('23', 'trt2tzezpekdhn2h', 'x3ouxvnpec53lxb0', '1', '06/12/2021 16:00 PM', '1999.0');
INSERT INTO `orders` VALUES ('24', 'piopk5w3f18yvn30', 'x3ouxvnpec53lxb0', '1', '06/12/2021 17:15 PM', '3789.0');
INSERT INTO `orders` VALUES ('29', 'tspmllq0ami68d6s', 'x3ouxvnpec53lxb0', '1', '06/13/2021 16:17 PM', '6499.0');
INSERT INTO `orders` VALUES ('30', 'jagnpo7qlhrxit76', 'x3ouxvnpec53lxb0', '1', '06/13/2021 17:01 PM', '9298.0');

-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockcode` varchar(255) NOT NULL,
  `goodcode` varchar(255) NOT NULL,
  `goodnumber` varchar(255) NOT NULL,
  `usercode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `gcode_gcode` (`goodcode`),
  KEY `ucode` (`usercode`),
  CONSTRAINT `gcode_gcode` FOREIGN KEY (`goodcode`) REFERENCES `goods` (`goodcode`),
  CONSTRAINT `ucode` FOREIGN KEY (`usercode`) REFERENCES `user` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '7pltrcnjt468gk4d', 'qpxnzmpk6u653oit', '16', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('2', '4c6h5ku48riovx0h', 't83jho9g5c2wwaky', '6', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('3', '5aclzmaio0zwjpdy', 'mje1gwdxxlsmm1vb', '2', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('4', 'omvwcq0tfpreowrs', '1d8zwxg3lra5q1a8', '1', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('5', 'zblo7uzxp135kccf', 'ohb3ae351m5yicbr', '1', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('6', '2gh1wzrdddj34gou', '4t3qrbrqy0bwo2vk', '1', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('7', 'j1tah1tgd2lym97b', 'j0058q5cxwpmx6mh', '2', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('8', 'y9bst8346zmixq50', '7pogp1o894i9ldzb', '2', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('9', 'wgkz9ilgrm3uulks', 'oedg6axoar2e1436', '2', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('10', '0pjexar1k24r7cjb', 'gwd6f6awyv5txpf9', '1', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('11', '9ipx23wev0o5h5ln', 'eezuwkktp5ggp4nk', '2', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('12', 'ev2hbf856l4aac6n', '8kj1g1ezmtk9g7pw', '1', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('13', 'mxcdc5137uchtww1', 'fjnze1adeixc6eah', '1', 'sqwsnwnsw');
INSERT INTO `stock` VALUES ('14', '5wle8espdn95z2t6', 'k4sdvxkc5hhdcty3', '1', 'sqwsnwnsw');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `usertype` varchar(255) NOT NULL DEFAULT '2',
  `state` varchar(255) NOT NULL DEFAULT '1',
  `image` varchar(255) DEFAULT NULL,
  `date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usercode` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sqwsnwnsw', '郑旭杰', '123456', 'Zeo', '2879967183@qq.com', '18586256816', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('3', 'sasass2121asa', '站三121212', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('4', 'sas212ass2121asa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('5', 'sas212a21ss2121asa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('6', 's2121a21ss2121asa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('7', 's2121a21ss2121asa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('8', '212s2121a21ss2121asa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('9', '121asa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('10', '121a2121sa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('11', '121121sa', '站三', '21212121', 'zhangsan', '2121@qq.com', '12211111111', '2', '1', '/upload/AdminLTELogo.png', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('14', '9umf0jptuipmmcb1', 'admin1212', '21212', 'XuJie Zheng', '21212@qq.com', '+8618586256816', '1', '1', '/upload/16211364066151.jpg', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('16', '2c0jaelynngwa5vx', 'tom21212', '21212', 'sun zheng21212', '212129967183@qq.com', '18586256816', '1', '1', '/upload/16211364066151.jpg', '05/14/2021 1:54 PM');
INSERT INTO `user` VALUES ('17', 'mbvddcbpsmg8vt0p', 'andy1212', 'andy1212', 'andy1212', 'andy1212@qq.com', '11586256816', '1', '1', 'upload/16204912722501.jpg', '07/10/2021 3:46 PM');
INSERT INTO `user` VALUES ('18', 'gbjdfmw7v449gepn', '源于我', '1123', '源于我', '123@qq.com', '18586256816', '2', '1', 'upload/1620068173971捕获.PNG', '05/28/2021 9:42 PM');
INSERT INTO `user` VALUES ('19', 'x3ouxvnpec53lxb0', '但我觉得我', '321', '但我觉得我', '321@qq.com', '18586256816', '1', '1', 'upload/g49qdz4tlz1ewpkh1621115209509111.png', '07/09/2021 3:37 PM');
INSERT INTO `user` VALUES ('20', 'idmlvkay95lhj085', '邯郸市飒飒', '1212122121', '邯郸市飒飒', '111111111@qq.com', '11111111111', '1', '1', 'upload/1622439442657(167).pngoc0vk5tgndi3d617', '05/19/2021 8:26 AM');
INSERT INTO `user` VALUES ('21', 'k92l27wsarm8zsiq', '郑旭杰', '123456', 'Zeo', '2879977183@qq.com', '18586256816', '2', '1', 'upload/1622065158639gir1evjuri93cqgg', '05/12/2021 1:56 PM');
INSERT INTO `user` VALUES ('22', 'prqgr3nf4qrlqhdl', '毕淑娜', '1233', '毕淑娜', 'bishuna@qq.com', '18586256816', '2', '1', 'upload/gjlseusc0dibkkd71622746988386car2.jpg', '05/11/2021 3:05 PM');
INSERT INTO `user` VALUES ('23', '9194qzwi47umuatf', '123@qq.com', '123456', 'zhangsna', '123@qq.com', '13514711438', '2', '1', null, '06/02/2021 11:43 AM');
INSERT INTO `user` VALUES ('24', '0eixa9l6jyfutp7e', 'Zheng@qq.com', '123456', 'lishi', 'Zheng@qq.com', '15648148585', '2', '1', null, '06/02/2021 11:46 AM');

-- ----------------------------
-- Table structure for `user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `user_menu`;
CREATE TABLE `user_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_menucode` varchar(255) NOT NULL,
  `usercode` varchar(255) NOT NULL,
  `menucode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ucodec` (`usercode`),
  KEY `mcode` (`menucode`),
  CONSTRAINT `mcode` FOREIGN KEY (`menucode`) REFERENCES `menu` (`menucode`),
  CONSTRAINT `ucodec` FOREIGN KEY (`usercode`) REFERENCES `user` (`usercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_menu
-- ----------------------------
