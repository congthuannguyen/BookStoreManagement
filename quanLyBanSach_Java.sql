
-- NHÓM: QNHAT -----------------------------------------------------------------------------------------------
-- Thành Viên:
			-- Nguyễn Công Thuận
			-- Đoàn Ngọc Phú Quốc
			-- Đỗ Hồng Ân
			-- Đặng Chí Hiếu 
			-- Trương Quang Nhật

CREATE DATABASE ManageBooks_Java
GO
USE ManageBooks_Java
GO

-- Tạo bảng NhaXuatBan
CREATE TABLE tblNhaXuatBan
(
	maNXB	varchar(15) not null primary key,
	tenNXB	nvarchar(100) not null,
	diaChiNXB	nvarchar(100) not null,
	dienThoai	varchar(11)	not null check(dienThoai like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or dienThoai like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	deleted int null
)
GO
INSERT INTO tblNhaXuatBan (maNXB, tenNXB, diaChiNXB, dienThoai)
	VALUES ('123',N'Cần Thơ',N'Cần Thơ','0987535168');
GO
-- Tạo bảng PhieuNhap
CREATE TABLE tblPhieuNhap
(
	soPN	varchar(15) not null primary key,
	ngayNhap	varchar(50) not null,
	maNXB	varchar(15) not null foreign key references tblNhaXuatBan(maNXB)
)
GO
INSERT INTO tblPhieuNhap
	VALUES	('76','01/01/2021','123');
GO
-- Tạo bảng DanhMuc
CREATE TABLE tblDanhMuc
(
	maDM	varchar(15) not null primary key,
	tenDM	nvarchar(100) not null,
	deleted	int null
)
GO
INSERT INTO tblDanhMuc (maDM, tenDM)
	VALUES	('98762', N'Sách Bán Chạy'),
			('78888',N'Sách Văn Học Trong Nước'),
			('63435',N'Sách Thiếu Nhi'),
			('65467',N'Sách Chuyên Ngành'),
			('12651',N'Sách Mới Ra Mắt');
GO
-- Tạo bảng TacGia
CREATE TABLE tblTacGia
(
	maTG	varchar(15) not null primary key,
	tenTG	nvarchar(100) not null,
	lienLac	nvarchar(100) null,
	deleted int null
)
GO
INSERT INTO tblTacGia (maTG, tenTG, lienLac)
	VALUES	('2341',N'Nguyễn Văn A',N'Quảng Nam'),
			('8768',N'Trần Thị CC',N'Hà Nội'),
			('9159',N'Lê Lý Trần Anh',N'TP. Hồ Chí Minh'),
			('77772',N'Hoàng Văn Công',N'Đà Nẵng');
GO
-- Tạo bảng Sach
CREATE TABLE tblSach
(
	maSach	varchar(15) not null primary key,
	tenSach	nvarchar(100) not null,
	soLuongTon	int not null default 0 check(soLuongTon >= 0),
	maDM varchar(15) not null foreign key references tblDanhMuc(maDM),
	maTG	varchar(15) not null foreign key references tblTacGia(maTG),
	giaBan	money not null,
	deleted	int null
)
GO
INSERT INTO tblSach (maSach, tenSach, soLuongTon, maDM, maTG, giaBan)
	VALUES	('49124',N'Con Đường Băng',54,'98762','8768',73746),
			('47114',N'Xác Suất Thống Kê',9,'65467','77772',98725);
GO
-- Tạo bảng HinhAnh
CREATE TABLE tblHinhAnh
(
	maHA	nvarchar(15) not null,
	maSach varchar(15) not null foreign key references tblSach(maSach),
	hinhAnh	image null,
		PRIMARY KEY (maHA, maSach)
)
GO
-- Tạo bảng ChiTietPhieuNhap
CREATE TABLE tblChiTietPhieuNhap
(
	maSach varchar(15) not null foreign key references tblSach(maSach),
	soPN	varchar(15) not null foreign key references tblPhieuNhap(soPN),
	soLuongNhap	int not null default 0 check(soLuongNhap >= 0),
	giaNhap	money not null default 0 check(giaNhap >= 0),
		PRIMARY KEY (maSach,soPN)
)
GO
INSERT INTO tblChiTietPhieuNhap
	VALUES	('49124','76','45',8756546742);
GO
-- Tạo bảng KhachHang
CREATE TABLE tblKhachHang
(
	maKH	varchar(15) not null primary key,
	tenKH	nvarchar(100) not null,
	diaChiKH	nvarchar(100) not null,
	dienThoai	varchar(11)	not null check(dienThoai like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or dienThoai like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Email	varchar(100) not null check(Email like '[a-z]%@%'),
	soDuTaiKhoan money not null default 0 check(soDuTaiKhoan >= 0)
)
GO
INSERT INTO tblKhachHang
	VALUES ('98765',N'Nguyên Lê Linh', N'Quảng Nam','0475748444','thuan@gmail.com',5465437),
			('91113',N'Văn Ngọc Thuận', N'Quảng Trị','0999999999','thinh@gmail.com',1243246);
GO
-- Tạo bản NhanVien
CREATE TABLE tblNhanVien
(
	userName	varchar(100) not null primary key,
	tenNV	nvarchar(100) not null,
	matKhau	varchar(100) not null,
	dienThoai	varchar(11)	not null check(dienThoai like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or dienThoai like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
	Email	varchar(100) not null check(Email like '[a-z]%@%'),
	gioiTinh	nvarchar(5)	not null,
	DoB	varchar(15) not null,
	chucVu varchar(30) not null check(chucVu in ('Admin',N'NV Bán Hàng')),
	soDuTaiKhoan money not null default 0 check(soDuTaiKhoan >= 0),
		UNIQUE(userName)
)
GO
INSERT INTO tblNhanVien
	VALUES	('admim',N'Admin','123123','0782019606','congThuan701@gmail.com','Nam','23/07/2001','Admin',48732645);
GO
-- Tạo bảng HoaDon
CREATE TABLE tblHoaDon
(
	soHD	varchar(15) not null primary key,
	maKH	varchar(15) not null foreign key references tblKhachHang(maKH),
	userName	varchar(100) not null foreign key references tblNhanVien(userName),
	ngayBan	varchar(50) not null
)
GO
INSERT INTO tblHoaDon
	VALUES	('5555','98765','admim','05/02/2021'),
			('5566','91113','admim','12/04/2021');
GO
-- Tạo bảng chiTietHoaDon
CREATE TABLE tblChiTietHoaDon
(
	maSach varchar(15) not null foreign key references tblSach(maSach),
	soHD	varchar(15) not null foreign key references tblHoaDon(soHD),
	soLuongBan	int not null default 0 check (soLuongBan >= 0),
		PRIMARY KEY (maSach,soHD)
)
GO
INSERT INTO tblChiTietHoaDon
	VALUES	('47114','5555',3),
			('49124','5566',5);