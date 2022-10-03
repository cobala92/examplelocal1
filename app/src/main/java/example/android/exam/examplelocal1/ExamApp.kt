package example.android.exam.examplelocal1

import android.app.Application
import example.android.exam.examplelocal1.logger.CrashlyticsLoggerTree
import timber.log.Timber

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