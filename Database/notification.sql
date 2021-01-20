-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 20, 2021 at 03:31 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eadcw`
--

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
CREATE TABLE IF NOT EXISTS `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `time` int NOT NULL,
  `details` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10009 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`id`, `email`, `date`, `time`, `details`) VALUES
(1, 'test@email.com', '2021-01-04', 230, 'test notification here'),
(2, 'test2@email.com', '2021-02-04', 1230, 'test 2 notification here'),
(10000, 'test3@email.com', '2021-02-04', 1230, 'test 2 notification here'),
(10001, 'test4@email.com', '2021-02-04', 1230, 'test 2 notification here'),
(10002, 'test4@email.com', '2021-02-04', 1230, 'test 2 notification here'),
(10003, 'test4@email.com', '2021-02-04', 1230, 'test 2 notification here'),
(10004, 'test2@email.com', '2021-01-04', 230, 'test  2 notification here'),
(10005, 'test@email.com', '2021-01-04', 230, 'test  2 notification here'),
(10006, 'test@email.com', '2021-01-04', 230, 'test 3 notification here'),
(10007, 'test@email.com', '2021-01-03', 830, 'test 5  notification here'),
(10008, 'test@email.com', '2021-01-03', 830, 'test 5  notification here');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
