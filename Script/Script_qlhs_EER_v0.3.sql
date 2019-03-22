-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 22, 2019 at 03:26 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyhocsinh`
--
CREATE DATABASE IF NOT EXISTS `quanlyhocsinh` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `quanlyhocsinh`;

-- --------------------------------------------------------

--
-- Table structure for table `cauhinh`
--

DROP TABLE IF EXISTS `cauhinh`;
CREATE TABLE IF NOT EXISTS `cauhinh` (
  `idCauHinh` int(11) NOT NULL AUTO_INCREMENT,
  `TenThuocTinh` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `LoaiThuocTinh` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `GiaTri` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenDayDu` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idCauHinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitiet_cauhinh_diem`
--

DROP TABLE IF EXISTS `chitiet_cauhinh_diem`;
CREATE TABLE IF NOT EXISTS `chitiet_cauhinh_diem` (
  `idDiem` int(11) NOT NULL,
  `idCauHinh` int(11) NOT NULL,
  `apDung` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idDiem`,`idCauHinh`),
  KEY `fk_Diem_has_CauHinh_CauHinh1_idx` (`idCauHinh`),
  KEY `fk_Diem_has_CauHinh_Diem1_idx` (`idDiem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitiet_cauhinh_hocsinh`
--

DROP TABLE IF EXISTS `chitiet_cauhinh_hocsinh`;
CREATE TABLE IF NOT EXISTS `chitiet_cauhinh_hocsinh` (
  `idHocSinh` int(11) NOT NULL,
  `idCauHinh` int(11) NOT NULL,
  `apDung` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idHocSinh`,`idCauHinh`),
  KEY `fk_HocSinh_has_CauHinh_CauHinh1_idx` (`idCauHinh`),
  KEY `fk_HocSinh_has_CauHinh_HocSinh1_idx` (`idHocSinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitiet_cauhinh_lop`
--

DROP TABLE IF EXISTS `chitiet_cauhinh_lop`;
CREATE TABLE IF NOT EXISTS `chitiet_cauhinh_lop` (
  `idLop` int(11) NOT NULL,
  `idNamHoc` int(11) NOT NULL,
  `idCauHinh` int(11) NOT NULL,
  PRIMARY KEY (`idLop`,`idNamHoc`),
  KEY `fk_Lop_has_CauHinh_CauHinh1_idx` (`idCauHinh`),
  KEY `fk_Lop_has_CauHinh_Lop1_idx` (`idLop`),
  KEY `idNamHoc` (`idNamHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
CREATE TABLE IF NOT EXISTS `diem` (
  `idDiem` int(11) NOT NULL AUTO_INCREMENT,
  `15Phut` double DEFAULT NULL,
  `1Tiet` double DEFAULT NULL,
  `CuoiKy` double DEFAULT NULL,
  `idHocSinh` int(11) NOT NULL,
  `idNamHoc` int(11) NOT NULL,
  `idHocKy` int(11) NOT NULL,
  `idMonHoc` int(11) NOT NULL,
  PRIMARY KEY (`idDiem`),
  KEY `fk_Diem_HocSinh1_idx` (`idHocSinh`),
  KEY `fk_Diem_MonHoc1_idx` (`idMonHoc`),
  KEY `fk_Diem_HocKy1_idx` (`idHocKy`),
  KEY `idHocSinh` (`idHocSinh`,`idMonHoc`,`idNamHoc`,`idHocKy`),
  KEY `idNamHoc` (`idNamHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='		';

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

DROP TABLE IF EXISTS `hocky`;
CREATE TABLE IF NOT EXISTS `hocky` (
  `idHocKy` int(11) NOT NULL AUTO_INCREMENT,
  `TenHocKy` int(11) NOT NULL,
  PRIMARY KEY (`idHocKy`),
  UNIQUE KEY `NamHoc` (`TenHocKy`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hocky`
--

INSERT INTO `hocky` (`idHocKy`, `TenHocKy`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh`
--

DROP TABLE IF EXISTS `hocsinh`;
CREATE TABLE IF NOT EXISTS `hocsinh` (
  `idHocSinh` int(11) NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) CHARACTER SET utf8 NOT NULL,
  `NgaySinh` date NOT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `GioiTinh` varchar(45) CHARACTER SET utf8 NOT NULL,
  `DiaChi` varchar(200) CHARACTER SET utf8 NOT NULL,
  `TinhTrang` tinyint(4) NOT NULL,
  PRIMARY KEY (`idHocSinh`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`idHocSinh`, `HoTen`, `NgaySinh`, `Email`, `GioiTinh`, `DiaChi`, `TinhTrang`) VALUES
(1, 'Nguyễn Văn A', '2013-10-18', '', 'nam', '18 Đặng Văn Kiêu, P4, Quận Ảo Tưởng', 1),
(2, 'Nguyễn Thị B', '2003-08-22', '', 'nữ', '25 Trần Hửu Ngợi, P9, Quận Dị', 2),
(3, 'Hoàng Văn C', '2003-08-22', '', 'nam', '19 Trần Gời, P5, Quận B', 2),
(4, 'Phan Hồng D', '2003-10-10', '', 'nữ', '56 Phạm Hồng, P8, Quận Ba Chuẩn', 3),
(5, 'Nguyễn Thanh X', '2003-08-22', '', 'nam', '45 Hồng F, P6, Quận Ba Chửn', 4),
(6, 'Mai Hồng A', '2003-07-23', '', 'nữ', '56 Lại H, P3, Quận H', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh_lophoc`
--

DROP TABLE IF EXISTS `hocsinh_lophoc`;
CREATE TABLE IF NOT EXISTS `hocsinh_lophoc` (
  `idLopHoc` int(11) NOT NULL,
  `idNamHoc` int(11) NOT NULL,
  `idHocSinh` int(11) NOT NULL,
  PRIMARY KEY (`idHocSinh`,`idLopHoc`,`idNamHoc`),
  UNIQUE KEY `idHocSinh` (`idHocSinh`,`idNamHoc`),
  KEY `idLopHoc` (`idLopHoc`,`idNamHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
CREATE TABLE IF NOT EXISTS `lop` (
  `idLop` int(11) NOT NULL AUTO_INCREMENT,
  `TenLop` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Khoi` int(11) NOT NULL,
  `TinhTrang` tinyint(4) NOT NULL,
  PRIMARY KEY (`idLop`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`idLop`, `TenLop`, `Khoi`, `TinhTrang`) VALUES
(1, '10A1', 10, 1),
(2, '10A2', 10, 1),
(3, '10A3', 10, 1),
(4, '10A4', 10, 1),
(5, '10A5', 10, 1),
(6, '11A1', 11, 1),
(7, '11A2', 11, 1),
(8, '11A3', 11, 1),
(9, '11A4', 11, 1),
(10, '11A5', 11, 1),
(11, '12A1', 12, 1),
(12, '12A2', 12, 1),
(13, '12A3', 12, 1),
(14, '12A4', 12, 1),
(15, '12A5', 12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE IF NOT EXISTS `monhoc` (
  `idMonHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenMH` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`idMonHoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `namhoc`
--

DROP TABLE IF EXISTS `namhoc`;
CREATE TABLE IF NOT EXISTS `namhoc` (
  `idNamHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenNamHoc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idNamHoc`),
  UNIQUE KEY `TenNamHoc` (`TenNamHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `namhoc`
--

INSERT INTO `namhoc` (`idNamHoc`, `TenNamHoc`) VALUES
(1, '2018-2019');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

DROP TABLE IF EXISTS `nguoidung`;
CREATE TABLE IF NOT EXISTS `nguoidung` (
  `idNguoiDung` int(11) NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenTaiKhoan` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `LoaiNguoiDung` tinyint(4) NOT NULL,
  `TinhTrang` tinyint(4) NOT NULL,
  PRIMARY KEY (`idNguoiDung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiet_cauhinh_diem`
--
ALTER TABLE `chitiet_cauhinh_diem`
  ADD CONSTRAINT `fk_Diem_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Diem_has_CauHinh_Diem1` FOREIGN KEY (`idDiem`) REFERENCES `diem` (`idDiem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chitiet_cauhinh_hocsinh`
--
ALTER TABLE `chitiet_cauhinh_hocsinh`
  ADD CONSTRAINT `fk_HocSinh_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_HocSinh_has_CauHinh_HocSinh1` FOREIGN KEY (`idHocSinh`) REFERENCES `hocsinh` (`idHocSinh`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `chitiet_cauhinh_lop`
--
ALTER TABLE `chitiet_cauhinh_lop`
  ADD CONSTRAINT `chitiet_cauhinh_lop_ibfk_1` FOREIGN KEY (`idNamHoc`) REFERENCES `namhoc` (`idNamHoc`),
  ADD CONSTRAINT `fk_Lop_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Lop_has_CauHinh_Lop1` FOREIGN KEY (`idLop`) REFERENCES `lop` (`idLop`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `fk_Diem_HocKy1` FOREIGN KEY (`idHocKy`) REFERENCES `hocky` (`idHocKy`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Diem_MonHoc1` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `hocsinh_lophoc`
--
ALTER TABLE `hocsinh_lophoc`
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_1` FOREIGN KEY (`idLopHoc`,`idNamHoc`) REFERENCES `chitiet_cauhinh_lop` (`idLop`, `idNamHoc`),
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_2` FOREIGN KEY (`idHocSinh`) REFERENCES `hocsinh` (`idHocSinh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
