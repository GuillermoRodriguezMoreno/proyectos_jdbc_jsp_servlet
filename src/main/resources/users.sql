CREATE DATABASE IF NOT EXISTS `users` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `users`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
    `usuario` varchar(40),
    `contraseña` varchar(11),
    PRIMARY KEY (`usuario`)
    )