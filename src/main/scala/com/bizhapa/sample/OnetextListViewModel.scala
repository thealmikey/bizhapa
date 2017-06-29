package com.bizhapa.sample

import android.app.Application
import android.arch.lifecycle.{AndroidViewModel, LiveData}
import android.arch.persistence.room.Room
import android.content.Context
import android.os.AsyncTask
import java.util.List

import scala.beans.BeanProperty

/**
  * Created by almikey on 13/06/17.
  */

class OnetextListViewModel(application: Application,var db:AppDatabase) extends AndroidViewModel(application){

  var appDatabase:AppDatabase = db

  @BeanProperty
  val oneTextList:LiveData[Array[OnetextModel]] = appDatabase.theTextModel().getAllTexts()

}
