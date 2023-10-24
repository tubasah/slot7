USE [master]
GO
/****** Object:  Database [SWP391]    Script Date: 22/10/2023 6:39:52 CH ******/
CREATE DATABASE [SWP391]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SWP391', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.HANI\MSSQL\DATA\SWP391.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SWP391_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.HANI\MSSQL\DATA\SWP391_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [SWP391] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SWP391].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SWP391] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SWP391] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SWP391] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SWP391] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SWP391] SET ARITHABORT OFF 
GO
ALTER DATABASE [SWP391] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SWP391] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SWP391] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SWP391] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SWP391] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SWP391] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SWP391] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SWP391] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SWP391] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SWP391] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SWP391] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SWP391] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SWP391] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SWP391] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SWP391] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SWP391] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SWP391] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SWP391] SET RECOVERY FULL 
GO
ALTER DATABASE [SWP391] SET  MULTI_USER 
GO
ALTER DATABASE [SWP391] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SWP391] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SWP391] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SWP391] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SWP391] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SWP391] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'SWP391', N'ON'
GO
ALTER DATABASE [SWP391] SET QUERY_STORE = OFF
GO
USE [SWP391]
GO
/****** Object:  Table [dbo].[AppUser]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AppUser](
	[id] [uniqueidentifier] NOT NULL,
	[name] [nvarchar](200) NULL,
	[password] [nvarchar](200) NULL,
	[email] [nvarchar](255) NULL,
	[number] [nvarchar](200) NULL,
	[role_id] [int] NULL,
	[image] [nvarchar](max) NULL,
	[fullName] [nvarchar](100) NULL,
	[gender] [nvarchar](10) NULL,
	[statusNow] [nvarchar](50) NULL,
	[school] [nvarchar](100) NULL,
	[favour] [nvarchar](100) NULL,
	[bio] [nvarchar](max) NULL,
 CONSTRAINT [PK__AppUser__3213E83FF445C707] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[feedBack_id] [uniqueidentifier] NOT NULL,
	[rated_star] [float] NULL,
	[feedback] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[status] [bit] NULL,
	[product_id] [uniqueidentifier] NULL,
	[userId] [uniqueidentifier] NULL,
	[date] [datetime] NULL,
 CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED 
(
	[feedBack_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[id] [uniqueidentifier] NOT NULL,
	[customer_id] [uniqueidentifier] NULL,
	[seller_id] [uniqueidentifier] NULL,
	[fullname] [nvarchar](max) NULL,
	[phone] [nvarchar](max) NULL,
	[order_total] [decimal](10, 2) NULL,
	[order_date] [date] NULL,
	[order_town] [nvarchar](200) NULL,
	[order_location] [nvarchar](200) NULL,
	[status] [nvarchar](max) NULL,
	[stt] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK__Customer__3213E83FFAA05241] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[id] [uniqueidentifier] NOT NULL,
	[order_id] [uniqueidentifier] NULL,
	[product_id] [uniqueidentifier] NULL,
	[quantity] [int] NULL,
	[price] [int] NOT NULL,
 CONSTRAINT [PK__OrderIte__3213E83FF2231EE5] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductCategory]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductCategory](
	[id] [uniqueidentifier] NOT NULL,
	[type] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductInfo]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductInfo](
	[product_id] [uniqueidentifier] NOT NULL,
	[seller_id] [uniqueidentifier] NULL,
	[type_id] [uniqueidentifier] NULL,
	[product_name] [nvarchar](200) NULL,
	[product_image] [nvarchar](max) NOT NULL,
	[product_available] [int] NULL,
	[product_sales] [int] NULL,
	[product_price] [decimal](10, 2) NULL,
	[product_voucher] [decimal](10, 2) NULL,
	[product_description] [nvarchar](max) NULL,
 CONSTRAINT [PK__ProductI__3213E83F81EA1832] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[requestSetRole]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[requestSetRole](
	[id] [uniqueidentifier] NOT NULL,
	[user_id] [uniqueidentifier] NULL,
	[email] [nvarchar](255) NULL,
	[fullName] [nvarchar](200) NULL,
	[shopName] [nvarchar](200) NULL,
	[commoditiesSector] [nvarchar](200) NULL,
	[address] [nvarchar](200) NULL,
	[phone] [nvarchar](200) NULL,
	[status] [nvarchar](200) NULL,
 CONSTRAINT [PK__requestS__3213E83F718D8C48] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShopComment]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShopComment](
	[id] [uniqueidentifier] NOT NULL,
	[product_id] [uniqueidentifier] NULL,
	[commentor_id] [uniqueidentifier] NULL,
	[comment_content] [nvarchar](max) NULL,
	[comment_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShopLike]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShopLike](
	[id] [uniqueidentifier] NOT NULL,
	[product_id] [uniqueidentifier] NULL,
	[liker_id] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShoppingCart]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShoppingCart](
	[id] [uniqueidentifier] NOT NULL,
	[user_id] [uniqueidentifier] NULL,
	[cart_quantity] [int] NULL,
	[cart_total] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ShoppingCartItem]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ShoppingCartItem](
	[id] [uniqueidentifier] NOT NULL,
	[cart_id] [uniqueidentifier] NULL,
	[product_id] [uniqueidentifier] NULL,
	[item_quantity] [int] NULL,
	[item_subtotal] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SocialComment]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SocialComment](
	[id] [uniqueidentifier] NOT NULL,
	[post_id] [uniqueidentifier] NULL,
	[commentor_id] [uniqueidentifier] NULL,
	[comment_content] [nvarchar](max) NULL,
	[comment_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SocialLike]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SocialLike](
	[id] [uniqueidentifier] NOT NULL,
	[post_id] [uniqueidentifier] NULL,
	[liker_id] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserFollow]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserFollow](
	[id] [uniqueidentifier] NOT NULL,
	[follower_id] [uniqueidentifier] NULL,
	[following_id] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserMessage]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserMessage](
	[id] [uniqueidentifier] NOT NULL,
	[sender_id] [uniqueidentifier] NULL,
	[receiver_id] [uniqueidentifier] NULL,
	[context] [nvarchar](max) NULL,
	[message_date] [datetime] NULL,
 CONSTRAINT [PK__UserMess__3213E83FF2A55861] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserNotification]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserNotification](
	[id] [uniqueidentifier] NOT NULL,
	[user_id] [uniqueidentifier] NULL,
	[notification_content] [nvarchar](max) NULL,
	[notification_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserPost]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserPost](
	[id] [uniqueidentifier] NOT NULL,
	[user_id] [uniqueidentifier] NULL,
	[post_title] [nvarchar](200) NULL,
	[post_content] [nvarchar](max) NULL,
	[post_image] [nvarchar](255) NULL,
	[post_date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 22/10/2023 6:39:52 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[id] [int] NOT NULL,
	[role] [nvarchar](200) NULL,
 CONSTRAINT [PK_UserRole] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'59b5896f-98b2-4699-82ec-1b8b99cebcb2', N'admin', N'admin', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'trngchnii', N'123456', N'nitnhde160262@fpt.edu.vn', N'0705355331', 3, N'SavedImages/366138678_622236543225698_8733882307654270103_n.jpg', N'Trịnh Ngọc Hàn Ni', N'nÃ¡Â»Â¯', N'cjskds', N'dsda', N'dsad', N'ÃÂ¡ÃÂ')
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', N'Cap', N'cap', N'asdf@gmail.com', N'', 2, N'SavedImages/366138678_622236543225698_8733882307654270103_n.jpg', N'', N'', N'', N'', N'', N'')
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'3393c2bb-1630-4184-ad67-9a789cf770de', N'asd', N'vinh', N'asdf@gmail.com', N'12334532', 2, NULL, N'Đinh Quang Vinh', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'e19ab04d-0ffa-4272-ac2a-a6323338adb2', N'hanni59', N'1234567', N'ni.trnh59@gmail.com', NULL, 3, NULL, N'Đinh Quang Vinh', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'BigBoss', N'vinh', N'gogogogo1303@gmail.com', N'12334532', 2, NULL, N'Đinh Quang Vinh', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'1c3ed8de-da68-4d11-8fae-c0469d89ede1', N'hanni', N'123456', N'ni.trnh@gmail.com', NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[AppUser] ([id], [name], [password], [email], [number], [role_id], [image], [fullName], [gender], [statusNow], [school], [favour], [bio]) VALUES (N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'Gau', N'password123', N'a@gmail.com', N'123456', 3, N'SavedImages/Screenshot 2023-09-07 200157.png', N'', N'', N'', N'', N'', N'')
GO
INSERT [dbo].[Feedback] ([feedBack_id], [rated_star], [feedback], [image], [status], [product_id], [userId], [date]) VALUES (N'fd9a34a3-205b-4051-b14f-421ef9f4a022', 4, N'very good', N'setofshop\img\ao.png', NULL, N'9714198a-d7bb-41cf-a694-1978358dedc6', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', CAST(N'2023-10-17T01:32:38.360' AS DateTime))
INSERT [dbo].[Feedback] ([feedBack_id], [rated_star], [feedback], [image], [status], [product_id], [userId], [date]) VALUES (N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', 3, N'rất đẹp', N'setofshop\img\ao.png', NULL, N'9714198a-d7bb-41cf-a694-1978358dedc6', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', CAST(N'2023-10-14T20:20:11.987' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'dbb30e9a-4439-4963-9363-3bfa9d47da12', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(806000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Đà Nẵng', N'207 Thái Văn Lung', N'Cho van chuyen', 5)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'acbb0e37-b3f5-4f9a-be21-4ffb9ecc72d3', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(114000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Gia Lai', N'207 Thái Văn Lung', NULL, 7)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'8407f239-8ec3-48df-a53e-6beb4dda24ce', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(135000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Hà Nội', N'sdfs', N'Cho van chuyen', 3)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'1d874289-809b-4785-985f-b82605010638', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(116000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Đà Nẵng', N'207 Thái Văn Lung, Đà  Nẵng', N'Cho van chuyen', 1)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'c5bd547f-ef16-4ce6-9622-c730c7d4812b', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(16132000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Hà Nội', N'207 Thái Văn Lung', NULL, 9)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'c8d025f6-0eb8-4be9-88c1-ca6c0c365fc0', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(135000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Hà Nội', N'207 Thái Văn Lung', NULL, 8)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'5eb52d0e-ffd0-44bc-8880-d3cb17ad915c', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'ABC', N'0705355331', CAST(378000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Hà Nội', N'207 Thái Văn Lung, Đà  Nẵng', N'Cho van chuyen', 4)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'f2ae4e4a-dcaa-443d-b21a-f9affbfba0ce', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'Trịnh Ngọc Hàn Ni', N'asdd', CAST(440000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Đà Nẵng', N'asda', N'Cho van chuyen', 2)
INSERT [dbo].[Order] ([id], [customer_id], [seller_id], [fullname], [phone], [order_total], [order_date], [order_town], [order_location], [status], [stt]) VALUES (N'6ed65f95-bf23-4fcf-8bbe-fe7d63f8af49', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'Trịnh Ngọc Hàn Ni', N'0705355331', CAST(16132000.00 AS Decimal(10, 2)), CAST(N'2023-10-20' AS Date), N'Đà Nẵng', N'207 Thái Văn Lung', N'Cho van chuyen', 6)
SET IDENTITY_INSERT [dbo].[Order] OFF
GO
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'7412a23e-0c28-4199-98da-1bd6caed5a7f', N'dbb30e9a-4439-4963-9363-3bfa9d47da12', N'98c51e91-41f4-48ad-96f4-c3b81ecd858e', 1, 690000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'e3630e13-7362-490a-8ed8-26c744330a34', N'6ed65f95-bf23-4fcf-8bbe-fe7d63f8af49', N'658b8b30-49b1-4a21-9c83-613e63ef177e', 1, 16097000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'9b4ad0ee-ff7b-4f92-bf75-4c710e142f5f', N'5eb52d0e-ffd0-44bc-8880-d3cb17ad915c', N'9714198a-d7bb-41cf-a694-1978358dedc6', 3, 81000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'b7615393-fee3-45f3-8986-4dc4c65969a6', N'c5bd547f-ef16-4ce6-9622-c730c7d4812b', N'658b8b30-49b1-4a21-9c83-613e63ef177e', 1, 16097000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'8b9ecf1a-1724-427e-af42-5784ab122146', N'f2ae4e4a-dcaa-443d-b21a-f9affbfba0ce', N'9714198a-d7bb-41cf-a694-1978358dedc6', 5, 81000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'bbb01a50-b843-4c0e-820b-7a4533e52966', N'1d874289-809b-4785-985f-b82605010638', N'9714198a-d7bb-41cf-a694-1978358dedc6', 1, 81000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'10e5afcb-764d-4cc7-afe5-9d17b3176531', N'8407f239-8ec3-48df-a53e-6beb4dda24ce', N'151a571e-2d2e-40c1-a15f-3fba1e5fb897', 1, 100000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'51c3e1d4-eb8c-40fc-80f1-a318a17e993c', N'5eb52d0e-ffd0-44bc-8880-d3cb17ad915c', N'151a571e-2d2e-40c1-a15f-3fba1e5fb897', 1, 100000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'7627eea0-e05d-4d62-97c5-c430adbd7fae', N'c8d025f6-0eb8-4be9-88c1-ca6c0c365fc0', N'151a571e-2d2e-40c1-a15f-3fba1e5fb897', 1, 100000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'525ac398-383f-41b0-8f22-e80a1a7f81d3', N'dbb30e9a-4439-4963-9363-3bfa9d47da12', N'9714198a-d7bb-41cf-a694-1978358dedc6', 1, 81000)
INSERT [dbo].[OrderDetail] ([id], [order_id], [product_id], [quantity], [price]) VALUES (N'0bc08586-69f4-4530-ace7-ea686fd4ba88', N'acbb0e37-b3f5-4f9a-be21-4ffb9ecc72d3', N'16f62431-0913-42ea-ab7f-5943de81d86f', 1, 79000)
GO
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'32de7141-e052-4591-a103-2f5f544e01e0', N'Bách hoá online')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'467e803a-426e-441d-8db8-669ae23a3469', N'Điện thoại & Phụ kiện')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'eecbd3f1-134e-43b0-a3e1-700edb72a6a4', N'Mỹ phẩm')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'9bd9c078-7e46-4ba0-be56-7223ee26608b', N'Máy ảnh & Máy quay phim')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'c9c33aeb-38f4-44a0-89b5-860ba5ae8c23', N'Máy tính & Laptop')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'2ea22aa1-2368-4742-8d96-994337ed92de', N'Đồ chơi')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Thời trang nam')
INSERT [dbo].[ProductCategory] ([id], [type]) VALUES (N'063c4ea1-948f-48ed-87da-d8c9e326f01a', N'Thời trang nữ')
GO
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'05f5e5f3-b59e-4aeb-9de6-160df06346b7', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'32de7141-e052-4591-a103-2f5f544e01e0', N'Đèn trang trí', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQizQDH8Z69ZvchKKEncx_pMs9VY6v-qTt8mA&usqp=CAU', 100, 200, CAST(459000.00 AS Decimal(10, 2)), NULL, N'Đèn trang trí LED, màu sắc đa dạng.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'9714198a-d7bb-41cf-a694-1978358dedc6', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Áo Polo Teelab Special', N'https://bizweb.dktcdn.net/100/415/697/products/1-a76844f8-43b5-4ba4-8f94-08ff2f36394a.jpg?v=1657108723990', 6, 3, CAST(81000.00 AS Decimal(10, 2)), CAST(50000.00 AS Decimal(10, 2)), N'Áo thun nam phong cách, size M, L, XL, màu sắc đa dạng.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'84077702-76ff-4ce2-b11f-1be82bc20099', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Quần jeans nam', N'https://vn-live-01.slatic.net/p/b0e47989490f904facf60daeaeb3f2a0.jpg', 100, 90, CAST(1147500.00 AS Decimal(10, 2)), NULL, N'Quần jeans nam slim fit, size 32, màu xanh đậm.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'e1acff60-41cc-42af-ac59-271adf0cece1', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'063c4ea1-948f-48ed-87da-d8c9e326f01a', N'Áo khoác nữ', N'https://athenas.vn/wp-content/uploads/2022/10/ao-khoac-nu-1.jpg', 10, 60, CAST(804500.00 AS Decimal(10, 2)), NULL, N'Áo khoác nữ phong cách, size S, M, L, màu hồng pastel.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'151a571e-2d2e-40c1-a15f-3fba1e5fb897', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Áo sơ mi nam', N'https://pos.nvncdn.net/492284-9176/ps/20230419_rgw9gKNpgq.jpeg', 17, NULL, CAST(100000.00 AS Decimal(10, 2)), NULL, N'Áo sơ mi nam ')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'f8e2489d-9c0d-4c23-a0f8-40a4b3807c87', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'467e803a-426e-441d-8db8-669ae23a3469', N'Điện thoại di động', N'https://cdn.thegioididong.com/Products/Images/42/309722/oppo-reno10-xanh-128gb-11.jpg', 50, 50, CAST(13800000.00 AS Decimal(10, 2)), NULL, N'Điện thoại di động mới nhất, màn hình 6 inch, RAM 8GB, bộ nhớ 128GB.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'16f62431-0913-42ea-ab7f-5943de81d86f', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Bóng Chày Có Mũ Trùm', N'https://cdn.yeep.vn/2023/05/a2dd2e259801fcaa0f9bc3dfd78aebfd.jpg', 9, 3, CAST(79000.00 AS Decimal(10, 2)), CAST(50000.00 AS Decimal(10, 2)), N'️️️ Kích thước: M-2XL
Màu sắc: xanh dương, trắng
Chất liệu: sợi polyester
Phiên bản: dáng rộng
Chiều dài tay áo: dài tay
Độ dày: thông thường
Độ co giãn: co giãn nhẹ
Loại quần áo: quần áo nam
Phong cách cơ bản: phiên bản Hàn Quốc
Phong cách phân khu: đơn giản và thời trang
Các dịp phù hợp: giải trí khác
Đối tượng thích hợp: thanh thiếu niên
Dành cho: unisex
Mùa phù hợp: mùa xuân và mùa thu')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'658b8b30-49b1-4a21-9c83-613e63ef177e', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'9bd9c078-7e46-4ba0-be56-7223ee26608b', N'Máy ảnh DSLR', N'https://vietthuong.vn/image/catalog/phong-thu/may-anh-dslr-3.jpg', 8, 40, CAST(16097000.00 AS Decimal(10, 2)), CAST(200000.00 AS Decimal(10, 2)), N'Máy ảnh DSLR chuyên nghiệp, cảm biến Full-frame, 24MP.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'dadc365c-f0c0-459a-9472-6f72543ec062', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Tee basic ss1 CREWZ', N'https://cf.shopee.vn/file/81db3aec45e555ada18535a4f2383b88', 10, 3, CAST(79000.00 AS Decimal(10, 2)), CAST(50000.00 AS Decimal(10, 2)), N'Áo thun nam phong cách, size M, L, XL, màu sắc đa dạng.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'b5cc10c9-8d73-46bb-b8a3-86bb8b3bcb6e', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'c9c33aeb-38f4-44a0-89b5-860ba5ae8c23', N'Máy tính xách tay', N'https://bizweb.dktcdn.net/100/410/941/products/annotation-2023-08-30-093406.jpg?v=1693362873563', 10, 30, CAST(20677000.00 AS Decimal(10, 2)), CAST(100000.00 AS Decimal(10, 2)), N'Máy tính xách tay cao cấp, CPU Core i7, màn hình 15 inch, SSD 512GB.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'f81352e2-2e8e-49b9-9ccd-918c5a95f30c', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Áo sơ mi nam', N'SavedImages/funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg', 20, NULL, CAST(200000.00 AS Decimal(10, 2)), NULL, N'funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'6d213c1e-799c-4d7d-b58d-b8bbff6b5037', NULL, NULL, N'dsada', N'funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg', 20, NULL, CAST(200000.00 AS Decimal(10, 2)), NULL, N'Áo sơ mi nam ')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'c43b7071-c972-4a1c-8865-bbe9790bb7a1', NULL, NULL, N'Áo sơ mi nam', N'funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg', 20, NULL, CAST(100000.00 AS Decimal(10, 2)), NULL, N'Áo sơ mi nam ')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'1911e6ee-9740-411e-a420-bff2b5e8e9c4', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Áo sơ mi nam', N'SavedImages/funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg', 20, NULL, CAST(690000.00 AS Decimal(10, 2)), NULL, N'funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'98c51e91-41f4-48ad-96f4-c3b81ecd858e', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Áo thun namm', N'https://aoxuanhe.com/upload/product/axh-142/ao-thun-nam-trang-cotton-cao-cap.jpg', 9, 3, CAST(690000.00 AS Decimal(10, 2)), CAST(50000.00 AS Decimal(10, 2)), N'Áo thun nam phong cách, size M, L, XL, màu sắc đa dạng.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'3bf6dc87-2692-436b-8315-c53009c6e806', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'32de7141-e052-4591-a103-2f5f544e01e0', N'Balo du lịch', N'https://tamma.vn/images/ba-lo-du-lich-co-tay-keo-co-khoa-so.jpg', 100, 120, CAST(919000.00 AS Decimal(10, 2)), CAST(15000.00 AS Decimal(10, 2)), N'Balo du lịch chất liệu chống nước, dung tích 30L.')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'213de719-bb4a-485c-9c1f-dde38e048bf7', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Quần Short unisex', N'https://img.ws.mms.shopee.vn/6331a79731c3de9fb121b4b809c17362', 10, 3, CAST(79000.00 AS Decimal(10, 2)), CAST(50000.00 AS Decimal(10, 2)), N'Quần Short trơn, Quần Short Comp chất tổ ong cao cấp, quần Short đai lưng túi hộp, quần Short Essentials')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'37c9384b-e124-4448-aca9-ea4b0c33d7ee', N'1c3ed8de-da68-4d11-8fae-c0469d89ede1', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Thắt lưng nam', N'https://vn-test-11.slatic.net/p/192a419a3b54fe1b4758d4fad0525983.jpg', 10, 3, CAST(79000.00 AS Decimal(10, 2)), CAST(50000.00 AS Decimal(10, 2)), N'Thắt Lưng Unisex Cao Cấp Bản Nhỏ BBelt Mặt Chữ B Màu Đen Đẹp - Dây Lưng Da PU Mặt Kim Loại Hàn Quốc - BBelt

Chất liệu: Da PU cực kỳ bền bỉ.
Kích thước: Dài 100cm x Rộng 2,3cm')
INSERT [dbo].[ProductInfo] ([product_id], [seller_id], [type_id], [product_name], [product_image], [product_available], [product_sales], [product_price], [product_voucher], [product_description]) VALUES (N'cfea7031-d304-40f0-8439-f5665a515a6b', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1818e9a8-52cd-4538-9512-ad9234bd1eea', N'Giày thể thao', N'https://cdn.yeep.vn/2023/03/sg-11134201-22100-duxhdadsa4iv69.jpg', 60, 80, CAST(1837000.00 AS Decimal(10, 2)), NULL, N'Giày thể thao nam, size 42, màu trắng đen.')
GO
INSERT [dbo].[requestSetRole] ([id], [user_id], [email], [fullName], [shopName], [commoditiesSector], [address], [phone], [status]) VALUES (N'06d44f96-fe77-4295-8e5f-8368e8d8ea15', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'a@gmail.com', N'Tráº§n Ngá»c ChÃ­', N'Gau Shop', N'1818E9A8-52CD-4538-9512-AD9234BD1EEA', N'207 FPT, ÄÃ   Náºµng', N'0705355332', N'OK')
INSERT [dbo].[requestSetRole] ([id], [user_id], [email], [fullName], [shopName], [commoditiesSector], [address], [phone], [status]) VALUES (N'2410bc2a-52e4-4d0c-a3ff-8d383cc932ae', N'e19ab04d-0ffa-4272-ac2a-a6323338adb2', N'ni.trnh59@gmail.com', N'Trịnh Ngọc Hàn Ni', N'HanNi shop', N'EECBD3F1-134E-43B0-A3E1-700EDB72A6A4', N'207 Thái Văn Lung, Đà  Nẵng', N'0705355331', N'OK')
INSERT [dbo].[requestSetRole] ([id], [user_id], [email], [fullName], [shopName], [commoditiesSector], [address], [phone], [status]) VALUES (N'b47a3222-ec97-488f-b5b3-da4e36e35702', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'nitnhde160262@fpt.edu.vn', N'Trịnh Ngọc Hàn Ni', N'HanNi Shop', N'1818E9A8-52CD-4538-9512-AD9234BD1EEA', N'207 Thái Văn Lung, Đà  Nẵng', N'0705355331', N'OK')
INSERT [dbo].[requestSetRole] ([id], [user_id], [email], [fullName], [shopName], [commoditiesSector], [address], [phone], [status]) VALUES (N'907b00bb-583f-4614-bc0f-e17af6d21cbc', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', N'asdf@gmail.com', N'Đinh Quang Vinh', N'Vinh Shop', N'32DE7141-E052-4591-A103-2F5F544E01E0', N'Lê Duẩn', N'0705355331', NULL)
INSERT [dbo].[requestSetRole] ([id], [user_id], [email], [fullName], [shopName], [commoditiesSector], [address], [phone], [status]) VALUES (N'57cdc9f7-6cdb-456c-bb89-e3e929264759', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', N'asdf@gmail.com', N'Äinh Quang Vinh', N'Vinh Shop', N'32DE7141-E052-4591-A103-2F5F544E01E0', N'LÃª Duáº©n', N'0705355331', N'NOT OK')
GO
INSERT [dbo].[ShoppingCart] ([id], [user_id], [cart_quantity], [cart_total]) VALUES (N'3b53aeff-251a-43d6-a25b-08ac04bae4e4', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', NULL, NULL)
INSERT [dbo].[ShoppingCart] ([id], [user_id], [cart_quantity], [cart_total]) VALUES (N'79dd5939-31ed-4afb-874b-3b57269cd87a', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', NULL, NULL)
INSERT [dbo].[ShoppingCart] ([id], [user_id], [cart_quantity], [cart_total]) VALUES (N'4e767456-af44-4c6f-b68b-dec4cc1ef6cf', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', NULL, NULL)
GO
INSERT [dbo].[ShoppingCartItem] ([id], [cart_id], [product_id], [item_quantity], [item_subtotal]) VALUES (N'ed45f1fe-2c51-45b5-869c-2c3d504506b8', N'3b53aeff-251a-43d6-a25b-08ac04bae4e4', N'05f5e5f3-b59e-4aeb-9de6-160df06346b7', 25, NULL)
INSERT [dbo].[ShoppingCartItem] ([id], [cart_id], [product_id], [item_quantity], [item_subtotal]) VALUES (N'd67b2b8a-4357-403f-b503-70bf1d4a62c8', N'3b53aeff-251a-43d6-a25b-08ac04bae4e4', N'9714198a-d7bb-41cf-a694-1978358dedc6', 6, NULL)
INSERT [dbo].[ShoppingCartItem] ([id], [cart_id], [product_id], [item_quantity], [item_subtotal]) VALUES (N'546b0ad9-4cfb-4c61-bfce-870e6e905061', N'3b53aeff-251a-43d6-a25b-08ac04bae4e4', N'37c9384b-e124-4448-aca9-ea4b0c33d7ee', 1, NULL)
INSERT [dbo].[ShoppingCartItem] ([id], [cart_id], [product_id], [item_quantity], [item_subtotal]) VALUES (N'546ae9b0-078e-4326-b6d6-89e50ac402db', N'4e767456-af44-4c6f-b68b-dec4cc1ef6cf', N'05f5e5f3-b59e-4aeb-9de6-160df06346b7', 5, NULL)
INSERT [dbo].[ShoppingCartItem] ([id], [cart_id], [product_id], [item_quantity], [item_subtotal]) VALUES (N'4bb12fe0-34d8-434c-b73f-978e35ec2536', N'79dd5939-31ed-4afb-874b-3b57269cd87a', N'05f5e5f3-b59e-4aeb-9de6-160df06346b7', 2, NULL)
INSERT [dbo].[ShoppingCartItem] ([id], [cart_id], [product_id], [item_quantity], [item_subtotal]) VALUES (N'70466d14-2ae7-4b62-a24d-b78e5338f44e', N'4e767456-af44-4c6f-b68b-dec4cc1ef6cf', N'9714198a-d7bb-41cf-a694-1978358dedc6', 4, NULL)
GO
INSERT [dbo].[UserFollow] ([id], [follower_id], [following_id]) VALUES (N'b9160dfa-3c6b-4d4a-aa6a-7ef21a3ed353', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0')
INSERT [dbo].[UserFollow] ([id], [follower_id], [following_id]) VALUES (N'818c00b9-66e3-4fae-8f78-7fd390c07fd2', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', N'fd9a34a3-205b-4051-b14f-421ef9f4a011')
INSERT [dbo].[UserFollow] ([id], [follower_id], [following_id]) VALUES (N'fc4cae83-cb53-4be7-8e05-b8d6feb224bd', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea')
GO
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'f48c6707-bbf5-4e8d-8a7f-0326e9a392cc', N'e19ab04d-0ffa-4272-ac2a-a6323338adb2', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'hj', CAST(N'2023-10-10T08:37:14.610' AS DateTime))
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'18aff69c-4284-462f-ba85-08450cd10dd7', N'59b5896f-98b2-4699-82ec-1b8b99cebcb2', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'rrÃª', CAST(N'2023-10-07T23:46:18.367' AS DateTime))
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'd1e0462e-f95c-4502-b1f1-6276b5c20d0e', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'abc', CAST(N'2023-10-06T08:10:08.007' AS DateTime))
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'88e88244-f316-4439-891f-7a78d529be3a', N'59b5896f-98b2-4699-82ec-1b8b99cebcb2', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'dsad', CAST(N'2023-10-08T00:13:41.767' AS DateTime))
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'a9852868-c972-4978-a282-8177e62b0f54', N'fd9a34a3-205b-4051-b14f-421ef9f4a011', N'1caf9ad4-afea-4ee9-bfc1-e0afc556370f', N'abc', CAST(N'2023-10-09T18:32:51.013' AS DateTime))
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'2478abaa-7967-4ac6-8b4f-d5364d1a8f61', N'59b5896f-98b2-4699-82ec-1b8b99cebcb2', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'fdsf', CAST(N'2023-10-07T23:21:13.657' AS DateTime))
INSERT [dbo].[UserMessage] ([id], [sender_id], [receiver_id], [context], [message_date]) VALUES (N'f23fa536-277b-4a4d-abb8-db1ec08af30d', N'59b5896f-98b2-4699-82ec-1b8b99cebcb2', N'3897a0a3-0822-4464-b3e2-ad272e42e7ea', N'jghjh', CAST(N'2023-10-07T23:51:33.690' AS DateTime))
GO
INSERT [dbo].[UserPost] ([id], [user_id], [post_title], [post_content], [post_image], [post_date]) VALUES (N'aa9d36fd-4bc8-4390-af44-bd326411ca33', N'41eab62f-a954-4aab-b7c4-6f11d301d2d0', NULL, N'', N'SavedImages/funix-hinh-anh-dinh-dang-webp-1-e1668324507669.jpg', CAST(N'2023-10-20' AS Date))
INSERT [dbo].[UserPost] ([id], [user_id], [post_title], [post_content], [post_image], [post_date]) VALUES (N'465b2b71-3bfb-4d2a-9f88-e89f10ee47c1', N'3393c2bb-1630-4184-ad67-9a789cf770de', N'cvzxcvxzcvzxcv', N'xczxzxv', N'C:\Users\Admin\Documents\NetBeansProjects\SocialCommercial\build\web\SavedImages/Screenshot 2023-08-01 182140.png', CAST(N'2023-09-21' AS Date))
GO
INSERT [dbo].[UserRole] ([id], [role]) VALUES (1, N'admin')
INSERT [dbo].[UserRole] ([id], [role]) VALUES (2, N'User ')
INSERT [dbo].[UserRole] ([id], [role]) VALUES (3, N'Seller ')
INSERT [dbo].[UserRole] ([id], [role]) VALUES (4, N'Shipper ')
GO
ALTER TABLE [dbo].[AppUser] ADD  CONSTRAINT [DF__AppUser__id__276EDEB3]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[Feedback] ADD  DEFAULT (getdate()) FOR [date]
GO
ALTER TABLE [dbo].[Order] ADD  CONSTRAINT [DF__CustomerOrde__id__45F365D3]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[OrderDetail] ADD  CONSTRAINT [DF__OrderItemInf__id__46E78A0C]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ProductCategory] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ProductInfo] ADD  CONSTRAINT [DF__ProductInfo__id__5CD6CB2B]  DEFAULT (newid()) FOR [product_id]
GO
ALTER TABLE [dbo].[requestSetRole] ADD  CONSTRAINT [DF__requestSetRo__id__5DCAEF64]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ShopComment] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ShopComment] ADD  DEFAULT (getdate()) FOR [comment_date]
GO
ALTER TABLE [dbo].[ShopLike] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ShoppingCart] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ShoppingCartItem] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[SocialComment] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[SocialComment] ADD  DEFAULT (getdate()) FOR [comment_date]
GO
ALTER TABLE [dbo].[SocialLike] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[UserFollow] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[UserMessage] ADD  CONSTRAINT [DF__UserMessage__id__5441852A]  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[UserMessage] ADD  CONSTRAINT [DF__UserMessa__messa__5535A963]  DEFAULT (getdate()) FOR [message_date]
GO
ALTER TABLE [dbo].[UserNotification] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[UserNotification] ADD  DEFAULT (getdate()) FOR [notification_date]
GO
ALTER TABLE [dbo].[UserPost] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[AppUser]  WITH CHECK ADD  CONSTRAINT [FK_AppUser_UserRole] FOREIGN KEY([role_id])
REFERENCES [dbo].[UserRole] ([id])
GO
ALTER TABLE [dbo].[AppUser] CHECK CONSTRAINT [FK_AppUser_UserRole]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_AppUser] FOREIGN KEY([userId])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_AppUser]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_ProductInfo] FOREIGN KEY([product_id])
REFERENCES [dbo].[ProductInfo] ([product_id])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_ProductInfo]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK__CustomerO__custo__3E52440B] FOREIGN KEY([customer_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK__CustomerO__custo__3E52440B]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Order] FOREIGN KEY([id])
REFERENCES [dbo].[Order] ([id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrderItem__order__5BE2A6F2] FOREIGN KEY([order_id])
REFERENCES [dbo].[Order] ([id])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK__OrderItem__order__5BE2A6F2]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK__OrderItem__produ__6FE99F9F] FOREIGN KEY([product_id])
REFERENCES [dbo].[ProductInfo] ([product_id])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK__OrderItem__produ__6FE99F9F]
GO
ALTER TABLE [dbo].[ProductInfo]  WITH CHECK ADD  CONSTRAINT [FK__ProductIn__selle__2F10007B] FOREIGN KEY([seller_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[ProductInfo] CHECK CONSTRAINT [FK__ProductIn__selle__2F10007B]
GO
ALTER TABLE [dbo].[ProductInfo]  WITH CHECK ADD  CONSTRAINT [FK__ProductIn__type___71D1E811] FOREIGN KEY([type_id])
REFERENCES [dbo].[ProductCategory] ([id])
GO
ALTER TABLE [dbo].[ProductInfo] CHECK CONSTRAINT [FK__ProductIn__type___71D1E811]
GO
ALTER TABLE [dbo].[requestSetRole]  WITH CHECK ADD  CONSTRAINT [FK_requestSetRole_AppUser] FOREIGN KEY([user_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[requestSetRole] CHECK CONSTRAINT [FK_requestSetRole_AppUser]
GO
ALTER TABLE [dbo].[ShopComment]  WITH CHECK ADD  CONSTRAINT [FK__ShopComme__comme__5812160E] FOREIGN KEY([commentor_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[ShopComment] CHECK CONSTRAINT [FK__ShopComme__comme__5812160E]
GO
ALTER TABLE [dbo].[ShopComment]  WITH CHECK ADD  CONSTRAINT [FK__ShopComme__produ__74AE54BC] FOREIGN KEY([product_id])
REFERENCES [dbo].[ProductInfo] ([product_id])
GO
ALTER TABLE [dbo].[ShopComment] CHECK CONSTRAINT [FK__ShopComme__produ__74AE54BC]
GO
ALTER TABLE [dbo].[ShopLike]  WITH CHECK ADD  CONSTRAINT [FK__ShopLike__liker___5CD6CB2B] FOREIGN KEY([liker_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[ShopLike] CHECK CONSTRAINT [FK__ShopLike__liker___5CD6CB2B]
GO
ALTER TABLE [dbo].[ShopLike]  WITH CHECK ADD  CONSTRAINT [FK__ShopLike__produc__76969D2E] FOREIGN KEY([product_id])
REFERENCES [dbo].[ProductInfo] ([product_id])
GO
ALTER TABLE [dbo].[ShopLike] CHECK CONSTRAINT [FK__ShopLike__produc__76969D2E]
GO
ALTER TABLE [dbo].[ShoppingCartItem]  WITH CHECK ADD FOREIGN KEY([cart_id])
REFERENCES [dbo].[ShoppingCart] ([id])
GO
ALTER TABLE [dbo].[ShoppingCartItem]  WITH CHECK ADD FOREIGN KEY([cart_id])
REFERENCES [dbo].[ShoppingCart] ([id])
GO
ALTER TABLE [dbo].[ShoppingCartItem]  WITH CHECK ADD FOREIGN KEY([cart_id])
REFERENCES [dbo].[ShoppingCart] ([id])
GO
ALTER TABLE [dbo].[ShoppingCartItem]  WITH CHECK ADD  CONSTRAINT [FK__ShoppingC__produ__787EE5A0] FOREIGN KEY([product_id])
REFERENCES [dbo].[ProductInfo] ([product_id])
GO
ALTER TABLE [dbo].[ShoppingCartItem] CHECK CONSTRAINT [FK__ShoppingC__produ__787EE5A0]
GO
ALTER TABLE [dbo].[SocialComment]  WITH CHECK ADD  CONSTRAINT [FK__SocialCom__comme__4D94879B] FOREIGN KEY([commentor_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[SocialComment] CHECK CONSTRAINT [FK__SocialCom__comme__4D94879B]
GO
ALTER TABLE [dbo].[SocialComment]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[UserPost] ([id])
GO
ALTER TABLE [dbo].[SocialComment]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[UserPost] ([id])
GO
ALTER TABLE [dbo].[SocialComment]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[UserPost] ([id])
GO
ALTER TABLE [dbo].[SocialLike]  WITH CHECK ADD  CONSTRAINT [FK__SocialLik__liker__52593CB8] FOREIGN KEY([liker_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[SocialLike] CHECK CONSTRAINT [FK__SocialLik__liker__52593CB8]
GO
ALTER TABLE [dbo].[SocialLike]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[UserPost] ([id])
GO
ALTER TABLE [dbo].[SocialLike]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[UserPost] ([id])
GO
ALTER TABLE [dbo].[SocialLike]  WITH CHECK ADD FOREIGN KEY([post_id])
REFERENCES [dbo].[UserPost] ([id])
GO
ALTER TABLE [dbo].[UserFollow]  WITH CHECK ADD  CONSTRAINT [FK__UserFollo__follo__60A75C0F] FOREIGN KEY([follower_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[UserFollow] CHECK CONSTRAINT [FK__UserFollo__follo__60A75C0F]
GO
ALTER TABLE [dbo].[UserFollow]  WITH CHECK ADD  CONSTRAINT [FK__UserFollo__follo__619B8048] FOREIGN KEY([following_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[UserFollow] CHECK CONSTRAINT [FK__UserFollo__follo__619B8048]
GO
ALTER TABLE [dbo].[UserMessage]  WITH CHECK ADD  CONSTRAINT [FK__UserMessa__recei__6C190EBB] FOREIGN KEY([receiver_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[UserMessage] CHECK CONSTRAINT [FK__UserMessa__recei__6C190EBB]
GO
ALTER TABLE [dbo].[UserMessage]  WITH CHECK ADD  CONSTRAINT [FK__UserMessa__sende__6B24EA82] FOREIGN KEY([sender_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[UserMessage] CHECK CONSTRAINT [FK__UserMessa__sende__6B24EA82]
GO
ALTER TABLE [dbo].[UserNotification]  WITH CHECK ADD  CONSTRAINT [FK__UserNotif__user___66603565] FOREIGN KEY([user_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[UserNotification] CHECK CONSTRAINT [FK__UserNotif__user___66603565]
GO
ALTER TABLE [dbo].[UserPost]  WITH CHECK ADD  CONSTRAINT [FK__UserPost__user_i__47DBAE45] FOREIGN KEY([user_id])
REFERENCES [dbo].[AppUser] ([id])
GO
ALTER TABLE [dbo].[UserPost] CHECK CONSTRAINT [FK__UserPost__user_i__47DBAE45]
GO
USE [master]
GO
ALTER DATABASE [SWP391] SET  READ_WRITE 
GO
