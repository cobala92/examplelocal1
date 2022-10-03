package example.android.exam.examplelocal1.core

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface CoreModule {

    @Binds
    @Singleton
    fun appCoroutineDispatchers(impl: DefaultAppCoroutineDispatchers): AppCoroutineDispatchers

    @Binds
    @Singleton
    fun appCoroutineScope(impl: DefaultAppCoroutineScope): AppCoroutineScope
}
