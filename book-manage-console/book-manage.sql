/*
MySQL Backup
Database: bookmanagesys
Backup Time: 2024-04-29 13:57:49
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `bookmanagesys`.`book`;
DROP TABLE IF EXISTS `bookmanagesys`.`borrowrecord`;
DROP TABLE IF EXISTS `bookmanagesys`.`user`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(50) DEFAULT NULL,
  `total` int(10) DEFAULT NULL,
  `putaway` date DEFAULT NULL,
  `surplus` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
CREATE TABLE `borrowrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `borrowdate` date DEFAULT NULL,
  `backdate` date DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10029 DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `bookmanagesys`.`book` WRITE;
DELETE FROM `bookmanagesys`.`book`;
INSERT INTO `bookmanagesys`.`book` (`id`,`bookname`,`total`,`putaway`,`surplus`) VALUES (9, '高等数学2', 11, '2018-08-01', 0),(11, 'java精彩编程200例', 13, '2018-09-08', 0),(12, '高  等教 育', 14, '2018-08-01', 0),(13, 'java从入门到精通', 15, '2017-09-08', 0),(14, 'java从入门到精通', 15, '2017-09-08', 0),(15, '商务英语', 12, '2018-10-08', 0),(16, '计算机入门', 13, '2018-11-08', 0),(17, '大学英语', 8, '2018-10-08', 0),(18, '计算机', 4, '2017-11-08', 0),(19, '入门到精通', 2, '2019-09-17', 0),(20, '高等教育', 2, '2018-08-01', 0),(21, 'MTMLL', 1, '2018-08-01', 11),(22, '小猪佩奇', 8, '2024-04-25', 1),(23, '亚比囧囧囧', 10, '2024-05-06', 10);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `bookmanagesys`.`borrowrecord` WRITE;
DELETE FROM `bookmanagesys`.`borrowrecord`;
INSERT INTO `bookmanagesys`.`borrowrecord` (`id`,`bookid`,`userid`,`borrowdate`,`backdate`,`state`) VALUES (10004, 8, 8, '2019-09-01', '2019-10-01', '已还'),(10006, 9, 9, '2019-09-01', '2019-10-01', '已还'),(10008, 10, 10, '2019-09-01', '2019-10-01', '已还'),(10010, 11, 11, '2019-09-01', '2019-10-01', '已还'),(10014, 12, 12, '2019-09-01', '2019-10-01', '已还'),(10016, 13, 13, '2019-09-01', '2019-10-01', '已还'),(10018, 14, 14, '2019-09-01', '2019-10-01', '已还'),(10020, 15, 15, '2019-09-01', '2019-10-01', '已还'),(10022, 16, 16, '2019-09-01', '2019-10-01', '已还'),(10024, 17, 17, '2019-09-01', '2019-10-01', '已还'),(10026, 18, 18, '2019-09-01', '2019-10-01', '已还'),(10027, 22, 19, '2024-04-25', '2024-05-25', '已还'),(10028, 22, 19, '2024-05-06', '2024-06-05', '已借');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `bookmanagesys`.`user` WRITE;
DELETE FROM `bookmanagesys`.`user`;
INSERT INTO `bookmanagesys`.`user` (`id`,`username`,`password`) VALUES (8, 'xiaoli', '666666'),(9, 'zhangyogn', '666666'),(10, 'zhangming', '666666'),(11, 'hexu', '666666'),(12, 'yang', '666666'),(13, 'wang', '666666'),(14, 'zhang', '666666'),(15, 'zhangzetian', '666666'),(16, 'wangyang', '666666'),(17, '郭州乐沙', '666666'),(18, '北冥有鱼', '123456'),(19, 'song', '123123');
UNLOCK TABLES;
COMMIT;
