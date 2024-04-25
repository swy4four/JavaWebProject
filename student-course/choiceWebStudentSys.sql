/*
MySQL Backup
Database: choiceweb
Backup Time: 2024-04-25 15:54:47
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `choiceweb`.`admin`;
DROP TABLE IF EXISTS `choiceweb`.`choice`;
DROP TABLE IF EXISTS `choiceweb`.`course`;
DROP TABLE IF EXISTS `choiceweb`.`student`;
DROP TABLE IF EXISTS `choiceweb`.`teach`;
DROP TABLE IF EXISTS `choiceweb`.`teacher`;
CREATE TABLE `admin` (
  `adminID` varchar(255) NOT NULL,
  `adminPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `choice` (
  `studentID` varchar(255) NOT NULL,
  `courseID` varchar(255) NOT NULL,
  `choiceScore` float DEFAULT NULL,
  PRIMARY KEY (`studentID`,`courseID`),
  KEY `courseID` (`courseID`),
  CONSTRAINT `choice_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`),
  CONSTRAINT `choice_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `course` (
  `courseID` varchar(255) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `courseCredit` float DEFAULT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `student` (
  `studentID` varchar(255) NOT NULL,
  `studentName` varchar(255) DEFAULT NULL,
  `studentPassword` varchar(255) DEFAULT NULL,
  `studentSex` varchar(10) DEFAULT NULL,
  `studentBirthday` date DEFAULT NULL,
  `studentSubject` varchar(100) DEFAULT NULL,
  `studentTel` varchar(20) DEFAULT NULL,
  `studentEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `teach` (
  `teacherID` varchar(255) NOT NULL,
  `courseID` varchar(255) NOT NULL,
  `teachDate` date DEFAULT NULL,
  PRIMARY KEY (`teacherID`,`courseID`),
  KEY `courseID` (`courseID`),
  CONSTRAINT `teach_ibfk_1` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`),
  CONSTRAINT `teach_ibfk_2` FOREIGN KEY (`courseID`) REFERENCES `course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `teacher` (
  `teacherID` varchar(255) NOT NULL,
  `teacherName` varchar(255) DEFAULT NULL,
  `teacherPassword` varchar(255) DEFAULT NULL,
  `teacherSex` varchar(10) DEFAULT NULL,
  `teacherBirthday` date DEFAULT NULL,
  `teacherTitle` varchar(100) DEFAULT NULL,
  `teacherTel` varchar(20) DEFAULT NULL,
  `teacherEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
BEGIN;
LOCK TABLES `choiceweb`.`admin` WRITE;
DELETE FROM `choiceweb`.`admin`;
INSERT INTO `choiceweb`.`admin` (`adminID`,`adminPassword`) VALUES ('song', '123456');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `choiceweb`.`choice` WRITE;
DELETE FROM `choiceweb`.`choice`;
INSERT INTO `choiceweb`.`choice` (`studentID`,`courseID`,`choiceScore`) VALUES ('S001', 'C001', 88.5),('S002', 'C002', 92),('S003', 'C003', 91),('S004', 'C004', 89.5),('S005', 'C005', 93.2);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `choiceweb`.`course` WRITE;
DELETE FROM `choiceweb`.`course`;
INSERT INTO `choiceweb`.`course` (`courseID`,`courseName`,`courseCredit`) VALUES ('C001', '计算机科学导论', 3),('C002', '生物学基础', 4),('C003', 'JAVA程序设计', 4),('C004', '有机化学', 4.5),('C005', 'Python课程设计', 4);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `choiceweb`.`student` WRITE;
DELETE FROM `choiceweb`.`student`;
INSERT INTO `choiceweb`.`student` (`studentID`,`studentName`,`studentPassword`,`studentSex`,`studentBirthday`,`studentSubject`,`studentTel`,`studentEmail`) VALUES ('S001', '王五', 'mypass123', '男', '2000-08-12', '计算机科学', '9876543210', 'wangwu@example.com'),('S002', '赵六', 'emilypass', '女', '2002-11-22', '生物学', '9876543211', 'zhaoliu@example.com'),('S003', '陈九', 'chenpass', '男', '1999-07-19', '物理学', '9876543212', 'chenjiu@example.com'),('S004', '周十', 'zhoushypass', '女', '2001-05-22', '化学', '9876543213', 'zhoushi@example.com'),('S005', '韩小龙', 'hanpass555', '男', '2003-01-15', '数学', '9876543214', 'hanxiaolong@example.com');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `choiceweb`.`teach` WRITE;
DELETE FROM `choiceweb`.`teach`;
INSERT INTO `choiceweb`.`teach` (`teacherID`,`courseID`,`teachDate`) VALUES ('T001', 'C001', '2024-09-01'),('T002', 'C002', '2024-09-01'),('T003', 'C003', '2024-09-01'),('T004', 'C004', '2024-09-01'),('T005', 'C005', '2024-09-01');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `choiceweb`.`teacher` WRITE;
DELETE FROM `choiceweb`.`teacher`;
INSERT INTO `choiceweb`.`teacher` (`teacherID`,`teacherName`,`teacherPassword`,`teacherSex`,`teacherBirthday`,`teacherTitle`,`teacherTel`,`teacherEmail`) VALUES ('T001', '张三', 'password123', '男', '1980-06-15', '教授', '1234567890', 'zhangsan@example.com'),('T002', '李四', 'password234', '女', '1975-09-23', '助理教授', '1234567891', 'lisi@example.com'),('T003', '孙七', 'pass789', '男', '1970-04-05', '副教授', '1234567892', 'sunqi@example.com'),('T004', '周八', 'pass890', '女', '1982-12-11', '讲师', '1234567893', 'zhouba@example.com'),('T005', '何十一', 'hepass111', '女', '1985-03-30', '讲师', '1234567894', 'heshiyi@example.com');
UNLOCK TABLES;
COMMIT;
