package example.android.exam.examplelocal1.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import example.android.exam.examplelocal1.R
import example.android.exam.examplelocal1.ui.extension.collectIn
import example.android.exam.examplelocal1.ui.extension.collectInViewLifecycle
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.uiState.collectIn(this) { uiState ->
            Timber.tag("XXX").d("User Id = ${uiState.userUi?.id}")
        }
    }
}