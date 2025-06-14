USE [master]
GO
/****** Object:  Database [Lisa]    Script Date: 6/4/2025 2:14:42 PM ******/
CREATE DATABASE [Lisa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Lisa', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER03\MSSQL\DATA\Lisa.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Lisa_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER03\MSSQL\DATA\Lisa_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Lisa] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Lisa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Lisa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Lisa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Lisa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Lisa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Lisa] SET ARITHABORT OFF 
GO
ALTER DATABASE [Lisa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Lisa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Lisa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Lisa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Lisa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Lisa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Lisa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Lisa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Lisa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Lisa] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Lisa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Lisa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Lisa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Lisa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Lisa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Lisa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Lisa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Lisa] SET RECOVERY FULL 
GO
ALTER DATABASE [Lisa] SET  MULTI_USER 
GO
ALTER DATABASE [Lisa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Lisa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Lisa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Lisa] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Lisa] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Lisa] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Lisa', N'ON'
GO
ALTER DATABASE [Lisa] SET QUERY_STORE = ON
GO
ALTER DATABASE [Lisa] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Lisa]
GO
/****** Object:  Table [dbo].[Categorys]    Script Date: 6/4/2025 2:14:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categorys](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 6/4/2025 2:14:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[product_variant_id] [int] NOT NULL,
	[quantity] [int] NULL,
	[price] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 6/4/2025 2:14:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[order_date] [datetime] NULL,
	[total] [decimal](10, 2) NULL,
	[address] [nvarchar](255) NULL,
	[phone] [varchar](20) NULL,
	[status] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 6/4/2025 2:14:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[description] [nvarchar](255) NULL,
	[price] [decimal](10, 2) NULL,
	[image] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductVariants]    Script Date: 6/4/2025 2:14:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductVariants](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[product_id] [int] NOT NULL,
	[category_id] [int] NOT NULL,
	[stock] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/4/2025 2:14:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[fullname] [nvarchar](100) NULL,
	[email] [varchar](100) NULL,
	[role] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT (N'N''Chờ xử lý') FOR [status]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[Orders] ([id])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([product_variant_id])
REFERENCES [dbo].[ProductVariants] ([id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[ProductVariants]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[Categorys] ([id])
GO
ALTER TABLE [dbo].[ProductVariants]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[Products] ([id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD CHECK  (([status]=N'Đã hủy' OR [status]=N'Đã giao' OR [status]=N'Đang giao hàng' OR [status]=N'Chờ xử lý'))
GO
USE [master]
GO
ALTER DATABASE [Lisa] SET  READ_WRITE 
GO
