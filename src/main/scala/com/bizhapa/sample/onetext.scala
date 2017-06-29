package com.bizhapa.sample

import android.arch.persistence.room.{ PrimaryKey}
import com.lucidchart.room.entity.RoomEntity

import scala.beans.BeanProperty

/**
  * Created by almikey on 13/06/17.
  */
@RoomEntity
case class OnetextModel (@PrimaryKey theText:String)
