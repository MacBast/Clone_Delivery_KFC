-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2022 a las 01:14:43
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `product`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_product` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `price` varchar(20) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `price` varchar(20) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id_product`, `name`, `descripcion`, `price`, `image`) VALUES
(1, 'Buckets', '8 Presas de Pollo + 4 Strips + 6 Alitas(Las alitas picantes hot wings equivalen a un trozo de ala)', '83000', 'https://images.getduna.com/5fe6067e-0e11-4869-9118-ad3dcc8765c2/5c02238a0e0f562a_domicilio_5350_744x744_1648747487.png?d=600x600'),
(2, 'BIG BOX POP', '1 Pop Corn Pequeño (Trocitos de pechuga de pollo apanados) + 5 Alitas Picantes (Las alitas picantes ', '23900', 'https://images.getduna.com/5fe6067e-0e11-4869-9118-ad3dcc8765c2/5c02238a0e0f562a_domicilio_957_744x744_1649784647.png?d=600x600'),
(3, 'COMBO SAND KENTUCKY CORONEL', '1 Kentucky Coronel Sandwich (1 Filete de pechuga de pollo apanado, Ensalada Coleslaw, BBQ y mantequi', '19900', 'https://images.getduna.com/5fe6067e-0e11-4869-9118-ad3dcc8765c2/5c02238a0e0f562a_domicilio_5281_744x744_1647539619.png?d=600x600'),
(4, 'COMBO TWISTER CLASICO', '1 Twister Clásico + 1 papa pequeña+ 1 Gaseosa PET 400ml', '15900', 'https://images.getduna.com/5fe6067e-0e11-4869-9118-ad3dcc8765c2/5c02238a0e0f562a_domicilio_123_744x744.png?d=600x600'),
(5, 'Avalancha Oreo', 'Helado de Vainilla + Salsa de Arequipe + Topping de Oreo', '6900', 'https://images.getduna.com/5fe6067e-0e11-4869-9118-ad3dcc8765c2/5c02238a0e0f562a_domicilio_3687_744x744_1649787225.png?d=600x600'),
(6, 'MEGA VARIEDAD XL GASEOSA', '6 Presas de Pollo + 8 Alitas (Las alitas picantes hot wings equivalen a un trozo de ala) + 2 Pop Med', '74900', 'https://images.getduna.com/5fe6067e-0e11-4869-9118-ad3dcc8765c2/5c02238a0e0f562a_domicilio_5303_744x744_1647444371.png?d=600x600');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `identification` varchar(12) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`identification`, `fullname`, `telephone`, `email`) VALUES
('123456789', 'Fernanda Molina', '3006313781', 'mamolina812@gmail.com'),
('987654321', 'pedro perez', '3124587951', 'pedroperez@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `contraseña`) VALUES
(1, '', 'alejo', 'alejo'),
(2, '', 'alejoo', '123456'),
(3, '', 'alejoo', 'kaka'),
(4, '', 'alejoo', 'kaka'),
(5, '', 'alejoo', 'kaka'),
(6, '', 'hlroeoeo', 'afdfsad'),
(7, '', 'holaandre', 'alejoo'),
(8, '', 'holaandre', 'alejoo'),
(9, '', 'holla', 'jjfjfjf'),
(10, '', 'fasefawa', 'edfaewfes'),
(11, '', 'fasefawa', 'edfaewfes'),
(12, '', 'fasefawa', 'edfaewfes'),
(13, '', 'fasefawa', 'edfaewfes'),
(14, '', 'alejooo', 'mamaguevi'),
(15, '', 'alejooo', 'mamaguevi'),
(16, '', 'alejooo', 'mamaguevi'),
(17, '', 'aeljoooo', 'ajejej'),
(18, '', 'alonsozea@hotmail.com', '123456'),
(19, '', 'mateoo', 'mateoo'),
(20, '', 'daniel', 'daniel');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`name`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`identification`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
