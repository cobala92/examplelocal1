package example.android.exam.examplelocal1.data.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import example.android.exam.examplelocal1.data.repository.UserRepository
import example.android.exam.examplelocal1.data.repository.UserRepositoryImpl

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun userRepository(impl: UserRepositoryImpl): UserRepository
}
