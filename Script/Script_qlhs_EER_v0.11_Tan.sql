-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th6 11, 2019 lúc 03:53 PM
-- Phiên bản máy phục vụ: 5.7.26
-- Phiên bản PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlyhocsinh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cauhinh`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiet_cauhinh_diem`
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
-- Cấu trúc bảng cho bảng `chitiet_cauhinh_hocsinh`
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
-- Cấu trúc bảng cho bảng `chitiet_cauhinh_lop`
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
-- Cấu trúc bảng cho bảng `diem`
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='		';

--
-- Đang đổ dữ liệu cho bảng `diem`
--

INSERT INTO `diem` (`idDiem`, `Diem15Phut`, `Diem1Tiet`, `DiemCuoiKy`, `idHocSinhLopHoc`, `idHocKy`, `idMonHoc`) VALUES
(10, 10, 1, 1, 1, 1, 2),
(16, 9.1, 4.2, 4, 7, 1, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocky`
--

DROP TABLE IF EXISTS `hocky`;
CREATE TABLE IF NOT EXISTS `hocky` (
  `idHocKy` int(11) NOT NULL AUTO_INCREMENT,
  `TenHocKy` int(11) NOT NULL,
  PRIMARY KEY (`idHocKy`),
  UNIQUE KEY `NamHoc` (`TenHocKy`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocky`
--

INSERT INTO `hocky` (`idHocKy`, `TenHocKy`) VALUES
(1, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocsinh`
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocsinh`
--

INSERT INTO `hocsinh` (`idHocSinh`, `HoTen`, `NgaySinh`, `Email`, `GioiTinh`, `DiaChi`, `sdtCaNhan`, `sdtGiamHo`, `TinhTrang`) VALUES
(1, 'Nguyễn Văn A', '2013-10-18', '', 'nam', '18 Đặng Văn Kiêu, P4, Quận Ảo Tưởng', NULL, NULL, 1),
(2, 'Nguyễn Thị B', '2003-08-22', '', 'nữ', '25 Trần Hửu Ngợi, P9, Quận Dị', NULL, NULL, 2),
(3, 'Hoàng Văn C', '2003-08-22', '', 'nam', '19 Trần Gời, P5, Quận B', NULL, NULL, 2),
(4, 'Phan Hồng D', '2003-10-10', '', 'nữ', '56 Phạm Hồng, P8, Quận Ba Chuẩn', NULL, NULL, 3),
(5, 'Nguyễn Thanh X', '2003-08-22', '', 'nam', '45 Hồng F, P6, Quận Ba Chửn', NULL, NULL, 4),
(6, 'Mai Hồng A', '2003-07-23', '', 'nữ', '56 Lại H, P3, Quận H', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocsinh_lophoc`
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hocsinh_lophoc`
--

INSERT INTO `hocsinh_lophoc` (`idHocSinhLopHoc`, `idHocSinh`, `idLopHoc`, `idNamHoc`) VALUES
(1, 1, 1, 1),
(7, 2, 1, 1),
(8, 3, 2, 1),
(11, 3, 10, 2),
(10, 5, 5, 1),
(9, 6, 4, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

DROP TABLE IF EXISTS `lop`;
CREATE TABLE IF NOT EXISTS `lop` (
  `idLop` int(11) NOT NULL AUTO_INCREMENT,
  `TenLop` varchar(45) CHARACTER SET utf8 NOT NULL,
  `Khoi` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `TinhTrang` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idLop`),
  UNIQUE KEY `TenLop` (`TenLop`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lop`
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
(15, '12A5', '12', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
CREATE TABLE IF NOT EXISTS `monhoc` (
  `idMonHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenMH` varchar(45) CHARACTER SET utf8 NOT NULL,
  `heSo` int(3) NOT NULL DEFAULT '1',
  `dangGiangDay` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMonHoc`),
  UNIQUE KEY `TenMH` (`TenMH`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
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
-- Cấu trúc bảng cho bảng `namhoc`
--

DROP TABLE IF EXISTS `namhoc`;
CREATE TABLE IF NOT EXISTS `namhoc` (
  `idNamHoc` int(11) NOT NULL AUTO_INCREMENT,
  `TenNamHoc` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idNamHoc`),
  UNIQUE KEY `TenNamHoc` (`TenNamHoc`),
  UNIQUE KEY `TenNamHoc_2` (`TenNamHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `namhoc`
--

INSERT INTO `namhoc` (`idNamHoc`, `TenNamHoc`) VALUES
(2, '2017-2018'),
(1, '2018-2019');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`idNguoiDung`, `HoTen`, `TenTaiKhoan`, `MatKhau`, `LoaiNguoiDung`, `TinhTrang`, `Sdt`, `Email`) VALUES
(1, 'Kim Ji Won', 'won', '123357df09673b8943afb057783321e0', 1, 1, NULL, NULL),
(2, 'asd', 'asddd', '123', 0, 0, '', ''),
(3, 'asdddd', 'dddddd', '1234', 0, 0, '', ''),
(4, 'assdddd', 'asdddd', '81dc9bdb52d04dc20036dbd8313ed055', 0, 0, '', ''),
(5, '123aaaa', 'aaaaaaa', '202cb962ac59075b964b07152d234b70', 0, 0, '', '');

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiet_cauhinh_diem`
--
ALTER TABLE `chitiet_cauhinh_diem`
  ADD CONSTRAINT `fk_Diem_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Diem_has_CauHinh_Diem1` FOREIGN KEY (`idDiem`) REFERENCES `diem` (`idDiem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `chitiet_cauhinh_hocsinh`
--
ALTER TABLE `chitiet_cauhinh_hocsinh`
  ADD CONSTRAINT `fk_HocSinh_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_HocSinh_has_CauHinh_HocSinh1` FOREIGN KEY (`idHocSinh`) REFERENCES `hocsinh` (`idHocSinh`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `chitiet_cauhinh_lop`
--
ALTER TABLE `chitiet_cauhinh_lop`
  ADD CONSTRAINT `fk_Lop_has_CauHinh_CauHinh1` FOREIGN KEY (`idCauHinh`) REFERENCES `cauhinh` (`idCauHinh`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Lop_has_CauHinh_Lop1` FOREIGN KEY (`idLop`) REFERENCES `lop` (`idLop`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `diem_ibfk_1` FOREIGN KEY (`idHocKy`) REFERENCES `hocky` (`idHocKy`),
  ADD CONSTRAINT `diem_ibfk_2` FOREIGN KEY (`idHocSinhLopHoc`) REFERENCES `hocsinh_lophoc` (`idHocSinhLopHoc`),
  ADD CONSTRAINT `diem_ibfk_3` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`);

--
-- Các ràng buộc cho bảng `hocsinh_lophoc`
--
ALTER TABLE `hocsinh_lophoc`
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_1` FOREIGN KEY (`idHocSinh`) REFERENCES `hocsinh` (`idHocSinh`),
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_2` FOREIGN KEY (`idLopHoc`) REFERENCES `lop` (`idLop`),
  ADD CONSTRAINT `hocsinh_lophoc_ibfk_3` FOREIGN KEY (`idNamHoc`) REFERENCES `namhoc` (`idNamHoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
