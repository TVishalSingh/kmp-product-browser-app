package presentation.productlist

import androidx.compose.runtime.*
import di.ViewModelFactory
import domain.model.Product
import presentation.productlist.navigation.Screen
import presentation.productlist.productdetail.ProductDetailScreen


@Composable
fun App() {

    val viewModel = remember {
        ViewModelFactory.productListViewModel()
    }

    val uiState by viewModel.uiState.collectAsState()

    var currentScreen by remember {
        mutableStateOf<Screen>(Screen.ProductList)
    }

    when (val screen = currentScreen) {

        Screen.ProductList -> {

            ProductListScreen(
                uiState = uiState,
                onProductClick = {
                    currentScreen = Screen.ProductDetail(it)
                },
                onSearch = { query ->
                    viewModel.search(query)
                }
            )
        }

        is Screen.ProductDetail -> {

            ProductDetailScreen(
                product = screen.product,
                onBack = {
                    currentScreen = Screen.ProductList
                }
            )
        }
    }
}