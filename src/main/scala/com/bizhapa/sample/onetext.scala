package com.bizhapa.sample

import android.arch.persistence.room.{Entity, PrimaryKey}

import scala.beans.BeanProperty

/**
  * Created by almikey on 13/06/17.
  */
@Entity
class OnetextModel {
@PrimaryKey
  @BeanProperty var theText:String = _
}
