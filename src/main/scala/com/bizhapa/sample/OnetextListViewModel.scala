package com.bizhapa.sample

import android.app.Application
import android.arch.lifecycle.{AndroidViewModel, LiveData}
import android.arch.persistence.room.Room
import android.content.Context
import android.os.AsyncTask
import com.bizhapa.sample.OnetextListViewModel._

import scala.beans.BeanProperty

/**
  * Created by almikey on 13/06/17.
  */
object OnetextListViewModel{
  class addTextAsync(private var db:AppDatabase) extends AsyncTask[OnetextModel,Unit, Unit]{
    override def doInBackground(params: OnetextModel*): Unit = {
      db.theTextModel().addText(params(0))
    }
  }
}
class OnetextListViewModel(application: Application,var db:AppDatabase) extends AndroidViewModel(application){

  var appDatabase:AppDatabase = db

  @BeanProperty
  val oneTextList:LiveData[List[OnetextModel]] = appDatabase.theTextModel().getAllTexts()

  def addOnetext(onetext:OnetextModel):Unit = {
    new addTextAsync(appDatabase).execute(onetext)
  }
}
