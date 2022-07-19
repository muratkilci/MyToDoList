package com.example.mytodolist.di

import android.app.Application
import androidx.room.Room
import com.example.mytodolist.data.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
        callback: TaskDatabase.Callback
    ) = Room.databaseBuilder(app, TaskDatabase::class.java, "task-database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope


/*
-Module ->veritabanı ve görev dao sağlamak için kullanılır.
-Provides ->@Module ile açıklamalı sınıfa bağımlılık sağlamak için kullanılır.
-InstallIn -> Hilt'in kullanılacağı bileşenin hangi bileşenin içine ekleneceğini belirtir.
-Singleton ->bileşenin tek bir nesne olacağını belirtir.


&&&& Kendi annotation'larımızı oluşturma &&&
-Qualifier ->bileşenin hangi türde olacağını belirtir.
-Retention ->ek açıklamanın saklama ilkesini belirtmek için kullanılır.

 */