USE [datawarehouse]
GO
/****** Objeto:  Table [dbo].[DimProducto]    Fecha de la secuencia de comandos: 12/06/2008 02:01:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DimProducto](
	[ProductID] [int] NOT NULL,
	[Name] [nvarchar](50) COLLATE Latin1_General_BIN2 NULL,
	[ListPrice] [money] NULL,
	[StandarCost] [money] NULL,
	[Rating] [int] NULL,
	[Category] [nvarchar](50) COLLATE Latin1_General_BIN2 NULL,
	[ReviewDate] [nchar](10) COLLATE Latin1_General_BIN2 NULL,
	[SubCategory] [nvarchar](50) COLLATE Latin1_General_BIN2 NULL,
 CONSTRAINT [PK_DimProducto_1] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
