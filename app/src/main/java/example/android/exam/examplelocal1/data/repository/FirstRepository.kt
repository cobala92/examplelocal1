package example.android.exam.examplelocal1.data.repository

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import example.android.exam.examplelocal1.core.AppCoroutineDispatchers
import example.android.exam.examplelocal1.core.AppCoroutineScope
import example.android.exam.examplelocal1.data.dataremote.datasource.UserRemoteDataSource
import example.android.exam.examplelocal1.data.dataremote.mapper.toModel
import example.android.exam.examplelocal1.data.model.User
import javax.inject.Inject

interface UserRepository {
    suspend fun get(): Result<User, Throwable>
}

internal class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    appCoroutineScope: AppCoroutineScope,
    appCoroutineDispatchers: AppCoroutineDispatchers
) : UserRepository {
    override suspend fun get(): Result<User, Throwable> =
        userRemoteDataSource.getUser().map {
            it.toModel()
        }
}