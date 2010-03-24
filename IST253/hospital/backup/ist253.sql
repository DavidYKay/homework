-- phpMyAdmin SQL Dump
-- version 2.11.9.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 04, 2010 at 11:30 PM
-- Server version: 5.0.84
-- PHP Version: 5.2.12-pl0-gentoo

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
  `bedID` int(4) NOT NULL,
  `patientSSN` int(9) unsigned NOT NULL,
  `vacant` tinyint(1) NOT NULL,
  `roomNum` int(4) NOT NULL,
  PRIMARY KEY  (`bedID`),
  UNIQUE KEY `patientSSN` (`patientSSN`),
  KEY `roomNum` (`roomNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `beds`
--


-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
  `billID` int(4) NOT NULL,
  `patientSSN` int(9) unsigned NOT NULL,
  `insuranceID` int(4) NOT NULL,
  PRIMARY KEY  (`billID`),
  KEY `patientSSN` (`patientSSN`,`insuranceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill`
--


-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE IF NOT EXISTS `doctors` (
  `doctorID` int(4) unsigned NOT NULL,
  `firstName` char(30) NOT NULL,
  `lastName` char(20) NOT NULL,
  `patientSSN` int(9) unsigned NOT NULL,
  `DO/MD` int(4) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `doctors`
--


-- --------------------------------------------------------

--
-- Table structure for table `insurance`
--

CREATE TABLE IF NOT EXISTS `insurance` (
  `insuranceID` int(4) unsigned NOT NULL,
  `companyNAME` varchar(20) NOT NULL,
  `patientSSN` int(9) unsigned NOT NULL,
  `covered` tinyint(1) NOT NULL,
  `price` float unsigned NOT NULL,
  PRIMARY KEY  (`insuranceID`),
  KEY `patientSSN` (`patientSSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `insurance`
--


-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE IF NOT EXISTS `patients` (
  `patientSSN` int(9) unsigned NOT NULL COMMENT '27 if binary',
  `firstName` char(30) NOT NULL,
  `lastName` char(20) NOT NULL,
  `address` char(40) NOT NULL,
  `phoneNumber` char(12) NOT NULL,
  `state` char(2) NOT NULL,
  `zipcode` char(10) NOT NULL,
  `countryID` int(4) NOT NULL,
  `doctorID` int(4) NOT NULL,
  `billID` int(4) NOT NULL,
  `bedID` int(4) NOT NULL,
  `sickness` int(4) NOT NULL,
  PRIMARY KEY  (`patientSSN`),
  KEY `countryID` (`countryID`,`doctorID`,`billID`,`bedID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `patients`
--


-- --------------------------------------------------------

--
-- Table structure for table `procedure`
--

CREATE TABLE IF NOT EXISTS `procedure` (
  `procedureID` int(4) unsigned NOT NULL,
  `doctorID` int(4) unsigned NOT NULL,
  `price` int(4) unsigned NOT NULL,
  `date` int(4) unsigned NOT NULL,
  `patientSSN` int(9) unsigned NOT NULL,
  `completed` tinyint(1) NOT NULL,
  `procedureNAME` char(15) NOT NULL,
  PRIMARY KEY  (`procedureID`),
  KEY `doctorID` (`doctorID`,`patientSSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `procedure`
--


-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `testID` int(4) NOT NULL,
  `patientSSN` int(9) unsigned NOT NULL,
  PRIMARY KEY  (`testID`),
  KEY `patientSSN` (`patientSSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `test`
--


--
-- Constraints for dumped tables
--

--
-- Constraints for table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_1` FOREIGN KEY (`patientSSN`) REFERENCES `patients` (`patientSSN`);
