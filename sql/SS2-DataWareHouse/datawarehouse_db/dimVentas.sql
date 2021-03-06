USE [datawarehouse]
GO
/****** Objeto:  Table [dbo].[DimVenta]    Fecha de la secuencia de comandos: 12/06/2008 02:02:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DimVenta](
	[SalesOrderDetailID] [int] NOT NULL,
	[SalesOrderID] [int] NULL,
	[OrderDate] [datetime] NULL,
	[DueDate] [datetime] NULL,
	[ShipDate] [datetime] NULL,
	[ProductID] [int] NULL,
	[OrderQty] [int] NULL,
	[UnitPrice] [money] NULL,
 CONSTRAINT [PK_DimVenta_1] PRIMARY KEY CLUSTERED 
(
	[SalesOrderDetailID] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
