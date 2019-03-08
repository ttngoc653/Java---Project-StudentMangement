-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 08, 2019 at 11:46 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbstudentmgt`
--

-- --------------------------------------------------------

--
-- Table structure for table `dbclass`
--

DROP TABLE IF EXISTS `dbclass`;
CREATE TABLE IF NOT EXISTS `dbclass` (
  `schoolyear` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dblimit`
--

DROP TABLE IF EXISTS `dblimit`;
CREATE TABLE IF NOT EXISTS `dblimit` (
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `valueold` decimal(3,2) DEFAULT NULL,
  `daychangenew` date NOT NULL,
  `valuenew` decimal(3,2) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dbpersonal`
--

DROP TABLE IF EXISTS `dbpersonal`;
CREATE TABLE IF NOT EXISTS `dbpersonal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `dayofbirth` date NOT NULL,
  `address` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dbsubjects`
--

DROP TABLE IF EXISTS `dbsubjects`;
CREATE TABLE IF NOT EXISTS `dbsubjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subjects` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subjects` (`subjects`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dbtranscript`
--

DROP TABLE IF EXISTS `dbtranscript`;
CREATE TABLE IF NOT EXISTS `dbtranscript` (
  `student` int(11) NOT NULL,
  `class` int(11) NOT NULL,
  `semester` int(1) NOT NULL,
  `subjects` int(11) NOT NULL,
  `15minutes` decimal(2,2) DEFAULT NULL,
  `1period` decimal(2,2) DEFAULT NULL,
  `final` decimal(2,2) DEFAULT NULL,
  PRIMARY KEY (`student`,`class`,`semester`,`subjects`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
