package com.bizhapa.sample

import android.arch.persistence.room.{Database, Room, RoomDatabase}

/**
  * Created by almikey on 13/06/17.
  */


@Database(entities = Array(classOf[OnetextModel]), version=1)
abstract class AppDatabase extends RoomDatabase{
def theTextModel():OnetextDao
}
