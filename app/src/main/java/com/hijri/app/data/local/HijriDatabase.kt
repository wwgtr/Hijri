package com.hijri.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hijri.app.data.local.converter.DateTimeConverter
import com.hijri.app.data.local.dao.PrayerTimeDao
import com.hijri.app.data.local.entity.PrayerTimeEntity

@Database(
    entities = [PrayerTimeEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateTimeConverter::class)
abstract class HijriDatabase : RoomDatabase() {
    abstract fun prayerTimeDao(): PrayerTimeDao

    companion object {
        @Volatile
        private var INSTANCE: HijriDatabase? = null

        fun getInstance(context: Context): HijriDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    HijriDatabase::class.java,
                    "hijri_database"
                ).build().also { INSTANCE = it }
            }
    }
}
