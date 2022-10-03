package example.android.exam.examplelocal1.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

interface AppCoroutineScope : CoroutineScope

internal class DefaultAppCoroutineScope @Inject constructor(
    appCoroutineDispatchers: AppCoroutineDispatchers
) : AppCoroutineScope {

    override val coroutineContext: CoroutineContext = appCoroutineDispatchers.io + SupervisorJob()

    override fun toString(): String = "DefaultAppCoroutineScope(coroutineContext=$coroutineContext)"
}
