package example.android.exam.examplelocal1.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.michaelbull.result.fold
import dagger.hilt.android.lifecycle.HiltViewModel
import example.android.exam.examplelocal1.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(UserUiState(null, false, null))
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

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
    }

    data class UserUiState(
        val userUi: UserUi?,
        val loading: Boolean,
        val error: Throwable?,
    ) {
        data class UserUi(val email: String, val id: Int)
    }
}
