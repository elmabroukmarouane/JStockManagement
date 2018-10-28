-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 28 oct. 2018 à 12:06
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jstock_management`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `category_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` double(8,2) NOT NULL,
  `qte` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articles_category_id_foreign` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`id`, `category_id`, `name`, `price`, `qte`) VALUES
(1, 1, 'aut', 632.00, 804),
(2, 2, 'officia', 807.00, 712),
(3, 3, 'sit', 884.00, 827),
(4, 4, 'temporibus', 141.00, 507),
(5, 5, 'laudantium', 207.00, 997),
(6, 6, 'ducimus', 404.00, 233),
(7, 7, 'quia', 746.00, 859),
(8, 8, 'distinctio', 151.00, 939),
(9, 9, 'qui', 846.00, 570),
(10, 10, 'ut', 387.00, 245);

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'dolor'),
(2, 'culpa'),
(3, 'ut'),
(4, 'ipsa'),
(5, 'ea'),
(6, 'in'),
(7, 'ut'),
(8, 'fuga'),
(9, 'quo'),
(10, 'labore');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
(1, 'Super Administrateur', 'super_admin@mail.com', '123456'),
(2, 'Dr. Brycen Jacobi', 'owen49@hotmail.com', '123456'),
(3, 'Trey Bartoletti MD', 'turner.moore@yahoo.com', '123456'),
(4, 'Vern Okuneva', 'vhauck@wisoky.com', '123456'),
(5, 'Dr. Tavares Stanton', 'dare.cydney@hotmail.com', '123456'),
(6, 'Ms. Maximillia Dooley', 'nolan.bins@mosciski.com', '123456'),
(7, 'Eleazar Jones', 'dooley.carlos@little.com', '123456'),
(8, 'Delta Wuckert', 'josh31@casper.com', '123456'),
(9, 'Herta Erdman', 'darren46@kuhn.com', '123456'),
(10, 'Leland Harber DVM', 'jo63@hotmail.com', '123456'),
(11, 'Genoveva Hane', 'jasper.carroll@hotmail.com', '123456');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `articles_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
