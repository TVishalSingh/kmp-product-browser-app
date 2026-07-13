package domain.repository

import domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun searchProducts(query: String): List<Product>
}