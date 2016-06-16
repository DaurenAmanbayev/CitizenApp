-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Июн 16 2016 г., 13:18
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `citizensdb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `citizens`
--

CREATE TABLE `citizens` (
  `id` int(6) NOT NULL,
  `name` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `birthDate` date DEFAULT NULL,
  `homeAddress` varchar(30) NOT NULL,
  `documentNumber` varchar(12) NOT NULL,
  `documentType` varchar(12) NOT NULL,
  `documentCreatedDate` date DEFAULT NULL,
  `documentExpiredDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `citizens`
--

INSERT INTO `citizens` (`id`, `name`, `lastName`, `birthDate`, `homeAddress`, `documentNumber`, `documentType`, `documentCreatedDate`, `documentExpiredDate`) VALUES
(3, 'Frank', 'Igor', '2016-06-14', 'Bukeihana', '4645645646', '6132131', '2016-06-14', '2016-06-13'),
(4, 'Marat', 'Kusainov', '2016-06-14', 'Kabanbay', '4698797', 'passport', '2016-06-14', '2016-06-22'),
(5, 'Glenn', 'Steff', '2016-06-14', 'McDonalds', '564678', 'contract', '2016-06-13', '2016-06-14');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `citizens`
--
ALTER TABLE `citizens`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `citizens`
--
ALTER TABLE `citizens`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
