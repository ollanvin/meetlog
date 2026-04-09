package app.meetlog.mobile.data.localcache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MeetLogDao {
    @Query("SELECT * FROM meetlog_entries ORDER BY createdAtEpochMillis DESC")
    fun observeAll(): Flow<List<MeetLogEntryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: MeetLogEntryEntity): Long
}
