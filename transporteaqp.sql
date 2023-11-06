-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2023 a las 12:51:12
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `transporteaqp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialviajes`
--

CREATE TABLE `historialviajes` (
  `ID_Viaje` int(11) NOT NULL,
  `ID_Pasajero` int(11) DEFAULT NULL,
  `ID_Conductor` int(11) DEFAULT NULL,
  `ID_Ruta` int(11) DEFAULT NULL,
  `FechaHora` datetime DEFAULT NULL,
  `EstadoViaje` varchar(20) DEFAULT NULL,
  `Tarifas` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `ID_Pago` int(11) NOT NULL,
  `ID_Usuario` int(11) DEFAULT NULL,
  `Monto` float DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `MetodoPago` varchar(50) DEFAULT NULL,
  `EstadoPago` varchar(20) DEFAULT NULL,
  `DetallesFacturacion` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `ID_Rol` int(11) NOT NULL,
  `NombreRol` varchar(20) DEFAULT NULL,
  `EstadoRol` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`ID_Rol`, `NombreRol`, `EstadoRol`) VALUES
(1, 'Administrador', 1),
(2, 'Conductor', 1),
(3, 'Pasajero', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `ID_Ruta` int(11) NOT NULL,
  `Origen` varchar(50) DEFAULT NULL,
  `Destino` varchar(50) DEFAULT NULL,
  `Distancia` float DEFAULT NULL,
  `TiempoEstimadoViaje` int(11) DEFAULT NULL,
  `EstadoRutas` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifas`
--

CREATE TABLE `tarifas` (
  `ID_Tarifa` int(11) NOT NULL,
  `TipoTarifa` varchar(50) DEFAULT NULL,
  `Valor` float DEFAULT NULL,
  `ID_Ruta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_Usuario` int(11) NOT NULL,
  `NombreUsuario` varchar(50) DEFAULT NULL,
  `ApellidoPaterno` varchar(50) DEFAULT NULL,
  `ApellidoMaterno` varchar(50) DEFAULT NULL,
  `DNI` varchar(15) DEFAULT NULL,
  `CorreoElectronico` varchar(50) DEFAULT NULL,
  `NumeroTelefono` varchar(20) DEFAULT NULL,
  `ClaveUsuario` varchar(50) DEFAULT NULL,
  `EstadoUsuario` tinyint(1) DEFAULT NULL,
  `ID_Rol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_Usuario`, `NombreUsuario`, `ApellidoPaterno`, `ApellidoMaterno`, `DNI`, `CorreoElectronico`, `NumeroTelefono`, `ClaveUsuario`, `EstadoUsuario`, `ID_Rol`) VALUES
(1, 'Dannia', 'Mendoza', 'Hancco', '70890925', 'dannia@gmail.com', '987654321', 'dannia', 1, 1),
(2, 'Fernando', 'Farfan', 'Perez', '70707070', 'fernando.farfan@gmail.com', '987654321', 'fernando', 1, 2),
(3, 'Rocio', 'Perez', 'Ramos', '11223344', 'rocio@gmail.com', '987678567', 'rocio', 1, 3),
(4, 'Simon', 'Belarde', 'Huallaga', '23344556', 'simon@gmail.com', '977654567', 'simon', 1, 2),
(5, 'Mariana', 'Lopez', 'Lopez', '56764566', 'mariana@gmail.com', '987132453', 'mariana', 1, 3),
(6, 'David', 'Perez', 'Perez', '23458799', 'david', '983094555', 'david', 1, 1),
(7, 'Lucia', 'Belarde', 'Segundo', '56773388', 'lucia@gmail.com', '909898090', 'lucia', 1, 2),
(8, 'Luis', 'Peralta', 'NuÃ±ez', '56766666', 'luis@gmail.com', '983760000', 'luis', 1, 2),
(9, 'Jimena', 'Mendoza', 'Olarte', '78787878', 'jimena@gmail.com', '900666555', 'jimena', 1, 3),
(10, 'Joaquin', 'Espinoza ', 'Galarza', '34343434', 'joaquin@gmail.com', '988345678', 'joaquin', 1, 3),
(11, 'Milton', 'Medina', 'NuÃ±ez', '45454545', 'milton@gmail.com', '987111444', 'milton', 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `ID_Vehiculo` int(11) NOT NULL,
  `ID_Conductor` int(11) DEFAULT NULL,
  `Marca` varchar(50) DEFAULT NULL,
  `Modelo` varchar(50) DEFAULT NULL,
  `Anio` int(11) DEFAULT NULL,
  `NumeroPlaca` varchar(20) DEFAULT NULL,
  `EstadoMantenimiento` varchar(20) DEFAULT NULL,
  `Estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`ID_Vehiculo`, `ID_Conductor`, `Marca`, `Modelo`, `Anio`, `NumeroPlaca`, `EstadoMantenimiento`, `Estado`) VALUES
(1, 3, 'toyota', 'hashback', 2000, '456585', 'Bueno', 1),
(2, 7, 'kia', 'nuevo', 2001, 'v5f-888', 'Bueno', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historialviajes`
--
ALTER TABLE `historialviajes`
  ADD PRIMARY KEY (`ID_Viaje`),
  ADD KEY `ID_Pasajero` (`ID_Pasajero`),
  ADD KEY `ID_Conductor` (`ID_Conductor`),
  ADD KEY `ID_Ruta` (`ID_Ruta`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`ID_Pago`),
  ADD KEY `ID_Usuario` (`ID_Usuario`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID_Rol`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`ID_Ruta`);

--
-- Indices de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD PRIMARY KEY (`ID_Tarifa`),
  ADD KEY `ID_Ruta` (`ID_Ruta`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_Usuario`),
  ADD KEY `ID_Rol` (`ID_Rol`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`ID_Vehiculo`),
  ADD KEY `ID_Conductor` (`ID_Conductor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historialviajes`
--
ALTER TABLE `historialviajes`
  MODIFY `ID_Viaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `ID_Pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `ID_Rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `ID_Ruta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarifas`
--
ALTER TABLE `tarifas`
  MODIFY `ID_Tarifa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  MODIFY `ID_Vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historialviajes`
--
ALTER TABLE `historialviajes`
  ADD CONSTRAINT `historialviajes_ibfk_1` FOREIGN KEY (`ID_Pasajero`) REFERENCES `usuarios` (`ID_Usuario`),
  ADD CONSTRAINT `historialviajes_ibfk_2` FOREIGN KEY (`ID_Conductor`) REFERENCES `usuarios` (`ID_Usuario`),
  ADD CONSTRAINT `historialviajes_ibfk_3` FOREIGN KEY (`ID_Ruta`) REFERENCES `rutas` (`ID_Ruta`);

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID_Usuario`);

--
-- Filtros para la tabla `tarifas`
--
ALTER TABLE `tarifas`
  ADD CONSTRAINT `tarifas_ibfk_1` FOREIGN KEY (`ID_Ruta`) REFERENCES `rutas` (`ID_Ruta`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ID_Rol`) REFERENCES `roles` (`ID_Rol`);

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`ID_Conductor`) REFERENCES `usuarios` (`ID_Usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
