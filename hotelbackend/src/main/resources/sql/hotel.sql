-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 05 oct. 2021 à 15:46
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

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
-- Structure de la table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
    `admin_id` int(11) NOT NULL AUTO_INCREMENT,
    `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `role` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`admin_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
    `client_id` int(11) NOT NULL AUTO_INCREMENT,
    `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `nom_complet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `telephone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`client_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
CREATE TABLE IF NOT EXISTS `hotels` (
    `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
    `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `etoiles` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
    `nom` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
    `telephone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
    `ville` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`hotel_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
    `resa_id` int(11) NOT NULL AUTO_INCREMENT,
    `date_debut` datetime NOT NULL,
    `date_fin` datetime NOT NULL,
    `num_chambre` int(11) NOT NULL,
    `client_resa` int(11) NOT NULL,
    `hotel_resa` int(11) NOT NULL,
    PRIMARY KEY (`resa_id`),
    KEY `FKkp7569lw9tbb271ih92itbovx` (`client_resa`),
    KEY `FK5vac7l6jufdbexeq07jyxlhdt` (`hotel_resa`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
    ADD CONSTRAINT `FK5vac7l6jufdbexeq07jyxlhdt` FOREIGN KEY (`hotel_resa`) REFERENCES `hotels` (`hotel_id`),
  ADD CONSTRAINT `FKkp7569lw9tbb271ih92itbovx` FOREIGN KEY (`client_resa`) REFERENCES `clients` (`client_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
