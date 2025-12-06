package com.example.prosync.app

import android.app.Application
import androidx.room.Room
import com.example.prosync.Domain.usecase.addnote
import com.example.prosync.Domain.usecase.getnoteusecase
import com.example.prosync.data.Local.NoteDao
import com.example.prosync.data.Local.ProsyncDB
import com.example.prosync.data.Repository.NotesRepository
import com.example.prosync.data.Repository.NotesrepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModeule{
    @Provides
    @Singleton
    fun ProvideNoterepo(notesdao: NoteDao): NotesRepository = NotesrepoImpl(notesdao)

}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides @Singleton
    fun provideDatabase(app: Application): ProsyncDB =
        Room.databaseBuilder(app, ProsyncDB::class.java, "prosync_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides fun provideNoteDao(db: ProsyncDB) = db.noteDao()
}


@Module
@InstallIn(SingletonComponent::class)
object usecasemodule{
    @Provides
    @Singleton
    fun provideaddnote(repo: NotesRepository): addnote= addnote(repo)

    @Provides
    @Singleton
    fun providegetnotes(repo: NotesRepository): getnoteusecase=getnoteusecase(repo)
}
