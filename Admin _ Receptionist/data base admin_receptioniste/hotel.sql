-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 08 jan. 2023 à 20:21
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `clientcredentials`
--

CREATE TABLE `clientcredentials` (
  `userName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `clientcredentials`
--

INSERT INTO `clientcredentials` (`userName`, `email`, `password`) VALUES
('jamila', 'jamila@gmail.com', '1'),
('maryam', 'm@gmail.com', '123');

-- --------------------------------------------------------

--
-- Structure de la table `costumer`
--

CREATE TABLE `costumer` (
  `CIN` varchar(10) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `LastName` varchar(20) DEFAULT NULL,
  `Tel` varchar(200) DEFAULT NULL,
  `Nationality` varchar(20) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `checkIn` date DEFAULT NULL,
  `checkOut` date DEFAULT NULL,
  `Bed` varchar(20) DEFAULT NULL,
  `roomNo` varchar(20) DEFAULT NULL,
  `roomType` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `Total` double DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `Adult` int(11) NOT NULL,
  `minor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `costumer`
--

INSERT INTO `costumer` (`CIN`, `Name`, `LastName`, `Tel`, `Nationality`, `gender`, `email`, `checkIn`, `checkOut`, `Bed`, `roomNo`, `roomType`, `price`, `Total`, `status`, `Adult`, `minor`) VALUES
('B778899', 'Josef', 'Hill', '0344556677', 'Frech', 'Male ', 'JOSEF@gmail.com', '2023-10-12', '2023-10-14', 'Double', '15', 'AC ', 1400, 2800, 'Booked', 2, 0),
('G999997', 'Jamal', 'Hill', '0788996655', 'Moroccan', 'Male ', 'jamal@gmail.com', '2023-02-20', '2023-03-02', 'Double', '10', 'AC ', 900, 7200, 'Booked', 2, 0),
('HA334401', 'halima', 'Milhi', '0645342311', 'Moroccan', 'Female', 'halima@gmail.com', '2023-07-20', '2023-07-21', 'Single ', '20', 'Non-AC', 900, 900, 'Booked', 1, 1),
('J5555', 'mina', 'line', '0344556677', 'Spanish', 'Female', 'mina@gmail.com', '2023-02-12', '2023-02-18', 'Double', '2', 'AC ', 2000, 12000, 'Booked', 2, 0),
('J666677', 'Haitam', 'kim', '0655456677', 'Moroccan', 'Male ', 'Haitam@gmail.com', '2023-12-12', '2023-12-20', 'Double', '18', 'AC ', 3000, 24000, 'Booked', 2, 0),
('JE111123', 'Jamila', 'Lakhalifi', '0616606669', 'MOROCCAN', 'Female', 'lik@GMAIL.COM', '2023-01-12', '2023-01-25', 'Single ', '1', 'AC ', 278, 3614, 'Booked', 1, 0),
('JE213243', 'Jamila', 'Lakhalifi', '0639382203', 'Moroccan', 'Female', 'jamila@gmail.com', '2023-01-12', '2023-01-20', 'Single ', '6', 'AC ', 500, 4000, 'Booked', 1, 0),
('JE333244', 'Fatima', 'Idbi', '0666662345', 'Moroccan', 'Female', 'la@gmail.com', '2023-12-25', '2023-12-30', 'Double', '3', 'Non-AC', 1000, 5000, 'Booked', 2, 0),
('JE333322', 'Maryam', 'Monir', '0739372204', 'MOROCCAN', 'Female', 'maryam@GMAIL.COM', '2023-01-12', '2023-01-25', 'Single ', '16', 'AC ', 500, 6500, 'Booked', 1, 0),
('JE446655', 'Yassine', 'Malwi', '0733234540', 'Moroccan', 'Male ', 'yassine@gmail.com', '2022-02-10', '2022-02-13', 'Double', '19', 'AC ', 5000, 15000, 'Booked', 2, 0),
('M998878', 'Mohamed', 'Ali', '0678567899', 'Moroccan', 'Male ', 'mohamed@gmail.com', '2023-02-12', '2023-02-14', 'Double', '13', 'Non-AC', 1000, 2000, 'Booked', 2, 0),
('ME212334', 'imane', 'hamid', '0933282203', 'Spanish', 'Female', 'imane@gmail.com', '2023-12-01', '2023-12-02', 'Single ', '1', 'AC ', 278, 278, 'Booked', 1, 0),
('Q334432', 'Khalid', 'Gig', '0344556677', 'French', 'Male ', 'khalid@gmail.com', '2023-05-03', '2023-05-12', 'Single', '20', 'Non-AC ', 900, 8100, 'Booked', 2, 0),
('RE332210', 'khalid', 'Milo', '0755664433', 'Moroccan', 'Male ', 'k@gmail.com', '2023-10-20', '2023-10-22', 'Single ', '21', 'Non-AC', 200, 400, 'Booked', 1, 0),
('RM123212', 'Kamal', 'hali', '0633283602', 'German', 'Male ', 'kamal@gmail.com', '2023-01-01', '2023-01-20', 'Double', '14', 'AC ', 1200, 22800, 'Booked', 2, 1),
('RM442132', 'Ahmed', 'Lakhalifi', '0758330203', 'Moroccan', 'Male ', 'ahmed@gmail.com', '2023-01-01', '2023-01-10', 'Double', '4', 'AC ', 1200, 10800, 'Booked', 2, 1),
('YE334455', 'Manal', 'Hani', '0633445544', 'Moroccan', 'Female', 'Manal@gmail.com', '2023-04-20', '2023-04-25', 'Single ', '21', 'Non-AC', 200, 1000, 'Booked', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `months`
--

CREATE TABLE `months` (
  `1` int(11) NOT NULL,
  `2` int(11) NOT NULL,
  `3` int(11) NOT NULL,
  `4` int(11) NOT NULL,
  `5` int(11) NOT NULL,
  `6` int(11) NOT NULL,
  `7` int(11) NOT NULL,
  `8` int(11) NOT NULL,
  `9` int(11) NOT NULL,
  `10` int(11) NOT NULL,
  `11` int(11) NOT NULL,
  `12` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `receptionists`
--

CREATE TABLE `receptionists` (
  `name` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `securityQuestion` varchar(200) DEFAULT NULL,
  `answer` varchar(200) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `receptionists`
--

INSERT INTO `receptionists` (`name`, `email`, `password`, `securityQuestion`, `answer`, `status`) VALUES
('Amine Nijo', 'amine@gmail.com', '123', 'Your hobby ?', 'Football', 'true'),
('Haitam Mohamed', 'haitam@gmail.com', '123', 'Your best friend ?', 'Amine', 'true'),
('Karime Walid', 'karime@gmail.com', '123', 'Your hero ?', 'Rassoulo llah', 'true'),
('Amine Tano', 'tano@gmail.com', '123', 'Your best friend ?', 'karime', 'true');

-- --------------------------------------------------------

--
-- Structure de la table `room`
--

CREATE TABLE `room` (
  `roomNo` varchar(10) DEFAULT NULL,
  `roomType` varchar(200) DEFAULT NULL,
  `bed` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `Adult` int(11) NOT NULL,
  `minor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `room`
--

INSERT INTO `room` (`roomNo`, `roomType`, `bed`, `price`, `status`, `Adult`, `minor`) VALUES
('1', 'AC', 'Single', 278, 'Booked', 1, 0),
('2', 'AC', 'Double', 2000, 'Not_Booked', 2, 0),
('3', 'NON-AC', 'Double', 1000, 'Booked', 2, 0),
('4', 'AC', 'Double', 1200, 'Not_Booked', 2, 1),
('5', 'AC', 'Double', 1400, 'Not_Booked', 2, 0),
('6', 'AC', 'Single', 500, 'Booked', 1, 0),
('7', 'Non_AC', 'Single', 999, 'Not_Booked', 1, 0),
('8', 'AC', 'Double', 3000, 'Not_Booked', 2, 0),
('9', 'AC', 'Double', 5000, 'Not_Booked', 2, 0),
('10', 'AC', 'Double', 900, 'Not_Booked', 2, 0),
('11', 'AC', 'Single', 278, 'Not_Booked', 1, 0),
('12', 'AC', 'Double', 2000, 'Not_Booked', 2, 0),
('13', 'NON-AC', 'Double', 1000, 'Not_Booked', 2, 0),
('14', 'AC', 'Double', 1200, 'Not_Booked', 2, 1),
('15', 'AC', 'Double', 1400, 'Not_Booked', 2, 0),
('16', 'AC', 'Single', 500, 'Booked', 1, 0),
('17', 'Non_AC', 'Single', 999, 'Not_Booked', 1, 0),
('18', 'AC', 'Double', 3000, 'Not_Booked', 2, 0),
('19', 'AC', 'Double', 5000, 'Not_Booked', 2, 0),
('123', 'AC ', 'Double', 2000, 'Not_Booked', 2, 0),
('21', 'Non-AC', 'Single', 200, 'Not_Booked', 1, 0),
('20', 'NON-AC', 'Single', 2000, 'Not_Booked', 1, 1),
('22', 'Non-AC', 'Single', 500, 'Not_Booked', 1, 0),
('23', 'Non-AC', 'Double', 1000, 'Not_Booked', 2, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `costumer`
--
ALTER TABLE `costumer`
  ADD PRIMARY KEY (`CIN`);

--
-- Index pour la table `receptionists`
--
ALTER TABLE `receptionists`
  ADD UNIQUE KEY `email` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
