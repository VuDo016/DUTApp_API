package io.zoemeow.dutapp.repository

import io.zoemeow.dutapp.data.NewsGlobalCacheDatabaseDao
import io.zoemeow.dutapp.data.NewsSubjectCacheDatabaseDao
import io.zoemeow.dutapp.model.NewsGlobalItem
import io.zoemeow.dutapp.model.NewsSubjectItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsCacheRepository @Inject constructor(
    private val newsGlobalDbDao: NewsGlobalCacheDatabaseDao,
    private val newsSubjectDbDao: NewsSubjectCacheDatabaseDao
) {
    fun getAllNewsGlobal(): Flow<List<NewsGlobalItem>> = newsGlobalDbDao.getAllNews()
    suspend fun getNewsGlobalById(id: String): NewsGlobalItem = newsGlobalDbDao.getNewsById(id)
    suspend fun insertNewsGlobal(news: NewsGlobalItem) = newsGlobalDbDao.insertNews(news)
    suspend fun updateNewsGlobal(news: NewsGlobalItem) = newsGlobalDbDao.updateNews(news)
    suspend fun deleteNewsGlobal(news: NewsGlobalItem) = newsGlobalDbDao.deleteNews(news)
    suspend fun deleteAllNewsGlobal() = newsGlobalDbDao.deleteAllNews()

    fun getAllNewsSubject(): Flow<List<NewsSubjectItem>> = newsSubjectDbDao.getAllNews()
    suspend fun getNewsSubjectById(id: String): NewsSubjectItem = newsSubjectDbDao.getNewsById(id)
    suspend fun insertNewsSubject(news: NewsSubjectItem) = newsSubjectDbDao.insertNews(news)
    suspend fun updateNewsSubject(news: NewsSubjectItem) = newsSubjectDbDao.updateNews(news)
    suspend fun deleteNewsSubject(news: NewsSubjectItem) = newsSubjectDbDao.deleteNews(news)
    suspend fun deleteAllNewsSubject() = newsSubjectDbDao.deleteAllNews()
}