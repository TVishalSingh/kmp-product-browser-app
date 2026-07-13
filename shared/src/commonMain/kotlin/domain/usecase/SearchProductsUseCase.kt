package domain.usecase


import domain.repository.ProductRepository


class SearchProductsUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(query: String) =
        repository.searchProducts(query)
}