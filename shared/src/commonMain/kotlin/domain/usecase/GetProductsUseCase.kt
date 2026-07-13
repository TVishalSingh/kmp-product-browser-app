package domain.usecase


import domain.model.Product
import domain.repository.ProductRepository

class GetProductsUseCase(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(): List<Product> {
        return repository.getProducts()
    }
}