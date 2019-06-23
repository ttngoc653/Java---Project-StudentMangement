-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2019 at 01:07 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `quanlyhocsinh`
--

-- --------------------------------------------------------

--
-- Table structure for table `cauhinh`
--

CREATE TABLE IF NOT EXISTS `cauhinh` (
  `idCauHinh` int(11) NOT NULL AUTO_INCREMENT,
  `TenThuocTinh` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `LoaiThuocTinh` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GiaTri` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenDayDu` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idCauHinh`),
  UNIQUE KEY `TenThuocTinh` (`TenThuocTinh`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `cauhinh`
--

INSERT INTO `cauhinh` (`idCauHinh`, `TenThuocTinh`, `LoaiThuocTinh`, `GiaTri`, `TenDayDu`) VALUES
(8, 'siSoToiDa', 'maxSizeStudents', '40', 'Sỉ số tối đa chung'),
(9, 'tuoiToiTieuDauVao', 'minAge', '15', 'Tuổi tối tiểu vào trường'),
(10, 'tuoiToiDaDauVao', 'maxAge', '20', 'Tuổi tối đa vào trường'),
(11, 'diemChuan', 'benchmark', '5', 'Điểm chuẩn mặc định');

-- --------------------------------------------------------

--
-- Table structure for table `chitiet_cauhinh_diem`
--

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

CREATE TABLE IF NOT EXISTS `chitiet_cauhinh_hocsinh` (
  `idHocSinh` int(11) NOT NULL,
  `idCauHinh` int(11) NOT NULL,
  `apDung` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idHocSinh`,`idCauHinh`) USING BTREE,
  KEY `fk_HocSinh_has_CauHinh_CauHinh1_idx` (`idCauHinh`),
  KEY `fk_HocSinh_has_CauHinh_HocSinh1_idx` (`idHocSinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `chitiet_cauhinh_lop`
--

CREATE TABLE IF NOT EXISTS `chitiet_cauhinh_lop` (
  `idLop` int(11) NOT NULL,
  `idCauHinh` int(11) NOT NULL,
  PRIMARY KEY (`idLop`,`idCauHinh`),
  KEY `fk_Lop_has_CauHinh_CauHinh1_idx` (`idCauHinh`),
  KEY `fk_Lop_has_CauHinh_Lop1_idx` (`idLop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE IF NOT EXISTS `diem` (
  `idDiem` int(11) NOT NULL AUTO_INCREMENT,
  `Diem15Phut` double DEFAULT NULL,
  `Diem1Tiet` double DEFAULT NULL,
  `DiemCuoiKy` double DEFAULT NULL,
  `idHocSinhLopHoc` int(11) NOT NULL,
  `idHocKy` int(11) NOT NULL,
  `idMonHoc` int(11) NOT NULL,
  PRIMARY KEY (`idDiem`),
  UNIQUE KEY `idHocSinhLopHoc_2` (`idHocSinhLopHoc`,`idHocKy`,`idMonHoc`),
  KEY `idHocSinhLopHoc` (`idHocSinhLopHoc`),
  KEY `idHocKy` (`idHocKy`),
  KEY `idMonHoc` (`idMonHoc`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='		' AUTO_INCREMENT=80 ;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`idDiem`, `Diem15Phut`, `Diem1Tiet`, `DiemCuoiKy`, `idHocSinhLopHoc`, `idHocKy`, `idMonHoc`) VALUES
(10, 10, 9, 6, 1, 1, 2),
(16, 10, 8, 10, 7, 1, 2),
(17, 8, 7, 8, 15, 1, 3),
(18, 5.5, 6, 8, 15, 2, 3),
(19, 6.5, 8.6, 10, 15, 3, 3),
(20, 9, 9.5, 8, 15, 1, 2),
(21, 7.6, 10, 7, 15, 2, 2),
(22, 8, 8, 8, 15, 3, 2),
(23, 10, 7, 5.5, 15, 1, 4),
(24, 7, 0, 6, 15, 2, 4),
(25, 8.5, 9, 7, 15, 3, 4),
(26, 9.5, 10, 9.5, 15, 1, 5),
(27, 10, 8, 8, 15, 2, 5),
(28, 8, 10, 8, 15, 3, 5),
(29, 6, 9, 10, 15, 1, 1),
(30, 6, 8.5, 9.5, 15, 2, 1),
(31, 5, 3, 8.5, 15, 3, 1),
(32, 5, 5, 10, 15, 1, 7),
(33, 10, 8, 9.5, 15, 2, 7),
(34, 10, 10, 10, 15, 3, 7),
(35, 8, 6.5, 8, 15, 1, 6),
(36, 10, 8.5, 6, 15, 2, 6),
(37, 9.5, 10, 5, 15, 3, 6),
(38, 8, 9.5, 7, 16, 1, 3),
(39, 9, 6, 2, 16, 2, 3),
(40, 10, 7, 4, 16, 3, 3),
(41, 18, 8, 8, 16, 1, 2),
(42, 6, 9, 10, 16, 2, 2),
(43, 7, 10, 9, 16, 3, 2),
(44, 18, 1, 5, 16, 1, 4),
(45, 6, 5.5, 7, 16, 2, 4),
(46, 10, 9.6, 4, 16, 3, 4),
(47, 2, 9, 10, 16, 1, 5),
(48, 10, 10, 10, 16, 2, 5),
(49, 7, 10, 10, 16, 3, 5),
(50, 7.5, 9, 9, 16, 1, 1),
(51, 6.5, 10, 5, 16, 2, 1),
(52, 9, 9.5, 7, 16, 3, 1),
(53, 10, 9.75, 4, 16, 1, 7),
(54, 8.5, 10, 7, 16, 2, 7),
(55, 10, 10, 2, 16, 3, 7),
(56, 9.5, 9.6, 5, 16, 1, 6),
(57, 1, 7.5, 1.5, 16, 2, 6),
(58, 9, 6, 10, 16, 3, 6),
(59, 10, 8.5, 8, 17, 1, 3),
(60, 10, 10, 6, 17, 2, 3),
(61, 9.5, 9, 7, 17, 3, 3),
(62, 8.5, 9.5, 3, 17, 1, 2),
(63, 9.5, 10, 6, 17, 2, 2),
(64, 10, 10, 9, 17, 3, 2),
(65, 10, 9.5, 10, 17, 1, 4),
(66, 10, 10, 9.5, 17, 2, 4),
(67, 5.5, 8.5, 8.5, 17, 3, 4),
(68, 9.5, 10, 9.5, 17, 1, 5),
(69, 10, 9.5, 10, 17, 2, 5),
(70, 8.5, 8, 7, 17, 3, 5),
(71, 10, 8, 8, 17, 1, 1),
(72, 10, 6, 9, 17, 2, 1),
(73, 5.5, 10, 10, 17, 3, 1),
(74, 6.5, 10, 10, 17, 1, 7),
(75, 9.5, 9.5, 8, 17, 2, 7),
(76, 8, 6.8, 9.5, 17, 3, 7),
(77, 10, 9.5, 10, 17, 1, 6),
(78, 8.6, 10, 8.5, 17, 2, 6),
(79, 6.5, 8, 9, 17, 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `hocky`
--

CREATE TABLE IF NOT EXISTS `hocky` (
  `idHocKy` int(11) NOT NULL AUTO_INCREMENT,
  `TenHocKy` int(11) NOT NULL,
  PRIMARY KEY (`idHocKy`),
  UNIQUE KEY `NamHoc` (`TenHocKy`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

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

CREATE TABLE IF NOT EXISTS `hocsinh` (
  `idHocSinh` int(11) NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) CHARACTER SET utf8 NOT NULL,
  `NgaySinh` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GioiTinh` varchar(45) CHARACTER SET utf8 NOT NULL,
  `DiaChi` varchar(200) CHARACTER SET utf8 NOT NULL,
  `sdtCaNhan` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sdtGiamHo` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TinhTrang` tinyint(4) NOT NULL,
  PRIMARY KEY (`idHocSinh`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=27 ;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`idHocSinh`, `HoTen`, `NgaySinh`, `Email`, `GioiTinh`, `DiaChi`, `sdtCaNhan`, `sdtGiamHo`, `TinhTrang`) VALUES
(1, 'Nguyễn Văn Anh', '18-10-2003', 'nva2@gmail.com', 'Nam', '18, đường Đặng Văn Kiêu, \r phường 4, quận 9', '0909556688', '0909556688', 1),
(2, 'Nguyễn Thị Bình', '22-08-2003', '', 'Nữ', '25, đường Trần Hửu Ngợi, phường 9, Quận Bình Thạnh', '0909556688', NULL, 1),
(3, 'Hoàng Văn Cường', '22-08-2003', '', 'Nam', '19, đường Trần Gời, phường 5, quận 5', NULL, '0909556688', 1),
(4, 'Mai Hồng Danh', '10-10-2001', 'mhd@gmail.com', 'Nữ', '56, đường Phạm Hồng, phường 8, quận Ba Chuẩn', '0908050708', NULL, 1),
(5, 'Ngô Hùng Dũng', '22-08-2000', 'nhd@gmail.com', 'Nam', '45, đường S12, phường Bình Trị Đông A, Quận Tân Phú', '0908050708', '0908050708', 1),
(6, 'Phan Hồng Duyên', '27-03-2003', '', 'Nữ', '56, đường Dường Bá Trạc, phường 3, quận 6', '0909556688', NULL, 1),
(11, 'Hoàng Phúc Hân', '08-06-2000', '', 'Nữ', '59/92/20, đường Ngô Gia Tự, phường 5, quận 6', '0908050709', '', 1),
(12, 'Hoàng Tuấn Minh', '02-01-1999', 'htm@gmail.com', 'Nam', 'Chung cư City Gate, 15, đường Võ Văn Kiệt, phường 18, quận 8', '0125527890', '0125527890', 1),
(13, 'Huỳnh Hoài Mộng', '22-08-2000', '', 'Nữ', '59/90/28, đường Đinh Tiên Hoàng, phường 3, quận Bình Thạnh', '0908050708', '0908050708', 1),
(17, 'Nguyễn Hoàng Trúc Quân', '27-03-2000', '', 'Nữ', '1024, đường Võ Văn Kiệt, phường 10, quận 6', '09095566880', '', 1),
(18, 'Trần Ngụy Quốc Thái', '29-03-2000', 'ntqt@gmail.com', 'Nam', '105/19, đường Mai Xuân Thường, phường 10, quận 6', '02095566990', '02095566990', 1),
(19, 'Trần Phước Thanh', '28-03-2000', NULL, 'Nam', '56, đường Nguyễn Du, phường 3, quận 1', '0125527890', NULL, 1),
(20, 'Nguyễn Thị Ngọc Thùy', '20-10-2000', NULL, 'Nữ', '28, đường Đinh Tiên Hoàng, phường 3, quận Bình Thạnh', NULL, '0125527890', 1),
(21, 'Trần Thị Tình', '15-05-2000', NULL, 'Nữ', '19, đường Mai Xuân Thường, phường 10, quận 6', NULL, NULL, 1),
(22, 'Nguyễn Minh Tuấn', '22-03-2000', NULL, 'Nam', '56, đường Nguyễn Hoàng, phường 3, quận 2', NULL, NULL, 1),
(23, 'Nguyễn Thanh Xuân', '05-08-2000', NULL, 'Nữ', '90, đường Võ Văn Kiệt, phường 10, quận 6', '0125527890', NULL, 1),
(24, 'Đinh Hoàng Yến', '30-03-2000', NULL, 'Nữ', '56, đường Phạm Hồng, phường 8, quận Ba Chuẩn', '0125527890', '0125527890', 1),
(25, 'Trần Minh Yên', '05-11-2000', NULL, 'Nam', '19, đường Trần Gời, phường 5, quận 5', NULL, NULL, 1),
(26, 'Vũ Hoàng Yên', '19-08-2000', NULL, 'Nam', '28, đường Đinh Bộ Lĩnh, phường 3, quận Bình Thạnh', '0125527890', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh_lophoc`
--

CREATE TABLE IF NOT EXISTS `hocsinh_lophoc` (
  `idHocSinhLopHoc` int(11) NOT NULL AUTO_INCREMENT,
  `idHocSinh` int(11) NOT NULL,
  `idLopHoc` int(11) NOT NULL,
  `idNamHoc` int(11) NOT NULL,
  PRIMARY KEY (`idHocSinhLopHoc`) USING BTREE,
  UNIQUE KEY `idHocSinhLopHoc` (`idHocSinhLopHoc`),
  UNIQUE KEY `idHocSinh` (`idHocSinh`,`idLopHoc`,`idNamHoc`),
  KEY `idLopHoc` (`idLopHoc`),
  KEY `idNamHoc` (`idNamHoc`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Dumping data for table `hocsinh_lophoc`
--

INSERT INTO `hocsinh_lophoc` (`idHocSinhLopHoc`, `idHocSinh`, `idLopHoc`, `idNamHoc`) VALUES
(1, 1, 1, 1),
(7, 2, 1, 1),
(8, 3, 2, 1),
(11, 3, 10, 2),
(13, 4, 16, 1),
(10, 5, 5, 1),
(14, 6, 16, 1),
(16, 11, 1, 2),
(17, 13, 1, 2),
(15, 18, 16, 2);

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

CREATE TABLE IF NOT EXISTS `lop` (
  `idLop` int(11) NOT NULL AUTO_INCREMENT,
  `TenLop` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Khoi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `TinhTrang` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idLop`),
  UNIQUE KEY `TenLop` (`TenLop`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`idLop`, `TenLop`, `Khoi`, `TinhTrang`) VALUES
(1, '10A1', '10', 1),
(2, '10A2', '10', 1),
(3, '10A3', '10', 1),
(4, '10A4', '10', 1),
(5, '10A5', '10', 1),
(6, '11A1', '11', 1),
(7, '11A2', '11', 1),
(8, '11A3', '11', 1),
(9, '11A4', '11', 1),
(10, '11A5', '11', 1),
(11, '12A1', '12', 1),
(12, '12A2', '12', 1),
(13, '12A3', '12', 1),
(14, '12A4', '12', 1),
(15, '12A5', '12', 1),
(16, '12A6', '12', 1);

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

CREATE TABLE IF NOT EXISTS `monhoc` (
  `idMonHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenMH` varchar(45) CHARACTER SET utf8 NOT NULL,
  `heSo` int(3) NOT NULL DEFAULT '1',
  `dangGiangDay` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMonHoc`),
  UNIQUE KEY `TenMH` (`TenMH`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`idMonHoc`, `TenMH`, `heSo`, `dangGiangDay`) VALUES
(1, 'Toán', 1, 1),
(2, 'Lý', 1, 1),
(3, 'Hóa', 1, 1),
(4, 'Sinh', 1, 1),
(5, 'Sử', 1, 1),
(6, 'Địa', 1, 1),
(7, 'Văn', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `namhoc`
--

CREATE TABLE IF NOT EXISTS `namhoc` (
  `idNamHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenNamHoc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idNamHoc`),
  UNIQUE KEY `TenNamHoc` (`TenNamHoc`),
  UNIQUE KEY `TenNamHoc_2` (`TenNamHoc`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `namhoc`
--

INSERT INTO `namhoc` (`idNamHoc`, `TenNamHoc`) VALUES
(2, '2017-2018'),
(1, '2018-2019');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE IF NOT EXISTS `nguoidung` (
  `idNguoiDung` int(11) NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenTaiKhoan` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `MatKhau` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `LoaiNguoiDung` tinyint(4) NOT NULL,
  `TinhTrang` tinyint(4) NOT NULL,
  `Sdt` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idNguoiDung`),
  UNIQUE KEY `TenTaiKhoan` (`TenTaiKhoan`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`idNguoiDung`, `HoTen`, `TenTaiKhoan`, `MatKhau`, `LoaiNguoiDung`, `TinhTrang`, `Sdt`, `Email`) VALUES
(5, 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, '0335900680', 'tuhuynhkhtn@gmail.com'),
(6, 'gv01', 'gv01', 'e10adc3949ba59abbe56e057f20f883e', 0, 1, '0909090909', 'tuhuynhkhtn@gmail.com'),
(7, 'Trần Thế Ngọc', 'ttngoc', 'e10adc3949ba59abbe56e057f20f883e', 0, 1, '0909090909', 'tuhuynhkhtn@gmail.com'),
(8, 'Mai Thanh Tân', 'mttan', 'e10adc3949ba59abbe56e057f20f883e', 0, 1, '0909090909', 'tuhuynhkhtn@gmail.com'),
(9, 'Đinh Bá Tiến', 'dbtien', 'e10adc3949ba59abbe56e057f20f883e', 0, 1, '0909090909', 'tuhuynhkhtn@gmail.com'),
(10, 'Huỳnh Thư Tú', 'tttu', 'e10adc3949ba59abbe56e057f20f883e', 0, 1, '0909090909', 'tuhuynhkhtn@gmail.com');

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
  ADD CONSTRAINT `fk_Lop_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Lop_has_CauHinh_Lop1` FOREIGN KEY (`idLop`) REFERENCES `lop` (`idLop`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `diem_ibfk_1` FOREIGN KEY (`idHocKy`) REFERENCES `hocky` (`idHocKy`),
  ADD CONSTRAINT `diem_ibfk_2` FOREIGN KEY (`idHocSinhLopHoc`) REFERENCES `hocsinh_lophoc` (`idHocSinhLopHoc`),
  ADD CONSTRAINT `diem_ibfk_3` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`);

--
-- Constraints for table `hocsinh_lophoc`
--
ALTER TABLE `hocsinh_lophoc`
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_1` FOREIGN KEY (`idHocSinh`) REFERENCES `hocsinh` (`idHocSinh`),
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_2` FOREIGN KEY (`idLopHoc`) REFERENCES `lop` (`idLop`),
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_3` FOREIGN KEY (`idNamHoc`) REFERENCES `namhoc` (`idNamHoc`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
