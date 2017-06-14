package com.bizhapa.sample

import android.arch.persistence.room.{Database, Room, RoomDatabase}
import android.content.Context

/**
  * Created by almikey on 13/06/17.
  */
object AppDatabase{
  var INSTANCE:AppDatabase= _

  def getDatabase(context:Context)={
    if (INSTANCE==null){
    INSTANCE = Room.databaseBuilder(
      context, classOf[AppDatabase],"onetext_db").build()
  }
    INSTANCE
  }

}
@Database(entities = Array(classOf[OnetextModel]), version=1)
abstract class AppDatabase extends RoomDatabase{
def theTextModel():OnetextDao
}
