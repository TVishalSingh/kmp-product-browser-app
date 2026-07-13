package di

import presentation.productlist.ProductListViewModel

object ViewModelFactory {

    fun productListViewModel(): ProductListViewModel {
        return ProductListViewModel(
            AppContainer.getProductsUseCase,
            AppContainer.searchProductsUseCase
        )
    }
}