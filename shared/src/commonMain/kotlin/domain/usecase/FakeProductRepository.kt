package domain.usecase

import domain.model.Product
import domain.repository.ProductRepository

class FakeProductRepository : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                title = "Laptop",
                description = "Test laptop",
                brand = "Dell",
                price = 1000.0,
                rating = 4.5,
                thumbnail = ""
            ),
            Product(
                id = 2,
                title = "Phone",
                description = "Test phone",
                brand = "Samsung",
                price = 500.0,
                rating = 4.2,
                thumbnail = ""
            )
        )
    }

    override suspend fun searchProducts(query: String): List<Product> {
        return emptyList()
    }
}