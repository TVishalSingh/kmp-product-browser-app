package data.remote

import data.dto.ProductsResponseDto

interface ProductApi {

    suspend fun getProducts(): ProductsResponseDto

    suspend fun searchProducts(query: String): ProductsResponseDto
}