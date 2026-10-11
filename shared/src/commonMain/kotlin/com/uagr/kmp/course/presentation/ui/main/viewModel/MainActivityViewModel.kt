package com.uagr.kmp.course.presentation.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uagr.kmp.course.domain.usecase.main.ValidateInitialScreenUseCase
import com.uagr.kmp.course.presentation.ui.login.viewmodel.LoginUiEvent
import com.uagr.kmp.course.presentation.ui.main.viewModel.MainActivityUiEvent
import com.uagr.kmp.course.utils.operators.InitialScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class MainActivityViewModel(
    private val validateInitialScreenUseCase: ValidateInitialScreenUseCase,
) : ViewModel() {
    
    private val _mainActivityUiState = MutableStateFlow(MainActivityUiState())
    val mainActivityUiState: StateFlow<MainActivityUiState> = _mainActivityUiState.asStateFlow()
    
    private var _mainActivityUiEvent = MutableStateFlow<MainActivityUiEvent>(MainActivityUiEvent.Idle)
    val mainActivityUiEvent: StateFlow<MainActivityUiEvent> = _mainActivityUiEvent.asStateFlow()
    
    init{
        getUserInformation()
    }
    
    private fun getUserInformation() = viewModelScope.launch {
        validateInitialScreenUseCase.getUserInformation()
            .catch {
                _mainActivityUiState.update { state -> state.copy(
                    initialScreen = InitialScreen.LOGIN_SCREEN
                ) }
                _mainActivityUiEvent.emit(MainActivityUiEvent.UserNotLogged)
            }
            .collect { user ->
                if(user.email.isNotEmpty()) {
                    _mainActivityUiState.update { state -> state.copy(
                        initialScreen = InitialScreen.HOME_SCREEN
                    ) }
                    _mainActivityUiEvent.emit(MainActivityUiEvent.UserLogged)
                } else {
                    _mainActivityUiState.update { state ->
                        state.copy(
                            initialScreen = InitialScreen.LOGIN_SCREEN
                        )
                    }
                    _mainActivityUiEvent.emit(MainActivityUiEvent.UserNotLogged)
                }
            }
    }
    
    fun resetUiEvent() = viewModelScope.launch  {
        _mainActivityUiEvent.value = MainActivityUiEvent.Idle
    }

}