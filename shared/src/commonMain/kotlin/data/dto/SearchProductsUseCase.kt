package data.dto

import domain.model.Product
import domain.repository.ProductRepository

class SearchProductsUseCase(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(query: String): List<Product> {
        return repository.searchProducts(query)
    }
}