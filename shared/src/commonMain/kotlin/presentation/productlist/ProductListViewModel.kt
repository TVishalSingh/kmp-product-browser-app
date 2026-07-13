package presentation.productlist

import domain.usecase.GetProductsUseCase
import domain.usecase.SearchProductsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val searchProductsUseCase: SearchProductsUseCase
) {

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    private val _uiState = MutableStateFlow(ProductListUiState())

    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()

    init {
        println("ViewModel Created")
        loadProducts()
    }

    fun loadProducts() {

        scope.launch {

            _uiState.value = ProductListUiState(isLoading = true)

            try {

                val products = getProductsUseCase()

                _uiState.value = ProductListUiState(
                    products = products
                )

            } catch (e: Exception) {

                _uiState.value = ProductListUiState(
                    error = e.message ?: "Unknown Error"
                )

            }

        }
    }
    fun search(query: String) {
        println("Searching: $query")

        scope.launch {

            try {

                val products = if (query.isBlank()) {
                    getProductsUseCase()
                } else {
                    searchProductsUseCase(query)
                }

                _uiState.value = ProductListUiState(
                    products = products
                )

            } catch (e: Exception) {

                _uiState.value = ProductListUiState(
                    error = e.message ?: "Unknown Error"
                )

            }
        }
    }
}