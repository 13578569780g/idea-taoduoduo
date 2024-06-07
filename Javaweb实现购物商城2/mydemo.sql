
CREATE TABLE `car` (
  `user_name` varchar(50),
  `goods` varchar(50) ,
  `amount` varchar(50) ,
  `state` varchar(50) 
);

INSERT INTO `car` VALUES ('张三','25','1','0'),('张三','18','2','0');



CREATE TABLE `commodity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) ,
  `price` varchar(50) ,
  `introduce` varchar(50) ,
  `img` varchar(500) ,
  `type` int ,
  PRIMARY KEY (`id`)
) ;


INSERT INTO `commodity` VALUES (17,'金银花','2','非常好','Mysql_imgs/金银花.jpg',8),(18,'丽格海棠','12','非常好','Mysql_imgs/丽格海棠.jpg',8),(19,'鸡蛋花','12','非常好','Mysql_imgs/鸡蛋花.jpg',8),(20,'睡莲','12','非常好','Mysql_imgs/睡莲.jpg',6),(21,'梅花','12','非常非常好吃','Mysql_imgs/梅花.jpg',6),(22,'铁兰','12','非常非常好吃','Mysql_imgs/铁兰.jpg',6),(23,'马蹄莲','12','非常非常好吃','Mysql_imgs/马蹄莲.jpg',6),(24,'康乃馨','12','非常非常好吃','Mysql_imgs/康乃馨.jpg',6),(25,'勿忘我','12','非常非常好吃','Mysql_imgs/勿忘我.jpg',6),(26,'风信子','12','非常非常好吃','Mysql_imgs/风信子.jpg',6),(27,'木荷','12','非常非常好吃','Mysql_imgs/木荷.jpg',6),(28,'猫尾草','12','非常非常好吃','Mysql_imgs/猫尾草.jpg',6),(29,'黄花风铃木','12','非常非常好吃','Mysql_imgs/黄花风铃木.jpg',6),(30,'使君子','12','非常非常好吃','Mysql_imgs/使君子.jpg',6),(31,'黄槐','12','非常非常好吃','Mysql_imgs/黄槐.jpg',6),(32,'朱顶红','12','非常非常好吃','Mysql_imgs/朱顶红.jpg',6),(33,'飞燕草','12','非常非常好吃','Mysql_imgs/飞燕草.jpg',6),(34,'金钟花','12','非常非常好吃','Mysql_imgs/金钟花.jpg',6),(35,'荷花','12','非常非常好吃','Mysql_imgs/荷花.jpg',6),(36,'小嘴鱼','12','非常非常好吃','Mysql_imgs/小嘴鱼.jpg',5),(37,'石鲽鱼','12','非常非常好吃','Mysql_imgs/石鲽鱼.jpg',5),(38,'面条鱼','12','非常非常好吃','Mysql_imgs/面条鱼.jpg',5),(39,'扁玉螺','12','非常非常好吃','Mysql_imgs/扁玉螺.jpg',5),(40,'梭子蟹','12','非常非常好吃','Mysql_imgs/梭子蟹.jpg',5),(42,'三文鱼','12','非常非常好吃','Mysql_imgs/三文鱼.jpg',5),(43,'大鲍鱼','12','非常非常好吃','Mysql_imgs/大鲍鱼.jpg',5),(44,'北极贝','12','非常非常好吃','Mysql_imgs/北极贝.jpg',5),(45,'赤贝','12','非常非常好吃','Mysql_imgs/赤贝.jpg',5),(46,'草莓','12','非常非常好吃','Mysql_imgs/草莓.png',3),(47,'葡萄','12','非常非常好吃','Mysql_imgs/葡萄.png',3),(48,'蓝莓','12','非常非常好吃','Mysql_imgs/蓝莓.png',3),(49,'芒果','12','非常非常好吃','Mysql_imgs/芒果.png',3),(50,'橙子','12','非常非常好吃','Mysql_imgs/橙子.png',3),(51,'石榴','12','非常非常好吃','Mysql_imgs/石榴.png',3),(52,'香蕉','12','非常非常好吃','Mysql_imgs/香蕉.png',3),(53,'西瓜','12','非常非常好吃','Mysql_imgs/西瓜.png',3),(54,'榴莲','12','非常非常好吃','Mysql_imgs/榴莲.png',3),(55,'火龙果','12','非常非常好吃','Mysql_imgs/火龙果.png',3);


CREATE TABLE `manage` (
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL
) ;


INSERT INTO `manage` VALUES ('管理员账号','123');


CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50),
  `pwd` varchar(50),
  `imgs` varchar(255) ,
  `phone` varchar(50) ,
  `address` varchar(50),
  PRIMARY KEY (`id`)
) ;


INSERT INTO `user` VALUES (1,'张三','123','Mysql_imgs/1703080438041.gif','123456789','河南省'),(2,'张三666','123','Mysql_imgs/1702994592160.gif','123','123'),(3,'王老六','123','Mysql_imgs/1703080593764.gif','1234567890','浙江省'),(4,'测试','123','imgs/touxiang.jpg','123','哈哈哈');

