package app.meetlog.mobile.data.localcache.di

import android.content.Context
import androidx.room.Room
import app.meetlog.mobile.data.localcache.MeetLogDao
import app.meetlog.mobile.data.localcache.MeetLogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MeetLogDatabase {
        return Room.databaseBuilder(
            context,
            MeetLogDatabase::class.java,
            "meetlog.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMeetLogDao(db: MeetLogDatabase): MeetLogDao = db.meetLogDao()
}
