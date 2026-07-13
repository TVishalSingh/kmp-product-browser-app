package domain.repository

import data.dto.toDomain
import data.remote.ProductApi
import domain.model.Product


class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return api.getProducts()
            .products
            .map { it.toDomain() }
    }

    override suspend fun searchProducts(query: String): List<Product> {
        return api.searchProducts(query)
            .products
            .map { it.toDomain() }
    }
}