package data.remote

import data.dto.ProductsResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ProductApiImpl(
    private val client: HttpClient
) : ProductApi {

    private val baseUrl = "https://dummyjson.com"

    override suspend fun getProducts(): ProductsResponseDto {
        return client
            .get("$baseUrl/products")
            .body()
    }

    override suspend fun searchProducts(query: String): ProductsResponseDto {
        return client
            .get("$baseUrl/products/search") {
                parameter("q", query)
            }
            .body()
    }
}