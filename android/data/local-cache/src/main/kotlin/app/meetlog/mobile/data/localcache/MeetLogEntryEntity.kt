package app.meetlog.mobile.data.localcache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meetlog_entries")
data class MeetLogEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val body: String,
    val createdAtEpochMillis: Long
)
