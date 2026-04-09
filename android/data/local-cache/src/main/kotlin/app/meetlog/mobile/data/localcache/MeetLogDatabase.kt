package app.meetlog.mobile.data.localcache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MeetLogEntryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MeetLogDatabase : RoomDatabase() {
    abstract fun meetLogDao(): MeetLogDao
}
