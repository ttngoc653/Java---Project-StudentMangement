-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 17, 2019 at 12:35 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `cauhinh`
--

DROP TABLE IF EXISTS `cauhinh`;
CREATE TABLE IF NOT EXISTS `cauhinh` (
  `idCauHinh` int(11) NOT NULL AUTO_INCREMENT,
  `TenThuocTinh` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `LoaiThuocTinh` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GiaTri` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TenDayDu` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idCauHinh`),
  UNIQUE KEY `TenThuocTinh` (`TenThuocTinh`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cauhinh`
--

INSERT INTO `cauhinh` (`idCauHinh`, `TenThuocTinh`, `LoaiThuocTinh`, `GiaTri`, `TenDayDu`) VALUES
(11, 'tuoiToiDaDauVao', 'maxAge', '20', 'Tuổi tối đa vào trường'),
(12, 'tuoiToiTieuDauVao', 'minAge', '15', 'Tuổi tối tiểu vào trường'),
(13, 'siSoToiDa', 'maxSizeStudents', '40', 'Sỉ số tối đa chung'),
(14, 'soLopToiDa', 'maxSizeGrades', '40', 'Số lớp tối đa của trường'),
(15, 'diemChuan', 'benchmark', '5.0', 'Điểm chuẩn mặc định'),
(16, 'soMonToiDa', 'maxSubjects', '', 'Số môn giảng dạy tối đa.');

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
  PRIMARY KEY (`idHocSinh`,`idCauHinh`) USING BTREE,
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
  `idCauHinh` int(11) NOT NULL,
  PRIMARY KEY (`idLop`,`idCauHinh`),
  KEY `fk_Lop_has_CauHinh_CauHinh1_idx` (`idCauHinh`),
  KEY `fk_Lop_has_CauHinh_Lop1_idx` (`idLop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hocky`
--

INSERT INTO `hocky` (`idHocKy`, `TenHocKy`) VALUES
(4, 1),
(5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh`
--

DROP TABLE IF EXISTS `hocsinh`;
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hocsinh`
--

INSERT INTO `hocsinh` (`idHocSinh`, `HoTen`, `NgaySinh`, `Email`, `GioiTinh`, `DiaChi`, `sdtCaNhan`, `sdtGiamHo`, `TinhTrang`) VALUES
(14, 'Nguyễn Triệu Khánh Ân', '07-03-2003', '', 'Nam', '1A29A Trần Văn Giàu, ấp 1, Xã Phạm Văn Hai, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(15, 'Đỗ Nguyễn Gia Bảo', '28-10-2003', '', 'Nam', 'E1/19A Khu phố 5, Thị Trấn Tân Túc, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(16, 'Lê Thu An', '19-10-2003', '', 'Nữ', 'Số 6, Đường 24, Khu dân cư Him Lam 6A, Xã Bình Hưng, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(17, 'Lý Thế Bình', '02-01-2003', '', 'Nam', 'A10/21F Đường Công Nghệ Mới, Xã Vĩnh Lộc B, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(18, 'Võ Thuý Diễm', '18-05-2003', '', 'Nữ', 'D7/11 Liên ấp 2-3-4, ấp 4, Xã Vĩnh Lộc A, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(19, 'Nguyễn Hoàng Khánh Duy', '07-03-2003', '', 'Nam', 'A5/15 ấp 1, Xã Bình Chánh, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(20, 'Nguyễn Thị Mỹ Duyên', '07-07-2003', '', 'Nữ', 'Số 524 Đường Võ Văn Vân, ấp 2, Xã Vĩnh Lộc B, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(21, 'Lê Thị Tuyết Đào', '06-12-2003', '', 'Nữ', 'Số B2/26 đường Mai Bá Hương, ấp 2, Xã Lê Minh Xuân, Huyện Bình Chánh, TP Hồ Chí Minh', '', '', 1),
(22, 'Nguyễn Võ Hải Đăng', '10-09-2003', '', 'Nam', 'Số 28 Đường số 24, Khu dân cư Him Lam 6A, Ấp 4, Xã Bình Hưng, Huyện Bình Chánh, Thành phố Hồ Chí Minh', '', '', 1),
(23, 'Nguyễn Hoàng Hải Đông', '07-11-2003', '', 'Nam', 'D8/40D Đoàn Nguyễn Tuấn, Xã Hưng Long, Huyện Bình Chánh, Thành phố Hồ Chí Minh', '', '', 1),
(24, 'Lê Dương Hồng Hạnh', '05-11-2003', '', 'Nữ', 'B7/27W Liên Ấp 2.6, Xã Vĩnh Lộc A, Huyện Bình Chánh, Thành phố Hồ Chí Minh', '', '', 1),
(25, 'Lê Dương Hồng Hạnh', '05-11-2003', '', 'Nữ', 'C7/13AB16 Phạm Hùng, Xã Bình Hưng, Huyện Bình Chánh, Thành phố Hồ Chí Minh', '', '', 1),
(26, 'Nguyễn Lê Thúy Hằng', '20-11-2003', '', 'Nữ', 'E10/300 Ấp 5, Xã Đa Phước, Huyện Bình Chánh, Thành phố Hồ Chí Minh', '', '', 1),
(28, 'Nguyễn Trung Hiếu', '02-12-2003', '', 'Nam', 'E2/6F2 Ấp 5 Đường Thới Hòa, Xã Vĩnh Lộc A, Huyện Bình Chánh, Thành phố Hồ Chí Minh', '', '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `hocsinh_lophoc`
--

DROP TABLE IF EXISTS `hocsinh_lophoc`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
CREATE TABLE IF NOT EXISTS `lop` (
  `idLop` int(11) NOT NULL AUTO_INCREMENT,
  `TenLop` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Khoi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `TinhTrang` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idLop`),
  UNIQUE KEY `TenLop` (`TenLop`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lop`
--

INSERT INTO `lop` (`idLop`, `TenLop`, `Khoi`, `TinhTrang`) VALUES
(17, '10A1', '10', 1),
(18, '10A2', '10', 1),
(19, '10A3', '10', 1),
(20, '10A4', '10', 1),
(21, '11A1', '11', 1),
(22, '11A2', '11', 1),
(23, '11A3', '11', 1),
(24, '12A1', '12', 1),
(25, '12A2', '12', 1);

-- --------------------------------------------------------

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE IF NOT EXISTS `monhoc` (
  `idMonHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenMH` varchar(45) CHARACTER SET utf8 NOT NULL,
  `heSo` int(3) NOT NULL DEFAULT '1',
  `dangGiangDay` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMonHoc`),
  UNIQUE KEY `TenMH` (`TenMH`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `monhoc`
--

INSERT INTO `monhoc` (`idMonHoc`, `TenMH`, `heSo`, `dangGiangDay`) VALUES
(8, 'Toán', 1, 1),
(9, 'Lý', 1, 1),
(10, 'Hóa', 1, 1),
(11, 'Sinh', 1, 1),
(12, 'Sử', 1, 1),
(13, 'Địa', 1, 1),
(14, 'Văn', 1, 1),
(16, 'Đạo đức', 1, 1),
(17, 'Thể dục', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `namhoc`
--

DROP TABLE IF EXISTS `namhoc`;
CREATE TABLE IF NOT EXISTS `namhoc` (
  `idNamHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenNamHoc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idNamHoc`),
  UNIQUE KEY `TenNamHoc` (`TenNamHoc`),
  UNIQUE KEY `TenNamHoc_2` (`TenNamHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `namhoc`
--

INSERT INTO `namhoc` (`idNamHoc`, `TenNamHoc`) VALUES
(3, '2018-2019'),
(4, '2019-2020');

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
  `Sdt` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idNguoiDung`),
  UNIQUE KEY `TenTaiKhoan` (`TenTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`idNguoiDung`, `HoTen`, `TenTaiKhoan`, `MatKhau`, `LoaiNguoiDung`, `TinhTrang`, `Sdt`, `Email`) VALUES
(1, 'Kim Ji Won', 'won', 'e10adc3949ba59abbe56e057f20f883e', 1, 1, NULL, NULL),
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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
