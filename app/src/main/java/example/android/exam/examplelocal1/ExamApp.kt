package example.android.exam.examplelocal1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import example.android.exam.examplelocal1.logger.CrashlyticsLoggerTree
import timber.log.Timber

@HiltAndroidApp
class ExamApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }
}

private fun setupTimber() {
    if (BuildConfig.DEBUG) {
        Timber.plant(
            Timber.DebugTree(),
        )
    } else {
        Timber.plant(
            CrashlyticsLoggerTree()
        )
    }
    Timber.d("Initialized Timber")
}