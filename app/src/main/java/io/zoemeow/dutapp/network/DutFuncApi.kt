package io.zoemeow.dutapp.network

import io.zoemeow.dutapp.model.LoginStatus
import io.zoemeow.dutapp.model.NewsListItem
import io.zoemeow.dutapp.model.SubjectFeeListItem
import io.zoemeow.dutapp.model.SubjectScheduleListItem
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DutFuncApi {
    // https://stackoverflow.com/questions/58298010/how-to-send-parameters-for-get-request-using-retrofit-and-kotlin-coroutines
    @GET("/news")
    suspend fun getNews(
        @Query(value = "type") newsType: String,
        @Query(value = "page") page: Int = 1
    ): NewsListItem

    @POST("/account?type=login")
    suspend fun dutLogin(
        @Query(value = "user") user: String,
        @Query(value = "pass") pass: String
    ): LoginStatus

    @POST("/account?type=logout")
    suspend fun dutLogout(
        @Query(value = "sid") sid: String,
    ): LoginStatus

    @POST("/account?type=subjectschedule")
    suspend fun dutGetSubjectSchedule(
        @Query(value = "sid") sid: String,
        @Query(value = "year") year: Int,
        @Query(value = "semester") semester: Int,
        @Query(value = "insummer") insummer: Int
    ): SubjectScheduleListItem

    @POST("/account?type=subjectfee")
    suspend fun dutGetSubjectFee(
        @Query(value = "sid") sid: String,
        @Query(value = "year") year: Int,
        @Query(value = "semester") semester: Int,
        @Query(value = "insummer") insummer: Int
    ): SubjectFeeListItem
}