-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2019 at 04:12 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=11 ;

--
-- Dumping data for table `cauhinh`
--

INSERT INTO `cauhinh` (`idCauHinh`, `TenThuocTinh`, `LoaiThuocTinh`, `GiaTri`, `TenDayDu`) VALUES
(8, 'siSoToiDa', 'maxSizeStudents', '2', 'Sỉ số tối đa chung'),
(9, 'tuoiToiTieuDauVao', 'minAge', '5', 'Tuổi tối tiểu vào trường'),
(10, 'tuoiToiDaDauVao', 'maxAge', '5', 'Tuổi tối đa vào trường');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='		' AUTO_INCREMENT=38 ;

--
-- Dumping data for table `diem`
--

INSERT INTO `diem` (`idDiem`, `Diem15Phut`, `Diem1Tiet`, `DiemCuoiKy`, `idHocSinhLopHoc`, `idHocKy`, `idMonHoc`) VALUES
(10, NULL, 9, 6, 1, 1, 2),
(16, NULL, 8, NULL, 7, 1, 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=13 ;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`idHocSinh`, `HoTen`, `NgaySinh`, `Email`, `GioiTinh`, `DiaChi`, `sdtCaNhan`, `sdtGiamHo`, `TinhTrang`) VALUES
(1, 'Nguyễn Văn A', '18-10-2003', '', 'Nam', '18 Đặng Văn Kiêu, P4, Quận Ảo Tưởng', NULL, NULL, 1),
(2, 'Nguyễn Thị B', '22-08-2003', '', 'Nữ', '25 Trần Hửu Ngợi, P9, Quận Dị', '0909556688', NULL, 1),
(3, 'Hoàng Văn C', '22-08-2003', '', 'Nam', '19 Trần Gời, P5, Quận B', NULL, '0909556688', 1),
(4, 'Phan Hồng D', '10-10-2001', '', 'Nữ', '56 Phạm Hồng, P8, Quận Ba Chuẩn', '0908050708', NULL, 1),
(5, 'Nguyễn Thanh X', '22-08-2000', '', 'Nam', '45 Hồng F, P6, Quận Ba Chửn', '0908050708', '0908050708', 1),
(6, 'Mai Hồng A', '27-03-2003', '', 'Nữ', '56 Lại H, P3, Quận H', '0909556688', NULL, 1),
(11, 'Hoàng Phúc Hân', '08-06-2000', 'cho moi', 'Nữ', 'cho moi', '0908050709', '', 1),
(12, 'Trần Ngụy Quốc Thái', '02-01-1999', 'quận 8', 'Nam', 'Chung cư xxx, Quận 8', '0125527890', '0125527890', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=16 ;

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
(14, 6, 16, 1);

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
(16, 'Anh1', '11', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`idNguoiDung`, `HoTen`, `TenTaiKhoan`, `MatKhau`, `LoaiNguoiDung`, `TinhTrang`, `Sdt`, `Email`) VALUES
(1, 'Kim Ji Won', 'won', '123357df09673b8943afb057783321e0', 1, 1, NULL, NULL),
(2, 'asd', 'asddd', '123', 0, 0, '', ''),
(3, 'asdddd', 'dddddd', '1234', 0, 0, '', ''),
(4, 'assdddd', 'asdddd', '202cb962ac59075b964b07152d234b70', 0, 0, '', ''),
(5, 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, '0909090909', 'tuhuynhkhtn@gmail.com'),
(6, 'gv01', 'gv01', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, '0909090909', 'gv01@gmail.com');

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
