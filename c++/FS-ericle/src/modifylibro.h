/**
@file modifylibro.h
@brief Subclase de insertLibro que representa la ventana de modificacion de libro.
@author Erik Giron (C#200313492)
@todo reject()
 * @todo accept()

Copyright (C) 2006 Erik Giron

http://www.itforcegt.org/200313492

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either
version 2 of the License, or (at your option) any later
version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
*/

#ifndef MODIFYLIBRO_H
#define MODIFYLIBRO_H

#include "insertLibro.h"

class modifyLibro : public insertLibro
{
  Q_OBJECT

public:
  modifyLibro(QWidget* parent = 0, const char* name = 0, bool modal = FALSE, WFlags fl = 0 );
  ~modifyLibro();
  /*$PUBLIC_FUNCTIONS$*/

public slots:
  /*$PUBLIC_SLOTS$*/

protected:
  /*$PROTECTED_FUNCTIONS$*/

protected slots:
  /*$PROTECTED_SLOTS$*/
  virtual void          reject();
  virtual void          accept();

};

#endif

