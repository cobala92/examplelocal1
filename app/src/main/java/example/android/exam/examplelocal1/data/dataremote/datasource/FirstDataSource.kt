package example.android.exam.examplelocal1.data.dataremote.datasource

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.coroutines.runSuspendCatching
import example.android.exam.examplelocal1.core.AppCoroutineDispatchers
import example.android.exam.examplelocal1.data.dataremote.response.UserResponse
import example.android.exam.examplelocal1.data.dataremote.service.ApiService
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface UserRemoteDataSource {
    suspend fun getUser(): Result<UserResponse, Throwable>
}

internal class UserRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService, private val appCoroutineDispatchers: AppCoroutineDispatchers

) : UserRemoteDataSource {
    override suspend fun getUser(): Result<UserResponse, Throwable> = runSuspendCatching {
        withContext(appCoroutineDispatchers.io) {
            apiService.getUsers()
        }
    }

}
