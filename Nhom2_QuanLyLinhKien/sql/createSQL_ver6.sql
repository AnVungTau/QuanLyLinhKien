create database QLLinhKien
go
USE [QLLinhKien]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--- Function 
CREATE FUNCTION AUTO_maKh()
RETURNS [VARCHAR](6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT(maKh) FROM KhachHang) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maKh, 4)) FROM KhachHang
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'KH000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'KH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 and @ID < 999 THEN 'KH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 999 THEN 'KH' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
CREATE FUNCTION AUTO_maHoaDon()
RETURNS [VARCHAR](10)
AS
BEGIN
	DECLARE @ID VARCHAR(10)
	IF (SELECT COUNT(maHoaDon) FROM HoaDon) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maHoaDon, 8)) FROM HoaDon
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HD0000000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'HD000000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 and @ID < 999 THEN 'HD00000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 999 and @ID < 9999 THEN 'HD0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9999 and @ID < 99999 THEN 'HD0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99999 and @ID < 999999 THEN 'HD00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 999999 and @ID < 9999999 THEN 'HD0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9999999 THEN 'HD' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
CREATE FUNCTION AUTO_maChiTietHD()
RETURNS [VARCHAR](10)
AS
BEGIN
	DECLARE @ID VARCHAR(10)
	IF (SELECT COUNT(maChiTietHD) FROM ChiTietHoaDon) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maChiTietHD, 6)) FROM ChiTietHoaDon
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'CTHD00000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'CTHD0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 and @ID < 999 THEN 'CTHD000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 999 and @ID < 9999 THEN 'CTHD00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9999 and @ID < 99999 THEN 'CTHD0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99999 THEN 'CTHD' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
CREATE FUNCTION AUTO_maLoaiLinhKien()
RETURNS [VARCHAR](7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT(maLoai) FROM LoaiLinhKien) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maLoai, 3)) FROM LoaiLinhKien
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'LLK_00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'LLK_0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 THEN 'LLK_' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
CREATE FUNCTION AUTO_maLinhKien()
RETURNS [VARCHAR](6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT(maLk) FROM LinhKien) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maLk, 4)) FROM LinhKien
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'LK000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'LK00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 and @ID < 999 THEN 'LK0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 999 THEN 'LK' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
GO
CREATE FUNCTION AUTO_maNhaCungCap()
RETURNS [VARCHAR](6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT(maNhaCungCap) FROM NhaCungCap) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maNhaCungCap, 2)) FROM NhaCungCap
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NCC_0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NCC_' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END

GO
CREATE FUNCTION AUTO_maNhanVien()
RETURNS [VARCHAR](6)
AS
BEGIN
	DECLARE @ID VARCHAR(6)
	IF (SELECT COUNT(maNv) FROM NhanVien) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT(maNv, 3)) FROM NhanVien
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NV_00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 and @ID < 99 THEN 'NV_0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 99 THEN 'NV_' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END


--- Create table 
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maChiTietHD] [varchar](10) NOT NULL,
	[maLk] [varchar](6) NOT NULL,
	[tenLk] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[mucGiamGia] [float] NULL,	
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maChiTietHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [varchar](10) NOT NULL,
	[maKh] [varchar](8) NOT NULL,
	[maNv] [varchar](6) NOT NULL,
	[tenKh] [nvarchar](50) NOT NULL,
	[tenNv] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NULL,
	[ngayLapHoaDon] [date] NULL,
	[trangThaiThanhToan] [bit] NOT NULL,
	[maChiTietHD] [varchar](10) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKh] [varchar](8) NOT NULL,
	[tenKh] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[sdt] [int] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LinhKien]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LinhKien](
	[maLk] [varchar](6) NOT NULL,
	[tenLk] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[ngaySx] [date] NULL,
	[gia] [float] NOT NULL,
	[chiTietLk] [nvarchar](MAX) NULL,
	[maNhaCungCap] [varchar](6) NOT NULL,
	[maLoai] [varchar](7) NOT NULL,
 CONSTRAINT [PK_LinhKien] PRIMARY KEY CLUSTERED 
(
	[maLk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiLinhKien]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiLinhKien](
	[maLoai] [varchar](7) NOT NULL,
	[tenLoai] [nvarchar](50) NOT NULL,
	[soLuongLinhKien] [int] NOT NULL,
 CONSTRAINT [PK_LoaiLinhKien] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [varchar](6) NOT NULL,
	[tenNhaCungCap] [nvarchar](100) NOT NULL,
	[diaChi] [nvarchar](500) NOT NULL,
	[soLuongSp] [int] NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNv] [varchar](6) NOT NULL,
	[tenNv] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[namSinh] [date] NOT NULL,
	[sdt] [varchar](10) NULL,
	[diaChi] [nvarchar](50) NULL,
	[chucVu] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/1/2023 9:33:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTk] [nvarchar](20) NOT NULL,
	[matKhau] [nvarchar](20) NOT NULL,
	[chucVu] [nvarchar](50) NOT NULL,
	[maNv] [varchar](6) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

--- create Foreign Key
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_LinhKien] FOREIGN KEY([maLk])
REFERENCES [dbo].[LinhKien] ([maLk])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_LinhKien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKh])
REFERENCES [dbo].[KhachHang] ([maKh])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNv])
REFERENCES [dbo].[NhanVien] ([maNv])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD  CONSTRAINT [FK_LinhKien_LoaiLinhKien] FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiLinhKien] ([maLoai])
GO
ALTER TABLE [dbo].[LinhKien] CHECK CONSTRAINT [FK_LinhKien_LoaiLinhKien]
GO
ALTER TABLE [dbo].[LinhKien]  WITH CHECK ADD  CONSTRAINT [FK_LinhKien_NhaCungCap] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
GO
ALTER TABLE [dbo].[LinhKien] CHECK CONSTRAINT [FK_LinhKien_NhaCungCap]
GO

ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_ChiTietHoaDon] FOREIGN KEY([maChiTietHD])
REFERENCES [dbo].[ChiTietHoaDon] ([maChiTietHD])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_ChiTietHoaDon]
GO

ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNv])
REFERENCES [dbo].[NhanVien] ([maNv])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
--------------------------------------------------------------------------------------------------------
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ([dbo].[AUTO_maKh]()) FOR [maKh]
GO 
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ([dbo].[AUTO_maHoaDon]()) FOR [maHoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT ([dbo].[AUTO_maChiTietHD]()) FOR [maChiTietHD]
GO
ALTER TABLE [dbo].[LoaiLinhKien] ADD  DEFAULT ([dbo].[AUTO_maLoaiLinhKien]()) FOR [maLoai]
GO
ALTER TABLE [dbo].[NhaCungCap] ADD  DEFAULT ([dbo].[AUTO_maNhaCungCap]()) FOR [maNhaCungCap]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ([dbo].[AUTO_maNhanVien]()) FOR [maNv]
GO
ALTER TABLE [dbo].[LinhKien] ADD  DEFAULT ([dbo].[AUTO_maLinhKien]()) FOR [maLk]



GO 
INSERT INTO [dbo].[NhaCungCap] ( [tenNhaCungCap] , [diaChi] , [soLuongSp]) 
	VALUES (N'Linh Kiện Điện Tử ABECO ' , N'Lô số 20, KCN Quang Minh, Xã Quang Minh, H. Mê Linh,Hà Nội' , 20)
GO 
INSERT INTO [dbo].[NhaCungCap] ( [tenNhaCungCap] , [diaChi] , [soLuongSp]) 
	VALUES (N'Linh Kiện Điện Tử GENESISTEK VINA',N'Villa 596 Khu Dân Cư Lucasta Residence, Đường Liên Phường, Phường Phú Hữu, TP Thủ Đức, Tp. Hồ Chí Minh (TPHCM)' , 20)
GO
INSERT INTO [dbo].[NhaCungCap] ( [tenNhaCungCap] , [diaChi] , [soLuongSp]) 
	VALUES (N'Linh Kiện Điện Tử Minh Hà' , N'Tầng 3, Số 1, Ngõ 120 Trường Chinh, P. Phương Mai, Q. Đống Đa, Hà Nội' , 100)
GO
INSERT INTO [dbo].[LoaiLinhKien] ([tenLoai], [soLuongLinhKien])
     VALUES (N'IC', 100 )
GO
GO
INSERT INTO [dbo].[LoaiLinhKien] ([tenLoai], [soLuongLinhKien])
     VALUES (N'Công tắc', 10)
GO
GO
INSERT INTO [dbo].[LoaiLinhKien] ([tenLoai], [soLuongLinhKien])
     VALUES (N'Điện tro cắm', 20)
GO
GO
INSERT INTO [dbo].[LoaiLinhKien] ([tenLoai], [soLuongLinhKien])
     VALUES (N'Tụ diện dạng cắm', 10)
GO
GO
INSERT INTO [dbo].[LoaiLinhKien] ([tenLoai], [soLuongLinhKien])
     VALUES (N'Tụ điện dạng dán', 5)



GO
INSERT INTO [dbo].[LinhKien] ([tenLk] ,[soLuong] ,[ngaySx]  ,[gia] ,[chiTietLk] ,[maNhaCungCap] ,[maLoai])
	VALUES ('CD4013BE' ,5 ,'2022-07-11'  ,10000 
	,'The flip flop is packaged in a case of 14-DIP (0.300, 7.62mm). A package named Tubeincludes it. The output it is configured with uses Differential. The trigger configured with it uses Positive Edge. Through Holeis in the way of this electric part. With a supply voltage of 3V~18V volts, it operates. It is operating at a temperature of -55°C~125°C TA. Logic flip flops of this type are classified as D-Type. JK flip flop belongs to the 4000Bseries of FPGAs. This D flip flop should not have a frequency greater than 24MHz. It consumes 4μA of quiescent A total of 14 terminations have been made. This D latch belongs to the family of CD4013. The power source is powered by 5V. The input capacitance of this JK flip flopis 5pF farads. This electronic part is mounted in the way of Through Hole. The electronic flip flop is designed with pins 14. This device''s clock edge trigger type is Positive Edge. The part you are looking for is included in FF/Latches. Normal operation requires a supply voltage (Vsup) above 3V. Optimal efficiency requires a supply voltage of 10V. It offers maximum design flexibility with its output current of 6.8mA. It has 1 output lines to operate. In terms of quiescent current, it consumes 20μA . A total of 2 channels are available.' 
	,'NCC_01' ,'LLK_001')
GO
INSERT INTO [dbo].[LinhKien] ([tenLk] ,[soLuong] ,[ngaySx]  ,[gia] ,[chiTietLk] ,[maNhaCungCap] ,[maLoai])
	VALUES ('LM317T' ,10 ,'2022-07-11'  ,10000 
	,'DESCRIPTION
The LM317 is an adjustable 3-terminal positive voltage regulator, designed to supply 1A of output current with voltage adjustable from 1.3V ~ 37V.

FEATURES
● Typical 1% Output Voltage Tolerance
● Output voltage adjustable from 1.3V ~ 37V
● Output current in excess of 1A
● Internal short circuit protection
● Internal over temperature protection
● Output transistor safe area compensation

APPLICATIONS
● PC Motherboard
● LCD Monitor
● Graphic Card
● DVD Player
● Network Interface Card/Switch
● Telecom Equipment
● Printer and other Peripheral Equipment'
	,'NCC_01' ,'LLK_001')
GO
INSERT INTO [dbo].[LinhKien] ([tenLk] ,[soLuong] ,[ngaySx]  ,[gia] ,[chiTietLk] ,[maNhaCungCap] ,[maLoai])
	VALUES ('SWTA7722-L' ,5 ,'2022-07-11'  ,10000 
	,''
	,'NCC_01' ,'LLK_002')
GO
INSERT INTO [dbo].[LinhKien] ([tenLk] ,[soLuong] ,[ngaySx]  ,[gia] ,[chiTietLk] ,[maNhaCungCap] ,[maLoai])
	VALUES ('Aluminum Housed MH' ,5 ,'2022-07-11'  ,10000 
	,'Brand: LION
Series: MH,MV,GH,AH,AS Series
Spec./Size: 50W~1000W
Working temperature: -55ºC~+250ºC​
Standard package: 1000PCS/BOX
ROHS status: ROHS
Standard Value: 0.001Ω~30KΩ'
	,'NCC_01' ,'LLK_003')
GO