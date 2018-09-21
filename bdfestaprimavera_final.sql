-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21-Set-2018 às 02:15
-- Versão do servidor: 5.7.17
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdfestaprimavera`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacao`
--

CREATE TABLE `avaliacao` (
  `id_avaliacao` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `rm` int(11) NOT NULL,
  `notas` varchar(50) NOT NULL,
  `pontuacao` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `competicao`
--

CREATE TABLE `competicao` (
  `edicao` int(11) NOT NULL,
  `rm_miss` int(11) DEFAULT NULL,
  `rm_mister` int(11) DEFAULT NULL,
  `data` date NOT NULL,
  `criterios` varchar(700) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `competicao`
--

INSERT INTO `competicao` (`edicao`, `rm_miss`, `rm_mister`, `data`, `criterios`) VALUES
(2018, 0, 0, '2018-09-22', 'Postura, Charme, Simpatia, Desenvoltura, Elegância, Traje-Primavera-Verão, Traje-Gala');

-- --------------------------------------------------------

--
-- Estrutura da tabela `competidor`
--

CREATE TABLE `competidor` (
  `rm` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `turma` varchar(15) NOT NULL,
  `idade` varchar(3) NOT NULL,
  `sexo` varchar(9) NOT NULL,
  `id_inst` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `convite`
--

CREATE TABLE `convite` (
  `id_convite` int(11) NOT NULL,
  `ano` varchar(4) NOT NULL,
  `login` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `instituicao`
--

CREATE TABLE `instituicao` (
  `id_inst` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `jurado`
--

CREATE TABLE `jurado` (
  `login` varchar(255) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `ocupacao` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `participacao`
--

CREATE TABLE `participacao` (
  `id_participacao` int(11) NOT NULL,
  `edicao` varchar(4) NOT NULL,
  `rm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD PRIMARY KEY (`id_avaliacao`),
  ADD KEY `rm` (`rm`),
  ADD KEY `id_jurado` (`login`);

--
-- Indexes for table `competicao`
--
ALTER TABLE `competicao`
  ADD PRIMARY KEY (`edicao`);

--
-- Indexes for table `competidor`
--
ALTER TABLE `competidor`
  ADD PRIMARY KEY (`rm`),
  ADD KEY `id_instituicao` (`id_inst`);

--
-- Indexes for table `convite`
--
ALTER TABLE `convite`
  ADD PRIMARY KEY (`id_convite`),
  ADD KEY `id_jurado` (`login`),
  ADD KEY `edicao` (`ano`);

--
-- Indexes for table `instituicao`
--
ALTER TABLE `instituicao`
  ADD PRIMARY KEY (`id_inst`);

--
-- Indexes for table `jurado`
--
ALTER TABLE `jurado`
  ADD PRIMARY KEY (`login`);

--
-- Indexes for table `participacao`
--
ALTER TABLE `participacao`
  ADD PRIMARY KEY (`id_participacao`),
  ADD KEY `rm` (`rm`),
  ADD KEY `edicao` (`edicao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `avaliacao`
--
ALTER TABLE `avaliacao`
  MODIFY `id_avaliacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `competicao`
--
ALTER TABLE `competicao`
  MODIFY `edicao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2019;
--
-- AUTO_INCREMENT for table `competidor`
--
ALTER TABLE `competidor`
  MODIFY `rm` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `convite`
--
ALTER TABLE `convite`
  MODIFY `id_convite` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `instituicao`
--
ALTER TABLE `instituicao`
  MODIFY `id_inst` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `participacao`
--
ALTER TABLE `participacao`
  MODIFY `id_participacao` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD CONSTRAINT `avaliacao_fk_login` FOREIGN KEY (`login`) REFERENCES `jurado` (`login`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `avaliacao_ibfk_1` FOREIGN KEY (`rm`) REFERENCES `competidor` (`rm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `competidor`
--
ALTER TABLE `competidor`
  ADD CONSTRAINT `competidor_ibfk_1` FOREIGN KEY (`id_inst`) REFERENCES `instituicao` (`id_inst`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `convite`
--
ALTER TABLE `convite`
  ADD CONSTRAINT `fkLogin` FOREIGN KEY (`login`) REFERENCES `jurado` (`login`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `participacao`
--
ALTER TABLE `participacao`
  ADD CONSTRAINT `fk_rm` FOREIGN KEY (`rm`) REFERENCES `competidor` (`rm`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
