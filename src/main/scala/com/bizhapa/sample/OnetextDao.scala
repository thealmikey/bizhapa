package com.bizhapa.sample

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.{Dao, Insert, Query}
import java.util.List

/**
  * Created by almikey on 13/06/17.
  */
@Dao
trait OnetextDao {
@Query("select * from OnetextModel")
  def getAllTexts():LiveData[Array[OnetextModel]]

  @Insert
  def addText(onetext:OnetextModel)

}
