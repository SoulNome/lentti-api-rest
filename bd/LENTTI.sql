-- phpMyAdmin SQL Dump
-- version 5.2.1deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 20, 2023 at 06:49 AM
-- Server version: 10.6.11-MariaDB-2
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LENTTI`
--

-- --------------------------------------------------------

--
-- Table structure for table `deliveries`
--

CREATE TABLE `deliveries` (
  `delivery_document` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` bigint(10) NOT NULL,
  `address` varchar(40) NOT NULL,
  `vehicle` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deliveries`
--

INSERT INTO `deliveries` (`delivery_document`, `name`, `phone`, `addres`, `vehicle`, `Password`, `email`) VALUES
(12345677, 'Ana García', 5555678, 'Avenida Siempreviva 456', 'Bicicleta', 'contrasena456', 'nombre.apellido@dominio.com'),
(23456788, 'Pedro Sanchez', 5559012, 'Carrera 7 # 23-45', 'carro', 'contrasena789', 'inicialnombre.apellido@dominio.com'),
(34567899, 'Maria Gomez', 5552345, 'Cra 13 # 14-56', 'moto', 'contrasena012', 'nombre.apellido+número@dominio.com'),
(45678900, 'Luisa Martinez', 5556789, 'Calle 45 # 18-23', 'bicicleta', 'contrasena345', 'nombre_completo@dominio.com');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id_order` int(11) NOT NULL,
  `delivery_document` bigint(20) NOT NULL,
  `user_document` bigint(20) NOT NULL,
  `quantity_products` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `pick_up_location` varchar(30) NOT NULL,
  `place_of_delivery` varchar(30) NOT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id_order`, `delivery_document`, `user_document`, `quantity_products`, `total_price`, `pick_up_location`, `place_of_delivery`, `description`) VALUES
(1, 12345677, 12345671, 2, 19.99, '123 Main St', '456 Elm St', 'Delivery instructions go here.'),
(3, 23456788, 23456782, 1, 8.99, '789 Oak Ave', '123 Maple St', 'Delivery instructions go here.'),
(4, 34567899, 34567893, 4, 31.99, '456 Elm St', '789 Oak Ave', 'Delivery instructions go here.'),
(5, 45678900, 45678904, 3, 23.99, '321 Cedar Rd', '654 Pine St', 'Delivery instructions go here.');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id_product` int(11) NOT NULL,
  `price` double NOT NULL,
  `name` varchar(20) NOT NULL,
  `company` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id_product`, `price`, `name`, `company`) VALUES
(1, 10.99, 'Product A', 'Company A'),
(2, 8.99, 'Product B', 'Company B'),
(3, 15.99, 'Product C', 'Company A'),
(4, 12.99, 'Product D', 'Company C'),
(5, 9.99, 'Product E', 'Company B');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_document` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_document`, `name`, `phone`, `password`, `email`) VALUES
(12345671, 'John Doe', 55512334, 'password123', 'sindireccion@gmail.com'),
(23456782, 'Jane Smith', 5555675, 'password456', 'semeolvido@gmail.com'),
(34567893, 'Mike Johnson', 5559016, 'password789', 'notengoniidea@gmail.com'),
(45678904, 'Sarah Williams', 5552347, 'password012', 'sarah@gmail.com'),
(56789015, 'David Brown', 555678978, 'password345', 'nose@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deliveries`
--
ALTER TABLE `deliveries`
  ADD PRIMARY KEY (`delivery_document`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `delivery_document` (`delivery_document`),
  ADD KEY `user_document` (`user_document`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id_product`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_document`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id_product` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`delivery_document`) REFERENCES `deliveries` (`delivery_document`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`user_document`) REFERENCES `users` (`user_document`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
