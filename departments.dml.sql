-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 25, 2014 at 05:02 PM
-- Server version: 5.5.37
-- PHP Version: 5.5.13-2+deb.sury.org~precise+1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java_departments`
--

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`id`, `name`) VALUES
(1, 'Бухгалтерия'),
(2, 'Техники'),
(3, 'Юристы'),
(6, 'Палата №6'),
(10, 'Отдел русского языка и культуры'),
(12, 'Кочегарка'),
(23, 'ИТ отдел'),
(24, 'Библиотека'),
(25, 'Артакцион невиданной щедрости');

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `username`, `birthday`, `passport`, `salary`, `department_id`, `position_id`) VALUES
(1, 'Ivan Petrov', '1982-07-30', 'VH3337777', 7000.00, 3, 1),
(8, 'Алена Михайловна', '1993-10-20', 'VH2222000', 2000.00, 1, 1),
(9, 'Семен Потапыч', '1902-07-20', 'ке456222', 1000.00, 12, 7);

--
-- Dumping data for table `positions`
--

INSERT INTO `positions` (`id`, `name`, `minSalary`, `maxSalary`) VALUES
(1, 'Начальник', 5000.00, 10000.00),
(2, 'ЗамНачальника', 3000.00, 5000.00),
(3, 'Главный специалист', 2000.00, 3500.00),
(4, 'Специалист', 500.00, 3000.00),
(5, 'Стажер', 500.00, 800.00),
(6, 'Вахтер', 400.00, 1000.00),
(7, 'Вахтер-Охранник', 100.00, 500.00),
(8, 'Вахтер-Стажер', 110.00, 450.00),
(9, 'Уборщики', 10.00, 100.00),
(10, 'Секретарь', 100.00, 2000.00);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
