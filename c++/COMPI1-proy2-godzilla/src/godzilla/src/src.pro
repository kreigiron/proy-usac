# File generated by kdevelop's qmake manager. 
# ------------------------------------------- 
# Subdir relative project main directory: ./src
# Target is an application:  ../bin/godzilla

YACCSOURCES += embed.y 
LEXSOURCES += embed.l 
HEADERS += godzilla.h \
           ast.h \
           colaerr.h \
           constantes.h \
           symtab.h \
           parserheader.h \
           browser.h 
SOURCES += godzilla.cpp \
           main.cpp \
           ast.c \
           colaerr.c \
           symtab.c \
           browser.cpp 
TARGET = ../bin/godzilla
CONFIG += debug \
warn_on \
qt \
thread
TEMPLATE = app
