USE [datawarehouse]
GO
/****** Objeto:  Table [dbo].[FactVentas]    Fecha de la secuencia de comandos: 12/06/2008 02:02:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FactVentas](
	[IdVenta] [int] NOT NULL,
	[IdCliente] [int] NOT NULL,
	[IdMes] [int] NOT NULL,
	[IdProducto] [int] NOT NULL,
	[IdTerritorio] [int] NOT NULL,
	[subTotal] [money] NULL,
	[ContribucionMarginal] [money] NULL,
	[Tax] [money] NULL,
	[Flete] [money] NULL,
	[TotalDue] [money] NULL,
 CONSTRAINT [PK_FactVentas] PRIMARY KEY CLUSTERED 
(
	[IdVenta] ASC,
	[IdCliente] ASC,
	[IdMes] ASC,
	[IdProducto] ASC,
	[IdTerritorio] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
