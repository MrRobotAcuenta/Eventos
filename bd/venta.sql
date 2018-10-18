-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2018 a las 18:32:42
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `venta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cupo`
--

CREATE TABLE `cupo` (
  `nameEvento` varchar(25) NOT NULL,
  `asiento` varchar(15) NOT NULL,
  `disponible` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cupo`
--

INSERT INTO `cupo` (`nameEvento`, `asiento`, `disponible`) VALUES
('Festigame', 'ASD 11', 0),
('Festigame', 'ASD 12', 0),
('Festigame', 'ASD 13', 1),
('Octoberfest', 'BLAT 04', 0),
('Octoberfest', 'BLAT 05', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `nameEvento` varchar(25) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `restriccion` tinyint(1) NOT NULL,
  `lugar` varchar(20) NOT NULL,
  `fecha` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`nameEvento`, `tipo`, `restriccion`, `lugar`, `fecha`) VALUES
('Festigame', 'lel', 0, 'Santiago', '12/11/2018'),
('Octoberfest', 'lel', 0, 'Santiago', '15/11/2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `rut` varchar(10) NOT NULL,
  `fechaNacimiento` varchar(15) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`rut`, `fechaNacimiento`, `nombre`) VALUES
('17674932-5', '11/09/1995', 'elgu sanito'),
('18476587-3', '14/05/1995', 'juan lopez'),
('18534235-7', '13/01/1997', 'Bladimir Montes'),
('19836423-2', '14/05/1997', 'gerardo reyero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tickets`
--

CREATE TABLE `tickets` (
  `asiento` varchar(15) NOT NULL,
  `precio` int(8) NOT NULL,
  `fechaEvento` varchar(15) NOT NULL,
  `idTicket` int(8) NOT NULL,
  `nameEvento` varchar(25) NOT NULL,
  `rut` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tickets`
--

INSERT INTO `tickets` (`asiento`, `precio`, `fechaEvento`, `idTicket`, `nameEvento`, `rut`) VALUES
('ASD 12', 50000, '12/11/2018', 1, 'Festigame', '19836423-2'),
('ASD 11', 50000, '12/11/2018', 2, 'Festigame', '18476587-3'),
('BLAT 05', 70000, '15/11/2018', 4, 'Octoberfest', '18534235-7'),
('BLAT 04', 60000, '15/11/2018', 6, 'Octoberfest', '17674932-5');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cupo`
--
ALTER TABLE `cupo`
  ADD PRIMARY KEY (`asiento`),
  ADD KEY `idEvento` (`nameEvento`),
  ADD KEY `nameEvento` (`nameEvento`);

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`nameEvento`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `nameEvento` (`nameEvento`),
  ADD KEY `rut` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
