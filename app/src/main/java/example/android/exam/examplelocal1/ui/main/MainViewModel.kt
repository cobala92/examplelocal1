package example.android.exam.examplelocal1.ui.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.fold
import dagger.hilt.android.lifecycle.HiltViewModel
import example.android.exam.examplelocal1.R
import example.android.exam.examplelocal1.data.model.TabMainItem
import example.android.exam.examplelocal1.data.repository.UserRepository
import example.android.exam.examplelocal1.ui.history.HistoryFragment
import example.android.exam.examplelocal1.ui.home.HomeFragment
import example.android.exam.examplelocal1.ui.setting.SettingFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val application: Application,
) : ViewModel() {
    private val _uiState = MutableStateFlow(UserUiState(null, false, null))
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()
    private val mainTabs = arrayListOf<TabMainItem>()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            userRepository.get().fold({ user ->
                _uiState.update {
                    it.copy(
                        userUi = UserUiState.UserUi(user.email, user.id), loading = false
                    )
                }
            }, { throwable ->
                _uiState.update { it.copy(loading = false, error = throwable) }
            })
        }
        initTabItems()
    }

    data class UserUiState(
        val userUi: UserUi?,
        val loading: Boolean,
        val error: Throwable?,
    ) {
        data class UserUi(val email: String, val id: Int)
    }

    private fun initTabItems() {
        mainTabs.add(
            TabMainItem(
                HomeFragment.newInstance(),
                R.drawable.selector_tab_item_home,
                application.getString(R.string.tabLayoutMainFirstTitle)
            )
        )
        mainTabs.add(
            TabMainItem(
                HistoryFragment.newInstance(),
                R.drawable.selector_tab_item_practice,
                application.getString(R.string.tabLayoutMainSecondTitle)
            )
        )
        mainTabs.add(
            TabMainItem(
                SettingFragment.newInstance(),
                R.drawable.selector_tab_item_setting,
                application.getString(R.string.tabLayoutMainSecondTitle)
            )
        )
    }

    fun getTabMainItems(): List<TabMainItem> = mainTabs
}
