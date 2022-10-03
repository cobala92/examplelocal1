package example.android.exam.examplelocal1.data.dataremote.service

import example.android.exam.examplelocal1.data.dataremote.response.UserResponse
import retrofit2.http.GET

internal interface ApiService {
    companion object Factory {
        // Todo
    }

    @GET("users/2")
    suspend fun getUsers(): UserResponse
}