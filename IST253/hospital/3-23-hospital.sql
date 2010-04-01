-- phpMyAdmin SQL Dump
-- version 2.11.9.6
-- http://www.phpmyadmin.net

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ist253`
--

-- --------------------------------------------------------

--
-- Table structure for table `beds`
--

CREATE TABLE IF NOT EXISTS `beds` (
    `bedID`      int     (4)          NOT NULL AUTO_INCREMENT,
    `patientSSN` int     (9) unsigned DEFAULT NULL, --NULL so we can have empty beds
    `vacant`     tinyint (1)          NOT NULL, --Remove this
    `roomNum`    int     (4)          NOT NULL,
    KEY `roomNum` (`roomNum`),
    PRIMARY KEY  (`bedID`),
    FOREIGN KEY (`patientSSN`) REFERENCES patients (`patientSSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE IF NOT EXISTS `bills` (
    `billID`      int (4)          NOT NULL,
    `patientSSN`  int (9) unsigned NOT NULL,
    `insuranceID` int (4) unsigned NOT NULL,
    PRIMARY KEY  (`billID`),
    FOREIGN KEY (`patientSSN`) REFERENCES patients (`patientSSN`),
    FOREIGN KEY (`insuranceID`) REFERENCES insurance (`insuranceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE IF NOT EXISTS `doctors` (
    `doctorID`   int  (4 )   unsigned NOT NULL AUTO_INCREMENT,
    `firstName`  char (30)            NOT NULL,
    `lastName`   char (20)            NOT NULL,
    `DO/MD`      int  (4 )   unsigned NOT NULL,
    PRIMARY KEY  (`doctorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `insurance`
--

CREATE TABLE IF NOT EXISTS `insurance` (
    `insuranceID` int(4) unsigned NOT NULL,
    `companyName` varchar(20)     NOT NULL,
    PRIMARY KEY  (`insuranceID`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE IF NOT EXISTS `patients` (
    `patientSSN`  int(9) unsigned NOT NULL COMMENT '27 if binary',
    `firstName`   char(30)        NOT NULL,
    `lastName`    char(20)        NOT NULL,
    `address`     char(40)        NOT NULL,
    `phoneNumber` char(12)        NOT NULL,
    `state`       char(2)         NOT NULL,
    `zipcode`     char(10)        NOT NULL,
    `countryID`   int(4)          NOT NULL,
    `doctorID`    int(4)          NOT NULL,
    `bedID`       int(4)          NOT NULL,
    `sickness`    int(4)          NOT NULL,
    PRIMARY KEY  (`patientSSN`),
    KEY `countryID` (`countryID`),
    FOREIGN KEY (`doctorID`) REFERENCES doctors (`doctorID`),
    FOREIGN KEY (`bedID`)    REFERENCES beds    (`bedID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- --------------------------------------------------------

--
-- Table structure for table `procedure`
--

CREATE TABLE IF NOT EXISTS `procedure` (
    `procedureID`    int(4) unsigned NOT NULL,
    `doctorID`       int(4) unsigned NOT NULL,
    `price`          int(4) unsigned NOT NULL,
    `date`           int(4) unsigned NOT NULL,
    `patientSSN`     int(9) unsigned NOT NULL,
    `completed`      tinyint(1)      NOT NULL,
    `procedureName`  char(15)        NOT NULL,
    PRIMARY KEY  (`procedureID`),
    FOREIGN KEY (`doctorID`) REFERENCES doctors (`doctorID`),
    FOREIGN KEY (`patientSSN`) REFERENCES patients (`patientSSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

