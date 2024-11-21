    package com.omidtest.product

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.domain.product.result.ProductList
    import com.domain.product.usecase.GetProductListUseCase
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.StateFlow
    import kotlinx.coroutines.launch
    import java.lang.Exception
    import javax.inject.Inject

    sealed class UiState<out T> {
        object Loading : UiState<Nothing>()
        data class Success<T>(val data: T) : UiState<T>()
        data class Error(val message: String) : UiState<Nothing>()
    }

    @HiltViewModel
    class ProductListViewModel @Inject constructor(
        private val getListUseCase: GetProductListUseCase
    ) : ViewModel() {
        private val _uiState  = MutableStateFlow<UiState<List<ProductList>>>(UiState.Loading)
        val uiState : StateFlow<UiState<List<ProductList>>> get() = _uiState

        fun loadList() {
            viewModelScope.launch {
                _uiState.value = UiState.Loading
                try {
                    val result: List<ProductList> = getListUseCase()
                    _uiState.value = UiState.Success(result)
                } catch (e: Exception){
                    _uiState.value = UiState.Error(e.message ?: "Unknown error")
                }
            }
        }
    }