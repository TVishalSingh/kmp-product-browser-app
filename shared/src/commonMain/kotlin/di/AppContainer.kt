package di

import data.remote.ProductApi
import data.remote.ProductApiImpl
import data.remote.createHttpClient

import domain.repository.ProductRepositoryImpl
import domain.usecase.GetProductsUseCase
import domain.usecase.SearchProductsUseCase

object AppContainer {

    private val httpClient = createHttpClient()

    private val productApi: ProductApiImpl = ProductApiImpl(httpClient)

    private val repository = ProductRepositoryImpl(productApi)

    val getProductsUseCase = GetProductsUseCase(repository)

    val searchProductsUseCase = SearchProductsUseCase(repository)
}