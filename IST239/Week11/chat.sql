-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 14, 2010 at 04:33 AM
-- Server version: 5.1.41
-- PHP Version: 5.3.2-1ubuntu4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ist239`
--

-- --------------------------------------------------------

--
-- Table structure for table `buddies`
--

CREATE TABLE IF NOT EXISTS `buddies` (
  `user_id` int(10) unsigned NOT NULL,
  `buddy_id` int(10) unsigned NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `buddy_id` (`buddy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Table links users to their buddies.';

--
-- Dumping data for table `buddies`
--

INSERT INTO `buddies` (`user_id`, `buddy_id`) VALUES
(3, 2),
(3, 3),
(2, 3),
(2, 2),
(2, 13),
(2, 15),
(15, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`) VALUES
(2, 'dk', '5f4dcc3b5aa765d61d8327deb882cf99', 'magneus@gmail.com'),
(3, 'kyle', '5f4dcc3b5aa765d61d8327deb882cf99', 'koreanstylekyle@hotmail.com'),
(13, 'bob', '98f6bcd4621d373cade4e832627b4f6', 'bob@yahoo.com'),
(15, 'newbie', '81dc9bdb52d04dc20036dbd8313ed055', 'newbie@yahoo.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buddies`
--
ALTER TABLE `buddies`
  ADD CONSTRAINT `buddies_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `buddies_ibfk_2` FOREIGN KEY (`buddy_id`) REFERENCES `user` (`id`);
